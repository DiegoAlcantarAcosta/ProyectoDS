/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOS;

import Conexion.Conexion;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import entidades.Persona;
import entidades.Tarjeta;
import entidades.Transferencia;
import interfaces.daos.ITarjetaDAO;
import interfaces.daos.ITransferenciaDAO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.bson.BsonDateTime;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 * YA LISTOOO
 *
 * @author Wilber
 */
public class TransferenciaDAO implements ITransferenciaDAO {

    MongoCollection<Transferencia> coleccionTransferencia;
    MongoCollection<Persona> coleccionPersonas;
    ITarjetaDAO td;

    public TransferenciaDAO() {
        coleccionPersonas = Conexion.getDatabase().getCollection("Personas", Persona.class);
        coleccionTransferencia = Conexion.getDatabase().getCollection("Transferencias", Transferencia.class);
        td = new TarjetaDAO();
    }

    @Override
    public boolean realizarTransferencia(Transferencia transferencia) {
        try {
            // Validar que las tarjetas sean diferentes
            if (transferencia.getNumeroCuentaDestinatario().equals(transferencia.getNumeroCuentaPropietario())) {
                return false;
            }

            // Obtener las tarjetas involucradas
            Tarjeta tarjetaPropietario = td.obtenerTarjetaPorNumero(new Tarjeta(transferencia.getNumeroCuentaPropietario()));
            Tarjeta tarjetaDestinatario = td.obtenerTarjetaPorNumero(new Tarjeta(transferencia.getNumeroCuentaDestinatario()));

            // Obtener las personas involucradas
            Persona personaRemitente = td.obtenerPersonaDeTarjeta(tarjetaPropietario);
            Persona personaDestinatario = td.obtenerPersonaDeTarjeta(tarjetaDestinatario);

            // Validar que se encontraron las personas y que tienen suficiente saldo
            if (personaRemitente == null || personaDestinatario == null) {
                return false;
            }

            if (tarjetaPropietario == null || tarjetaPropietario.getSaldo() < transferencia.getImporte()) {
                return false;
            }

            tarjetaPropietario.setSaldo(tarjetaPropietario.getSaldo() - transferencia.getImporte());
            tarjetaDestinatario.setSaldo(tarjetaDestinatario.getSaldo() + transferencia.getImporte());

            coleccionPersonas.updateOne(
                    Filters.and(
                            Filters.eq("_id", personaRemitente.getId()),
                            Filters.eq("listaTarjetas._id", tarjetaPropietario.getId())
                    ),
                    Updates.set("listaTarjetas.$", tarjetaPropietario)
            );

            coleccionPersonas.updateOne(
                    Filters.and(
                            Filters.eq("_id", personaDestinatario.getId()),
                            Filters.eq("listaTarjetas._id", tarjetaDestinatario.getId())
                    ),
                    Updates.set("listaTarjetas.$", tarjetaDestinatario)
            );

            // Guardar la transferencia
            transferencia.setFechaMovimiento(new Date());
            MongoCollection<Transferencia> coleccionTransferencias = Conexion.getDatabase().getCollection("Transferencias", Transferencia.class);

            // Convertir la fecha al formato de MongoDB
            // Convertir la fecha al formato BsonDateTime
//            BsonDateTime fechaMovimientoBson = new BsonDateTime(transferencia.getFechaMovimiento().getTime());
//            transferencia.setFechaMovimientoBson(fechaMovimientoBson);
            coleccionTransferencias.insertOne(transferencia);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Transferencia> obtenerTransferenciasEgreso(Tarjeta tarjeta, Date fechaInicio, Date fechaFin) {
        MongoCollection<Transferencia> coleccionTransferencias = Conexion.getDatabase().getCollection("Transferencias", Transferencia.class);
        
        Date fechaI = new Date(fechaInicio.getTime());
        Date fechaF = new Date(fechaFin.getTime());
        fechaI.setHours(0);
        fechaI.setMinutes(0);
        fechaI.setSeconds(0);

        fechaF.setHours(23);
        fechaF.setMinutes(59);
        fechaF.setSeconds(59);

        System.out.println("Inicio: " + fechaI);
        System.out.println("Fin: " + fechaF);

        Document filtroTarjeta = new Document("numeroCuentaPropietario", tarjeta.getNumeroCuenta());
        
        Document filtroFecha = new Document();
        filtroFecha.put("$gte", fechaI);
        filtroFecha.put("$lte", fechaF);
        
        List<Document> filtros = new ArrayList<>();
        filtros.add(filtroTarjeta);
        filtros.add(new Document("fechaMovimiento", filtroFecha));
        Document filtroCombinado = new Document("$and", filtros);
        
        List<Transferencia> transferenciasEgreso = coleccionTransferencias.find(filtroCombinado).into(new ArrayList<>());

        return transferenciasEgreso;
    }

    @Override
    public List<Transferencia> obtenerTransferenciasIngreso(Tarjeta tarjeta, Date fechaInicio, Date fechaFin) {
        
        MongoCollection<Transferencia> coleccionTransferencias = Conexion.getDatabase().getCollection("Transferencias", Transferencia.class);
        
        Date fechaI = new Date(fechaInicio.getTime());
        Date fechaF = new Date(fechaFin.getTime());
        fechaI.setHours(0);
        fechaI.setMinutes(0);
        fechaI.setSeconds(0);

        fechaF.setHours(23);
        fechaF.setMinutes(59);
        fechaF.setSeconds(59);

        System.out.println("Inicio: " + fechaI);
        System.out.println("Fin: " + fechaF);

        Document filtroTarjeta = new Document("numeroCuentaDestinatario", tarjeta.getNumeroCuenta());
        
        Document filtroFecha = new Document();
        filtroFecha.put("$gte", fechaI);
        filtroFecha.put("$lte", fechaF);
        
        List<Document> filtros = new ArrayList<>();
        filtros.add(filtroTarjeta);
        filtros.add(new Document("fechaMovimiento", filtroFecha));
        Document filtroCombinado = new Document("$and", filtros);
        
        List<Transferencia> transferenciasIngreso = coleccionTransferencias.find(filtroCombinado).into(new ArrayList<>());

        return transferenciasIngreso;

    }

//    @Override
//    public List<Transferencia> obtenerTransferencias(Tarjeta tarjeta, Date fechaInicio, Date fechaFin) {
//        MongoCollection<Transferencia> coleccionTransferencias = Conexion.getDatabase().getCollection("Transferencias", Transferencia.class);
//
//        // Crear un filtro para buscar transferencias asociadas a la tarjeta
//        Document filtroTarjetaEgreso = new Document("numeroCuentaPropietario", tarjeta.getNumeroCuenta());
//        Document filtroTarjetaIngreso = new Document("numeroCuentaDestinatario", tarjeta.getNumeroCuenta());
//
//        // Aplicar el filtro de la tarjeta a la consulta
//        List<Transferencia> listaBuscadaEgreso = coleccionTransferencias.find(filtroTarjetaEgreso).into(new ArrayList<>());
//        List<Transferencia> listaBuscadaIngreso = coleccionTransferencias.find(filtroTarjetaIngreso).into(new ArrayList<>());
//
//        // Ahora, necesitas aplicar los filtros adicionales de fecha y tipo de transferencia.
//        // Para ello, puedes utilizar el operador "and" en MongoDB.
//        BasicDBObject fechaQuery1 = new BasicDBObject();
//        fechaQuery1.put("$gte", fechaInicio); // Mayor o igual que fechaInicio
//        fechaQuery1.put("$lte", fechaFin);   // Menor o igual que fechaFin
//
//        // Combinar los filtros
//        BasicDBObject filtro1 = new BasicDBObject();
//        filtro1.put("fechaMovimiento", fechaQuery1);
////        filtro1.put("importe", new BasicDBObject("$lt", 0)); // Importe negativo para egresos
//
//        // Aplicar el filtro combinado
//        List<Transferencia> transferenciasEgreso = coleccionTransferencias.find(filtro1).into(new ArrayList<>());
//        List<Transferencia> transferenciasIngreso = coleccionTransferencias.find(filtro1).into(new ArrayList<>());
//
//        List<Transferencia> transferencias = new ArrayList<>();
//        transferencias.addAll(listaBuscadaEgreso);
//        transferencias.addAll(listaBuscadaIngreso);
//
//        return transferencias;
//    }
    @Override
    public List<Transferencia> obtenerTransferencias(Tarjeta tarjeta, Date fechaInicio, Date fechaFin) {
        List<Transferencia> listaIngresos = this.obtenerTransferenciasIngreso(tarjeta, fechaInicio, fechaFin);
        List<Transferencia> listaEgresos = this.obtenerTransferenciasEgreso(tarjeta, fechaInicio, fechaFin);

        List<Transferencia> lista = new ArrayList<>();
        lista.addAll(listaIngresos);
        lista.addAll(listaEgresos);

        return lista;
    }

    @Override
    public List<Transferencia> obtenerTransferenciasSinFecha(Tarjeta tarjeta) {
        MongoCollection<Transferencia> coleccionTransferencias = Conexion.getDatabase().getCollection("Transferencias", Transferencia.class);

        Document filtroTarjeta = new Document("$or", Arrays.asList(
                new Document("numeroCuentaPropietario", tarjeta.getNumeroCuenta()),
                new Document("numeroCuentaDestinatario", tarjeta.getNumeroCuenta())));

        List<Transferencia> listaBuscada = coleccionTransferencias.find(filtroTarjeta)
                .into(new ArrayList<>());

        return listaBuscada;
    }

    @Override
    public Double ingresosDelDia(Tarjeta tarjeta) {
        Date fecha = new Date();
        List<Transferencia> listaIngresos = this.obtenerTransferenciasIngreso(tarjeta, fecha, fecha);

        Double ingreso = 0d;

        if (listaIngresos != null) {

            for (Transferencia transferencia : listaIngresos) {
                ingreso += transferencia.getImporte();
            }
        }

        return ingreso;

    }

    @Override
    public Double egresosDelDia(Tarjeta tarjeta) {
        Date fecha = new Date();
        List<Transferencia> listaEgresos = this.obtenerTransferenciasEgreso(tarjeta, fecha, fecha);

        Double egreso = 0d;

        if (listaEgresos != null) {

            for (Transferencia transferencia : listaEgresos) {
                egreso += transferencia.getImporte();
            }
        }

        return egreso;

    }

}
