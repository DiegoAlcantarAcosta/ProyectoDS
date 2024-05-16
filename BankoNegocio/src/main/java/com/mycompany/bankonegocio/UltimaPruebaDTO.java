/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.bankonegocio;

import DAOS.MiembroGrupoDAO;
import DTOs.MiembroGrupoDTO;
import Objetos.Interfaces.IObjetoNegocioMiembroGrupo;
import Objetos.ObjetoNegocioMiembroGrupo;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import interfaces.daos.IMiembroGrupoDAO;
import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */
public class UltimaPruebaDTO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MongoDatabase database = MongoClients.create().getDatabase("BANKO");

        IMiembroGrupoDAO miembroGrupoDAO = new MiembroGrupoDAO(database);

        IObjetoNegocioMiembroGrupo objetoNegocioMiembroGrupo = new ObjetoNegocioMiembroGrupo(miembroGrupoDAO);

        MiembroGrupoDTO nuevoMiembroDTO = new MiembroGrupoDTO("Orlando", "Leyva", "Fontes");
        String idGrupo = "609f1ff33aaf9629e55ae3d4"; 

        boolean miembroAgregado = objetoNegocioMiembroGrupo.agregarMiembro(nuevoMiembroDTO, idGrupo);
        if (miembroAgregado) {
            System.out.println("¡Miembro agregado correctamente!");
        } else {
            System.out.println("Error al agregar el miembro.");
        }

//        // Obtener todos los miembros de un grupo
//        ObjectId objectIdGrupo = new ObjectId(idGrupo);
//        System.out.println("Miembros del grupo:");
//        objetoNegocioMiembroGrupo.obtenerMiembrosPorGrupo(objectIdGrupo)
//                .forEach(miembro -> System.out.println(miembro.getNombre() + " " +
//                        miembro.getApellidoP() + " " + miembro.getApellidoM()));
    }    }
    

