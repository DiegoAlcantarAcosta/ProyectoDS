/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOS;

import Conexion.Conexion;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import encriptacion.Encriptador;
import encriptacion.IEncriptador;
import entidades.Contacto;
import entidades.Persona;
import interfaces.daos.IContactoDAO;
import java.util.List;
import javax.persistence.PersistenceException;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author Dell
 */
public class ContactoDAO implements IContactoDAO {

    MongoCollection<Contacto> coleccionPersonas;
    private Encriptador enc = new Encriptador();

    public ContactoDAO() {
        this.coleccionPersonas = Conexion.getDatabase().getCollection("Personas", Contacto.class);
    }

    @Override
    public Boolean agregar(Persona persona, Contacto contacto) throws PersistenceException {
        try {
            contacto.setNumeroCuenta(enc.getAES(contacto.getNumeroCuenta()));
            if (persona.getId() != null) {
                coleccionPersonas.updateOne(Filters.eq("_id", persona.getId()), Updates.push("listaContactos", contacto));
                return true;
            }
            throw new MongoException("La persona no existe");

        } catch (MongoException e) {
            System.out.println(e);
            return false;
        }

    }

    @Override
    public Boolean eliminar(Persona persona, Contacto contacto) throws PersistenceException {
        try {
            contacto.setNumeroCuenta(enc.getAES(contacto.getNumeroCuenta()));
            if (persona.getId() != null && contacto.getAlias() != null) {
                Bson filtro = Filters.and(Filters.eq("_id", persona.getId()), Filters.eq("listaContactos.alias", contacto.getAlias()));
                Bson update = Updates.pull("listaContactos", Filters.eq("alias", contacto.getAlias()));
                UpdateResult result = coleccionPersonas.updateOne(filtro, update);

                return result.getModifiedCount() > 0;
            }
            throw new MongoException("No se logro eliminar el contacto");
        } catch (MongoException e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public Boolean actualizar(Persona persona, Contacto contactoOri, Contacto contactoActua) throws PersistenceException {
        try {
            contactoActua.setNumeroCuenta(enc.getAES(contactoActua.getNumeroCuenta()));
            if (persona.getId() != null && contactoOri.getAlias() != null && contactoOri.getNumeroCuenta() != null) {

                coleccionPersonas.updateOne(
                        Filters.and(
                                Filters.eq("_id", persona.getId()),
                                Filters.eq("listaContactos.alias", contactoOri.getAlias())
                        ),
                        Updates.set("listaContactos.$", contactoActua)
                );
                return true;
            }
            throw new MongoException("No se logro actualizar el contacto");

        } catch (MongoException e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public List<Contacto> obtenerContactosPersona(Persona persona) throws PersistenceException {
        try {
            if (persona.getListaContactos() != null) {

                List<Contacto> listaContactos = persona.getListaContactos();

                return listaContactos;
            }
            throw new MongoException("No se logro obtener la lista de contactos");
        } catch (MongoException e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public Contacto obtenerContactoPersona(Persona persona, Contacto contacto) throws PersistenceException {
        try {
            
            if (persona.getId() != null && contacto.getAlias() != null) {
                List<Contacto> listaContactos = persona.getListaContactos();
                for (Contacto conta : listaContactos) {
                    if (this.validaContactoPersona(contacto, conta)) {
                        return conta;
                    }
                }
            }
            throw new MongoException("No se logro obtener el contacto");
        } catch (MongoException e) {
            System.out.println(e);
            return null;
        }
    }

    public Boolean validaContactoPersona(Contacto contacto, Contacto contacto2) {
        if (contacto.getAlias().equals(contacto2.getAlias())) {
            return true;

        }

        return false;
    }

}
