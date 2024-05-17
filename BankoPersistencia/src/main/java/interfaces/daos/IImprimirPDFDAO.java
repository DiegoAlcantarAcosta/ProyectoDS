/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces.daos;

import entidades.Transferencia;
import java.io.ByteArrayOutputStream;
import java.util.List;

/**
 *
 * @author Wilber
 */
public interface IImprimirPDFDAO {

    public ByteArrayOutputStream imprimirPDF(List<Transferencia> transferencias);
    
}

