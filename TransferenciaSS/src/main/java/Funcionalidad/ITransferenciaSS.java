
package Funcionalidad;

import DTOs.TransferenciaDTO;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Wilber
 */
public interface ITransferenciaSS {
    
  public boolean realizarTransferencia(TransferenciaDTO transferenciaDTO);
  
}
