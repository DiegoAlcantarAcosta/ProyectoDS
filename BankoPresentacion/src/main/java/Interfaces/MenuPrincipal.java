/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import DTOs.PersonaDTO;
import DTOs.TarjetaDTO;
import Funcionalidad.IMovimientosTransferenciasSS;
import Funcionalidad.ITarjetaSS;
import Funcionalidad.MovimientosTransferenciasSS;
import Funcionalidad.TarjetaSS;
import Funucionalidad.IPersonaSS;
import Funucionalidad.PersonaSS;
import java.awt.Image;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

/**
 *
 * @author Diego
 */
public class MenuPrincipal extends javax.swing.JFrame {

  IPersonaSS personaSS;
    ITarjetaSS tarjetaSS;
    PersonaDTO personaDTO;
    TarjetaDTO tarjetaDTO;
    IMovimientosTransferenciasSS movimientosTransferenciasSS;
    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal(PersonaDTO persona , TarjetaDTO tarjeta) {
        initComponents();
        movimientosTransferenciasSS = new MovimientosTransferenciasSS();
        personaSS = new PersonaSS();
        tarjetaSS = new TarjetaSS();
        personaDTO = persona;

        cargarBox(numeroCuentaComboBox, tarjeta);
//        TarjetaDTO t = new TarjetaDTO(numeroCuentaComboBox.getSelectedItem().toString());
        
        tarjetaDTO = tarjeta;

       
      IngresosTexxField.setText(movimientosTransferenciasSS.ingresosDelDia(tarjetaDTO).toString());
      GastosTexxField.setText(movimientosTransferenciasSS.egresosDelDia(tarjetaDTO).toString());
    }
    
//    public Icon setIcono(String url, JButton boton){
//        ImageIcon icon = new ImageIcon(getClass().getResource(url));
//        int ancho = boton.getWidth();
//        int alto = boton.getHeight() ;
//        
//        ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
//        
//        return icono;
//        
//    }
//    
//    public Icon setIconoPrecionado(String url, JButton boton, int alto, int ancho){
//        ImageIcon icon = new ImageIcon(getClass().getResource(url));
//        int width = boton.getWidth() - ancho;
//        int height = boton.getHeight() - alto;
//        
//        ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
//        
//        return icono;
//        
//    }

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
        SaldoDisponibleTexxField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        IngresosTexxField = new javax.swing.JTextField();
        GastosTexxField = new javax.swing.JTextField();
        perfilButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        nombreTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        movimientosButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnMisContactos = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        crearGrupoButton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        añadirTarjetaButton = new javax.swing.JButton();
        transferirButton = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        tarjetasTextField = new javax.swing.JTextField();
        numeroCuentaComboBox = new javax.swing.JComboBox<>();
        cerrarSesionButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Principal");
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(102, 0, 0));
        jPanel1.setForeground(new java.awt.Color(153, 0, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("BAN-KO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(244, 244, 244))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );

        jLabel2.setText("Saldo disponible:");

        SaldoDisponibleTexxField.setEditable(false);
        SaldoDisponibleTexxField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaldoDisponibleTexxFieldActionPerformed(evt);
            }
        });

        jLabel4.setText("Ingresos:");

        jLabel5.setText("Gastos:");

        IngresosTexxField.setEditable(false);
        IngresosTexxField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IngresosTexxFieldActionPerformed(evt);
            }
        });

        GastosTexxField.setEditable(false);
        GastosTexxField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GastosTexxFieldActionPerformed(evt);
            }
        });

        perfilButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perfilButtonActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 102, 153));

        nombreTextField.setEditable(false);
        nombreTextField.setBackground(new java.awt.Color(0, 102, 153));
        nombreTextField.setBorder(null);
        nombreTextField.setCaretColor(new java.awt.Color(0, 102, 153));
        nombreTextField.setDisabledTextColor(new java.awt.Color(0, 102, 153));
        nombreTextField.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        nombreTextField.setSelectionColor(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nombreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(166, 166, 166))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nombreTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        jLabel3.setText("Perfil");

        movimientosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                movimientosButtonActionPerformed(evt);
            }
        });

        jLabel6.setText("Movimientos");

        btnMisContactos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMisContactos.setMaximumSize(new java.awt.Dimension(56, 57));
        btnMisContactos.setMinimumSize(new java.awt.Dimension(56, 57));
        btnMisContactos.setPreferredSize(new java.awt.Dimension(56, 57));
        btnMisContactos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMisContactosActionPerformed(evt);
            }
        });

        jLabel7.setText("Mis Contactos");

        crearGrupoButton.setMaximumSize(new java.awt.Dimension(56, 57));
        crearGrupoButton.setMinimumSize(new java.awt.Dimension(56, 57));
        crearGrupoButton.setPreferredSize(new java.awt.Dimension(56, 57));
        crearGrupoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearGrupoButtonActionPerformed(evt);
            }
        });

        jLabel8.setText("Crear Grupo");

        añadirTarjetaButton.setMaximumSize(new java.awt.Dimension(56, 57));
        añadirTarjetaButton.setMinimumSize(new java.awt.Dimension(56, 57));
        añadirTarjetaButton.setPreferredSize(new java.awt.Dimension(56, 57));
        añadirTarjetaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añadirTarjetaButtonActionPerformed(evt);
            }
        });

        transferirButton.setMaximumSize(new java.awt.Dimension(56, 57));
        transferirButton.setMinimumSize(new java.awt.Dimension(56, 57));
        transferirButton.setPreferredSize(new java.awt.Dimension(56, 57));
        transferirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transferirButtonActionPerformed(evt);
            }
        });

        jLabel9.setText("Gestion Tarjetas");

        jLabel10.setText("Transferir");

        jPanel3.setBackground(new java.awt.Color(0, 102, 153));

        tarjetasTextField.setEditable(false);
        tarjetasTextField.setBackground(new java.awt.Color(0, 102, 153));
        tarjetasTextField.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        tarjetasTextField.setText("Tarjetas");
        tarjetasTextField.setBorder(null);
        tarjetasTextField.setCaretColor(new java.awt.Color(0, 102, 153));
        tarjetasTextField.setDisabledTextColor(new java.awt.Color(0, 102, 153));
        tarjetasTextField.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        tarjetasTextField.setSelectionColor(new java.awt.Color(0, 0, 0));
        tarjetasTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tarjetasTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tarjetasTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(260, 260, 260))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tarjetasTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
        );

        numeroCuentaComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numeroCuentaComboBoxActionPerformed(evt);
            }
        });

        cerrarSesionButton.setText("Cerrar Sesion");
        cerrarSesionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarSesionButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(SaldoDisponibleTexxField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(IngresosTexxField, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                    .addComponent(GastosTexxField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(perfilButton, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(41, 41, 41))))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(movimientosButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMisContactos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(crearGrupoButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(añadirTarjetaButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(transferirButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(67, 67, 67))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(296, 296, 296)
                .addComponent(cerrarSesionButton)
                .addGap(0, 245, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(numeroCuentaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(189, 189, 189))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SaldoDisponibleTexxField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(IngresosTexxField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(GastosTexxField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(perfilButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)))))
                .addGap(17, 17, 17)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(crearGrupoButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(añadirTarjetaButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(transferirButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(movimientosButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMisContactos, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(31, 31, 31)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(numeroCuentaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(cerrarSesionButton)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

     public void cargarBox(JComboBox<String> cB, TarjetaDTO tarjetaDTO) {
    DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>();
    cB.setModel(modelo);
    PersonaDTO personita = personaSS.obtenerPersonaDTOPorCurp(personaDTO);
    List<TarjetaDTO> lista = tarjetaSS.obtenerTarjetasDTOPersona(personita);
    
    for (int i = 0; i < lista.size(); i++) {
        modelo.addElement(lista.get(i).getNumeroCuenta());
    }
    modelo.setSelectedItem(tarjetaDTO.getNumeroCuenta());
}
    
    
    private void SaldoDisponibleTexxFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaldoDisponibleTexxFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SaldoDisponibleTexxFieldActionPerformed

    private void IngresosTexxFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IngresosTexxFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IngresosTexxFieldActionPerformed

    private void GastosTexxFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GastosTexxFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GastosTexxFieldActionPerformed

    private void tarjetasTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tarjetasTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tarjetasTextFieldActionPerformed

    private void transferirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transferirButtonActionPerformed
       
        FrmSeleccionarContacto contacto = new FrmSeleccionarContacto(tarjetaDTO);
        contacto.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_transferirButtonActionPerformed

    private void cerrarSesionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarSesionButtonActionPerformed
       InicioSesionForm i = new InicioSesionForm();
       i.setVisible(true);
       dispose();
    }//GEN-LAST:event_cerrarSesionButtonActionPerformed

    private void numeroCuentaComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numeroCuentaComboBoxActionPerformed
        // TODO add your handling code here:
        String numC = numeroCuentaComboBox.getSelectedItem().toString();
        
        tarjetaDTO = tarjetaSS.obtenerTarjetaDTOPorNumero(new TarjetaDTO(numC));
//        Tarjeta tarjeta = tarjetas.obtenerTarjetaPorNumero(new Tarjeta(numC));
        SaldoDisponibleTexxField.setText(tarjetaDTO.getSaldo().toString());
        IngresosTexxField.setText(movimientosTransferenciasSS.ingresosDelDia(tarjetaDTO).toString());
        GastosTexxField.setText(movimientosTransferenciasSS.egresosDelDia(tarjetaDTO).toString());
        
        
    }//GEN-LAST:event_numeroCuentaComboBoxActionPerformed

    private void btnMisContactosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMisContactosActionPerformed
        // TODO add your handling code here:
        FrmMisContactos mc = new FrmMisContactos(personaDTO, tarjetaDTO);
        mc.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnMisContactosActionPerformed

    private void crearGrupoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearGrupoButtonActionPerformed
    FrmCrearGrupo menuPrincipal = new FrmCrearGrupo(personaDTO);

    menuPrincipal.setVisible(true);

    this.setVisible(false);
    }//GEN-LAST:event_crearGrupoButtonActionPerformed

    private void movimientosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_movimientosButtonActionPerformed
        String numC = numeroCuentaComboBox.getSelectedItem().toString();
        tarjetaDTO = tarjetaSS.obtenerTarjetaDTOPorNumero(new TarjetaDTO(numC));

        FrmMovimientos mv = new FrmMovimientos(tarjetaDTO);
        mv.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_movimientosButtonActionPerformed

    private void añadirTarjetaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añadirTarjetaButtonActionPerformed
        ContraseñaTarjetas a = new ContraseñaTarjetas(personaDTO, tarjetaDTO);
        a.show();
        dispose();
    }//GEN-LAST:event_añadirTarjetaButtonActionPerformed

    private void perfilButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perfilButtonActionPerformed
       FrmPerfil a = new FrmPerfil(personaDTO, tarjetaDTO);
       a.show();
       dispose();
    }//GEN-LAST:event_perfilButtonActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField GastosTexxField;
    private javax.swing.JTextField IngresosTexxField;
    private javax.swing.JTextField SaldoDisponibleTexxField;
    private javax.swing.JButton añadirTarjetaButton;
    private javax.swing.JButton btnMisContactos;
    private javax.swing.JButton cerrarSesionButton;
    private javax.swing.JButton crearGrupoButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton movimientosButton;
    private javax.swing.JTextField nombreTextField;
    private javax.swing.JComboBox<String> numeroCuentaComboBox;
    private javax.swing.JButton perfilButton;
    private javax.swing.JTextField tarjetasTextField;
    private javax.swing.JButton transferirButton;
    // End of variables declaration//GEN-END:variables
}
