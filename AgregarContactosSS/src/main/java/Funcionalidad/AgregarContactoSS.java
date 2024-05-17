/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funcionalidad;

import DTOs.ContactoDTO;
import Objetos.Interfaces.IObjetoNegocioGrupo;
import Objetos.ObjetoNegocioGrupo;

/**
 *
 * @author Oley
 */
public class AgregarContactoSS implements IAgregarContactoSS{
    IObjetoNegocioGrupo ObjetoNegocioGrupo;

    public AgregarContactoSS( ) {
        this.ObjetoNegocioGrupo = new ObjetoNegocioGrupo();
    }

    @Override
    public Boolean agregarContacto(ContactoDTO contactoDTO, String idGrupo) {
return ObjetoNegocioGrupo.agregarContacto(contactoDTO, idGrupo);    }
    
    
    
    
    
    
}
