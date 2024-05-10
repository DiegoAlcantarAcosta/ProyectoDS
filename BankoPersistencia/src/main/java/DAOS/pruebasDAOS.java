/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package DAOS;

import entidades.Persona;
import entidades.Tarjeta;
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
        TarjetaDAO td = new TarjetaDAO();
        PersonaDAO pd = new PersonaDAO();
        Tarjeta t = new Tarjeta("2222222221");
        Persona p = new Persona("RAGI930420MDFRRS05");
        Persona person = pd.obtenerPersonaPorCurp(p);
        System.out.println(td.obtenerTarjetasPersona(person).toString());
        Persona persona = new Persona();
        persona = pd.obtenerPersonaPorTelefonoYContrasena("5587650987", "abc123def");
//        

//        System.out.println(td.obtenerUltimaTarjetaPersona(person).toString());
//        
//        System.out.println(td.obtenerTarjetaPorNumero(t).toString());
//        System.out.println(td.obtenerTodasLasTarjetasDeClientes().toString());
//        System.out.println(pd.obtenerTodasLasPersonas().toString());
//            System.out.println(td.obtenerTarjetaPorNumero(t).toString());

        Date date = new Date(2030, 1, 20);
        Tarjeta tarjetita = new Tarjeta(new ObjectId("663e946e2ed744477802c97d"), "2222222221", tipoTarjeta.DEBITO, tipoBanco.BBVA, 1000d, date);

        td.actualizarTarjeta(persona, tarjetita);
    }

}
