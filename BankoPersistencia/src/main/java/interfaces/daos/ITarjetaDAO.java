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
    
    
    public List<Tarjeta> obtenerTodasLasTarjetasDeClientes();

    public List<Tarjeta> obtenerTarjetasPersona(Persona persona);
    
    public Tarjeta obtenerTarjetaPorNumero(Tarjeta tarjeta);
    
    public Tarjeta obtenerUltimaTarjetaPersona(Persona persona);
    
      public void guardar(Tarjeta tarjeta) throws PersistenciaException;

    public void actualizar(Tarjeta tarjeta) throws PersistenciaException;

    public void eliminar(Tarjeta tarjeta) throws PersistenciaException;
//    public boolean realizarTransferencia(Transferencia transferenciaa);
}
