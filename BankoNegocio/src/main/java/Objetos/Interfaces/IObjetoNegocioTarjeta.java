/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Objetos.Interfaces;

import DTOs.PersonaDTO;
import DTOs.TarjetaDTO;
import java.util.List;

/**
 *
 * @author Dell
 */
public interface IObjetoNegocioTarjeta {
    
    public List<TarjetaDTO> obtenerTarjetasDTOPersona(PersonaDTO personaDTO);
    
    public TarjetaDTO obtenerUltimaTarjetaDTOPersona(PersonaDTO personaDTO);
    
    public TarjetaDTO obtenerTarjetaDTOPorNumero(TarjetaDTO tarjetaDTO);
    
}
