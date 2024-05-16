/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package DAOS;

import encriptacion.Encriptador;
import entidades.Persona;
import entidades.Tarjeta;
import entidades.Transferencia;
import entidades.tipoBanco;
import entidades.tipoTarjeta;
import java.util.Date;
import org.bson.types.ObjectId;

/**
 *
 * @author Diego
 */
public class pruebasDAOS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//       TarjetaDAO td = new TarjetaDAO();
        PersonaDAO pd = new PersonaDAO();
        Tarjeta t = new Tarjeta("1234567891");
//        Persona p = new Persona("RAGI930420MDFRRS05");
//        Persona person = pd.obtenerPersonaPorCurp(p);
//        System.out.println(td.obtenerTarjetasPersona(person).toString());
//        Persona persona = new Persona();
////        persona = pd.obtenerPersonaPorTelefonoYContrasena("5587650987", "abc123def");
////        
////
////        System.out.println(td.obtenerUltimaTarjetaPersona(person).toString());
////        
////        System.out.println(td.obtenerTarjetaPorNumero(t).toString());
////        System.out.println(td.obtenerTodasLasTarjetasDeClientes().toString());
////        System.out.println(pd.obtenerTodasLasPersonas().toString());
////            System.out.println(td.obtenerTarjetaPorNumero(t).toString());
////
////        Date date = new Date(2030, 1, 20);
////        Tarjeta tarjetita = new Tarjeta(new ObjectId("663e946e2ed744477802c97d"), "2222222221", tipoTarjeta.DEBITO, tipoBanco.BBVA, 1000d, date);
////
////        td.actualizarTarjeta(persona, tarjetita);
//
//        Transferencia transferencia = new Transferencia("1234567899", "1234567898", 500d, "Pa las uñas", new Date());
//
//        TransferenciaDAO transferenciaDAO = new TransferenciaDAO();
//        System.out.println(transferenciaDAO.realizarTransferencia(transferencia));

//        Date fecha1 = new Date(124, 4, 10); // Año 2024, mes 5 (Mayo), día 10
//        Date fecha2 = new Date(124, 4, 14); // Año 2024, mes 5 (Mayo), día 14
//        
//        
//        TransferenciaDAO transferenciaDAO = new TransferenciaDAO();
//        System.out.println(transferenciaDAO.obtenerTransferencias(t, fecha1, fecha2));
//
//        
        Date fecha1 = new Date(124, 4, 14);

        Date fecha = new Date();
        Encriptador enc = new Encriptador();
        
        System.out.println(enc.getAES("1"));
        System.out.println(enc.getAES("1"));
//        System.out.println(enc.getAESDecrypt("Ydk9ZfXtAqFS2eHuaIYoing=="));
//        System.out.println(enc.getAESDecrypt("slDhE3b2uGT/mZeHHUfnfA=="));
        System.out.println(enc.getAESDecrypt("ieJfodULS5sqp2auz2VTyw=="));
//        System.out.println(pd.insertMasivo());
//        fecha1.setHours(23);
//        fecha1.setMinutes(59);
//        fecha1.setSeconds(59);
//        fecha.setHours(0);
//        fecha.setMinutes(0);
//        fecha.setSeconds(0);
//        TransferenciaDAO transferenciaDAO = new TransferenciaDAO();
//        System.out.println(transferenciaDAO.obtenerTransferenciasEgreso(t, fecha, fecha));
////        System.out.println(fecha1);
//        System.out.println(transferenciaDAO.egresosDelDia(t));

    }

}
