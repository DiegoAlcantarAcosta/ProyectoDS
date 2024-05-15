/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import org.bson.types.ObjectId;

/**
 * Clase que representa un miembro de un grupo en el sistema.
 * 
 * <p>Esta clase almacena la información de un miembro de un grupo, incluyendo su nombre,
 * apellido paterno y apellido materno.</p>
 * 
 * @author Oley
 */
public class MiembroGrupoDTO {
    
    /**
     * El identificador único del miembro del grupo.
     */
    private ObjectId id;

    /**
     * El nombre del miembro del grupo.
     */
    private String nombre;
    
    /**
     * El apellido paterno del miembro del grupo.
     */
    private String apellidoPaterno;
    
    /**
     * El apellido materno del miembro del grupo.
     */
    private String apellidoMaterno;

    /**
     * Constructor vacío de la clase MiembroGrupoDTO.
     */
    public MiembroGrupoDTO() {
    }

    /**
     * Constructor de la clase MiembroGrupoDTO.
     * 
     * @param nombre El nombre del miembro del grupo.
     * @param apellidoPaterno El apellido paterno del miembro del grupo.
     * @param apellidoMaterno El apellido materno del miembro del grupo.
     */
    public MiembroGrupoDTO(String nombre, String apellidoPaterno, String apellidoMaterno) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
    }

    // Métodos getter y setter
    
    /**
     * Obtiene el identificador único del miembro del grupo.
     * 
     * @return El identificador único del miembro del grupo.
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el identificador único del miembro del grupo.
     * 
     * @param id El nuevo identificador único del miembro del grupo.
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del miembro del grupo.
     * 
     * @return El nombre del miembro del grupo.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del miembro del grupo.
     * 
     * @param nombre El nuevo nombre del miembro del grupo.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido paterno del miembro del grupo.
     * 
     * @return El apellido paterno del miembro del grupo.
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Establece el apellido paterno del miembro del grupo.
     * 
     * @param apellidoPaterno El nuevo apellido paterno del miembro del grupo.
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Obtiene el apellido materno del miembro del grupo.
     * 
     * @return El apellido materno del miembro del grupo.
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Establece el apellido materno del miembro del grupo.
     * 
     * @param apellidoMaterno El nuevo apellido materno del miembro del grupo.
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }
}
