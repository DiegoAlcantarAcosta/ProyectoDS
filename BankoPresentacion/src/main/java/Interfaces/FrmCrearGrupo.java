/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import DTOs.ContactoDTO;
import DTOs.PersonaDTO;
import DTOs.TarjetaDTO;
//import Funcionalidad.IAgregarContactos;
import Funcionalidad.IGrupoSS;
//import Funcionalidad.IAgregarContactoSS;
//import Funcionalidad.IGrupoSS;
import Funcionalidad.IMostrarContactoSS;
import Funcionalidad.MostrarContactoSS;
import Objetos.ObjetoNegocioGrupo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Oley
 */
public class FrmCrearGrupo extends javax.swing.JFrame {
ObjetoNegocioGrupo objetoNegocioGrupo;
PersonaDTO personaDTO;
//    IAgregarContactos agregarContactos;
     IGrupoSS grupoSS;
    IMostrarContactoSS mostrarContactoSS;
    List<Object[]> rowData;
        TarjetaDTO tarjetaDTO;

    /**
     * Creates new form FrmCrearGrupo
     */
    public FrmCrearGrupo(PersonaDTO personaDTO) {
        initComponents();
        this.personaDTO = new PersonaDTO();
        
        // Inicializar objetoNegocioGrupo
        this.objetoNegocioGrupo = new ObjetoNegocioGrupo();

        // Inicializar mostrarContactoSS
        mostrarContactoSS = new MostrarContactoSS();

        // Obtener lista de contactos y llenar la tabla
        List<ContactoDTO> listaContactos = mostrarContactoSS.obtenerContactosDTOPersona(personaDTO);
        llenarTablaContactos(listaContactos);
        tableContactos.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

    }
 private void llenarTablaContactos(List<ContactoDTO> contactos) {
        DefaultTableModel model = (DefaultTableModel) tableContactos.getModel();
        model.setRowCount(0);

        for (ContactoDTO contacto : contactos) {
            Object[] row = {
                contacto.getAlias(),contacto.getApellidoP(),contacto.getApellidoM(),contacto.getBanco()
            };
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tableContactos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tableContactos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tableContactos);

        jButton1.setText("Regresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Continuar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      // Obtener los índices de las filas seleccionadas
        int[] selectedRows = tableContactos.getSelectedRows();
        if (selectedRows.length > 0) {
            List<Object[]> rowData = new ArrayList<>();
            for (int rowIndex : selectedRows) {
                Object[] row = new Object[1]; // Una fila con una sola columna (alias)
                row[0] = tableContactos.getValueAt(rowIndex, 0); // Obtener el alias
                rowData.add(row); // Agregar la fila a la lista
            }
//            FrmInformacionGrupo2 informacionGrupo = new FrmInformacionGrupo2( grupoSS,  agregarContactos,rowData);

//            informacionGrupo.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Por favor selecciona al menos un contacto.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        MenuPrincipal mp = new MenuPrincipal(personaDTO,tarjetaDTO);

        mp.show();
        this.dispose();


        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
   
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableContactos;
    // End of variables declaration//GEN-END:variables
}
