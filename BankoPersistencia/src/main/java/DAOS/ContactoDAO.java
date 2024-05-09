/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOS;

import entidades.Contacto;
import entidades.Persona;
import interfaces.daos.IContactoDAO;
import java.util.List;

/**
 *
 * @author Dell
 */
public class ContactoDAO implements IContactoDAO {

    private PersonaDAO pd = new PersonaDAO();
    private TarjetaDAO td = new TarjetaDAO();

    public ContactoDAO() {
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
