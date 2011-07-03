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
    private static int SC_SOCKET_SENDER = 0;
    private static int SC_SOCKET_RECIEVER = 1;
    private static int SC_SENDER_STREAM = 2;
    private static int SC_TOTAL_INFO = 3;
    // Informacion para las conexiones de los sistemas de cada hogar
    private int homeSystemPort = 4440;
    private ServerSocket homeSystemSocket;
    // Informacion para las conexiones de los sistemas centrales
    private int centralSystemPort = 4450;
    private ServerSocket centralSystemSocket;
    // Token para determinar el siguiente servidor a quien se le va a asignar la conexion
    private int centralSystemTokenPosition;
    // Identificador unico de los mensajes
    private int messageIdentifier;
    // Cache de mensajes
    private Map<Integer, byte[]> messageCache;
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
        messageCache = new HashMap<Integer, byte[]>();
        serverList = new ArrayList<Object[]>();
        centralSystemTokenPosition = 0;
        messageIdentifier = 0;
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
    public synchronized void redirectMessage(byte[] total, byte[] payload) throws IOException {
        ByteBuffer bb = ByteBuffer.allocate(total.length + payload.length);
        bb.put(total);
        bb.put(payload);
        
        //Almacenar mensaje en cache
        cacheMessage(bb.array());

        //Redireccionar el mensaje
        DataOutputStream dataOutputStream = getNextDOS();
        dataOutputStream.write(bb.array());
    }
    
    /**
     * Almacena en el cache un mensaje
     * @param message 
     */
    private void cacheMessage(byte[] message){
        messageIdentifier++;
        messageCache.put(messageIdentifier, message);        
    }
    
    private synchronized void removeMessageFromCache(int identifier){
        messageCache.remove(identifier);
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
                        startCentralSystemRecieverThread(reciever);
                        addCentralSystemConnection(sender, reciever);
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
    private void addCentralSystemConnection(Socket sender, Socket reciever) throws IOException {
        Object[] description = new Object[SC_TOTAL_INFO];
        description[SC_SOCKET_SENDER] = sender;
        description[SC_SOCKET_RECIEVER] = reciever;
        description[SC_SENDER_STREAM] = new DataOutputStream(sender.getOutputStream());
        serverList.add(description);
    }

    /**
     * Inicia el hilo que permite procesar las respuestas de los servidores centrales
     * @param reciever 
     */
    private void startCentralSystemRecieverThread(final Socket reciever) {
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
                        byte[] messageIdentifier = new byte[4];
                        messageIdentifier[0] = dataInputStream.readByte();
                        messageIdentifier[1] = dataInputStream.readByte();
                        messageIdentifier[2] = dataInputStream.readByte();
                        messageIdentifier[3] = dataInputStream.readByte();
                        int identifier = Util.byteArrayToInt(messageIdentifier);
                        removeMessageFromCache(identifier);
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
