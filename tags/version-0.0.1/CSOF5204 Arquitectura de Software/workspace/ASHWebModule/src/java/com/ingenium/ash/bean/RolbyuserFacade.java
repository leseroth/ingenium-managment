/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ingenium.ash.bean;

import com.ingenium.ash.entities.Rolbyuser;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author admin
 */
@Stateless
public class RolbyuserFacade extends AbstractFacade<Rolbyuser> {
    @PersistenceContext(unitName = "ASHWebModulePU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public RolbyuserFacade() {
        super(Rolbyuser.class);
    }

     public boolean getRolbyUser(int idPerson, int idRol){
        try{
        Query q = em.createQuery("select object(o) from Rolbyuser as o where o.personId =:person and o.roleId =:rol");
        q.setParameter("person", idPerson);
        q.setParameter("rol", idRol);
        Rolbyuser r = (Rolbyuser) q.getSingleResult();
        return true;
        }catch(Exception e){
            return false;
        }
    }

}
