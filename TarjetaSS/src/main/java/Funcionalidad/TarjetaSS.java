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

    @Override
    public TarjetaDTO obtenerTarjetaDTOPorNumero(TarjetaDTO tarjetaDTO) {
        TarjetaDTO t = tarjeta.obtenerTarjetaDTOPorNumero(tarjetaDTO);
        return t;
    }

    @Override
    public List<TarjetaDTO> obtenerTarjetasDTOPersona(PersonaDTO personaDTO) {
        List<TarjetaDTO> tarjetas = tarjeta.obtenerTarjetasDTOPersona(personaDTO);
        return tarjetas;
    }

    @Override
    public TarjetaDTO obtenerUltimaTarjetaDTOPersona(PersonaDTO personaDTO) {
        TarjetaDTO t = tarjeta.obtenerUltimaTarjetaDTOPersona(personaDTO);
        return t;
    }
}
