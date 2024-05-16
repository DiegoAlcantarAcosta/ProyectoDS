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

    public ObjetoNegocioEncriptador() {
        enc = new Encriptador();
    }

    @Override
    public String getAES(String data) {
        return enc.getAES(data);
    }

    @Override
    public String getAESDecrypt(String data) {
        return enc.getAESDecrypt(data);
    }
    
    
    
    
}
