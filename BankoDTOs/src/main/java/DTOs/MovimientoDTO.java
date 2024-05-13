
package DTOs;

import entidades.tipoBanco;
import java.util.Date;
import org.bson.types.ObjectId;

/**
 * eaaaa
 * @author Wilber
 */
public class MovimientoDTO {
    
    private ObjectId id;
    private String nombre;
    private Double importe;
    private String motivo;
    private tipoBancoDTO banco;
    private String numeroCuenta;  
    private Date fecha;
    
    
     public MovimientoDTO() {
        // Constructor vacío
    }

    public MovimientoDTO(ObjectId id, String nombre, Double importe, String motivo, tipoBancoDTO banco, String numeroCuenta, Date fecha) {
        this.id = id;
        this.nombre = nombre;
        this.importe = importe;
        this.motivo = motivo;
        this.banco = banco;
        this.numeroCuenta = numeroCuenta;
        this.fecha = fecha;
    }

     
    public MovimientoDTO(String nombre, Double importe, String motivo, tipoBancoDTO banco, String numeroCuenta, Date fecha) {
        this.nombre = nombre;
        this.importe = importe;
        this.motivo = motivo;
        this.banco = banco;
        this.numeroCuenta = numeroCuenta;
        this.fecha = fecha;
    }
     
    public MovimientoDTO(String nombre, double importe, String motivo) {
        this.nombre = nombre;
        this.importe = importe;
        this.motivo = motivo;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public tipoBancoDTO getBanco() {
        return banco;
    }

    public void setBanco(tipoBancoDTO banco) {
        this.banco = banco;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "MovimientoDTO{" + "id=" + id + ", nombre=" + nombre + ", importe=" + importe + ", motivo=" + motivo + ", banco=" + banco + ", numeroCuenta=" + numeroCuenta + ", fecha=" + fecha + '}';
    }

    
}
