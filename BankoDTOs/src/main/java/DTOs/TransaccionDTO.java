/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */
public class TransaccionDTO {

    private String id;
    private ObjectId grupoId;
    private double monto;
    private String descripcion;

    public TransaccionDTO(String id, ObjectId grupoId, double monto, String descripcion) {
        this.id = id;
        this.grupoId = grupoId;
        this.monto = monto;
        this.descripcion = descripcion;
    }

    public TransaccionDTO() {
    }

    public TransaccionDTO(ObjectId grupoId, double monto, String descripcion) {
        this.grupoId = grupoId;
        this.monto = monto;
        this.descripcion = descripcion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ObjectId getGrupoId() {
        return grupoId;
    }

    public void setGrupoId(ObjectId grupoId) {
        this.grupoId = grupoId;
    }

}
