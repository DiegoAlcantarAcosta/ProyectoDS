/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOS;
import Conexion.Conexion;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.lt;
import com.mongodb.client.result.DeleteResult;
import entidades.Grupo;
import entidades.SolicitudInvitacion;
import interfaces.daos.ISolicitudInvitacionDAO;
import java.util.ArrayList;
import org.bson.Document;
import org.bson.types.ObjectId;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author Oley
 */
public class SolicitudInvitacionDAO implements ISolicitudInvitacionDAO {
      private MongoCollection<SolicitudInvitacion> collection;

    public SolicitudInvitacionDAO(MongoCollection<SolicitudInvitacion> collection) {
        this.collection = collection;
    }

    public SolicitudInvitacionDAO() {
        this.collection = Conexion.getDatabase().getCollection("SolicitudInvitacion", SolicitudInvitacion.class);
    }
 @Override
    public SolicitudInvitacion obtenerSolicitudPorId(String solicitudId) {
        return collection.find(Filters.eq("_id", new ObjectId(solicitudId))).first();
    }
    @Override
    public List<SolicitudInvitacion> obtenerSolicitudesPendientesPorUsuario(ObjectId usuarioId) {
        List<SolicitudInvitacion> solicitudes = new ArrayList<>();
        // Buscar todas las solicitudes en las que el receptor es el usuario dado y el monto es negativo
        try (MongoCursor<SolicitudInvitacion> cursor = collection.find(and(eq("usuarioId", usuarioId), lt("monto", 0))).iterator()) {
            while (cursor.hasNext()) {
                solicitudes.add(cursor.next());
            }
        } catch (Exception e) {
            e.printStackTrace(); // Manejo del error, puedes imprimirlo o realizar otra acción
        }
        return solicitudes;
    }

    @Override
    public boolean enviarSolicitud(SolicitudInvitacion solicitudInvitacion) {
        try {
            // Cambiar el monto a negativo
            solicitudInvitacion.setMonto(-solicitudInvitacion.getMonto());
            collection.insertOne(solicitudInvitacion);
            return true; // Operación exitosa
        } catch (Exception e) {
            e.printStackTrace(); // Manejo del error, puedes imprimirlo o realizar otra acción
            return false; // Error durante la operación
        }
    }

    @Override
    public boolean aceptarSolicitudInvitacion(String solicitudId) {
        SolicitudInvitacion solicitud = collection.find(eq("_id", new ObjectId(solicitudId))).first();
        if (solicitud != null) {
            // Cambiar el monto a positivo
            solicitud.setMonto(Math.abs(solicitud.getMonto()));
            collection.deleteOne(eq("_id", new ObjectId(solicitudId)));
            collection.insertOne(solicitud); // Actualizar la solicitud con el monto positivo
            return true;
        }
        return false;
    }
}
