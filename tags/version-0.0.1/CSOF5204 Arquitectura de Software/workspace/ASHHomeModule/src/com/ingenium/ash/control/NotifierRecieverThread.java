package com.ingenium.ash.control;

import com.ingenium.ash.communication.ConnectorClient;
import com.ingenium.ash.notificator.EmailNotification;
import com.ingenium.ash.notificator.SkypeNotification;
import com.skype.Call.Status;
import static com.ingenium.ash.util.Constants.*;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Erik Arcos
 */
public class NotifierRecieverThread implements Runnable {

    private ConnectorClient connClient;
    private HomeModuleMain home;
    private boolean keepAlive;

    public NotifierRecieverThread(HomeModuleMain home, ConnectorClient connClient) {
        this.connClient = connClient;
        this.home = home;
        keepAlive = true;
    }

    @Override
    public void run() {
        while (keepAlive) {
            try {
                byte status = connClient.recieveMessage();

                if (status == HM_STATUS_NOTIFY) {

                    new Thread() {

                        @Override
                        public void run() {
                            try {
                                SkypeNotification.sendChatMessage(home.getOwnerSkype(), "Se ha detectado un evento en su hogar por favor conteste la siguiente videollamada para ver lo que esta sucediendo");
                                Thread.sleep(1000);
                                Status outcome = SkypeNotification.startVideoCall(home.getOwnerSkype());
                                if (outcome != Status.INPROGRESS) {
                                    EmailNotification.notificateClient(home.getOwnerEmail(), home.getOwner());
                                }
                                System.out.println("Se inicio una llamada a las " + new Date() + " y su resultado fue " + outcome);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(NotifierRecieverThread.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (Exception ex) {
                                Logger.getLogger(NotifierRecieverThread.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }.start();

                }
            } catch (IOException ex) {
                keepAlive = false;
            } catch (Exception ex) {
                keepAlive = false;
            }
        }
    }

    public void stopThread() {
        keepAlive = false;
    }
}
