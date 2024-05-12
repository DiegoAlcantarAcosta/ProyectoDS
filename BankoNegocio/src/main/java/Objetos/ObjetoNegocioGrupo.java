/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

import DAOS.GrupoDAO;
import DAOS.MiembroGrupoDAO;
import DAOS.TransaccionDAO;
import DTOs.GrupoDTO;
import DTOs.MiembroGrupoDTO;
import Objetos.Interfaces.IObjetoNegocioGrupo;
import entidades.Grupo;
import entidades.MiembroGrupo;
import interfaces.daos.IGrupoDAO;
import interfaces.daos.ITransaccionDAO;
import interfaces.daos.IMiembroGrupoDAO;
import org.bson.types.ObjectId;
import interfaces.daos.IGrupoDAO;

/**
 *
 * @author Oley
 */
public class ObjetoNegocioGrupo implements IObjetoNegocioGrupo {

  IGrupoDAO grupoDAO;
    IMiembroGrupoDAO miembroGrupoDAO;
    ITransaccionDAO transaccionDAO;

    public ObjetoNegocioGrupo(IGrupoDAO grupoDAO, IMiembroGrupoDAO miembroGrupoDAO, ITransaccionDAO transaccionDAO) {
        this.grupoDAO = grupoDAO;
        this.miembroGrupoDAO = miembroGrupoDAO;
        this.transaccionDAO = transaccionDAO;
    }

    

    public Grupo convertirDTOAEntidad(GrupoDTO grupoDTO) {
        Grupo grupo = new Grupo(grupoDTO.getNombre(), grupoDTO.getSaldo(), grupoDTO.getMotivo());
        return grupo;
    }

    public GrupoDTO convertirEntidadADTO(Grupo grupo) {
        if (grupo != null) {
        GrupoDTO grupoDTO = new GrupoDTO();
        grupoDTO.setNombre(grupo.getNombre());
        grupoDTO.setSaldo(grupo.getMontoTotal());
        grupoDTO.setMotivo(grupo.getMotivo());
        return grupoDTO;
    } else {
        return null; // Devolver null si el grupo es null
    }
    }

    @Override
   public Boolean crearGrupo(GrupoDTO grupoDTO) {
    Grupo grupo = this.convertirDTOAEntidad(grupoDTO);
    Boolean creado = grupoDAO.crearGrupo(grupo);
    return creado;
}

    @Override
    public GrupoDTO obtenerGrupoPorId(String id) {
        ObjectId objectId = new ObjectId(id);
        Grupo grupo = grupoDAO.obtenerGrupoPorID(objectId);
        GrupoDTO grupoDTO = convertirEntidadADTO(grupo);
        return grupoDTO;
    }

    @Override
    public Boolean agregarMiembro(MiembroGrupoDTO miembroDTO, String idGrupo) {
        ObjectId objectId = new ObjectId(idGrupo);
        MiembroGrupo miembroGrupo = convertirDTOAEntidadMiembro(miembroDTO);
        Boolean agregado = miembroGrupoDAO.agregarMiembro(miembroGrupo, objectId);
        return agregado;
    }

    private MiembroGrupo convertirDTOAEntidadMiembro(MiembroGrupoDTO miembroDTO) {
        MiembroGrupo miembroGrupo = new MiembroGrupo();
        miembroGrupo.setNombre(miembroDTO.getNombre());
        return miembroGrupo;
    }

    private MiembroGrupoDTO convertirEntidadADTOMiembro(MiembroGrupo miembroGrupo) {
        MiembroGrupoDTO miembroDTO = new MiembroGrupoDTO();
        miembroDTO.setNombre(miembroGrupo.getNombre());
        return miembroDTO;
    }

}
 