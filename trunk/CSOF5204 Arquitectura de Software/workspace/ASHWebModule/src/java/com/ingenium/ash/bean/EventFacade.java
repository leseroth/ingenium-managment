/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ingenium.ash.bean;

import com.ingenium.ash.entities.Event;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author admin
 */
@Stateless
public class EventFacade extends AbstractFacade<Event> {
    @PersistenceContext(unitName = "ASHWebModulePU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public EventFacade() {
        super(Event.class);
    }

}
