/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

import Objetos.Interfaces.INegocioSolicitudInvitacion;
import entidades.SolicitudInvitacion;
import interfaces.daos.ISolicitudInvitacionDAO;
import java.util.List;
import org.bson.types.ObjectId;


/**
 *
 * @author Oley
 */
public class ObjetoNegocioSolicitudInvitacion implements INegocioSolicitudInvitacion {

    private final ISolicitudInvitacionDAO solicitudInvitacionDAO;
    
    /**
     * Constructor que inicializa
     * @param solicitudInvitacionDAO soli
     */
    public ObjetoNegocioSolicitudInvitacion(ISolicitudInvitacionDAO solicitudInvitacionDAO) {
        this.solicitudInvitacionDAO = solicitudInvitacionDAO;
    }
    
    /**
     * Metodo para aceptar solicitud
     * @param solicitudId soli
     * @return  true o false
     */
    @Override
    public boolean aceptarSolicitudInvitacion(String solicitudId) {
          return solicitudInvitacionDAO.aceptarSolicitudInvitacion(solicitudId);

    }
    
    /**
     * metodo para rechazar invitacion
     * @param solicitudId  soli
     */
    @Override
    public void rechazarSolicitudInvitacion(String solicitudId) {
        ObjectId objectId = new ObjectId(solicitudId);
        solicitudInvitacionDAO.rechazarSolicitudInvitacion(objectId);
    }
    
    /**
     * Metodo para tener invitaciones pendientes
     * @param usuarioId usuario
     * @return  lista de solicitudes 
     */
    @Override
    public List<SolicitudInvitacion> obtenerSolicitudesPendientesPorUsuario(ObjectId usuarioId) {
        return solicitudInvitacionDAO.obtenerSolicitudesPendientesPorUsuario(usuarioId);
    }
     /**
      * Metodo para enviar solicitud
      * @param solicitudInvitacion soli
      * @return  true o false
      */
    @Override
    public boolean enviarSolicitud(SolicitudInvitacion solicitudInvitacion) {
        return solicitudInvitacionDAO.enviarSolicitud(solicitudInvitacion);
    }
    
}
