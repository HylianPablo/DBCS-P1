/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Despliegue;

import Dominio.Configuracionpc;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Propietario
 */
@Remote
public interface fachadaCompCatalogoRemote {

    List<Configuracionpc> getCatalogo();

    Boolean addConfiguracion(int velCPU, int capRAM, int capDD, int velTarGraf, int memTarGraf, short idTipoCPU, List<Integer> idsDescrComp);
    
    Boolean editConfiguracion(int IdConfiguracion, int velCPU, int capRAM, int capDD, int velTarGraf,int memTarGraf, short idTipoCPU);

    float getPrecioTotal(int idConfiguracion);
    
}
