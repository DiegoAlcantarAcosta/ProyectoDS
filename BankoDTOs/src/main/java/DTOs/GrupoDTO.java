/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */
public class GrupoDTO {
        private ObjectId id; 

     private String nombre;
    private Double saldo;
    private String motivo;
//    private List<MiembroGrupoDTO> miembros;
    private List<ContactoDTO> contactos;

    // Constructor vacío
    public GrupoDTO() {
    }

//    public GrupoDTO(String nombre, Double saldo, String motivo, List<MiembroGrupoDTO> miembros) {
//        this.nombre = nombre;
//        this.saldo = saldo;
//        this.motivo = motivo;
//        this.miembros = miembros;
//    }
//    public GrupoDTO(String nombre, Double saldo, String motivo, List<ContactoDTO> contactos) {

    public GrupoDTO(String nombre, Double saldo, String motivo ) {
        this.nombre = nombre;
        this.saldo = saldo;
        this.motivo = motivo;
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

    public List<ContactoDTO> getContactos() {
        return contactos;
    }

    public void setContactos(List<ContactoDTO> contactos) {
        this.contactos = contactos;
    }

   


}
