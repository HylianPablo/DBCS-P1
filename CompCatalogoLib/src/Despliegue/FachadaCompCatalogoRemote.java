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
 * @author arome
 */
@Remote
public interface FachadaCompCatalogoRemote {

    List<Configuracionpc> getCatalogo();
    
}
