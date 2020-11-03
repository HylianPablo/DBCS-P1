/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Despliegue;

import Dominio.Configuracionpc;
import Dominio.Cpu;
import Dominio.Descripcioncomponente;
import Persistencia.ConfiguracionpcFacadeLocal;
import Persistencia.CpuFacadeLocal;
import Persistencia.DescripcioncomponenteFacadeLocal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author arome
 */
@Stateless
public class fachadaCompCatalogo implements fachadaCompCatalogoRemote {
    @EJB
    private DescripcioncomponenteFacadeLocal descripcioncomponenteFacade;
    @EJB
    private CpuFacadeLocal cpuFacade;
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

    @Override
    public Boolean addConfiguracion(int velCPU, int capRAM, int capDD, int velTarGraf, int memTarGraf, short idTipoCPU, List<Integer> idsDescrComp) {
        int id = 1000 * velCPU + 100 * capRAM + 10 * capDD + velTarGraf + memTarGraf;
        Configuracionpc cf = new Configuracionpc(id, velCPU, capRAM, capDD);
        cf.setMemoriatarjetagrafica(memTarGraf);
        cf.setVelocidadtarjetagrafica(velTarGraf);
        Cpu c = cpuFacade.find(idTipoCPU);
        if(c!=null){
           cf.setTipocpu(c); 
        }else{
            return false;
        }
        List<Descripcioncomponente> listaComps = new ArrayList<>();
        for (int i = 0 ; i<idsDescrComp.size(); i++){
            Descripcioncomponente dc = descripcioncomponenteFacade.find(idsDescrComp.get(i));
            if(dc!=null){
               listaComps.add(dc); 
            }else{
                return false;
            }                      
        }
        cf.setDescripcioncomponenteList(listaComps);
        //try{
            configuracionpcFacade.create(cf);
        //}catch(Exception ex){
            //System.err.println(ex.getMessage());
            //return false;
        //}
        return true;
    }
    
    @Override
    public Boolean editConfiguracion(int IdConfiguracion, int velCPU, int capRAM, int capDD, int velTarGraf,int memTarGraf, short idTipoCPU){
        Configuracionpc cf = configuracionpcFacade.find(IdConfiguracion);
        if(cf==null){
            return false;
        }
        Cpu c = cpuFacade.find(idTipoCPU);          
        if(c==null){
            return false;
        }
        cf.setTipocpu(c);
        cf.setMemoriatarjetagrafica(memTarGraf);
        cf.setVelocidadcpu(velCPU);
        cf.setCapacidadram(capRAM);
        cf.setCapacidaddd(capDD);
        cf.setVelocidadtarjetagrafica(velTarGraf);
        try{
            configuracionpcFacade.edit(cf);
        }catch(Exception ex){
            System.err.println(ex.getMessage());
            return false;
        }
        return true;       
    }

    @Override
    public float getPrecioTotal(int idConfiguracion) {
        float precioTotal = 0;
        Configuracionpc cf = configuracionpcFacade.find(idConfiguracion);
        if(cf==null){
            return (float) -1.0;
        }
        List<Descripcioncomponente> listaComps = cf.getDescripcioncomponenteList();
        if(listaComps.size()==0){
            return (float) -1.0;
        }
        for (int i = 0 ; i<listaComps.size(); i++){
            precioTotal += listaComps.get(i).getPrecio();                   
        }
        return precioTotal;
    }
    
    
    
    
    
    
}
