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
import entidades.Persona;
import interfaces.daos.IPersonaDAO;
import java.util.ArrayList;
import java.util.List;
import org.bson.conversions.Bson;

/**
 *
 * @author Diego
 */
public class PersonaDAO implements IPersonaDAO {

    private final MongoCollection<Persona> coleccionPersonas;

    public PersonaDAO() {
        this.coleccionPersonas = Conexion.getDatabase().getCollection("Personas", Persona.class);
    }

    @Override
    public Boolean registrar(Persona persona) {
          try {
            this.coleccionPersonas.insertOne(persona);
            return true;
        } catch (MongoException e) {
            System.out.println(e);
        }
        return false;
    }

    @Override
    public boolean personaRegistrada(Persona persona) {
        Bson filtroID = Filters.eq("_id", persona.getId());
        Persona person = coleccionPersonas.find(filtroID).first();
        try {
            if (person != null){
                return true;
            } 
        } catch (MongoException e) {
            System.out.println(e);
        }
        return false;
    }

    @Override
    public Persona obtenerPersonaPorCurp(Persona persona) {
        Bson filtroID = Filters.eq("curp", persona.getCurp());
        try {
            return coleccionPersonas.find(filtroID).first();
        } catch (MongoException e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public List<Persona> obtenerTodasLasPersonas() {
       List<Persona> todasLasPersonas = new ArrayList<>();

        try {
            // Obtén un cursor que contenga todos los documentos de personas
            MongoCursor<Persona> cursor = coleccionPersonas.find().iterator();

            // Itera sobre todos los documentos de personas
            while (cursor.hasNext()) {
                Persona persona = cursor.next();
                todasLasPersonas.add(persona);
            }
        }catch(MongoException e){
            System.out.println(e);
        }

        return todasLasPersonas;
    }

}
