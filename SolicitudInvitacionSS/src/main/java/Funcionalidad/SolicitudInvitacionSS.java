/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funcionalidad;

import entidades.SolicitudInvitacion;
import interfaces.daos.ISolicitudInvitacionDAO;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */
public class SolicitudInvitacionSS implements ISolicitudInvitacionSS{
      private final ISolicitudInvitacionDAO solicitudInvitacionDAO;

    public SolicitudInvitacionSS(ISolicitudInvitacionDAO solicitudInvitacionDAO) {
        this.solicitudInvitacionDAO = solicitudInvitacionDAO;
    }

   

    @Override
    public boolean enviarSolicitud(SolicitudInvitacion solicitudInvitacion) {
        return solicitudInvitacionDAO.enviarSolicitud(solicitudInvitacion);
    }

    @Override
    public boolean aceptarSolicitudInvitacion(String solicitudId) {
        return solicitudInvitacionDAO.aceptarSolicitudInvitacion(solicitudId);
    }

    @Override
    public void rechazarSolicitudInvitacion(String solicitudId) {
   ObjectId objectId = new ObjectId(solicitudId);
        solicitudInvitacionDAO.rechazarSolicitudInvitacion(objectId);
    }

    @Override
    public List<SolicitudInvitacion> obtenerSolicitudesPendientesPorUsuario(ObjectId usuarioId) {
        return solicitudInvitacionDAO.obtenerSolicitudesPendientesPorUsuario(usuarioId);
    }
}
