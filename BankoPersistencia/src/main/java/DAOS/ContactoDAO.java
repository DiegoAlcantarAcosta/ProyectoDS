/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOS;

import Conexion.Conexion;
import com.mongodb.client.FindIterable;
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
        if (persona.getId() != null && contacto.getAlias() != null) {
            Bson filtro = Filters.and(Filters.eq("_id", persona.getId()), Filters.eq("listaContactos.alias", contacto.getAlias()));
            Bson update = Updates.pull("listaContactos", Filters.eq("alias", contacto.getAlias()));
            UpdateResult result = coleccionPersonas.updateOne(filtro, update);

            return result.getModifiedCount() > 0;
        }
        return false;

    }

    @Override
    public Boolean actualizar(Persona persona, Contacto contactoOri, Contacto contactoActua) {
        if (persona.getId() != null && contactoOri.getAlias() != null && contactoOri.getNumeroCuenta() != null) {

            coleccionPersonas.updateOne(
                    Filters.and(
                            Filters.eq("_id", persona.getId()),
                            Filters.eq("listaContactos.alias", contactoOri.getAlias())
                    ),
                    Updates.set("listaContactos.$", contactoActua)
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
//    if (persona.getId() != null && contacto.getId() != null) {
//        Document query = new Document("_id", persona.getId())
//                            .append("listaContactos._id", contacto.getId());
//        
//        Document projection = new Document("listaContactos.$", 1); // Proyecta solo el contacto específico
//
//        FindIterable<Contacto> result = coleccionPersonas.find(query).projection(projection);
//
//        Contacto personaDoc = result.first();
//        Document doc = (Document)personaDoc;
//        if (personaDoc != null) {
//            List<Document> contactosDocs = personaDoc.getList("listaContactos", Document.class);
//
//            // Busca el contacto en la lista de contactos de la persona
//            for (Document contactoDoc : contactosDocs) {
//                if (contactoDoc.getObjectId("_id").equals(contacto.getId())) {
//                    Contacto contactoEncontrado = new Contacto();
//                    contactoEncontrado.setId(contactoDoc.getObjectId("_id"));
//                    contactoEncontrado.setAlias(contactoDoc.getString("alias"));
//                    contactoEncontrado.setNombre(contactoDoc.getString("nombre"));
//                    contactoEncontrado.setApellidoP(contactoDoc.getString("apellidoP"));
//                    contactoEncontrado.setApellidoM(contactoDoc.getString("apellidoM"));
//                    contactoEncontrado.setNumeroCuenta(contactoDoc.getString("numeroCuenta"));
//                    contactoEncontrado.setBanco(tipoBanco.valueOf(contactoDoc.getString("banco")));
//                    return contactoEncontrado;
//                }
//            }
//        }
//    }
//
//    return null; // Devuelve null si no se encontró el contacto para la persona dada
return null;
}

}
