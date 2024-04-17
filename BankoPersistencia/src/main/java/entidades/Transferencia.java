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

/**
 *
 * @author Wilber
 */
@Entity
@Table(name = "transferencias")
public class Transferencia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_tarjetaDestinatario", nullable = false)
    private String numeroCuentaDestinatario;
    
    @Column(name = "numero_tarjetaPropietario", nullable = false)
    private String numeroCuentaPropietario;
    
    @Column(name = "importe", nullable = false)
    private Double  importe;
    
    @Column(name = "motivo", nullable = false)
    private String motivo;
    
    @Column(name = "fecha_importe", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaMovimiento;
    
     @ManyToOne
    @JoinColumn(name = "persona_id_origen")
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "tarjeta_id_origen")
    private Tarjeta tarjeta;

    public Transferencia() {
    }

    public Transferencia(String numeroCuentaDestinatario, String numeroCuentaPropietario, Double  importe, String motivo, Date fechaMovimiento) {
        this.numeroCuentaDestinatario = numeroCuentaDestinatario;
        this.numeroCuentaPropietario = numeroCuentaPropietario;
        this.importe = importe;
        this.motivo = motivo;
        this.fechaMovimiento = fechaMovimiento;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        return "entidades.Transferencia[ id=" + id + " ]";
    }

}