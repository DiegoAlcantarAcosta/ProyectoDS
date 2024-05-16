/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funcionalidad;

import Objetos.Interfaces.IObjetoNegocioEncriptador;
import Objetos.ObjetoNegocioEncriptador;

/**
 *
 * @author Dell
 */
public class DesencriptadorSS implements IDesencriptadorSS{
    IObjetoNegocioEncriptador des;

    public DesencriptadorSS() {
        des = new ObjetoNegocioEncriptador();
    }
    
    @Override
    public String getAESDecrypt(String data) {
        return des.getAESDecrypt(data);
    }
    
}
