package entidades;

import Conexion.Conexion;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Wilber
 */
public class PruebasPersistencia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//        PersonaDAO pd = new PersonaDAO();
//        Persona persona = pd.obtenerPersonaPorCurp(new Persona("RASM920730HDFNXN09"));
//        Persona personaPrueba = pd.obtenerPersonaPorCurp(new Persona("VAQW900101HDFNLT02"));
//        TarjetaDAO td = new TarjetaDAO();
//        Tarjeta tarjeta = td.obtenerTarjetaPorNumero(new Tarjeta("1234567892"));
//        Tarjeta tarjetaPrueba = td.obtenerTarjetaPorNumero(new Tarjeta("1234567890"));
//        ContactoDAO cd = new ContactoDAO();
//        Contacto contacto = new Contacto("Wilber", personaPrueba.getNombre(), personaPrueba.getApellidoP(), 
//                personaPrueba.getApellidoM(), tarjetaPrueba.getNumeroCuenta(), tarjetaPrueba.getBanco(), persona);
//        
//        Boolean si = cd.agregar(contacto);
//        
//        System.out.println(si);
        //PROBAMOS CREAR UNA PERSONA.
        ArrayList<Persona> entidades = new ArrayList<>();

        try {

            // Crear una nueva persona
            Date fechaNac1 = new Date(710256000000L); // 15 de junio de 1990
            List<Tarjeta> tarjetas1 = new ArrayList<>();
            Persona persona1 = new Persona("Juan", "Pérez", "Gómez", "PEGJ900615HDFRZN00", "contraseña123", fechaNac1, "5512345678", tarjetas1);

            Date fechaNac2 = new Date(504489600000L); // 25 de diciembre de 1985
            List<Tarjeta> tarjetas2 = new ArrayList<>();
            Persona persona2 = new Persona("María", "Sánchez", "López", "SALM851225MDFRPR09", "123456789", fechaNac2, "5587654321", tarjetas2);

            Date fechaNac3 = new Date(699654000000L); // 10 de marzo de 1992
            List<Tarjeta> tarjetas3 = new ArrayList<>();
            Persona persona3 = new Persona("Pedro", "Ramírez", "Hernández", "RAHP920310HDFLRR08", "qwerty123", fechaNac3, "5512349876", tarjetas3);

            Date fechaNac4 = new Date(586771200000L); // 20 de agosto de 1988
            List<Tarjeta> tarjetas4 = new ArrayList<>();
            Persona persona4 = new Persona("Ana", "García", "Martínez", "GAMA880820MDFRNN05", "password123", fechaNac4, "5556781234", tarjetas4);

            Date fechaNac5 = new Date(799766400000L); // 5 de mayo de 1995
            List<Tarjeta> tarjetas5 = new ArrayList<>();
            Persona persona5 = new Persona("Luis", "Torres", "Rodríguez", "TORL950505HDFRDS09", "123abc456", fechaNac5, "5512345679", tarjetas5);

            Date fechaNac6 = new Date(403497600000L); // 15 de octubre de 1982
            List<Tarjeta> tarjetas6 = new ArrayList<>();
            Persona persona6 = new Persona("Sofía", "Morales", "Guzmán", "MOGS821015MDFRFN04", "password456", fechaNac6, "5587659876", tarjetas6);

            Date fechaNac7 = new Date(259545600000L); // 25 de marzo de 1978
            List<Tarjeta> tarjetas7 = new ArrayList<>();
            Persona persona7 = new Persona("Carlos", "Jiménez", "Hernández", "JIHC780325HDFRRS06", "qwerty456", fechaNac7, "5512348765", tarjetas7);

            Date fechaNac8 = new Date(691593600000L); // 10 de diciembre de 1991
            List<Tarjeta> tarjetas8 = new ArrayList<>();
            Persona persona8 = new Persona("Laura", "Fernández", "López", "FELL911210MDFRPR08", "123password", fechaNac8, "5556789012", tarjetas8);

            Date fechaNac9 = new Date(554579200000L); // 30 de julio de 1987
            List<Tarjeta> tarjetas9 = new ArrayList<>();
            Persona persona9 = new Persona("Javier", "Martínez", "Sánchez", "MASJ870730HDFRNN01", "password987", fechaNac9, "5512347890", tarjetas9);

            Date fechaNac10 = new Date(735900800000L); // 20 de abril de 1993
            List<Tarjeta> tarjetas10 = new ArrayList<>();
            Persona persona10 = new Persona("Isabela", "Ramírez", "García", "RAGI930420MDFRRS05", "abc123def", fechaNac10, "5587650987", tarjetas10);

            // PROBAMOS CREAR UNA TARJETA.
            Date fecha = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(fecha);

            // Sumar 3 años a la fecha
            calendar.add(Calendar.YEAR, 3);
            Date fechaVencimiento = calendar.getTime();
            Tarjeta tarjeta1 = new Tarjeta(new ObjectId(),"1234567890", tipoTarjeta.CREDITO, tipoBanco.BANAMEX, 10000.0, fechaVencimiento);
            Tarjeta tarjeta2 = new Tarjeta(new ObjectId(),"1234567891", tipoTarjeta.DEBITO, tipoBanco.BANCOPPEL, 10000.0, fechaVencimiento);
            Tarjeta tarjeta3 = new Tarjeta(new ObjectId(),"1234567892", tipoTarjeta.CREDITO, tipoBanco.BANREGIO, 10000.0, fechaVencimiento);
            Tarjeta tarjeta4 = new Tarjeta(new ObjectId(),"1234567893", tipoTarjeta.DEBITO, tipoBanco.BBVA, 10000.0, fechaVencimiento);
            Tarjeta tarjeta5 = new Tarjeta(new ObjectId(),"1234567894", tipoTarjeta.CREDITO, tipoBanco.HSBC, 10000.0, fechaVencimiento);
            Tarjeta tarjeta6 = new Tarjeta(new ObjectId(),"1234567895", tipoTarjeta.DEBITO, tipoBanco.SANTANDER, 10000.0, fechaVencimiento);
            Tarjeta tarjeta7 = new Tarjeta(new ObjectId(),"1234567896", tipoTarjeta.CREDITO, tipoBanco.BANAMEX, 10000.0, fechaVencimiento);
            Tarjeta tarjeta8 = new Tarjeta(new ObjectId(),"1234567897", tipoTarjeta.DEBITO, tipoBanco.BANCOPPEL, 10000.0, fechaVencimiento);
            Tarjeta tarjeta9 = new Tarjeta(new ObjectId(),"1234567898", tipoTarjeta.CREDITO, tipoBanco.BBVA, 10000.0, fechaVencimiento);
            Tarjeta tarjeta10 = new Tarjeta(new ObjectId(),"123456789", tipoTarjeta.DEBITO, tipoBanco.HSBC, 10000.0, fechaVencimiento);
            Tarjeta tarjeta11 = new Tarjeta(new ObjectId(),"111111111", tipoTarjeta.DEBITO, tipoBanco.HSBC, 10000.0, fechaVencimiento);

            tarjetas1.add(tarjeta1);
            tarjetas2.add(tarjeta2);
            tarjetas3.add(tarjeta3);
            tarjetas4.add(tarjeta4);
            tarjetas5.add(tarjeta5);
            tarjetas6.add(tarjeta6);
            tarjetas7.add(tarjeta7);
            tarjetas8.add(tarjeta8);
            tarjetas9.add(tarjeta9);
            tarjetas10.add(tarjeta10);
            tarjetas10.add(tarjeta11);

            entidades.add(persona1);
            entidades.add(persona2);
            entidades.add(persona3);
            entidades.add(persona4);
            entidades.add(persona5);
            entidades.add(persona6);
            entidades.add(persona7);
            entidades.add(persona8);
            entidades.add(persona9);
            entidades.add(persona10);

            MongoCollection<Persona> coleccionPersonas = Conexion.getDatabase().getCollection("Usuarios", Persona.class);

            coleccionPersonas.insertMany(entidades);

        } catch (MongoException e) {
            System.out.println(e);
        }
    }

}
