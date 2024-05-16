/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import Funcionalidad.IniciarSesionSS;

/**
 *
 * @author Diego
 */
public class pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IniciarSesionSS s = new IniciarSesionSS();
        String telefono = "";
        String contra = "";
        System.out.println(s.procesarInicioSesion(telefono, contra));
    }
    
}
