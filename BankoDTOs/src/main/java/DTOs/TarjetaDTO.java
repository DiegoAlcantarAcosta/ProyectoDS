package DTOs;

import java.util.Calendar;
import java.util.Date;
import org.bson.types.ObjectId;

/**
 *
 * @author Wilber
 */
public class TarjetaDTO {
    
    private ObjectId id;
    private String numeroCuenta;
    private tipoTarjetaDTO tipo;
    private tipoBancoDTO banco;
    private Double saldo;
    private Date fechaVencimiento;

     /**
     * Constructor de la clase TarjetaDTO.
     * 
     * @param id El identificador único de la tarjeta.
     * @param numeroCuenta El número de cuenta asociado a la tarjeta.
     * @param tipo El tipo de tarjeta.
     * @param banco El banco asociado a la tarjeta.
     * @param saldo El saldo disponible en la tarjeta.
     * @param fechaVencimiento La fecha de vencimiento de la tarjeta.
     */
    public TarjetaDTO(ObjectId id, String numeroCuenta, tipoTarjetaDTO tipo, tipoBancoDTO banco, Double saldo, Date fechaVencimiento) {
        this.id = id;
        this.numeroCuenta = numeroCuenta;
        this.tipo = tipo;
        this.banco = banco;
        this.saldo = saldo;
        this.fechaVencimiento = fechaVencimiento;
    }

     /**
     * Constructor de la clase TarjetaDTO.
     * 
     * @param numeroCuenta El número de cuenta asociado a la tarjeta.
     * @param tipo El tipo de tarjeta.
     * @param banco El banco asociado a la tarjeta.
     * @param saldo El saldo disponible en la tarjeta.
     * @param fechaVencimiento La fecha de vencimiento de la tarjeta.
     */
    public TarjetaDTO(String numeroCuenta, tipoTarjetaDTO tipo, tipoBancoDTO banco, Double saldo, Date fechaVencimiento) {
        this.numeroCuenta = numeroCuenta;
        this.tipo = tipo;
        this.banco = banco;
        this.saldo = saldo;
        this.fechaVencimiento = fechaVencimiento;
    }

     /**
     * Constructor vacío de la clase TarjetaDTO.
     */
    public TarjetaDTO() {
    }

      /**
     * Obtiene el identificador único de la tarjeta.
     * 
     * @return El identificador único de la tarjeta.
     */
    public ObjectId getId() {
        return id;
    }

     /**
     * Establece el identificador único de la tarjeta.
     * 
     * @param id El nuevo identificador único de la tarjeta.
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

     /**
      * Constructor que inicializa el numero de cuenta
      * @param numeroCuenta  numero de cuenta
      */
    public TarjetaDTO(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

  /**
     * Obtiene el número de cuenta asociado a la tarjeta.
     * 
     * @return El número de cuenta asociado a la tarjeta.
     */
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    /**
     * Establece el número de cuenta asociado a la tarjeta.
     * 
     * @param numeroCuenta El nuevo número de cuenta asociado a la tarjeta.
     */
    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

   /**
     * Obtiene el tipo de tarjeta.
     * 
     * @return El tipo de tarjeta.
     */
    public tipoTarjetaDTO getTipo() {
        return tipo;
    }

   /**
     * Establece el tipo de tarjeta.
     * 
     * @param tipo El nuevo tipo de tarjeta.
     */
    public void setTipo(tipoTarjetaDTO tipo) {
        this.tipo = tipo;
    }

      /**
     * Obtiene el banco asociado a la tarjeta.
     * 
     * @return El banco asociado a la tarjeta.
     */
    public tipoBancoDTO getBanco() {
        return banco;
    }

     /**
     * Establece el banco asociado a la tarjeta.
     * 
     * @param banco El nuevo banco asociado a la tarjeta.
     */
    public void setBanco(tipoBancoDTO banco) {
        this.banco = banco;
    }

     /**
     * Obtiene el saldo disponible en la tarjeta.
     * 
     * @return El saldo disponible en la tarjeta.
     */
    public Double getSaldo() {
        return saldo;
    }

     /**
     * Establece el saldo disponible en la tarjeta.
     * 
     * @param saldo El nuevo saldo disponible en la tarjeta.
     */
    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

     /**
     * Obtiene la fecha de vencimiento de la tarjeta.
     * 
     * @return La fecha de vencimiento de la tarjeta.
     */
    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

     /**
     * Establece la fecha de vencimiento de la tarjeta.
     * 
     * @param fechaVencimiento La nueva fecha de vencimiento de la tarjeta.
     */
    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }


     /**
     * Devuelve una representación de cadena de la tarjeta, que incluye todos sus atributos.
     * 
     * @return Una cadena que representa la tarjeta.
     */
    @Override
    public String toString() {
        return "TarjetaDTO{" + "numeroCuenta=" + numeroCuenta + ", tipo=" + tipo + ", banco=" + banco + ", saldo=" + saldo + ", fechaVencimiento=" + fechaVencimiento + '}';
    }

    
    
}
