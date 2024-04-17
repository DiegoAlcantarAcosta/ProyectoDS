package entidades;

import DAOS.ContactoDAO;
import DAOS.PersonaDAO;
import DAOS.TarjetaDAO;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Wilber
 */
public class PruebasPersistencia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        PersonaDAO pd = new PersonaDAO();
        Persona persona = pd.obtenerPersonaPorCurp(new Persona("RASM920730HDFNXN09"));
        Persona personaPrueba = pd.obtenerPersonaPorCurp(new Persona("VAQW900101HDFNLT02"));
        TarjetaDAO td = new TarjetaDAO();
        Tarjeta tarjeta = td.obtenerTarjetaPorNumero(new Tarjeta("1234567892"));
        Tarjeta tarjetaPrueba = td.obtenerTarjetaPorNumero(new Tarjeta("1234567890"));
        ContactoDAO cd = new ContactoDAO();
        Contacto contacto = new Contacto("Joto", personaPrueba.getNombre(), personaPrueba.getApellidoP(), 
                personaPrueba.getApellidoM(), tarjetaPrueba.getNumeroCuenta(), tarjetaPrueba.getBanco(), persona);
        
        Boolean si = cd.agregar(contacto);
        
        System.out.println(si);
        
        
        
        
        
        
        
       //PROBAMOS CREAR UNA PERSONA.
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ConexionPU");
//        EntityManager em = entityManagerFactory.createEntityManager();
//
//        EntityTransaction transaction = null;
//
//        ArrayList<Object> entidades = new ArrayList<>();
//
//        try {
//
//            // Crear una nueva persona
//            Calendar fechaNacimiento1 = Calendar.getInstance();
//            fechaNacimiento1.set(1990, Calendar.JANUARY, 1);
//            Persona persona1 = new Persona("Wilber", "Valdez", "Quintero", fechaNacimiento1, "6442116429", "VAQW900101HDFNLT02");
//
//            Calendar fechaNacimiento2 = Calendar.getInstance();
//            fechaNacimiento2.set(1985, Calendar.MARCH, 15);
//            Persona persona2 = new Persona("Camila", "Fernández", "Gómez", fechaNacimiento2, "6442116430", "FEGC850315HDFMOM02");
//
//            Calendar fechaNacimiento3 = Calendar.getInstance();
//            fechaNacimiento3.set(1992, Calendar.JULY, 30);
//            Persona persona3 = new Persona("Mateo", "Ramírez", "Sánchez", fechaNacimiento3, "6442116431", "RASM920730HDFNXN09");
//
//            Calendar fechaNacimiento4 = Calendar.getInstance();
//            fechaNacimiento4.set(1978, Calendar.NOVEMBER, 5);
//            Persona persona4 = new Persona("Sofía", "Aguilar", "Castillo", fechaNacimiento4, "6442116432", "AACS781105MDFSTF05");
//
//            Calendar fechaNacimiento5 = Calendar.getInstance();
//            fechaNacimiento5.set(1995, Calendar.APRIL, 20);
//            Persona persona5 = new Persona("Sebastián", "Ortiz", "Flores", fechaNacimiento5, "6442116433", "OEFS950420HDFRTB12");
//
//            Calendar fechaNacimiento6 = Calendar.getInstance();
//            fechaNacimiento6.set(1988, Calendar.SEPTEMBER, 12);
//            Persona persona6 = new Persona("Valeria", "Gutiérrez", "Reyes", fechaNacimiento6, "6442116434", "GRRV880912MDFYLY07");
//
//            Calendar fechaNacimiento7 = Calendar.getInstance();
//            fechaNacimiento7.set(1982, Calendar.JUNE, 28);
//            Persona persona7 = new Persona("Andrés", "Herrera", "Castañeda", fechaNacimiento7, "6442116435", "HECA820628HDFRRN04");
//
//            Calendar fechaNacimiento8 = Calendar.getInstance();
//            fechaNacimiento8.set(1991, Calendar.FEBRUARY, 3);
//            Persona persona8 = new Persona("Alejandra", "Morales", "Díaz", fechaNacimiento8, "6442116436", "MODA910203MDFRLJ01");
//
//            Calendar fechaNacimiento9 = Calendar.getInstance();
//            fechaNacimiento9.set(1975, Calendar.AUGUST, 19);
//            Persona persona9 = new Persona("Rodrigo", "Vargas", "Jiménez", fechaNacimiento9, "6442116437", "VAJR750819HDFMRN08");
//
//            Calendar fechaNacimiento10 = Calendar.getInstance();
//            fechaNacimiento10.set(1987, Calendar.DECEMBER, 24);
//            Persona persona10 = new Persona("Gabriela", "Soto", "Ramos", fechaNacimiento10, "6442116438", "SORG871224MDFMAB15");
//
//            entidades.add(persona1);
//            entidades.add(persona2);
//            entidades.add(persona3);
//            entidades.add(persona4);
//            entidades.add(persona5);
//            entidades.add(persona6);
//            entidades.add(persona7);
//            entidades.add(persona8);
//            entidades.add(persona9);
//            entidades.add(persona10);
//
//            // PROBAMOS CREAR UNA TARJETA.
//            Calendar fechaVencimiento = Calendar.getInstance();
//            fechaVencimiento.add(Calendar.YEAR, 3); // Por ejemplo, vencimiento en 3 años
//            Tarjeta tarjeta1 = new Tarjeta("1234567890", tipoTarjeta.CREDITO, tipoBanco.BANAMEX, 10000.0, fechaVencimiento, persona1);
//            Tarjeta tarjeta2 = new Tarjeta("1234567891", tipoTarjeta.DEBITO, tipoBanco.BANCOPPEL, 10000.0, fechaVencimiento, persona2);
//            Tarjeta tarjeta3 = new Tarjeta("1234567892", tipoTarjeta.CREDITO, tipoBanco.BANREGIO, 10000.0, fechaVencimiento, persona3);
//            Tarjeta tarjeta4 = new Tarjeta("1234567893", tipoTarjeta.DEBITO, tipoBanco.BBVA, 10000.0, fechaVencimiento, persona4);
//            Tarjeta tarjeta5 = new Tarjeta("1234567894", tipoTarjeta.CREDITO, tipoBanco.HSBC, 10000.0, fechaVencimiento, persona5);
//            Tarjeta tarjeta6 = new Tarjeta("1234567895", tipoTarjeta.DEBITO, tipoBanco.SANTANDER, 10000.0, fechaVencimiento, persona6);
//            Tarjeta tarjeta7 = new Tarjeta("1234567896", tipoTarjeta.CREDITO, tipoBanco.BANAMEX, 10000.0, fechaVencimiento, persona7);
//            Tarjeta tarjeta8 = new Tarjeta("1234567897", tipoTarjeta.DEBITO, tipoBanco.BANCOPPEL, 10000.0, fechaVencimiento, persona8);
//            Tarjeta tarjeta9 = new Tarjeta("1234567898", tipoTarjeta.CREDITO, tipoBanco.BBVA, 10000.0, fechaVencimiento, persona9);
//            Tarjeta tarjeta10 = new Tarjeta("123456789", tipoTarjeta.DEBITO, tipoBanco.HSBC, 10000.0, fechaVencimiento, persona10);
//            Tarjeta tarjeta11 = new Tarjeta("111111111", tipoTarjeta.DEBITO, tipoBanco.HSBC, 10000.0, fechaVencimiento, persona3);
//
//            entidades.add(tarjeta1);
//            entidades.add(tarjeta2);
//            entidades.add(tarjeta3);
//            entidades.add(tarjeta4);
//            entidades.add(tarjeta5);
//            entidades.add(tarjeta6);
//            entidades.add(tarjeta7);
//            entidades.add(tarjeta8);
//            entidades.add(tarjeta9);
//            entidades.add(tarjeta10);
//            entidades.add(tarjeta11);
//
//            em.getTransaction().begin();
//
//            for (Object entidad : entidades) {
//                em.persist(entidad); //cada vuelta almacena la entidad correspondiente
//            }
//
//            em.getTransaction().commit();
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            e.printStackTrace();
//        } finally {
//            em.close();
//            entityManagerFactory.close();
//        }
    }

}
