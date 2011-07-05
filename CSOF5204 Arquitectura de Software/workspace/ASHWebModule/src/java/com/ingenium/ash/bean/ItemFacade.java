/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ingenium.ash.bean;

import com.ingenium.ash.entities.Item;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author admin
 */
@Stateless
public class ItemFacade extends AbstractFacade<Item> {
    @PersistenceContext(unitName = "ASHWebModulePU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public ItemFacade() {
        super(Item.class);
    }

}
