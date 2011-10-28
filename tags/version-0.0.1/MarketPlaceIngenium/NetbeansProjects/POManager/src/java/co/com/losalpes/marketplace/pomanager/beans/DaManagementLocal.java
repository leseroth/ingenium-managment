/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.losalpes.marketplace.pomanager.beans;

import co.com.losalpes.marketplace.pomanager.bos.DispatchAdviceBO;
import co.com.losalpes.marketplace.pomanager.exceptions.BussinessException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author marketplace
 */
@Local
public interface DaManagementLocal {
    
    public String registrarDA(DispatchAdviceBO da, String numSeguimientoPo) throws BussinessException;

    public DispatchAdviceBO consultarDA(String numSeguimiento) throws BussinessException;

    public List<DispatchAdviceBO> consultarDAsFabricante(String nit) throws BussinessException;

    public DispatchAdviceBO consultarDAnumSeguimientoPO(String numSeguimiento) throws BussinessException;
}
