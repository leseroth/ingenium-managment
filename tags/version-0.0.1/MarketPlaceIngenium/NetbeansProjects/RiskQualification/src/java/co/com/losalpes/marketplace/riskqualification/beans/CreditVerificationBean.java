/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.losalpes.marketplace.riskqualification.beans;

import co.com.losalpes.marketplace.riskqualification.entities.Confecamara;
import javax.ejb.Stateless;
import co.com.losalpes.marketplace.riskqualification.entities.DataCredito;
import co.com.losalpes.marketplace.riskqualification.entities.ListasNegras;
import co.com.losalpes.marketplace.riskqualification.enums.TipoLista;
import co.com.losalpes.marketplace.riskqualification.exceptions.DataBaseException;
import co.com.losalpes.marketplace.riskqualification.ws.ExternalServices;
import co.com.losalpes.marketplace.riskqualification.tools.Tools;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.xml.ws.WebServiceException;

/**
 *
 * @author marketplace
 */
@Stateless
public class CreditVerificationBean implements CreditVerificationRemote, CreditVerificationLocal {

        @PersistenceContext
        private EntityManager em;
        private DataCredito dc = null;
        private Confecamara cf = null;
        private ListasNegras ln = null;

      public Boolean registrarDataCredito(String nit) throws Exception {
        
        //Llamado a servicio externo
        String cal = ExternalServices.getRating(nit);
        dc = new DataCredito(nit,Tools.getDateCurrent(),cal);
        try {
            em.persist(dc);
            return true;
        } catch (Exception e) {
            throw new DataBaseException(e.getMessage());
        }
    }

     public Boolean registrarAntiLavados(String nit) throws Exception {
        
         //Llamado a servicio externo
        Boolean reg = !ExternalServices.nitValidate(nit);
        ln = new ListasNegras(nit,Tools.getDateCurrent(),reg,TipoLista.listaAntilavados);
        try {
            em.persist(ln);
            return true;
        } catch (Exception e) {
            throw new DataBaseException(e.getMessage());
        }
    }

       public Boolean registrarListaClinton(String nit) throws Exception {

         //Llamado a servicio externo
           Boolean reg = !ExternalServices.nitValidate(nit);
        ln = new ListasNegras(nit,Tools.getDateCurrent(),reg,TipoLista.listaClinton);
        try {
            em.persist(ln);
            return true;
        } catch (Exception e) {
            throw new DataBaseException(e.getMessage());
        }
    }

        public Boolean registrarComfecamara(String nit) throws Exception {

         //Llamado a servicio externo
            Boolean reg = ExternalServices.nitValidate(nit);
        cf = new Confecamara(nit,Tools.getDateCurrent(),reg);
        try {
            em.persist(cf);
            return true;
        } catch (Exception e) {
            throw new DataBaseException(e.getMessage());
        }
    }

     public String verificarDataCredito(String nit,int reglaVal) {

          String rating = "";
          Boolean registrar;
          Query q = em.createNamedQuery("getInfoDataCredito");
          q.setParameter("pNit", nit.trim());
          try {
           List results = q.getResultList();
            if (!results.isEmpty())
            {
               dc = (DataCredito) results.get(0);
               //Fecha actual
               Calendar fecha = Calendar.getInstance();
               fecha.setTime(dc.getFecha());
               int diff = Tools.safeLongToInt(Tools.getDiffDates(fecha,Calendar.getInstance()));
               if (diff > reglaVal)
               {
                   //Registra entidad
                   registrar = registrarDataCredito(nit.trim());
                   rating = dc.getCalificacion();
               }
               else
                   //Retorna la calificación en DataCredito
                   rating = dc.getCalificacion();
            }
              else
              {
               //Registra entidad
               registrar = registrarDataCredito(nit.trim());
               rating = dc.getCalificacion();
              }
          } catch (Exception e) {
             //throw exception for comunication fail
              throw new WebServiceException(e.getMessage());
          }
          return rating;
    }

        public Boolean verificarComfecamara(String nit, int reglaVal) throws Exception {
        Boolean rating = false;
        Query q = em.createNamedQuery("getInfoConfecamara");
        q.setParameter("pNit", nit.trim());
        try {
            List results = q.getResultList();
            if (!results.isEmpty())
            {
               cf = (Confecamara) results.get(0);                  
               //Obteniendo fecha de registro confecamaras
               Calendar fecha = Calendar.getInstance();
               fecha.setTime(cf.getFecha());
               int diff = Tools.safeLongToInt(Tools.getDiffDates(fecha,Calendar.getInstance()));
               if (diff > reglaVal)
               {
                   //Registra la entidad
                   rating = registrarComfecamara(nit.trim());
                   rating = cf.getEstado();
               }
               else
                   //Devuelve estado fente a confecamaras
                   rating = cf.getEstado();
            }
            else
              {                                  
                //Registra la entidad
                rating =  registrarComfecamara(nit.trim());
                rating = cf.getEstado();
              }
              return rating;

        } catch (Exception e) {
            throw new WebServiceException(e.getMessage());
        }
        }

      public Boolean verificarListaClinton(String nit, int reglaVal) throws Exception {
        Boolean rating = false;
        Query q = em.createNamedQuery("getInfoListasNegras");
        q.setParameter("pNit", nit.trim());
        q.setParameter("pTipo", TipoLista.listaClinton);
        try {
            List results = q.getResultList();
            if (!results.isEmpty())
            {
               ln = (ListasNegras) results.get(0);
               //Obteniendo fecha de registro confecamaras
               Calendar fecha = Calendar.getInstance();
               fecha.setTime(ln.getFecha());
               int diff = Tools.safeLongToInt(Tools.getDiffDates(fecha,Calendar.getInstance()));
               if (diff > reglaVal)
               {
                   //Registra la entidad
                   rating = registrarListaClinton(nit.trim());
                   rating = ln.getEstado();
               }
               else
                   //Devuelve estado fente a confecamaras
                   rating = ln.getEstado();
            }
            else
              {
                //Registra la entidad
                rating =  registrarListaClinton(nit.trim());
                rating = ln.getEstado();
              }
              return rating;

        } catch (Exception e) {
            throw new WebServiceException(e.getMessage());
        }
        }

      public Boolean verificarListaAntiLavado(String nit, int reglaVal) throws Exception {
        Boolean rating = false;
        Query q = em.createNamedQuery("getInfoListasNegras");
        q.setParameter("pNit", nit.trim());
        q.setParameter("pTipo", TipoLista.listaAntilavados);
        try {
            List results = q.getResultList();
            if (!results.isEmpty())
            {
               ln = (ListasNegras) results.get(0);
               //Obteniendo fecha de registro confecamaras
               Calendar fecha = Calendar.getInstance();
               fecha.setTime(ln.getFecha());
               int diff = Tools.safeLongToInt(Tools.getDiffDates(fecha,Calendar.getInstance()));
               if ( diff > reglaVal) {
                   //Registra la entidad
                   rating =  registrarAntiLavados(nit.trim());
                   rating = ln.getEstado();
               }
               else
                   //Devuelve estado fente a confecamaras
                   rating = ln.getEstado();
            }
            else
              {
                //Registra la entidad
                rating = registrarAntiLavados(nit.trim());
                rating = ln.getEstado();
              }
              return rating;

        } catch (Exception e) {
            throw new WebServiceException(e.getMessage());
        }
        }

}
