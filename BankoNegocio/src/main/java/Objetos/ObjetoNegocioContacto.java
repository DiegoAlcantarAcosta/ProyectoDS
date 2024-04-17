/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

import DAOS.ContactoDAO;
import DTOs.ContactoDTO;
import DTOs.PersonaDTO;
import DTOs.tipoBancoDTO;
import Objetos.Interfaces.IObjetoNegocioContacto;
import entidades.Contacto;
import entidades.Persona;
import entidades.tipoBanco;
import interfaces.daos.IContactoDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell
 */
public class ObjetoNegocioContacto implements IObjetoNegocioContacto {

    IContactoDAO cd;

    public ObjetoNegocioContacto() {
        this.cd = new ContactoDAO();
    }

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

            ObjetoNegocioPersona onp = new ObjetoNegocioPersona();
            PersonaDTO personaDTO = onp.obtenerPersonaDTOPorCurp(contactoDTO.getPersona());
            Persona persona = onp.convertirDTOAEntidad(personaDTO);

            contacto.setPersona(persona);

            return contacto;
        } else {
            Contacto contacto = new Contacto();
            contacto.setAlias(contactoDTO.getAlias());
            ObjetoNegocioPersona onp = new ObjetoNegocioPersona();
            PersonaDTO personaDTO = onp.obtenerPersonaDTOPorCurp(contactoDTO.getPersona());
            Persona persona = onp.convertirDTOAEntidad(personaDTO);
            return contacto;

        }
//        Contacto contacto = new Contacto();
//        contacto.setAlias(contactoDTO.getAlias());
//        contacto.setApellidoM(contactoDTO.getApellidoM());
//        contacto.setApellidoP(contactoDTO.getApellidoP());
//
//        tipoBancoDTO banco = contactoDTO.getBanco();
//        tipoBanco banc;
//
//        switch (banco) {
//            case BANAMEX:
//                banc = tipoBanco.BANAMEX;
//                break;
//            case BANCOPPEL:
//                banc = tipoBanco.BANCOPPEL;
//                break;
//            case BANREGIO:
//                banc = tipoBanco.BANREGIO;
//                break;
//            case BBVA:
//                banc = tipoBanco.BBVA;
//                break;
//            case HSBC:
//                banc = tipoBanco.HSBC;
//                break;
//            case SANTANDER:
//                banc = tipoBanco.SANTANDER;
//                break;
//            // Añade casos para otros valores de tipoBanco si es necesario
//            default:
//                banc = tipoBanco.BANAMEX;
//        }
//
//        contacto.setBanco(banc);
//        contacto.setNombre(contactoDTO.getNombre());
//        contacto.setNumeroCuenta(contactoDTO.getNumeroCuenta());
//
//        ObjetoNegocioPersona onp = new ObjetoNegocioPersona();
//        PersonaDTO personaDTO = onp.obtenerPersonaDTOPorCurp(contactoDTO.getPersona());
//        Persona persona = onp.convertirDTOAEntidad(personaDTO);
//
//        contacto.setPersona(persona);

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

            ObjetoNegocioPersona onp = new ObjetoNegocioPersona();

            PersonaDTO personaCurp = new PersonaDTO(contacto.getPersona().getCurp());
            PersonaDTO personaDTO = onp.obtenerPersonaDTOPorCurp(personaCurp);

            contactoDTO.setPersona(personaDTO);

            return contactoDTO;

        } else {
            ContactoDTO contactoDTO = new ContactoDTO();
            contactoDTO.setAlias(contacto.getAlias());
            return contactoDTO;
        }

    }

    @Override
    public Boolean agregar(ContactoDTO contactoDTO) {
        Contacto contacto = this.convertirDTOAEntidad(contactoDTO);
        Boolean verifica = cd.agregar(contacto);
        return verifica;
    }

    @Override
    public Boolean eliminar(ContactoDTO contactoDTO) {
        Contacto contacto = this.convertirDTOAEntidad(contactoDTO);
        Boolean verifica = cd.eliminar(contacto);
        return verifica;
    }

    @Override
    public List<ContactoDTO> obtenerContactosDTOPersona(PersonaDTO personaDTO) {
        ObjetoNegocioPersona op = new ObjetoNegocioPersona();
        PersonaDTO personaBuscada = op.obtenerPersonaDTOPorCurp(personaDTO);
        Persona persona = op.convertirDTOAEntidad(personaBuscada);

        List<Contacto> listaEnt = cd.obtenerContactosPersona(persona);
        List<ContactoDTO> listaDTO = new ArrayList<>();

        for (Contacto contacto : listaEnt) {
            ContactoDTO contaClonDTO = this.convertirEntidadADTO(contacto);
            listaDTO.add(contaClonDTO);
        }
        return listaDTO;
    }

    @Override
    public ContactoDTO obtenerContactoDTOPersona(ContactoDTO contactoDTO, PersonaDTO personaDTO) {
        ObjetoNegocioPersona op = new ObjetoNegocioPersona();
        PersonaDTO personaBuscada = op.obtenerPersonaDTOPorCurp(personaDTO);
        Persona persona = op.convertirDTOAEntidad(personaBuscada);

        contactoDTO.setPersona(personaBuscada);

        Contacto contacto = this.convertirDTOAEntidad(contactoDTO);
        Contacto contactoBuscado = cd.obtenerContactoPersona(contacto, persona);
        ContactoDTO contactoConvert = this.convertirEntidadADTO(contactoBuscado);
        return contactoConvert;
    }

}
