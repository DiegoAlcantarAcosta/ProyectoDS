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

    public ObjetoNegocioMiembroGrupo(IMiembroGrupoDAO mongoMiembroGrupoDAO) {
        this.mongoMiembroGrupoDAO = mongoMiembroGrupoDAO;
    }

   

  

   

    

    private MiembroGrupo convertirAMiembroGrupo(MiembroGrupoDTO miembroGrupoDTO) {
        MiembroGrupo miembroGrupo = new MiembroGrupo();
        // Asignar valores del DTO a la entidad
        miembroGrupo.setNombre(miembroGrupoDTO.getNombre());
        miembroGrupo.setApellidoP(miembroGrupoDTO.getApellidoPaterno());
        miembroGrupo.setApellidoM(miembroGrupoDTO.getApellidoMaterno());
        return miembroGrupo;
    }

    private MiembroGrupoDTO convertirAMiembroGrupoDTO(MiembroGrupo miembroGrupo) {
        MiembroGrupoDTO miembroGrupoDTO = new MiembroGrupoDTO();
        // Asignar valores de la entidad al DTO
        miembroGrupoDTO.setId(miembroGrupo.getId());
        miembroGrupoDTO.setNombre(miembroGrupo.getNombre());
        miembroGrupoDTO.setApellidoPaterno(miembroGrupo.getApellidoP());
        miembroGrupoDTO.setApellidoMaterno(miembroGrupo.getApellidoM());
        return miembroGrupoDTO;
    }

    private List<MiembroGrupoDTO> convertirAMiembrosGrupoDTO(List<MiembroGrupo> miembrosGrupo) {
        List<MiembroGrupoDTO> miembrosGrupoDTO = new ArrayList<>();
        for (MiembroGrupo miembroGrupo : miembrosGrupo) {
            miembrosGrupoDTO.add(convertirAMiembroGrupoDTO(miembroGrupo));
        }
        return miembrosGrupoDTO;
    }

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