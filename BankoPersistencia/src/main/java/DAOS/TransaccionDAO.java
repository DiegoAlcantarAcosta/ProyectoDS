/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOS;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import entidades.Grupo;
import entidades.Transaccion;
import interfaces.daos.ITransaccionDAO;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */
public class TransaccionDAO implements ITransaccionDAO {

     private MongoCollection<Document> collection;

    public TransaccionDAO(MongoDatabase database) {
        this.collection = database.getCollection("transacciones");
    }

    @Override
    public boolean registrarTransaccion(Transaccion transaccion) {
         try {
            Document documento = new Document("grupoId", transaccion.getGrupoId())
                    .append("monto", transaccion.getMonto())
                    .append("descripcion", transaccion.getDescripcion());
            collection.insertOne(documento);
            return true; // Se registró exitosamente
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Ocurrió un error al registrar la transacción
        }
    
    }

    @Override
public List<Transaccion> obtenerTransaccionesPorGrupo(ObjectId grupoId) {
        List<Transaccion> transacciones = new ArrayList<>();
        for (Document documento : collection.find(new Document("grupoId", grupoId))) {
            Transaccion transaccion = new Transaccion();
            transaccion.setId(documento.getObjectId("_id"));
            transaccion.setGrupoId(documento.getObjectId("grupoId"));
            transaccion.setMonto(documento.getDouble("monto"));
            transaccion.setDescripcion(documento.getString("descripcion"));
            transacciones.add(transaccion);
        }
        return transacciones;
    }

   

}
