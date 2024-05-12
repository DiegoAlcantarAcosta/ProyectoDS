/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.bankonegocio;

import Objetos.ObjetoNegocioTransaccion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import entidades.Transaccion;
import interfaces.daos.ITransaccionDAO;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */
public class PruebaNegocioTransaccion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
  MongoClient mongoClient = MongoClients.create();
    MongoDatabase database = mongoClient.getDatabase("BANKO");
    MongoCollection<Document> transaccionesCollection = database.getCollection("transaccion");

    ITransaccionDAO transaccionDAO = new MongoTransaccionDAO(transaccionesCollection);

        ObjetoNegocioTransaccion negocioTransaccion = new ObjetoNegocioTransaccion(transaccionDAO);

        Transaccion transaccion = new Transaccion();
        transaccion.setGrupoId(new ObjectId("609f1ff33aaf9629e55ae3d5"));
        transaccion.setMonto(100.0); 
        transaccion.setDescripcion("Compra de productos"); 

        // Probar el método registrarTransaccion
        boolean registroExitoso = negocioTransaccion.registrarTransaccion(transaccion);
        if (registroExitoso) {
            System.out.println("La transacción se registró exitosamente.");
        } else {
            System.out.println("Error: La transacción no se pudo registrar.");
        }

        ObjectId idGrupo = new ObjectId("609f1ff33aaf9629e55ae3d5"); 
        Transaccion transaccionObtenida = negocioTransaccion.obtenerTransaccionPorId(idGrupo);
        if (transaccionObtenida != null) {
            System.out.println("Transacción encontrada:");
            System.out.println("ID: " + transaccionObtenida.getId());
            System.out.println("Monto: " + transaccionObtenida.getMonto());
            System.out.println("Descripción: " + transaccionObtenida.getDescripcion());
        } else {
            System.out.println("No se encontraron transacciones para el grupo con ID: " + idGrupo);
        }
    }
    }
    

