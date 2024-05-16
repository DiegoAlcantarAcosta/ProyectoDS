/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Funcionalidad;

import DTOs.PersonaDTO;
import DTOs.TarjetaDTO;
import java.util.List;

/**
 *
 * @author Diego
 */
public interface IMostrarTarjetasSS {

    public List<TarjetaDTO> obtenerTarjetasDTOPersona(PersonaDTO personaDTO);

}
