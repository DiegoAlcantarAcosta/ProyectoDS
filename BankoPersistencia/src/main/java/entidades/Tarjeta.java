
package entidades;

import java.util.Calendar;
import java.util.Date;
import org.bson.types.ObjectId;

/**
 *
 * @author Wilber
 */

public class Tarjeta {

    private ObjectId id;
    private String numeroCuenta;
    private tipoTarjeta tipo;
    private tipoBanco banco;
    private Double saldo;
    private Date fechaVencimiento;

    public Tarjeta(ObjectId id, String numeroCuenta, tipoTarjeta tipo, tipoBanco banco, Double saldo, Date fechaVencimiento) {
        this.id = id;
        this.numeroCuenta = numeroCuenta;
        this.tipo = tipo;
        this.banco = banco;
        this.saldo = saldo;
        this.fechaVencimiento = fechaVencimiento;
    }

    
    
    public Tarjeta(String numeroCuenta, tipoTarjeta tipo, tipoBanco banco, Double saldo, Date fechaVencimiento) {
        this.numeroCuenta = numeroCuenta;
        this.tipo = tipo;
        this.banco = banco;
        this.saldo = saldo;
        this.fechaVencimiento = fechaVencimiento;
    }   
    
    public Tarjeta() {
    }

    public Tarjeta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
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

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    @Override
    public String toString() {
        return "Tarjeta{" + "id=" + id + ", numeroCuenta=" + numeroCuenta + ", tipo=" + tipo + ", banco=" + banco + ", saldo=" + saldo + ", fechaVencimiento=" + fechaVencimiento  + '}';
    }
}
