/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.bankonegocio;

import DAOS.GrupoDAO;
import DAOS.MiembroGrupoDAO;
import DAOS.TransaccionDAO;
import DTOs.GrupoDTO;
import DTOs.MiembroGrupoDTO;
import Objetos.ObjetoNegocioGrupo;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import interfaces.daos.IGrupoDAO;
import interfaces.daos.IMiembroGrupoDAO;
import interfaces.daos.ITransaccionDAO;

/**
 *
 * @author Oley
 */
public class PruebaObjetoNegocioGrupo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         // Crear instancia de GrupoDTO para crear un nuevo grupo
  MongoClient mongoClient = new MongoClient("localhost", 27017); // Conexión a MongoDB en el puerto predeterminado
    MongoDatabase database = mongoClient.getDatabase("BANKO"); // Nombre de tu base de datos        GrupoDTO grupoDTO = new GrupoDTO();
        GrupoDTO grupoDTO = new GrupoDTO();
   
    grupoDTO.setNombre("Grupo de Prueba");
        grupoDTO.setSaldo(1000.0);
        grupoDTO.setMotivo("Reunión de Amigos");

        // Crear instancia de MiembroGrupoDTO para agregar un miembro al grupo
        MiembroGrupoDTO miembroDTO = new MiembroGrupoDTO();
        miembroDTO.setNombre("Juan");

        // Crear instancias de las implementaciones reales de las interfaces DAO (usando MongoDB)
        IGrupoDAO grupoDAO = new GrupoDAO(database); // Suponiendo que GrupoDAO implementa IGrupoDAO y utiliza MongoDB
        IMiembroGrupoDAO miembroGrupoDAO = new MiembroGrupoDAO(database); // Suponiendo que MiembroGrupoDAO implementa IMiembroGrupoDAO y utiliza MongoDB
        ITransaccionDAO transaccionDAO = new TransaccionDAO(database); // Suponiendo que TransaccionDAO implementa ITransaccionDAO y utiliza MongoDB

        // Crear instancia de ObjetoNegocioGrupo pasando las implementaciones reales de las interfaces DAO
        ObjetoNegocioGrupo negocioGrupo = new ObjetoNegocioGrupo(grupoDAO, miembroGrupoDAO, transaccionDAO);

        // Crear el grupo
        Boolean creado = negocioGrupo.crearGrupo(grupoDTO);
        if (creado) {
            System.out.println("El grupo fue creado correctamente.");
        } else {
            System.out.println("Hubo un problema al crear el grupo.");
        }

        // Obtener un grupo por su ID
        String idGrupo = "663f0e00f646294d5bb6738e"; // ID de grupo existente en la base de datos
        GrupoDTO grupoObtenido = negocioGrupo.obtenerGrupoPorId(idGrupo);
        if (grupoObtenido != null) {
            System.out.println("Grupo obtenido: " + grupoObtenido.getNombre());
        } else {
            System.out.println("No se encontró ningún grupo con el ID especificado.");
        }

        // Agregar un miembro al grupo
        Boolean agregado = negocioGrupo.agregarMiembro(miembroDTO, idGrupo);
        if (agregado) {
            System.out.println("Miembro agregado correctamente al grupo.");
        } else {
            System.out.println("Hubo un problema al agregar el miembro al grupo.");
        }
    }
}

