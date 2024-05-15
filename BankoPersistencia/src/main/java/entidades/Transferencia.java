/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.bson.BsonDateTime;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 * La clase Transferencia representa una transacción financiera entre dos
 * cuentas.
 *
 * @author Wilber
 */
public class Transferencia {

    private ObjectId id;
    private String numeroCuentaDestinatario;
    private String numeroCuentaPropietario;
    private Double importe;
    private String motivo;
    private Date fechaMovimiento;
    // private BsonDateTime fechaMovimientoBson;

    public Transferencia() {
    }

    /**
     *  * Constructor parametrizado de la clase Transferencia.
     *
     * @param numeroCuentaDestinatario El número de cuenta del destinatario de
     * la transferencia.
     * @param numeroCuentaPropietario El número de cuenta del propietario de la
     * transferencia.
     * @param importe El importe de la transferencia.
     * @param motivo El motivo de la transferencia.
     * @param fechaMovimiento La fecha y hora de la transferencia.
     *
     */
    public Transferencia(String numeroCuentaDestinatario, String numeroCuentaPropietario, Double importe, String motivo, Date fechaMovimiento) {
        this.numeroCuentaDestinatario = numeroCuentaDestinatario;
        this.numeroCuentaPropietario = numeroCuentaPropietario;
        this.importe = importe;
        this.motivo = motivo;
        this.fechaMovimiento = fechaMovimiento;
    }

//    public BsonDateTime getFechaMovimientoBson() {
//        return fechaMovimientoBson;
//    }
//
//    public void setFechaMovimientoBson(BsonDateTime fechaMovimientoBson) {
//        this.fechaMovimientoBson = fechaMovimientoBson;
//    }
    /**
     * Obtiene el número de cuenta del destinatario de la transferencia.
     *
     * @return El número de cuenta del destinatario.
     */
    public String getNumeroCuentaDestinatario() {
        return numeroCuentaDestinatario;
    }

    /**
     * Establece el número de cuenta del destinatario de la transferencia.
     *
     * @param numeroCuentaDestinatario El número de cuenta del destinatario.
     */
    public void setNumeroCuentaDestinatario(String numeroCuentaDestinatario) {
        this.numeroCuentaDestinatario = numeroCuentaDestinatario;
    }

    /**
     * Obtiene el número de cuenta del propietario de la transferencia.
     *
     * @return El número de cuenta del propietario.
     */
    public String getNumeroCuentaPropietario() {
        return numeroCuentaPropietario;
    }

    /**
     * Establece el número de cuenta del propietario de la transferencia.
     *
     * @param numeroCuentaPropietario El número de cuenta del propietario.
     */
    public void setNumeroCuentaPropietario(String numeroCuentaPropietario) {
        this.numeroCuentaPropietario = numeroCuentaPropietario;
    }

    /**
     * Obtiene el importe de la transferencia.
     *
     * @return El importe de la transferencia.
     */
    public Double getImporte() {
        return importe;
    }

    /**
     * Establece el importe de la transferencia.
     *
     * @param importe El importe de la transferencia.
     */
    public void setImporte(Double importe) {
        this.importe = importe;
    }

    /**
     * Obtiene el motivo de la transferencia.
     *
     * @return El motivo de la transferencia.
     */
    public String getMotivo() {
        return motivo;
    }

    /**
     * Establece el motivo de la transferencia.
     *
     * @param motivo El motivo de la transferencia.
     */
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    /**
     * Obtiene el identificador único de la transferencia.
     *
     * @return El identificador único de la transferencia.
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el identificador único de la transferencia.
     *
     * @param id El identificador único de la transferencia.
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Obtiene la fecha y hora de la transferencia.
     *
     * @return La fecha y hora de la transferencia.
     */
    public Date getFechaMovimiento() {
        return fechaMovimiento;
    }

    /**
     * Establece la fecha y hora de la transferencia.
     *
     * @param fechaMovimiento La fecha y hora de la transferencia.
     */
    public void setFechaMovimiento(Date fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    /**
     * Devuelve una representación en forma de cadena de la transferencia.
     *
     * @return Una cadena que representa la transferencia.
     */
    @Override
    public String toString() {
        return "Transferencia{" + "id=" + id + ", numeroCuentaDestinatario=" + numeroCuentaDestinatario + ", numeroCuentaPropietario=" + numeroCuentaPropietario + ", importe=" + importe + ", motivo=" + motivo + ", fechaMovimiento=" + fechaMovimiento + '}';
    }

}
