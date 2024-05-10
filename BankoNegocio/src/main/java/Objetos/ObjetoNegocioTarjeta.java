/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

import DAOS.PersonaDAO;
import DAOS.TarjetaDAO;
import DTOs.PersonaDTO;
import DTOs.TarjetaDTO;
import DTOs.tipoBancoDTO;
import DTOs.tipoTarjetaDTO;
import Excepciones.PersistenciaException;
import Objetos.Interfaces.IObjetoNegocioTarjeta;
import entidades.Persona;
import entidades.Tarjeta;
import entidades.tipoBanco;
import entidades.tipoTarjeta;
import interfaces.daos.IPersonaDAO;
import interfaces.daos.ITarjetaDAO;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Dell
 */
public class ObjetoNegocioTarjeta implements IObjetoNegocioTarjeta {

    ITarjetaDAO td;
    IPersonaDAO pd;

    public ObjetoNegocioTarjeta() {
        td = new TarjetaDAO();
        pd = new PersonaDAO();
    }

    public Tarjeta convertirDTOAEntidad(TarjetaDTO tarjetaDTO) {
        Tarjeta tarjeta = new Tarjeta();
        tarjeta.setFechaVencimiento(tarjetaDTO.getFechaVencimiento());
        tarjeta.setId(new ObjectId(""+ tarjetaDTO.getId()));
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

    @Override
    public List<TarjetaDTO> obtenerTarjetasDTOPersona(PersonaDTO personaDTO) {
        try {
            ObjetoNegocioPersona op = new ObjetoNegocioPersona();
            Persona persona = op.convertirDTOAEntidad(personaDTO);
            Persona person = pd.obtenerPersonaPorCurp(persona);
            List<Tarjeta> listaEnt = td.obtenerTarjetasPersona(person);
            List<TarjetaDTO> listaDTO = new ArrayList<>();

            for (Tarjeta tarjeta : listaEnt) {
                TarjetaDTO tarjeClonDTO = this.convertirEntidadADTO(tarjeta);
                listaDTO.add(tarjeClonDTO);
            }
            return listaDTO;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public TarjetaDTO obtenerUltimaTarjetaDTOPersona(PersonaDTO personaDTO) {
        ObjetoNegocioPersona op = new ObjetoNegocioPersona();
        PersonaDTO personaBuscada = op.obtenerPersonaDTOPorCurp(personaDTO);
        Persona persona = op.convertirDTOAEntidad(personaBuscada);

        Tarjeta tarjetaBuscada = td.obtenerUltimaTarjetaPersona(persona);
        TarjetaDTO tarjetaConvert = this.convertirEntidadADTO(tarjetaBuscada);

        return tarjetaConvert;

    }

    @Override
    public TarjetaDTO obtenerTarjetaDTOPorNumero(TarjetaDTO tarjetaDTO) {
        Tarjeta tarjetaBuscada = td.obtenerTarjetaPorNumero(new Tarjeta(tarjetaDTO.getNumeroCuenta()));
        TarjetaDTO tarjetaConvert = this.convertirEntidadADTO(tarjetaBuscada);

        return tarjetaConvert;
    }

    @Override
    public List<TarjetaDTO> obtenerTodasLasTarjetasDeClientes() {
        List<Tarjeta> listaEnt = td.obtenerTodasLasTarjetasDeClientes();
        List<TarjetaDTO> listaDTO = new ArrayList<>();
        for (Tarjeta tarjeta : listaEnt) {
            TarjetaDTO tarjeClonDTO = this.convertirEntidadADTO(tarjeta);
            listaDTO.add(tarjeClonDTO);
        }
        return listaDTO;
    }

    @Override
    public void guardar(PersonaDTO persona ,TarjetaDTO tarjeta) throws PersistenciaException {
        ObjetoNegocioPersona onp = new ObjetoNegocioPersona();
        Tarjeta tarjetaEnt = convertirDTOAEntidad(tarjeta);
        Persona personaEnt = onp.convertirDTOAEntidad(persona);
        td.guardar( personaEnt,tarjetaEnt);
    }

    @Override
    public void actualizar(TarjetaDTO tarjeta) throws PersistenciaException {
        Tarjeta tarjetaEnt = convertirDTOAEntidad(tarjeta);
        td.actualizar(tarjetaEnt);
    }

    @Override
    public void eliminar(PersonaDTO persona ,TarjetaDTO tarjeta) throws PersistenciaException {
        ObjetoNegocioPersona onp = new ObjetoNegocioPersona();
        Tarjeta tarjetaEnt = convertirDTOAEntidad(tarjeta);
        Persona personaEnt = onp.convertirDTOAEntidad(persona);
        td.eliminar(personaEnt ,tarjetaEnt);
    }

    @Override
    public PersonaDTO obtenerPersonaDeTarjeta(TarjetaDTO tarjeta) {
        ObjetoNegocioPersona onp = new ObjetoNegocioPersona();
        Tarjeta tarjetaEnt = convertirDTOAEntidad(tarjeta);
        Persona personaEnt = td.obtenerPersonaDeTarjeta(tarjetaEnt);
        return onp.convertirEntidadADTO(personaEnt);
    }
}
