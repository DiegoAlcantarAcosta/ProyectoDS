/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOS;

import Conexion.Conexion;
import Conexion.IConexion;
import entidades.Contacto;
import entidades.Persona;
import interfaces.daos.IPersonaDAO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Diego
 */
public class PersonaDAO implements IPersonaDAO {

    private final IConexion conexion;

    public PersonaDAO() {
        conexion = new Conexion();
    }

  

    @Override
    public Boolean registrar(Persona persona) {
        EntityManager em = conexion.abrir();
        em.getTransaction().begin();

        try {
            Persona personaRegistrar = new Persona(persona.getNombre(), persona.getApellidoP(), persona.getApellidoM(), persona.getFechaNac(), persona.getTelefono(), persona.getCurp());
            em.persist(personaRegistrar);
            em.getTransaction().commit();
            return true;

        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        } finally {
            
            em.close();
        }
        
    }

    @Override
    public boolean personaRegistrada(Persona persona) {

        try {
            Persona personaBuscada = this.obtenerPersonaPorCurp(persona);

            if (personaBuscada == null) {
                return false;

            }

            return true;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Persona obtenerPersonaPorCurp(Persona persona) {
        EntityManager em = conexion.abrir();
        em.getTransaction().begin();

        try {
            String sentencia = "SELECT p FROM Persona p WHERE p.curp = :curp";
            TypedQuery<Persona> query = em.createQuery(sentencia, Persona.class);
            query.setParameter("curp", persona.getCurp());
            Persona personaBuscada = query.getSingleResult();
            em.getTransaction().commit();

//            Persona personaDTO = new Persona();
//            personaDTO.setNombre(personaBuscada.getNombre());
//            personaDTO.setApellidoP(personaBuscada.getApellidoP());
//            personaDTO.setApellidoM(personaBuscada.getApellidoM());
//            personaDTO.setCurp(personaBuscada.getCurp());
//            personaDTO.setTelefono(personaBuscada.getTelefono());
//            personaDTO.setFechaNac(personaBuscada.getFechaNac());
            return personaBuscada;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

}
