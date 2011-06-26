package com.ingenium.ash.cache;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import com.ingenium.ash.util.Constants;
import java.util.*;

/**
 *
 * @author davper
 */
public class CacheRules {

    private static HashMap<String, Byte> hmRules = new HashMap();

/*    public CacheRules() {
        RuleHouse reglaCasa = new RuleHouse();

        reglaCasa.setInfoRule();

        hmRules.put(reglaCasa.getKeyRuleItem(), reglaCasa.getRuleItem());
        System.out.println(getStatus("1-24"));
    }
 * 
 */

    /**
     *
     * @param code
     * @return
     */
    public static byte getStatus(String code) {
        Object o = hmRules.get(code);
        if (o == null) {
            //System.out.println("null");
            return Constants.DEFAULTSTATUS;
        } else {
            return ((Byte) o).byteValue();
        }
    }

    public static void putRule(RuleHouse rule) {
        hmRules.put(rule.getKeyRuleItem(), rule.getRuleItem());
    }
}
