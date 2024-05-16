/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces.daos;

import entidades.Persona;
import java.util.List;

/**
 *
 * @author Diego
 */
public interface IPersonaDAO {

    public Boolean procesarInicioSesion(String telefono, String contaseña);
    
    public Persona obtenerPersonaPorTelefonoYContrasena(String telefono, String contrasena);
    
    public Boolean registrar(Persona persona);

    public boolean personaRegistrada(Persona persona);

    public Persona obtenerPersonaPorCurp(Persona persona);
    
    public List<Persona> obtenerTodasLasPersonas();
    
    public Boolean insertMasivo();
}
