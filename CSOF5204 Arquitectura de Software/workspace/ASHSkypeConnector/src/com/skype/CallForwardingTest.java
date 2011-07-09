/*******************************************************************************
 * Copyright (c) 2006-2007 Koji Hisano <hisano@gmail.com> - UBION Inc. Developer
 * Copyright (c) 2006-2007 UBION Inc. <http://www.ubion.co.jp/>
 * 
 * Copyright (c) 2006-2007 Skype Technologies S.A. <http://www.skype.com/>
 * 
 * Skype4Java is licensed under either the Apache License, Version 2.0 or
 * the Eclipse Public License v1.0.
 * You may use it freely in commercial and non-commercial products.
 * You may obtain a copy of the licenses at
 *
 *   the Apache License - http://www.apache.org/licenses/LICENSE-2.0
 *   the Eclipse Public License - http://www.eclipse.org/legal/epl-v10.html
 *
 * If it is possible to cooperate with the publicity of Skype4Java, please add
 * links to the Skype4Java web site <https://developer.skype.com/wiki/Java_API> 
 * in your web site or documents.
 * 
 * Contributors: Koji Hisano - initial API and implementation
 * Gabriel Takeuchi - Ignored non working tests, fixed some, removed warnings
 ******************************************************************************/
package com.skype;

import org.junit.Ignore;
import org.junit.Test;

import com.skype.Profile.CallForwardingRule;
import com.skype.Profile.Status;

@Ignore
public class CallForwardingTest {
	@Test
    public void testSetCallForwarding() throws Exception {
        Skype.setDaemon(true);
        Skype.setDebug(true);
        Skype.getProfile().setStatus(Status.OFFLINE);
        // CallForwardingRule[] oldCallForwardingRules =
        // Skype.getProfile().getAllCallForwardingRules();
        // boolean oldCallForwarding = Skype.getProfile().isCallForwarding();
        Skype.getProfile().setAllCallForwardingRules(new CallForwardingRule[] { new CallForwardingRule(0, 30, "+819018875000") });
        Skype.getProfile().setCallForwarding(true);
    }
}
