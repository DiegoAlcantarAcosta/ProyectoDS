/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funcionalidad;

import DTOs.GrupoDTO;
import DTOs.MiembroGrupoDTO;
import entidades.Grupo;
import interfaces.daos.IGrupoDAO;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */
public class GrupoSS implements IGrupoSS{
      private final IGrupoDAO grupoDAO;
    private final IMiembroGrupoSS miembroGrupoSS;

    public GrupoSS(IGrupoDAO grupoDAO, IMiembroGrupoSS miembroGrupoSS) {
        this.grupoDAO = grupoDAO;
        this.miembroGrupoSS = miembroGrupoSS;
    }

    @Override
    public Boolean crearGrupo(GrupoDTO grupoDTO) {
        Grupo grupo = convertirAGrupo(grupoDTO);
        return grupoDAO.crearGrupo(grupo);
    }

    @Override
    public GrupoDTO obtenerGrupoPorId(ObjectId id) {
        Grupo grupo = grupoDAO.obtenerGrupoPorID(id);
        if (grupo != null) {
            return convertirAGrupoDTO(grupo);
        } else {
            return null;
        }
    }

    @Override
    public Boolean agregarMiembro(MiembroGrupoDTO miembroDTO, String idGrupo) {
        return miembroGrupoSS.agregarMiembro(miembroDTO, idGrupo);
    }

    private Grupo convertirAGrupo(GrupoDTO grupoDTO) {
     Grupo grupo = new Grupo();
    grupo.setNombre(grupoDTO.getNombre());
    grupo.setMontoTotal(grupoDTO.getSaldo());
    grupo.setMotivo(grupoDTO.getMotivo());
    return grupo;
   
    }

    private GrupoDTO convertirAGrupoDTO(Grupo grupo) {
    GrupoDTO grupoDTO = new GrupoDTO();
    grupoDTO.setNombre(grupo.getNombre());
    grupoDTO.setSaldo(grupo.getMontoTotal());
    grupoDTO.setMotivo(grupo.getMotivo());
    return grupoDTO;
    }
}
