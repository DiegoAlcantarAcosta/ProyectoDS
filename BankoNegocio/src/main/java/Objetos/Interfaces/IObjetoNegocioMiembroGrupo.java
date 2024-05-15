/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Objetos.Interfaces;

import DTOs.MiembroGrupoDTO;
import java.util.List;

/**
 *
 * @author Oley
 */
public interface IObjetoNegocioMiembroGrupo {

    /***
     * metodo para agregar miembro 
     * @param miembroDTO miembro
     * @param idGrupo id grupo
     * @return  boolean
     */
    Boolean agregarMiembro(MiembroGrupoDTO miembroDTO, String idGrupo);



}
