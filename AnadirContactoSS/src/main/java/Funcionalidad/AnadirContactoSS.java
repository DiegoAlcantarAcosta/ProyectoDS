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
import java.util.List;

/**
 *
 * @author Diego
 */
public class AnadirContactoSS implements IAnadirContactoSS {

    IObjetoNegocioContacto contacto;
    IObjetoNegocioPersona persona;

    /**
     * Constructor que inicializa los objetos de negocio necesarios para agregar contactos.
     */
    public AnadirContactoSS() {
        contacto = new ObjetoNegocioContacto();
        persona = new ObjetoNegocioPersona();

    }

    /**
     * Agrega un nuevo contacto a una persona específica.
     * 
     * @param personaDTO La información de la persona.
     * @param contactoDTO La información del nuevo contacto.
     * @return {@code true} si la adición es exitosa, {@code false} en caso contrario.
     */
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

    /**
     * Valida si la información del nuevo contacto puede ser agregada.
     * 
     * @param personaDTO La información de la persona.
     * @param contactoDTO La información del nuevo contacto.
     * @return {@code true} si la validación es exitosa y el contacto puede ser agregado, {@code false} en caso contrario.
     */
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
