/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOS;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import entidades.Grupo;
import entidades.MiembroGrupo;
import interfaces.daos.IMiembroGrupoDAO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */
public class MiembroGrupoDAO implements IMiembroGrupoDAO {

     private MongoCollection<Document> collection;

    public MiembroGrupoDAO(MongoDatabase database) {
        this.collection = database.getCollection("miembrosGrupo");
    }

   

    @Override
   public List<MiembroGrupo> obtenerMiembrosPorGrupo(ObjectId grupoId) {
      List<MiembroGrupo> miembros = new ArrayList<>();
        for (Document documento : collection.find(new Document("grupoId", grupoId))) {
            MiembroGrupo miembro = new MiembroGrupo(
                documento.getObjectId("_id"),
                documento.getString("nombre"),
                documento.getString("apellidoP"),
                documento.getString("apellidoM")
            );
            miembros.add(miembro);
        }
        return miembros;
    }
public void agregarNuevoMiembro(String nombre, String apellidoP, String apellidoM) {
        Document documento = new Document("nombre", nombre)
                                .append("apellidoP", apellidoP)
                                .append("apellidoM", apellidoM);
        collection.insertOne(documento);
    }

    @Override
    public boolean agregarMiembro(MiembroGrupo miembroGrupo, ObjectId grupoId) {
try {
        Document documento = new Document("nombre", miembroGrupo.getNombre())
                                .append("grupoId", grupoId);
        collection.insertOne(documento);
        return true; // La inserción fue exitosa
    } catch (Exception e) {
        e.printStackTrace();
        return false; 
    }    }

}
