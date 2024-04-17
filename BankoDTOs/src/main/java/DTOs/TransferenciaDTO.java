
package DTOs;

import entidades.Transferencia;
import java.util.Date;
/**
 *
 * @author Wilber
 */
public class TransferenciaDTO {
 
  private String numeroCuentaDestinatario;
  private String numeroCuentaPropietario;
  private Double  importe;
  private String motivo;
  private Date fechaMovimiento;
  private PersonaDTO persona;
  private TarjetaDTO tarjeta;

     public TransferenciaDTO() {
    }

    public TransferenciaDTO(String numeroCuentaDestinatario, String numeroCuentaPropietario, Double  importe, String motivo, Date fechaMovimiento) {
        this.numeroCuentaDestinatario = numeroCuentaDestinatario;
        this.numeroCuentaPropietario = numeroCuentaPropietario;
        this.importe = importe;
        this.motivo = motivo;
        this.fechaMovimiento = fechaMovimiento;
    }
    
     public TransferenciaDTO(Transferencia transferencia) {
         
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

    public PersonaDTO getPersona() {
        return persona;
    }

    public void setPersona(PersonaDTO persona) {
        this.persona = persona;
    }

    public TarjetaDTO getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(TarjetaDTO tarjeta) {
        this.tarjeta = tarjeta;
    }

    @Override
    public String toString() {
        return "TransferenciaDTO{" + "numeroCuentaDestinatario=" + numeroCuentaDestinatario + ", numeroCuentaPropietario=" + numeroCuentaPropietario + ", importe=" + importe + ", motivo=" + motivo + ", fechaMovimiento=" + fechaMovimiento + ", persona=" + persona + ", tarjeta=" + tarjeta + '}';
    }
  
  
  
        
}
