/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guardado;

import entidades.Contacto;
import entidades.Persona;
import entidades.Tarjeta;
import entidades.Transferencia;

/**
 *
 * @author Usuario
 */
public class TransferenciaDatos {

    Persona persona = new Persona();
    Tarjeta tarjeta = new Tarjeta();
    Tarjeta tarjetaDestinatario = new Tarjeta();
    Contacto contacto = new Contacto();
    Transferencia tranferencia = new Transferencia();

    public Transferencia getTranferencia() {
        return tranferencia;
    }

    public void setTranferencia(Transferencia tranferencia) {
        this.tranferencia = tranferencia;
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

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    public Tarjeta getTarjetaDestinatario() {
        return tarjetaDestinatario;
    }

    public void setTarjetaDestinatario(Tarjeta tarjetaDestinatario) {
        this.tarjetaDestinatario = tarjetaDestinatario;
    }

}
