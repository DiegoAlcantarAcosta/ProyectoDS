/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import DTOs.ContactoDTO;
import DTOs.PersonaDTO;
import DTOs.TarjetaDTO;
import Excepciones.PersistenciaException;
import Funcionalidad.EliminarTarjetaSS;
import Funcionalidad.IEliminarTarjetaSS;
import Funcionalidad.IMostrarTarjetasSS;
import Funcionalidad.ITarjetaSS;
import Funcionalidad.MostrarContactoSS;
import Funcionalidad.MostrarTarjetasSS;
import Funcionalidad.TarjetaSS;
import entidades.Contacto;
import java.awt.HeadlessException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class OpcionesTarjeta extends javax.swing.JFrame {

    private IMostrarTarjetasSS mostrarTarjetasSS;
    private ITarjetaSS tarjetaSS;
    TarjetaDTO tarjeDesti;
    PersonaDTO personaDTO;
    IEliminarTarjetaSS eliminarTarjetaSS;
    TarjetaDTO tarjetaDTO;

    /**
     * Creates new form FrmSeleccionarContacto
     */
    public OpcionesTarjeta(PersonaDTO persona, TarjetaDTO tarjetaDTO) {
        initComponents();
        personaDTO = persona;
        mostrarTarjetasSS = new MostrarTarjetasSS();
        eliminarTarjetaSS = new EliminarTarjetaSS();
        tarjetaSS = new TarjetaSS();
        this.tarjetaDTO = tarjetaDTO;

        this.llenarTablaTarjetas();
    }

    private void llenarTablaTarjetas() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Numero");
        modelo.addColumn("Tipo");
        modelo.addColumn("Banco");
        modelo.addColumn("Saldo");
        modelo.addColumn("Vencimiento");

        SimpleDateFormat formatoSalida = new SimpleDateFormat("dd/MM/yyyy");

        try {
            List<TarjetaDTO> listaTarjetas = mostrarTarjetasSS.obtenerTarjetasDTOPersona(personaDTO);

            if (listaTarjetas.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No se encontraron resultados", "AVISO", JOptionPane.WARNING_MESSAGE);
                dispose();
            }
            for (int i = 0; i < listaTarjetas.size(); i++) {
                String[] datos = new String[5];
                datos[0] = listaTarjetas.get(i).getNumeroCuenta();
                datos[1] = listaTarjetas.get(i).getTipo().toString();
                datos[2] = listaTarjetas.get(i).getBanco().toString();
                datos[3] = "" + listaTarjetas.get(i).getSaldo();
                String fechaPrint = formatoSalida.format(listaTarjetas.get(i).getFechaVencimiento().getTime());
                datos[4] = fechaPrint;

                modelo.addRow(datos);
            }
            tablaTarjetas.setModel(modelo);
        } catch (HeadlessException e) {
            throw e;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblContactos = new javax.swing.JLabel();
        cancelarButton = new javax.swing.JButton();
        actualizarButton = new javax.swing.JButton();
        eliminarButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaTarjetas = new javax.swing.JTable();
        añadirButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestion de Tarjetas");

        jPanel1.setBackground(new java.awt.Color(102, 0, 0));
        jPanel1.setForeground(new java.awt.Color(153, 0, 0));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tarjetas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(289, 289, 289)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
        );

        lblContactos.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblContactos.setText("Tarjetas:");

        cancelarButton.setText("Cancelar");
        cancelarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarButtonActionPerformed(evt);
            }
        });

        actualizarButton.setText("Actualizar");
        actualizarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarButtonActionPerformed(evt);
            }
        });

        eliminarButton.setText("Eliminar");
        eliminarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarButtonActionPerformed(evt);
            }
        });

        tablaTarjetas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Numero", "Tipo", "Banco", "Saldo", "Vencimiento"
            }
        ));
        tablaTarjetas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaTarjetasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaTarjetas);

        añadirButton1.setText("Añadir");
        añadirButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añadirButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblContactos)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cancelarButton)
                                .addGap(108, 108, 108)
                                .addComponent(añadirButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(actualizarButton)
                                .addGap(71, 71, 71)
                                .addComponent(eliminarButton))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblContactos, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelarButton)
                    .addComponent(actualizarButton)
                    .addComponent(eliminarButton)
                    .addComponent(añadirButton1))
                .addGap(23, 23, 23))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarButtonActionPerformed
        MenuPrincipal a = new MenuPrincipal(personaDTO, tarjetaDTO);
        a.show();
        dispose();
    }//GEN-LAST:event_cancelarButtonActionPerformed

    private void actualizarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarButtonActionPerformed
        int selectedRow = tablaTarjetas.getSelectedRow();
        if (selectedRow != -1) {
            String numero = (String) tablaTarjetas.getValueAt(selectedRow, 0);
            TarjetaDTO tarjetaBuscada = tarjetaSS.obtenerTarjetaDTOPorNumero(new TarjetaDTO(numero));
            tarjeDesti = tarjetaSS.obtenerTarjetaDTOPorNumero(new TarjetaDTO(tarjetaBuscada.getNumeroCuenta()));
            ActualizarTarjeta a = new ActualizarTarjeta(personaDTO, tarjeDesti);
            a.show();
            dispose();
        } else {
            JOptionPane.showConfirmDialog(null, "Seleccione una tarjeta");
        }
    }//GEN-LAST:event_actualizarButtonActionPerformed

    private void eliminarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarButtonActionPerformed
        try {
            int selectedRow = tablaTarjetas.getSelectedRow();
            int countRows = tablaTarjetas.getRowCount();

            if (selectedRow != -1) {
                String numero = (String) tablaTarjetas.getValueAt(selectedRow, 0);
                TarjetaDTO tarjetaBuscada = tarjetaSS.obtenerTarjetaDTOPorNumero(new TarjetaDTO(numero));
                if (countRows - 1 != 0) {
                    eliminarTarjetaSS.eliminar(personaDTO, tarjetaBuscada);
                    this.llenarTablaTarjetas();
                    tarjeDesti = tarjetaSS.obtenerTarjetasDTOPersona(personaDTO).getLast();
                    JOptionPane.showMessageDialog(this, "Tarjeta eliminada con exito", "AVISO", JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "No puedes dejar la cuenta sin tarjetas", "AVISO", JOptionPane.WARNING_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(this, "No se pudo eliminar la tarjeta", "AVISO", JOptionPane.WARNING_MESSAGE);
            }
        } catch (PersistenciaException e) {
            System.out.println("Error: " + e);
        }


    }//GEN-LAST:event_eliminarButtonActionPerformed

    private void tablaTarjetasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaTarjetasMouseClicked

    }//GEN-LAST:event_tablaTarjetasMouseClicked

    private void añadirButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añadirButton1ActionPerformed
        AñadirTarjeta a = new AñadirTarjeta(personaDTO, tarjeDesti);
        a.show();
        dispose();
    }//GEN-LAST:event_añadirButton1ActionPerformed

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
//            java.util.logging.Logger.getLogger(FrmSeleccionarContacto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FrmSeleccionarContacto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FrmSeleccionarContacto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FrmSeleccionarContacto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new FrmSeleccionarContacto().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizarButton;
    private javax.swing.JButton añadirButton1;
    private javax.swing.JButton cancelarButton;
    private javax.swing.JButton eliminarButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblContactos;
    private javax.swing.JTable tablaTarjetas;
    // End of variables declaration//GEN-END:variables
}
