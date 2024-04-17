/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

import DAOS.TarjetaDAO;
import DTOs.PersonaDTO;
import DTOs.TarjetaDTO;
import DTOs.tipoBancoDTO;
import DTOs.tipoTarjetaDTO;
import Objetos.Interfaces.IObjetoNegocioTarjeta;
import entidades.Persona;
import entidades.Tarjeta;
import entidades.tipoBanco;
import entidades.tipoTarjeta;
import interfaces.daos.ITarjetaDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell
 */
public class ObjetoNegocioTarjeta implements IObjetoNegocioTarjeta {
    ITarjetaDAO td;

    public ObjetoNegocioTarjeta() {
        td = new TarjetaDAO();
    }
    
    public Tarjeta convertirDTOAEntidad(TarjetaDTO tarjetaDTO) {
        Tarjeta tarjeta = new Tarjeta();
        tarjeta.setFechaVencimiento(tarjetaDTO.getFechaVencimiento());
        tarjeta.setNumeroCuenta(tarjetaDTO.getNumeroCuenta());
        tarjeta.setSaldo(tarjetaDTO.getSaldo());
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

        ObjetoNegocioPersona onp = new ObjetoNegocioPersona();
        PersonaDTO personaDTO = onp.obtenerPersonaDTOPorCurp(tarjetaDTO.getPersona());
        Persona persona = onp.convertirDTOAEntidad(personaDTO);

        tarjeta.setPersona(persona);

        return tarjeta;
    }
    
    public TarjetaDTO convertirEntidadADTO(Tarjeta tarjeta) {
        TarjetaDTO tarjetaDTO = new TarjetaDTO();
        tarjetaDTO.setFechaVencimiento(tarjeta.getFechaVencimiento());
        tarjetaDTO.setNumeroCuenta(tarjeta.getNumeroCuenta());
        tarjetaDTO.setSaldo(tarjeta.getSaldo());
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

        ObjetoNegocioPersona onp = new ObjetoNegocioPersona();
        PersonaDTO personaDTO = onp.convertirEntidadADTO(tarjeta.getPersona());
        PersonaDTO persona = onp.obtenerPersonaDTOPorCurp(personaDTO);

        tarjetaDTO.setPersona(persona);

        return tarjetaDTO;
    }
    
    @Override
    public List<TarjetaDTO> obtenerTarjetasDTOPersona(PersonaDTO personaDTO){
        ObjetoNegocioPersona op = new ObjetoNegocioPersona();
        PersonaDTO personaBuscada = op.obtenerPersonaDTOPorCurp(personaDTO);
        Persona persona = op.convertirDTOAEntidad(personaBuscada);

        List<Tarjeta> listaEnt = td.obtenerTarjetasPersona(persona);
        List<TarjetaDTO> listaDTO = new ArrayList<>();

        for (Tarjeta tarjeta : listaEnt) {
            TarjetaDTO tarjeClonDTO = this.convertirEntidadADTO(tarjeta);
            listaDTO.add(tarjeClonDTO);
        }
        return listaDTO;
    }
    
    @Override
    public TarjetaDTO obtenerUltimaTarjetaDTOPersona(PersonaDTO personaDTO){
        ObjetoNegocioPersona op = new ObjetoNegocioPersona();
        PersonaDTO personaBuscada = op.obtenerPersonaDTOPorCurp(personaDTO);
        Persona persona = op.convertirDTOAEntidad(personaBuscada);
        
        Tarjeta tarjetaBuscada = td.obtenerUltimaTarjetaPersona(persona);
        TarjetaDTO tarjetaConvert = this.convertirEntidadADTO(tarjetaBuscada);
        
        return tarjetaConvert;
        
    }
    
    @Override
    public TarjetaDTO obtenerTarjetaDTOPorNumero(TarjetaDTO tarjetaDTO){
        Tarjeta tarjetaBuscada = td.obtenerTarjetaPorNumero(new Tarjeta(tarjetaDTO.getNumeroCuenta()));
        TarjetaDTO tarjetaConvert = this.convertirEntidadADTO(tarjetaBuscada);
        
        return tarjetaConvert;
    }


    
    
    
}
