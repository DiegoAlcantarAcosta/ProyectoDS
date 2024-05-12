
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
    private String banco;
    private PersonaDTO persona;

   public ContactoDTO() {
    }

    public ContactoDTO(String alias, String nombre, String apellidoP, String apellidoM, String numeroCuenta, String banco, PersonaDTO persona) {
        this.alias = alias;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.numeroCuenta = numeroCuenta;
        this.banco = banco;
        this.persona = persona;
    }

//    public ContactoDTO(String numeroCuenta, Persona persona) {
//        this.numeroCuenta = numeroCuenta;
//        this.persona = persona;
//    }
    
    public ContactoDTO(String alias, PersonaDTO persona) {
        this.alias = alias;
        this.persona = persona;
    }

    public ContactoDTO(String alias) {
        this.alias = alias;
    }
    
   

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public PersonaDTO getPersona() {
        return persona;
    }

    public void setPersona(PersonaDTO persona) {
        this.persona = persona;
    }

    @Override
    public String toString() {
        return "ContactoDTO{" + "alias=" + alias + ", nombre=" + nombre + ", apellidoP=" + apellidoP + ", apellidoM=" + apellidoM + ", numeroCuenta=" + numeroCuenta + ", banco=" + banco + ", persona=" + persona + '}';
    }
    
    
    
}
