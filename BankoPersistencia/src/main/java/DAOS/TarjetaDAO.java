/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOS;

import Conexion.Conexion;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import encriptacion.Encriptador;
import encriptacion.IEncriptador;
import entidades.Persona;
import entidades.Tarjeta;
import interfaces.daos.ITarjetaDAO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author Diego
 */
public class TarjetaDAO implements ITarjetaDAO {

    private final MongoCollection<Persona> coleccionPersonas;
    private Encriptador enc = new Encriptador();

    public TarjetaDAO() {
        this.coleccionPersonas = Conexion.getDatabase().getCollection("Personas", Persona.class);
    }

    // Diego Alcantar
    @Override
    public List<Tarjeta> obtenerTarjetasPersona(Persona persona) {
      List<Tarjeta> tarjetas = new ArrayList<>();
        if (persona != null) {
            Persona personaEncontrada = coleccionPersonas.find(new Document("_id", persona.getId())).first();
            if (personaEncontrada != null) {
                tarjetas = personaEncontrada.getListaTarjetas();
            }
        }
        return tarjetas;
    }
    

    // Diego Alcantar
    @Override
    public Tarjeta obtenerUltimaTarjetaPersona(Persona persona) {
        List<Tarjeta> tarjetas = persona.getListaTarjetas();
        if (tarjetas.isEmpty()) {
            return null; // Si la persona no tiene tarjetas, devuelve null
        }
        return tarjetas.get(tarjetas.size() - 1); // Devuelve la última tarjeta de la lista
    }

    // Diego Alcantar
    @Override
    public Tarjeta obtenerTarjetaPorNumero(Tarjeta tarjeta) {
        try {
            tarjeta.setNumeroCuenta(enc.getAES(tarjeta.getNumeroCuenta()));
            List<Tarjeta> listaTarjetas = obtenerTodasLasTarjetasDeClientes();
            for (int i = 0; i < listaTarjetas.size(); i++) {
                if (tarjeta.getNumeroCuenta().equalsIgnoreCase(listaTarjetas.get(i).getNumeroCuenta())) {
                    return listaTarjetas.get(i);
                }
            }
        } catch (MongoException e) {
            System.out.println(e);
        }
        return null;
    }
// Diego Alcantar

    @Override
    public void guardar(Persona persona, Tarjeta tarjeta) {
        coleccionPersonas.updateOne(Filters.eq("_id", persona.getId()), Updates.push("listaTarjetas", tarjeta));
    }
// Diego Alcantar

    @Override
    public void actualizarTarjeta(Persona persona, Tarjeta tarjeta) {
        coleccionPersonas.updateOne(
                Filters.and(
                        Filters.eq("_id", persona.getId()),
                        Filters.eq("listaTarjetas._id", tarjeta.getId())
                ),
                Updates.set("listaTarjetas.$", tarjeta)
        );

    }
// Diego Alcantar

     @Override
public void eliminar(Persona persona, Tarjeta tarjeta) {
 Bson filter = Filters.and(
                    Filters.eq("_id", persona.getId()),
                    Filters.elemMatch("listaTarjetas", Filters.eq("_id", tarjeta.getId()))
            );

            // Crear la actualización para eliminar la tarjeta de la lista
            Bson update = Updates.pull("listaTarjetas", new Document("_id", tarjeta.getId()));

            coleccionPersonas.updateOne(filter, update);
}

// Diego Alcantar

    @Override
    public List<Tarjeta> obtenerTodasLasTarjetasDeClientes() {
        List<Tarjeta> todasLasTarjetas = new ArrayList<>();

        try {
            // Obtén un cursor que contenga todos los documentos de personas
            MongoCursor<Persona> cursor = coleccionPersonas.find().iterator();

            // Itera sobre todos los documentos de personas
            while (cursor.hasNext()) {
                Persona persona = cursor.next();

                // Accede a la lista de tarjetas de cada persona
                List<Tarjeta> tarjetas = persona.getListaTarjetas();

                // Agrega todas las tarjetas de la persona a la lista de tarjetas
                todasLasTarjetas.addAll(tarjetas);
            }
        } catch (MongoException e) {
            System.out.println(e);

            return null;
        }
        return todasLasTarjetas;
    }
// Diego Alcantar

    @Override
    public Persona obtenerPersonaDeTarjeta(Tarjeta tarjeta) {
        try {
            Persona persona = coleccionPersonas.find(Filters.elemMatch("listaTarjetas", Filters.eq("numeroCuenta", tarjeta.getNumeroCuenta()))).first();
            if (persona != null) {
                return persona;
            } else {
                System.out.println("No se encontró ninguna persona con esa tarjeta.");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        return null;
    }
}
