/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import DTOs.PersonaDTO;
import DTOs.TarjetaDTO;
import DTOs.tipoBancoDTO;
import DTOs.tipoTarjetaDTO;
import Funcionalidad.ActualizarTarjetaSS;
import Funcionalidad.AnadirTarjetaSS;
import Funcionalidad.TarjetaSS;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import org.bson.types.ObjectId;

/**
 *
 * @author Diego
 */
public class ActualizarTarjeta extends javax.swing.JFrame {

    PersonaDTO persona;
    TarjetaDTO tarjeta;
    ActualizarTarjetaSS tarjetaSS;
    TarjetaSS tarjetaSS2;
    List<TarjetaDTO> tarjetasClientes;

    /**
     * Creates new form MenuPrincipal
     */
    public ActualizarTarjeta(PersonaDTO personaDTO, TarjetaDTO tarjetaDTO) {
        initComponents();
        persona = personaDTO;
        tarjeta = tarjetaDTO;
        tarjetaSS = new ActualizarTarjetaSS();
        numTarjetaTextField.setText(tarjetaDTO.getNumeroCuenta());
     
        for (tipoTarjetaDTO value : tipoTarjetaDTO.values()) {
            tipoTarjetaComboBox.addItem(value);
        }

        for (tipoBancoDTO value : tipoBancoDTO.values()) {
            bancoComboBox.addItem(value);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        numTarjetaTextField = new javax.swing.JTextField();
        tipoTarjetaComboBox = new javax.swing.JComboBox<>();
        bancoComboBox = new javax.swing.JComboBox<>();
        fechaVencimientoJDateChooser = new com.toedter.calendar.JDateChooser();
        AceptarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(102, 0, 0));
        jPanel1.setForeground(new java.awt.Color(153, 0, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Añadir Tarjeta");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(139, 139, 139))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel2.setText("Numero de tarjeta:");

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        jLabel3.setText("Tipo de tarjeta:");

        jLabel4.setText("Banco:");

        jLabel5.setText("Fecha Venciemiento:");

        numTarjetaTextField.setEditable(false);

        tipoTarjetaComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoTarjetaComboBoxActionPerformed(evt);
            }
        });

        AceptarButton.setText("Aceptar");
        AceptarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AceptarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(18, 18, 18)
                            .addComponent(bancoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(11, 11, 11))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(numTarjetaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tipoTarjetaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(10, 10, 10)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(fechaVencimientoJDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)))
                .addContainerGap(54, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(AceptarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(numTarjetaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tipoTarjetaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(bancoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(fechaVencimientoJDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AceptarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents




    public static boolean esFechaVencimientoValida(Date fechaVencimiento) {
        // Obtener la fecha actual
        Date fechaActual = new Date();

        // Comparar la fecha de vencimiento con la fecha actual
        return fechaVencimiento == null || !fechaVencimiento.before(fechaActual);
    }

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        OpcionesTarjeta a = new OpcionesTarjeta(persona);
        a.show();
        dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void tipoTarjetaComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoTarjetaComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipoTarjetaComboBoxActionPerformed

    private void AceptarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarButtonActionPerformed
        try {
            if (fechaVencimientoJDateChooser.getDate() != null) {
                        if (esFechaVencimientoValida(fechaVencimientoJDateChooser.getDate())) {
                            tipoTarjetaDTO tipoTarjeta = (tipoTarjetaDTO) tipoTarjetaComboBox.getSelectedItem();
                            tipoBancoDTO tipoBanco = (tipoBancoDTO) bancoComboBox.getSelectedItem();
                            TarjetaDTO tarjetaDTO = new TarjetaDTO(tarjeta.getId(), tarjeta.getNumeroCuenta(), tipoTarjeta, tipoBanco, tarjeta.getSaldo(), fechaVencimientoJDateChooser.getDate());
                            tarjetaSS.actualizar(persona, tarjetaDTO);
                            OpcionesTarjeta a = new OpcionesTarjeta(persona);
                            a.show();
                            this.dispose(); // Cierra el formulario actual
                        } else {
                            JOptionPane.showMessageDialog(this, "No se puede poner una fecha caducada", "AVISO", JOptionPane.WARNING_MESSAGE);
                        }
            } else {
                JOptionPane.showMessageDialog(this, "No deje espacios en blanco", "AVISO", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
            JOptionPane.showMessageDialog(this, "No se pudo actualizar la tarjeta", "AVISO", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_AceptarButtonActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AceptarButton;
    private javax.swing.JComboBox<tipoBancoDTO> bancoComboBox;
    private javax.swing.JButton btnRegresar;
    private com.toedter.calendar.JDateChooser fechaVencimientoJDateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField numTarjetaTextField;
    private javax.swing.JComboBox<tipoTarjetaDTO> tipoTarjetaComboBox;
    // End of variables declaration//GEN-END:variables
}