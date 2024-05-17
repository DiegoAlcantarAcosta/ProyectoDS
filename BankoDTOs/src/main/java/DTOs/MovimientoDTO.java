package DTOs;

import java.util.Date;
import org.bson.types.ObjectId;

/**
 * Clase que representa un movimiento financiero en el sistema.
 * 
 * <p>Esta clase almacena la información de un movimiento financiero, incluyendo
 * su nombre, importe, motivo, banco, número de cuenta y fecha.</p>
 * 
 * @author Wilber
 */
public class MovimientoDTO {
    
    /**
     * El identificador único del movimiento.
     */
    private ObjectId id;
    
    /**
     * El nombre del movimiento.
     */
    private String nombre;
    
    /**
     * El importe del movimiento.
     */
    private Double importe;
    
    /**
     * El motivo del movimiento.
     */
    private String motivo;
    
    /**
     * El banco asociado al movimiento.
     */
    private tipoBancoDTO banco;
    
    /**
     * El número de cuenta asociado al movimiento.
     */
    private String numeroCuenta;  
    
    /**
     * La fecha del movimiento.
     */
    private Date fecha;
    
    
    /**
     * Constructor vacío de la clase MovimientoDTO.
     */
     public MovimientoDTO() {
        // Constructor vacío
    }

    /**
     * Constructor de la clase MovimientoDTO.
     * 
     * @param id El identificador único del movimiento.
     * @param nombre El nombre del movimiento.
     * @param importe El importe del movimiento.
     * @param motivo El motivo del movimiento.
     * @param banco El banco asociado al movimiento.
     * @param numeroCuenta El número de cuenta asociado al movimiento.
     * @param fecha La fecha del movimiento.
     */
    public MovimientoDTO(ObjectId id, String nombre, Double importe, String motivo, tipoBancoDTO banco, String numeroCuenta, Date fecha) {
        this.id = id;
        this.nombre = nombre;
        this.importe = importe;
        this.motivo = motivo;
        this.banco = banco;
        this.numeroCuenta = numeroCuenta;
        this.fecha = fecha;
    }

    /**
     * Constructor de la clase MovimientoDTO.
     * 
     * @param nombre El nombre del movimiento.
     * @param importe El importe del movimiento.
     * @param motivo El motivo del movimiento.
     * @param banco El banco asociado al movimiento.
     * @param numeroCuenta El número de cuenta asociado al movimiento.
     * @param fecha La fecha del movimiento.
     */
    public MovimientoDTO(String nombre, Double importe, String motivo, tipoBancoDTO banco, String numeroCuenta, Date fecha) {
        this.nombre = nombre;
        this.importe = importe;
        this.motivo = motivo;
        this.banco = banco;
        this.numeroCuenta = numeroCuenta;
        this.fecha = fecha;
    }
     
    /**
     * Constructor de la clase MovimientoDTO.
     * 
     * @param nombre El nombre del movimiento.
     * @param importe El importe del movimiento.
     * @param motivo El motivo del movimiento.
     */
    public MovimientoDTO(String nombre, double importe, String motivo) {
        this.nombre = nombre;
        this.importe = importe;
        this.motivo = motivo;
    }

    // Métodos getter y setter
    
    /**
     * Obtiene el identificador único del movimiento.
     * 
     * @return El identificador único del movimiento.
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el identificador único del movimiento.
     * 
     * @param id El nuevo identificador único del movimiento.
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del movimiento.
     * 
     * @return El nombre del movimiento.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del movimiento.
     * 
     * @param nombre El nuevo nombre del movimiento.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el importe del movimiento.
     * 
     * @return El importe del movimiento.
     */
    public Double getImporte() {
        return importe;
    }

    /**
     * Establece el importe del movimiento.
     * 
     * @param importe El nuevo importe del movimiento.
     */
    public void setImporte(Double importe) {
        this.importe = importe;
    }

    /**
     * Obtiene el motivo del movimiento.
     * 
     * @return El motivo del movimiento.
     */
    public String getMotivo() {
        return motivo;
    }

    /**
     * Establece el motivo del movimiento.
     * 
     * @param motivo El nuevo motivo del movimiento.
     */
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    /**
     * Obtiene el banco asociado al movimiento.
     * 
     * @return El banco asociado al movimiento.
     */
    public tipoBancoDTO getBanco() {
        return banco;
    }

    /**
     * Establece el banco asociado al movimiento.
     * 
     * @param banco El nuevo banco asociado al movimiento.
     */
    public void setBanco(tipoBancoDTO banco) {
        this.banco = banco;
    }

    /**
     * Obtiene el número de cuenta asociado al movimiento.
     * 
     * @return El número de cuenta asociado al movimiento.
     */
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    /**
     * Establece el número de cuenta asociado al movimiento.
     * 
     * @param numeroCuenta El nuevo número de cuenta asociado al movimiento.
     */
    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    /**
     * Obtiene la fecha del movimiento.
     * 
     * @return La fecha del movimiento.
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha del movimiento.
     * 
     * @param fecha La nueva fecha del movimiento.
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "MovimientoDTO{" + "id=" + id + ", nombre=" + nombre + ", importe=" + importe + ", motivo=" + motivo + ", banco=" + banco + ", numeroCuenta=" + numeroCuenta + ", fecha=" + fecha + '}';
    }

    
}
