/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOS;

import Conexion.Conexion;
import Conexion.IConexion;
import entidades.Tarjeta;
import entidades.Transferencia;
import guardado.General;
import guardado.TransferenciaDatos;
import interfaces.daos.ITransferenciaDAO;
import java.util.Date;
import javax.persistence.EntityManager;

/**
 *
 * @author Wilber
 */
public class TransferenciaDAO implements ITransferenciaDAO{
    
    private final IConexion conexion;
    private TransferenciaDatos datos;
    private Transferencia transferenciaa;
    private TarjetaDAO tarjeta;

    public TransferenciaDAO() {
        conexion = new Conexion();
        datos = General.transferencia;
        transferenciaa = new Transferencia();
        tarjeta = new TarjetaDAO();
    }
    
    @Override
    public boolean realizarTransferencia(Transferencia transferenciaa) {
    EntityManager em = conexion.abrir();
    try {
        em.getTransaction().begin();

        // Obtener la tarjeta del propietario
        Tarjeta tarjetaPropietario = tarjeta.obtenerTarjetaPorNumero(new Tarjeta(transferenciaa.getNumeroCuentaPropietario()));

        // Validar que el saldo sea suficiente
        if (tarjetaPropietario.getSaldo() >= transferenciaa.getImporte()) {
            // Realizar la transferencia
            tarjetaPropietario.setSaldo(tarjetaPropietario.getSaldo() - transferenciaa.getImporte());
            em.merge(tarjetaPropietario);

            // Obtener la tarjeta del destinatario
            Tarjeta tarjetaDestinatario = tarjeta.obtenerTarjetaPorNumero(new Tarjeta(transferenciaa.getNumeroCuentaDestinatario()));
            tarjetaDestinatario.setSaldo(tarjetaDestinatario.getSaldo() + transferenciaa.getImporte());
            em.merge(tarjetaDestinatario);

            // Guardar la transferencia
            transferenciaa.setFechaMovimiento(new Date());
            transferenciaa.setTarjeta(tarjetaPropietario);
            transferenciaa.setPersona(tarjetaPropietario.getPersona());
            em.persist(transferenciaa);

            em.getTransaction().commit();
            return true;
        } else {
            return false;
        }
    } catch (Exception e) {
        em.getTransaction().rollback();
        throw e;
    } finally {
        em.close();
    }
    
    }
    
    
    @Override
    public TransferenciaDatos getDatos() {
        return datos;
    }
    
}
