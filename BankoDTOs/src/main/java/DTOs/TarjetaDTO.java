package DTOs;

import entidades.Persona;
import java.util.Calendar;
import java.util.Date;
import org.bson.types.ObjectId;

/**
 *
 * @author Wilber
 */
public class TarjetaDTO {
    
    private ObjectId id;
    private String numeroCuenta;
    private tipoTarjetaDTO tipo;
    private tipoBancoDTO banco;
    private Double saldo;
    private Date fechaVencimiento;

    public TarjetaDTO(ObjectId id, String numeroCuenta, tipoTarjetaDTO tipo, tipoBancoDTO banco, Double saldo, Date fechaVencimiento) {
        this.id = id;
        this.numeroCuenta = numeroCuenta;
        this.tipo = tipo;
        this.banco = banco;
        this.saldo = saldo;
        this.fechaVencimiento = fechaVencimiento;
    }

    public TarjetaDTO(String numeroCuenta, tipoTarjetaDTO tipo, tipoBancoDTO banco, Double saldo, Date fechaVencimiento) {
        this.numeroCuenta = numeroCuenta;
        this.tipo = tipo;
        this.banco = banco;
        this.saldo = saldo;
        this.fechaVencimiento = fechaVencimiento;
    }

    public TarjetaDTO() {
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    
    
    public TarjetaDTO(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public tipoTarjetaDTO getTipo() {
        return tipo;
    }

    public void setTipo(tipoTarjetaDTO tipo) {
        this.tipo = tipo;
    }

    public tipoBancoDTO getBanco() {
        return banco;
    }

    public void setBanco(tipoBancoDTO banco) {
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
        return "TarjetaDTO{" + "numeroCuenta=" + numeroCuenta + ", tipo=" + tipo + ", banco=" + banco + ", saldo=" + saldo + ", fechaVencimiento=" + fechaVencimiento + '}';
    }

    
    
}
