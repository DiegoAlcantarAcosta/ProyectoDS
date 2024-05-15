/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

import DTOs.MiembroGrupoDTO;
import Objetos.Interfaces.IObjetoNegocioMiembroGrupo;
import entidades.MiembroGrupo;
import interfaces.daos.IMiembroGrupoDAO;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */
public class ObjetoNegocioMiembroGrupo implements IObjetoNegocioMiembroGrupo {
    private final IMiembroGrupoDAO mongoMiembroGrupoDAO;

    /**
     * Constructor que inicializa
     * @param mongoMiembroGrupoDAO  miembro grupo
     */
    public ObjetoNegocioMiembroGrupo(IMiembroGrupoDAO mongoMiembroGrupoDAO) {
        this.mongoMiembroGrupoDAO = mongoMiembroGrupoDAO;
    }

    /***
     * Conviertye miembroGrupo
     * @param miembroGrupoDTO miembr grupo
     * @return  miembreGrupo
     */
    private MiembroGrupo convertirAMiembroGrupo(MiembroGrupoDTO miembroGrupoDTO) {
        MiembroGrupo miembroGrupo = new MiembroGrupo();
        // Asignar valores del DTO a la entidad
        miembroGrupo.setNombre(miembroGrupoDTO.getNombre());
        miembroGrupo.setApellidoP(miembroGrupoDTO.getApellidoPaterno());
        miembroGrupo.setApellidoM(miembroGrupoDTO.getApellidoMaterno());
        return miembroGrupo;
    }

    /***
     * convertir miembro a grupoDTO
     * @param miembroGrupo miembroGruupo
     * @return  miembroGruupoDTO
     */
    private MiembroGrupoDTO convertirAMiembroGrupoDTO(MiembroGrupo miembroGrupo) {
        MiembroGrupoDTO miembroGrupoDTO = new MiembroGrupoDTO();
        // Asignar valores de la entidad al DTO
        miembroGrupoDTO.setId(miembroGrupo.getId());
        miembroGrupoDTO.setNombre(miembroGrupo.getNombre());
        miembroGrupoDTO.setApellidoPaterno(miembroGrupo.getApellidoP());
        miembroGrupoDTO.setApellidoMaterno(miembroGrupo.getApellidoM());
        return miembroGrupoDTO;
    }

    /**
     * convertir miembroGrupoDTO
     * @param miembrosGrupo miembro
     * @return  lista de miembrosGrupoDTO
     */
    private List<MiembroGrupoDTO> convertirAMiembrosGrupoDTO(List<MiembroGrupo> miembrosGrupo) {
        List<MiembroGrupoDTO> miembrosGrupoDTO = new ArrayList<>();
        for (MiembroGrupo miembroGrupo : miembrosGrupo) {
            miembrosGrupoDTO.add(convertirAMiembroGrupoDTO(miembroGrupo));
        }
        return miembrosGrupoDTO;
    }

    /**
     * Metodo para agregar un miembro a un grupo
     * @param miembroDTO miembroDTO
     * @param idGrupo di grupo
     * @return  true o false
     */
    @Override
    public Boolean agregarMiembro(MiembroGrupoDTO miembroDTO, String idGrupo) {
  try {
        ObjectId grupoId = new ObjectId(idGrupo); 
        MiembroGrupo miembroGrupo = convertirAMiembroGrupo(miembroDTO);
        return mongoMiembroGrupoDAO.agregarMiembro(miembroGrupo, grupoId);
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
}

    

   
    
}