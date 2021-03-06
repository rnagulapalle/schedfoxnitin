/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FirstTimeEmployeePasswordChange.java
 *
 * Created on Aug 2, 2010, 2:09:06 PM
 */

package rmischedule.employee.dashboard;

import javax.swing.JOptionPane;
import rmischedule.data_connection.Connection;
import rmischedule.main.Main_Window;
import schedfoxlib.model.util.Record_Set;
import rmischeduleserver.mysqlconnectivity.queries.login.change_employees_password_query;
import rmischeduleserver.mysqlconnectivity.queries.login.check_employee_login_isnt_used_query;

/**
 *
 * @author user
 */
public class FirstTimeEmployeePasswordChange extends javax.swing.JDialog {

    private String companyDB;
    private int employee_id;
    private boolean change=false;

    /** Creates new form FirstTimeEmployeePasswordChange */
    public FirstTimeEmployeePasswordChange(java.awt.Frame parent, boolean modal, String companyDB, int employee_id) {
        super(parent, modal);
        initComponents();
        this.companyDB = companyDB;
        this.employee_id = employee_id;
    }
    public FirstTimeEmployeePasswordChange(java.awt.Frame parent, boolean modal,
            String companyDB, int employee_id,boolean change) {

        this(parent,modal,companyDB,employee_id);
        this.change=change;

    }
    private void createAndLogin() {
        String userName = userNameTxt.getText().replaceAll("'", "''").trim();
        String password = (new String(passwordTxt.getPassword())).replaceAll("'", "''").trim();
        String confirmPassword = (new String(confirmPasswordTxt.getPassword())).replaceAll("'", "''").trim();

        if (userName.length() == 0) {
            JOptionPane.showMessageDialog(Main_Window.parentOfApplication,
                    "You must enter a User Name!", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (password.length() == 0) {
            JOptionPane.showMessageDialog(Main_Window.parentOfApplication,
                    "You must enter a Password1", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (confirmPassword.length() == 0) {
            JOptionPane.showMessageDialog(Main_Window.parentOfApplication,
                    "You must confirm your password", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(Main_Window.parentOfApplication,
                    "Your passwords do not match!", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            check_employee_login_isnt_used_query myQuery = new check_employee_login_isnt_used_query();
            myQuery.update(userName, companyDB);
            Connection myConn = new Connection();
            Record_Set rst = myConn.executeQuery(myQuery);
            if(checkForDuplicates(rst,userName)){
                    JOptionPane.showMessageDialog(Main_Window.parentOfApplication,
                            "This login is already being used, please use a different " +
                            "name", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    //Ready to change pass and log in.
                    change_employees_password_query changeQuery = new change_employees_password_query();
                    changeQuery.update(userName, password, this.employee_id, this.companyDB);
                    myConn.executeUpdate(changeQuery);
                    if(change==false)
                        Main_Window.parentOfApplication.setUser(this.employee_id + "", companyDB);
                    this.dispose();
                }
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private boolean checkForDuplicates(Record_Set rst,String userName){

        if (change==false&&rst.length() > 0)
            return(true);

        if(change==true)
            while(rst.getEOF()==false){
                if(userName.equalsIgnoreCase(rst.getString("employee_login")))
                        if((rst.getInt("employee_id")!=employee_id))
                            return(true);
                rst.moveNext();
            }


         return(false);

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        userNameTxt = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        passwordTxt = new javax.swing.JPasswordField();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        confirmPasswordTxt = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
        loginBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        jPanel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.Y_AXIS));

        jTextArea1.setColumns(20);
        jTextArea1.setEditable(false);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 1, 13)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(4);
        jTextArea1.setText("Please enter your desired user name and password below. This will be the login name and password you use from now on to login to Schedfox.");
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setOpaque(false);
        jPanel5.add(jTextArea1);

        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.LINE_AXIS));

        jLabel1.setText("User Name");
        jLabel1.setMaximumSize(new java.awt.Dimension(120, 14));
        jLabel1.setMinimumSize(new java.awt.Dimension(120, 14));
        jLabel1.setPreferredSize(new java.awt.Dimension(120, 14));
        jPanel3.add(jLabel1);

        userNameTxt.setMaximumSize(new java.awt.Dimension(2147483647, 24));
        jPanel3.add(userNameTxt);

        jPanel5.add(jPanel3);

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        jLabel2.setText("Password");
        jLabel2.setMaximumSize(new java.awt.Dimension(120, 14));
        jLabel2.setMinimumSize(new java.awt.Dimension(120, 14));
        jLabel2.setPreferredSize(new java.awt.Dimension(120, 14));
        jPanel2.add(jLabel2);

        passwordTxt.setMaximumSize(new java.awt.Dimension(2147483647, 24));
        jPanel2.add(passwordTxt);

        jPanel5.add(jPanel2);

        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));
        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.LINE_AXIS));

        jLabel3.setText("Confirm Password");
        jLabel3.setMaximumSize(new java.awt.Dimension(120, 14));
        jLabel3.setMinimumSize(new java.awt.Dimension(120, 14));
        jLabel3.setPreferredSize(new java.awt.Dimension(120, 14));
        jPanel4.add(jLabel3);

        confirmPasswordTxt.setMaximumSize(new java.awt.Dimension(2147483647, 24));
        jPanel4.add(confirmPasswordTxt);

        jPanel5.add(jPanel4);

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanel1.setMaximumSize(new java.awt.Dimension(2147483647, 40));
        jPanel1.setMinimumSize(new java.awt.Dimension(90, 40));
        jPanel1.setPreferredSize(new java.awt.Dimension(338, 40));
        jPanel1.setLayout(new java.awt.BorderLayout());

        loginBtn.setText("Apply and Login");
        loginBtn.setMaximumSize(new java.awt.Dimension(140, 23));
        loginBtn.setMinimumSize(new java.awt.Dimension(140, 23));
        loginBtn.setPreferredSize(new java.awt.Dimension(140, 23));
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });
        jPanel1.add(loginBtn, java.awt.BorderLayout.EAST);

        jPanel5.add(jPanel1);

        getContentPane().add(jPanel5);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-346)/2, (screenSize.height-236)/2, 346, 236);
    }// </editor-fold>//GEN-END:initComponents

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        createAndLogin();
    }//GEN-LAST:event_loginBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField confirmPasswordTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton loginBtn;
    private javax.swing.JPasswordField passwordTxt;
    private javax.swing.JTextField userNameTxt;
    // End of variables declaration//GEN-END:variables

}
