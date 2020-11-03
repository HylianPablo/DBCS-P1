/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Despliegue;

import Dominio.Configuracionpc;
import Dominio.Empresa;
import Dominio.Estadoventapcs;
import Dominio.Pedidopc;
import Persistencia.ConfiguracionpcFacadeLocal;
import Persistencia.EmpresaFacadeLocal;
import Persistencia.EstadoventapcsFacadeLocal;
import Persistencia.PedidopcFacadeLocal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author arome
 */
@Stateless
public class fachadaCompPedido implements fachadaCompPedidoLocal {
    @EJB
    private EstadoventapcsFacadeLocal estadoventapcsFacade;
    @EJB
    private ConfiguracionpcFacadeLocal configuracionpcFacade;
    @EJB
    private EmpresaFacadeLocal empresaFacade;
    @EJB
    private PedidopcFacadeLocal pedidopcFacade;
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @Override
    public float importeAbonar(String nifcif) {
        List<Pedidopc> pedidos = new ArrayList<>();
        float importeTotal = -1.0F;
        /*
        int cantidad = 0;
        pedidos = pedidopcFacade.findAll();
        for (int i = 0; i<pedidos.size(); i++){
            if(pedidos.get(i).getEncargadopor().equals(nifcif)){
                if(pedidos.get(i).getEstado().getIdestadoventa()==3){
                    pedidos.get(i).getConfiguracionsolicitada()
                    cantidad = pedidos.get(i).getCantidadsolicitada();
                }  
            }
        }*/
        return importeTotal;
    }

    @Override
    public boolean addPedido(int cantidad, int idConfiguracion, String nifcif) {
        Pedidopc p = new Pedidopc(53,cantidad);
        Configuracionpc conf = configuracionpcFacade.find(idConfiguracion);
        if(conf==null){
            return false;
        }
        Empresa emp = empresaFacade.find(nifcif);
        if(emp==null){
            return false;
        }
        Estadoventapcs estado = estadoventapcsFacade.find((short)1);
        p.setEstado(estado);
        p.setEncargadopor(emp);
        p.setConfiguracionsolicitada(conf);
        try{
            pedidopcFacade.create(p);
        }catch(Exception ex){
            System.err.println(ex.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean delPedido(int idConfiguracion, String nifcif) {
        Empresa empresa = empresaFacade.find(nifcif);
        if(empresa==null){
            return false;
        }
        List<Pedidopc> pedidosUsuario = pedidopcFacade.getPedidoByEncargadopor(empresa);
        if(pedidosUsuario==null || pedidosUsuario.isEmpty()){
            return false;
        }
        for(int i=0;i<pedidosUsuario.size();i++){
            if(pedidosUsuario.get(i).getConfiguracionsolicitada().getIdconfiguracion()==idConfiguracion){
                pedidopcFacade.remove(pedidosUsuario.get(i));
                return true;
            }
        }
        return false;
    }
    
    
}
