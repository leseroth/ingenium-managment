package com.ingenium.ash.cache;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author davper
 */
public class RuleHouse {

    public int itemCode;
    public byte itemhora;
    public byte itemStatus;

    public RuleHouse() {
        
    }

    public void setInfoRule() {
        itemCode = 1;
        itemhora = 24;
        itemStatus = 3;
    }

    public String getKeyRuleItem() {

        return String.valueOf(itemCode + "-" + itemhora);
    }

    public byte getRuleItem() {

        return itemStatus;
    }
}
