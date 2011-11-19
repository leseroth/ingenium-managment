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

/**
 * Bean que implementa la logica de verificacion de informacion
 * @author Erik
 */
@Stateless
public class CreditVerificationBean implements CreditVerificationRemote, CreditVerificationLocal {

    @PersistenceContext
    private EntityManager em;

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
     * @return La entidad creada
     */
    protected Confecamara registrarComfecamara(String nit, boolean existente) {
        boolean estado = ExternalServices.nitValidate(nit, existente);
        Confecamara confecamara = new Confecamara(estado, new Date(), nit);
        em.persist(confecamara);
        return confecamara;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String verificarDataCredito(String nit, int reglaVal) throws BussinessException {
        DataCredito datacredito = null;

        try {
            Query q = em.createNamedQuery("getInfoDataCredito");
            q.setParameter("pNit", nit.trim());
            List results = q.getResultList();

            if (!results.isEmpty()) {
                datacredito = (DataCredito) results.get(0);

                //Obteniendo fecha de registro confecamaras para validar nuevamente
                if (Tools.getDiffDates(datacredito.getFecha(), new Date()) > reglaVal) {
                    //Registra la entidad nuevamente
                    System.err.println("Registra la entidad nuevamente");
                    datacredito = registrarDataCredito(nit.trim(), true);
                }
            } else {
                //Registra la entidad
                datacredito = registrarDataCredito(nit.trim(), false);
            }
        } catch (Exception e) {
            throw new BussinessException("Excepcion : " + e.getMessage());
        }

        return datacredito.getCalificacion();
    }

    /**
     * Permite registrar una entidad ante datacredito
     * @param nit Nit de la entidad
     * @param existente Indica si ya existia, si ya existia existe el 50% de posiblidad de que no sea validada,
     * en caso contrario, es valida si su nit no contiene 7, 8 o 9
     * @return La entidad creada
     */
    protected DataCredito registrarDataCredito(String nit, boolean existente) {
        String calificacion = ExternalServices.getRating(nit, existente);
        DataCredito datacredito = new DataCredito(calificacion, new Date(), nit);
        em.persist(datacredito);
        return datacredito;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean verificarListaAntiLavado(String nit, int reglaVal) throws BussinessException {
        return consultarListaNegra(nit, reglaVal, TipoLista.LISTA_ANTILAVADOS);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean verificarListaClinton(String nit, int reglaVal) throws BussinessException {
        return consultarListaNegra(nit, reglaVal, TipoLista.LISTA_CLINTON);
    }

    /**
     * Consulta las listas negras dependiendo el tipo de lista
     * @param nit Nit de la empresa
     * @param reglaVal Dias de validacion
     * @param tipoLista Tipo de lista a consultar
     * @return true si el establecimiento es valido
     * @throws BussinessException
     */
    protected Boolean consultarListaNegra(String nit, int reglaVal, TipoLista tipoLista) throws BussinessException {
        ListasNegras listaNegra = null;

        try {
            Query q = em.createNamedQuery("getInfoListasNegras");
            q.setParameter("pNit", nit.trim());
            q.setParameter("pTipo", tipoLista);
            List results = q.getResultList();

            if (!results.isEmpty()) {
                listaNegra = (ListasNegras) results.get(0);

                //Obteniendo fecha de registro confecamaras para validar nuevamente
                if (Tools.getDiffDates(listaNegra.getFecha(), new Date()) > reglaVal) {
                    //Registra la entidad nuevamente
                    System.err.println("Registra la entidad nuevamente");
                    listaNegra = registrarListaNegra(nit.trim(), true, tipoLista);
                }
            } else {
                //Registra la entidad
                listaNegra = registrarListaNegra(nit.trim(), false, tipoLista);
            }
        } catch (Exception e) {
            throw new BussinessException("Excepcion : " + e.getMessage());
        }

        return listaNegra.getEstado();
    }

    /**
     * Permite registrar una entidad en las listas negras.
     * @param nit Nit de la entidad
     * @param existente Indica si ya existia, si ya existia existe el 50% de posiblidad de que no sea validada,
     * en caso contrario, es valida si su nit no contiene 7, 8 o 9
     * @param tipoLista Tipo de lista a registrar
     * @return
     */
    protected ListasNegras registrarListaNegra(String nit, boolean existente, TipoLista tipoLista) {
        boolean estado = ExternalServices.nitValidate(nit, existente);
        ListasNegras listaNegra = new ListasNegras(estado, new Date(), nit, tipoLista);
        em.persist(listaNegra);
        return listaNegra;
    }
}
