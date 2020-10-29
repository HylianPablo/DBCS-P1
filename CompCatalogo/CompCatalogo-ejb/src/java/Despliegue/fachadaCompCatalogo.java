/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Despliegue;

import Dominio.Configuracionpc;
import Persistencia.ConfiguracionpcFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Propietario
 */
@Stateless
public class fachadaCompCatalogo implements fachadaCompCatalogoRemote {
    @EJB
    private ConfiguracionpcFacadeLocal configuracionpcFacade;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List<Configuracionpc> getCatalogo() {
        List<Configuracionpc> list = null;
        try{
            list = configuracionpcFacade.findAll();
        }catch(Exception ex){
            System.err.println(ex.getMessage());
        }
        return list;
    }
}
