/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

import DAOS.PersonaDAO;
import DTOs.PersonaDTO;
import DTOs.TarjetaDTO;
import Objetos.Interfaces.IObjetoNegocioPersona;
import entidades.Persona;
import entidades.Tarjeta;
import interfaces.daos.IPersonaDAO;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Dell
 */
public class ObjetoNegocioPersona implements IObjetoNegocioPersona {

    IPersonaDAO pd;

    public ObjetoNegocioPersona() {
        this.pd = new PersonaDAO();
    }
    // Diego Alcantar
    public Persona convertirDTOAEntidad(PersonaDTO personaDTO) {
        ObjetoNegocioTarjeta ont = new ObjetoNegocioTarjeta();
        
        Persona persona = new Persona();
        persona.setNombre(personaDTO.getNombre());
        ObjectId id = new ObjectId("" + personaDTO.getId());
        persona.setId(id);
        persona.setApellidoP(personaDTO.getApellidoP());
        persona.setApellidoM(personaDTO.getApellidoM());
        persona.setFechaNac(personaDTO.getFechaNac());
        persona.setTelefono(personaDTO.getTelefono());
        persona.setCurp(personaDTO.getCurp());
        persona.setContrasena(personaDTO.getContrasena());
        
        List<TarjetaDTO> tarjetas = personaDTO.getListaTarjetas();
        List<Tarjeta> tarjetasResultado = new ArrayList<>();

        for (TarjetaDTO tarjetaDTO : tarjetas) {
            Tarjeta tarjeta = ont.convertirDTOAEntidad(tarjetaDTO);
            // Puedes agregar más asignaciones aquí si hay más atributos en la entidad Tarjeta
            tarjetasResultado.add(tarjeta);
        }
        
        persona.setListaTarjetas(tarjetasResultado);

        return persona;
    }
    // Diego Alcantar
    public Persona convertirDTOAEntidadCURP(PersonaDTO personaDTO) {
        Persona persona = new Persona();
        persona.setCurp(personaDTO.getCurp());
        return persona;
    }
    // Diego Alcantar
    public PersonaDTO convertirEntidadADTOCURP(Persona persona) {
        PersonaDTO personaDTO = new PersonaDTO();
        personaDTO.setCurp(persona.getCurp());
        return personaDTO;
    }
    // Diego Alcantar
    public PersonaDTO convertirEntidadADTO(Persona persona) {
        ObjetoNegocioTarjeta ont = new ObjetoNegocioTarjeta();
        PersonaDTO personaDTO = new PersonaDTO();
        personaDTO.setNombre(persona.getNombre());
        personaDTO.setId(new ObjectId("" + persona.getId()));
        personaDTO.setApellidoP(persona.getApellidoP());
        personaDTO.setApellidoM(persona.getApellidoM());
        personaDTO.setFechaNac(persona.getFechaNac());
        personaDTO.setTelefono(persona.getTelefono());
        personaDTO.setCurp(persona.getCurp());
        personaDTO.setContrasena(persona.getContrasena());

        List<Tarjeta> tarjetas = persona.getListaTarjetas();
        List<TarjetaDTO> tarjetasResultado = new ArrayList<>();

        for (Tarjeta tarjetaDTO : tarjetas) {
            TarjetaDTO tarjeta = ont.convertirEntidadADTO(tarjetaDTO);
            // Puedes agregar más asignaciones aquí si hay más atributos en la entidad Tarjeta
            tarjetasResultado.add(tarjeta);
        }
        
        personaDTO.setListaTarjetas(tarjetasResultado);

        
        return personaDTO;
    }

    @Override
    public Boolean registrar(PersonaDTO personaDTO) {
        Persona persona = this.convertirDTOAEntidad(personaDTO);
        Boolean registro = pd.registrar(persona);
        return registro;
    }
    // Diego Alcantar
    @Override
    public boolean personaRegistrada(PersonaDTO personaDTO) {
        Persona persona = this.convertirDTOAEntidad(personaDTO);
        boolean validar = pd.personaRegistrada(persona);
        return validar;
    }
    // Diego Alcantar
    @Override
    public PersonaDTO obtenerPersonaDTOPorCurp(PersonaDTO personaDTO) {
        Persona p = pd.obtenerPersonaPorCurp(convertirDTOAEntidadCURP(personaDTO));
        PersonaDTO personaConvert = this.convertirEntidadADTO(p);
        return personaConvert;
    }
    // Diego Alcantar
    @Override
    public Boolean procesarInicioSesion(String telefono, String contaseña) {
        return pd.procesarInicioSesion(telefono, contaseña);
    }
    // Diego Alcantar
    @Override
    public PersonaDTO obtenerPersonaPorTelefonoYContrasena(String telefono, String contrasena) {
        Persona persona = pd.obtenerPersonaPorTelefonoYContrasena(telefono, contrasena);
        PersonaDTO personaDTO = convertirEntidadADTO(persona);
        return personaDTO;
    }
}
