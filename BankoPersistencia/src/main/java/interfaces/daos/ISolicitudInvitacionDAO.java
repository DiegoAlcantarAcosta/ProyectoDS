/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces.daos;

import entidades.Persona;
import entidades.SolicitudInvitacion;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */
public interface ISolicitudInvitacionDAO {

 boolean enviarSolicitud(SolicitudInvitacion solicitudInvitacion);
    List<SolicitudInvitacion> obtenerSolicitudesPendientesPorUsuario(ObjectId usuarioId);
    boolean aceptarSolicitudInvitacion(String solicitudId);
    public SolicitudInvitacion obtenerSolicitudPorId(String solicitudId);

}
