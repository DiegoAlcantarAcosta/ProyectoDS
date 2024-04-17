/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces.daos;

import entidades.Persona;
import entidades.Tarjeta;
//import entidades.Transferencia;
import guardado.TransferenciaDatos;
import java.util.List;

/**
 *
 * @author Diego
 */
public interface ITarjetaDAO {

    public List<Tarjeta> obtenerTarjetasPersona(Persona persona);
    public TransferenciaDatos getDatos();
    public Tarjeta obtenerTarjetaPorNumero(Tarjeta tarjeta);
    public Tarjeta obtenerUltimaTarjetaPersona(Persona persona);
//    public boolean realizarTransferencia(Transferencia transferenciaa);
}
