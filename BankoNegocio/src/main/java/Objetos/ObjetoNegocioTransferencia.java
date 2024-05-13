/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

import DAOS.TransferenciaDAO;
import DTOs.PersonaDTO;
import DTOs.TarjetaDTO;
import DTOs.TransferenciaDTO;
import Objetos.Interfaces.IObjetoNegocioTransferencia;
import entidades.Persona;
import entidades.Tarjeta;
import entidades.Transferencia;
import interfaces.daos.ITransferenciaDAO;

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
    public boolean realizarTransferencia(TransferenciaDTO transferenciaDTO){
        Transferencia transferencia = this.convertirDTOAEntidad(transferenciaDTO);
        boolean verificar = trd.realizarTransferencia(transferencia);
        return verificar;
    }
    
    
    
}
