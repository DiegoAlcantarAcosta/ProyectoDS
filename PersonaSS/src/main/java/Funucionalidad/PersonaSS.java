/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package Funucionalidad;

import DTOs.PersonaDTO;
import Objetos.Interfaces.IObjetoNegocioPersona;
import Objetos.ObjetoNegocioPersona;

/**
 *
 * @author Diego
 */
public class PersonaSS implements IPersonaSS {

     IObjetoNegocioPersona persona;

    public PersonaSS() {
        persona = new ObjetoNegocioPersona();
    }
    
    @Override
    public Boolean registrar(PersonaDTO personaDTO) {
       return persona.registrar(personaDTO);
    }
    // Diego Alcantar
    @Override
    public boolean personaRegistrada(PersonaDTO personaDTO) {
       return persona.personaRegistrada(personaDTO);
    }
    // Diego Alcantar
    @Override
    public PersonaDTO obtenerPersonaDTOPorCurp(PersonaDTO personaDTO) {
       PersonaDTO personaDTObuscada = persona.obtenerPersonaDTOPorCurp(personaDTO);
        return personaDTObuscada;
    }
    
    public Boolean insertMasivo(){
        return persona.insertMasivo();
    }
}
