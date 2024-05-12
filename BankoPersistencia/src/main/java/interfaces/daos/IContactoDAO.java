/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces.daos;

import entidades.Contacto;
import entidades.Persona;
import java.util.List;
import javax.persistence.PersistenceException;

/**
 *
 * @author Dell
 */
public interface IContactoDAO {
    public Boolean agregar(Persona persona, Contacto contacto) throws PersistenceException;
    public Boolean eliminar(Persona persona, Contacto contacto) throws PersistenceException;
    public Boolean actualizar(Persona persona, Contacto contactoOri, Contacto contactoActua) throws PersistenceException;
    public List<Contacto> obtenerContactosPersona(Persona persona) throws PersistenceException;
    public Contacto obtenerContactoPersona(Persona persona, Contacto contacto) throws PersistenceException;
    
}
