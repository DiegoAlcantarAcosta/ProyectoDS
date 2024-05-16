/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Objetos.Interfaces;

import DTOs.ContactoDTO;
import DTOs.PersonaDTO;
import java.util.List;

/**
 *
 * @author Dell
 */
public interface IObjetoNegocioContacto {
    
    public Boolean agregar(PersonaDTO personaDTO, ContactoDTO contactoDTO);
    
    public Boolean eliminar(PersonaDTO personaDTO, ContactoDTO contactoDTO);
    
    public Boolean actualizar(PersonaDTO personaDTO, ContactoDTO contactoOrigiDTO, ContactoDTO contactoNuevoDTO);
    
    public List<ContactoDTO> obtenerContactosDTOPersona(PersonaDTO personaDTO);
    
    public ContactoDTO obtenerContactoDTOPersona(PersonaDTO personaDTO, ContactoDTO contactoDTO);
}
