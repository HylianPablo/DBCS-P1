/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.Pedidopc;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author alerome
 * @author pamarti
 */
@Stateless
public class PedidopcFacade extends AbstractFacade<Pedidopc> implements PedidopcFacadeLocal {
    @PersistenceContext(unitName = "CompPedido-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PedidopcFacade() {
        super(Pedidopc.class);
    }
    
    /**
     * Obtiene una lista de los pedidos encargados por una empresa a través de una NamedQuery.
     * @param empresa Cadena de caracteres que representa el NIF/CIF de la empresa.
     * @return Lista con los pedidos de ordenadores asociados a la empresa.
     */
    @Override
    public List<Pedidopc> getPedidoByEncargadopor(String empresa){
        return em.createNamedQuery("Pedidopc.findByEncargadopor").setParameter(1,empresa).getResultList();
    }
    
}
