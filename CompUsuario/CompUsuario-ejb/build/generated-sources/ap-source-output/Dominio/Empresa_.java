package Dominio;

import Dominio.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-11-07T18:53:42")
@StaticMetamodel(Empresa.class)
public class Empresa_ { 

    public static volatile SingularAttribute<Empresa, String> nifcif;
    public static volatile SingularAttribute<Empresa, Usuario> usuario;
    public static volatile SingularAttribute<Empresa, Short> esproveedor;
    public static volatile SingularAttribute<Empresa, Short> escliente;

}