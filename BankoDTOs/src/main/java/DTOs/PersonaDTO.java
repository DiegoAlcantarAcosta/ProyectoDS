
package DTOs;

import entidades.Tarjeta;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Wilber
 */
public class PersonaDTO {
    
  private ObjectId id;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String curp;
    private String contrasena; // Diego Alcantar
    private Date fechaNac;
    private String telefono;
    private List<TarjetaDTO> listaTarjetas; // Diego Alcantar


   public PersonaDTO() {
    }


    public PersonaDTO(String curp) {
        this.curp = curp;
    }

    public PersonaDTO(ObjectId id, String nombre, String apellidoP, String apellidoM, String curp, String contrasena, Date fechaNac, String telefono, List<TarjetaDTO> listaTarjetas) {
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

    
    
    public PersonaDTO(String nombre, String apellidoP, String apellidoM, Date fechaNac, String telefono) {
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.fechaNac = fechaNac;
        this.telefono = telefono;
    }

    public PersonaDTO(String nombre, String apellidoP, String apellidoM, Date fechaNac, String telefono, String curp) {
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.fechaNac = fechaNac;
        this.telefono = telefono;
        this.curp = curp;
    }

    public PersonaDTO(String nombre, String apellidoP, String apellidoM, String curp, Date fechaNac, String telefono, ObjectId id) {
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.curp = curp;
        this.fechaNac = fechaNac;
        this.telefono = telefono;
        this.id = id;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public List<TarjetaDTO> getListaTarjetas() {
        return listaTarjetas;
    }

    public void setListaTarjetas(List<TarjetaDTO> listaTarjetas) {
        this.listaTarjetas = listaTarjetas;
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

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
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

    @Override
    public String toString() {
        return "PersonaDTO{" + "nombre=" + nombre + ", apellidoP=" + apellidoP + ", apellidoM=" + apellidoM + ", curp=" + curp + ", fechaNac=" + fechaNac + ", telefono=" + telefono + ", id=" + id + '}';
    }

    

  

    
}
