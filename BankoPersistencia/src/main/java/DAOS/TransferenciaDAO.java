/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOS;

import Conexion.Conexion;



import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import encriptacion.Encriptador;
import entidades.Persona;
import entidades.Tarjeta;
import entidades.Transferencia;
import interfaces.daos.ITarjetaDAO;
import interfaces.daos.ITransferenciaDAO;
import java.io.ByteArrayOutputStream;
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
 * YA LISTOOO La clase TransferenciaDAO implementa la interfaz ITransferenciaDAO
 * y proporciona funcionalidades para realizar operaciones relacionadas con
 * transferencias financieras en una base de datos MongoDB.
 *
 * @author Wilber
 */
public class TransferenciaDAO implements ITransferenciaDAO {

    MongoCollection<Transferencia> coleccionTransferencia;
    MongoCollection<Persona> coleccionPersonas;
    ITarjetaDAO td;
    Encriptador enc = new Encriptador();

    /**
     * Constructor por defecto de la clase TransferenciaDAO. Inicializa las
     * colecciones y el objeto para acceder a las funcionalidades relacionadas
     * con las tarjetas.
     */
    public TransferenciaDAO() {
        coleccionPersonas = Conexion.getDatabase().getCollection("Personas", Persona.class);
        coleccionTransferencia = Conexion.getDatabase().getCollection("Transferencias", Transferencia.class);
        td = new TarjetaDAO();
    }

    /**
     * Realiza una transferencia financiera entre dos cuentas.
     *
     * @param transferencia La transferencia a realizar.
     * @return true si la transferencia se realizó con éxito, false en caso
     * contrario.
     */
    @Override
    public boolean realizarTransferencia(Transferencia transferencia) {
        try {

            if (transferencia.getNumeroCuentaDestinatario().equals(transferencia.getNumeroCuentaPropietario())) {
                return false;
            }

            Tarjeta tarjetaPropietario = td.obtenerTarjetaPorNumero(new Tarjeta(transferencia.getNumeroCuentaPropietario()));
            Tarjeta tarjetaDestinatario = td.obtenerTarjetaPorNumero(new Tarjeta(transferencia.getNumeroCuentaDestinatario()));

            Persona personaRemitente = td.obtenerPersonaDeTarjeta(tarjetaPropietario);
            Persona personaDestinatario = td.obtenerPersonaDeTarjeta(tarjetaDestinatario);

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
            transferencia.setNumeroCuentaDestinatario(enc.getAES(transferencia.getNumeroCuentaDestinatario()));
            transferencia.setNumeroCuentaPropietario(enc.getAES(transferencia.getNumeroCuentaPropietario()));
            MongoCollection<Transferencia> coleccionTransferencias = Conexion.getDatabase().getCollection("Transferencias", Transferencia.class);

            coleccionTransferencias.insertOne(transferencia);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Obtiene una lista de transferencias de egreso realizadas desde una
     * tarjeta en un rango de fechas.
     *
     * @param tarjeta La tarjeta asociada a las transferencias de egreso.
     * @param fechaInicio La fecha de inicio del rango.
     * @param fechaFin La fecha de fin del rango.
     * @return Una lista de transferencias de egreso.
     */
    @Override
    public List<Transferencia> obtenerTransferenciasEgreso(Tarjeta tarjeta, Date fechaInicio, Date fechaFin) {
        tarjeta.setNumeroCuenta(enc.getAES(tarjeta.getNumeroCuenta()));
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

    /**
     * Obtiene una lista de transferencias de ingreso recibidas en una tarjeta
     * en un rango de fechas.
     *
     * @param tarjeta La tarjeta asociada a las transferencias de ingreso.
     * @param fechaInicio La fecha de inicio del rango.
     * @param fechaFin La fecha de fin del rango.
     * @return Una lista de transferencias de ingreso.
     */
    @Override
    public List<Transferencia> obtenerTransferenciasIngreso(Tarjeta tarjeta, Date fechaInicio, Date fechaFin) {
        tarjeta.setNumeroCuenta(enc.getAES(tarjeta.getNumeroCuenta()));
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

    /**
     * Obtiene una lista de todas las transferencias (tanto ingresos como
     * egresos) realizadas por una tarjeta dentro de un rango de fechas
     * especificado.
     *
     * @param tarjeta La tarjeta asociada a las transferencias.
     * @param fechaInicio La fecha de inicio del rango.
     * @param fechaFin La fecha de fin del rango.
     * @return Una lista de todas las transferencias realizadas por la tarjeta
     * en el rango de fechas especificado.
     */
    @Override
    public List<Transferencia> obtenerTransferencias(Tarjeta tarjeta, Date fechaInicio, Date fechaFin) {
        List<Transferencia> listaIngresos = this.obtenerTransferenciasIngreso(tarjeta, fechaInicio, fechaFin);
        List<Transferencia> listaEgresos = this.obtenerTransferenciasEgreso(tarjeta, fechaInicio, fechaFin);

        List<Transferencia> lista = new ArrayList<>();
        lista.addAll(listaIngresos);
        lista.addAll(listaEgresos);

        return lista;
    }

    /**
     * Obtiene una lista de todas las transferencias (tanto ingresos como
     * egresos) realizadas por una tarjeta sin tener en cuenta la fecha.
     *
     * @param tarjeta La tarjeta asociada a las transferencias.
     * @return Una lista de todas las transferencias realizadas por la tarjeta
     * sin tener en cuenta la fecha.
     */
    @Override
    public List<Transferencia> obtenerTransferenciasSinFecha(Tarjeta tarjeta) {
        tarjeta.setNumeroCuenta(enc.getAES(tarjeta.getNumeroCuenta()));
        MongoCollection<Transferencia> coleccionTransferencias = Conexion.getDatabase().getCollection("Transferencias", Transferencia.class);

        Document filtroTarjeta = new Document("$or", Arrays.asList(
                new Document("numeroCuentaPropietario", tarjeta.getNumeroCuenta()),
                new Document("numeroCuentaDestinatario", tarjeta.getNumeroCuenta())));

        List<Transferencia> listaBuscada = coleccionTransferencias.find(filtroTarjeta)
                .into(new ArrayList<>());

        return listaBuscada;
    }

    /**
     * Calcula el total de ingresos realizados por una tarjeta en el día actual.
     *
     * @param tarjeta La tarjeta asociada a los ingresos.
     * @return El total de ingresos realizados por la tarjeta en el día actual.
     */
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

    /**
     * Calcula el total de egresos realizados por una tarjeta en el día actual.
     *
     * @param tarjeta La tarjeta asociada a los egresos.
     * @return El total de egresos realizados por la tarjeta en el día actual.
     */
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
