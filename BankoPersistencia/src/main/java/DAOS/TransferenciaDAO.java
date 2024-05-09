/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOS;

import Conexion.Conexion;
import entidades.Tarjeta;
import entidades.Transferencia;
import interfaces.daos.ITransferenciaDAO;
import java.util.Date;
import javax.persistence.EntityManager;

/**
 *
 * @author Wilber
 */
public class TransferenciaDAO implements ITransferenciaDAO{
    
    private Transferencia transferenciaa;
    private TarjetaDAO tarjeta;

    public TransferenciaDAO() {
        transferenciaa = new Transferencia();
        tarjeta = new TarjetaDAO();
    }
    
    @Override
    public boolean realizarTransferencia(Transferencia transferenciaa) {
 
    
        return false;
 
    
    }
    
    
}
