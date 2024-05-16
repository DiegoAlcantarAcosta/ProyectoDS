/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces.daos;

import entidades.Contacto;
import entidades.Grupo;
import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */
public interface IGrupoDAO {
ObjectId crearGrupo(Grupo grupo);
    Grupo obtenerGrupoPorID(ObjectId  id);
        Boolean agregarContacto(Contacto contacto, String idGrupo);

}
