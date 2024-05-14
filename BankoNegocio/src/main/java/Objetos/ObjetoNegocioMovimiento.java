/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

import DTOs.MovimientoDTO;
import Objetos.Interfaces.IObjetoNegocioMovimiento;
import entidades.Movimiento;
import entidades.tipoBanco;
import interfaces.daos.IMovimientoDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Wilber
 */
public class ObjetoNegocioMovimiento implements IObjetoNegocioMovimiento{
    
      IMovimientoDAO movimientoDAO;
      private ObjetoNegocioMovimiento onm;

    public ObjetoNegocioMovimiento() {
    this.movimientoDAO = movimientoDAO;
    }

//     @Override
//    public List<MovimientoDTO> obtenerMovimientos(ObjectId userId, Date fechaInicio, Date fechaFin, boolean ingresos, boolean egresos) {
//        return movimientoDAO.obtenerMovimientos(userId, fechaInicio, fechaFin, ingresos, egresos);
//    }
    
      @Override
    public List<MovimientoDTO> obtenerMovimientos(ObjectId userId, Date fechaInicio, Date fechaFin, boolean ingresos, boolean egresos) {
        List<Movimiento> movimientosEntidad = movimientoDAO.obtenerMovimientos(userId, fechaInicio, fechaFin, ingresos, egresos);
        List<MovimientoDTO> movimientosDTO = new ArrayList<>();
  
        for (Movimiento movimiento : movimientosEntidad) {
            MovimientoDTO movimientoDTO = onm.convertirEntidadADTO(movimiento);
            movimientosDTO.add(movimientoDTO);
        }

        return movimientosDTO;
    }
    
     public void guardarMovimiento(Movimiento movimiento) {
        movimientoDAO.guardarMovimiento(movimiento);
    }
    
    
//   ---------------     POSIBLES ERRORES CON BANCO  ---------------
     
    public Movimiento convertirDTOAEntidad(MovimientoDTO movimientoDTO) {
        Movimiento movimiento = new Movimiento();
        movimiento.setNombre(movimientoDTO.getNombre());
        movimiento.setImporte(movimientoDTO.getImporte());
        movimiento.setMotivo(movimientoDTO.getMotivo());
        movimiento.setBanco(movimiento.getBanco());
        movimiento.setNumeroCuenta(movimientoDTO.getNumeroCuenta());
        movimiento.setFecha(movimientoDTO.getFecha());

        if (movimientoDTO.getId() != null) {
            movimiento.setId(movimientoDTO.getId());
        } else {
            movimiento.setId(new ObjectId());
        }

        return movimiento;
    }
    
    public MovimientoDTO convertirEntidadADTO(Movimiento movimiento) {
        MovimientoDTO movimientoDTO = new MovimientoDTO();
        movimientoDTO.setId(movimiento.getId());
        movimientoDTO.setNombre(movimiento.getNombre());
        movimientoDTO.setImporte(movimiento.getImporte());
        movimientoDTO.setMotivo(movimiento.getMotivo());
        movimientoDTO.setBanco(movimientoDTO.getBanco());
        movimientoDTO.setNumeroCuenta(movimiento.getNumeroCuenta());
        movimientoDTO.setFecha(movimiento.getFecha());

        return movimientoDTO;
    }
   
}
