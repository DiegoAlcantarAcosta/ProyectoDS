/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

import Objetos.Interfaces.IObjetoNegocioTransaccion;
import entidades.Transaccion;
import interfaces.daos.ITransaccionDAO;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */
public class ObjetoNegocioTransaccion implements IObjetoNegocioTransaccion{
    private final ITransaccionDAO transaccionDAO;

    public ObjetoNegocioTransaccion(ITransaccionDAO transaccionDAO) {
        this.transaccionDAO = transaccionDAO;
    }

    @Override
    public boolean registrarTransaccion(Transaccion transaccion) {
        if (transaccion.getMonto() <= 0) {
            System.out.println("Error: El monto de la transacción debe ser mayor que cero.");
            return false;
        }

        try {
            transaccionDAO.registrarTransaccion(transaccion);
            return true; 
        } catch (Exception e) {
            e.printStackTrace();
            return false; 
        }
    }

    @Override
    public Transaccion obtenerTransaccionPorId(ObjectId grupoid) {
    List<Transaccion> transacciones = transaccionDAO.obtenerTransaccionesPorGrupo(grupoid);
    if (!transacciones.isEmpty()) {
        return transacciones.get(0);
    } else {
        return null;
    }

    }
}
