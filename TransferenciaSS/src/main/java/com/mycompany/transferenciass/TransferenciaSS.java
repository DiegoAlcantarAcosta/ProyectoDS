
package com.mycompany.transferenciass;

import DTOs.TransferenciaDTO;
import Objetos.Interfaces.IObjetoNegocioTransferencia;
import Objetos.ObjetoNegocioTransferencia;

/**
 *
 * @author Wilber
 */
public class TransferenciaSS implements ITransferenciaSS{
    
    IObjetoNegocioTransferencia transferencia;

    public TransferenciaSS() {
       this.transferencia = new ObjetoNegocioTransferencia(); 
        
    }
    
  
    @Override
    public boolean realizarTransferencia(TransferenciaDTO transferenciaDTO){
         
        return transferencia.realizarTransferencia(transferenciaDTO);
        
        
    }

    
    
}
