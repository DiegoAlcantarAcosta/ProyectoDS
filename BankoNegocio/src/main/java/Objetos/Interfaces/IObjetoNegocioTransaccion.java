/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Objetos.Interfaces;

import entidades.Transaccion;
import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */
public interface IObjetoNegocioTransaccion {
    
    /**
     * metodo para hacer transferencia
     * @param transaccion transaccion
     * @return  boolean
     */
    boolean registrarTransaccion(Transaccion transaccion);

    /**
     * obtener transaccion por id
     * @param grupoid id grupo
     * @return  transaccion
     */
    Transaccion obtenerTransaccionPorId(ObjectId grupoid);
}
