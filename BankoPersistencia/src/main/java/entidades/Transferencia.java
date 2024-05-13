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
import org.bson.types.ObjectId;

/**
 *
 * @author Wilber
 */
public class Transferencia {
    
    private ObjectId id;
    private String numeroCuentaDestinatario;
    private String numeroCuentaPropietario;
    private Double  importe;
    private String motivo;
    private Date fechaMovimiento;

    public Transferencia() {
    }

    public Transferencia(String numeroCuentaDestinatario, String numeroCuentaPropietario, Double  importe, String motivo, Date fechaMovimiento) {
        this.numeroCuentaDestinatario = numeroCuentaDestinatario;
        this.numeroCuentaPropietario = numeroCuentaPropietario;
        this.importe = importe;
        this.motivo = motivo;
        this.fechaMovimiento = fechaMovimiento;
    }

    public String getNumeroCuentaDestinatario() {
        return numeroCuentaDestinatario;
    }

    public void setNumeroCuentaDestinatario(String numeroCuentaDestinatario) {
        this.numeroCuentaDestinatario = numeroCuentaDestinatario;
    }

    public String getNumeroCuentaPropietario() {
        return numeroCuentaPropietario;
    }

    public void setNumeroCuentaPropietario(String numeroCuentaPropietario) {
        this.numeroCuentaPropietario = numeroCuentaPropietario;
    }

    public Double  getImporte() {
        return importe;
    }

    public void setImporte(Double  importe) {
        this.importe = importe;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Date getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(Date fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    @Override
    public String toString() {
        return "Transferencia{" + "id=" + id + ", numeroCuentaDestinatario=" + numeroCuentaDestinatario + ", numeroCuentaPropietario=" + numeroCuentaPropietario + ", importe=" + importe + ", motivo=" + motivo + ", fechaMovimiento=" + fechaMovimiento + '}';
    }

}