/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.losalpes.marketplace.pomanager.beans;

import co.com.losalpes.marketplace.pomanager.bos.ReturnMaterialAdviceBO;
import co.com.losalpes.marketplace.pomanager.exceptions.AvisoDespachoNoExisteException;
import co.com.losalpes.marketplace.pomanager.exceptions.ClienteNoExisteException;
import co.com.losalpes.marketplace.pomanager.exceptions.OrdenCompraNoExisteException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author marketplace
 */
@Local
public interface RmaManagementLocal {
    public String registrarRMA(ReturnMaterialAdviceBO rma) throws OrdenCompraNoExisteException, AvisoDespachoNoExisteException;

    public List<ReturnMaterialAdviceBO> consultarRMAsComercio(String nit) throws ClienteNoExisteException;

    public List<ReturnMaterialAdviceBO> consultarRMAsFabricante(String nit) throws ClienteNoExisteException;
}
