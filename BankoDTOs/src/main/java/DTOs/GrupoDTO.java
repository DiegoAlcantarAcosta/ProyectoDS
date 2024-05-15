/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import java.util.List;

/**
 * Clase que representa un grupo en el sistema.
 * 
 * <p>Esta clase almacena la información de un grupo, incluyendo su nombre,
 * saldo, motivo y lista de miembros.</p>
 * 
 * @author Oley
 */
public class GrupoDTO {
    
    /**
     * El nombre del grupo.
     */
    private String nombre;
    
    /**
     * El saldo del grupo.
     */
    private Double saldo;
    
    /**
     * El motivo del grupo.
     */
    private String motivo;
    
    /**
     * La lista de miembros del grupo.
     */
    private List<MiembroGrupoDTO> miembros;

    /**
     * Constructor vacío de la clase GrupoDTO.
     */
    public GrupoDTO() {
    }

    /**
     * Constructor de la clase GrupoDTO.
     * 
     * @param nombre El nombre del grupo.
     * @param saldo El saldo del grupo.
     * @param motivo El motivo del grupo.
     * @param miembros La lista de miembros del grupo.
     */
    public GrupoDTO(String nombre, Double saldo, String motivo, List<MiembroGrupoDTO> miembros) {
        this.nombre = nombre;
        this.saldo = saldo;
        this.motivo = motivo;
        this.miembros = miembros;
    }

    // Métodos getter y setter
    
    /**
     * Obtiene el nombre del grupo.
     * 
     * @return El nombre del grupo.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del grupo.
     * 
     * @param nombre El nuevo nombre del grupo.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el saldo del grupo.
     * 
     * @return El saldo del grupo.
     */
    public Double getSaldo() {
        return saldo;
    }

    /**
     * Establece el saldo del grupo.
     * 
     * @param saldo El nuevo saldo del grupo.
     */
    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    /**
     * Obtiene el motivo del grupo.
     * 
     * @return El motivo del grupo.
     */
    public String getMotivo() {
        return motivo;
    }

    /**
     * Establece el motivo del grupo.
     * 
     * @param motivo El nuevo motivo del grupo.
     */
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    /**
     * Obtiene la lista de miembros del grupo.
     * 
     * @return La lista de miembros del grupo.
     */
    public List<MiembroGrupoDTO> getMiembros() {
        return miembros;
    }

    /**
     * Establece la lista de miembros del grupo.
     * 
     * @param miembros La nueva lista de miembros del grupo.
     */
    public void setMiembros(List<MiembroGrupoDTO> miembros) {
        this.miembros = miembros;
    }
}
