/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ingenium.ash.valueobjects;

/**
 *
 * @author davper
 */
public class ContactInfo {

    public static int itemCode;
    public static String name;
    public static String lastName;
    public static String email;
    public static int eventType;
    public static int eventDate;

    public ContactInfo(int pItemCode, String pName, String pLastName, String pEmail, int pEventType, int pEventDate) {
        itemCode = pItemCode;
        name = pName;
        lastName = pLastName;
        email = pEmail;
        eventType = pEventType;
        eventDate = pEventDate;
    }

    public String getKeyContactHouse() {

        return String.valueOf(itemCode);
    }

    void setItemCode(int pItemCode) {
        itemCode = pItemCode;
    }

    public void setName(String pName) {
        name = pName;
    }

    public void setLastName(String pLastName) {
        lastName = pLastName;
    }

    public void setEmail(String pEmail) {
        email = pEmail;
    }

    public void setEventType(int pEventType) {
        eventType = pEventType;
    }

    public void setEventDate(int pEventDate) {
        eventDate = pEventDate;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public int getEventType() {
        return eventType;
    }

    public int getEventDate() {
        return eventDate;
    }
}