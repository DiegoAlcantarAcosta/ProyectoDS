package entidades;

import entidades.Persona;
import entidades.tipoBanco;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-04-16T23:42:25", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Contacto.class)
public class Contacto_ { 

    public static volatile SingularAttribute<Contacto, Persona> persona;
    public static volatile SingularAttribute<Contacto, String> apellidoP;
    public static volatile SingularAttribute<Contacto, String> alias;
    public static volatile SingularAttribute<Contacto, tipoBanco> banco;
    public static volatile SingularAttribute<Contacto, String> apellidoM;
    public static volatile SingularAttribute<Contacto, String> numeroCuenta;
    public static volatile SingularAttribute<Contacto, Long> id;
    public static volatile SingularAttribute<Contacto, String> nombre;

}