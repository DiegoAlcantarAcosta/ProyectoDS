/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

import DAOS.ImprimirPDFDAO;
import DAOS.TransferenciaDAO;
import DTOs.PersonaDTO;
import DTOs.TarjetaDTO;
import DTOs.TransferenciaDTO;
import DTOs.tipoBancoDTO;
import DTOs.tipoTarjetaDTO;
import Objetos.Interfaces.IObjetoNegocioTransferencia;
import encriptacion.Encriptador;
import encriptacion.IEncriptador;
import entidades.Persona;
import entidades.Tarjeta;
import entidades.Transferencia;
import entidades.tipoBanco;
import static entidades.tipoBanco.BANAMEX;
import static entidades.tipoBanco.BANCOPPEL;
import static entidades.tipoBanco.BANREGIO;
import static entidades.tipoBanco.BBVA;
import static entidades.tipoBanco.HSBC;
import static entidades.tipoBanco.SANTANDER;
import entidades.tipoTarjeta;
import static entidades.tipoTarjeta.CREDITO;
import static entidades.tipoTarjeta.DEBITO;
import interfaces.daos.IImprimirPDFDAO;
import interfaces.daos.ITransferenciaDAO;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * La clase ObjetoNegocioTransferencia implementa la interfaz
 * IObjetoNegocioTransferencia y proporciona métodos para convertir entre
 * objetos de transferencia y DTO, así como para realizar operaciones
 * relacionadas con transferencias financieras.
 *
 * @author Dell
 */
public class ObjetoNegocioTransferencia implements IObjetoNegocioTransferencia {

    ITransferenciaDAO trd;
    IEncriptador enc = new Encriptador();
    IImprimirPDFDAO impPDF;

    /**
     * Constructor de la clase ObjetoNegocioTransferencia. Inicializa el objeto
     * TransferenciaDAO.
     */
    public ObjetoNegocioTransferencia() {
        trd = new TransferenciaDAO();
        impPDF = new ImprimirPDFDAO();
    }

    @Override
    public ByteArrayOutputStream imprimirPDF(TarjetaDTO tarjetaDTO, Date fechaInicio, Date fechaFin, boolean ingresos, boolean egresos) {
        Tarjeta tarjetaConvert = this.convertirDTOAEntidad(tarjetaDTO);
        List<Transferencia> transferenciasEntidad;

        if (ingresos && egresos) {
            transferenciasEntidad = trd.obtenerTransferencias(tarjetaConvert, fechaInicio, fechaFin);
        } else if (ingresos) {
            transferenciasEntidad = trd.obtenerTransferenciasIngreso(tarjetaConvert, fechaInicio, fechaFin);
        } else if (egresos) {
            transferenciasEntidad = trd.obtenerTransferenciasEgreso(tarjetaConvert, fechaInicio, fechaFin);
        } else {
            transferenciasEntidad = trd.obtenerTransferenciasSinFecha(tarjetaConvert);
        }

        return impPDF.imprimirPDF(transferenciasEntidad);
    }

    /**
     * Convierte un objeto de transferencia DTO a un objeto de entidad
     * Transferencia.
     *
     * @param transferenciaDTO El objeto de transferencia DTO a convertir.
     * @return El objeto de transferencia convertido a entidad.
     */
    public Transferencia convertirDTOAEntidad(TransferenciaDTO transferenciaDTO) {
        Transferencia transferencia = new Transferencia();
        transferencia.setFechaMovimiento(transferenciaDTO.getFechaMovimiento());
        transferencia.setImporte(transferenciaDTO.getImporte());
        transferencia.setMotivo(transferenciaDTO.getMotivo());
        transferencia.setNumeroCuentaDestinatario(transferenciaDTO.getNumeroCuentaDestinatario());
        transferencia.setNumeroCuentaPropietario(transferenciaDTO.getNumeroCuentaPropietario());

//        ObjetoNegocioPersona onp = new ObjetoNegocioPersona();
//        PersonaDTO personaDTO = onp.obtenerPersonaDTOPorCurp(transferenciaDTO.getPersona());
//        Persona persona = onp.convertirDTOAEntidad(personaDTO);
//
//        transferencia.setPersona(persona);
//        
//        ObjetoNegocioTarjeta ont = new ObjetoNegocioTarjeta();
//        TarjetaDTO tarjetaDTO = ont.obtenerTarjetaDTOPorNumero(transferenciaDTO.getTarjeta());
//        Tarjeta tarjeta = ont.convertirDTOAEntidad(tarjetaDTO);
//
//        transferencia.setTarjeta(tarjeta);
        return transferencia;
    }

    /**
     * Convierte un objeto de entidad Transferencia a un objeto de transferencia
     * DTO.
     *
     * @param transferencia El objeto de entidad Transferencia a convertir.
     * @return El objeto de transferencia convertido a DTO.
     */
    public TransferenciaDTO convertirEntidadADTO(Transferencia transferencia) {
        TransferenciaDTO transferenciaDTO = new TransferenciaDTO();
        transferenciaDTO.setFechaMovimiento(transferencia.getFechaMovimiento());
        transferenciaDTO.setImporte(transferencia.getImporte());
        transferenciaDTO.setMotivo(transferencia.getMotivo());
        transferenciaDTO.setNumeroCuentaDestinatario(enc.getAESDecrypt(transferencia.getNumeroCuentaDestinatario()));
        transferenciaDTO.setNumeroCuentaPropietario(enc.getAESDecrypt(transferencia.getNumeroCuentaPropietario()));

        return transferenciaDTO;
    }

    /**
     * Realiza una transferencia financiera utilizando un objeto de
     * transferencia DTO.
     *
     * @param transferenciaDTO El objeto de transferencia DTO que contiene la
     * información de la transferencia.
     * @return true si la transferencia se realizó con éxito, false en caso
     * contrario.
     */
    @Override
    public boolean realizarTransferencia(TransferenciaDTO transferenciaDTO) {
        Transferencia transferencia = this.convertirDTOAEntidad(transferenciaDTO);
        boolean verificar = trd.realizarTransferencia(transferencia);
        return verificar;
    }

//    @Override
//    public List<TransferenciaDTO> obtenerTransferencias(ObjectId userId, Date fechaInicio, Date fechaFin, boolean ingresos, boolean egresos) {
//    List<Transferencia> transferenciasEntidad = trd.obtenerTransferencias(userId, fechaInicio, fechaFin, ingresos, egresos);
//    List<TransferenciaDTO> transferenciasDTO = new ArrayList<>();
//
//    for (Transferencia transferencia : transferenciasEntidad) {
//        TransferenciaDTO transferenciaDTO = convertirEntidadADTO(transferencia);
//        transferenciasDTO.add(transferenciaDTO);
//    }
//
//    return transferenciasDTO;
//}
    /**
     * Obtiene una lista de transferencias de egreso realizadas desde una
     * tarjeta en un rango de fechas.
     *
     * @param tarjetaDTO El objeto de DTO de tarjeta asociado a las
     * transferencias de egreso.
     * @return Una lista de transferencias de egreso en formato DTO.
     */
    public Tarjeta convertirDTOAEntidad(TarjetaDTO tarjetaDTO) {
        Tarjeta tarjeta = new Tarjeta();
        tarjeta.setFechaVencimiento(tarjetaDTO.getFechaVencimiento());
        tarjeta.setId(tarjetaDTO.getId());
        tarjeta.setNumeroCuenta(tarjetaDTO.getNumeroCuenta());
        tarjeta.setSaldo(tarjetaDTO.getSaldo());

        tipoBancoDTO banco = tarjetaDTO.getBanco();
        tipoBanco banc;

        switch (banco) {
            case BANAMEX:
                banc = tipoBanco.BANAMEX;
                break;
            case BANCOPPEL:
                banc = tipoBanco.BANCOPPEL;
                break;
            case BANREGIO:
                banc = tipoBanco.BANREGIO;
                break;
            case BBVA:
                banc = tipoBanco.BBVA;
                break;
            case HSBC:
                banc = tipoBanco.HSBC;
                break;
            case SANTANDER:
                banc = tipoBanco.SANTANDER;
                break;
            // Añade casos para otros valores de tipoBanco si es necesario
            default:
                banc = null;
        }

        tipoTarjetaDTO tipo = tarjetaDTO.getTipo();
        tipoTarjeta tip;

        switch (tipo) {
            case CREDITO:
                tip = tipoTarjeta.CREDITO;
                break;
            case DEBITO:
                tip = tipoTarjeta.DEBITO;
                break;
            // Añade casos para otros valores de tipoBanco si es necesario
            default:
                tip = null;
        }

        tarjeta.setBanco(banc);
        tarjeta.setTipo(tip);

        return tarjeta;
    }

    // Diego Alcantar 
    /**
     * Convierte un objeto de entidad Tarjeta a un objeto de transferencia DTO.
     *
     * @param tarjeta El objeto de entidad Tarjeta a convertir.
     * @return El objeto de transferencia DTO convertido.
     */
    public TarjetaDTO convertirEntidadADTO(Tarjeta tarjeta) {
        TarjetaDTO tarjetaDTO = new TarjetaDTO();
        tarjetaDTO.setFechaVencimiento(tarjeta.getFechaVencimiento());
        tarjetaDTO.setId(new ObjectId("" + tarjeta.getId()));
        tarjetaDTO.setNumeroCuenta(tarjeta.getNumeroCuenta());
        tarjetaDTO.setSaldo(tarjeta.getSaldo());

        tipoBanco banco = tarjeta.getBanco();
        tipoBancoDTO banc;

        switch (banco) {
            case BANAMEX:
                banc = tipoBancoDTO.BANAMEX;
                break;
            case BANCOPPEL:
                banc = tipoBancoDTO.BANCOPPEL;
                break;
            case BANREGIO:
                banc = tipoBancoDTO.BANREGIO;
                break;
            case BBVA:
                banc = tipoBancoDTO.BBVA;
                break;
            case HSBC:
                banc = tipoBancoDTO.HSBC;
                break;
            case SANTANDER:
                banc = tipoBancoDTO.SANTANDER;
                break;
            // Añade casos para otros valores de tipoBanco si es necesario
            default:
                banc = null;
        }

        tipoTarjeta tipo = tarjeta.getTipo();
        tipoTarjetaDTO tip;

        switch (tipo) {
            case CREDITO:
                tip = tipoTarjetaDTO.CREDITO;
                break;
            case DEBITO:
                tip = tipoTarjetaDTO.DEBITO;
                break;
            // Añade casos para otros valores de tipoBanco si es necesario
            default:
                tip = null;
        }

        tarjetaDTO.setBanco(banc);
        tarjetaDTO.setTipo(tip);

        return tarjetaDTO;
    }

    //    @Override
//    public List<TransferenciaDTO> obtenerTransferencias(ObjectId userId, Date fechaInicio, Date fechaFin, boolean ingresos, boolean egresos) {
//    List<Transferencia> transferenciasEntidad = trd.obtenerTransferencias(userId, fechaInicio, fechaFin, ingresos, egresos);
//    List<TransferenciaDTO> transferenciasDTO = new ArrayList<>();
//
//    for (Transferencia transferencia : transferenciasEntidad) {
//        TransferenciaDTO transferenciaDTO = convertirEntidadADTO(transferencia);
//        transferenciasDTO.add(transferenciaDTO);
//    }
//
//    return transferenciasDTO;
//}
    /**
     * Obtiene una lista de transferencias de egreso realizadas desde una
     * tarjeta en un rango de fechas.
     *
     * @param tarjetaDTO El objeto de DTO de tarjeta asociado a las
     * transferencias de egreso.
     * @param fechaInicio La fecha de inicio del rango.
     * @param fechaFin La fecha de fin del rango.
     * @return Una lista de transferencias de egreso en formato DTO.
     */
    @Override
    public List<TransferenciaDTO> obtenerTransferenciasEgreso(TarjetaDTO tarjetaDTO, Date fechaInicio, Date fechaFin) {
        Tarjeta tarjetaConvert = this.convertirDTOAEntidad(tarjetaDTO);
        List<Transferencia> transferenciasEntidad = trd.obtenerTransferenciasEgreso(tarjetaConvert, fechaInicio, fechaFin);
        List<TransferenciaDTO> transferenciasDTO = new ArrayList<>();

        for (Transferencia transferencia : transferenciasEntidad) {
            TransferenciaDTO transferenciaDTO = convertirEntidadADTO(transferencia);
            transferenciasDTO.add(transferenciaDTO);
        }

        return transferenciasDTO;

    }

    /**
     * Obtiene todas las transferencias de ingreso de una tarjeta en un rango de
     * fechas.
     *
     * @param tarjetaDTO El objeto TarjetaDTO asociado a las transferencias.
     * @param fechaInicio La fecha de inicio del rango.
     * @param fechaFin La fecha de fin del rango.
     * @return Una lista de objetos TransferenciaDTO que representan las
     * transferencias de ingreso.
     */
    @Override
    public List<TransferenciaDTO> obtenerTransferenciasIngreso(TarjetaDTO tarjetaDTO, Date fechaInicio, Date fechaFin) {
        Tarjeta tarjetaConvert = this.convertirDTOAEntidad(tarjetaDTO);
        List<Transferencia> transferenciasEntidad = trd.obtenerTransferenciasIngreso(tarjetaConvert, fechaInicio, fechaFin);
        List<TransferenciaDTO> transferenciasDTO = new ArrayList<>();

        for (Transferencia transferencia : transferenciasEntidad) {
            TransferenciaDTO transferenciaDTO = convertirEntidadADTO(transferencia);
            transferenciasDTO.add(transferenciaDTO);
        }

        return transferenciasDTO;

    }

    /**
     * Obtiene todas las transferencias asociadas a una tarjeta en un rango de
     * fechas.
     *
     * @param tarjetaDTO El objeto TarjetaDTO asociado a las transferencias.
     * @param fechaInicio La fecha de inicio del rango.
     * @param fechaFin La fecha de fin del rango.
     * @return Una lista de objetos TransferenciaDTO que representan todas las
     * transferencias asociadas a la tarjeta en el rango especificado.
     */
    @Override
    public List<TransferenciaDTO> obtenerTransferencias(TarjetaDTO tarjetaDTO, Date fechaInicio, Date fechaFin) {
        Tarjeta tarjetaConvert = this.convertirDTOAEntidad(tarjetaDTO);
        List<Transferencia> transferenciasEntidad = trd.obtenerTransferencias(tarjetaConvert, fechaInicio, fechaFin);
        List<TransferenciaDTO> transferenciasDTO = new ArrayList<>();

        for (Transferencia transferencia : transferenciasEntidad) {
            TransferenciaDTO transferenciaDTO = convertirEntidadADTO(transferencia);
            transferenciasDTO.add(transferenciaDTO);
        }

        return transferenciasDTO;

    }

    /**
     * Obtiene el total de ingresos realizados en un día específico mediante una
     * tarjeta.
     *
     * @param tarjetaDTO El objeto TarjetaDTO asociado a los ingresos.
     * @return El total de ingresos realizados en el día mediante la tarjeta.
     */
    @Override
    public Double ingresosDelDia(TarjetaDTO tarjetaDTO) {
        Tarjeta tarjetaConvert = this.convertirDTOAEntidad(tarjetaDTO);
        Double ingreso = trd.ingresosDelDia(tarjetaConvert);
        return ingreso;

    }

    /**
     * Obtiene el total de egresos realizados en un día específico mediante una
     * tarjeta.
     *
     * @param tarjetaDTO El objeto TarjetaDTO asociado a los egresos.
     * @return El total de egresos realizados en el día mediante la tarjeta.
     */
    @Override
    public Double egresosDelDia(TarjetaDTO tarjetaDTO) {
        Tarjeta tarjetaConvert = this.convertirDTOAEntidad(tarjetaDTO);
        Double egreso = trd.egresosDelDia(tarjetaConvert);
        return egreso;

    }

    /**
     * Obtiene todas las transferencias asociadas a una tarjeta sin tener en
     * cuenta la fecha.
     *
     * @param tarjetaDTO El objeto TarjetaDTO asociado a las transferencias.
     * @return Una lista de objetos TransferenciaDTO que representan todas las
     * transferencias asociadas a la tarjeta.
     */
    @Override
    public List<TransferenciaDTO> obtenerTransferenciasSinFecha(TarjetaDTO tarjetaDTO) {
        Tarjeta tarjetaConvert = this.convertirDTOAEntidad(tarjetaDTO);
        List<Transferencia> transferenciasEntidad = trd.obtenerTransferenciasSinFecha(tarjetaConvert);
        List<TransferenciaDTO> transferenciasDTO = new ArrayList<>();

        for (Transferencia transferencia : transferenciasEntidad) {
            TransferenciaDTO transferenciaDTO = convertirEntidadADTO(transferencia);
            transferenciasDTO.add(transferenciaDTO);
        }

        return transferenciasDTO;

    }

}
