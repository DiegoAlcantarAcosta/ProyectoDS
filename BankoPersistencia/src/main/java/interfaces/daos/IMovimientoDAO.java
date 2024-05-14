
package interfaces.daos;

import entidades.Movimiento;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Wilber
 */
public interface IMovimientoDAO {
    
   List<Movimiento> obtenerMovimientos(ObjectId userId, Date fechaInicio, Date fechaFin, boolean ingresos, boolean egresos);
    void guardarMovimiento(Movimiento movimiento);
}
