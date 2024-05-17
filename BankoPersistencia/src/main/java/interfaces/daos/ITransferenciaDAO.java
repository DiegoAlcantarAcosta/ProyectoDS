/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces.daos;

import entidades.Tarjeta;
import entidades.Transferencia;
import java.io.ByteArrayOutputStream;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * La interfaz ITransferenciaDAO define los métodos que deben ser implementados
 * por las clases que proporcionan funcionalidades relacionadas con las
 * transferencias financieras.
 *
 * @author Wilber
 */
public interface ITransferenciaDAO {

    /**
     * Realiza una transferencia financiera.
     *
     * @param transferencia La transferencia a realizar.
     * @return true si la transferencia se realizó con éxito, false en caso
     * contrario.
     */
    public boolean realizarTransferencia(Transferencia transferencia);

    /**
     * Obtiene una lista de transferencias de egreso realizadas desde una
     * tarjeta en un rango de fechas.
     *
     * @param tarjeta La tarjeta asociada a las transferencias de egreso.
     * @param fechaInicio La fecha de inicio del rango.
     * @param fechaFin La fecha de fin del rango.
     * @return Una lista de transferencias de egreso.
     */
    public List<Transferencia> obtenerTransferenciasEgreso(Tarjeta tarjeta, Date fechaInicio, Date fechaFin);

    /**
     * Obtiene una lista de transferencias de ingreso recibidas en una tarjeta
     * en un rango de fechas.
     *
     * @param tarjeta La tarjeta asociada a las transferencias de ingreso.
     * @param fechaInicio La fecha de inicio del rango.
     * @param fechaFin La fecha de fin del rango.
     * @return Una lista de transferencias de ingreso.
     */
    public List<Transferencia> obtenerTransferenciasIngreso(Tarjeta tarjeta, Date fechaInicio, Date fechaFin);

    /**
     * Obtiene una lista de todas las transferencias (tanto ingresos como
     * egresos) realizadas por una tarjeta dentro de un rango de fechas
     * especificado.
     *
     * @param tarjeta La tarjeta asociada a las transferencias.
     * @param fechaInicio La fecha de inicio del rango.
     * @param fechaFin La fecha de fin del rango.
     * @return Una lista de todas las transferencias realizadas por la tarjeta
     * en el rango de fechas especificado.
     */
    public List<Transferencia> obtenerTransferencias(Tarjeta tarjeta, Date fechaInicio, Date fechaFin);

    /**
     * Calcula el total de ingresos realizados por una tarjeta en el día actual.
     *
     * @param tarjeta La tarjeta asociada a los ingresos.
     * @return El total de ingresos realizados por la tarjeta en el día actual.
     */
    public Double ingresosDelDia(Tarjeta tarjeta);

    /**
     * Calcula el total de egresos realizados por una tarjeta en el día actual.
     *
     * @param tarjeta La tarjeta asociada a los egresos.
     * @return El total de egresos realizados por la tarjeta en el día actual.
     */
    public Double egresosDelDia(Tarjeta tarjeta);

    /**
     * Obtiene una lista de todas las transferencias (tanto ingresos como
     * egresos) realizadas por una tarjeta sin tener en cuenta la fecha.
     *
     * @param tarjeta La tarjeta asociada a las transferencias.
     * @return Una lista de todas las transferencias realizadas por la tarjeta
     * sin tener en cuenta la fecha.
     */
    public List<Transferencia> obtenerTransferenciasSinFecha(Tarjeta tarjeta);
    
    
   
    //completo
}
