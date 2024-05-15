/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Objetos.Interfaces;

import DTOs.GrupoDTO;
import DTOs.MiembroGrupoDTO;

/**
 *
 * @author Oley
 */
public interface IObjetoNegocioGrupo {

    /**
     * metodo para crear grupo
     * @param grupoDTO grupo
     * @return  boolean
     */
    Boolean crearGrupo(GrupoDTO grupoDTO);

    /**
     * metodo para obtener grupo por id
     * @param id id
     * @return  grupoDTO
     */
    GrupoDTO obtenerGrupoPorId(String id);

    /***
     * metodo para agregar miembro
     * @param miembroDTO miembro
     * @param idGrupo idgrupo
     * @return  boolean
     */
    Boolean agregarMiembro(MiembroGrupoDTO miembroDTO, String idGrupo);
}
