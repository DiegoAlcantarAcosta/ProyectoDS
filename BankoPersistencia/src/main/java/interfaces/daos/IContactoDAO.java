/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces.daos;

import entidades.Contacto;
import entidades.Persona;
import java.util.List;

/**
 *
 * @author Dell
 */
public interface IContactoDAO {
    public Boolean agregar(Persona persona, Contacto contacto);
    public Boolean eliminar(Persona persona, Contacto contacto);
    public Boolean actualizar(Persona persona, Contacto contactoOri, Contacto contactoActua);
    public List<Contacto> obtenerContactosPersona(Persona persona);
    public Contacto obtenerContactoPersona(Persona persona, Contacto contacto);
    
}
