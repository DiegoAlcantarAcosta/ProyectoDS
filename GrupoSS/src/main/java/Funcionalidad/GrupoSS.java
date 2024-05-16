/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funcionalidad;

import DTOs.GrupoDTO;
import DTOs.MiembroGrupoDTO;
import Objetos.Interfaces.IObjetoNegocioGrupo;
import Objetos.ObjetoNegocioGrupo;
import entidades.Grupo;
import interfaces.daos.IGrupoDAO;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */
public class GrupoSS implements IGrupoSS {

    private final IObjetoNegocioGrupo objetoNegocioGrupo;

    public GrupoSS() {
        this.objetoNegocioGrupo = new ObjetoNegocioGrupo();
    }

    @Override
    public ObjectId crearGrupo(GrupoDTO grupoDTO) {
       return objetoNegocioGrupo.crearGrupo(grupoDTO);

    }

}
