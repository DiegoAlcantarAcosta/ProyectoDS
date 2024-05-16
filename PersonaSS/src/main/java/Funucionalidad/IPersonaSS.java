/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Funucionalidad;

import DTOs.PersonaDTO;

/**
 *
 * @author Diego
 */
public interface IPersonaSS {
    public Boolean registrar(PersonaDTO personaDTO);
    
    public boolean personaRegistrada(PersonaDTO personaDTO);
    
    public PersonaDTO obtenerPersonaDTOPorCurp(PersonaDTO personaDTO);
    
    public Boolean insertMasivo();
}
