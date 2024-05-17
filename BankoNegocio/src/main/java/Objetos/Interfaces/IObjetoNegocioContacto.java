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
    
    /**
     * agrega un contyacto
     * @param personaDTO persona
     * @param contactoDTO contacto
     * @return  boolean si
     */
    public Boolean agregar(PersonaDTO personaDTO, ContactoDTO contactoDTO);
    
    /**
     * elimina un contacto
     * @param personaDTO persona
     * @param contactoDTO contacto
     * @return  boolean s
     */
    public Boolean eliminar(PersonaDTO personaDTO, ContactoDTO contactoDTO);
    
    /**
     * actualiza el contacto
     * @param personaDTO persona
     * @param contactoOrigiDTO contacto base
     * @param contactoNuevoDTO cnntacto nuevo
     * @return  boolean s
     */
    public Boolean actualizar(PersonaDTO personaDTO, ContactoDTO contactoOrigiDTO, ContactoDTO contactoNuevoDTO);
    
    /**
     * Metodo para obtneer contyactos
     * @param personaDTO persona
     * @return  lista de contactos s
     */
    public List<ContactoDTO> obtenerContactosDTOPersona(PersonaDTO personaDTO);
    
    /**
     * obtener contacto de persona
     * @param personaDTO persona
     * @param contactoDTO contacto
     * @return  contacto s
     */
    public ContactoDTO obtenerContactoDTOPersona(PersonaDTO personaDTO, ContactoDTO contactoDTO);
}
