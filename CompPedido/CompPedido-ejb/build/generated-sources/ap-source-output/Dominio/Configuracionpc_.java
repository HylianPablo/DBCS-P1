package Dominio;

import Dominio.Cpu;
import Dominio.Pedidopc;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-11-03T13:25:33")
@StaticMetamodel(Configuracionpc.class)
public class Configuracionpc_ { 

    public static volatile SingularAttribute<Configuracionpc, Integer> idconfiguracion;
    public static volatile ListAttribute<Configuracionpc, Pedidopc> pedidopcList;
    public static volatile SingularAttribute<Configuracionpc, Integer> velocidadcpu;
    public static volatile SingularAttribute<Configuracionpc, Cpu> tipocpu;
    public static volatile SingularAttribute<Configuracionpc, Integer> velocidadtarjetagrafica;
    public static volatile SingularAttribute<Configuracionpc, Integer> capacidadram;
    public static volatile SingularAttribute<Configuracionpc, Integer> capacidaddd;
    public static volatile SingularAttribute<Configuracionpc, Integer> memoriatarjetagrafica;

}