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
public class EncriptadorSS implements IEncriptadorSS{
    IObjetoNegocioEncriptador enc;

    public EncriptadorSS() {
        enc = new ObjetoNegocioEncriptador();
    }
    

    @Override
    public String getAES(String data) {
        return enc.getAES(data);
    }
}
