/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */

public class Grupo {
      private ObjectId id;
    private String nombre;
    private double montoTotal;
    private String motivo;
    private List<Contacto> contactos;

  public Grupo() {
    this.id = new ObjectId();
    this.contactos = new ArrayList<>();
}

public Grupo(String nombre, double montoTotal, String motivo) {
    this.id = new ObjectId();
    this.nombre = nombre;
    this.montoTotal = montoTotal;
    this.motivo = motivo;
    this.contactos = new ArrayList<>();
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

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    // Métodos para manejar la lista de contactos
    public List<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(List<Contacto> contactos) {
        this.contactos = contactos;
    }

    public void agregarContacto(Contacto contacto) {
        this.contactos.add(contacto);
    }

    public void removerContacto(Contacto contacto) {
        this.contactos.remove(contacto);
    }
    

}
