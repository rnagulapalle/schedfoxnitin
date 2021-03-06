/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CreateDynamicField.java
 *
 * Created on Aug 12, 2010, 11:43:54 AM
 */
package rmischedule.xadmin.components;

import java.util.Vector;
import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListDataListener;
import rmischedule.data_connection.Connection;
import rmischedule.main.Main_Window;
import rmischedule.xadmin.CompanyDynamicFields;
import rmischedule.xadmin.DynamicComboSetup;
import rmischeduleserver.control.model.DynamicFieldDef;
import rmischedule.xadmin.model.DynamicFieldLocation;
import rmischedule.xadmin.model.DynamicFieldType;
import rmischeduleserver.mysqlconnectivity.queries.admin.save_dynamic_field_query;

/**
 *
 * @author user
 */
public class CreateDynamicField extends javax.swing.JPanel {

    private Vector<DynamicFieldLocation> fieldLocations;
    private Vector<DynamicFieldType> fieldTypes;
    private LocationCombo locationCombo;
    private TypeCombo typeCombo;
    private DynamicFieldDef fieldDef;
    private CompanyDynamicFields companyFields;

    /** Creates new form CreateDynamicField */
    public CreateDynamicField(CompanyDynamicFields companyFields, Vector<DynamicFieldLocation> fieldLocations, Vector<DynamicFieldType> fieldType, DynamicFieldDef fieldDef) {
        this.companyFields = companyFields;
        locationCombo = new LocationCombo();
        typeCombo = new TypeCombo();
        this.fieldDef = fieldDef;
        initComponents();
        this.fieldLocations = fieldLocations;
        this.fieldTypes = fieldType;
        saveBtn.setIcon(Main_Window.Save_User_Icon_24x24px);
        editBtn.setIcon(Main_Window.WindowsEdit24x24);
        deleteBtn.setIcon(Main_Window.Delete24x24);
        editBtn.setVisible(false);
        if (fieldDef.getFieldTypeId() == 7) {
            editBtn.setVisible(true);
        }

        this.fieldNameTxt.setText(fieldDef.getName());
        this.isRequiredTxt.setSelected(fieldDef.isIsRequired());
        this.typeCombo.setSelectedId(fieldDef.getFieldTypeId());
        this.locationCombo.setSelectedId(fieldDef.getFieldLocationId());
        this.showInEmployeeLoginChk.setSelected(fieldDef.isShowInEmployeeLogin());
        this.showInClientLoginChk.setSelected(fieldDef.isShowInClientLogin());
    }

    /**
     * Saves the dynamic field object to the db.
     */
    private void saveDynamicField() {
        boolean hasError = false;
        try {
            fieldDef.setFieldLocationId(((DynamicFieldLocation) this.locationCombo.getSelectedItem()).getId());
        } catch (Exception e) {
            hasError = true;
            JOptionPane.showMessageDialog(Main_Window.parentOfApplication, "Please choose an location!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        try {
            fieldDef.setFieldTypeId(((DynamicFieldType) this.typeCombo.getSelectedItem()).getId());
        } catch (Exception e) {
            hasError = true;
            JOptionPane.showMessageDialog(Main_Window.parentOfApplication, "Please choose a type!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        if (!hasError) {
            fieldDef.setIsRequired(isRequiredTxt.isSelected());
            fieldDef.setName(fieldNameTxt.getText());
            fieldDef.setShowInClientLogin(showInClientLoginChk.isSelected());
            fieldDef.setShowInEmployeeLogin(showInEmployeeLoginChk.isSelected());

            save_dynamic_field_query saveQuery = new save_dynamic_field_query();
            saveQuery.update(fieldDef.getId(), fieldDef.getFieldLocationId(), fieldDef.getFieldTypeId(), 
                    fieldDef.getName(), fieldDef.getDynamicFieldDefDefault(), fieldDef.isIsRequired(),
                    true, fieldDef.isShowInClientLogin(), fieldDef.isShowInEmployeeLogin());
            Connection myConn = this.companyFields.getMyParent().getConnection();
            myConn.executeUpdate(saveQuery);

            companyFields.reloadData();
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        firstRowPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        windowCmbBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        fieldNameTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        fieldTypeCombo = new javax.swing.JComboBox();
        secondRowPanel = new javax.swing.JPanel();
        showInClientLoginChk = new javax.swing.JCheckBox();
        showInEmployeeLoginChk = new javax.swing.JCheckBox();
        isRequiredTxt = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        editBtn = new javax.swing.JButton();
        saveBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(), javax.swing.BorderFactory.createEmptyBorder(4, 3, 4, 3)));
        setMaximumSize(new java.awt.Dimension(1493, 70));
        setMinimumSize(new java.awt.Dimension(593, 70));
        setPreferredSize(new java.awt.Dimension(593, 70));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        firstRowPanel.setLayout(new javax.swing.BoxLayout(firstRowPanel, javax.swing.BoxLayout.X_AXIS));

        jLabel3.setText("Window");
        jLabel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 5));
        firstRowPanel.add(jLabel3);

        windowCmbBox.setModel(locationCombo);
        windowCmbBox.setMaximumSize(new java.awt.Dimension(1000, 24));
        windowCmbBox.setMinimumSize(new java.awt.Dimension(70, 24));
        windowCmbBox.setPreferredSize(new java.awt.Dimension(70, 24));
        firstRowPanel.add(windowCmbBox);

        jLabel1.setText("Field Name");
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 5));
        firstRowPanel.add(jLabel1);

        fieldNameTxt.setMaximumSize(new java.awt.Dimension(150, 24));
        fieldNameTxt.setMinimumSize(new java.awt.Dimension(140, 24));
        fieldNameTxt.setPreferredSize(new java.awt.Dimension(140, 24));
        firstRowPanel.add(fieldNameTxt);

        jLabel2.setText("Field Type");
        jLabel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 5));
        firstRowPanel.add(jLabel2);

        fieldTypeCombo.setModel(typeCombo);
        fieldTypeCombo.setMaximumSize(new java.awt.Dimension(100, 24));
        fieldTypeCombo.setMinimumSize(new java.awt.Dimension(100, 24));
        fieldTypeCombo.setPreferredSize(new java.awt.Dimension(100, 24));
        fieldTypeCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldTypeComboActionPerformed(evt);
            }
        });
        firstRowPanel.add(fieldTypeCombo);

        add(firstRowPanel);

        secondRowPanel.setLayout(new javax.swing.BoxLayout(secondRowPanel, javax.swing.BoxLayout.X_AXIS));

        showInClientLoginChk.setText("Show in Client Login Dashboard");
        secondRowPanel.add(showInClientLoginChk);

        showInEmployeeLoginChk.setText("Show in Employee Login Dashboard");
        secondRowPanel.add(showInEmployeeLoginChk);

        isRequiredTxt.setText("Required?");
        isRequiredTxt.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 5));
        isRequiredTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isRequiredTxtActionPerformed(evt);
            }
        });
        secondRowPanel.add(isRequiredTxt);
        secondRowPanel.add(jPanel1);

        editBtn.setMaximumSize(new java.awt.Dimension(26, 26));
        editBtn.setMinimumSize(new java.awt.Dimension(26, 26));
        editBtn.setPreferredSize(new java.awt.Dimension(26, 26));
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });
        secondRowPanel.add(editBtn);

        saveBtn.setMaximumSize(new java.awt.Dimension(26, 26));
        saveBtn.setMinimumSize(new java.awt.Dimension(26, 26));
        saveBtn.setPreferredSize(new java.awt.Dimension(26, 26));
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });
        secondRowPanel.add(saveBtn);

        deleteBtn.setMaximumSize(new java.awt.Dimension(26, 26));
        deleteBtn.setMinimumSize(new java.awt.Dimension(26, 26));
        deleteBtn.setPreferredSize(new java.awt.Dimension(26, 26));
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });
        secondRowPanel.add(deleteBtn);

        add(secondRowPanel);
    }// </editor-fold>//GEN-END:initComponents

    private void isRequiredTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isRequiredTxtActionPerformed
    }//GEN-LAST:event_isRequiredTxtActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        this.saveDynamicField();
    }//GEN-LAST:event_saveBtnActionPerformed

    private void fieldTypeComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldTypeComboActionPerformed
        if (((DynamicFieldType) this.typeCombo.getSelectedItem()).getId() == 7) {
            //editComboWindow();
        }
    }//GEN-LAST:event_fieldTypeComboActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        editComboWindow();
    }//GEN-LAST:event_editBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        deleteField();
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void deleteField() {
        int confirm = JOptionPane.showConfirmDialog(Main_Window.parentOfApplication, "You are about to delete out this field and all associated data! \r\n" +
                "Once completed you will not be able to get this information back, are you sure you want to do this?",
                "Confirm Deletion", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION && fieldDef.getId() != 0) {
            save_dynamic_field_query saveQuery = new save_dynamic_field_query();
            saveQuery.update(fieldDef.getId(), fieldDef.getFieldLocationId(), fieldDef.getFieldTypeId(), fieldDef.getName(), 
                    fieldDef.getDynamicFieldDefDefault(), fieldDef.isIsRequired(), false, fieldDef.isShowInClientLogin(),
                    fieldDef.isShowInEmployeeLogin());
            Connection myConn = this.companyFields.getMyParent().getConnection();
            myConn.executeUpdate(saveQuery);

            companyFields.reloadData();
        }
    }

    private void editComboWindow() {
        DynamicComboSetup dynamicComboSetup =
                new DynamicComboSetup(Main_Window.parentOfApplication, true, fieldDef, companyFields.getMyParent().getConnection());
        dynamicComboSetup.setVisible(true);
        editBtn.setVisible(true);
    }

    private class TypeCombo implements ComboBoxModel {

        int index = -1;

        public void setSelectedItem(Object anItem) {
            if (anItem instanceof DynamicFieldType) {
                DynamicFieldType fieldType = (DynamicFieldType) anItem;
                for (int i = 0; i < fieldTypes.size(); i++) {
                    if (fieldTypes.get(i).getId() == fieldType.getId()) {
                        index = i;
                        if (fieldTypes.get(i).getId() == 7) {
                            editComboWindow();
                        } else {
                            editBtn.setVisible(false);
                        }
                    }
                }
            }
        }

        public void setSelectedId(int id) {
            for (int i = 0; i < fieldTypes.size(); i++) {
                if (fieldTypes.get(i).getId() == id) {
                    index = i;
                }
            }
        }

        public Object getSelectedItem() {
            if (index == -1) {
                return "Select a type";
            } else {
                return fieldTypes.get(index);
            }
        }

        public int getSize() {
            return fieldTypes.size();
        }

        public Object getElementAt(int index) {
            if (index == -1) {
                return "Select a type";
            } else {
                return fieldTypes.get(index);
            }
        }

        public void addListDataListener(ListDataListener l) {
        }

        public void removeListDataListener(ListDataListener l) {
        }
    }

    private class LocationCombo implements ComboBoxModel {

        int index = -1;

        public void setSelectedItem(Object anItem) {
            if (anItem instanceof DynamicFieldLocation) {
                DynamicFieldLocation fieldLocation = (DynamicFieldLocation) anItem;
                for (int i = 0; i < fieldLocations.size(); i++) {
                    if (fieldLocations.get(i).getId() == fieldLocation.getId()) {
                        index = i;
                    }
                }
            }
        }

        public void setSelectedId(int id) {
            for (int i = 0; i < fieldLocations.size(); i++) {
                if (fieldLocations.get(i).getId() == id) {
                    index = i;
                }
            }
        }

        public Object getSelectedItem() {
            if (index == -1) {
                return "Select a location";
            } else {
                return fieldLocations.get(index);
            }
        }

        public int getSize() {
            return fieldLocations.size();
        }

        public Object getElementAt(int index) {
            if (index == -1) {
                return "Select a location";
            } else {
                return fieldLocations.get(index);
            }
        }

        public void addListDataListener(ListDataListener l) {
        }

        public void removeListDataListener(ListDataListener l) {
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JTextField fieldNameTxt;
    private javax.swing.JComboBox fieldTypeCombo;
    private javax.swing.JPanel firstRowPanel;
    private javax.swing.JCheckBox isRequiredTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton saveBtn;
    private javax.swing.JPanel secondRowPanel;
    private javax.swing.JCheckBox showInClientLoginChk;
    private javax.swing.JCheckBox showInEmployeeLoginChk;
    private javax.swing.JComboBox windowCmbBox;
    // End of variables declaration//GEN-END:variables
}
