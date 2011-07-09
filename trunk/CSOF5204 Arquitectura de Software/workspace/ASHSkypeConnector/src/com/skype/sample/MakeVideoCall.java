/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skype.sample;
import com.skype.Call;
import com.skype.Skype;
/**
 *
 * @author Fenix
 */
public class MakeVideoCall {
    public static void main(String[] args) throws Exception {
        String s;
        boolean ve;
	String vd;
        String account = "erik.fernando.arcos.franco";
        Call videoCall = Skype.call(account);
        vd = Skype.getVideoDevice();
        System.out.println(vd);
	// set video device
	Skype.setVideoDevice(vd);
	s = videoCall.getReceiveVideoStatus().toString();
	System.out.println(s);
    }
    
}
