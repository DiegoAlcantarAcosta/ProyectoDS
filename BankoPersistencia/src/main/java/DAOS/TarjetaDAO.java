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
import entidades.Persona;
import entidades.Tarjeta;
import interfaces.daos.ITarjetaDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import static java.util.Spliterators.iterator;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author Diego
 */
public class TarjetaDAO implements ITarjetaDAO {

    PersonaDAO pd = new PersonaDAO();
    private final MongoCollection<Tarjeta> coleccionTarjetas;
    private final MongoCollection<Persona> coleccionPersonas;

    public TarjetaDAO() {
        this.coleccionTarjetas = Conexion.getDatabase().getCollection("Personas", Tarjeta.class);
        this.coleccionPersonas = Conexion.getDatabase().getCollection("Personas", Persona.class);
    }

    @Override
    public List<Tarjeta> obtenerTarjetasPersona(Persona persona) {
        List<Tarjeta> lista = persona.getListaTarjetas();
        return lista;
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
        try {
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
    public void eliminar(Persona persona, Tarjeta tarjeta) {
       if (persona != null) {
            List<Tarjeta> tarjetas = obtenerTarjetasPersona(persona);
            Iterator<Tarjeta> iterator = tarjetas.iterator();
            while (iterator.hasNext()) {
                Tarjeta t = iterator.next();
                if (t.getNumeroCuenta().equals(tarjeta.getNumeroCuenta())) {
                    iterator.remove();
                    break;
                }
            }
            coleccionPersonas.updateOne(Filters.eq("_id", persona.getId()), Updates.set("listaTarjetas", tarjetas));
        } else {
            System.out.println("No se encontró la persona.");
        }
    }

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

    @Override
    public Persona obtenerPersonaDeTarjeta(Tarjeta tarjeta) {
        try  {         
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
