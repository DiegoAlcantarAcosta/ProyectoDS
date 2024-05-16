/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.itransaccionss;

import DTOs.TransaccionDTO;
import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */
public interface ITransaccionSS {
    boolean registrarTransaccion(TransaccionDTO transaccionDTO);
    TransaccionDTO obtenerTransaccionPorId(ObjectId grupoId);
}
