/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package Funcionalidad;

import DTOs.ContactoDTO;
import DTOs.PersonaDTO;
import DTOs.TarjetaDTO;
import Objetos.Interfaces.IObjetoNegocioContacto;
import Objetos.Interfaces.IObjetoNegocioPersona;
import Objetos.Interfaces.IObjetoNegocioTarjeta;
import Objetos.ObjetoNegocioContacto;
import Objetos.ObjetoNegocioPersona;
import Objetos.ObjetoNegocioTarjeta;
import java.util.List;

/**
 * ya jala wey
 * @author Diego
 */
public class AnadirContactoSS implements IAnadirContactoSS {

    IObjetoNegocioContacto contacto;
    IObjetoNegocioPersona persona;

    public AnadirContactoSS() {
        contacto = new ObjetoNegocioContacto();
        persona = new ObjetoNegocioPersona();

    }

    @Override
    public Boolean agregar(PersonaDTO personaDTO, ContactoDTO contactoDTO) {
        if (personaDTO != null && contactoDTO != null) {
            if (this.validaAgrega(personaDTO, contactoDTO)) {
                Boolean confi = contacto.agregar(personaDTO, contactoDTO);
                return confi;
            }
        }

        return false;
    }

    private Boolean validaAgrega(PersonaDTO personaDTO, ContactoDTO contactoDTO) {
        PersonaDTO personaBuscada = persona.obtenerPersonaDTOPorCurp(personaDTO);

        List<ContactoDTO> listaContactos = personaBuscada.getListaContactos();

        if (listaContactos != null) {

            for (ContactoDTO conta : listaContactos) {
                if (conta.getAlias().equalsIgnoreCase(contactoDTO.getAlias())
                        || conta.getNumeroCuenta().equals(contactoDTO.getNumeroCuenta())) {

                    return false;

                }
            }

        }

        return true;
    }

}
