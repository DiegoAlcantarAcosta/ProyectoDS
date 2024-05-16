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
    boolean registrarTransaccion(Transaccion transaccion);

    Transaccion obtenerTransaccionPorId(ObjectId grupoid);
}
