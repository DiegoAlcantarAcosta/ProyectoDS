
package DTOs;

/**
 *
 * @author Wilber
 */
public class ContactoDTO {
    
    private String alias;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String numeroCuenta;
    private tipoBancoDTO banco;

    /**
     * Constructor por defecto de la clase ContactoDTO.
     */
   public ContactoDTO() {
    }

   /**
     * Constructor de la clase ContactoDTO.
     * 
     * @param alias El alias del contacto.
     * @param nombre El nombre del contacto.
     * @param apellidoP El apellido paterno del contacto.
     * @param apellidoM El apellido materno del contacto.
     * @param numeroCuenta El número de cuenta del contacto.
     * @param banco El banco asociado al contacto.
     */
    public ContactoDTO(String alias, String nombre, String apellidoP, String apellidoM, String numeroCuenta, tipoBancoDTO banco) {
        this.alias = alias;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.numeroCuenta = numeroCuenta;
        this.banco = banco;
    }

    /**
     * Constructor de la clase ContactoDTO que recibe solo el alias del contacto.
     * 
     * @param alias El alias del contacto.
     */
    public ContactoDTO(String alias) {
        this.alias = alias;
    }
    
    /**
     * Obtiene el alias del contacto.
     * 
     * @return El alias del contacto.
     */
    public String getAlias() {
        return alias;
    }

    /**
     * Establece el alias del contacto.
     * 
     * @param alias El nuevo alias del contacto.
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }

    /**
     * Obtiene el nombre del contacto.
     * 
     * @return El nombre del contacto.
     */
    public String getNombre() {
        return nombre;
    }

     /**
     * Establece el nombre del contacto.
     * 
     * @param nombre El nuevo nombre del contacto.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

     /**
     * Obtiene el apellido paterno del contacto.
     * 
     * @return El apellido paterno del contacto.
     */
    public String getApellidoP() {
        return apellidoP;
    }

     /**
     * Establece el apellido paterno del contacto.
     * 
     * @param apellidoP El nuevo apellido paterno del contacto.
     */
    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

     /**
     * Obtiene el apellido materno del contacto.
     * 
     * @return El apellido materno del contacto.
     */
    public String getApellidoM() {
        return apellidoM;
    }

     /**
     * Establece el apellido materno del contacto.
     * 
     * @param apellidoM El nuevo apellido materno del contacto.
     */
    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

     /**
     * Obtiene el número de cuenta del contacto.
     * 
     * @return El número de cuenta del contacto.
     */
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

        /**
     * Establece el número de cuenta del contacto.
     * 
     * @param numeroCuenta El nuevo número de cuenta del contacto.
     */

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    /**
     * Obtiene el banco asociado al contacto.
     * 
     * @return El banco asociado al contacto.
     */
    public tipoBancoDTO getBanco() {
        return banco;
    }

     /**
     * Establece el banco asociado al contacto.
     * 
     * @param banco El nuevo banco asociado al contacto.
     */
    public void setBanco(tipoBancoDTO banco) {
        this.banco = banco;
    }

     /**
     * Devuelve una representación en cadena del objeto ContactoDTO.
     * 
     * @return Una representación en cadena del objeto ContactoDTO.
     */
    @Override
    public String toString() {
        return "ContactoDTO{" + "alias=" + alias + ", nombre=" + nombre + ", apellidoP=" + apellidoP + ", apellidoM=" + apellidoM + ", numeroCuenta=" + numeroCuenta + ", banco=" + banco + '}';
    }
}
