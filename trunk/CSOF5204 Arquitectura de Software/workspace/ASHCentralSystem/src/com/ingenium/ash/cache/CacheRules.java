package com.ingenium.ash.cache;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.*;

/**
 *
 * @author davper
 */
public class CacheRules {

    private static HashMap<String, Byte> hmRules = new HashMap();

    public CacheRules() {
        RuleHouse reglaCasa = new RuleHouse();

        reglaCasa.setInfoRule();

        hmRules.put(reglaCasa.getKeyRuleItem(), reglaCasa.getRuleItem());

        System.out.println(getStatus("1-24"));
    }

    public static byte getStatus(String code) {
        return ((Byte) hmRules.get(code)).byteValue();
    }
}
