/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funcionalidad;

import DTOs.TarjetaDTO;
import Objetos.Interfaces.IObjetoNegocioTransferencia;
import Objetos.ObjetoNegocioTransferencia;
import java.io.ByteArrayOutputStream;
import java.util.Date;

/**
 *
 * @author Wilber
 */
public class ImprimirPDFSS implements IImprimirPDFSS{

    IObjetoNegocioTransferencia imprimirPDF;

    public ImprimirPDFSS() {
        this.imprimirPDF = new ObjetoNegocioTransferencia();
    }

    @Override
    public ByteArrayOutputStream imprimirPDF(TarjetaDTO tarjetaDTO, Date fechaInicio, Date fechaFin, boolean ingresos, boolean egresos) {
        return imprimirPDF.imprimirPDF(tarjetaDTO, fechaInicio, fechaFin, ingresos, egresos);
    }

}
