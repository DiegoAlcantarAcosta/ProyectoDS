/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package Funcionalidad;

import DTOs.PersonaDTO;
import DTOs.TarjetaDTO;
import Objetos.Interfaces.IObjetoNegocioTarjeta;
import Objetos.ObjetoNegocioTarjeta;
import java.util.List;

/**
 *
 * @author Diego
 */
public class TarjetaSS implements ITarjetaSS {

    IObjetoNegocioTarjeta tarjeta;

    public TarjetaSS() {
        tarjeta = new ObjetoNegocioTarjeta();
    }
    // Diego Alcantar
    @Override
    public TarjetaDTO obtenerTarjetaDTOPorNumero(TarjetaDTO tarjetaDTO) {
        TarjetaDTO t = tarjeta.obtenerTarjetaDTOPorNumero(tarjetaDTO);
        return t;
    }
    // Diego Alcantar
    @Override
    public List<TarjetaDTO> obtenerTarjetasDTOPersona(PersonaDTO personaDTO) {
        return personaDTO.getListaTarjetas();
    }
    // Diego Alcantar
    @Override
    public TarjetaDTO obtenerUltimaTarjetaDTOPersona(PersonaDTO personaDTO) {
        TarjetaDTO t = tarjeta.obtenerUltimaTarjetaDTOPersona(personaDTO);
        return t;
    }
    // Diego Alcantar
    @Override
    public PersonaDTO obtenerPersonaDeTarjeta(TarjetaDTO tarjetaDTO) {
       return this.tarjeta.obtenerPersonaDeTarjeta(tarjetaDTO);
    }
    // Diego Alcantar
    @Override
    public List<TarjetaDTO> obtenerTodasLasTarjetasDeClientes() {
      return tarjeta.obtenerTodasLasTarjetasDeClientes();
    }
}
