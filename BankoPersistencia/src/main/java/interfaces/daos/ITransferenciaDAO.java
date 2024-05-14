/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces.daos;

import entidades.Tarjeta;
import entidades.Transferencia;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Wilber
 */
public interface ITransferenciaDAO {

    public boolean realizarTransferencia(Transferencia transferenciaa);
    public List<Transferencia> obtenerTransferenciasEgreso(Tarjeta tarjeta, Date fechaInicio, Date fechaFin);
    public List<Transferencia> obtenerTransferenciasIngreso(Tarjeta tarjeta, Date fechaInicio, Date fechaFin);
    public List<Transferencia> obtenerTransferencias(Tarjeta tarjeta, Date fechaInicio, Date fechaFin);
    public Double ingresosDelDia (Tarjeta tarjeta);
    public Double egresosDelDia (Tarjeta tarjeta);
    public List<Transferencia> obtenerTransferenciasSinFecha(Tarjeta tarjeta);
    //completo
}
