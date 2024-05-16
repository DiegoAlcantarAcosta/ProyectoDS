/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.bankonegocio;

import Objetos.ObjetoNegocioSolicitudInvitacion;
import entidades.SolicitudInvitacion;
import interfaces.daos.ISolicitudInvitacionDAO;
import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */
public class ProbarSolicitudes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ISolicitudInvitacionDAO dao = new SimulatedSolicitudInvitacionDAO();

        ObjetoNegocioSolicitudInvitacion negocio = new ObjetoNegocioSolicitudInvitacion(dao);

        System.out.println("Enviando solicitud...");
        negocio.enviarSolicitud(new SolicitudInvitacion());
        
        System.out.println("Obteniendo solicitudes pendientes...");
        negocio.obtenerSolicitudesPendientesPorUsuario(new ObjectId("663f0e00f646294d5bb6738e"));
        
        System.out.println("Aceptando solicitud...");
negocio.aceptarSolicitudInvitacion(("663f0e00f646294d5bb6738e"));
        
        System.out.println("Rechazando solicitud...");
        negocio.rechazarSolicitudInvitacion(("663f0e00f646294d5bb6738e"));    }
    
}
