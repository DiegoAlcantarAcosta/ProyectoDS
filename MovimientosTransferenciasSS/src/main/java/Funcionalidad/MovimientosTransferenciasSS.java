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
 * La clase MovimientosTransferenciasSS implementa la interfaz
 * IMovimientosTransferenciasSS y actúa como intermediario entre la interfaz de
 * transferencias (IObjetoNegocioTransferencia) y el resto del sistema.
 * Proporciona métodos para obtener información sobre transferencias financieras
 * y operaciones relacionadas con tarjetas.
 *
 * @author Wilber
 */
public class MovimientosTransferenciasSS implements IMovimientosTransferenciasSS {

    IObjetoNegocioTransferencia transferencia;

    /**
     * Constructor por defecto que inicializa el atributo transferencia con una
     * nueva instancia de ObjetoNegocioTransferencia.
     */
    public MovimientosTransferenciasSS() {
        this.transferencia = new ObjetoNegocioTransferencia();

    }

    /**
     * Retorna una lista de transferencias de egreso asociadas a una tarjeta
     * dentro de un rango de fechas específico.
     *
     * @param tarjetaDTO El objeto TarjetaDTO asociado a la tarjeta de la cual
     * se desean obtener las transferencias de egreso.
     * @param fechaInicio La fecha de inicio del rango de fechas para la
     * búsqueda de transferencias.
     * @param fechaFin La fecha de fin del rango de fechas para la búsqueda de
     * transferencias.
     * @return Una lista de TransferenciaDTO que contiene las transferencias de
     * egreso encontradas.
     */
    @Override
    public List<TransferenciaDTO> obtenerTransferenciasEgreso(TarjetaDTO tarjetaDTO, Date fechaInicio, Date fechaFin) {
        return transferencia.obtenerTransferenciasEgreso(tarjetaDTO, fechaInicio, fechaFin);
    }

    /**
     * Retorna una lista de transferencias de ingreso asociadas a una tarjeta
     * dentro de un rango de fechas específico.
     *
     * @param tarjetaDTO El objeto TarjetaDTO asociado a la tarjeta de la cual
     * se desean obtener las transferencias de ingreso.
     * @param fechaInicio La fecha de inicio del rango de fechas para la
     * búsqueda de transferencias.
     * @param fechaFin La fecha de fin del rango de fechas para la búsqueda de
     * transferencias.
     * @return Una lista de TransferenciaDTO que contiene las transferencias de
     * ingreso encontradas.
     */
    @Override
    public List<TransferenciaDTO> obtenerTransferenciasIngreso(TarjetaDTO tarjetaDTO, Date fechaInicio, Date fechaFin) {
        return transferencia.obtenerTransferenciasIngreso(tarjetaDTO, fechaInicio, fechaFin);
    }

    /**
     * Retorna una lista de todas las transferencias asociadas a una tarjeta
     * dentro de un rango de fechas específico.
     *
     * @param tarjetaDTO El objeto TarjetaDTO asociado a la tarjeta de la cual
     * se desean obtener todas las transferencias.
     * @param fechaInicio La fecha de inicio del rango de fechas para la
     * búsqueda de transferencias.
     * @param fechaFin La fecha de fin del rango de fechas para la búsqueda de
     * transferencias.
     * @return Una lista de TransferenciaDTO que contiene todas las
     * transferencias encontradas.
     */
    @Override
    public List<TransferenciaDTO> obtenerTransferencias(TarjetaDTO tarjetaDTO, Date fechaInicio, Date fechaFin) {
        return transferencia.obtenerTransferencias(tarjetaDTO, fechaInicio, fechaFin);

    }

    /**
     * Retorna el total de ingresos realizados en el día para una tarjeta
     * específica.
     *
     * @param tarjetaDTO El objeto TarjetaDTO asociado a la tarjeta de la cual
     * se desea obtener el total de ingresos.
     * @return El total de ingresos realizados en el día para la tarjeta
     * especificada.
     */
    @Override
    public Double ingresosDelDia(TarjetaDTO tarjetaDTO) {
        return transferencia.ingresosDelDia(tarjetaDTO);
    }

    /**
     * Retorna el total de egresos realizados en el día para una tarjeta
     * específica.
     *
     * @param tarjetaDTO El objeto TarjetaDTO asociado a la tarjeta de la cual
     * se desea obtener el total de egresos.
     * @return El total de egresos realizados en el día para la tarjeta
     * especificada.
     */
    @Override
    public Double egresosDelDia(TarjetaDTO tarjetaDTO) {
        return transferencia.egresosDelDia(tarjetaDTO);

    }

    /**
     * Retorna una lista de todas las transferencias asociadas a una tarjeta sin
     * tener en cuenta la fecha.
     *
     * @param tarjetaDTO El objeto TarjetaDTO asociado a la tarjeta de la cual
     * se desean obtener todas las transferencias.
     * @return Una lista de TransferenciaDTO que contiene todas las
     * transferencias encontradas.
     */
    @Override
    public List<TransferenciaDTO> obtenerTransferenciasSinFecha(TarjetaDTO tarjetaDTO) {
        return transferencia.obtenerTransferenciasSinFecha(tarjetaDTO);
    }

}
