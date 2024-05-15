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
    
    /**
     * envia soli
     * @param solicitudInvitacion soli
     * @return  boolean
     */
    boolean enviarSolicitud(SolicitudInvitacion solicitudInvitacion);
    
    /**
     * Acepta soli
     * @param solicitudId soli
     * @return boolean
     */
    boolean aceptarSolicitudInvitacion(String solicitudId);
    
    /**
     * rechaza soli
     * @param solicitudId soli
     */
    void rechazarSolicitudInvitacion(String solicitudId);
    /**
     * obtiene las solicitudes pendientes
     * @param usuarioId usuario
     * @return  lista de solicitudes
     */
    List<SolicitudInvitacion> obtenerSolicitudesPendientesPorUsuario(ObjectId usuarioId);
}
