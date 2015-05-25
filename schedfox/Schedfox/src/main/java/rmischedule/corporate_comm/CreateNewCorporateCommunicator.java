/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CreateNewCorporateCommunicator.java
 *
 * Created on Oct 26, 2010, 10:33:35 AM
 */

package rmischedule.corporate_comm;

import java.util.Date;
import javax.swing.JOptionPane;
import rmischedule.data_connection.Connection;
import rmischedule.main.Main_Window;
import rmischedule.messaging.email.SchedfoxEmail;
import rmischedule.schedule.Schedule_View_Panel;
import schedfoxlib.model.util.Record_Set;
import schedfoxlib.model.Client;
import schedfoxlib.model.Problemsolver;
import rmischeduleserver.mysqlconnectivity.queries.client.get_corporate_communicator_contact_query;
import rmischeduleserver.mysqlconnectivity.queries.problem_solver.save_problem_for_client_query;

/**
 *
 * @author user
 */
public class CreateNewCorporateCommunicator extends javax.swing.JDialog {

    private Schedule_View_Panel svp;
    private Client client;
    private CorporateCommunicator corporateCommunicator;

    /** Creates new form CreateNewCorporateCommunicator */
    public CreateNewCorporateCommunicator(java.awt.Frame parent, CorporateCommunicator corpCommunicator,
            Schedule_View_Panel svp, boolean modal, Client clientobj) {
        super(parent, modal);
        this.svp = svp;
        this.client = clientobj;
        this.corporateCommunicator = corpCommunicator;
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        problemTxt = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        cancelBtn = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        okBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("");
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 8, 1, 8));
        jPanel3.setMaximumSize(new java.awt.Dimension(7000005, 75));
        jPanel3.setMinimumSize(new java.awt.Dimension(100, 75));
        jPanel3.setPreferredSize(new java.awt.Dimension(396, 75));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 32)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Corporate Communicator");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel3.add(jLabel2, java.awt.BorderLayout.NORTH);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 414, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel5, java.awt.BorderLayout.CENTER);

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(32, 25, 101));
        jLabel1.setText("Communication makes us both better.  Tell us how we can help.");
        jPanel3.add(jLabel1, java.awt.BorderLayout.SOUTH);

        getContentPane().add(jPanel3);

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 8, 8, 8));
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        problemTxt.setColumns(20);
        problemTxt.setLineWrap(true);
        problemTxt.setRows(5);
        problemTxt.setWrapStyleWord(true);
        jScrollPane1.setViewportView(problemTxt);

        jPanel2.add(jScrollPane1);

        getContentPane().add(jPanel2);

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 8, 1, 8));
        jPanel1.setMaximumSize(new java.awt.Dimension(32767, 35));
        jPanel1.setMinimumSize(new java.awt.Dimension(0, 35));
        jPanel1.setPreferredSize(new java.awt.Dimension(413, 35));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        cancelBtn.setText("Cancel");
        cancelBtn.setMaximumSize(new java.awt.Dimension(90, 30));
        cancelBtn.setMinimumSize(new java.awt.Dimension(90, 23));
        cancelBtn.setPreferredSize(new java.awt.Dimension(90, 23));
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });
        jPanel1.add(cancelBtn);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 234, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 33, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4);

        okBtn.setText("Save");
        okBtn.setMaximumSize(new java.awt.Dimension(90, 30));
        okBtn.setMinimumSize(new java.awt.Dimension(90, 23));
        okBtn.setPreferredSize(new java.awt.Dimension(90, 23));
        okBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okBtnActionPerformed(evt);
            }
        });
        jPanel1.add(okBtn);

        getContentPane().add(jPanel1);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-438)/2, (screenSize.height-291)/2, 438, 291);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void okBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okBtnActionPerformed
        Connection myConn = svp.getConnection();
        long millis = myConn.getServerTimeMillis();
        int client_id = Integer.parseInt(Main_Window.parentOfApplication.myUser.getUserId());
        Problemsolver problem = new Problemsolver();
        problem.setProblem(this.problemTxt.getText());
        problem.setPsDate(new Date(millis));
        problem.setClientId(client_id);

        save_problem_for_client_query saveQuery = new save_problem_for_client_query();
        saveQuery.update(problem);
        myConn.prepQuery(saveQuery);
        myConn.executeQuery(saveQuery);

        try {
            Main_Window.parentOfApplication.myUser.setEmail("notify@schedfox.com");
            new SchedfoxEmail("New Corporate Communicator for " + client.getClientName(), this.problemTxt.getText(), getDMToNotify(client_id), false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(Main_Window.parentOfApplication, "Error",
                    "Could not notify DM's via email. " + e.getMessage(), JOptionPane.ERROR_MESSAGE);
        } finally {
            corporateCommunicator.refreshProblems(svp);
            this.dispose();
        }

        
    }//GEN-LAST:event_okBtnActionPerformed

    private String[] getDMToNotify(int client_id) {
        get_corporate_communicator_contact_query contactQuery = new get_corporate_communicator_contact_query();
        contactQuery.setPreparedStatement(new Object[]{client_id});

        Record_Set rst = svp.getConnection().executeQuery(contactQuery);
        String[] myVal = new String[rst.length()];
        if (rst.length() == 0) {
            myVal = new String[5];
            myVal[0] = "bmccoy@champ.net";
            myVal[1] = "msullivan@champ.net";
            myVal[2] = "bsatchell@champ.net";
            myVal[3] = "aalonzo@champ.net";
            myVal[4] = "dmorong@champ.net";
        } else {
            for (int u = 0; u < rst.length(); u++) {
                myVal[u] = rst.getString("user_email");
                rst.moveNext();
            }
        }
        return myVal;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton okBtn;
    private javax.swing.JTextArea problemTxt;
    // End of variables declaration//GEN-END:variables

}