
package DTOs;

import java.time.Instant;
import java.util.Date;
import org.bson.types.ObjectId;
/**
 *
 * @author Wilber
 */
public class TransferenciaDTO {
 
 private ObjectId id;
  private String numeroCuentaDestinatario;
  private String numeroCuentaPropietario;
  private Double  importe;
  private String motivo;
  private Date fechaMovimiento;

     public TransferenciaDTO() {
         fechaMovimiento = Date.from(Instant.now());
    }

    public TransferenciaDTO(ObjectId id, String numeroCuentaDestinatario, String numeroCuentaPropietario, Double importe, String motivo, Date fechaMovimiento) {
        this.id = id;
        this.numeroCuentaDestinatario = numeroCuentaDestinatario;
        this.numeroCuentaPropietario = numeroCuentaPropietario;
        this.importe = importe;
        this.motivo = motivo;
        this.fechaMovimiento = fechaMovimiento;
    }

     
     
    public TransferenciaDTO(String numeroCuentaDestinatario, String numeroCuentaPropietario, Double  importe, String motivo) {
        this.numeroCuentaDestinatario = numeroCuentaDestinatario;
        this.numeroCuentaPropietario = numeroCuentaPropietario;
        this.importe = importe;
        this.motivo = motivo;
        fechaMovimiento = Date.from(Instant.now());
    }
    
     public TransferenciaDTO(TransferenciaDTO transferencia) {
         
    }

    public String getNumeroCuentaDestinatario() {
        return numeroCuentaDestinatario;
    }

    public void setNumeroCuentaDestinatario(String numeroCuentaDestinatario) {
        this.numeroCuentaDestinatario = numeroCuentaDestinatario;
    }

    public String getNumeroCuentaPropietario() {
        return numeroCuentaPropietario;
    }

    public void setNumeroCuentaPropietario(String numeroCuentaPropietario) {
        this.numeroCuentaPropietario = numeroCuentaPropietario;
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

    public Date getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(Date fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    @Override
    public String toString() {
        return "TransferenciaDTO{" + "numeroCuentaDestinatario=" + numeroCuentaDestinatario + ", numeroCuentaPropietario=" + numeroCuentaPropietario + ", importe=" + importe + ", motivo=" + motivo + ", fechaMovimiento=" + fechaMovimiento + '}';
    }
  
        
}
