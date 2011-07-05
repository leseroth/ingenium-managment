/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ingenium.ash.util;

import com.ingenium.ash.entities.Person;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import com.ingenium.ash.facade.PersonController;
import com.ingenium.ash.facade.RolbyuserController;

/**
 *
 * @author admin
 */
public class Login {

    private String name;
    private String password;
    private Person person;
    private String message;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public String Login(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        PersonController controller = (PersonController)facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "personController");
        try {
            setPerson(controller.login(name, password));
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        if(getPerson()==null){            
            message = "Usuario o Contraseña Incorrecto";
            /*Usuario no existe o password incorrecto*/
        }else{            
            /*Ingresar*/
            return "/index";
        }
        return null;
    }

    public String logout(){
        person = null;
        return "/login";
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the person
     */
    public Person getPerson() {
        return person;
    }

    /**
     * @param person the person to set
     */
    public void setPerson(Person person) {
        this.person = person;
    }

    public boolean getAuthorizationAdm(){
                FacesContext facesContext = FacesContext.getCurrentInstance();
        RolbyuserController controller = (RolbyuserController)facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "rolbyuserController");

        return controller.findRolbyPerson(person.getId(), 1);
        
    }
}
