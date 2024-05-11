/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOS;

import Conexion.Conexion;
import com.mongodb.client.MongoCollection;
import entidades.Contacto;
import interfaces.daos.IContactoDAO;
import java.util.List;

/**
 *
 * @author Dell
 */
public class ContactoDAO implements IContactoDAO {

    MongoCollection<Contacto> coleccionContactos;

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
    public List<Contacto> obtenerContactosPersona() {
  
        return null;
  
    }
    
    @Override
    public Contacto obtenerContactoPersona() {

        return null;

    }

}
