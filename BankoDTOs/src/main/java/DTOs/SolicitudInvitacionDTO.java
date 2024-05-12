/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

/**
 *
 * @author Oley
 */
public class SolicitudInvitacionDTO {
      private String id; 
    private String remitente;
    private String receptor; 
    private String mensaje; 
    private boolean aceptada; 

    // Constructor
    public SolicitudInvitacionDTO(String id, String remitente, String receptor, String mensaje, boolean aceptada) {
        this.id = id;
        this.remitente = remitente;
        this.receptor = receptor;
        this.mensaje = mensaje;
        this.aceptada = aceptada;
    }

    // Getters y setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public String getReceptor() {
        return receptor;
    }

    public void setReceptor(String receptor) {
        this.receptor = receptor;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public boolean isAceptada() {
        return aceptada;
    }

    public void setAceptada(boolean aceptada) {
        this.aceptada = aceptada;
    }
}
