/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOS;

import Conexion.Conexion;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import entidades.Contacto;
import entidades.Persona;
import interfaces.daos.IContactoDAO;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author Dell
 */
public class ContactoDAO implements IContactoDAO {

    MongoCollection<Contacto> coleccionPersonas;

    public ContactoDAO() {
        this.coleccionPersonas = Conexion.getDatabase().getCollection("Personas", Contacto.class);
    }

    @Override
    public Boolean agregar(Persona persona, Contacto contacto) {
        if (persona.getId() != null) {
            coleccionPersonas.updateOne(Filters.eq("_id", persona.getId()), Updates.push("listaContactos", contacto));
            return true;
        }
        return false;

    }

    @Override
    public Boolean eliminar(Persona persona, Contacto contacto) {
        if (persona.getId() != null && contacto.getId() != null) {
            Bson filtro = Filters.and(Filters.eq("_id", persona.getId()), Filters.eq("listaContactos._id", contacto.getId()));
            Bson update = Updates.pull("listaContactos", Filters.eq("_id", contacto.getId()));
            UpdateResult result = coleccionPersonas.updateOne(filtro, update);

            return result.getModifiedCount() > 0;
        }
        return false;

    }

    @Override
    public Boolean actualizar(Persona persona, Contacto contacto) {
        if (persona.getId() != null && contacto.getId() != null) {

            coleccionPersonas.updateOne(
                    Filters.and(
                            Filters.eq("_id", persona.getId()),
                            Filters.eq("listaContactos._id", contacto.getId())
                    ),
                    Updates.set("listaContactos.$", contacto)
            );
            return true;
        }
        return false;
    }

    @Override
    public List<Contacto> obtenerContactosPersona(Persona persona) {

        return null;

    }

    @Override
    public Contacto obtenerContactoPersona(Persona persona, Contacto contacto) {

        return null;

    }

}
