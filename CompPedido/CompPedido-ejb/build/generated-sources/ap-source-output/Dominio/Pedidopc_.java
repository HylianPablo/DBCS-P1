package Dominio;

import Dominio.Estadoventapcs;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-11-07T18:57:39")
@StaticMetamodel(Pedidopc.class)
public class Pedidopc_ { 

    public static volatile SingularAttribute<Pedidopc, Integer> configuracionsolicitada;
    public static volatile SingularAttribute<Pedidopc, String> encargadopor;
    public static volatile SingularAttribute<Pedidopc, Estadoventapcs> estado;
    public static volatile SingularAttribute<Pedidopc, Integer> idpedido;
    public static volatile SingularAttribute<Pedidopc, Integer> cantidadsolicitada;

}