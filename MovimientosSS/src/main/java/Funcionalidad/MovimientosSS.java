/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funcionalidad;

import DTOs.MovimientoDTO;
import Objetos.Interfaces.IObjetoNegocioMovimiento;
import Objetos.ObjetoNegocioMovimiento;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Wilber
 */
public class MovimientosSS implements IMovimientosSS {

    IObjetoNegocioMovimiento movimiento;

    public MovimientosSS() {
        movimiento = new ObjetoNegocioMovimiento();

    }

    @Override
    public List<MovimientoDTO> obtenerMovimientos(ObjectId userId, Date fechaInicio, Date fechaFin, boolean ingresos, boolean egresos) {
        return movimiento.obtenerMovimientos(userId, fechaInicio, fechaFin, ingresos, egresos);
    
    }
    
}

