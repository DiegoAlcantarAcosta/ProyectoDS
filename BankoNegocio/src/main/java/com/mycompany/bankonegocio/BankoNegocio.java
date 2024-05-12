/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.bankonegocio;

import DAOS.TarjetaDAO;
import DTOs.ContactoDTO;
import DTOs.PersonaDTO;
import DTOs.TarjetaDTO;
import DTOs.TransferenciaDTO;
import DTOs.tipoBancoDTO;
import Objetos.ObjetoNegocioContacto;
import Objetos.ObjetoNegocioPersona;
import Objetos.ObjetoNegocioTarjeta;
import Objetos.ObjetoNegocioTransferencia;
import entidades.Persona;
import entidades.Tarjeta;
import java.time.Instant;
import java.util.Date;
import org.bson.types.ObjectId;

/**
 *
 * @author Dell
 */
public class BankoNegocio {

    public static void main(String[] args) {
        ObjetoNegocioContacto oc = new ObjetoNegocioContacto();
        ObjetoNegocioPersona op = new ObjetoNegocioPersona();
        ObjetoNegocioTarjeta ot = new ObjetoNegocioTarjeta();
        ObjetoNegocioTransferencia otr = new ObjetoNegocioTransferencia();
        TarjetaDAO td = new TarjetaDAO();
        TarjetaDTO tarjeDesti;
        ContactoDTO contactoDTO = new ContactoDTO("Wili", "wiliberto", "Perez", "Perez", "1", tipoBancoDTO.BANCOPPEL);
        PersonaDTO personaDTO = new PersonaDTO("");
        

//        Tarjeta tarjeta = new Tarjeta("111111111");
//        Tarjeta tarjetaBuscada = td.obtenerTarjetaPorNumero(tarjeta);
//        TarjetaDTO tarjetaDTO = ot.convertirEntidadADTO(tarjetaBuscada);
////        System.out.println(ot.obtenerPersonaDeTarjeta(tarjetaDTO));
//
//        PersonaDTO personaDTO = new PersonaDTO("PEGJ900615HDFRZN00");
//        System.out.println(op.obtenerPersonaDTOPorCurp(personaDTO).toString());

//        TarjetaDTO tarjetaBuscada = tarjetaSS.obtenerTarjetaDTOPorNumero(new TarjetaDTO(numero));
//        tarjeDesti = tarjetaSS.obtenerTarjetaDTOPorNumero(new TarjetaDTO(tarjetaBuscada.getNumeroCuenta()));
//        ot.eliminar(tarjeta);

    }
}
