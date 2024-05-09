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
import entidades.Tarjeta;
import interfaces.daos.IPersonaDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

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

    @Override
    public Boolean procesarInicioSesion(String telefono, String contaseña) {
        try  {
            Persona persona = coleccionPersonas.find(Filters.and(
                    Filters.eq("telefono", telefono),
                    Filters.eq("contrasena", contaseña)
            )).first();

            // Si se encuentra una persona con ese número de teléfono y contraseña, retorna true
            return persona != null;
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Persona obtenerPersonaPorTelefonoYContrasena(String telefono, String contrasena) {
        try  {
            // Buscar la persona por número de teléfono y contraseña
            Persona personaDocument = coleccionPersonas.find(Filters.and(
                    Filters.eq("telefono", telefono),
                    Filters.eq("contrasena", contrasena)
            )).first();
            // Si se encuentra una persona, retornar un objeto Persona con los datos mapeados
            if (personaDocument != null) {
                ObjectId id = personaDocument.getId();
                String nombre = personaDocument.getNombre();
                String apellidoP = personaDocument.getApellidoP();
                String apellidoM = personaDocument.getApellidoM();
                String curp = personaDocument.getCurp();
                Date fechaNac = personaDocument.getFechaNac();                // Aquí puedes añadir más atributos si es necesario
                List<Tarjeta> listaTarjetas = personaDocument.getListaTarjetas();

                // Crear y retornar un objeto Persona con los datos mapeados
                return new Persona(id, nombre, apellidoP, apellidoM, curp, contrasena, fechaNac, telefono, listaTarjetas);
            } else {
                return null; // Si no se encuentra ninguna persona, retornar null
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return null;
        }
    }
}
