/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOS;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
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
 private MongoCollection<Document> collection;

    public SolicitudInvitacionDAO(MongoDatabase database) {
        this.collection = database.getCollection("solicitudesInvitacion");
    }

 @Override
public boolean enviarSolicitud(SolicitudInvitacion solicitudInvitacion) {
     try {
        Document documento = new Document("usuarioId", solicitudInvitacion.getUsuarioId())
                                    .append("grupoId", solicitudInvitacion.getGrupoId())
                                    .append("mensaje", solicitudInvitacion.getMensaje());
        collection.insertOne(documento);
        return true; // Operación exitosa
    } catch (Exception e) {
        e.printStackTrace(); // Manejo del error, puedes imprimirlo o realizar otra acción
        return false; // Error durante la operación
    }
}

    @Override
    public List<SolicitudInvitacion> obtenerSolicitudesPendientesPorUsuario(ObjectId usuarioId) {
        List<SolicitudInvitacion> solicitudes = new ArrayList<>();
        for (Document documento : collection.find(new Document("usuarioId", usuarioId))) {
            SolicitudInvitacion solicitud = new SolicitudInvitacion();
            solicitud.setId(documento.getObjectId("_id"));
            solicitud.setUsuarioId(documento.getObjectId("usuarioId"));
            solicitud.setGrupoId(documento.getObjectId("grupoId"));
            solicitud.setMensaje(documento.getString("mensaje"));
            // Otros campos de SolicitudInvitacion si los hubiera...
            solicitudes.add(solicitud);
        }
        return solicitudes;
    }
   
   

    
    public void rechazarSolicitudInvitacion(ObjectId solicitudId) {
        collection.deleteOne(new Document("_id", solicitudId));
    }

    public List<SolicitudInvitacion> obtenerSolicitudesEnviadasPorUsuario(ObjectId usuarioId) {
        List<SolicitudInvitacion> solicitudes = new ArrayList<>();
        for (Document documento : collection.find(new Document("receptorId", usuarioId))) {
            SolicitudInvitacion solicitud = new SolicitudInvitacion();
            solicitud.setId(documento.getObjectId("_id"));
            solicitud.setUsuarioId(documento.getObjectId("usuarioId"));
            solicitud.setGrupoId(documento.getObjectId("grupoId"));
            solicitud.setMensaje(documento.getString("mensaje"));
            solicitudes.add(solicitud);
        }
        return solicitudes;
    }

    @Override
    public boolean aceptarSolicitudInvitacion(String solicitudId) {
DeleteResult result = collection.deleteOne(new Document("_id", solicitudId));
    return result.getDeletedCount() > 0;
    }
}
