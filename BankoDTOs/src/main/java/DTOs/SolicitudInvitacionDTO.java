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
    
    /**
     * El identificador único de la solicitud.
     */
    private String id;
    
    /**
     * El remitente de la solicitud.
     */
    private String remitente;
    
    /**
     * El receptor de la solicitud.
     */
    private String receptor;
    
    /**
     * El mensaje incluido en la solicitud.
     */
    private String mensaje;
    
    /**
     * Indica si la solicitud ha sido aceptada o no.
     */
    private boolean aceptada;

    /**
     * Constructor de la clase SolicitudInvitacionDTO.
     * 
     * @param id El identificador único de la solicitud.
     * @param remitente El remitente de la solicitud.
     * @param receptor El receptor de la solicitud.
     * @param mensaje El mensaje incluido en la solicitud.
     * @param aceptada Indica si la solicitud ha sido aceptada o no.
     */
    public SolicitudInvitacionDTO(String id, String remitente, String receptor, String mensaje, boolean aceptada) {
        this.id = id;
        this.remitente = remitente;
        this.receptor = receptor;
        this.mensaje = mensaje;
        this.aceptada = aceptada;
    }

    // Getters y setters
    
    /**
     * Obtiene el identificador único de la solicitud.
     * 
     * @return El identificador único de la solicitud.
     */
    public String getId() {
        return id;
    }

    /**
     * Establece el identificador único de la solicitud.
     * 
     * @param id El nuevo identificador único de la solicitud.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtiene el remitente de la solicitud.
     * 
     * @return El remitente de la solicitud.
     */
    public String getRemitente() {
        return remitente;
    }

    /**
     * Establece el remitente de la solicitud.
     * 
     * @param remitente El nuevo remitente de la solicitud.
     */
    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    /**
     * Obtiene el receptor de la solicitud.
     * 
     * @return El receptor de la solicitud.
     */
    public String getReceptor() {
        return receptor;
    }

    /**
     * Establece el receptor de la solicitud.
     * 
     * @param receptor El nuevo receptor de la solicitud.
     */
    public void setReceptor(String receptor) {
        this.receptor = receptor;
    }

    /**
     * Obtiene el mensaje incluido en la solicitud.
     * 
     * @return El mensaje incluido en la solicitud.
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * Establece el mensaje incluido en la solicitud.
     * 
     * @param mensaje El nuevo mensaje incluido en la solicitud.
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * Verifica si la solicitud ha sido aceptada.
     * 
     * @return Verdadero si la solicitud ha sido aceptada, falso en caso contrario.
     */
    public boolean isAceptada() {
        return aceptada;
    }

    /**
     * Establece si la solicitud ha sido aceptada o no.
     * 
     * @param aceptada Verdadero si la solicitud ha sido aceptada, falso en caso contrario.
     */
    public void setAceptada(boolean aceptada) {
        this.aceptada = aceptada;
    }
}
