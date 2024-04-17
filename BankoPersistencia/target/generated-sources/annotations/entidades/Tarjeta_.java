package entidades;

import entidades.Persona;
import entidades.tipoBanco;
import entidades.tipoTarjeta;
import java.util.Calendar;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-04-17T00:48:44", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Tarjeta.class)
public class Tarjeta_ { 

    public static volatile SingularAttribute<Tarjeta, tipoTarjeta> tipo;
    public static volatile SingularAttribute<Tarjeta, Persona> persona;
    public static volatile SingularAttribute<Tarjeta, Calendar> fechaVencimiento;
    public static volatile SingularAttribute<Tarjeta, tipoBanco> banco;
    public static volatile SingularAttribute<Tarjeta, String> numeroCuenta;
    public static volatile SingularAttribute<Tarjeta, Long> id;
    public static volatile SingularAttribute<Tarjeta, Double> saldo;

}