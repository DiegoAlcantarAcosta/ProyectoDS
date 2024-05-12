/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces.daos;

import entidades.Grupo;
import java.util.List;
import entidades.MiembroGrupo;
import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */
public interface IMiembroGrupoDAO {

    boolean agregarMiembro(MiembroGrupo miembroGrupo, ObjectId grupoId);

    List<MiembroGrupo> obtenerMiembrosPorGrupo(ObjectId grupoId);

}
