package com.ingenium.ash.communication;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectorClient {
    
    private Socket socket;
    private DataOutputStream dataOutputStream;
    
    public ConnectorClient(String server, int port){
        try {
            socket = new Socket(server,port);
            OutputStream os = socket.getOutputStream();
            dataOutputStream = new DataOutputStream(os);
	} catch (UnknownHostException ex) {
            Logger.getLogger(ConnectorClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConnectorClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void sendMessage(){
        try {
            dataOutputStream.write(new byte[]{5,1,2,3,4,5});
        } catch (IOException ex) {
            Logger.getLogger(ConnectorClient.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    public void killSocket(){
        try {
            dataOutputStream.close();
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(ConnectorClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
