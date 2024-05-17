/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Funcionalidad;

import DTOs.TarjetaDTO;
import java.io.ByteArrayOutputStream;
import java.util.Date;

/**
 *
 * @author Wilber
 */
public interface IImprimirPDFSS {
    
    public ByteArrayOutputStream imprimirPDF(TarjetaDTO tarjetaDTO, Date fechaInicio, Date fechaFin, boolean ingresos, boolean egresos);
    
}
