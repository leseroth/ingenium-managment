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
import static com.ingenium.ash.util.Constants.*;

/**
 *
 * @author Erik
 */
public class LoadBalancer {

    // Informacion para las conexiones de los sistemas de cada hogar
    private ServerSocket homeSystemServerSocket;
    // Informacion para las conexiones de los sistemas centrales
    private int centralSystemCounter;
    private ServerSocket centralSystemServerSocket;
    // Lista de servidores
    private static List<Object[]> centralSystemList;
    // Token para determinar el siguiente servidor a quien se le va a asignar la conexion
    private int centralSystemTokenPosition;
    // Cache de mensajes
    private static final String MEESSAGE_ID_SEPARATOR = "-";
    private Map<String, byte[]> messageCache;
    private Map<String, Long> recievedMessageTime;
    // Tiempo de recepcion del ultimo mensaje de una determinada casa
    private Map<Short, Long> lastTimeHomeReport;
    private static final long DOS_TIME = 500;
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
        centralSystemList = new ArrayList<Object[]>();
        lastTimeHomeReport = new HashMap<Short, Long>();
        recievedMessageTime = new HashMap<String, Long>();
        centralSystemTokenPosition = 0;
    }

    /**
     * Retorna el flujo de salida del servidor asignado a procesar la peticion
     * @return 
     */
    private DataOutputStream getNextDataOutputStream() {
        centralSystemTokenPosition++;
        if (centralSystemTokenPosition == centralSystemList.size()) {
            centralSystemTokenPosition = 0;
        }

        DataOutputStream dos = null;

        try {
            Object[] description = centralSystemList.get(centralSystemTokenPosition);
            dos = (DataOutputStream) description[LB_CS_SENDER_STREAM];
        } catch (Exception e) {
            dos = getNextDataOutputStream();
        }
        return dos;
    }

    public synchronized boolean verifyDenialOfService(short homeIdentifier, long currentTime) {
        boolean dos = false;

        Long lastTimeLong = lastTimeHomeReport.get(homeIdentifier);
        if (lastTimeLong == null) {
            lastTimeHomeReport.put(homeIdentifier, currentTime);
        } else {
            long diff = currentTime - lastTimeLong;
            dos = diff < DOS_TIME;
            if (!dos) {
                lastTimeHomeReport.put(homeIdentifier, currentTime);
            } else {
                System.out.println("Diff " + diff);
            }
        }

        return dos;
    }

    /**
     * Redirecciona los mensajes a un servidor que este libre para procesarlos
     * @param total
     * @param payload
     * @throws IOException 
     */
    public synchronized void redirectMessage(short homeIdentifier, int messageIdentifier, byte[] payload, long recievedTime) throws IOException {
        ByteBuffer bb = ByteBuffer.allocate(SIZE_SHORT + SIZE_INT + SIZE_INT + payload.length);
        bb.putShort(homeIdentifier);
        bb.putInt(messageIdentifier);
        bb.putInt(payload.length);
        bb.put(payload);

        //Redireccionar el mensaje
        DataOutputStream dataOutputStream = getNextDataOutputStream();
        dataOutputStream.write(bb.array());

        //Almacenar mensaje en cache
        Integer csId = (Integer) centralSystemList.get(centralSystemTokenPosition)[LB_CS_IDENTIFIER];
        String messageId = generateIdentifier(homeIdentifier, csId, messageIdentifier);
        messageCache.put(messageId, payload);
        recievedMessageTime.put(messageId, recievedTime);
    }

    private synchronized void removeMessageFromCache(String identifier) {
        byte[] message = messageCache.remove(identifier);
        if (message != null && SHOW_LOAD_BALANCER) {
            System.out.println("Procesado: " + identifier);
        }
        long rt = recievedMessageTime.get(identifier);
        recievedMessageTime.put(identifier, System.currentTimeMillis() - rt);
    }

    public static String generateIdentifier(short homeIdentifier, int centralSystemIdentifier, int messageIdentifier) {
        StringBuilder sb = new StringBuilder();
        sb.append(homeIdentifier);
        sb.append(MEESSAGE_ID_SEPARATOR);
        sb.append(centralSystemIdentifier);
        sb.append(MEESSAGE_ID_SEPARATOR);
        sb.append(messageIdentifier);
        return sb.toString();
    }

    /**
     * Elimina un servidor de la lista de servidores
     * @param socket 
     */
    private synchronized void removeServer(int centralSystemId) throws IOException {
        for (Object[] description : centralSystemList) {
            if (centralSystemId == Integer.parseInt(description[LB_CS_IDENTIFIER].toString())) {
                centralSystemList.remove(description);
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
                    centralSystemServerSocket = new ServerSocket(LB_CENTRAL_SYSTEM_SOCKET_PORT);
                } catch (IOException ex) {
                    Logger.getLogger(LoadBalancer.class.getName()).log(Level.SEVERE, "No se pudo iniciar el socket central");
                }

                System.out.println("El balanceador de carga esta listo para aceptar conexiones de servidores");
                while (true) {
                    try {
                        centralSystemCounter++;
                        Socket sender = centralSystemServerSocket.accept();
                        Socket reciever = centralSystemServerSocket.accept();
                        startCentralSystemRecieverThread(centralSystemCounter, reciever);
                        addCentralSystemConnection(centralSystemCounter, sender, reciever);
                        System.out.println("Se ha agregado un servidor al pool");
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
        Object[] description = new Object[LB_CS_TOTAL_INFO];
        description[LB_CS_IDENTIFIER] = identifier;
        description[LB_CS_SOCKET_SENDER] = sender;
        description[LB_CS_SOCKET_RECIEVER] = reciever;
        description[LB_CS_SENDER_STREAM] = new DataOutputStream(sender.getOutputStream());
        centralSystemList.add(description);
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

                boolean keepAlive = true;
                while (keepAlive) {
                    try {
                        short homeIdentifier = dataInputStream.readShort();
                        int messageIdentifier = dataInputStream.readInt();

                        removeMessageFromCache(generateIdentifier(homeIdentifier, centralSystemIdentifier, messageIdentifier));
                    } catch (IOException ex) {
                        String message = "Se ha perdido la conexion con el Central System: " + centralSystemIdentifier;
                        Logger.getLogger(LoadBalancer.class.getName()).log(Level.SEVERE, message);
                        keepAlive = false;
                    }
                }

                // Volver a enviar los mensajes que un CS caido no contesto
                try {
                    removeServer(centralSystemIdentifier);
                    resendUnprocessedMessages(centralSystemIdentifier);
                } catch (IOException ex) {
                    Logger.getLogger(LoadBalancer.class.getName()).log(Level.SEVERE, "Error al redireccionar los mensajes de un Central System Caido", ex);
                }
            }
        }.start();
    }

    private synchronized void resendUnprocessedMessages(int fallenCentralSystemId) throws IOException {
        for (String messageId : messageCache.keySet()) {
            String[] messageIdInfo = messageId.split(MEESSAGE_ID_SEPARATOR);

            if (messageIdInfo[1].equals("" + fallenCentralSystemId)) {
                redirectMessage(Short.parseShort(messageIdInfo[0]), Integer.parseInt(messageIdInfo[2]), messageCache.get(messageId), System.currentTimeMillis());
            }
        }
    }

    /**
     * Inicia el hilo que acepta las conexiones de los sistemas de las casas
     */
    public void startHomeSystemServerConnection() {
        new Thread() {

            @Override
            public void run() {
                try {
                    homeSystemServerSocket = new ServerSocket(LB_HOME_SYSTEM_SOCKET_PORT);
                } catch (IOException ex) {
                    Logger.getLogger(LoadBalancer.class.getName()).log(Level.SEVERE, "No se pudo iniciar el socket de las casas");
                }

                long firstTime = System.currentTimeMillis();
                System.out.println("El balanceador de carga esta listo para aceptar conexiones de casas");
                boolean keepAlive = true;
                while (keepAlive) {
                    try {
                        Socket homeSocket = homeSystemServerSocket.accept();
                        HomeSystemConnection hsc = new HomeSystemConnection(homeSocket);
                        new Thread(hsc).start();
                    } catch (IOException ex) {
                        Logger.getLogger(LoadBalancer.class.getName()).log(Level.SEVERE, "Error al conectar una casa al balanceador de carga");
                        keepAlive = false;
                    }

                    if (System.currentTimeMillis() - firstTime > 60000) {
                        for (Long time : recievedMessageTime.values()) {
                            System.out.println(time);
                        }
                        recievedMessageTime.clear();
                        firstTime = System.currentTimeMillis();
                    }
                }
            }
        }.start();
    }
}
