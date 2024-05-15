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
 * La interfaz IMovimientosTransferenciasSS define los métodos que deben ser
 * implementados para proporcionar funcionalidades relacionadas con los
 * movimientos de transferencias financieras y las consultas asociadas a
 * tarjetas.
 *
 * @author Wilber
 */
public interface IMovimientosTransferenciasSS {
//hola
    ////holaaa
    /**
     * Obtiene una lista de transferencias de egreso asociadas a una tarjeta
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
    public List<TransferenciaDTO> obtenerTransferenciasEgreso(TarjetaDTO tarjetaDTO, Date fechaInicio, Date fechaFin);

    /**
     * Obtiene una lista de transferencias de ingreso asociadas a una tarjeta
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
    public List<TransferenciaDTO> obtenerTransferenciasIngreso(TarjetaDTO tarjetaDTO, Date fechaInicio, Date fechaFin);

    /**
     * Obtiene una lista de todas las transferencias asociadas a una tarjeta
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
    public List<TransferenciaDTO> obtenerTransferencias(TarjetaDTO tarjetaDTO, Date fechaInicio, Date fechaFin);

    /**
     * Obtiene el total de ingresos realizados en el día para una tarjeta
     * específica.
     *
     * @param tarjetaDTO El objeto TarjetaDTO asociado a la tarjeta de la cual
     * se desea obtener el total de ingresos.
     * @return El total de ingresos realizados en el día para la tarjeta
     * especificada.
     */
    public Double ingresosDelDia(TarjetaDTO tarjetaDTO);

    /**
     * Obtiene el total de egresos realizados en el día para una tarjeta
     * específica.
     *
     * @param tarjetaDTO El objeto TarjetaDTO asociado a la tarjeta de la cual
     * se desea obtener el total de egresos.
     * @return El total de egresos realizados en el día para la tarjeta
     * especificada.
     */
    public Double egresosDelDia(TarjetaDTO tarjetaDTO);

    /**
     * Obtiene una lista de todas las transferencias asociadas a una tarjeta sin
     * tener en cuenta la fecha.
     *
     * @param tarjetaDTO El objeto TarjetaDTO asociado a la tarjeta de la cual
     * se desean obtener todas las transferencias.
     * @return Una lista de TransferenciaDTO que contiene todas las
     * transferencias encontradas.
     */
    public List<TransferenciaDTO> obtenerTransferenciasSinFecha(TarjetaDTO tarjetaDTO);
}
