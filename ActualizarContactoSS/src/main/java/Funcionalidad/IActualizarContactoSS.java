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
    
    /**
     * Metodo para actualizar un ocntacto
     * @param personaDTO persona dueña de contactos
     * @param contactoOrigiDTO contacto registrado
     * @param contactoNuevoDTO contacto por el que se reemplazara
     * @return  true o false
     */
    public Boolean actualizar(PersonaDTO personaDTO, ContactoDTO contactoOrigiDTO, ContactoDTO contactoNuevoDTO);
    
}
