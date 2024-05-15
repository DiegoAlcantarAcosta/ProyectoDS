/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import org.bson.types.ObjectId;

/**
 * Esta clase representa un objeto de Transferencia de Datos (DTO) para una
 * transacción. Un DTO es un objeto que lleva datos entre procesos, generalmente
 * entre la capa de acceso a datos y la capa de presentación. Este DTO
 * particular contiene información sobre una transacción, excluyendo los
 * atributos.
 *
 * @author Oley
 */
public class TransaccionDTO {

    private String id;
    private ObjectId grupoId;
    private double monto;
    private String descripcion;

    /**
     * Constructor para crear un nuevo objeto TransaccionDTO con todos los
     * atributos.
     *
     * @param id El identificador de la transacción.
     * @param grupoId El identificador del grupo al que pertenece la
     * transacción.
     * @param monto El monto de la transacción.
     * @param descripcion La descripción de la transacción.
     */
    public TransaccionDTO(String id, ObjectId grupoId, double monto, String descripcion) {
        this.id = id;
        this.grupoId = grupoId;
        this.monto = monto;
        this.descripcion = descripcion;
    }

    /**
     * Constructor vacío para crear un nuevo objeto TransaccionDTO sin
     * inicializar atributos.
     */
    public TransaccionDTO() {
    }

    /**
     * Constructor para crear un nuevo objeto TransaccionDTO sin el atributo de
     * identificador.
     *
     * @param grupoId El identificador del grupo al que pertenece la
     * transacción.
     * @param monto El monto de la transacción.
     * @param descripcion La descripción de la transacción.
     */
    public TransaccionDTO(ObjectId grupoId, double monto, String descripcion) {
        this.grupoId = grupoId;
        this.monto = monto;
        this.descripcion = descripcion;
    }

    /**
     * Método para obtener el identificador de la transacción.
     *
     * @return El identificador de la transacción.
     */
    public String getId() {
        return id;
    }

    /**
     * Método para establecer el identificador de la transacción.
     *
     * @param id El identificador de la transacción.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Método para obtener el monto de la transacción.
     *
     * @return El monto de la transacción.
     */
    public double getMonto() {
        return monto;
    }

    /**
     * Método para establecer el monto de la transacción.
     *
     * @param monto El monto de la transacción.
     */
    public void setMonto(double monto) {
        this.monto = monto;
    }

    /**
     * Método para obtener la descripción de la transacción.
     *
     * @return La descripción de la transacción.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Método para establecer la descripción de la transacción.
     *
     * @param descripcion La descripción de la transacción.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Método para obtener el identificador del grupo al que pertenece la
     * transacción.
     *
     * @return El identificador del grupo al que pertenece la transacción.
     */
    public ObjectId getGrupoId() {
        return grupoId;
    }

    /**
     * Método para establecer el identificador del grupo al que pertenece la
     * transacción.
     *
     * @param grupoId El identificador del grupo al que pertenece la
     * transacción.
     */
    public void setGrupoId(ObjectId grupoId) {
        this.grupoId = grupoId;
    }
}
