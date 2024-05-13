/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Funcionalidad;

import DTOs.MovimientoDTO;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Wilber
 */
public interface IMovimientosSS {
    
    public List<MovimientoDTO> obtenerMovimientos(ObjectId userId, Date fechaInicio, Date fechaFin, boolean ingresos, boolean egresos);
    
}
