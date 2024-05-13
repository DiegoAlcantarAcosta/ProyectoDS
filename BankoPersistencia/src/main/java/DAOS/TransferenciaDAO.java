/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOS;

import Conexion.Conexion;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import entidades.Persona;
import entidades.Tarjeta;
import entidades.Transferencia;
import interfaces.daos.ITarjetaDAO;
import interfaces.daos.ITransferenciaDAO;
import java.util.Date;

/**
 *
 * @author Wilber
 */
public class TransferenciaDAO implements ITransferenciaDAO{
    
    MongoCollection<Persona> coleccionPersonas;
    ITarjetaDAO td;

    public TransferenciaDAO() {
        coleccionPersonas = Conexion.getDatabase().getCollection("Personas", Persona.class);
        td = new TarjetaDAO();
    }
    
    
@Override
public boolean realizarTransferencia(Transferencia transferencia) {
    try {
        // Validar que las tarjetas sean diferentes
        if (transferencia.getNumeroCuentaDestinatario().equals(transferencia.getNumeroCuentaPropietario())) {
            return false;
        }

        // Obtener las tarjetas involucradas
        Tarjeta tarjetaPropietario = td.obtenerTarjetaPorNumero(new Tarjeta(transferencia.getNumeroCuentaPropietario()));
        Tarjeta tarjetaDestinatario = td.obtenerTarjetaPorNumero(new Tarjeta(transferencia.getNumeroCuentaDestinatario()));

        // Obtener las personas involucradas
        Persona personaRemitente = td.obtenerPersonaDeTarjeta(tarjetaPropietario);
        Persona personaDestinatario = td.obtenerPersonaDeTarjeta(tarjetaDestinatario);

        // Validar que se encontraron las personas y que tienen suficiente saldo
        if (personaRemitente == null || personaDestinatario == null) {
            return false;
        }


        if (tarjetaPropietario == null || tarjetaPropietario.getSaldo() < transferencia.getImporte()) {
            return false;
        }

        tarjetaPropietario.setSaldo(tarjetaPropietario.getSaldo() - transferencia.getImporte());
        tarjetaDestinatario.setSaldo(tarjetaDestinatario.getSaldo() +  transferencia.getImporte());
        
         coleccionPersonas.updateOne(
                Filters.and(
                        Filters.eq("_id", personaRemitente.getId()),
                        Filters.eq("listaTarjetas._id", tarjetaPropietario.getId())
                ),
                Updates.set("listaTarjetas.$", tarjetaPropietario)
        );
         
         coleccionPersonas.updateOne(
                Filters.and(
                        Filters.eq("_id", personaDestinatario.getId()),
                        Filters.eq("listaTarjetas._id", tarjetaDestinatario.getId())
                ),
                Updates.set("listaTarjetas.$", tarjetaDestinatario)
        );

        // Guardar la transferencia
        transferencia.setFechaMovimiento(new Date());
        MongoCollection<Transferencia> coleccionTransferencias = Conexion.getDatabase().getCollection("Transferencias", Transferencia.class);
        coleccionTransferencias.insertOne(transferencia);

        return true;
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
}

    
    
}
