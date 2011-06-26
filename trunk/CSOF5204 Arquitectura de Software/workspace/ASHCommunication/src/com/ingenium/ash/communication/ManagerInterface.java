package com.ingenium.ash.communication;

/**
 *
 * @author Usuario
 */
public interface ManagerInterface {
    
    void processEvent(byte[] event, long time);
    
}
