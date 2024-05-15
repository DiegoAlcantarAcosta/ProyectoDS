/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package encriptacion;

/**
 *
 * @author Dell
 */
public interface IEncriptador {
    public String getAES(String data);
    
    public String getAESDecrypt(String data);
}
