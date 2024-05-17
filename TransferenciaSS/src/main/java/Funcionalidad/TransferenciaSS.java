
package Funcionalidad;

import DTOs.PersonaDTO;
import DTOs.TarjetaDTO;
import DTOs.TransferenciaDTO;
import Objetos.Interfaces.IObjetoNegocioContacto;
import Objetos.Interfaces.IObjetoNegocioPersona;
import Objetos.Interfaces.IObjetoNegocioTarjeta;
import Objetos.Interfaces.IObjetoNegocioTransferencia;
import Objetos.ObjetoNegocioPersona;
import Objetos.ObjetoNegocioTarjeta;
import Objetos.ObjetoNegocioTransferencia;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Wilber
 */
public class TransferenciaSS implements ITransferenciaSS{
    
    IObjetoNegocioTransferencia transferencia;
    IObjetoNegocioPersona persona;
    IObjetoNegocioTarjeta tarjeta;

    public TransferenciaSS() {
       this.transferencia = new ObjetoNegocioTransferencia();
       this.persona = new ObjetoNegocioPersona();
       this.tarjeta = new ObjetoNegocioTarjeta();
        
    }
    
  
    @Override
    public boolean realizarTransferencia(TransferenciaDTO transferenciaDTO){
         
        PersonaDTO personaBuscada = tarjeta.obtenerPersonaDeTarjeta(new TarjetaDTO(transferenciaDTO.getNumeroCuentaDestinatario()));
        if(personaBuscada != null){
            return transferencia.realizarTransferencia(transferenciaDTO);
        }
        
        
        
        return false;
        
        
    }
       
}
