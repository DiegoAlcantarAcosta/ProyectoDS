/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package Funcionalidad;

import DTOs.ContactoDTO;
import DTOs.TarjetaDTO;
import Objetos.Interfaces.IObjetoNegocioContacto;
import Objetos.Interfaces.IObjetoNegocioTarjeta;
import Objetos.ObjetoNegocioContacto;
import Objetos.ObjetoNegocioTarjeta;

/**
 *
 * @author Diego
 */
public class AnadirContactoSS implements IAnadirContactoSS {
 IObjetoNegocioContacto contacto;

    public AnadirContactoSS() {
        contacto = new ObjetoNegocioContacto();
        
    }

    @Override
    public Boolean agregar(ContactoDTO contactoDTO) {
       return contacto.agregar(contactoDTO);
    }

   
}
