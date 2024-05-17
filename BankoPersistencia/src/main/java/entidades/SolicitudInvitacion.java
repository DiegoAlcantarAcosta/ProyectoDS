/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */

public class SolicitudInvitacion {

   
    private ObjectId usuarioId;
    private String mensaje;
private double monto;
    private String numeroCuentaContacto; 

 

 public SolicitudInvitacion(ObjectId idUsuario, String mensaje, double monto, String numeroCuentaContacto) {
       this.usuarioId=idUsuario;
     this.mensaje = mensaje;
        this.monto = monto;
        this.numeroCuentaContacto = numeroCuentaContacto; // Asignamos el número de cuenta proporcionado
    }

    public SolicitudInvitacion() {
    }

    public ObjectId getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(ObjectId usuarioId) {
        this.usuarioId = usuarioId;
    }

  

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getNumeroCuentaContacto() {
        return numeroCuentaContacto;
    }

    public void setNumeroCuentaContacto(String numeroCuentaContacto) {
        this.numeroCuentaContacto = numeroCuentaContacto;
    }


    
}
