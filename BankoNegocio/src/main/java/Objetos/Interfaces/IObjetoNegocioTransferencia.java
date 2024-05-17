/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Objetos.Interfaces;

import DTOs.TarjetaDTO;
import DTOs.TransferenciaDTO;
import java.io.ByteArrayOutputStream;
import java.util.Date;
import java.util.List;

/**
 * Esta interfaz define los métodos que deben ser implementados por las clases
 * que manejan operaciones relacionadas con transferencias.
 *
 * @author Wilber
 */
public interface IObjetoNegocioTransferencia {
    

    public ByteArrayOutputStream imprimirPDF(TarjetaDTO tarjetaDTO, Date fechaInicio, Date fechaFin, boolean ingresos, boolean egresos);

    
    /**
     * Realiza una transferencia utilizando la información proporcionada en el
     * objeto TransferenciaDTO.
     *
     * @param transferenciaDTO El objeto TransferenciaDTO que contiene la
     * información de la transferencia.
     * @return true si la transferencia se realizó con éxito, false de lo
     * contrario.
     */
    public boolean realizarTransferencia(TransferenciaDTO transferenciaDTO);

    /**
     * Obtiene todas las transferencias de egreso de una tarjeta en un rango de
     * fechas.
     *
     * @param tarjetaDTO El objeto TarjetaDTO asociado a las transferencias.
     * @param fechaInicio La fecha de inicio del rango.
     * @param fechaFin La fecha de fin del rango.
     * @return Una lista de objetos TransferenciaDTO que representan las
     * transferencias de egreso.
     */
    public List<TransferenciaDTO> obtenerTransferenciasEgreso(TarjetaDTO tarjetaDTO, Date fechaInicio, Date fechaFin);

    /**
     * Obtiene todas las transferencias de ingreso de una tarjeta en un rango de
     * fechas.
     *
     * @param tarjetaDTO El objeto TarjetaDTO asociado a las transferencias.
     * @param fechaInicio La fecha de inicio del rango.
     * @param fechaFin La fecha de fin del rango.
     * @return Una lista de objetos TransferenciaDTO que representan las
     * transferencias de ingreso.
     */
    public List<TransferenciaDTO> obtenerTransferenciasIngreso(TarjetaDTO tarjetaDTO, Date fechaInicio, Date fechaFin);

    /**
     * Obtiene todas las transferencias asociadas a una tarjeta en un rango de
     * fechas.
     *
     * @param tarjetaDTO El objeto TarjetaDTO asociado a las transferencias.
     * @param fechaInicio La fecha de inicio del rango.
     * @param fechaFin La fecha de fin del rango.
     * @return Una lista de objetos TransferenciaDTO que representan todas las
     * transferencias asociadas a la tarjeta en el rango especificado.
     */
    public List<TransferenciaDTO> obtenerTransferencias(TarjetaDTO tarjetaDTO, Date fechaInicio, Date fechaFin);

    /**
     * Obtiene el total de ingresos realizados en un día específico mediante una
     * tarjeta.
     *
     * @param tarjetaDTO El objeto TarjetaDTO asociado a los ingresos.
     * @return El total de ingresos realizados en el día mediante la tarjeta.
     */
    public Double ingresosDelDia(TarjetaDTO tarjetaDTO);

    /**
     * Obtiene el total de egresos realizados en un día específico mediante una
     * tarjeta.
     *
     * @param tarjetaDTO El objeto TarjetaDTO asociado a los egresos.
     * @return El total de egresos realizados en el día mediante la tarjeta.
     */
    public Double egresosDelDia(TarjetaDTO tarjetaDTO);

    /**
     * Obtiene todas las transferencias asociadas a una tarjeta sin tener en
     * cuenta la fecha.
     *
     * @param tarjetaDTO El objeto TarjetaDTO asociado a las transferencias.
     * @return Una lista de objetos TransferenciaDTO que representan todas las
     * transferencias asociadas a la tarjeta.
     */
    public List<TransferenciaDTO> obtenerTransferenciasSinFecha(TarjetaDTO tarjetaDTO);
}
