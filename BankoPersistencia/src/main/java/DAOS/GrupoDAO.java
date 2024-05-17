/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOS;

import Conexion.Conexion;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import entidades.Contacto;
import entidades.Grupo;
import entidades.Persona;
import interfaces.daos.IGrupoDAO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */
public class GrupoDAO implements IGrupoDAO {
private MongoCollection<Grupo> collection;

    public GrupoDAO(MongoCollection<Grupo> collection) {
        this.collection = collection;
    }

  

    public GrupoDAO() {
        this.collection = Conexion.getDatabase().getCollection("Grupo", Grupo.class);
    }

    @Override
    public Grupo obtenerGrupoPorID(ObjectId id) {
        Grupo documento = collection.find(new Document("_id", id)).first();
        if (documento != null) {
            return documento;
        }
        return null;
    }

    @Override
    public ObjectId crearGrupo(Grupo grupo) {
        try {
            collection.insertOne(grupo);
            return grupo.getId();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Boolean agregarContacto(Contacto contacto, String idGrupo) {
        try {
            ObjectId objectId = new ObjectId(idGrupo);
            Document filtro = new Document("_id", objectId);
            Document documentoContacto = new Document("nombre", contacto.getNombre())
                    .append("apellidoP", contacto.getApellidoP())
                    .append("apellidoM", contacto.getApellidoM());
            UpdateResult resultado = collection.updateOne(filtro, Updates.addToSet("contactos", documentoContacto));
            return resultado.getModifiedCount() > 0;
        } catch (Exception e) {
            throw new RuntimeException("Error al agregar el contacto al grupo: " + e.getMessage(), e);
        }
    }
}
