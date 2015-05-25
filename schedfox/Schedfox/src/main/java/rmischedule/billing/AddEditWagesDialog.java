/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AddEditWagesDialog.java
 *
 * Created on Apr 15, 2011, 1:03:17 PM
 */

package rmischedule.billing;

import java.math.BigDecimal;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import rmischedule.employee.components.Employee_Billing;
import rmischedule.main.Main_Window;
import rmischeduleserver.control.BillingController;
import schedfoxlib.model.Employee;
import schedfoxlib.model.EmployeeWageTypes;
import schedfoxlib.model.EmployeeWages;

/**
 *
 * @author user
 */
public class AddEditWagesDialog extends javax.swing.JDialog {

    private EmployeeWages wage;
    private Employee_Billing empBilling;
    private String companyId;

    private EmployeeWagesComboModel employeeComboModel = new EmployeeWagesComboModel();
    
    /** Creates new form AddEditWagesDialog */
    public AddEditWagesDialog(java.awt.Frame parent, boolean modal, 
            EmployeeWages wage, Employee_Billing empBilling, String companyId) {
        super(parent, modal);
        initComponents();
        this.wage = wage;
        this.empBilling = empBilling;
        this.companyId = companyId;

        this.fillInForm();
    }

    private EmployeeWagesComboModel getEmployeeWagesModel() {
        return this.employeeComboModel;
    }

    private void fillInForm() {
        try {
            this.amountTxt.setText(wage.getWages().toString());
        } catch (NullPointerException npe) {
            this.amountTxt.setText("0.00");
        }
        try {
            typeCombo.setSelectedItem(wage.getEmployeeWageTypeId());
        } catch (Exception e) {}
        BillingController billingController = BillingController.getInstance(this.companyId);
        try {
            ArrayList<EmployeeWageTypes> types = billingController.getEmployeeWageTypes();
            for (int t = 0; t < types.size(); t++) {
                employeeComboModel.addItem(types.get(t));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(Main_Window.parentOfApplication,
                    "Could not get the wage types", "Error", JOptionPane.ERROR_MESSAGE);
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

        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        typeCombo = new javax.swing.JComboBox();
        editWageTypeBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        amountTxt = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        closeBtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        saveBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        jPanel4.setMaximumSize(new java.awt.Dimension(4000, 300));
        jPanel4.setMinimumSize(new java.awt.Dimension(40, 30));
        jPanel4.setPreferredSize(new java.awt.Dimension(100, 30));
        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.LINE_AXIS));

        jLabel1.setText("Wage Type");
        jLabel1.setMaximumSize(new java.awt.Dimension(110, 24));
        jLabel1.setMinimumSize(new java.awt.Dimension(110, 24));
        jLabel1.setPreferredSize(new java.awt.Dimension(110, 24));
        jPanel4.add(jLabel1);

        typeCombo.setModel(getEmployeeWagesModel());
        typeCombo.setMaximumSize(new java.awt.Dimension(32767, 26));
        jPanel4.add(typeCombo);

        editWageTypeBtn.setText("Edit Types");
        editWageTypeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editWageTypeBtnActionPerformed(evt);
            }
        });
        jPanel4.add(editWageTypeBtn);

        getContentPane().add(jPanel4);

        jPanel2.setMaximumSize(new java.awt.Dimension(4000, 300));
        jPanel2.setMinimumSize(new java.awt.Dimension(40, 30));
        jPanel2.setPreferredSize(new java.awt.Dimension(100, 30));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        jLabel2.setText("Amount");
        jLabel2.setMaximumSize(new java.awt.Dimension(110, 24));
        jLabel2.setMinimumSize(new java.awt.Dimension(110, 24));
        jLabel2.setPreferredSize(new java.awt.Dimension(110, 24));
        jPanel2.add(jLabel2);

        amountTxt.setMaximumSize(new java.awt.Dimension(2147483647, 28));
        jPanel2.add(amountTxt);

        getContentPane().add(jPanel2);

        jPanel1.setMaximumSize(new java.awt.Dimension(4000, 300));
        jPanel1.setMinimumSize(new java.awt.Dimension(40, 30));
        jPanel1.setPreferredSize(new java.awt.Dimension(100, 30));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        closeBtn.setText("Close");
        closeBtn.setMaximumSize(new java.awt.Dimension(70, 28));
        closeBtn.setMinimumSize(new java.awt.Dimension(70, 28));
        closeBtn.setPreferredSize(new java.awt.Dimension(70, 28));
        closeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeBtnActionPerformed(evt);
            }
        });
        jPanel1.add(closeBtn);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 223, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 41, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3);

        saveBtn.setText("Save");
        saveBtn.setMaximumSize(new java.awt.Dimension(70, 28));
        saveBtn.setMinimumSize(new java.awt.Dimension(70, 28));
        saveBtn.setPreferredSize(new java.awt.Dimension(70, 28));
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });
        jPanel1.add(saveBtn);

        getContentPane().add(jPanel1);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-371)/2, (screenSize.height-157)/2, 371, 157);
    }// </editor-fold>//GEN-END:initComponents

    private void closeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBtnActionPerformed
        this.dispose();
    }//GEN-LAST:event_closeBtnActionPerformed

    private void editWageTypeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editWageTypeBtnActionPerformed
        AddEditWageTypesDialog editWageTypes = new AddEditWageTypesDialog(Main_Window.parentOfApplication,
                true, this.companyId);
        editWageTypes.setVisible(true);
    }//GEN-LAST:event_editWageTypeBtnActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        try {
            try {
                Employee emp = (Employee)this.empBilling.getMyParent().getSelectedObject();
                wage.setEmployeeId(emp.getEmployeeId());
            } catch (Exception e) {
                throw new Exception("Please select an employee before clicking save!");
            }
            try {
                EmployeeWageTypes wageTypes = (EmployeeWageTypes)employeeComboModel.getSelectedItem();
                wage.setEmployeeWageTypeId(wageTypes.getEmployeeWageTypeId());
            } catch (Exception e) {
                throw new Exception("Please select a wage type!");
            }
            try {
                wage.setWages(new BigDecimal(Double.parseDouble(amountTxt.getText())));
            } catch (Exception e) {
                throw new Exception("Please enter a valid amount!");
            }
            BillingController billingController = BillingController.getInstance(companyId);
            billingController.saveEmployeeWage(wage);
            JOptionPane.showMessageDialog(Main_Window.parentOfApplication,
                    "Wage Saved", "Information Saved", JOptionPane.INFORMATION_MESSAGE);
            this.empBilling.reloadData();
            this.dispose();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(Main_Window.parentOfApplication,
                    "Could not save wage! Error: " + e.getMessage(), "Error Saving",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_saveBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amountTxt;
    private javax.swing.JButton closeBtn;
    private javax.swing.JButton editWageTypeBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton saveBtn;
    private javax.swing.JComboBox typeCombo;
    // End of variables declaration//GEN-END:variables

}