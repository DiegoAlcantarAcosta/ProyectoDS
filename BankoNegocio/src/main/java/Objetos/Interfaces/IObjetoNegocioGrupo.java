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

    Boolean crearGrupo(GrupoDTO grupoDTO);

    GrupoDTO obtenerGrupoPorId(String id);

    Boolean agregarMiembro(MiembroGrupoDTO miembroDTO, String idGrupo);
}
