/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.itransaccionss;

import DTOs.TransaccionDTO;
import entidades.Transaccion;
import interfaces.daos.ITransaccionDAO;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */
public class TransaccionSS implements ITransaccionSS{

    private final ITransaccionDAO transaccionDAO;

    public TransaccionSS(ITransaccionDAO transaccionDAO) {
        this.transaccionDAO = transaccionDAO;
    }

    @Override
    public boolean registrarTransaccion(TransaccionDTO transaccionDTO) {
        Transaccion transaccion = convertirATransaccion(transaccionDTO);
        return transaccionDAO.registrarTransaccion(transaccion);
    }

    @Override
    public TransaccionDTO obtenerTransaccionPorId(ObjectId grupoId) {
        Transaccion transaccion = transaccionDAO.obtenerTransaccionesPorGrupo(grupoId).get(0);
    if (transaccion != null) {
        return convertirATransaccionDTO(transaccion);
    } else {
        return null;
    }
    }

    private Transaccion convertirATransaccion(TransaccionDTO transaccionDTO) {
        Transaccion transaccion = new Transaccion();
        transaccion.setGrupoId(transaccionDTO.getGrupoId());
        transaccion.setMonto(transaccionDTO.getMonto());
        transaccion.setDescripcion(transaccionDTO.getDescripcion());
        return transaccion;
    }

    private TransaccionDTO convertirATransaccionDTO(Transaccion transaccion) {
        TransaccionDTO transaccionDTO = new TransaccionDTO();
        transaccionDTO.setGrupoId(transaccion.getGrupoId());
        transaccionDTO.setMonto(transaccion.getMonto());
        transaccionDTO.setDescripcion(transaccion.getDescripcion());
        return transaccionDTO;
    }
    
    
}
