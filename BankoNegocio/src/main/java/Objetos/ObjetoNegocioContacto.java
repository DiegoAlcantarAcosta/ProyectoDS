/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

import DAOS.ContactoDAO;
import DAOS.PersonaDAO;
import DTOs.ContactoDTO;
import DTOs.PersonaDTO;
import DTOs.tipoBancoDTO;
import Objetos.Interfaces.IObjetoNegocioContacto;
import encriptacion.Encriptador;
import encriptacion.IEncriptador;
import entidades.Contacto;
import entidades.Persona;
import entidades.tipoBanco;
import interfaces.daos.IContactoDAO;
import interfaces.daos.IPersonaDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell
 */
public class ObjetoNegocioContacto implements IObjetoNegocioContacto {

    IContactoDAO cd;
    IPersonaDAO pd;
    IEncriptador enc = new Encriptador();

    /**
     * Constructor inicializador
     */
    public ObjetoNegocioContacto() {
        this.cd = new ContactoDAO();
        this.pd = new PersonaDAO();
    }

    /**
     * Metodo para convertir una DTO a Entidad
     * @param contactoDTO contactoDTO
     * @return contacto entidad
     */
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

    /**
     * Metodo para convertir una entidad a DTO
     * @param contacto contacto entidad
     * @return contactoDTO
     */
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
            contactoDTO.setNumeroCuenta(enc.getAESDecrypt(contacto.getNumeroCuenta()));

            return contactoDTO;

        } else {
            ContactoDTO contactoDTO = new ContactoDTO();
            contactoDTO.setAlias(contacto.getAlias());
            return contactoDTO;
        }

    }

    /**
     * Metodo para agregar un contacto 
     * @param personaDTO persona
     * @param contactoDTO contacto
     * @return  true o false
     */
    @Override
    public Boolean agregar(PersonaDTO personaDTO, ContactoDTO contactoDTO) {
        Contacto contacto = this.convertirDTOAEntidad(contactoDTO);
        Persona persona = new Persona(personaDTO.getCurp());
        Persona personaBuscada = pd.obtenerPersonaPorCurp(persona);
        Boolean verifica = cd.agregar(personaBuscada, contacto);
        return verifica;
    }

    /**
     * Metodo para eliminar un contacto
     * @param personaDTO persona
     * @param contactoDTO contacto
     * @return  true o false
     */
    @Override
    public Boolean eliminar(PersonaDTO personaDTO, ContactoDTO contactoDTO) {
        Persona personaBuscada = pd.obtenerPersonaPorCurp(new Persona(personaDTO.getCurp()));
        Contacto contactoConvert = this.convertirDTOAEntidad(contactoDTO);
        Contacto contactoBuscado = cd.obtenerContactoPersona(personaBuscada, contactoConvert);
        Boolean verifica = cd.eliminar(personaBuscada, contactoBuscado);
        return verifica;
    }

    /**
     * Metodo para actualizar un contacto
     * @param personaDTO persona
     * @param contactoOrigiDTO contacto base
     * @param contactoNuevoDTO contacto actualizado
     * @return  true o false
     */
    @Override
    public Boolean actualizar(PersonaDTO personaDTO, ContactoDTO contactoOrigiDTO, ContactoDTO contactoNuevoDTO) {
        Persona personaBuscada = pd.obtenerPersonaPorCurp(new Persona(personaDTO.getCurp()));
        Contacto contactoOrConvert = this.convertirDTOAEntidad(contactoOrigiDTO);
        Contacto contactoNuConvert = this.convertirDTOAEntidad(contactoNuevoDTO);
        Contacto contactoOrBuscado = cd.obtenerContactoPersona(personaBuscada, contactoOrConvert);
        Boolean verifica = cd.actualizar(personaBuscada, contactoOrBuscado, contactoNuConvert);
        return verifica;
    }

    /**
     * Metodo para obtener los contactos de una persona
     * @param personaDTO persona
     * @return  lista de contactos
     */
    @Override
    public List<ContactoDTO> obtenerContactosDTOPersona(PersonaDTO personaDTO) {
        Persona personaBuscada = pd.obtenerPersonaPorCurp(new Persona(personaDTO.getCurp()));

        List<ContactoDTO> listaDTO = new ArrayList<>();
        if (personaBuscada != null && personaBuscada.getListaContactos() != null) {
            List<Contacto> listaEnt = personaBuscada.getListaContactos();

            for (Contacto contacto : listaEnt) {
                ContactoDTO contaClonDTO = this.convertirEntidadADTO(contacto);
                listaDTO.add(contaClonDTO);
            }
            return listaDTO;
        }

        return listaDTO;
    }

    /**
     * Metodo para obtener un contacto de una persona
     * @param personaDTO persona
     * @param contactoDTO contacto
     * @return  contactoDTO s
     */
    @Override
    public ContactoDTO obtenerContactoDTOPersona(PersonaDTO personaDTO, ContactoDTO contactoDTO) {

        Persona personaBuscada = pd.obtenerPersonaPorCurp(new Persona(personaDTO.getCurp()));

        Contacto contacto = this.convertirDTOAEntidad(contactoDTO);
        Contacto contactoBuscado = cd.obtenerContactoPersona(personaBuscada, contacto);
        ContactoDTO contactoConvert = this.convertirEntidadADTO(contactoBuscado);
        return contactoConvert;
    }

}
