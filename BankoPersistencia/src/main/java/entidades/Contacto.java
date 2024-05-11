/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author Dell
 */
public class Contacto {
    
    private Long id;
    private String alias;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String numeroCuenta;
    private tipoBanco banco;

    public Contacto() {
    }

    public Contacto(String alias, String nombre, String apellidoP, String apellidoM, String numeroCuenta, tipoBanco banco) {
        this.alias = alias;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.numeroCuenta = numeroCuenta;
        this.banco = banco;
    }

//    public Contacto(String numeroCuenta, Persona persona) {
//        this.numeroCuenta = numeroCuenta;
//        this.persona = persona;
//    }

    public Contacto(String alias) {
        this.alias = alias;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public tipoBanco getBanco() {
        return banco;
    }

    public void setBanco(tipoBanco banco) {
        this.banco = banco;
    }

    @Override
    public String toString() {
        return "Contacto{" + "id=" + id + ", alias=" + alias + ", nombre=" + nombre + ", apellidoP=" + apellidoP + ", apellidoM=" + apellidoM + ", numeroCuenta=" + numeroCuenta + ", banco=" + banco + '}';
    }
    
}
