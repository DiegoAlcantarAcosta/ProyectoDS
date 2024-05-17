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

      /**
     * Constructor que inicializa el objeto de negocio necesario para la actualización de tarjetas.
     */
    public ActualizarTarjetaSS() {
        tarjeta = new ObjetoNegocioTarjeta();
    }
   
    /**
     * Actualiza la información de una tarjeta para una persona específica.
     * 
     * @param persona La información de la persona.
     * @param tarjeta La nueva información de la tarjeta.
     * @throws PersistenciaException Si ocurre un error durante la persistencia de la actualización.
     */
    @Override
    public void actualizar(PersonaDTO persona, TarjetaDTO tarjeta) throws PersistenciaException {
       this.tarjeta.actualizar(persona, tarjeta);
    }
    
}
