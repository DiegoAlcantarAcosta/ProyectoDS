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
public class AnadirTarjetaSS implements IAnadirTarjetaSS {

     IObjetoNegocioTarjeta tarjeta;

     /**
     * Constructor que inicializa el objeto de negocio necesario para añadir tarjetas.
     */
    public AnadirTarjetaSS() {
        tarjeta = new ObjetoNegocioTarjeta();
    }
    
     /**
     * Guarda la información de una tarjeta asociada a una persona.
     * 
     * @param persona La información de la persona.
     * @param tarjeta La información de la tarjeta.
     * @throws PersistenciaException Si ocurre un error durante la persistencia de la tarjeta.
     */
    @Override
    public void guardar(PersonaDTO persona, TarjetaDTO tarjeta) throws PersistenciaException {
       this.tarjeta.guardar(persona, tarjeta);
    }
    
}
