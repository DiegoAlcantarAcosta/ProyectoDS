/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Funcionalidad;

import DTOs.PersonaDTO;


/**
 *
 * @author Diego
 */
public interface IIniciarSesionSS {
    public Boolean procesarInicioSesion(String telefono, String contaseña);
    
    public PersonaDTO obtenerPersonaPorTelefonoYContrasena(String telefono, String contrasena);
    
}
