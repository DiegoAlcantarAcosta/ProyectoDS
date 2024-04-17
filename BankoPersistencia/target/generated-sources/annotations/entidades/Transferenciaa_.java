package entidades;

import entidades.Persona;
import entidades.Tarjeta;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-04-15T02:09:29", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Transferenciaa.class)
public class Transferenciaa_ { 

    public static volatile SingularAttribute<Transferenciaa, String> numeroCuentaDestinatario;
    public static volatile SingularAttribute<Transferenciaa, String> numeroCuentaPropietario;
    public static volatile SingularAttribute<Transferenciaa, String> motivo;
    public static volatile SingularAttribute<Transferenciaa, Persona> persona;
    public static volatile SingularAttribute<Transferenciaa, Long> id;
    public static volatile SingularAttribute<Transferenciaa, Date> fechaMovimiento;
    public static volatile SingularAttribute<Transferenciaa, Tarjeta> tarjeta;
    public static volatile SingularAttribute<Transferenciaa, Double> importe;

}