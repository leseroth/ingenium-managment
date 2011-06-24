package com.ingenium.ash.communication;

import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author Erik Arcos
 */
public class ConnectorServer implements Runnable {

    private ConnectorProcessor connProcessor;
    private ServerSocket serverSocket;
    private boolean keepAlive;

    /**
     * Constructor
     */
    public ConnectorServer(ConnectorProcessor cp) {
        keepAlive = true;
        connProcessor = cp;
    }

    /**
     * Starts the server in the defined port
     * 
     * @param port Port number for the server
     * @return null if the start was successful, an error message otherwise. 
     */
    public String startServer(int port) {
        String message = null;

        if (serverSocket != null) {
            message = "El servidor ya esta iniciado";
        } else {
            try {
                serverSocket = new ServerSocket(port);
            } catch (IOException e) {
                message = "No se puede escuchar en el puerto: " + port;
                e.printStackTrace();
                System.exit(1);
            }
        }

        if (message == null) {
            new Thread(this).start();
        }

        return message;
    }

    /**
     * Thread to accept the connections of clients
     */
    @Override
    public void run() {
        try {
            while (keepAlive) {

                Socket clientSocket = null;
                try {
                    clientSocket = serverSocket.accept();
                    connProcessor.addConnection(clientSocket);
                } catch (IOException e) {
                    Logger.getLogger(ConnectorServer.class.getName()).log(Level.WARNING, "No fue posible aceptar una conexion");
                    e.printStackTrace();
                }
            }
        } finally {
            try {
                serverSocket.close();
            } catch (IOException ex) {
                Logger.getLogger(ConnectorServer.class.getName()).log(Level.SEVERE, ex.getMessage());
            }
        }
    }

    /**
     * Stops the server
     */
    public void stopServer() {
        keepAlive = false;
    }
}

/*
 * 
    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
    BufferedReader in = new BufferedReader(
            new InputStreamReader(
            clientSocket.getInputStream()));
    String inputLine, outputLine;
    KnockKnockProtocol kkp = new KnockKnockProtocol();
    outputLine  = kkp.processInput(null);

    out.println (outputLine);
    
    while ((inputLine  = in.readLine()

    
        ) != null) {
                outputLine = kkp.processInput(inputLine);
        out.println(outputLine);
        if (outputLine.equals("Bye.")) {
            break;
        }
    }

    out.close ();

    in.close ();
}
 * 
 */