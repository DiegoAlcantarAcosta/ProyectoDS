/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Prueba;

import DAOS.PersonaDAO;
import DTOs.ContactoDTO;
import DTOs.PersonaDTO;
import DTOs.tipoBancoDTO;
import Funcionalidad.MostrarContactoSS;
import Objetos.Interfaces.IObjetoNegocioPersona;
import Objetos.ObjetoNegocioPersona;

/**
 *
 * @author Dell
 */
public class prueba {
    public static void main(String[] args) {
        MostrarContactoSS m = new MostrarContactoSS();
        
        ContactoDTO contactoDTO = new ContactoDTO("Wili", "wiliberto", "Perez", "Perez", "1", tipoBancoDTO.BANCOPPEL);
        ContactoDTO contactoFalso = new ContactoDTO("Tumama", "wiliberto", "Perez", "Perez", "1", tipoBancoDTO.BANCOPPEL);
        ContactoDTO contactoActualizaDTO = new ContactoDTO("Wilito", "wiliberto", "Perez", "Perez", "2", tipoBancoDTO.BANCOPPEL);
        PersonaDTO personaDTO = new PersonaDTO("SALM851225MDFRPR09");
        PersonaDTO persona2DTO = new PersonaDTO("SALM851225MDFRPR09");
//        ContactoDTO c = new ContactoDTO("Wili");
//        PersonaDTO p = new PersonaDTO("RASM920730HDFNXN09");
//        IObjetoNegocioPersona per = new ObjetoNegocioPersona();
//        PersonaDTO perDTO = per.obtenerPersonaDTOPorCurp(p);
        
        System.out.println(m.obtenerContactosDTOPersona(personaDTO));
        
        
    }
    
    
    
}
