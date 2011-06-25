package com.ingenium.ash.communication;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Erik Arcos
 */
public class SocketProcessor implements Runnable {

    private Socket socket;
    private boolean keepAlive;
    private DataInputStream dataInputStream;

    public SocketProcessor(Socket s) {
        socket = s;
        keepAlive = true;
    }

    @Override
    public void run() {
        System.out.println("va");
        
        try {
            dataInputStream = new DataInputStream(socket.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(SocketProcessor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        while (keepAlive) {
            try {
                byte size = dataInputStream.readByte(); 
                byte[] byteArray = new byte[size];
                dataInputStream.readFully(byteArray);
                processMessage(byteArray); 
            }  catch (SocketException se) {
                Logger.getLogger(ConnectorProcessor.class.getName()).log(Level.INFO, "Se ha cerrado el socket");
                keepAlive = false;
            }  catch (IOException ex) {
                Logger.getLogger(ConnectorProcessor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        closeSocket();
    }
    
    public void closeSocket(){
        try {
            dataInputStream.close();
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(SocketProcessor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void processMessage(byte[] info){
        // TODO processar la informacion enviada
        for(byte b:info){
            System.out.print(b);
        } System.out.println("");
    }
}
