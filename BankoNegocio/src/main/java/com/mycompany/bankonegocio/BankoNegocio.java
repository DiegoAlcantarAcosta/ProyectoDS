/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bankonegocio;

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
import java.time.Instant;
import java.util.Date;

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
        
        PersonaDTO personaDTO = new PersonaDTO("RASM920730HDFNXN09");
        Persona personaEnt = new Persona("RASM920730HDFNXN09");
        
        ContactoDTO contactoDTO = new ContactoDTO("Wili");
        
        TarjetaDTO tarjetaDTO = new TarjetaDTO("111111111");
        
        ot.obtenerTarjetaDTOPorNumero(tarjetaDTO);
        System.out.println(ot.obtenerTarjetaDTOPorNumero(tarjetaDTO));
        
        ot.obtenerTarjetasDTOPersona(personaDTO);
        System.out.println(ot.obtenerTarjetasDTOPersona(personaDTO));
        
        ot.obtenerUltimaTarjetaDTOPersona(personaDTO);
        System.out.println(ot.obtenerUltimaTarjetaDTOPersona(personaDTO));
        
        Date fecha = Date.from(Instant.now());
        
        TransferenciaDTO transferenciaDTO = new TransferenciaDTO("1234567890", "111111111",
                20D, "Pa las uñas;)");
        
        
        System.out.println("Tranferencia hecha?: " + otr.realizarTransferencia(transferenciaDTO));
        
        
        
        
        System.out.println(op.obtenerPersonaDTOPorCurp(personaDTO));
        TarjetaDTO tar = new TarjetaDTO("1234567891");
        PersonaDTO per = new PersonaDTO("FEGC850315HDFMOM02");
        
        
        
        
        ContactoDTO con = new ContactoDTO("so", "Sebastián", "Ortiz", "Flores", 
                "1234567894", tipoBancoDTO.HSBC, per);
        
        System.out.println(oc.agregar(con));
////        System.out.println(op.convertirDTOAEntidad(personaDTO));
////        System.out.println(op.convertirEntidadADTO(personaEnt));
//        System.out.println(oc.obtenerContactoDTOPersona(contactoDTO, personaDTO));
////        System.out.println(oc.obtenerContactosDTOPersona(personaDTO));
    }
}
