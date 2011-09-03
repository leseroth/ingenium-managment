/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.losalpes.marketplace.pomanager.beans;

import co.com.losalpes.marketplace.pomanager.bos.DispatchAdviceBO;
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
public interface DaManagementLocal {
    
    public String registrarDA(DispatchAdviceBO da, String numSeguimientoPo) throws OrdenCompraNoExisteException;

    public DispatchAdviceBO consultarDA(String numSeguimiento) throws AvisoDespachoNoExisteException;

    public List<DispatchAdviceBO> consultarDAsFabricante(String nit) throws ClienteNoExisteException;

    public DispatchAdviceBO consultarDAnumSeguimientoPO(String numSeguimiento) throws AvisoDespachoNoExisteException, OrdenCompraNoExisteException;
}
