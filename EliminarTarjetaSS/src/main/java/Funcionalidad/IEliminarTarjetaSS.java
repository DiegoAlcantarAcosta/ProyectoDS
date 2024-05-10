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
public interface IEliminarTarjetaSS {
    public void eliminar(PersonaDTO persona ,TarjetaDTO tarjeta) throws PersistenciaException;
}
