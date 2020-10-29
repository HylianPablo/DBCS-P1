package Dominio;

import Dominio.Cpu;
import Dominio.Descripcioncomponente;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-10-29T19:12:34")
@StaticMetamodel(Configuracionpc.class)
public class Configuracionpc_ { 

    public static volatile SingularAttribute<Configuracionpc, Integer> idconfiguracion;
    public static volatile ListAttribute<Configuracionpc, Descripcioncomponente> descripcioncomponenteList;
    public static volatile SingularAttribute<Configuracionpc, Integer> velocidadcpu;
    public static volatile SingularAttribute<Configuracionpc, Cpu> tipocpu;
    public static volatile SingularAttribute<Configuracionpc, Integer> velocidadtarjetagrafica;
    public static volatile SingularAttribute<Configuracionpc, Integer> capacidadram;
    public static volatile SingularAttribute<Configuracionpc, Integer> capacidaddd;
    public static volatile SingularAttribute<Configuracionpc, Integer> memoriatarjetagrafica;

}