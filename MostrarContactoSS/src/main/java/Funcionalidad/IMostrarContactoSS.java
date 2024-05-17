/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Funcionalidad;

import DTOs.ContactoDTO;
import DTOs.PersonaDTO;
import java.util.List;

/**
 *
 * @author Diego
 */
public interface IMostrarContactoSS {
    public List<ContactoDTO> obtenerContactosDTOPersona(PersonaDTO personaDTO);
    
    public ContactoDTO obtenerContactoDTOPersona(PersonaDTO personaDTO, ContactoDTO contactoDTO);
}
