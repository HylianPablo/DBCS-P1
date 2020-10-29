/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Despliegue;

import Dominio.Empleado;
import Dominio.Empresa;
import Persistencia.EmpleadoFacadeLocal;
import Persistencia.EmpresaFacadeLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Propietario
 */

@Stateless
public class FachadaCompUsuario implements FachadaCompUsuarioLocal {
    @EJB
    private EmpleadoFacadeLocal empleadoFacade;
    @EJB
    private EmpresaFacadeLocal empresaFacade;
    

    @Override
    public Empresa getEmpresa(String nifcif) {
        Empresa e = null;
        try{
            e = empresaFacade.find(nifcif);
        }catch(Exception ex){
            System.err.println(ex.getMessage());
        }
        return e;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public Empleado getEmpleado(String nifcif) {
        Empleado e = null;
        try{
            e = empleadoFacade.find(nifcif);
        }catch(Exception ex){
            System.err.println(ex.getMessage());
        }
        return e;
    }
}
