/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebas;

import DAOS.ContactoDAO;
import DAOS.PersonaDAO;
import entidades.Contacto;
import entidades.Persona;
import entidades.tipoBanco;
import org.bson.types.ObjectId;

/**
 *
 * @author Dell
 */
public class pruebas {
    
    public static void main(String[] args) {
        ContactoDAO cd = new ContactoDAO();
        PersonaDAO pd = new PersonaDAO();
        Contacto contacto = new Contacto("Wili", "wiliberto", "perez", "perez", "1", "BANCOPPEL");
        Contacto contacto1Actua = new Contacto("Wilo", "wiliberto", "perez", "perez", "1", "BANCOPPEL");
        Contacto contacto2 = new Contacto("Mari", "Juna", "perez", "Lopez", "2", "BANCOPPEL");
        Persona persona = new Persona(new ObjectId("663ff128d0ef4e16ee77a384"));
        Persona personaCurp = new Persona("PEGJ900615HDFRZN00");
        Persona persona1 = pd.obtenerPersonaPorCurp(personaCurp);
        
        System.out.println(cd.obtenerContactoPersona(persona1, contacto2));
        System.out.println(cd.obtenerContactosPersona(persona1));
        System.out.println(cd.actualizar(persona, contacto, contacto1Actua));
        System.out.println(cd.eliminar(persona1, contacto2));
        System.out.println(cd.obtenerContactosPersona(persona1));
        System.out.println(cd.obtenerContactoPersona(persona1, contacto2));
    }
    
}
