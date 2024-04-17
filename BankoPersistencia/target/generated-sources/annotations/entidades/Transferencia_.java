package entidades;

import entidades.Persona;
import entidades.Tarjeta;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-04-16T23:42:25", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Transferencia.class)
public class Transferencia_ { 

    public static volatile SingularAttribute<Transferencia, String> numeroCuentaDestinatario;
    public static volatile SingularAttribute<Transferencia, String> numeroCuentaPropietario;
    public static volatile SingularAttribute<Transferencia, String> motivo;
    public static volatile SingularAttribute<Transferencia, Persona> persona;
    public static volatile SingularAttribute<Transferencia, Long> id;
    public static volatile SingularAttribute<Transferencia, Date> fechaMovimiento;
    public static volatile SingularAttribute<Transferencia, Tarjeta> tarjeta;
    public static volatile SingularAttribute<Transferencia, Double> importe;

}