/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces.daos;

import entidades.Persona;

/**
 *
 * @author Diego
 */
public interface IPersonaDAO {

    public Boolean registrar(Persona persona);

    public boolean personaRegistrada(Persona persona);

    public Persona obtenerPersonaPorCurp(Persona persona);
}
