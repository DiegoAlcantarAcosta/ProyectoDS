/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import java.util.List;

/**
 *
 * @author Oley
 */
public class GrupoDTO {
     private String nombre;
    private Double saldo;
    private String motivo;
    private List<MiembroGrupoDTO> miembros;

    // Constructor vacío
    public GrupoDTO() {
    }

    public GrupoDTO(String nombre, Double saldo, String motivo, List<MiembroGrupoDTO> miembros) {
        this.nombre = nombre;
        this.saldo = saldo;
        this.motivo = motivo;
        this.miembros = miembros;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public List<MiembroGrupoDTO> getMiembros() {
        return miembros;
    }

    public void setMiembros(List<MiembroGrupoDTO> miembros) {
        this.miembros = miembros;
    }
}
