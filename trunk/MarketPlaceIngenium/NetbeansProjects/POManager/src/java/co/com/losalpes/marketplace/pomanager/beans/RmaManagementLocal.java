/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.losalpes.marketplace.pomanager.beans;

import co.com.losalpes.marketplace.pomanager.bos.ReturnMaterialAdviceBO;
import co.com.losalpes.marketplace.pomanager.exceptions.BussinessException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author marketplace
 */
@Local
public interface RmaManagementLocal {
    public String registrarRMA(ReturnMaterialAdviceBO rma) throws BussinessException;

    public List<ReturnMaterialAdviceBO> consultarRMAsComercio(String nit) throws BussinessException;

    public List<ReturnMaterialAdviceBO> consultarRMAsFabricante(String nit) throws BussinessException;
}
