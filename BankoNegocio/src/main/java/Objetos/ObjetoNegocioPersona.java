/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

import DAOS.PersonaDAO;
import DTOs.ContactoDTO;
import DTOs.PersonaDTO;
import DTOs.TarjetaDTO;
import DTOs.tipoBancoDTO;
import Objetos.Interfaces.IObjetoNegocioPersona;
import entidades.Contacto;
import entidades.Persona;
import entidades.Tarjeta;
import entidades.tipoBanco;
import static entidades.tipoBanco.BANAMEX;
import static entidades.tipoBanco.BANCOPPEL;
import static entidades.tipoBanco.BANREGIO;
import static entidades.tipoBanco.BBVA;
import static entidades.tipoBanco.HSBC;
import static entidades.tipoBanco.SANTANDER;
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


        List<ContactoDTO> contactos = personaDTO.getListaContactos();
        List<Contacto> contactosResultado = new ArrayList<>();
        if (contactos != null) {
            for (ContactoDTO contactoDTO : contactos) {
                Contacto contacto = this.convertirDTOAEntidad(contactoDTO);
                // Puedes agregar más asignaciones aquí si hay más atributos en la entidad Tarjeta
                contactosResultado.add(contacto);
            }

            persona.setListaContactos(contactosResultado);
        }
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
            // Puedes agregar más asignaciones aquí si hay más atributos en la entidad Tarjeta aa
            tarjetasResultado.add(tarjeta);
        }

        personaDTO.setListaTarjetas(tarjetasResultado);

        
        List<Contacto> contactos = persona.getListaContactos();
        List<ContactoDTO> contactosResultado = new ArrayList<>();

        if (persona.getListaContactos() != null) {
            for (Contacto conta : contactos) {
                ContactoDTO contactoDTO = this.convertirEntidadADTO(conta);
                contactosResultado.add(contactoDTO);
            }

            personaDTO.setListaContactos(contactosResultado);
        }

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
    
    // Contacto convercion
    public Contacto convertirDTOAEntidad(ContactoDTO contactoDTO) {
        if (contactoDTO.getBanco() != null) {
            Contacto contacto = new Contacto();
            contacto.setAlias(contactoDTO.getAlias());
            contacto.setApellidoM(contactoDTO.getApellidoM());
            contacto.setApellidoP(contactoDTO.getApellidoP());

            tipoBancoDTO banco = contactoDTO.getBanco();
            tipoBanco banc;
            switch (banco) {
                case BANAMEX:
                    banc = tipoBanco.BANAMEX;
                    break;
                case BANCOPPEL:
                    banc = tipoBanco.BANCOPPEL;
                    break;
                case BANREGIO:
                    banc = tipoBanco.BANREGIO;
                    break;
                case BBVA:
                    banc = tipoBanco.BBVA;
                    break;
                case HSBC:
                    banc = tipoBanco.HSBC;
                    break;
                case SANTANDER:
                    banc = tipoBanco.SANTANDER;
                    break;
                // Añade casos para otros valores de tipoBanco si es necesario
                default:
                    banc = tipoBanco.BANAMEX;
            }

            contacto.setBanco(banc);
            contacto.setNombre(contactoDTO.getNombre());
            contacto.setNumeroCuenta(contactoDTO.getNumeroCuenta());

            return contacto;
        } else {
            Contacto contacto = new Contacto();
            contacto.setAlias(contactoDTO.getAlias());
            return contacto;

        }
    }

    public ContactoDTO convertirEntidadADTO(Contacto contacto) {
        if (contacto.getBanco() != null) {
            ContactoDTO contactoDTO = new ContactoDTO();
            contactoDTO.setAlias(contacto.getAlias());
            contactoDTO.setApellidoM(contacto.getApellidoM());
            contactoDTO.setApellidoP(contacto.getApellidoP());

            tipoBanco banco = contacto.getBanco();
            tipoBancoDTO banc;

            switch (banco) {
                case BANAMEX:
                    banc = tipoBancoDTO.BANAMEX;
                    break;
                case BANCOPPEL:
                    banc = tipoBancoDTO.BANCOPPEL;
                    break;
                case BANREGIO:
                    banc = tipoBancoDTO.BANREGIO;
                    break;
                case BBVA:
                    banc = tipoBancoDTO.BBVA;
                    break;
                case HSBC:
                    banc = tipoBancoDTO.HSBC;
                    break;
                case SANTANDER:
                    banc = tipoBancoDTO.SANTANDER;
                    break;
                // Añade casos para otros valores de tipoBanco si es necesario
                default:
                    banc = null;
            }

            //tipoBancoDTO banc = (tipoBancoDTO) banco;
            contactoDTO.setBanco(banc);
            contactoDTO.setNombre(contacto.getNombre());
            contactoDTO.setNumeroCuenta(contacto.getNumeroCuenta());

            return contactoDTO;

        } else {
            ContactoDTO contactoDTO = new ContactoDTO();
            contactoDTO.setAlias(contacto.getAlias());
            return contactoDTO;
        }

    }
}
