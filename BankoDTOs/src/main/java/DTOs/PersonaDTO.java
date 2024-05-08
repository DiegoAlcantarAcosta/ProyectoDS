
package DTOs;

import java.util.Calendar;
import java.util.Date;
import org.bson.types.ObjectId;

/**
 *
 * @author Wilber
 */
public class PersonaDTO {
    
  private String nombre;
  private String apellidoP;
  private String apellidoM;
  private String curp;
  private Date fechaNac;
  private String telefono;
  private ObjectId id;

   public PersonaDTO() {
    }


    public PersonaDTO(String curp) {
        this.curp = curp;
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
