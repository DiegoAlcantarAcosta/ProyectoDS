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
public class MostrarTarjetasSS implements IMostrarTarjetasSS {

    IObjetoNegocioTarjeta tarjeta;

    public MostrarTarjetasSS() {
       tarjeta = new ObjetoNegocioTarjeta();
    }

    @Override
    public List<TarjetaDTO> obtenerTarjetasDTOPersona(PersonaDTO personaDTO) {
        List<TarjetaDTO> lista = tarjeta.obtenerTarjetasDTOPersona(personaDTO);
        return lista;
    }
}
