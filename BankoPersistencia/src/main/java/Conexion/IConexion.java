/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Conexion;

import javax.persistence.EntityManager;

/**
 *
 * @author PERSONAL
 */
public interface IConexion {
    
    /**
     * Abre una conexión con la base de datos utilizando JPA.
     * 
     * @return Un objeto EntityManager que representa la conexión establecida.
     */
    EntityManager abrir();
    
}
