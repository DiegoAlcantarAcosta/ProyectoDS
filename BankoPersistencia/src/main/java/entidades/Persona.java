package entidades;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Wilber
 */

public class Persona {

    private ObjectId id;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String curp;
    private String contrasena;
    private Date fechaNac;
    private String telefono;
    private List<Tarjeta> listaTarjetas;
    private List<Contacto> listaContactos;

    public Persona() {
    }

    public Persona(ObjectId id) {
        this.id = id;
    }

    public Persona(String curp) {
        this.curp = curp;
    }

    public Persona(String nombre, String apellidoP, String apellidoM, Date fechaNac, String telefono) {
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.fechaNac = fechaNac;
        this.telefono = telefono;
    }

    public Persona(String nombre, String apellidoP, String apellidoM, Date fechaNac, String telefono, String curp, String contrasena) {
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.fechaNac = fechaNac;
        this.telefono = telefono;
        this.curp = curp;
        this.contrasena = contrasena;
    }   
    
    public Persona(String nombre, String apellidoP, String apellidoM, String curp, String contrasena, Date fechaNac, String telefono, List<Tarjeta> listaTarjetas) {
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.curp = curp;
        this.contrasena = contrasena;
        this.fechaNac = fechaNac;
        this.telefono = telefono;
        this.listaTarjetas = listaTarjetas;
    }

    public Persona(ObjectId id, String nombre, String apellidoP, String apellidoM, String curp, String contrasena, Date fechaNac, String telefono, List<Tarjeta> listaTarjetas) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.curp = curp;
        this.contrasena = contrasena;
        this.fechaNac = fechaNac;
        this.telefono = telefono;
        this.listaTarjetas = listaTarjetas;
    }
    
    

    public List<Tarjeta> getListaTarjetas() {
        return listaTarjetas;
    }

    public void setListaTarjetas(List<Tarjeta> listaTarjetas) {
        this.listaTarjetas = listaTarjetas;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
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

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Contacto> getListaContactos() {
        return listaContactos;
    }

    public void setListaContactos(List<Contacto> listaContactos) {
        this.listaContactos = listaContactos;
    }

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", nombre=" + nombre + ", apellidoP=" + apellidoP + ", apellidoM=" + apellidoM + ", curp=" + curp + ", contrasena=" + contrasena + ", fechaNac=" + fechaNac + ", telefono=" + telefono + ", listaTarjetas=" + listaTarjetas + ", listaContactos=" + listaContactos + '}';
    }
}
