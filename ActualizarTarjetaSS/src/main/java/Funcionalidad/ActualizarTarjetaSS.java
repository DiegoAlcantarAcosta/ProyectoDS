/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
public class ActualizarTarjetaSS implements IActualizarTarjetaSS {

     IObjetoNegocioTarjeta tarjeta;

    public ActualizarTarjetaSS() {
        tarjeta = new ObjetoNegocioTarjeta();
    }
    
    @Override
    public void actualizar(PersonaDTO persona, TarjetaDTO tarjeta) throws PersistenciaException {
       this.tarjeta.actualizar(persona, tarjeta);
    }
    
}
