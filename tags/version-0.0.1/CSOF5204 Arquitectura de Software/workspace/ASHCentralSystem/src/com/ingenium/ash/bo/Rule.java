/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ingenium.ash.bo;

/**
 *
 * @author admin
 */
public class Rule {

    private byte RuleStatus;
    private Item item;
    private int Hora;

    /**
     * 
     * @param RuleStatus
     * @param item
     * @param Hora
     */
    public Rule(byte RuleStatus, Item item, int Hora) {
        this.RuleStatus = RuleStatus;
        this.item = item;
        this.Hora = Hora;
    }

    /**
     * @return the RuleStatus
     */
    public byte getRuleStatus() {
        return RuleStatus;
    }

    /**
     * @param RuleStatus the RuleStatus to set
     */
    public void setRuleStatus(byte RuleStatus) {
        this.RuleStatus = RuleStatus;
    }

    /**
     * @return the HoraInicio
     */
    public int getHora() {
        return Hora;
    }

    /**
     * @param HoraInicio the HoraInicio to set
     */
    public void setHora(int Hora) {
        this.Hora = Hora;
    }
    
    /**
     * @return the item
     */
    public Item getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(Item item) {
        this.item = item;
    }

}
