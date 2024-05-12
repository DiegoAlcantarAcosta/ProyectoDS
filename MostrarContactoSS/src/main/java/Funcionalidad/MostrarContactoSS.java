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
public class MostrarContactoSS implements IMostrarContactoSS {

    IObjetoNegocioContacto contacto;

    public MostrarContactoSS() {
        contacto = new ObjetoNegocioContacto();
    }
    
    @Override
    public List<ContactoDTO> obtenerContactosDTOPersona(PersonaDTO personaDTO) {
        List<ContactoDTO> lista = contacto.obtenerContactosDTOPersona(personaDTO);
        return lista;
    }

    @Override
    public ContactoDTO obtenerContactoDTOPersona(ContactoDTO contactoDTO, PersonaDTO personaDTO) {
//       ContactoDTO lista = contacto.obtenerContactoDTOPersona( contactoDTO,personaDTO);
//        return lista;

    return null;
    }

}
