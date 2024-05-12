/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.actualizarcontactoss;

import DTOs.ContactoDTO;
import DTOs.PersonaDTO;
import DTOs.tipoBancoDTO;
import Funcionalidad.ActualizarContactoSS;

/**
 *
 * @author Dell
 */
public class prueba {

    public static void main(String[] args) {
        ActualizarContactoSS ac = new ActualizarContactoSS();
        ContactoDTO contactoDTO = new ContactoDTO("Wili", "wiliberto", "Perez", "Perez", "1", tipoBancoDTO.BANCOPPEL);
        ContactoDTO contactoFalso = new ContactoDTO("Tumama", "wiliberto", "Perez", "Perez", "1", tipoBancoDTO.BANCOPPEL);
        ContactoDTO contactoActualizaDTO = new ContactoDTO("Wilito", "wiliberto", "Perez", "Perez", "2", tipoBancoDTO.BANCOPPEL);
        PersonaDTO personaDTO = new PersonaDTO("SALM851225MDFRPR09");
        PersonaDTO persona2DTO = new PersonaDTO("SALM851225MDFRPR09");
        
        System.out.println(ac.actualizar(personaDTO,contactoDTO, contactoActualizaDTO));
    }
}
