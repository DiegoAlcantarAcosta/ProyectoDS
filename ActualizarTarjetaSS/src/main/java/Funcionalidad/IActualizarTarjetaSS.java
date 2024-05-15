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
public interface IActualizarTarjetaSS {

    /**
     *  Metodo para actualizar la tarjeta de una persona
     * @param persona persona dueña
     * @param tarjeta tarjeta a editar
     * @throws PersistenciaException  excepcion
     */
    public void actualizar(PersonaDTO persona, TarjetaDTO tarjeta) throws PersistenciaException;

}
