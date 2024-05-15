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
import encriptacion.Encriptador;
import encriptacion.IEncriptador;
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
 * @author Diego
 */
public class ObjetoNegocioTarjeta implements IObjetoNegocioTarjeta {

    ITarjetaDAO td;
    IPersonaDAO pd;
    IEncriptador enc = new Encriptador();

    /**
     * Constructor para inicializar
     */
    public ObjetoNegocioTarjeta() {
        td = new TarjetaDAO();
        pd = new PersonaDAO();
    }

   /**
    * convertir DTO a entidad
    * @param tarjetaDTO tarjeta
    * @return  tarjeta
    */
    public Tarjeta convertirDTOAEntidad(TarjetaDTO tarjetaDTO) {
        Tarjeta tarjeta = new Tarjeta();
        tarjeta.setFechaVencimiento(tarjetaDTO.getFechaVencimiento());
        tarjeta.setId(tarjetaDTO.getId());
        tarjeta.setNumeroCuenta(enc.getAES(tarjetaDTO.getNumeroCuenta()));
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

   
    /**
     * convertir entidad a DTO
     * @param tarjeta tarjeta
     * @return  tarjetaDTO
     */
    public TarjetaDTO convertirEntidadADTO(Tarjeta tarjeta) {
        TarjetaDTO tarjetaDTO = new TarjetaDTO();
        tarjetaDTO.setFechaVencimiento(tarjeta.getFechaVencimiento());
        tarjetaDTO.setId(new ObjectId("" + tarjeta.getId()));
        tarjetaDTO.setNumeroCuenta(enc.getAESDecrypt(tarjeta.getNumeroCuenta()));
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

   /**
    * obtiene las tarjetasDTO de una persona
    * @param personaDTO persona
    * @return  lista de tarjetas DTO
    */
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
            return null;
        }
    }

    /**
     * obtener la uultima tarjeta d euna persona
     * @param personaDTO persona
     * @return  tarjeta
     */
    @Override
    public TarjetaDTO obtenerUltimaTarjetaDTOPersona(PersonaDTO personaDTO) {
        ObjetoNegocioPersona op = new ObjetoNegocioPersona();
        PersonaDTO personaBuscada = op.obtenerPersonaDTOPorCurp(personaDTO);
        Persona persona = op.convertirDTOAEntidad(personaBuscada);

        Tarjeta tarjetaBuscada = td.obtenerUltimaTarjetaPersona(persona);
        TarjetaDTO tarjetaConvert = this.convertirEntidadADTO(tarjetaBuscada);

        return tarjetaConvert;

    }

   /**
    * obtener una tarjeta por numero
    * @param tarjetaDTO tarjeta
    * @return  tarjetaDTO
    */
    @Override
    public TarjetaDTO obtenerTarjetaDTOPorNumero(TarjetaDTO tarjetaDTO) {
        Tarjeta tarjetaBuscada = td.obtenerTarjetaPorNumero(new Tarjeta(tarjetaDTO.getNumeroCuenta()));
        if (tarjetaBuscada != null) {
            TarjetaDTO tarjetaConvert = this.convertirEntidadADTO(tarjetaBuscada);

            return tarjetaConvert;
        }
        return null;

    }

    /**
     * obtener todas las tarjetas
     * @return lista de tarjetasDTO
     */
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

   /**
    * Metodo para guardar una tarjeta
    * @param persona persona
    * @param tarjeta tarjeta
    * @throws PersistenciaException  excepccion
    */
    @Override
    public void guardar(PersonaDTO persona, TarjetaDTO tarjeta) throws PersistenciaException {
        ObjetoNegocioPersona onp = new ObjetoNegocioPersona();
        Tarjeta tarjetaEnt = convertirDTOAEntidad(tarjeta);
        Persona personaEnt = onp.convertirDTOAEntidad(persona);
        td.guardar(personaEnt, tarjetaEnt);
    }

    /**
     * Metodo para actualizar una tarjeta 
     * @param persona persona
     * @param tarjeta tarjeta
     * @throws PersistenciaException en caso de error
     */
    @Override
    public void actualizar(PersonaDTO persona, TarjetaDTO tarjeta) throws PersistenciaException {
        ObjetoNegocioPersona onp = new ObjetoNegocioPersona();
        Tarjeta tarjetaEnt = convertirDTOAEntidad(tarjeta);
        Persona personaEnt = onp.convertirDTOAEntidad(persona);
        td.actualizarTarjeta(personaEnt, tarjetaEnt);
    }

   /**
    * Metodo para eliminar una tarjeta
    * @param persona persona
    * @param tarjeta tarjeta
    * @throws PersistenciaException en caso de error
    */
    @Override
    public void eliminar(PersonaDTO persona, TarjetaDTO tarjeta) throws PersistenciaException {
        ObjetoNegocioPersona onp = new ObjetoNegocioPersona();
        Tarjeta tarjetaEnt = convertirDTOAEntidad(tarjeta);
        Persona personaEnt = onp.convertirDTOAEntidad(persona);
        td.eliminar(personaEnt, tarjetaEnt);
    }

   /**
    * Metodo para obtener una persona con una tarjeta
    * @param tarjeta tarejta
    * @return  personaDTO
    */
    @Override
    public PersonaDTO obtenerPersonaDeTarjeta(TarjetaDTO tarjeta) {
        ObjetoNegocioPersona onp = new ObjetoNegocioPersona();
        TarjetaDTO tarjetaTemporal = obtenerTarjetaDTOPorNumero(tarjeta);
        Tarjeta tarjetaEnt = convertirDTOAEntidad(tarjetaTemporal);
        Persona personaEnt = td.obtenerPersonaDeTarjeta(tarjetaEnt);
        return onp.convertirEntidadADTO(personaEnt);
    }
}
