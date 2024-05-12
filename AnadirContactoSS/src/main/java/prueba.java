
import DTOs.ContactoDTO;
import DTOs.PersonaDTO;
import DTOs.TarjetaDTO;
import DTOs.tipoBancoDTO;
import Funcionalidad.AnadirContactoSS;
import Objetos.ObjetoNegocioPersona;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Dell
 */
public class prueba {
    public static void main(String[] args) {
        AnadirContactoSS a = new AnadirContactoSS();
        TarjetaDTO tar = new TarjetaDTO("1234567891");
        PersonaDTO per = new PersonaDTO("FEGC850315HDFMOM02");
        ObjetoNegocioPersona op = new ObjetoNegocioPersona();
        
        PersonaDTO pepe = op.obtenerPersonaDTOPorCurp(per);
        
//        ContactoDTO con = new ContactoDTO("Pepe", "Camila", "Fernández", "Gómez", 
//                "1234567891", tipoBancoDTO.BANCOPPEL, pepe);
        
//        System.out.println(a.agregar(con));
    }
}
