/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import Conexion.Conexion;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Oley
 */
public class Consultas {
    public String obtenerNombre(String numeroCuenta) {
        EntityManager em = new Conexion().abrir();

        String jpql = "SELECT p.nombre " +
                      "FROM Persona p " +
                      "JOIN p.tarjetas t " +
                      "WHERE t.numeroCuenta = :numeroCuenta";

        TypedQuery<String> query = em.createQuery(jpql, String.class);
        query.setParameter("numeroCuenta", Integer.parseInt(numeroCuenta));

        String nombre = null;
        try {
            nombre = query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return nombre;
    }

    public String obtenerBanco(String numeroCuenta) {
        EntityManager em = new Conexion().abrir();

        String jpql = "SELECT t.banco " +
                      "FROM Tarjeta t " +
                      "WHERE t.numeroCuenta = :numeroCuenta";

        TypedQuery<String> query = em.createQuery(jpql, String.class);
        query.setParameter("numeroCuenta", Integer.parseInt(numeroCuenta));

        String banco = null;
        try {
            banco = query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return banco;
    }
}
