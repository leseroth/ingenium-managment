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
    public int itemhora;
    public byte itemStatus;

    public RuleHouse() {
        
    }

    public RuleHouse(int itemCode, int itemhora, byte itemStatus) {
        this.itemCode = itemCode;
        this.itemhora = itemhora;
        this.itemStatus = itemStatus;
    }

    public String getKeyRuleItem() {

        return String.valueOf(itemCode + "-" + itemhora);
    }

    public byte getRuleItem() {

        return itemStatus;
    }
}
