
package DTOs;

import entidades.Persona;
import java.util.Calendar;

/**
 *
 * @author Wilber
 */
public class PersonaDTO {
    
  private String nombre;
  private String apellidoP;
  private String apellidoM;
  private String curp;
  private Calendar fechaNac;
  private String telefono;

   public PersonaDTO() {
    }


    public PersonaDTO(String curp) {
        this.curp = curp;
    }

    public PersonaDTO(String nombre, String apellidoP, String apellidoM, Calendar fechaNac, String telefono) {
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.fechaNac = fechaNac;
        this.telefono = telefono;
    }

    public PersonaDTO(String nombre, String apellidoP, String apellidoM, Calendar fechaNac, String telefono, String curp) {
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.fechaNac = fechaNac;
        this.telefono = telefono;
        this.curp = curp;
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

    public Calendar getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Calendar fechaNac) {
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
        return "PersonaDTO{" + "nombre=" + nombre + ", apellidoP=" + apellidoP + ", apellidoM=" + apellidoM + ", curp=" + curp + ", fechaNac=" + fechaNac + ", telefono=" + telefono + '}';
    }

  

    
}
