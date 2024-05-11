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
    public Boolean agregar(Contacto contacto);
    public Boolean eliminar(Contacto contacto);
    public List<Contacto> obtenerContactosPersona();
    public Contacto obtenerContactoPersona();
    
}
