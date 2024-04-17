
package entidades;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Wilber
 */
@Entity
@Table (name = "Tarjetas")
public class Tarjeta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "numero_tarjeta", nullable = false)
    private String numeroCuenta;
    
    @Column (name = "tipo_tarjeta", nullable = false)
    @Enumerated (EnumType.STRING)
    private tipoTarjeta tipo;
    
    @Column (name = "banco", nullable = false)
    @Enumerated (EnumType.STRING)
    private tipoBanco banco;
    
    @Column (name = "saldo", nullable = true)
    private Double saldo;
    
    @Column (name = "fecha_vencimiento", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar fechaVencimiento;
    
    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "id_persona", nullable = false)
    private Persona persona;

    public Tarjeta(String numeroCuenta, tipoTarjeta tipo, tipoBanco banco, Double saldo, Calendar fechaVencimiento, Persona persona) {
        this.numeroCuenta = numeroCuenta;
        this.tipo = tipo;
        this.banco = banco;
        this.saldo = saldo;
        this.fechaVencimiento = fechaVencimiento;
        this.persona = persona;
    }   
    
    public Tarjeta() {
    }

    public Tarjeta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public tipoTarjeta getTipo() {
        return tipo;
    }

    public void setTipo(tipoTarjeta tipo) {
        this.tipo = tipo;
    }

    public tipoBanco getBanco() {
        return banco;
    }

    public void setBanco(tipoBanco banco) {
        this.banco = banco;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Calendar getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Calendar fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public String toString() {
        return "Tarjeta{" + "id=" + id + ", numeroCuenta=" + numeroCuenta + ", tipo=" + tipo + ", banco=" + banco + ", saldo=" + saldo + ", fechaVencimiento=" + fechaVencimiento + ", persona=" + persona + '}';
    }

    
    
}
