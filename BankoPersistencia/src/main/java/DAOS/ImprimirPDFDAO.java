/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOS;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import encriptacion.Encriptador;
import encriptacion.IEncriptador;
import entidades.Transferencia;
import interfaces.daos.IImprimirPDFDAO;
import java.io.ByteArrayOutputStream;
import java.util.List;

/**
 *
 * @author Wilber
 */
public class ImprimirPDFDAO implements IImprimirPDFDAO {

    IEncriptador enc = new Encriptador();

    @Override
//    public ByteArrayOutputStream imprimirPDF(List<Transferencia> transferencias) {
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        Document document = new Document();
//
//        try {
//            PdfWriter.getInstance(document, baos);
//            document.open();
//
//            document.add(new Paragraph("Movimientos de transferencias"));
//            
//            PdfPTable table = new PdfPTable(5);
//            table.addCell("Destinatario");
//            table.addCell("Importe");
//            table.addCell("Motivo");
//            table.addCell("Numero Cuenta");
//            table.addCell("Fecha");
//
//            for (Transferencia transferencia : transferencias) {
//                String numeroCuentaDestinatarioDesencriptado = enc.getAESDecrypt(transferencia.getNumeroCuentaDestinatario());
//                String numeroCuentaPropietarioDesencriptado = enc.getAESDecrypt(transferencia.getNumeroCuentaPropietario());
//
//                table.addCell(numeroCuentaDestinatarioDesencriptado);
//                table.addCell(transferencia.getImporte().toString());
//                table.addCell(transferencia.getMotivo());
//                table.addCell(numeroCuentaPropietarioDesencriptado);
//                table.addCell(transferencia.getFechaMovimiento().toString());
//            }
//
//            document.add(table);
//        } catch (DocumentException e) {
//            e.printStackTrace();
//        } finally {
//            document.close();
//        }
//
//        return baos;
//    }

    public ByteArrayOutputStream imprimirPDF(List<Transferencia> transferencias) {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    Document document = new Document();

    try {
        PdfWriter.getInstance(document, baos);
        document.open();

        // Título del documento
        
       Font fuenteBanko = new Font(Font.FontFamily.HELVETICA, 20, Font.BOLD);
        Paragraph banko = new Paragraph("BANKO", fuenteBanko);
        banko.setAlignment(Element.ALIGN_CENTER);
        banko.setSpacingAfter(10f); // Espacio después del nombre del banco
        document.add(banko);
        
        Font fuenteTitulo = new Font(Font.FontFamily.HELVETICA, 18, Font.NORMAL);
        Paragraph titulo = new Paragraph("Movimientos de transferencias", fuenteTitulo);
        titulo.setAlignment(Element.ALIGN_CENTER);
        titulo.setSpacingAfter(20f);      
        
        document.add(titulo);

        // Crear tabla con estilos
        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100);
        table.setSpacingBefore(10f);
        table.setSpacingAfter(10f);

        // Encabezados de columna
        Font fuenteEncabezado = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
        PdfPCell celda = new PdfPCell(new Phrase("Destinatario", fuenteEncabezado));
        celda.setBackgroundColor(BaseColor.LIGHT_GRAY);
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("Importe", fuenteEncabezado));
        celda.setBackgroundColor(BaseColor.LIGHT_GRAY);
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("Motivo", fuenteEncabezado));
        celda.setBackgroundColor(BaseColor.LIGHT_GRAY);
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("Numero Cuenta", fuenteEncabezado));
        celda.setBackgroundColor(BaseColor.LIGHT_GRAY);
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("Fecha", fuenteEncabezado));
        celda.setBackgroundColor(BaseColor.LIGHT_GRAY);
        table.addCell(celda);

        // Agregar datos a la tabla
        for (Transferencia transferencia : transferencias) {
            String numeroCuentaDestinatarioDesencriptado = enc.getAESDecrypt(transferencia.getNumeroCuentaDestinatario());
            String numeroCuentaPropietarioDesencriptado = enc.getAESDecrypt(transferencia.getNumeroCuentaPropietario());

            table.addCell(numeroCuentaDestinatarioDesencriptado);
            table.addCell(transferencia.getImporte().toString());
            table.addCell(transferencia.getMotivo());
            table.addCell(numeroCuentaPropietarioDesencriptado);
            table.addCell(transferencia.getFechaMovimiento().toString());
        }

        document.add(table);

    } catch (DocumentException e) {
        e.printStackTrace();
    } finally {
        document.close();
    }

    return baos;
}
    }

