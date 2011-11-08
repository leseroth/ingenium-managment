package co.com.losalpes.marketplace.riskqualification.beans;

import co.com.losalpes.marketplace.riskqualification.entities.Confecamara;
import javax.ejb.Stateless;
import co.com.losalpes.marketplace.riskqualification.entities.DataCredito;
import co.com.losalpes.marketplace.riskqualification.entities.ListasNegras;
import co.com.losalpes.marketplace.riskqualification.enums.TipoLista;
import co.com.losalpes.marketplace.riskqualification.tools.ExternalServices;
import co.com.losalpes.marketplace.riskqualification.tools.Tools;
import co.com.losalpes.marketplace.riskqualification.exceptions.BussinessException;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.xml.ws.WebServiceException;

/**
 * Bean que implementa la logica de verificacion de informacion
 * @author Erik
 */
@Stateless
public class CreditVerificationBean implements CreditVerificationRemote, CreditVerificationLocal {

    @PersistenceContext
    private EntityManager em;
    private DataCredito dc = null;
    private ListasNegras ln = null;

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean verificarComfecamara(String nit, int reglaVal) throws BussinessException {
        Confecamara confecamara = null;

        try {
            Query q = em.createNamedQuery("getInfoConfecamara");
            q.setParameter("pNit", nit.trim());
            List results = q.getResultList();

            if (!results.isEmpty()) {
                confecamara = (Confecamara) results.get(0);

                //Obteniendo fecha de registro confecamaras para validar nuevamente
                if (Tools.getDiffDates(confecamara.getFecha(), new Date()) > reglaVal) {
                    //Registra la entidad nuevamente
                    System.err.println("Registra la entidad nuevamente");
                    confecamara = registrarComfecamara(nit.trim(), true);
                }
            } else {
                //Registra la entidad
                confecamara = registrarComfecamara(nit.trim(), false);
            }
        } catch (Exception e) {
            throw new BussinessException("Excepcion : " + e.getMessage());
        }

        return confecamara.getEstado();
    }

    /**
     * Permite registrar una entidad ante confecamara
     * @param nit Nit de la entidad
     * @param existente Indica si ya existia, si ya existia existe el 50% de posiblidad de que no sea validada,
     * en caso contrario, es valida si su nit no contiene 7, 8 o 9
     * @return
     */
    protected Confecamara registrarComfecamara(String nit, boolean existente) {
        boolean estado = ExternalServices.nitValidate(nit, existente);
        Confecamara confecamara = new Confecamara(estado, new Date(), nit);
        em.persist(confecamara);
        return confecamara;
    }

    public Boolean registrarDataCredito(String nit) {

        //Llamado a servicio externo
        String cal = ExternalServices.getRating(nit);
        dc = new DataCredito(nit, new Date(), cal);
        try {
            em.persist(dc);
            return true;
        } catch (Exception e) {
            //throw new DataBaseException(e.getMessage());
        }
        return true;
    }

    public Boolean registrarAntiLavados(String nit, boolean existente) {

        //Llamado a servicio externo
        Boolean reg = !ExternalServices.nitValidate(nit, existente);
        ln = new ListasNegras(nit, new Date(), reg, TipoLista.listaAntilavados);
        try {
            em.persist(ln);
            return true;
        } catch (Exception e) {
            //throw new DataBaseException(e.getMessage());
        }

        return true;
    }

    public Boolean registrarListaClinton(String nit, boolean existente) {

        //Llamado a servicio externo
        Boolean reg = !ExternalServices.nitValidate(nit, existente);
        ln = new ListasNegras(nit, new Date(), reg, TipoLista.listaClinton);
        try {
            em.persist(ln);

        } catch (Exception e) {
            //throw new DataBaseException(e.getMessage());
        }
        return true;
    }

    public String verificarDataCredito(String nit, int reglaVal) {

        String rating = "";
        Boolean registrar;
        Query q = em.createNamedQuery("getInfoDataCredito");
        q.setParameter("pNit", nit.trim());
        try {
            List results = q.getResultList();
            if (!results.isEmpty()) {
                dc = (DataCredito) results.get(0);
                //Fecha actual
                int diff = Tools.getDiffDates(dc.getFecha(), new Date());
                if (diff > reglaVal) {
                    //Registra entidad
                    registrar = registrarDataCredito(nit.trim());
                    rating = dc.getCalificacion();
                } else //Retorna la calificación en DataCredito
                {
                    rating = dc.getCalificacion();
                }
            } else {
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

    public Boolean verificarListaClinton(String nit, int reglaVal) {
        Boolean rating = false;
        Query q = em.createNamedQuery("getInfoListasNegras");
        q.setParameter("pNit", nit.trim());
        q.setParameter("pTipo", TipoLista.listaClinton);
        try {
            List results = q.getResultList();
            if (!results.isEmpty()) {
                ln = (ListasNegras) results.get(0);
                //Obteniendo fecha de registro confecamaras
                int diff = Tools.getDiffDates(ln.getFecha(), new Date());
                if (diff > reglaVal) {
                    //Registra la entidad
                    rating = registrarListaClinton(nit.trim(), true);
                    rating = ln.getEstado();
                } else //Devuelve estado fente a confecamaras
                {
                    rating = ln.getEstado();
                }
            } else {
                //Registra la entidad
                rating = registrarListaClinton(nit.trim(), false);
                rating = ln.getEstado();
            }
            return rating;

        } catch (Exception e) {
            // throw new WebServiceException(e.getMessage());
        }

        return rating;
    }

    public Boolean verificarListaAntiLavado(String nit, int reglaVal) {
        Boolean rating = false;
        Query q = em.createNamedQuery("getInfoListasNegras");
        q.setParameter("pNit", nit.trim());
        q.setParameter("pTipo", TipoLista.listaAntilavados);
        try {
            List results = q.getResultList();
            if (!results.isEmpty()) {
                ln = (ListasNegras) results.get(0);
                //Obteniendo fecha de registro confecamaras
                int diff = Tools.getDiffDates(ln.getFecha(), new Date());
                if (diff > reglaVal) {
                    //Registra la entidad
                    rating = registrarAntiLavados(nit.trim(), true);
                    rating = ln.getEstado();
                } else //Devuelve estado fente a confecamaras
                {
                    rating = ln.getEstado();
                }
            } else {
                //Registra la entidad
                rating = registrarAntiLavados(nit.trim(), false);
                rating = ln.getEstado();
            }
            return rating;

        } catch (Exception e) {
            //throw new WebServiceException(e.getMessage());
        }

        return rating;
    }
}
