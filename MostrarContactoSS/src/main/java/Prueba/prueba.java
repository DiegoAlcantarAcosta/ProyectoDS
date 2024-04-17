/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Prueba;

import DAOS.PersonaDAO;
import DTOs.ContactoDTO;
import DTOs.PersonaDTO;
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
        ContactoDTO c = new ContactoDTO("Wili");
        PersonaDTO p = new PersonaDTO("RASM920730HDFNXN09");
        IObjetoNegocioPersona per = new ObjetoNegocioPersona();
        PersonaDTO perDTO = per.obtenerPersonaDTOPorCurp(p);
        
        System.out.println(m.obtenerContactoDTOPersona(c, perDTO));
        
        
    }
    
    
    
}
