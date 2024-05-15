/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Objetos.Interfaces;

import DTOs.ContactoDTO;
import DTOs.GrupoDTO;
import DTOs.MiembroGrupoDTO;
import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */
public interface IObjetoNegocioGrupo {


     ObjectId  crearGrupo(GrupoDTO grupoDTO);

 
    GrupoDTO obtenerGrupoPorId(String id);

    
    Boolean agregarContacto(ContactoDTO contactoDTO, String idGrupo); // Agregar este método

}
