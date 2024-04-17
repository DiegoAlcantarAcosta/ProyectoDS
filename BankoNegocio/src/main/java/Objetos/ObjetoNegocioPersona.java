/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

import DAOS.PersonaDAO;
import DTOs.PersonaDTO;
import Objetos.Interfaces.IObjetoNegocioPersona;
import entidades.Persona;
import interfaces.daos.IPersonaDAO;

/**
 *
 * @author Dell
 */
public class ObjetoNegocioPersona implements IObjetoNegocioPersona {

    IPersonaDAO pd;

    public ObjetoNegocioPersona() {
        this.pd = new PersonaDAO();
    }

    public Persona convertirDTOAEntidad(PersonaDTO personaDTO) {
        Persona persona = new Persona();
        persona.setNombre(personaDTO.getNombre());
        persona.setApellidoP(personaDTO.getApellidoP());
        persona.setApellidoM(personaDTO.getApellidoM());
        persona.setFechaNac(personaDTO.getFechaNac());
        persona.setTelefono(personaDTO.getTelefono());
        persona.setCurp(personaDTO.getCurp());

        return persona;
    }

   
    public PersonaDTO convertirEntidadADTO(Persona persona) {
        PersonaDTO personaDTO = new PersonaDTO();
        personaDTO.setNombre(persona.getNombre());
        personaDTO.setApellidoP(persona.getApellidoP());
        personaDTO.setApellidoM(persona.getApellidoM());
        personaDTO.setFechaNac(persona.getFechaNac());
        personaDTO.setTelefono(persona.getTelefono());
        personaDTO.setCurp(persona.getCurp());

        return personaDTO;
    }

    @Override
    public Boolean registrar(PersonaDTO personaDTO) {
        Persona persona = this.convertirDTOAEntidad(personaDTO);
        Boolean registro = pd.registrar(persona);
        return registro;
    }

    @Override
    public boolean personaRegistrada(PersonaDTO personaDTO) {
        Persona persona = this.convertirDTOAEntidad(personaDTO);
        boolean validar = pd.personaRegistrada(persona);
        return validar;
    }

    @Override
    public PersonaDTO obtenerPersonaDTOPorCurp(PersonaDTO personaDTO) {
        //Persona persona = this.convertirDTOAEntidad(personaDTO);
        Persona persona = new Persona(personaDTO.getCurp());
        Persona personaBuscada = pd.obtenerPersonaPorCurp(persona);
        PersonaDTO personaConvert = this.convertirEntidadADTO(personaBuscada);
        return personaConvert;
    }
}
