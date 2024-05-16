/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Funcionalidad;

import DTOs.ContactoDTO;
import DTOs.PersonaDTO;
import DTOs.TarjetaDTO;

/**
 *
 * @author Diego
 */
public interface IAnadirContactoSS {
    public Boolean agregar(PersonaDTO personaDTO, ContactoDTO contactoDTO);
    
}
