/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;
import DTOs.ContactoDTO;
import DTOs.GrupoDTO;
import DTOs.PersonaDTO;
import Funcionalidad.ActualizarContactoSS;
//import Funcionalidad.AgregarContactos;
import Funcionalidad.GrupoSS;
//import Funcionalidad.IAgregarContactos;
import Funcionalidad.IGrupoSS;
import Funcionalidad.IMostrarContactoSS;
import Funcionalidad.MostrarContactoSS;
import Interfaces.MenuPrincipal;
import entidades.SolicitudInvitacion;
//import funcionalidad.IEnviarSolicitudSS;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.bson.types.ObjectId;
/**
 *
 * @author Oley
 */
public class FrmInformacionGrupo2 extends javax.swing.JFrame {
private List<Object[]> rowData;
     IGrupoSS grupoSS;
//    IAgregarContactos agregarContactoSS;
        IMostrarContactoSS mostrarContactoSS;
//        private IEnviarSolicitudSS enviarSolicitudSS;
        PersonaDTO personaDTO;
    /**
     * Creates new form FrmInformacionGrupo2
     */
//    public FrmInformacionGrupo2(IGrupoSS grupoSS, IAgregarContactos agregarContactoSS,List<Object[]> rowData) {
//        initComponents();
//        this.grupoSS=new GrupoSS();
////      this.agregarContactoSS=new AgregarContactos();
//        mostrarContactoSS = new MostrarContactoSS();
////        this.enviarSolicitudSS = enviarSolicitudSS;
//         this.rowData = rowData; 
//               llenarTablaContactos(rowData);
//    }
private void llenarTablaContactos(List<Object[]> rowData) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        for (Object[] row : rowData) {
            model.addRow(row);
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

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Motivo = new javax.swing.JTextField();
        Total = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("jButton1");

        jButton2.setText("jButton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Motivo");

        jLabel2.setText("Total");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(50, 50, 50))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Total, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                    .addComponent(Motivo))
                .addGap(109, 109, 109))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Motivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
String motivo = Motivo.getText();
    String totalStr = Total.getText();
    
    // Validar que se hayan ingresado valores para el motivo y el total
    if (motivo.isEmpty() || totalStr.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor ingresa un motivo y un total.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    try {
        // Convertir el total a un número decimal
        double total = Double.parseDouble(totalStr);
        
        // Crear un grupo con el motivo y el total
        GrupoDTO grupoDTO = new GrupoDTO();
        grupoDTO.setMotivo(motivo);
        grupoDTO.setSaldo(total); // Establecer el saldo como el monto total
        
        // Llamar al método para crear el grupo y obtener su ID
        ObjectId grupoId = grupoSS.crearGrupo(grupoDTO);
        
        // Verificar si se creó el grupo correctamente
        if (grupoId != null) {
            // Recorrer los datos de la tabla y enviar las solicitudes de invitación a los contactos presentes en la tabla
            for (Object[] row : rowData) {
                // Verificar que rowData tenga al menos dos elementos antes de intentar acceder al índice 1
                if (row.length >= 2) {
                    String userId = (String) row[1]; // Obtener el ID del usuario de la tabla
                    String alias = (String) row[0]; // Obtener el alias del contacto
                    
                    // Crear y enviar la solicitud de invitación para este contacto
                    SolicitudInvitacion solicitud = new SolicitudInvitacion(grupoId, "Mensaje de invitación para " + alias, total,""); // Establecer el monto en la solicitud
//                    boolean enviado = enviarSolicitudSS.enviarSolicitud(solicitud);
                    
                    // Si la solicitud se envió correctamente, puedes realizar alguna acción (por ejemplo, mostrar un mensaje)
//                    if (enviado) {
//                        System.out.println("Solicitud de invitación enviada a " + alias);
//                    }
                } else {
                    // Indicar que rowData no tiene suficientes elementos
                    System.err.println("rowData no tiene suficientes elementos.");
                }
            }
            
            // Mostrar un mensaje de éxito
            JOptionPane.showMessageDialog(this, "Grupo creado y solicitudes de invitación enviadas correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Error al crear el grupo. Por favor intenta de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (NumberFormatException e) {
        // Manejar la excepción si el usuario ingresa un valor no válido para el total
        JOptionPane.showMessageDialog(this, "El total ingresado no es válido. Por favor ingresa un número decimal.", "Error", JOptionPane.ERROR_MESSAGE);
    }



    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
   
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Motivo;
    private javax.swing.JTextField Total;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
