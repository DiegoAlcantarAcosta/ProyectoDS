/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

import DAOS.TransferenciaDAO;
import DTOs.PersonaDTO;
import DTOs.TarjetaDTO;
import DTOs.TransferenciaDTO;
import DTOs.tipoBancoDTO;
import DTOs.tipoTarjetaDTO;
import Objetos.Interfaces.IObjetoNegocioTransferencia;
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
import interfaces.daos.ITransferenciaDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Dell
 */
public class ObjetoNegocioTransferencia implements IObjetoNegocioTransferencia {

    ITransferenciaDAO trd;

    public ObjetoNegocioTransferencia() {
        trd = new TransferenciaDAO();
    }

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

    public TransferenciaDTO convertirEntidadADTO(Transferencia transferencia) {
        TransferenciaDTO transferenciaDTO = new TransferenciaDTO();
        transferenciaDTO.setFechaMovimiento(transferencia.getFechaMovimiento());
        transferenciaDTO.setImporte(transferencia.getImporte());
        transferenciaDTO.setMotivo(transferencia.getMotivo());
        transferenciaDTO.setNumeroCuentaDestinatario(transferencia.getNumeroCuentaDestinatario());
        transferenciaDTO.setNumeroCuentaPropietario(transferencia.getNumeroCuentaPropietario());

        return transferenciaDTO;
    }

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

    @Override
    public Double ingresosDelDia(TarjetaDTO tarjetaDTO) {
        Tarjeta tarjetaConvert = this.convertirDTOAEntidad(tarjetaDTO);
        Double ingreso = trd.ingresosDelDia(tarjetaConvert);
        return ingreso;

    }

    @Override
    public Double egresosDelDia(TarjetaDTO tarjetaDTO) {
        Tarjeta tarjetaConvert = this.convertirDTOAEntidad(tarjetaDTO);
        Double egreso = trd.egresosDelDia(tarjetaConvert);
        return egreso;

    }

}
