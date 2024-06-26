/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import DTOs.ContactoDTO;
import DTOs.PersonaDTO;
import DTOs.TarjetaDTO;
import DTOs.tipoBancoDTO;
import Funcionalidad.ActualizarContactoSS;
import Funcionalidad.EliminarContactoSS;
import Funcionalidad.IEliminarContactoSS;
import Funcionalidad.IActualizarContactoSS;
import Funcionalidad.IEliminarContactoSS;
//import Funcionalidad.ActualizarContactoSS;
import Funcionalidad.IEliminarTarjetaSS;
import Funcionalidad.IActualizarTarjetaSS;
import Funcionalidad.IEliminarTarjetaSS;
import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public class FrmEditaMiContacto extends javax.swing.JFrame {

    PersonaDTO personaDTO;
    ContactoDTO contactoOrigiDTO;
    IActualizarContactoSS actualiza;
    IEliminarContactoSS elimina;
    TarjetaDTO tarjetaDTO;

    /**
     * Creates new form FrmEditaMiContacto
     */
    public FrmEditaMiContacto(PersonaDTO personaDTO, ContactoDTO contactoDTO, TarjetaDTO tarjetaDTO) {
        initComponents();
        this.actualiza = new ActualizarContactoSS();
        this.elimina = new EliminarContactoSS();
        this.personaDTO = personaDTO;
        this.contactoOrigiDTO = contactoDTO;
        this.tarjetaDTO = tarjetaDTO;

        this.txtAlias.setText(contactoDTO.getAlias());
        this.txtNombre.setText(contactoDTO.getNombre());
        this.txtNumCuenta.setText(contactoDTO.getNumeroCuenta());
        this.txtAP.setText(contactoDTO.getApellidoP());
        this.txtAM.setText(contactoDTO.getApellidoM());
        for (tipoBancoDTO value : tipoBancoDTO.values()) {
            comboBanco.addItem(value);
        }
        comboBanco.setSelectedItem(contactoDTO.getBanco());

    }

    public boolean validarNumeroCuenta(String numeroCuenta) {
        // Expresión regular para validar que el número de cuenta tenga exactamente 9 dígitos
        String regex = "\\d{10}";
        return numeroCuenta.matches(regex);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnEditar = new javax.swing.JButton();
        txtAlias = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNumCuenta = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtAP = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtAM = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        comboBanco = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Edita un Contacto");

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(102, 0, 0));
        jPanel1.setForeground(new java.awt.Color(153, 0, 0));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Editar Contacto");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
        );

        txtNumCuenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNumCuentaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumCuentaKeyTyped(evt);
            }
        });

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        jLabel1.setText("Alias: ");

        txtAP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAPKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAPKeyTyped(evt);
            }
        });

        jLabel3.setText("Nombre: ");

        txtAM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAMKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAMKeyTyped(evt);
            }
        });

        jLabel4.setText("Apellido paterno: ");

        jLabel5.setText("Apellido materno: ");

        jLabel6.setText("Número de cuenta:");

        jLabel7.setText("Banco:");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar Contacto");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNumCuenta)
                        .addGap(59, 59, 59))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtAlias, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtAM)
                                        .addComponent(txtAP))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(130, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(btnCancelar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminar)
                        .addGap(56, 56, 56)
                        .addComponent(btnEditar)
                        .addGap(21, 21, 21))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtAlias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtNumCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(comboBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtAP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnEditar)
                    .addComponent(btnEliminar))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
//         TODO add your handling code here:
        if (this.validarNumeroCuenta(txtNumCuenta.getText())) {
            String[] botones = {"Si", "Cancelar", "No"};
            int i = JOptionPane.showOptionDialog(this, "¿Seguro que quieres editar este contacto? \nAlias:" + txtAlias.getText(), "Confirmacion",
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, botones, botones[0]);

            if (i == 0) {
                tipoBancoDTO tipoBanco = (tipoBancoDTO) comboBanco.getSelectedItem();
                ContactoDTO contactoDTO = new ContactoDTO(txtAlias.getText(), txtNombre.getText(), txtAP.getText(), txtAM.getText(),
                        txtNumCuenta.getText(), (tipoBancoDTO) tipoBanco);
                Boolean verifica = actualiza.actualizar(personaDTO, contactoOrigiDTO, contactoDTO);
                if (verifica == true) {
                    JOptionPane.showMessageDialog(this, "Contacto Editado", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                    FrmMisContactos mc = new FrmMisContactos(personaDTO, tarjetaDTO);
                    mc.show();
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Algo fallo!!! \nIntentalo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } else if (i == 1) {
                FrmMisContactos mc = new FrmMisContactos(personaDTO, tarjetaDTO);
                mc.show();
                this.dispose();
            } else if (i == 2) {
                JOptionPane.showMessageDialog(this, "Muy bien, termina de editar tu contacto:) ", "Continua Editando", JOptionPane.INFORMATION_MESSAGE);

            }

        }
        else{
            JOptionPane.showMessageDialog(this, "Número de cuenta no valido:\nEl número de cuenta tiene que ser de 10 digitos.",
                    "Advertencia", JOptionPane.WARNING_MESSAGE
                    );
        }


    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        FrmMisContactos mc = new FrmMisContactos(personaDTO, tarjetaDTO);
        mc.show();
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        String[] botones = {"Si", "Cancelar", "No"};
        int i = JOptionPane.showOptionDialog(this, "¿Seguro que quieres eliminar este contacto? \n Aunque hayas editado algún campo, si no confirmaste la edición se borrara el siguiente contacto:\n"
                + "Alias:" + contactoOrigiDTO.getAlias(), "Confirmacion",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, botones, botones[0]);

        if (i == 0) {
            Boolean verifica = elimina.eliminar(personaDTO, contactoOrigiDTO);
            if (verifica == true) {
                JOptionPane.showMessageDialog(this, "Contacto Eliminado", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                FrmMisContactos mc = new FrmMisContactos(personaDTO, tarjetaDTO);
                mc.show();
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Algo fallo!!! \nIntentalo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } else if (i == 1) {
            FrmMisContactos mc = new FrmMisContactos(personaDTO, tarjetaDTO);
            mc.show();
            this.dispose();
        } else if (i == 2) {
            JOptionPane.showMessageDialog(this, "Muy bien, termina de editar tu contacto:) ", "Continua Editando", JOptionPane.INFORMATION_MESSAGE);

        }

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtNumCuentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumCuentaKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtNumCuentaKeyPressed

    private void txtNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreKeyPressed

    private void txtAPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAPKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtAPKeyPressed

    private void txtAMKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAMKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtAMKeyPressed

    private void txtNumCuentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumCuentaKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();

        if (c < '0' || c > '9') {
            evt.consume();
        }
        {

        }

        String textoActual = txtNumCuenta.getText();

        if (textoActual.length() + 1 > 10) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNumCuentaKeyTyped

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();

        if (!Character.isLetter(c) && !Character.isWhitespace(c) && c != '\b') {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtAPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAPKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();

        if (!Character.isLetter(c) && !Character.isWhitespace(c) && c != '\b') {
            evt.consume();
        }
    }//GEN-LAST:event_txtAPKeyTyped

    private void txtAMKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAMKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();

        if (!Character.isLetter(c) && !Character.isWhitespace(c) && c != '\b') {
            evt.consume();
        }
    }//GEN-LAST:event_txtAMKeyTyped

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
//            java.util.logging.Logger.getLogger(FrmEditaMiContacto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FrmEditaMiContacto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FrmEditaMiContacto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FrmEditaMiContacto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new FrmEditaMiContacto().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JComboBox<tipoBancoDTO> comboBanco;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtAM;
    private javax.swing.JTextField txtAP;
    private javax.swing.JTextField txtAlias;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumCuenta;
    // End of variables declaration//GEN-END:variables
}
