/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Despliegue;

import Dominio.Estadoventapcs;
import Dominio.Pedidopc;
import Dominio.Configuracionpc;
import Persistencia.EstadoventapcsFacadeLocal;
import Persistencia.PedidopcFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Propietario
 */
@Stateless
public class fachadaCompPedido implements fachadaCompPedidoLocal {
    @EJB
    private PedidopcFacadeLocal pedidopcFacade;
    @EJB
    private EstadoventapcsFacadeLocal estadoventapcsFacade;
    @EJB
    private fachadaCompCatalogoRemote fachadaCompCatalogo;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public float importeAbonar(String nifcif) {
        
        float importeTotal = 0.0F;
        List<Pedidopc> pedidosEmpresa = pedidopcFacade.getPedidoByEncargadopor(nifcif);
        if(pedidosEmpresa==null || pedidosEmpresa.isEmpty()){
            return -1.0f;
        }
        for (Pedidopc pedidosEmpresa1 : pedidosEmpresa) {
            if (pedidosEmpresa1.getEstado().getIdestadoventa() == 3) {
                int confPedido = pedidosEmpresa1.getConfiguracionsolicitada();
                importeTotal+=(fachadaCompCatalogo.getPrecioTotal(confPedido)*pedidosEmpresa1.getCantidadsolicitada());
            }
        }
        return importeTotal;
    }

    @Override
    public boolean addPedido(int cantidad, int idConfiguracion, String nifcif) {
        Pedidopc pedido = new Pedidopc(53);
        float precioConfiguracion = fachadaCompCatalogo.getPrecioTotal(idConfiguracion);
        if(precioConfiguracion==-1.0f){
            return false;
        }
        pedido.setCantidadsolicitada(cantidad);
        pedido.setEncargadopor(nifcif);
        pedido.setConfiguracionsolicitada(idConfiguracion);
        Estadoventapcs estado = estadoventapcsFacade.find((short)1);
        pedido.setEstado(estado);
        try{
            pedidopcFacade.create(pedido);
        }catch(Exception ex){
            System.err.println(ex.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean delPedido(int idConfiguracion, String nifcif) {
        List<Pedidopc> pedidosUsuario = pedidopcFacade.getPedidoByEncargadopor(nifcif);
        if(pedidosUsuario==null || pedidosUsuario.isEmpty()){
            return false;
        }
        for (Pedidopc pedidosUsuario1 : pedidosUsuario) {
            if (pedidosUsuario1.getConfiguracionsolicitada() == idConfiguracion) {
                pedidopcFacade.remove(pedidosUsuario1);
                return true;
            }
        }
        return false;
    }
}
