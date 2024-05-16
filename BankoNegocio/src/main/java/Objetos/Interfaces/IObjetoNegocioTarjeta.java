/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Objetos.Interfaces;

import DTOs.PersonaDTO;
import DTOs.TarjetaDTO;
import Excepciones.PersistenciaException;
import entidades.Tarjeta;
import java.util.List;

/**
 *
 * @author Dell
 */
public interface IObjetoNegocioTarjeta {
    
    /**
     * metodo para obtener tarjetasdeto de persona
     * @param personaDTO oersonadto
     * @return  lista de tarjetas
     */
    public List<TarjetaDTO> obtenerTarjetasDTOPersona(PersonaDTO personaDTO);
    
    /**
     * obtener ultima persona 
     * @param personaDTO persona
     * @return  tarjetadto
     */
    public TarjetaDTO obtenerUltimaTarjetaDTOPersona(PersonaDTO personaDTO);
    
    /**
     * obtener tarjeta por numero
     * @param tarjetaDTO tarjeta
     * @return  tarjeta
     */
    public TarjetaDTO obtenerTarjetaDTOPorNumero(TarjetaDTO tarjetaDTO);
    
    /**
     * obtener todas lkas tarjetas
     * @return  lista de tarjetas
     */
        public List<TarjetaDTO> obtenerTodasLasTarjetasDeClientes();
        
        /**
         * metodo apra guardar una tarjeta
         * @param persona persona
         * @param tarjeta tarjeta
         * @throws PersistenciaException  error
         */
        public void guardar(PersonaDTO persona ,TarjetaDTO tarjeta) throws PersistenciaException;

        /**
         * metodo para actualizar tarjeta
         * @param persona persona
         * @param tarjeta tarjeta
         * @throws PersistenciaException error 
         */
    public void actualizar(PersonaDTO persona ,TarjetaDTO tarjeta) throws PersistenciaException;

    /**
     * metodo para eliminar tarjeta
     * @param persona persona
     * @param tarjeta tarjeta
     * @throws PersistenciaException error
     */
    public void eliminar(PersonaDTO persona ,TarjetaDTO tarjeta) throws PersistenciaException;
    
    /**
     * metodo para iobtener persona de una tarjeta
     * @param tarjeta tarjeta
     * @return  persona
     */
    public PersonaDTO obtenerPersonaDeTarjeta(TarjetaDTO tarjeta);

}
