/*
 * IndividualUpdateDesc.java
 *
 * Created on December 9, 2005, 1:01 PM
 */

package rmischedule.login.UpdateComponents;
import rmischedule.login.*;
/**
 *
 * @author  Ira Juneau
 */
public class IndividualUpdateDesc extends javax.swing.JPanel {
    
    /** Creates new form IndividualUpdateDesc */
    public IndividualUpdateDesc(ListNewUpdatesClass.HistoryDescription myDesc) {
        initComponents();
        Desc.setText(myDesc.desc);
        Use.setText(myDesc.howto);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        Desc = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        Use = new javax.swing.JTextArea();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.X_AXIS));

        setOpaque(false);
        jPanel1.setMaximumSize(new java.awt.Dimension(16, 32767));
        jPanel1.setMinimumSize(new java.awt.Dimension(16, 10));
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(16, 10));
        add(jPanel1);

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.Y_AXIS));

        jPanel2.setBorder(new javax.swing.border.MatteBorder(new java.awt.Insets(0, 0, 1, 0), new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(new java.awt.GridLayout());

        jPanel3.setOpaque(false);
        jLabel1.setForeground(new java.awt.Color(112, 39, 39));
        jLabel1.setText("Description");
        jPanel3.add(jLabel1);

        jPanel2.add(jPanel3);

        jPanel4.setLayout(new java.awt.GridLayout());

        jPanel4.setOpaque(false);
        Desc.setEditable(false);
        Desc.setLineWrap(true);
        Desc.setWrapStyleWord(true);
        Desc.setOpaque(false);
        jPanel4.add(Desc);

        jPanel2.add(jPanel4);

        jPanel5.setLayout(new java.awt.GridLayout());

        jPanel5.setOpaque(false);
        jLabel2.setForeground(new java.awt.Color(112, 39, 39));
        jLabel2.setText("How To Use");
        jPanel5.add(jLabel2);

        jPanel2.add(jPanel5);

        jPanel6.setLayout(new java.awt.GridLayout());

        jPanel6.setOpaque(false);
        Use.setEditable(false);
        Use.setLineWrap(true);
        Use.setWrapStyleWord(true);
        Use.setOpaque(false);
        jPanel6.add(Use);

        jPanel2.add(jPanel6);

        add(jPanel2);

    }
    // </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Desc;
    private javax.swing.JTextArea Use;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    // End of variables declaration//GEN-END:variables
    
}
