/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Funcionalidad;

import DTOs.GrupoDTO;
import DTOs.MiembroGrupoDTO;
import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */
public interface IGrupoSS {
     ObjectId  crearGrupo(GrupoDTO grupoDTO);


}
