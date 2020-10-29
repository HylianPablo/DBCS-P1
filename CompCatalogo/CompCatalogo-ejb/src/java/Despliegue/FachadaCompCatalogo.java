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
 * @author arome
 */
@Stateless
public class FachadaCompCatalogo implements FachadaCompCatalogoRemote {
    @EJB
    private ConfiguracionpcFacadeLocal configuracionpcFacade;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List<Configuracionpc> getCatalogo() {
        List<Configuracionpc> list = null;
        Configuracionpc p = null;
        //try{
            p = configuracionpcFacade.find("1111");
            //System.out.println(p.getCapacidaddd() + "hoawdqwdwqgeikewnfkewflfjdqwkfneflewfnwfewkfewnfljewfjkfjewfjewjfwejhfwejewjfjewjfewk");
            list.add(p);
        //}catch(Exception ex){
           // System.err.println(ex.getMessage());
        //}
        return list;
    }
}
