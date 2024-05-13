package DAOS;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import entidades.Movimiento;
import entidades.tipoBanco;
import interfaces.daos.IMovimientoDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Wilber
 */
public class MovimientoDAO implements IMovimientoDAO {

    private MongoCollection<Document> coleccionMovimientos;

    public MovimientoDAO(MongoDatabase db) {
        this.coleccionMovimientos = db.getCollection("movimientos");

    }

    @Override
    public List<Movimiento> obtenerMovimientos(ObjectId userId, Date fechaInicio, Date fechaFin, boolean ingresos, boolean egresos) {
        List<Movimiento> movimientos = new ArrayList<>();
        BasicDBObject query = new BasicDBObject();
        query.put("userId", userId);
        query.put("fecha", new BasicDBObject("$gte", fechaInicio).append("$lte", fechaFin));

        if (ingresos && !egresos) {
            query.put("importe", new BasicDBObject("$gt", 0));
        } else if (!ingresos && egresos) {
            query.put("importe", new BasicDBObject("$lt", 0));
        }

        FindIterable<Document> resultados = coleccionMovimientos.find(query);
        for (Document doc : resultados) {
            Movimiento movimiento = convertirDocumentoAMovimientoDTO(doc);
            movimientos.add(movimiento);
        }

        return movimientos;
    }

    private Movimiento convertirDocumentoAMovimientoDTO(Document doc) {
        ObjectId id = (ObjectId) doc.get("_id");
        String nombre = doc.getString("nombre");
        Double importe = doc.getDouble("importe");
        String motivo = doc.getString("motivo");

        String codigoBanco = doc.getString("banco");
        tipoBanco banco = tipoBanco.valueOf(codigoBanco);

        String numeroCuenta = doc.getString("numeroCuenta");
        Date fecha = doc.getDate("fecha");

        return new Movimiento(id, nombre, importe, motivo, banco, numeroCuenta, fecha);

    }

}
