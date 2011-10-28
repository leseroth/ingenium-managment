/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.losalpes.marketplace.riskqualification.beans;

import javax.ejb.Local;

/**
 *
 * @author marketplace
 */
@Local
public interface CreditVerificationLocal {
 
    public Boolean registrarDataCredito(String nit) throws Exception;
    public Boolean registrarComfecamara(String nit) throws Exception;
    public Boolean registrarAntiLavados(String nit) throws Exception;
    public Boolean registrarListaClinton(String nit) throws Exception;
    public String verificarDataCredito(String nit, int reglaVal) throws Exception;
    public Boolean verificarComfecamara(String nit, int reglaVal) throws Exception;
    public Boolean verificarListaClinton(String nit, int reglaVal) throws Exception;
    public Boolean verificarListaAntiLavado(String nit, int reglaVal) throws Exception;
    
}
