package com.ingenium.ash.notificator;

import com.skype.Call;
import com.skype.Call.Status;
import com.skype.connector.Connector;
import static com.ingenium.ash.util.Constants.*;

public class SkypeNotification {

    public static void startVideoCall(String skypeUser) throws Exception {
        
        String responseHeader = "CALL ";
        String response = Connector.getInstance().executeWithId("CALL " + skypeUser, responseHeader);
        
        String id = response.substring(responseHeader.length(), response.indexOf(" STATUS "));
        Call call = Call.getInstance(id);

        boolean callStablished = false;
        
        wait:
        for (int i = 0; i < MAX_SKYPE_SECONDS_WAIT; i++) {
            Status status = call.getStatus();
            if (status.equals(Status.INPROGRESS)) {
                callStablished = true;
                break wait;
            }
            Thread.sleep(1000);
        }
        
        // Iniciar la llamada de video
        if (callStablished) {
            Connector.getInstance().execute("ALTER CALL " + id + " " + "START_VIDEO_SEND");
        }
    }
}
