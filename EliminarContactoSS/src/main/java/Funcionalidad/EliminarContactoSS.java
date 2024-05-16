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
public class EliminarContactoSS implements IEliminarContactoSS {

    IObjetoNegocioContacto contacto;
    IObjetoNegocioPersona persona;

    public EliminarContactoSS() {
        this.contacto = new ObjetoNegocioContacto();
        this.persona = new ObjetoNegocioPersona();
    }

    @Override
    public Boolean eliminar(PersonaDTO personaDTO, ContactoDTO contactoDTO) {

        if (personaDTO != null && contactoDTO != null) {
            if (this.validaElimina(personaDTO, contactoDTO)) {
                Boolean valida = contacto.eliminar(personaDTO, contactoDTO);
                return valida;
            }
        }

        return false;
    }

    private Boolean validaElimina(PersonaDTO personaDTO, ContactoDTO contactoDTO) {
        PersonaDTO personaBuscada = persona.obtenerPersonaDTOPorCurp(personaDTO);

        List<ContactoDTO> listaContactos = personaBuscada.getListaContactos();

        if (listaContactos != null) {

            for (ContactoDTO conta : listaContactos) {
                if (conta.getAlias().equalsIgnoreCase(contactoDTO.getAlias()) && conta.getApellidoP().equalsIgnoreCase(contactoDTO.getApellidoP())
                        && conta.getApellidoM().equalsIgnoreCase(contactoDTO.getApellidoM()) && conta.getNombre().equalsIgnoreCase(contactoDTO.getNombre())
                        && conta.getNumeroCuenta().equalsIgnoreCase(contactoDTO.getNumeroCuenta())
                        && conta.getBanco().equals(contactoDTO.getBanco())) {

                    return true;

                }
            }

            return false;

        }

        return false;
    }

}
