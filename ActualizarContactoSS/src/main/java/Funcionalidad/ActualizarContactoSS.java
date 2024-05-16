/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funcionalidad;

import DTOs.ContactoDTO;
import DTOs.PersonaDTO;
import Objetos.Interfaces.IObjetoNegocioContacto;
import Objetos.Interfaces.IObjetoNegocioPersona;
import Objetos.ObjetoNegocioContacto;
import Objetos.ObjetoNegocioPersona;
import java.util.List;

/**
 *
 * @author Dell
 */
public class ActualizarContactoSS implements IActualizarContactoSS {

    IObjetoNegocioContacto contacto;
    IObjetoNegocioPersona persona;

    public ActualizarContactoSS() {
        this.contacto = new ObjetoNegocioContacto();
        this.persona = new ObjetoNegocioPersona();
    }

    @Override
    public Boolean actualizar(PersonaDTO personaDTO, ContactoDTO contactoOrigiDTO, ContactoDTO contactoNuevoDTO) {
        if (personaDTO != null && contactoOrigiDTO != null && contactoNuevoDTO != null) {
            if (this.validaActualiza(personaDTO, contactoOrigiDTO, contactoNuevoDTO)) {
                Boolean valida = contacto.actualizar(personaDTO, contactoOrigiDTO, contactoNuevoDTO);
                return valida;
            }
        }

        return false;
    }

    private Boolean validaActualiza(PersonaDTO personaDTO, ContactoDTO contactoOrigiDTO, ContactoDTO contactoNuevoDTO) {
        PersonaDTO personaBuscada = persona.obtenerPersonaDTOPorCurp(personaDTO);
        Boolean bandera = false;

        List<ContactoDTO> listaContactos = personaBuscada.getListaContactos();

        if (listaContactos != null) {
            for (ContactoDTO conta : listaContactos) {
                if (conta.getAlias().equalsIgnoreCase(contactoOrigiDTO.getAlias())) {
                    bandera = true;
                }
            }
            if (bandera) {

                if (contactoNuevoDTO.getAlias() != null && contactoNuevoDTO.getApellidoP() != null && contactoNuevoDTO.getNombre() != null
                        && contactoNuevoDTO.getNumeroCuenta() != null && contactoNuevoDTO.getBanco() != null) {

                    return true;

                }
            }
        }
        return false;
    }
}
