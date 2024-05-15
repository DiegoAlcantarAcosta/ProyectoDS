/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

import Objetos.Interfaces.IObjetoNegocioEncriptador;
import encriptacion.Encriptador;
import encriptacion.IEncriptador;

/**
 *
 * @author Dell
 */
public class ObjetoNegocioEncriptador implements IObjetoNegocioEncriptador{
    IEncriptador enc;

    /**
     * Constructor que inicializa
     */
    public ObjetoNegocioEncriptador() {
        enc = new Encriptador();
    }

    /**
     * Metodo para obtener el AES
     * @param data dato
     * @return  cadena
     */
    @Override
    public String getAES(String data) {
        return enc.getAES(data);
    }

    /**
     * Metodo para settear el AES
     * @param data dato
     * @return cadena
     */
    @Override
    public String getAESDecrypt(String data) {
        return enc.getAESDecrypt(data);
    }
    
    
    
    
}
