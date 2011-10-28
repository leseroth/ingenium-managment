/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ingenium.ash.cache;

import com.ingenium.ash.valueobjects.ContactInfo;
import java.util.*;

/**
 *
 * @author davper
 */
public class CacheContactInfo {

    private static HashMap<String, ContactInfo> hmContact = new HashMap();

    public CacheContactInfo() {
        
        for (int i = 0; i < 240; i++) {
            hmContact.put(String.valueOf(i), new ContactInfo(1, "David", "Pérez","davidres@gmail.com",2,2011) );
        }
    }

    public static ContactInfo getInfoContact(String code) {
        return hmContact.get(code);
    }
    public static void putInfoContact(ContactInfo contactInfo) {
        hmContact.put(contactInfo.getKeyContactHouse(), contactInfo);
    }
}
