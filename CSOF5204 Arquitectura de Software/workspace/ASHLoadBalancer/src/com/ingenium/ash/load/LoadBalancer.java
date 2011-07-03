package com.ingenium.ash.load;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Erik
 */
public class LoadBalancer {

    // Posiciones descriptivas de cada servidor
    private static int SC_IDENTIFIER = 0;
    private static int SC_SOCKET_SENDER = 1;
    private static int SC_SOCKET_RECIEVER = 2;
    private static int SC_SENDER_STREAM = 3;
    private static int SC_TOTAL_INFO = 4;
    // Informacion para las conexiones de los sistemas de cada hogar
    private int homeSystemPort = 4440;
    private ServerSocket homeSystemSocket;
    // Informacion para las conexiones de los sistemas centrales
    private int centralSystemPort = 4450;
    private int centralSystemCounter;
    private ServerSocket centralSystemSocket;
    // Token para determinar el siguiente servidor a quien se le va a asignar la conexion
    private int centralSystemTokenPosition;
    // Cache de mensajes
    private static final String SEPARATOR = "*";
    private Map<String, byte[]> messageCache;
    // Lista de servidores
    private static List<Object[]> serverList;
    // Referencia al unico Balanceador de carga
    private static LoadBalancer reference;

    /**
     * Obtiene la unica referencia al balanceador de carga
     * @return 
     */
    public static LoadBalancer getInstance() {
        if (reference == null) {
            reference = new LoadBalancer();
        }
        return reference;
    }

    /**
     * Constructor privado
     */
    private LoadBalancer() {
        messageCache = new HashMap<String, byte[]>();
        serverList = new ArrayList<Object[]>();
        centralSystemTokenPosition = 0;
    }

    /**
     * Retorna el flujo de salida del servidor asignado a procesar la peticion
     * @return 
     */
    private DataOutputStream getNextDOS() {
        centralSystemTokenPosition++;
        if (centralSystemTokenPosition == serverList.size()) {
            centralSystemTokenPosition = 0;
        }

        Object[] description = serverList.get(centralSystemTokenPosition);
        return (DataOutputStream) description[SC_SENDER_STREAM];
    }

    /**
     * Redirecciona los mensajes a un servidor que este libre para procesarlos
     * @param total
     * @param payload
     * @throws IOException 
     */
    public synchronized void redirectMessage(short homeIdentifier, int messageIdentifier, byte[] payload) throws IOException {
        ByteBuffer bb = ByteBuffer.allocate(2 + 4 + 4 + payload.length);
        bb.putShort(homeIdentifier);
        bb.putInt(messageIdentifier);
        bb.putInt(payload.length);
        bb.put(payload);

        //Redireccionar el mensaje
        DataOutputStream dataOutputStream = getNextDOS();
        dataOutputStream.write(bb.array());

        //Almacenar mensaje en cache
        Integer csId = (Integer) serverList.get(centralSystemTokenPosition)[SC_IDENTIFIER];
        messageCache.put(generateIdentifier(homeIdentifier, csId, messageIdentifier), payload);
    }

    private synchronized void removeMessageFromCache(String identifier) {
        messageCache.remove(identifier);
    }

    public static String generateIdentifier(short homeIdentifier, int centralSystemIdentifier, int messageIdentifier) {
        StringBuilder sb = new StringBuilder();
        sb.append(homeIdentifier);
        sb.append(SEPARATOR);
        sb.append(centralSystemIdentifier);
        sb.append(SEPARATOR);
        sb.append(messageIdentifier);
        return sb.toString();
    }

    /**
     * Elimina un servidor de la lista de servidores
     * @param socket 
     */
    public void removeServer(Socket socket) {
        for (Object[] description : serverList) {
            if (socket.equals(description[SC_SOCKET_SENDER]) || socket.equals(description[SC_SOCKET_RECIEVER])) {
                serverList.remove(description);
                break;
            }
        }
    }

    /**
     * Inicia el hilo que acepta las conexiones de las replicaciones de sistemas centrales
     */
    public void startCentralSystemServerConnection() {
        new Thread() {

            @Override
            public void run() {
                try {
                    centralSystemSocket = new ServerSocket(centralSystemPort);
                } catch (IOException ex) {
                    Logger.getLogger(LoadBalancer.class.getName()).log(Level.SEVERE, "No se pudo iniciar el socket central");
                }

                while (true) {
                    try {
                        Socket sender = centralSystemSocket.accept();
                        Socket reciever = centralSystemSocket.accept();
                        startCentralSystemRecieverThread(centralSystemCounter, reciever);
                        addCentralSystemConnection(centralSystemCounter, sender, reciever);
                        centralSystemCounter++;
                    } catch (IOException ex) {
                        Logger.getLogger(LoadBalancer.class.getName()).log(Level.SEVERE, "Error al conectar un CentralSystem");
                    }
                }
            }
        }.start();
    }

    /**
     * Adiciona un servidor al pool de servidores
     * @param serverName
     * @param sender
     * @param reciever
     * @throws IOException 
     */
    private void addCentralSystemConnection(int identifier, Socket sender, Socket reciever) throws IOException {
        Object[] description = new Object[SC_TOTAL_INFO];
        description[SC_IDENTIFIER] = identifier;
        description[SC_SOCKET_SENDER] = sender;
        description[SC_SOCKET_RECIEVER] = reciever;
        description[SC_SENDER_STREAM] = new DataOutputStream(sender.getOutputStream());
        serverList.add(description);
    }

    /**
     * Inicia el hilo que permite procesar las respuestas de los servidores centrales
     * @param reciever 
     */
    private void startCentralSystemRecieverThread(final int centralSystemIdentifier, final Socket reciever) {
        new Thread() {

            @Override
            public void run() {
                DataInputStream dataInputStream = null;
                try {
                    dataInputStream = new DataInputStream(reciever.getInputStream());
                } catch (IOException ex) {
                    Logger.getLogger(LoadBalancer.class.getName()).log(Level.SEVERE, "No se pudo obtener el ouputStream");
                }

                while (true) {
                    try {
                        short homeIdentifier = dataInputStream.readShort();
                        int messageIdentifier = dataInputStream.readInt();

                        removeMessageFromCache(generateIdentifier(homeIdentifier, centralSystemIdentifier, messageIdentifier));
                    } catch (IOException ex) {
                        Logger.getLogger(LoadBalancer.class.getName()).log(Level.SEVERE, "Error al redireccionar el mensaje");
                    }
                }

            }
        }.start();
    }

    /**
     * Inicia el hilo que acepta las conexiones de los sistemas de las casas
     */
    public void startHomeSystemServerConnection() {
        new Thread() {

            @Override
            public void run() {
                try {
                    homeSystemSocket = new ServerSocket(homeSystemPort);
                } catch (IOException ex) {
                    Logger.getLogger(LoadBalancer.class.getName()).log(Level.SEVERE, "No se pudo iniciar el socket de las casas");
                }

                while (true) {
                    try {
                        Socket homeSocket = homeSystemSocket.accept();
                        HomeSystemConnection hsc = new HomeSystemConnection(homeSocket);
                        new Thread(hsc).start();
                    } catch (IOException ex) {
                        Logger.getLogger(LoadBalancer.class.getName()).log(Level.SEVERE, "Error al conectar una casa al balanceador de carga");
                    }
                }
            }
        }.start();
    }
}
