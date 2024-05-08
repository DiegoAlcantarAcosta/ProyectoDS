/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOS;

import Conexion.Conexion;
import Excepciones.PersistenciaException;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import entidades.Persona;
import entidades.Tarjeta;
import interfaces.daos.ITarjetaDAO;
import java.util.List;
import org.bson.conversions.Bson;

/**
 *
 * @author Diego
 */
public class TarjetaDAO implements ITarjetaDAO {

    private final MongoCollection<Tarjeta> coleccionTarjetas;

    public TarjetaDAO() {
        this.coleccionTarjetas = Conexion.getDatabase().getCollection("Tarjetas", Tarjeta.class);
    }

    @Override
    public List<Tarjeta> obtenerTarjetasPersona(Persona persona) {
        if (persona.getListaTarjetas().isEmpty()) {
            return null; // Si la persona no tiene tarjetas, devuelve null
        } else {
            return persona.getListaTarjetas();
        }
    }

    @Override
    public Tarjeta obtenerUltimaTarjetaPersona(Persona persona) {
        List<Tarjeta> tarjetas = persona.getListaTarjetas();
        if (tarjetas.isEmpty()) {
            return null; // Si la persona no tiene tarjetas, devuelve null
        }
        return tarjetas.get(tarjetas.size() - 1); // Devuelve la última tarjeta de la lista
    }

    @Override
    public Tarjeta obtenerTarjetaPorNumero(Tarjeta tarjeta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

//   public boolean realizarTransferencia(Transferencia transferenciaa) {
//    EntityManager em = conexion.abrir();
//    try {
//        em.getTransaction().begin();
//
//        // Obtener la tarjeta del propietario
//        Tarjeta tarjetaPropietario = obtenerTarjetaPorNumero(new Tarjeta(transferenciaa.getNumeroCuentaPropietario()));
//
//        // Validar que el saldo sea suficiente
//        if (tarjetaPropietario.getSaldo() >= transferenciaa.getImporte()) {
//            // Realizar la transferencia
//            tarjetaPropietario.setSaldo(tarjetaPropietario.getSaldo() - transferenciaa.getImporte());
//            em.merge(tarjetaPropietario);
//
//            // Obtener la tarjeta del destinatario
//            Tarjeta tarjetaDestinatario = obtenerTarjetaPorNumero(new Tarjeta(transferenciaa.getNumeroCuentaDestinatario()));
//            tarjetaDestinatario.setSaldo(tarjetaDestinatario.getSaldo() + transferenciaa.getImporte());
//            em.merge(tarjetaDestinatario);
//
//            // Guardar la transferencia
//            transferenciaa.setFechaMovimiento(new Date());
//            transferenciaa.setTarjeta(tarjetaPropietario);
//            transferenciaa.setPersona(tarjetaPropietario.getPersona());
//            em.persist(transferenciaa);
//
//            em.getTransaction().commit();
//            return true;
//        } else {
//            return false;
//        }
//    } catch (Exception e) {
//        em.getTransaction().rollback();
//        throw e;
//    } finally {
//        em.close();
//    }
//    
//    }
    @Override
    public void guardar(Tarjeta tarjeta) {
        try {
            this.coleccionTarjetas.insertOne(tarjeta);
        } catch (MongoException e) {
            System.out.println(e);
        }
    }

    @Override
    public void actualizar(Tarjeta tarjeta) {
        Bson filtroID = Filters.eq("_id", tarjeta.getId());
        try {
            coleccionTarjetas.replaceOne(filtroID, tarjeta);
        } catch (MongoException e) {
            System.out.println(e);
        }
    }

    @Override
    public void eliminar(Tarjeta tarjeta) {
        try {
            coleccionTarjetas.deleteOne(Filters.eq("_id", tarjeta.getId()));
        } catch (MongoException e) {
            System.out.println(e);
        }
    }

}
