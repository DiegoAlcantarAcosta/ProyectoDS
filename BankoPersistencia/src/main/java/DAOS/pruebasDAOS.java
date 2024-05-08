/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package DAOS;

import entidades.Persona;
import entidades.Tarjeta;

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
        Tarjeta t = new Tarjeta("111111111");
        Persona p = new Persona("RAGI930420MDFRRS05");
        Persona person = pd.obtenerPersonaPorCurp(p);
//        System.out.println(td.obtenerTarjetasPersona(person).toString());
//        
//        System.out.println(td.obtenerUltimaTarjetaPersona(person).toString());
//        
//        System.out.println(td.obtenerTarjetaPorNumero(t).toString());
        
//        System.out.println(td.obtenerTodasLasTarjetasDeClientes().toString());
//        System.out.println(pd.obtenerTodasLasPersonas().toString());

            System.out.println(td.obtenerTarjetaPorNumero(t).toString());
    }

}
