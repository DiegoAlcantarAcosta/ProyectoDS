/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces.daos;

import entidades.Grupo;
import entidades.Transaccion;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */
public interface ITransaccionDAO {

      void registrarTransaccion(Transaccion transaccion);
    List<Transaccion> obtenerTransacccionesPorGrupo(ObjectId grupoId);
}
