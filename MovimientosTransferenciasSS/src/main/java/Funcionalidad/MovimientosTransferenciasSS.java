/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funcionalidad;

import DTOs.TarjetaDTO;
import DTOs.TransferenciaDTO;
import Objetos.Interfaces.IObjetoNegocioTransferencia;
import Objetos.ObjetoNegocioTransferencia;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Wilber
 */
public class MovimientosTransferenciasSS implements IMovimientosTransferenciasSS {

    IObjetoNegocioTransferencia transferencia;

    public MovimientosTransferenciasSS() {
        this.transferencia = new ObjetoNegocioTransferencia();

    }

    @Override
    public List<TransferenciaDTO> obtenerTransferenciasEgreso(TarjetaDTO tarjetaDTO, Date fechaInicio, Date fechaFin) {
        return transferencia.obtenerTransferenciasEgreso(tarjetaDTO, fechaInicio, fechaFin);
    }

    @Override
    public List<TransferenciaDTO> obtenerTransferenciasIngreso(TarjetaDTO tarjetaDTO, Date fechaInicio, Date fechaFin) {
        return transferencia.obtenerTransferenciasIngreso(tarjetaDTO, fechaInicio, fechaFin);
    }

    @Override
    public List<TransferenciaDTO> obtenerTransferencias(TarjetaDTO tarjetaDTO, Date fechaInicio, Date fechaFin) {
        return transferencia.obtenerTransferencias(tarjetaDTO, fechaInicio, fechaFin);

    }

    @Override
    public Double ingresosDelDia(TarjetaDTO tarjetaDTO) {
        return transferencia.ingresosDelDia(tarjetaDTO);
    }

    @Override
    public Double egresosDelDia(TarjetaDTO tarjetaDTO) {
        return transferencia.egresosDelDia(tarjetaDTO);

    }
    
    @Override
    public List<TransferenciaDTO> obtenerTransferenciasSinFecha(TarjetaDTO tarjetaDTO){
        return transferencia.obtenerTransferenciasSinFecha(tarjetaDTO);
    }

}
