/*
 * AddNewNote.java
 *
 * Created on February 3, 2006, 1:52 PM
 */

package rmischedule.schedule.components.notes;
import java.awt.*;
import rmischedule.schedule.*;
import rmischedule.schedule.components.*;
import javax.swing.*;

import rmischeduleserver.mysqlconnectivity.queries.schedule_data.notes.*;

/**
 *
 * @author  Ira Juneau
 */
public class AddNewNote extends javax.swing.JPanel {
    
    private Schedule_View_Panel svp;
    private Object currObjectToAttachNotesTo;
    
    /** Creates new form AddNewNote */
    public AddNewNote(Schedule_View_Panel sv) {
        initComponents();
        svp = sv;
        setBackground(new Color(255,255,255, 200));
        //controlPanel.setBackground(new Color(244,245,179, 100));
    }
    
    public void setVisible(boolean val, Object obj) {
        if (val) {
            memoText.setText("");
            currObjectToAttachNotesTo = obj;
            super.setVisible(true);
            Rectangle mySize = getBounds();
            JLayeredPane myParentPane = svp.getLayeredPane();
            
        } else {
            super.setVisible(false);
        }
    }
    
    /**
     * Used to attach a note to the damn shift...
     */
    private void saveSchedule() {
        save_schedule_note_query mySaveQuery = new save_schedule_note_query();
        SShift myShift = (SShift)currObjectToAttachNotesTo;
        mySaveQuery.update(myShift.myShift.getShiftId(), memoText.getText(), "1");
        if (myShift.myShift instanceof DShift) {
            QueryGenerateShift myQuery = new QueryGenerateShift((DShift)myShift.myShift);

            try {
                myQuery.updateShiftTimeUpdated();
                svp.getConnection().prepQuery(myQuery.getMyQuery());
                svp.getConnection().prepQuery(mySaveQuery);
                
                svp.getConnection().executeUpdate(myQuery.getMyQuery());
                svp.getConnection().executeUpdate(mySaveQuery);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (myShift.myShift instanceof DAvailability) {
            //TODO: Save note
        }
        JOptionPane.showMessageDialog(this, "EZ-Note Saved!", "Confirm Save", JOptionPane.OK_OPTION);
        hideMe(null);
    }
    
    public void saveData() {
        try {
            SShift myShift = (SShift)currObjectToAttachNotesTo;
            saveSchedule();
        } catch (Exception e) {}
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        controlPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        memoText = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10)));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        jPanel3.setMaximumSize(new java.awt.Dimension(32767, 14));
        jPanel3.setOpaque(false);
        jPanel3.setPreferredSize(new java.awt.Dimension(100, 14));
        jPanel3.setLayout(new java.awt.GridLayout(1, 0));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Add A New Note");
        jPanel3.add(jLabel1);

        add(jPanel3);

        controlPanel.setBackground(new java.awt.Color(244, 245, 179));
        controlPanel.setOpaque(false);
        controlPanel.setLayout(new java.awt.GridLayout(1, 0));

        memoText.setBackground(new java.awt.Color(244, 245, 179));
        memoText.setColumns(20);
        memoText.setRows(5);
        jScrollPane1.setViewportView(memoText);

        controlPanel.add(jScrollPane1);

        add(controlPanel);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        jButton2.setText("Cancel");
        jButton2.setMaximumSize(new java.awt.Dimension(120, 22));
        jButton2.setMinimumSize(new java.awt.Dimension(120, 22));
        jButton2.setPreferredSize(new java.awt.Dimension(120, 22));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hideMe(evt);
            }
        });
        jPanel1.add(jButton2);

        jPanel2.setMaximumSize(new java.awt.Dimension(32767, 45));
        jPanel2.setMinimumSize(new java.awt.Dimension(10, 45));
        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(100, 45));

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 125, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 45, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2);

        jButton1.setText("Save");
        jButton1.setMaximumSize(new java.awt.Dimension(120, 22));
        jButton1.setMinimumSize(new java.awt.Dimension(120, 22));
        jButton1.setPreferredSize(new java.awt.Dimension(120, 22));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveData(evt);
            }
        });
        jPanel1.add(jButton1);

        add(jPanel1);
    }// </editor-fold>//GEN-END:initComponents

    private void saveData(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveData
        saveData();
    }//GEN-LAST:event_saveData

    private void hideMe(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hideMe
        svp.setNoteVisible(false, this);
    }//GEN-LAST:event_hideMe

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        //Leave this here so we no longer can just click through the form.
    }//GEN-LAST:event_formMouseClicked
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel controlPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea memoText;
    // End of variables declaration//GEN-END:variables
    
}
