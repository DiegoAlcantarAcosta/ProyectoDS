/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebas;

import DAOS.ContactoDAO;
import DAOS.PersonaDAO;
import entidades.Contacto;
import entidades.Persona;

/**
 *
 * @author Dell
 */
public class pruebas {
    
    public static void main(String[] args) {
        ContactoDAO cd = new ContactoDAO();
        PersonaDAO pd = new PersonaDAO();
        Contacto contacto = new Contacto("Wili");
        Persona persona = new Persona("RASM920730HDFNXN09");
        cd.obtenerContactoPersona(contacto, persona);
        System.out.println(cd.obtenerContactoPersona(contacto, persona));
    }
    
}
