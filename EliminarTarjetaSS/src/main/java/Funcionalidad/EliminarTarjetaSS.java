/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package Funcionalidad;

import DTOs.PersonaDTO;
import DTOs.TarjetaDTO;
import Excepciones.PersistenciaException;
import Objetos.Interfaces.IObjetoNegocioTarjeta;
import Objetos.ObjetoNegocioTarjeta;

/**
 *
 * @author Diego
 */
public class EliminarTarjetaSS implements  IEliminarTarjetaSS{

     IObjetoNegocioTarjeta tarjeta;

    public EliminarTarjetaSS() {
        tarjeta = new ObjetoNegocioTarjeta();
    }
    // Diego Alcantar
    @Override
    public void eliminar(PersonaDTO persona ,TarjetaDTO tarjeta) throws PersistenciaException {
        this.tarjeta.eliminar(persona ,tarjeta);
    }

    
}
