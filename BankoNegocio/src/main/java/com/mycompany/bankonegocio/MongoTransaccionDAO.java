/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bankonegocio;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
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
public class MongoTransaccionDAO implements ITransaccionDAO {

   private final MongoCollection<Document> collection;

    public MongoTransaccionDAO(MongoCollection<Document> collection) {
        this.collection = collection;
    }

    @Override
    public void registrarTransaccion(Transaccion transaccion) {
        Document documento = new Document("grupoId", transaccion.getGrupoId())
                .append("monto", transaccion.getMonto())
                .append("descripcion", transaccion.getDescripcion());
        collection.insertOne(documento);
    }

    @Override
    public List<Transaccion> obtenerTransaccionesPorGrupo(ObjectId grupoId) {
        List<Transaccion> transacciones = new ArrayList<>();
        Document query = new Document("grupoId", grupoId);
        MongoCursor<Document> cursor = collection.find(query).iterator();
        try {
            while (cursor.hasNext()) {
                Document documento = cursor.next();
                Transaccion transaccion = new Transaccion();
                transaccion.setId(documento.getObjectId("_id"));
                transaccion.setGrupoId(documento.getObjectId("grupoId"));
                transaccion.setMonto(documento.getDouble("monto"));
                transaccion.setDescripcion(documento.getString("descripcion"));
                transacciones.add(transaccion);
            }
        } finally {
            cursor.close();
        }
        return transacciones;
    }
}
