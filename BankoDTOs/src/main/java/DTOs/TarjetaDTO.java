package DTOs;

import entidades.Persona;
import java.util.Calendar;

/**
 *
 * @author Wilber
 */
public class TarjetaDTO {

    private String numeroCuenta;
    private tipoTarjetaDTO tipo;
    private tipoBancoDTO banco;
    private Double saldo;
    private Calendar fechaVencimiento;
    private PersonaDTO persona;

    
    public TarjetaDTO(String numeroCuenta, tipoTarjetaDTO tipo, tipoBancoDTO banco, Double saldo, Calendar fechaVencimiento, PersonaDTO persona) {
        this.numeroCuenta = numeroCuenta;
        this.tipo = tipo;
        this.banco = banco;
        this.saldo = saldo;
        this.fechaVencimiento = fechaVencimiento;
        this.persona = persona;
    }

    public TarjetaDTO() {
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

    public Calendar getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Calendar fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public PersonaDTO getPersona() {
        return persona;
    }

    public void setPersona(PersonaDTO persona) {
        this.persona = persona;
    }

    @Override
    public String toString() {
        return "TarjetaDTO{" + "numeroCuenta=" + numeroCuenta + ", tipo=" + tipo + ", banco=" + banco + ", saldo=" + saldo + ", fechaVencimiento=" + fechaVencimiento + ", persona=" + persona + '}';
    }

    
    
}
