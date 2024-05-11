/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOS;

import Conexion.Conexion;
import interfaces.daos.IContactoDAO;
import java.util.List;

/**
 *
 * @author Dell
 */
public class ContactoDAO implements IContactoDAO {

    private final MongoCollection<Persona> coleccionContactos;

    public ContactoDAO() {
        this.coleccionContactos = Conexion.getDatabase().getCollection("Contactos", Contacto.class);
    }

    @Override
    public Boolean agregar(Contacto contacto) {
    
        return null;
    
    }
    
    @Override
    public Boolean eliminar(Contacto contacto) {

        return null;

    }
    
    @Override
    public List<Contacto> obtenerContactosPersona(Persona persona) {
  
        return null;
  
    }
    
    @Override
    public Contacto obtenerContactoPersona(Contacto contacto, Persona persona) {

        return null;

    }

}
