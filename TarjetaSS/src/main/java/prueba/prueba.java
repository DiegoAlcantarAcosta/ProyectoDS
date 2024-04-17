/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba;

import DTOs.TarjetaDTO;
import Funcionalidad.TarjetaSS;

/**
 *
 * @author Dell
 */
public class prueba {
    public static void main(String[] args) {
        TarjetaSS t = new TarjetaSS();
        System.out.println(t.obtenerTarjetaDTOPorNumero(new TarjetaDTO("1234567891")));
        
    }
}
