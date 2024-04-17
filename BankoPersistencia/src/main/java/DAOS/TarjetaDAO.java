/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOS;

import Conexion.Conexion;
import Conexion.IConexion;
import entidades.Persona;
import entidades.Tarjeta;
import entidades.Transferencia;
import interfaces.daos.ITarjetaDAO;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Diego
 */
public class TarjetaDAO implements ITarjetaDAO {

    private final IConexion conexion;
    private Transferencia transferenciaa;

    public TarjetaDAO() {
        conexion = new Conexion();
        transferenciaa = new Transferencia();
    }

    @Override
    public List<Tarjeta> obtenerTarjetasPersona(Persona persona) {
        EntityManager em = conexion.abrir();
        PersonaDAO personaDAO = new PersonaDAO();
        Persona personaBuscada = personaDAO.obtenerPersonaPorCurp(persona);
        
        try {
            em.getTransaction().begin();
            // Crear la consulta JPA
            String query = "SELECT t FROM Tarjeta t WHERE t.persona = :persona";
            TypedQuery<Tarjeta> q = em.createQuery(query, Tarjeta.class);
            q.setParameter("persona", personaBuscada);
            em.getTransaction().commit();

            // Ejecutar la consulta y obtener los resultados
            List<Tarjeta> tarjetas = q.getResultList();
            return tarjetas;
        } finally {
            em.close();
        }
    }
    
    @Override
    public Tarjeta obtenerUltimaTarjetaPersona(Persona persona) {
        EntityManager em = conexion.abrir();
        PersonaDAO personaDAO = new PersonaDAO();
        Persona personaBuscada = personaDAO.obtenerPersonaPorCurp(persona);
        em.getTransaction().begin();
        try {
            // Crear la consulta JPA
            String query = "SELECT t FROM Tarjeta t WHERE t.persona = :persona order by t.id desc";
            TypedQuery<Tarjeta> q = em.createQuery(query, Tarjeta.class);
            q.setParameter("persona", personaBuscada);
            q.setMaxResults(1);

            // Ejecutar la consulta y obtener los resultados
            Tarjeta ultimaTarjeta = q.getSingleResult();
            em.getTransaction().commit();
            return ultimaTarjeta;
        } finally {
            em.close();
        }
    }
    
    @Override
    public Tarjeta obtenerTarjetaPorNumero(Tarjeta tarjeta) {
        EntityManager em = conexion.abrir();
        em.getTransaction().begin();
        try {
            // Crear la consulta JPA
            String query = "SELECT t FROM Tarjeta t WHERE t.numeroCuenta = :numeroCuenta";
            TypedQuery<Tarjeta> q = em.createQuery(query, Tarjeta.class);
            q.setParameter("numeroCuenta", tarjeta.getNumeroCuenta());

            // Ejecutar la consulta y obtener los resultados
            Tarjeta tarjetaBuscada = q.getSingleResult();
            em.getTransaction().commit();
            
            return tarjetaBuscada;
        } finally {
            em.close();
        }
        
        
    }
    
    

//   public boolean realizarTransferencia(Transferencia transferenciaa) {
//    EntityManager em = conexion.abrir();
//    try {
//        em.getTransaction().begin();
//
//        // Obtener la tarjeta del propietario
//        Tarjeta tarjetaPropietario = obtenerTarjetaPorNumero(new Tarjeta(transferenciaa.getNumeroCuentaPropietario()));
//
//        // Validar que el saldo sea suficiente
//        if (tarjetaPropietario.getSaldo() >= transferenciaa.getImporte()) {
//            // Realizar la transferencia
//            tarjetaPropietario.setSaldo(tarjetaPropietario.getSaldo() - transferenciaa.getImporte());
//            em.merge(tarjetaPropietario);
//
//            // Obtener la tarjeta del destinatario
//            Tarjeta tarjetaDestinatario = obtenerTarjetaPorNumero(new Tarjeta(transferenciaa.getNumeroCuentaDestinatario()));
//            tarjetaDestinatario.setSaldo(tarjetaDestinatario.getSaldo() + transferenciaa.getImporte());
//            em.merge(tarjetaDestinatario);
//
//            // Guardar la transferencia
//            transferenciaa.setFechaMovimiento(new Date());
//            transferenciaa.setTarjeta(tarjetaPropietario);
//            transferenciaa.setPersona(tarjetaPropietario.getPersona());
//            em.persist(transferenciaa);
//
//            em.getTransaction().commit();
//            return true;
//        } else {
//            return false;
//        }
//    } catch (Exception e) {
//        em.getTransaction().rollback();
//        throw e;
//    } finally {
//        em.close();
//    }
//    
//    }

}
