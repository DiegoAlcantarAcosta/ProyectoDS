/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Funcionalidad;

import DTOs.ContactoDTO;
import DTOs.PersonaDTO;

/**
 *
 * @author Diego
 */
public interface IAnadirContactoSS {
    
    /**
     *  Metodo para agregar un contacto a una persona
     * @param personaDTO persona dueña del contacto
     * @param contactoDTO contacto que se le agregara
     * @return  true o false
     */
    public Boolean agregar(PersonaDTO personaDTO, ContactoDTO contactoDTO);
    
}
