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
    
    public List<TarjetaDTO> obtenerTarjetasDTOPersona(PersonaDTO personaDTO);
    
    public TarjetaDTO obtenerUltimaTarjetaDTOPersona(PersonaDTO personaDTO);
    
    public TarjetaDTO obtenerTarjetaDTOPorNumero(TarjetaDTO tarjetaDTO);
    
        public List<TarjetaDTO> obtenerTodasLasTarjetasDeClientes();
        
        public void guardar(PersonaDTO persona ,TarjetaDTO tarjeta) throws PersistenciaException;

    public void actualizar(TarjetaDTO tarjeta) throws PersistenciaException;

    public void eliminar(PersonaDTO persona ,TarjetaDTO tarjeta) throws PersistenciaException;
    
    public PersonaDTO obtenerPersonaDeTarjeta(TarjetaDTO tarjeta);

}
