package Interfaces;

import DTOs.PersonaDTO;
import DTOs.TarjetaDTO;
import DTOs.TransferenciaDTO;
import Funcionalidad.IImprimirPDFSS;
import Funcionalidad.IMovimientosTransferenciasSS;
import Funcionalidad.ITarjetaSS;
import Funcionalidad.ImprimirPDFSS;
import Funcionalidad.MovimientosTransferenciasSS;
import Funcionalidad.TarjetaSS;
import java.awt.Desktop;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.bson.types.ObjectId;

/**
 * ya kedo La clase FrmMovimientos es una interfaz gráfica de usuario (GUI) en
 * Java Swing para visualizar los movimientos financieros asociados a una
 * tarjeta.
 *
 * @author Wilber
 */
public class FrmMovimientos extends javax.swing.JFrame {

    
    private ITarjetaSS tarjetaSS;
    private PersonaDTO personaDTO;
    private TarjetaDTO tarjetaDTO;

    IMovimientosTransferenciasSS movimientos;
    IImprimirPDFSS impPDF;

    /**
     * Constructor de la clase.
     *
     * @param tarjetaDTO El objeto TarjetaDTO asociado a la tarjeta para la cual
     * se mostrarán los movimientos.
     */
    public FrmMovimientos(TarjetaDTO tarjetaDTO) {
        initComponents();
        tarjetaSS = new TarjetaSS();
        personaDTO = personaDTO;
        this.tarjetaDTO = tarjetaDTO;
        this.personaDTO = tarjetaSS.obtenerPersonaDeTarjeta(tarjetaDTO);
        movimientos = new MovimientosTransferenciasSS();
        impPDF = new ImprimirPDFSS();

        lblNombre.setText(this.lblNombre.getText() + ": " + this.personaDTO.getNombre() + " " + this.personaDTO.getApellidoP());
        lblCuenta.setText(this.lblCuenta.getText() + ": " + this.tarjetaDTO.getNumeroCuenta());
        lblBanco.setText(this.lblBanco.getText() + ": " + this.tarjetaDTO.getBanco().toString());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblCuenta = new javax.swing.JLabel();
        lblBanco = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        chbxIngresos = new javax.swing.JCheckBox();
        chbxEgresos = new javax.swing.JCheckBox();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnRegresar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        imprimirPDF = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Movimientos");

        jPanel1.setBackground(new java.awt.Color(102, 0, 0));
        jPanel1.setForeground(new java.awt.Color(153, 0, 0));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("MOVIMIENTOS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(374, 374, 374)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel5)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        lblNombre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNombre.setText("Nombre");

        lblCuenta.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCuenta.setText("Cuenta");

        lblBanco.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblBanco.setText("Banco");

        jDateChooser1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jDateChooser1KeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Inicio:");

        jDateChooser2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jDateChooser2KeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Fin:");

        chbxIngresos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        chbxIngresos.setText("Ingresos");
        chbxIngresos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbxIngresosActionPerformed(evt);
            }
        });

        chbxEgresos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        chbxEgresos.setText("Egresos");
        chbxEgresos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbxEgresosActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Destinatario", "Importe", "Motivo", "Numero Cuenta", "Fecha"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel3.setText("Para ver todos los movimientos, deja las fechas vacías y los checkbox vacíos");

        imprimirPDF.setBackground(new java.awt.Color(255, 153, 153));
        imprimirPDF.setForeground(new java.awt.Color(0, 0, 0));
        imprimirPDF.setText("Imprimir PDF");
        imprimirPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirPDFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(232, 232, 232)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel4))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(95, 95, 95)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(chbxEgresos)
                                                        .addComponent(chbxIngresos)))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lblBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(346, 346, 346))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(389, 389, 389)
                                .addComponent(btnBuscar))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(243, 243, 243)
                                .addComponent(jLabel3)))
                        .addGap(0, 248, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(301, 301, 301)
                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(imprimirPDF)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(112, 112, 112))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblCuenta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblBanco)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(chbxIngresos))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addComponent(chbxEgresos, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(25, 25, 25)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imprimirPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Actualiza los encabezados de la tabla de movimientos dependiendo de si se
     * están mostrando los ingresos o los egresos.
     * @param ingresos True si se están mostrando los ingresos, False si se
     * están mostrando los egresos.
     * @param egresos True si se están mostrando los egresos, False si se están
     * mostrando los ingresos.
     */
    private void actualizarEncabezadosTabla(boolean ingresos, boolean egresos) {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setColumnIdentifiers(new String[]{
            ingresos ? "Emisor" : "Destinatario",
            "Importe",
            "Motivo",
            "Numero Cuenta",
            "Fecha"
        });
    }

    /**
 * Llena la tabla de movimientos con los datos de las transferencias financieras proporcionadas en la lista.
 * @param transferencias Lista de objetos TransferenciaDTO que contienen los datos de las transferencias financieras.
 */
    private void llenarTabla(List<TransferenciaDTO> transferencias) {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(0);

        for (TransferenciaDTO transferencia : transferencias) {
            Object[] fila = new Object[5];
            fila[0] = transferencia.getNumeroCuentaDestinatario();
            fila[1] = transferencia.getImporte();
            fila[2] = transferencia.getMotivo();
            fila[3] = transferencia.getNumeroCuentaPropietario();
            fila[4] = transferencia.getFechaMovimiento();
            modelo.addRow(fila);
        }
    }

    /**
 * Maneja el evento de acción cuando el usuario selecciona o deselecciona el checkbox de "Ingresos".
 * Si se selecciona este checkbox, se deselecciona el checkbox de "Egresos".
 */
    private void chbxIngresosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbxIngresosActionPerformed
        if (chbxIngresos.isSelected()) {
            chbxEgresos.setSelected(false);
        }

    }//GEN-LAST:event_chbxIngresosActionPerformed

    /**
 * Maneja el evento de acción cuando el usuario selecciona o deselecciona el checkbox de "Egresos".
 * Si se selecciona este checkbox, se deselecciona el checkbox de "Ingresos".
 */
    private void chbxEgresosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbxEgresosActionPerformed
        if (chbxEgresos.isSelected()) {
            chbxIngresos.setSelected(false);
        }
    }//GEN-LAST:event_chbxEgresosActionPerformed

    /**
 * Maneja el evento de acción cuando el usuario hace clic en el botón "Buscar".
 * Obtiene las fechas de inicio y fin seleccionadas por el usuario, así como los checkboxes de "Ingresos" y "Egresos".
 * Luego, utiliza esta información para obtener las transferencias financieras correspondientes y actualizar la tabla.
 */
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        Date fechaInicio = jDateChooser1.getDate();
        Date fechaFin = jDateChooser2.getDate();
        boolean ingresos = chbxIngresos.isSelected();
        boolean egresos = chbxEgresos.isSelected();

        List<TransferenciaDTO> transferencias;
        if (ingresos && egresos) {
            transferencias = movimientos.obtenerTransferencias(tarjetaDTO, fechaInicio, fechaFin);
        } else if (ingresos && fechaInicio != null && fechaFin != null) {
            transferencias = movimientos.obtenerTransferenciasIngreso(tarjetaDTO, fechaInicio, fechaFin);
        } else if (egresos && fechaInicio != null && fechaFin != null) {
            transferencias = movimientos.obtenerTransferenciasEgreso(tarjetaDTO, fechaInicio, fechaFin);

        } else if (!egresos && !ingresos && fechaInicio == null && fechaFin == null) {
            transferencias = movimientos.obtenerTransferenciasSinFecha(tarjetaDTO);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione las fechas y seleccione si es ingreso o egreso", "Alerta", JOptionPane.WARNING_MESSAGE);
            return;
        }

        actualizarEncabezadosTabla(ingresos, egresos);
        llenarTabla(transferencias);


    }//GEN-LAST:event_btnBuscarActionPerformed

    /**
 * Maneja el evento de acción cuando el usuario hace clic en el botón "Regresar".
 * Cierra la ventana actual y vuelve al menú principal.
 */
    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        MenuPrincipal mp = new MenuPrincipal(personaDTO, tarjetaDTO);
        mp.show();
        this.dispose();

    }//GEN-LAST:event_btnRegresarActionPerformed

    /**
 * Maneja eventos de teclado para el componente de selección de fecha jDateChooser1.
 * Solo se permiten caracteres válidos en este campo (letras, dígitos y espacios en blanco).
 */
    private void jDateChooser1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateChooser1KeyTyped
        char c = evt.getKeyChar();

        if (!Character.isLetter(c) && !Character.isDigit(c) && !Character.isWhitespace(c) && c != '\b') {

            evt.consume();
        }    }//GEN-LAST:event_jDateChooser1KeyTyped

    /**
 * Maneja eventos de teclado para el componente de selección de fecha jDateChooser2.
 * Solo se permiten caracteres válidos en este campo (letras, dígitos y espacios en blanco).
 */
    private void jDateChooser2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateChooser2KeyTyped
        char c = evt.getKeyChar();

        if (!Character.isLetter(c) && !Character.isDigit(c) && !Character.isWhitespace(c) && c != '\b') {
            evt.consume();
        }    }//GEN-LAST:event_jDateChooser2KeyTyped

    private void imprimirPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirPDFActionPerformed
    Date fechaInicio = jDateChooser1.getDate();
        Date fechaFin = jDateChooser2.getDate();
        boolean ingresos = chbxIngresos.isSelected();
        boolean egresos = chbxEgresos.isSelected();

        try {
            ByteArrayOutputStream baos = impPDF.imprimirPDF(tarjetaDTO, fechaInicio, fechaFin, ingresos, egresos);

            if (baos != null) {
                String userHome = System.getProperty("user.home");
                String desktopPath = userHome + "/Desktop/Movimientos.pdf";

                try (FileOutputStream fos = new FileOutputStream(desktopPath)) {
                    baos.writeTo(fos);
                }

                JOptionPane.showMessageDialog(this, "PDF generado exitosamente en el escritorio", "Éxito", JOptionPane.INFORMATION_MESSAGE);

                
                File pdfFile = new File(desktopPath);
                if (pdfFile.exists()) {
                    if (Desktop.isDesktopSupported()) {
                        Desktop.getDesktop().open(pdfFile);
                    } else {
                        JOptionPane.showMessageDialog(this, "La funcionalidad de abrir archivos no está soportada en este sistema", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "El archivo PDF no existe", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "No se pudieron obtener las transferencias para generar el PDF", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al generar el PDF", "Error", JOptionPane.ERROR_MESSAGE);
        }
    

    }//GEN-LAST:event_imprimirPDFActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Movimientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Movimientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Movimientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Movimientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Movimientos().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JCheckBox chbxEgresos;
    private javax.swing.JCheckBox chbxIngresos;
    private javax.swing.JButton imprimirPDF;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblBanco;
    private javax.swing.JLabel lblCuenta;
    private javax.swing.JLabel lblNombre;
    // End of variables declaration//GEN-END:variables
}
