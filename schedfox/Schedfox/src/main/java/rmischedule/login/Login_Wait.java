/*
 * Login_Wait.java
 *
 * Created on August 31, 2004, 10:23 AM
 */

package rmischedule.login;
import rmischedule.login.UpdateComponents.*;
import java.awt.Color;
import java.awt.Dimension;
/**
 *
 * @author  jason.allen
 */
public class Login_Wait extends javax.swing.JInternalFrame {
    
    public static final Dimension hasDataSize = new Dimension(427, 300);
    public static final Dimension noDataSize = new Dimension(427, 84);
    public static Dimension activeSize;
    public boolean hasData;
    
    /** Creates new form Login_Wait */
    public Login_Wait() {
        ListNewUpdatesClass myUpdates = new ListNewUpdatesClass();
        hasData = false;
        initComponents();
        
        if (!hasData) {
            DataContainer.setVisible(false);
            activeSize = noDataSize;
        } else {
            for (int i = 0; i < myUpdates.myChangeHistory.size(); i++) {
                DataPanel.add(new IndividualPanel(myUpdates.myChangeHistory.get(i)));
            }
            activeSize = hasDataSize;
        }
        myScrollPane.getVerticalScrollBar().setBlockIncrement(40);
        myScrollPane.revalidate();
        setBackground(new Color(213,222,242,180));
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-activeSize.width)/2, (screenSize.height-activeSize.height)/2, activeSize.width, activeSize.height);
    }
    
    public void incrementProgress(){
       if(pBar.getValue() == pBar.getMaximum()){
           pBar.setValue(0);
       }else{
           pBar.setValue(pBar.getValue() + 1);
       }
    }
    
    /**
     * Overloaded setVisible to allow user to read updates if available...
     */
    public void stopLoading() {
        if (hasData) {
            java.awt.CardLayout myLayout = (java.awt.CardLayout)ControlPanel.getLayout();
            myLayout.show(ControlPanel, "hidepanel");
            setTitle("Recent Updates");
            repaint();
        } else {
            setVisible(false);
            dispose();
        }
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        UpdateDataPanel = new javax.swing.JPanel();
        DataContainer = new javax.swing.JPanel();
        myScrollPane = new javax.swing.JScrollPane();
        DataPanel = new javax.swing.JPanel();
        ControlPanel = new javax.swing.JPanel();
        LoadingPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pBar = new javax.swing.JProgressBar();
        HidePanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(204, 204, 255)), javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED)));
        setFrameIcon(null);
        UpdateDataPanel.setLayout(new java.awt.GridLayout(1, 0));

        UpdateDataPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 8, 3, 8));
        UpdateDataPanel.setMinimumSize(new java.awt.Dimension(10, 0));
        UpdateDataPanel.setOpaque(false);
        DataContainer.setLayout(new java.awt.GridLayout(1, 0));

        DataContainer.setOpaque(false);
        myScrollPane.setOpaque(false);
        DataPanel.setLayout(new javax.swing.BoxLayout(DataPanel, javax.swing.BoxLayout.Y_AXIS));

        DataPanel.setOpaque(false);
        myScrollPane.setViewportView(DataPanel);

        DataContainer.add(myScrollPane);

        UpdateDataPanel.add(DataContainer);

        getContentPane().add(UpdateDataPanel);

        ControlPanel.setLayout(new java.awt.CardLayout());

        ControlPanel.setMaximumSize(new java.awt.Dimension(32767, 30));
        ControlPanel.setMinimumSize(new java.awt.Dimension(189, 30));
        ControlPanel.setOpaque(false);
        ControlPanel.setPreferredSize(new java.awt.Dimension(189, 30));
        LoadingPanel.setLayout(new javax.swing.BoxLayout(LoadingPanel, javax.swing.BoxLayout.Y_AXIS));

        LoadingPanel.setOpaque(false);
        jLabel1.setFont(new java.awt.Font("Verdana", 1, 14));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Contacting server and applying security settings");
        LoadingPanel.add(jLabel1);

        pBar.setMaximumSize(new java.awt.Dimension(32767, 12));
        pBar.setMinimumSize(new java.awt.Dimension(10, 12));
        pBar.setPreferredSize(new java.awt.Dimension(150, 12));
        LoadingPanel.add(pBar);

        ControlPanel.add(LoadingPanel, "card2");

        HidePanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 0));

        HidePanel.setOpaque(false);
        jButton1.setText("OK");
        jButton1.setMaximumSize(new java.awt.Dimension(65, 23));
        jButton1.setMinimumSize(new java.awt.Dimension(65, 23));
        jButton1.setPreferredSize(new java.awt.Dimension(65, 23));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        HidePanel.add(jButton1);

        ControlPanel.add(HidePanel, "hidepanel");

        getContentPane().add(ControlPanel);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-427)/2, (screenSize.height-82)/2, 427, 82);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ControlPanel;
    private javax.swing.JPanel DataContainer;
    private javax.swing.JPanel DataPanel;
    private javax.swing.JPanel HidePanel;
    private javax.swing.JPanel LoadingPanel;
    private javax.swing.JPanel UpdateDataPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane myScrollPane;
    private javax.swing.JProgressBar pBar;
    // End of variables declaration//GEN-END:variables
    
}
