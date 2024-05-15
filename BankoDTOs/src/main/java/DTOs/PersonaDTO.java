package DTOs;

import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Clase que representa a una persona en el sistema.
 *
 * <p>
 * Esta clase almacena la información de una persona, incluyendo su nombre,
 * apellidos, CURP, contraseña, fecha de nacimiento, teléfono, lista de tarjetas
 * y lista de contactos.</p>
 *
 * <p>
 * Los objetos de esta clase se utilizan para transferir datos relacionados con
 * las personas entre diferentes componentes del sistema.</p>
 *
 * @author Wilber
 */
public class PersonaDTO {

    /**
     * El identificador único de la persona.
     */
    private ObjectId id;

    /**
     * El nombre de la persona.
     */
    private String nombre;

    /**
     * El apellido paterno de la persona.
     */
    private String apellidoP;

    /**
     * El apellido materno de la persona.
     */
    private String apellidoM;

    /**
     * El CURP de la persona.
     */
    private String curp;

    /**
     * La contraseña de la persona.
     */
    private String contrasena;

    /**
     * La fecha de nacimiento de la persona.
     */
    private Date fechaNac;

    /**
     * El teléfono de la persona.
     */
    private String telefono;

    /**
     * La lista de tarjetas asociadas a la persona.
     */
    private List<TarjetaDTO> listaTarjetas;

    /**
     * La lista de contactos de la persona.
     */
    private List<ContactoDTO> listaContactos;

    /**
     * Constructor vacío de la clase PersonaDTO.
     */
    public PersonaDTO() {
    }

    /**
     * Constructor de la clase PersonaDTO.
     *
     * @param curp El CURP de la persona.
     */
    public PersonaDTO(String curp) {
        this.curp = curp;
    }

    /**
     * Constructor de la clase PersonaDTO.
     *
     * @param id El identificador único de la persona.
     * @param nombre El nombre de la persona.
     * @param apellidoP El apellido paterno de la persona.
     * @param apellidoM El apellido materno de la persona.
     * @param curp El CURP de la persona.
     * @param contrasena La contraseña de la persona.
     * @param fechaNac La fecha de nacimiento de la persona.
     * @param telefono El teléfono de la persona.
     * @param listaTarjetas La lista de tarjetas asociadas a la persona.
     */
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

    /**
     * Constructor de la clase PersonaDTO.
     *
     * @param nombre El nombre de la persona.
     * @param apellidoP El apellido paterno de la persona.
     * @param apellidoM El apellido materno de la persona.
     * @param curp El CURP de la persona.
     * @param contrasena La contraseña de la persona.
     * @param fechaNac La fecha de nacimiento de la persona.
     * @param telefono El teléfono de la persona.
     * @param listaTarjetas La lista de tarjetas asociadas a la persona.
     * @param listaContactos La lista de contactos de la persona.
     */
    public PersonaDTO(String nombre, String apellidoP, String apellidoM, String curp, String contrasena, Date fechaNac, String telefono, List<TarjetaDTO> listaTarjetas, List<ContactoDTO> listaContactos) {
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.curp = curp;
        this.contrasena = contrasena;
        this.fechaNac = fechaNac;
        this.telefono = telefono;
        this.listaTarjetas = listaTarjetas;
        this.listaContactos = listaContactos;
    }

    /**
     * Constructor de la clase PersonaDTO.
     *
     * @param nombre El nombre de la persona.
     * @param apellidoP El apellido paterno de la persona.
     * @param apellidoM El apellido materno de la persona.
     * @param fechaNac La fecha de nacimiento de la persona.
     * @param telefono El teléfono de la persona.
     */
    public PersonaDTO(String nombre, String apellidoP, String apellidoM, Date fechaNac, String telefono) {
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.fechaNac = fechaNac;
        this.telefono = telefono;
    }

    /**
     * Constructor de la clase PersonaDTO.
     *
     * @param nombre El nombre de la persona.
     * @param apellidoP El apellido paterno de la persona.
     * @param apellidoM El apellido materno de la persona.
     * @param fechaNac La fecha de nacimiento de la persona.
     * @param telefono El teléfono de la persona.
     * @param curp El CURP de la persona.
     */
    public PersonaDTO(String nombre, String apellidoP, String apellidoM, Date fechaNac, String telefono, String curp) {
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.fechaNac = fechaNac;
        this.telefono = telefono;
        this.curp = curp;
    }

    /**
     * Constructor de la clase PersonaDTO.
     *
     * @param nombre El nombre de la persona.
     * @param apellidoP El apellido paterno de la persona.
     * @param apellidoM El apellido materno de la persona.
     * @param curp El CURP de la persona.
     * @param fechaNac La fecha de nacimiento de la persona.
     * @param telefono El teléfono de la persona.
     * @param id El identificador único de la persona.
     */
    public PersonaDTO(String nombre, String apellidoP, String apellidoM, String curp, Date fechaNac, String telefono, ObjectId id) {
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.curp = curp;
        this.fechaNac = fechaNac;
        this.telefono = telefono;
        this.id = id;
    }

    /**
     * Obtiene la contraseña de la persona.
     *
     * @return La contraseña de la persona.
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Establece la contraseña de la persona.
     *
     * @param contrasena La nueva contraseña de la persona.
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Obtiene la lista de tarjetas asociadas a la persona.
     *
     * @return La lista de tarjetas asociadas a la persona.
     */
    public List<TarjetaDTO> getListaTarjetas() {
        return listaTarjetas;
    }

    /**
     * Establece la lista de tarjetas asociadas a la persona.
     *
     * @param listaTarjetas La nueva lista de tarjetas asociadas a la persona.
     */
    public void setListaTarjetas(List<TarjetaDTO> listaTarjetas) {
        this.listaTarjetas = listaTarjetas;
    }

    /**
     * Obtiene el identificador único de la persona.
     *
     * @return El identificador único de la persona.
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el identificador único de la persona.
     *
     * @param id El nuevo identificador único de la persona.
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre de la persona.
     *
     * @return El nombre de la persona.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la persona.
     *
     * @param nombre El nuevo nombre de la persona.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido paterno de la persona.
     *
     * @return El apellido paterno de la persona.
     */
    public String getApellidoP() {
        return apellidoP;
    }

    /**
     * Establece el apellido paterno de la persona.
     *
     * @param apellidoP El nuevo apellido paterno de la persona.
     */
    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    /**
     * Obtiene el apellido materno de la persona.
     *
     * @return El apellido materno de la persona.
     */
    public String getApellidoM() {
        return apellidoM;
    }

    /**
     * Establece el apellido materno de la persona.
     *
     * @param apellidoM El nuevo apellido materno de la persona.
     */
    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    /**
     * Obtiene el CURP de la persona.
     *
     * @return El CURP de la persona.
     */
    public String getCurp() {
        return curp;
    }

    /**
     * Establece el CURP de la persona.
     *
     * @param curp El nuevo CURP de la persona.
     */
    public void setCurp(String curp) {
        this.curp = curp;
    }

    /**
     * Obtiene la fecha de nacimiento de la persona.
     *
     * @return La fecha de nacimiento de la persona.
     */
    public Date getFechaNac() {
        return fechaNac;
    }

    /**
     * Establece la fecha de nacimiento de la persona.
     *
     * @param fechaNac La nueva fecha de nacimiento de la persona.
     */
    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    /**
     * Obtiene el teléfono de la persona.
     *
     * @return El teléfono de la persona.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el teléfono de la persona.
     *
     * @param telefono El nuevo teléfono de la persona.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene la lista de contactos de la persona.
     *
     * @return La lista de contactos de la persona.
     */
    public List<ContactoDTO> getListaContactos() {
        return listaContactos;
    }

    /**
     * Establece la lista de contactos de la persona.
     *
     * @param listaContactos La nueva lista de contactos de la persona.
     */
    public void setListaContactos(List<ContactoDTO> listaContactos) {
        this.listaContactos = listaContactos;
    }

    /**
     * Devuelve una representación de cadena de la persona, que incluye todos
     * sus atributos.
     *
     * @return Una cadena que representa la persona.
     */
    @Override
    public String toString() {
        return "PersonaDTO{" + "id=" + id + ", nombre=" + nombre + ", apellidoP=" + apellidoP + ", apellidoM=" + apellidoM + ", curp=" + curp + ", contrasena=" + contrasena + ", fechaNac=" + fechaNac + ", telefono=" + telefono + ", listaTarjetas=" + listaTarjetas + ", listaContactos=" + listaContactos + '}';
    }
}
