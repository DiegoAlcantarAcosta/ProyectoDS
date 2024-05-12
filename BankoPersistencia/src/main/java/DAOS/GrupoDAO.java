/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOS;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import entidades.Grupo;
import interfaces.daos.IGrupoDAO;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */
public class GrupoDAO implements IGrupoDAO {
 private MongoCollection<Document> collection;

    public GrupoDAO(MongoDatabase database) {
        this.collection = database.getCollection("grupos");
    }

   

    @Override
    public Grupo obtenerGrupoPorID(ObjectId id) {
        Document documento = collection.find(new Document("_id", id)).first();
        if (documento != null) {
            Grupo grupo = new Grupo();
            grupo.setId(id);
            grupo.setNombre(documento.getString("nombre"));
            grupo.setMontoTotal(documento.getDouble("montoTotal"));
            grupo.setMotivo(documento.getString("motivo"));
            return grupo;
        }
        return null;
    }

    @Override
    public boolean crearGrupo(Grupo grupo) {
 try {
        Document documento = new Document("nombre", grupo.getNombre())
                                .append("montoTotal", grupo.getMontoTotal())
                                .append("motivo", grupo.getMotivo());
        collection.insertOne(documento);
        return true; // La inserción fue exitosa
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
   
    }
}
