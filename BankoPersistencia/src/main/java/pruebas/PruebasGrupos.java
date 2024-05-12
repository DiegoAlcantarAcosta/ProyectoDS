/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import DAOS.GrupoDAO;
import DAOS.MiembroGrupoDAO;
import DAOS.SolicitudInvitacionDAO;
import DAOS.TransaccionDAO;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import entidades.Grupo;
import entidades.MiembroGrupo;
import entidades.Persona;
import entidades.SolicitudInvitacion;
import entidades.Transaccion;
import interfaces.daos.IGrupoDAO;
import interfaces.daos.IMiembroGrupoDAO;
import interfaces.daos.ISolicitudInvitacionDAO;
import interfaces.daos.ITransaccionDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */
public class PruebasGrupos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");

    MongoDatabase database = mongoClient.getDatabase("BANKO");

    IGrupoDAO grupoDAO = new GrupoDAO(database);
    IMiembroGrupoDAO miembroGrupoDAO = new MiembroGrupoDAO(database);
    ISolicitudInvitacionDAO solicitudInvitacionDAO = new SolicitudInvitacionDAO(database);
    ITransaccionDAO transaccionDAO = new TransaccionDAO(database);

    // Crear un nuevo grupo
    Grupo grupo = new Grupo("Grupo de Ejemplo", 1000.0, "Motivo de Ejemplo");
    grupoDAO.crearGrupo(grupo);

    // Obtener el ID del grupo creado
    ObjectId grupoId = grupo.getId();

    // Recuperar el grupo por su ID
    Grupo grupoRecuperado = grupoDAO.obtenerGrupoPorID(grupoId);
    System.out.println("Grupo recuperado: " + grupoRecuperado);

    // Agregar un nuevo miembro al grupo
    MiembroGrupo nuevoMiembro = new MiembroGrupo("Juan", "Pérez", "Gómez");
    miembroGrupoDAO.agregarMiembro(nuevoMiembro, grupoId);

    // Obtener los miembros del grupo
    List<MiembroGrupo> miembrosDelGrupo = miembroGrupoDAO.obtenerMiembrosPorGrupo(grupoId);
    System.out.println("Miembros del grupo: " + miembrosDelGrupo);

    // Enviar una solicitud de invitación al grupo
    ObjectId usuarioId = new ObjectId();

SolicitudInvitacion solicitud = new SolicitudInvitacion(usuarioId, grupoId, "Mensaje de invitación");
    solicitudInvitacionDAO.enviarSolicitud(solicitud);

    // Obtener las solicitudes pendientes del usuario para un grupo
    Persona usuario = new Persona("nombre_de_usuario"); // Reemplaza "nombre_de_usuario" con el nombre de usuario real
    List<SolicitudInvitacion> solicitudesPendientes = solicitudInvitacionDAO.obtenerSolicitudesPendientesPorUsuario(grupoId);
    System.out.println("Solicitudes pendientes del usuario: " + solicitudesPendientes);

    // Registrar una nueva transacción para el grupo
    Transaccion transaccion = new Transaccion(grupoId, 500.0, "Pago de factura");
    transaccionDAO.registrarTransaccion(transaccion);

    // Obtener las transacciones del grupo
    List<Transaccion> transaccionesDelGrupo = transaccionDAO.obtenerTransaccionesPorGrupo(grupoId);
    System.out.println("Transacciones del grupo: " + transaccionesDelGrupo);

    mongoClient.close();
}
}
