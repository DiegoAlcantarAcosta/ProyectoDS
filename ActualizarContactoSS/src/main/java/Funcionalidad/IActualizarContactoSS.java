/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Funcionalidad;

import DTOs.ContactoDTO;
import DTOs.PersonaDTO;

/**
 *
 * @author Dell
 */
public interface IActualizarContactoSS {
    
    public Boolean actualizar(PersonaDTO personaDTO, ContactoDTO contactoOrigiDTO, ContactoDTO contactoNuevoDTO);
    
}
