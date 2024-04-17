/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces.daos;

import entidades.Transferencia;
import guardado.TransferenciaDatos;

/**
 *
 * @author Wilber
 */
public interface ITransferenciaDAO {
    
    
        public boolean realizarTransferencia(Transferencia transferenciaa);
            public TransferenciaDatos getDatos();


}
