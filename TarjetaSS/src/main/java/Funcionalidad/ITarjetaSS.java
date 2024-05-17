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
public interface ITarjetaSS {

    public TarjetaDTO obtenerTarjetaDTOPorNumero(TarjetaDTO tarjetaDTO);

    public List<TarjetaDTO> obtenerTarjetasDTOPersona(PersonaDTO personaDTO);

    public TarjetaDTO obtenerUltimaTarjetaDTOPersona(PersonaDTO personaDTO);

    public PersonaDTO obtenerPersonaDeTarjeta(TarjetaDTO tarjeta);

    public List<TarjetaDTO> obtenerTodasLasTarjetasDeClientes();
}
