/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ingenium.ash.bo;

/**
 *
 * @author admin
 */
public class Item {

    private int IdItem;
    private int Code;
    private int ItemType;
    private Home home;

    /**
     * @return the IdItem
     */
    public int getIdItem() {
        return IdItem;
    }

    /**
     * @param IdItem the IdItem to set
     */
    public void setIdItem(int IdItem) {
        this.IdItem = IdItem;
    }

    /**
     * @return the Code
     */
    public int getCode() {
        return Code;
    }

    /**
     * @param Code the Code to set
     */
    public void setCode(int Code) {
        this.Code = Code;
    }

    /**
     * @return the ItemType
     */
    public int getItemType() {
        return ItemType;
    }

    /**
     * @param ItemType the ItemType to set
     */
    public void setItemType(int ItemType) {
        this.ItemType = ItemType;
    }

    /**
     * @return the home
     */
    public Home getHome() {
        return home;
    }

    /**
     * @param home the home to set
     */
    public void setHome(Home home) {
        this.home = home;
    }
}
