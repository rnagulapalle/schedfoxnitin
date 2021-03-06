/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmischedule.equipment;

import java.util.ArrayList;
import rmischeduleserver.control.EquipmentController;
import schedfoxlib.model.ClientEquipment;
import schedfoxlib.model.EmployeeEquipment;
import schedfoxlib.model.EntityEquipment;
import schedfoxlib.model.Equipment;

/**
 *
 * @author user
 */
public class ManageEquipmentDialog extends javax.swing.JDialog {

    private EquipmentTableModel equipmentModel = new EquipmentTableModel();
    private EquipmentComboModel equipmentCombo = new EquipmentComboModel();
    private String companyId;

    /**
     * Creates new form ManageEquipmentDialog
     */
    public ManageEquipmentDialog(java.awt.Frame parent, boolean modal, String companyId) {
        super(parent, modal);
        initComponents();


        this.companyId = companyId;
        loadEquipment();
        loadEquipmentTypes();
    }

    private boolean loadEmployees() {
        if (!equipmentForCombo.getSelectedItem().toString().trim().equalsIgnoreCase("Clients")) {
            return true;
        }
        return false;
    }

    private boolean loadClients() {
        if (equipmentForCombo.getSelectedItem().toString().trim().equalsIgnoreCase("Clients")) {
            return true;
        }
        return false;
    }

    private void loadEquipmentTypes() {
        EquipmentController equipmentController = EquipmentController.getInstance(companyId);
        try {
            ArrayList<Equipment> equipment = equipmentController.getEquipmentByClientOrEmployee(loadClients(), loadEmployees());
            equipmentCombo.clearItems();
            for (int e = 0; e < equipment.size(); e++) {
                equipmentCombo.addItem(equipment.get(e));
            }
        } catch (Exception exe) {
            exe.printStackTrace();
        }
    }

    private void loadEquipment() {
        EquipmentController equipmentController = EquipmentController.getInstance(companyId);
        try {
            equipmentModel.clear();
            if (equipmentTypeCombo.getSelectedIndex() > -1) {
                Class myClass = EmployeeEquipment.class;
                if (loadClients()) {
                    myClass = ClientEquipment.class;
                }
                Equipment selEquipment = equipmentCombo.getEquipmentAt(equipmentTypeCombo.getSelectedIndex());
                ArrayList<EntityEquipment> equipment = equipmentController.getEquipmentByType(selEquipment.getEquipmentId(), myClass);
                for (int e = 0; e < equipment.size(); e++) {
                    equipmentModel.addEquipment(equipment.get(e));
                }
            }
        } catch (Exception exe) {
            exe.printStackTrace();
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

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        equipmentForCombo = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        equipmentTypeCombo = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        jPanel2.setMaximumSize(new java.awt.Dimension(32767, 90));
        jPanel2.setMinimumSize(new java.awt.Dimension(0, 90));
        jPanel2.setPreferredSize(new java.awt.Dimension(614, 90));
        jPanel2.setLayout(new java.awt.GridLayout(3, 0));

        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.LINE_AXIS));

        jLabel3.setText("Manage Equipment For");
        jLabel3.setMaximumSize(new java.awt.Dimension(120, 14));
        jLabel3.setMinimumSize(new java.awt.Dimension(120, 14));
        jLabel3.setPreferredSize(new java.awt.Dimension(120, 14));
        jPanel3.add(jLabel3);

        equipmentForCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Clients ", "Employees" }));
        equipmentForCombo.setMaximumSize(new java.awt.Dimension(140, 24));
        equipmentForCombo.setMinimumSize(new java.awt.Dimension(140, 24));
        equipmentForCombo.setPreferredSize(new java.awt.Dimension(140, 24));
        equipmentForCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                equipmentForComboActionPerformed(evt);
            }
        });
        jPanel3.add(equipmentForCombo);

        jLabel1.setText("Equipment Type");
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 6, 0, 0));
        jLabel1.setMaximumSize(new java.awt.Dimension(120, 14));
        jLabel1.setMinimumSize(new java.awt.Dimension(120, 14));
        jLabel1.setPreferredSize(new java.awt.Dimension(120, 14));
        jPanel3.add(jLabel1);

        equipmentTypeCombo.setModel(equipmentCombo);
        equipmentTypeCombo.setMaximumSize(new java.awt.Dimension(32767, 24));
        equipmentTypeCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                equipmentTypeComboActionPerformed(evt);
            }
        });
        jPanel3.add(equipmentTypeCombo);

        jPanel2.add(jPanel3);

        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.LINE_AXIS));

        jLabel2.setText("Unique ID");
        jLabel2.setMaximumSize(new java.awt.Dimension(120, 14));
        jLabel2.setMinimumSize(new java.awt.Dimension(120, 14));
        jLabel2.setPreferredSize(new java.awt.Dimension(120, 14));
        jPanel4.add(jLabel2);

        jTextField1.setMaximumSize(new java.awt.Dimension(140, 24));
        jTextField1.setMinimumSize(new java.awt.Dimension(140, 24));
        jTextField1.setPreferredSize(new java.awt.Dimension(140, 24));
        jPanel4.add(jTextField1);

        jLabel4.setText("Nickname");
        jLabel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 6, 0, 0));
        jLabel4.setMaximumSize(new java.awt.Dimension(120, 14));
        jLabel4.setMinimumSize(new java.awt.Dimension(120, 14));
        jLabel4.setPreferredSize(new java.awt.Dimension(120, 14));
        jPanel4.add(jLabel4);

        jTextField2.setMaximumSize(new java.awt.Dimension(2147483647, 24));
        jPanel4.add(jTextField2);

        jPanel2.add(jPanel4);

        jButton1.setText("Save");
        jButton1.setMaximumSize(new java.awt.Dimension(80, 23));
        jButton1.setMinimumSize(new java.awt.Dimension(80, 23));
        jButton1.setPreferredSize(new java.awt.Dimension(80, 23));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(441, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 7, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel5);

        getContentPane().add(jPanel2);

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jTable1.setModel(equipmentModel);
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);

        getContentPane().add(jPanel1);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-539)/2, (screenSize.height-434)/2, 539, 434);
    }// </editor-fold>//GEN-END:initComponents

    private void equipmentForComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_equipmentForComboActionPerformed
        loadEquipmentTypes();
        loadEquipment();
    }//GEN-LAST:event_equipmentForComboActionPerformed

    private void equipmentTypeComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_equipmentTypeComboActionPerformed
        loadEquipment();
    }//GEN-LAST:event_equipmentTypeComboActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox equipmentForCombo;
    private javax.swing.JComboBox equipmentTypeCombo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
