/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bankonegocio;

import entidades.SolicitudInvitacion;
import interfaces.daos.ISolicitudInvitacionDAO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */
public class SimulatedSolicitudInvitacionDAO implements  ISolicitudInvitacionDAO {
     private final Map<ObjectId, SolicitudInvitacion> solicitudesPendientes = new HashMap<>();
    private final List<SolicitudInvitacion> listaSolicitudes = new ArrayList<>();

    public SimulatedSolicitudInvitacionDAO() {
        ObjectId idUsuario1 = new ObjectId("609f1ff33aaf9629e55ae3d4");
        ObjectId idGrupo1 = new ObjectId("609f1ff33aaf9629e55ae3d5");
        String mensaje1 = "Mensaje 1";

        ObjectId idUsuario2 = new ObjectId("609f1ff33aaf9629e55ae3d6");
        ObjectId idGrupo2 = new ObjectId("609f1ff33aaf9629e55ae3d7");
        String mensaje2 = "DIOS AMEN";

        ObjectId idUsuario3 = new ObjectId("609f1ff33aaf9629e55ae3d8");
        ObjectId idGrupo3 = new ObjectId("609f1ff33aaf9629e55ae3d9");
        String mensaje3 = "CASI";

        this.listaSolicitudes.add(new SolicitudInvitacion(idUsuario1, idGrupo1, mensaje1));
        this.listaSolicitudes.add(new SolicitudInvitacion(idUsuario2, idGrupo2, mensaje2));
        this.listaSolicitudes.add(new SolicitudInvitacion(idUsuario3, idGrupo3, mensaje3));
    }

    @Override
    public boolean enviarSolicitud(SolicitudInvitacion solicitudInvitacion) {
        System.out.println("Simulación: Enviando solicitud");
        ObjectId id = new ObjectId(); 
        solicitudInvitacion.setId(id);
        solicitudesPendientes.put(id, solicitudInvitacion);
        return true;
    }

    @Override
    public List<SolicitudInvitacion> obtenerSolicitudesPendientesPorUsuario(ObjectId usuarioId) {
        List<SolicitudInvitacion> solicitudesPendientes = new ArrayList<>();
        for (SolicitudInvitacion solicitud : listaSolicitudes) {
            if (solicitud.getUsuarioId() != null && solicitud.getUsuarioId().equals(usuarioId)) {
                solicitudesPendientes.add(solicitud);
            }
        }
        return solicitudesPendientes;
    }

    public void aceptarSolicitudInvitacion(ObjectId solicitudId) {
        System.out.println("Simulación: Aceptando solicitud");
        solicitudesPendientes.remove(solicitudId);
    }

    @Override
    public void rechazarSolicitudInvitacion(ObjectId solicitudId) {
        System.out.println("Simulación: Rechazando solicitud");
        solicitudesPendientes.remove(solicitudId);
    }

    @Override
    public boolean aceptarSolicitudInvitacion(String solicitudId) {
 ObjectId objectId = new ObjectId(solicitudId);
    aceptarSolicitudInvitacion(objectId);
    return true;
            }

    @Override
    public List<SolicitudInvitacion> obtenerSolicitudesEnviadasPorUsuario(ObjectId usuarioId) {
 List<SolicitudInvitacion> solicitudesEnviadas = new ArrayList<>();
    for (SolicitudInvitacion solicitud : listaSolicitudes) {
        if (solicitud.getUsuarioId() != null && solicitud.getUsuarioId().equals(usuarioId)) {
            solicitudesEnviadas.add(solicitud);
        }
    }
    return solicitudesEnviadas;    }
}
