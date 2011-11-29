/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ingenium.ash.bo;

/**
 *
 * @author admin
 */
public class Event {

    private int IdEvent;
    private int EventType;
    private int EventDate;
    private Home home;
    private Item item;

    /**
     * @return the IdEvent
     */
    public int getIdEvent() {
        return IdEvent;
    }

    /**
     * @param IdEvent the IdEvent to set
     */
    public void setIdEvent(int IdEvent) {
        this.IdEvent = IdEvent;
    }

    /**
     * @return the EventType
     */
    public int getEventType() {
        return EventType;
    }

    /**
     * @param EventType the EventType to set
     */
    public void setEventType(int EventType) {
        this.EventType = EventType;
    }

    /**
     * @return the EventDate
     */
    public int getEventDate() {
        return EventDate;
    }

    /**
     * @param EventDate the EventDate to set
     */
    public void setEventDate(int EventDate) {
        this.EventDate = EventDate;
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
