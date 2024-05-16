
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

   /**
     * Constructor predeterminado que inicializa la fecha de la transferencia con la fecha y hora actual.
     */
     public TransferenciaDTO() {
         fechaMovimiento = Date.from(Instant.now());
    }

      /**
     * Constructor para crear un nuevo objeto TransferenciaDTO con todos los atributos.
     * 
     * @param id El identificador único de la transferencia.
     * @param numeroCuentaDestinatario El número de cuenta del destinatario de la transferencia.
     * @param numeroCuentaPropietario El número de cuenta del propietario de la transferencia.
     * @param importe El importe de la transferencia.
     * @param motivo El motivo de la transferencia.
     * @param fechaMovimiento La fecha y hora en que se realizó la transferencia.
     */
    public TransferenciaDTO(ObjectId id, String numeroCuentaDestinatario, String numeroCuentaPropietario, Double importe, String motivo, Date fechaMovimiento) {
        this.id = id;
        this.numeroCuentaDestinatario = numeroCuentaDestinatario;
        this.numeroCuentaPropietario = numeroCuentaPropietario;
        this.importe = importe;
        this.motivo = motivo;
        this.fechaMovimiento = fechaMovimiento;
    }

      /**
     * Constructor para crear un nuevo objeto TransferenciaDTO sin el atributo de identificador.
     * 
     * @param numeroCuentaDestinatario El número de cuenta del destinatario de la transferencia.
     * @param numeroCuentaPropietario El número de cuenta del propietario de la transferencia.
     * @param importe El importe de la transferencia.
     * @param motivo El motivo de la transferencia.
     */
    public TransferenciaDTO(String numeroCuentaDestinatario, String numeroCuentaPropietario, Double  importe, String motivo) {
        this.numeroCuentaDestinatario = numeroCuentaDestinatario;
        this.numeroCuentaPropietario = numeroCuentaPropietario;
        this.importe = importe;
        this.motivo = motivo;
        fechaMovimiento = Date.from(Instant.now());
    }
    
     /**
     * Constructor para crear un nuevo objeto TransferenciaDTO a partir de otro objeto TransferenciaDTO.
     * 
     * @param transferencia El objeto TransferenciaDTO del que se copiarán los datos.
     */
     public TransferenciaDTO(TransferenciaDTO transferencia) {
         
    }

   /**
     * Método para obtener el número de cuenta del destinatario de la transferencia.
     * 
     * @return El número de cuenta del destinatario de la transferencia.
     */
    public String getNumeroCuentaDestinatario() {
        return numeroCuentaDestinatario;
    }

    /**
     * Método para establecer el número de cuenta del destinatario de la transferencia.
     * 
     * @param numeroCuentaDestinatario El número de cuenta del destinatario de la transferencia.
     */
    public void setNumeroCuentaDestinatario(String numeroCuentaDestinatario) {
        this.numeroCuentaDestinatario = numeroCuentaDestinatario;
    }

    /**
     * Método para obtener el número de cuenta del propietario de la transferencia.
     * 
     * @return El número de cuenta del propietario de la transferencia.
     */
    public String getNumeroCuentaPropietario() {
        return numeroCuentaPropietario;
    }

    /**
     * Método para establecer el número de cuenta del propietario de la transferencia.
     * 
     * @param numeroCuentaPropietario El número de cuenta del propietario de la transferencia.
     */
    public void setNumeroCuentaPropietario(String numeroCuentaPropietario) {
        this.numeroCuentaPropietario = numeroCuentaPropietario;
    }

    /**
     * Método para obtener el importe de la transferencia.
     * 
     * @return El importe de la transferencia.
     */
    public Double getImporte() {
        return importe;
    }

    /**
     * Método para establecer el importe de la transferencia.
     * 
     * @param importe El importe de la transferencia.
     */
    public void setImporte(Double importe) {
        this.importe = importe;
    }

    /**
     * Método para obtener el motivo de la transferencia.
     * 
     * @return El motivo de la transferencia.
     */
    public String getMotivo() {
        return motivo;
    }

    /**
     * Método para establecer el motivo de la transferencia.
     * 
     * @param motivo El motivo de la transferencia.
     */
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    /**
     * Método para obtener la fecha y hora en que se realizó la transferencia.
     * 
     * @return La fecha y hora en que se realizó la transferencia.
     */
    public Date getFechaMovimiento() {
        return fechaMovimiento;
    }

    /**
     * Método para establecer la fecha y hora en que se realizó la transferencia.
     * 
     * @param fechaMovimiento La fecha y hora en que se realizó la transferencia.
     */
    public void setFechaMovimiento(Date fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    @Override
    public String toString() {
        return "TransferenciaDTO{" + "numeroCuentaDestinatario=" + numeroCuentaDestinatario + ", numeroCuentaPropietario=" + numeroCuentaPropietario + ", importe=" + importe + ", motivo=" + motivo + ", fechaMovimiento=" + fechaMovimiento + '}';
    }
}