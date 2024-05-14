/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Funcionalidad;

import DTOs.TarjetaDTO;
import DTOs.TransferenciaDTO;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Wilber
 */
public interface IMovimientosTransferenciasSS {

    public List<TransferenciaDTO> obtenerTransferenciasEgreso(TarjetaDTO tarjetaDTO, Date fechaInicio, Date fechaFin);

    public List<TransferenciaDTO> obtenerTransferenciasIngreso(TarjetaDTO tarjetaDTO, Date fechaInicio, Date fechaFin);

    public List<TransferenciaDTO> obtenerTransferencias(TarjetaDTO tarjetaDTO, Date fechaInicio, Date fechaFin);

    public Double ingresosDelDia (TarjetaDTO tarjetaDTO);
    
    public Double egresosDelDia (TarjetaDTO tarjetaDTO);
}
