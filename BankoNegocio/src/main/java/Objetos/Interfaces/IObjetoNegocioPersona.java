/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Objetos.Interfaces;

import DTOs.PersonaDTO;
import entidades.Persona;

/**
 *
 * @author Dell
 */
public interface IObjetoNegocioPersona {
    
    /**
     * metodo para registrar persona
     * @param personaDTO persona
     * @return boolean
     */
    public Boolean registrar(PersonaDTO personaDTO);
    
    /**
     * metodo para verificar registro
     * @param personaDTO persona
     * @return boolean
     */
    public boolean personaRegistrada(PersonaDTO personaDTO);
    
    /**
     * metodo para obtner persona por curp
     * @param personaDTO persona
     * @return personadto
     */
    public PersonaDTO obtenerPersonaDTOPorCurp(PersonaDTO personaDTO);
    
    /**
     * metodo para procesar inicio de sesion
     * @param telefono tlelefono
     * @param contaseña contra
     * @return  boolean
     */
    public Boolean procesarInicioSesion(String telefono, String contaseña);
    
    /**
     * metodo para obtener telefono y contra
     * @param telefono telefono
     * @param contrasena cntra
     * @return personadto
     */
    public PersonaDTO obtenerPersonaPorTelefonoYContrasena(String telefono, String contrasena);
    
    /**
     * insert masivo
     * @return boolean
     */
    public Boolean insertMasivo();
}
