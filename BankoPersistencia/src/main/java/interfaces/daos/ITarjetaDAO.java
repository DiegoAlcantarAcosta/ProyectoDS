/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces.daos;

import Excepciones.PersistenciaException;
import entidades.Persona;
import entidades.Tarjeta;
//import entidades.Transferencia;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author Diego
 */
public interface ITarjetaDAO {
    public Persona obtenerPersonaDeTarjeta(Tarjeta tarjeta);
    
    public List<Tarjeta> obtenerTodasLasTarjetasDeClientes();

    public List<Tarjeta> obtenerTarjetasPersona(Persona persona);
    
    public Tarjeta obtenerTarjetaPorNumero(Tarjeta tarjeta);
    
    public Tarjeta obtenerUltimaTarjetaPersona(Persona persona);
    
      public void guardar(Persona persona ,Tarjeta tarjeta) throws PersistenciaException;

    public void actualizarTarjeta(Persona persona, Tarjeta tarjeta);

    public void eliminar(Persona persona, Tarjeta tarjeta) throws PersistenciaException;
//    public boolean realizarTransferencia(Transferencia transferenciaa);
}
