/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Funcionalidad;

import DTOs.PersonaDTO;
import DTOs.TarjetaDTO;
import Excepciones.PersistenciaException;

/**
 *
 * @author Diego
 */
public interface IAnadirTarjetaSS {
    
    /**
     * Metodo para añadirle una tarjeta a una persona
     * @param persona persona a la que se añade
     * @param tarjeta tarjeta que se añadira
     * @throws PersistenciaException  en caso de error
     */
    public void guardar(PersonaDTO persona ,TarjetaDTO tarjeta) throws PersistenciaException;
}
