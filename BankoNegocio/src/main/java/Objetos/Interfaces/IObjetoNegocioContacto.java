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
    
    public Boolean agregar(ContactoDTO contactoDTO);
    
    public Boolean eliminar(ContactoDTO contactoDTO);
    
    public List<ContactoDTO> obtenerContactosDTOPersona(PersonaDTO personaDTO);
    
    public ContactoDTO obtenerContactoDTOPersona(ContactoDTO contactoDTO, PersonaDTO personaDTO);
}
