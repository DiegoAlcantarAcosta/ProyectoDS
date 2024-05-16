/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Funcionalidad;

/**
 *
 * @author Oley
 */
public interface ITransaccionSS {
     boolean registrarTransaccion(Transaccion transaccion);
    Transaccion obtenerTransaccionPorId(ObjectId grupoId);
}
