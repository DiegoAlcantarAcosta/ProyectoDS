/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package Funcionalidad;

import DTOs.PersonaDTO;
import Objetos.Interfaces.IObjetoNegocioPersona;
import Objetos.ObjetoNegocioPersona;

/**
 *
 * @author Diego
 */
public class IniciarSesionSS implements IIniciarSesionSS {

    IObjetoNegocioPersona persona;

    public IniciarSesionSS() {
        persona = new ObjetoNegocioPersona();
    }
    // Diego Alcantar
    @Override
    public Boolean procesarInicioSesion(String telefono, String contaseña) {
       return persona.procesarInicioSesion(telefono, contaseña);
    }
    // Diego Alcantar
    @Override
    public PersonaDTO obtenerPersonaPorTelefonoYContrasena(String telefono, String contrasena) {
        return persona.obtenerPersonaPorTelefonoYContrasena(telefono, contrasena);
    }
}
