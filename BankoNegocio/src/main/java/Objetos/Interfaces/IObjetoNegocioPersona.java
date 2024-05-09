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
    
    public Boolean registrar(PersonaDTO personaDTO);
    
    public boolean personaRegistrada(PersonaDTO personaDTO);
    
    public PersonaDTO obtenerPersonaDTOPorCurp(PersonaDTO personaDTO);
    
    public Boolean procesarInicioSesion(String telefono, String contaseña);
    
    public PersonaDTO obtenerPersonaPorTelefonoYContrasena(String telefono, String contrasena);
}
