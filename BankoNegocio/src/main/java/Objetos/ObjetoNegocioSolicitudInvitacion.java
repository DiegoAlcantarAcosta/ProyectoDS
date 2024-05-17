/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

import Conexion.Conexion;
import DAOS.SolicitudInvitacionDAO;
import DTOs.SolicitudInvitacionDTO;
import Objetos.Interfaces.INegocioSolicitudInvitacion;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import entidades.SolicitudInvitacion;
import interfaces.daos.ISolicitudInvitacionDAO;
import java.util.List;
import org.bson.types.ObjectId;


/**
 *
 * @author Oley
 */
public class ObjetoNegocioSolicitudInvitacion implements INegocioSolicitudInvitacion {

  
    private ISolicitudInvitacionDAO solicitudDAO;

    public ObjetoNegocioSolicitudInvitacion() {
        this.solicitudDAO = new SolicitudInvitacionDAO();
    }

   
    @Override
    public boolean enviarSolicitud(SolicitudInvitacion solicitudInvitacion) {
        // Cambiar el monto a negativo
        solicitudInvitacion.setMonto(-solicitudInvitacion.getMonto());
        return solicitudDAO.enviarSolicitud(solicitudInvitacion);
    }

    @Override
    public boolean aceptarSolicitudInvitacion(String solicitudId) {
       // Obtener la solicitud por su ID directamente desde la colección
        SolicitudInvitacion solicitud = solicitudDAO.obtenerSolicitudPorId(solicitudId);
        if (solicitud != null) {
            // Cambiar el monto a positivo
            solicitud.setMonto(Math.abs(solicitud.getMonto()));
            // Eliminar la solicitud original y actualizar con la nueva solicitud
            return solicitudDAO.aceptarSolicitudInvitacion(solicitudId);
        }
        return false;
    }

   

    @Override
    public List<SolicitudInvitacion> obtenerSolicitudesPendientesPorUsuario(ObjectId usuarioId) {
        return solicitudDAO.obtenerSolicitudesPendientesPorUsuario(usuarioId);
    }
}
