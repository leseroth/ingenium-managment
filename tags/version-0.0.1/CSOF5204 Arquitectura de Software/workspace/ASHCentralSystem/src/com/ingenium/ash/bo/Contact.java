/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ingenium.ash.bo;

/**
 *
 * @author admin
 */
public class Contact {

    private int IdContat;
    private String Name;
    private String LastName;
    private String Email;

    /**
     * @return the IdContat
     */
    public int getIdContat() {
        return IdContat;
    }

    /**
     * @param IdContat the IdContat to set
     */
    public void setIdContat(int IdContat) {
        this.IdContat = IdContat;
    }

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return the LastName
     */
    public String getLastName() {
        return LastName;
    }

    /**
     * @param LastName the LastName to set
     */
    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    /**
     * @return the Email
     */
    public String getEmail() {
        return Email;
    }

    /**
     * @param Email the Email to set
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }

}
