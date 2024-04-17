/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOS;

import Conexion.Conexion;
import Conexion.IConexion;
import entidades.Contacto;
import entidades.Persona;
import entidades.Tarjeta;
import interfaces.daos.IContactoDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Dell
 */
public class ContactoDAO implements IContactoDAO {

    private final IConexion conexion;
    private PersonaDAO pd = new PersonaDAO();
    private TarjetaDAO td = new TarjetaDAO();

    public ContactoDAO() {
        conexion = new Conexion();
    }

    @Override
    public Boolean agregar(Contacto contacto) {
        EntityManager em = conexion.abrir();
        Persona persona = pd.obtenerPersonaPorCurp(contacto.getPersona());
        Tarjeta tarjeta = td.obtenerTarjetaPorNumero(new Tarjeta(contacto.getNumeroCuenta()));

        try {
            if (persona != null && tarjeta != null) {
                em.getTransaction().begin();

                em.persist(contacto);

                em.getTransaction().commit();

                return true;

            }
            return false;

        } catch (Exception e) {

        } finally {
            em.close();
        }

        return false;
    }
    
    @Override
    public Boolean eliminar(Contacto contacto) {
        EntityManager em = conexion.abrir();
        Persona persona = pd.obtenerPersonaPorCurp(contacto.getPersona());
        Tarjeta tarjeta = td.obtenerTarjetaPorNumero(new Tarjeta(contacto.getNumeroCuenta()));

        try {
            if (persona != null && tarjeta != null) {
                em.getTransaction().begin();

                em.persist(contacto);

                em.getTransaction().commit();

                return true;

            }
            return false;

        } catch (Exception e) {

        } finally {
            em.close();
        }

        return false;
    }
    
    @Override
    public List<Contacto> obtenerContactosPersona(Persona persona) {
        EntityManager em = conexion.abrir();
        PersonaDAO personaDAO = new PersonaDAO();
        Persona personaBuscada = personaDAO.obtenerPersonaPorCurp(persona);
        
        try {
            em.getTransaction().begin();
            // Crear la consulta JPA
            String query = "SELECT c FROM Contacto c WHERE c.persona = :persona";
            TypedQuery<Contacto> q = em.createQuery(query, Contacto.class);
            q.setParameter("persona", personaBuscada);
            em.getTransaction().commit();

            // Ejecutar la consulta y obtener los resultados
            List<Contacto> contactos = q.getResultList();
            return contactos;
        } finally {
            em.close();
        }
    }
    
    @Override
    public Contacto obtenerContactoPersona(Contacto contacto, Persona persona) {
        EntityManager em = conexion.abrir();
        PersonaDAO personaDAO = new PersonaDAO();
        Persona personaBuscada = personaDAO.obtenerPersonaPorCurp(persona);
        
        try {
            em.getTransaction().begin();
            // Crear la consulta JPA
            String query = "SELECT c FROM Contacto c WHERE c.alias = :alias and c.persona = :persona";
            TypedQuery<Contacto> q = em.createQuery(query, Contacto.class);
            q.setParameter("alias", contacto.getAlias());
            q.setParameter("persona", personaBuscada);
            em.getTransaction().commit();

            // Ejecutar la consulta y obtener los resultados
            Contacto contactoBuscado = q.getSingleResult();
            return contactoBuscado;
        } finally {
            em.close();
        }
    }

}
