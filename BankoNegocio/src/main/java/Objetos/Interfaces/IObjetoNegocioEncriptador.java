/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Objetos.Interfaces;

/**
 *
 * @author Dell
 */
public interface IObjetoNegocioEncriptador {
    /**
     * metodo para encriptar
     * @param data dato
     * @return  cadena
     */
    public String getAES(String data);
    
    /**
     * metodo para desencriptar
     * @param data data
     * @return  cadena
     */
    public String getAESDecrypt(String data);
}
