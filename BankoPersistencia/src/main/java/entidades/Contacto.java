/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Dell
 */
@Entity
@Table (name = "contactos")
public class Contacto implements Serializable {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name ="alias", nullable = false)
    private String alias;
    
    @Column (name ="nombre", nullable = false)
    private String nombre;
    
    @Column (name ="apellido_paterno", nullable = false)
    private String apellidoP;
    
    @Column (name ="apellido_materno", nullable = false)
    private String apellidoM;
    
    @Column (name ="numero_cuenta", nullable = false)
    private String numeroCuenta;
    
    @Column (name ="Banco", nullable = false)
    @Enumerated (EnumType.STRING)
    private tipoBanco banco;
    
    @ManyToOne
    @JoinColumn(name = "id_persona", nullable = false)
    private Persona persona;

    public Contacto() {
    }

    public Contacto(String alias, String nombre, String apellidoP, String apellidoM, String numeroCuenta, tipoBanco banco, Persona persona) {
        this.alias = alias;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.numeroCuenta = numeroCuenta;
        this.banco = banco;
        this.persona = persona;
    }

//    public Contacto(String numeroCuenta, Persona persona) {
//        this.numeroCuenta = numeroCuenta;
//        this.persona = persona;
//    }
    
    public Contacto(String alias, Persona persona) {
        this.alias = alias;
        this.persona = persona;
    }

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

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public String toString() {
        return "Contacto{" + "id=" + id + ", alias=" + alias + ", nombre=" + nombre + ", apellidoP=" + apellidoP + ", apellidoM=" + apellidoM + ", numeroCuenta=" + numeroCuenta + ", banco=" + banco + ", persona=" + persona + '}';
    }

    
    
    
    
}
