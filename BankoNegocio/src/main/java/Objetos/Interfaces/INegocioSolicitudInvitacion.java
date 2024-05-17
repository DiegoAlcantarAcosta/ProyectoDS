/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Objetos.Interfaces;

import entidades.SolicitudInvitacion;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */
public interface INegocioSolicitudInvitacion {
  boolean enviarSolicitud(SolicitudInvitacion solicitudInvitacion);
    

    boolean aceptarSolicitudInvitacion(String solicitudId);
    
  
    List<SolicitudInvitacion> obtenerSolicitudesPendientesPorUsuario(ObjectId usuarioId);  
}
