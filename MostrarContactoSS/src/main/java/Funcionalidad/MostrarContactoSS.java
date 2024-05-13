/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package Funcionalidad;

import DTOs.ContactoDTO;
import DTOs.PersonaDTO;
import Objetos.Interfaces.IObjetoNegocioContacto;
import Objetos.Interfaces.IObjetoNegocioPersona;
import Objetos.ObjetoNegocioContacto;
import Objetos.ObjetoNegocioPersona;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Diego
 */
public class MostrarContactoSS implements IMostrarContactoSS {

    IObjetoNegocioContacto contacto;
    IObjetoNegocioPersona persona;

    public MostrarContactoSS() {
        contacto = new ObjetoNegocioContacto();
        persona = new ObjetoNegocioPersona();
    }

    @Override
    public List<ContactoDTO> obtenerContactosDTOPersona(PersonaDTO personaDTO) {
        if (personaDTO != null) {
            if (personaDTO.getCurp() != null) {
                List<ContactoDTO> lista = contacto.obtenerContactosDTOPersona(personaDTO);
                return lista;
            }
        }
        return null;
    }

    @Override
    public ContactoDTO obtenerContactoDTOPersona(PersonaDTO personaDTO, ContactoDTO contactoDTO) {
        if (personaDTO != null && contactoDTO != null) {
            if (personaDTO.getCurp() != null && contactoDTO.getAlias() != null
                    && this.validaMuestra(personaDTO, contactoDTO) == true) {
                ContactoDTO contactoBuscado = contacto.obtenerContactoDTOPersona(personaDTO, contactoDTO);
                return contactoBuscado;
            }
        }
        return null;
    }

    private Boolean validaMuestra(PersonaDTO personaDTO, ContactoDTO contactoDTO) {
        PersonaDTO personaBuscada = persona.obtenerPersonaDTOPorCurp(personaDTO);

        if (personaBuscada != null && personaBuscada.getListaContactos() != null) {
            List<ContactoDTO> listaContactos = personaBuscada.getListaContactos();

            for (ContactoDTO conta : listaContactos) {
                if (conta.getAlias().equalsIgnoreCase(contactoDTO.getAlias())) {
                    return true;
                }
            }
        }

        return false;
    }

}
