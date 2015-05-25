/*
 * CheckInButton.java
 *
 * Created on January 5, 2005, 10:39 AM
 */

package rmischedule.schedule.checkincheckout;
import com.creamtec.ajaxswing.AjaxSwingManager;
import rmischedule.main.Main_Window;
/**
 *
 * @author  ira
 */
public class CheckInButton extends javax.swing.JPanel {
    private AlertIsOnThread  aiot;
    private boolean hasAlertBeenShown;
    
    /** Creates new form CheckInButton */
    public CheckInButton() {
        initComponents();
        hasAlertBeenShown = false;
        aiot = new AlertIsOnThread();
        aiot.start();
        IconLabel.setIcon(Main_Window.CheckInButtonIcon);

        if (AjaxSwingManager.isAjaxSwingRunning()) {
            IconLabel.setVisible(false);
        }
    }
    
    //public void addMouseListener(MouseListener al) {
        //addMouseListener(al);
    //}
    
    public void displayAlertOnInitialLoad() {
        hasAlertBeenShown = true;
    }
    
    public void ToggleAlertGraphicsOn() {
        if (!hasAlertBeenShown) {
            displayAlertOnInitialLoad();
        }
        //CheckButton.setBackground(Color.red);
    }
    
    public void ToggleAlertGraphicsOff() {
        //CheckButton.setBackground(Color.white);
    }
    
    public boolean checkIfAlertStillIsOn() {
        return Main_Window.parentOfApplication.isCheckInAlert();
    }
    
    public void dispose() {
        aiot.runMe = false;
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CheckInLabel = new javax.swing.JLabel();
        IconLabel = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setMaximumSize(new java.awt.Dimension(2147483647, 36));
        setMinimumSize(new java.awt.Dimension(120, 32));
        setPreferredSize(new java.awt.Dimension(120, 32));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ChangeBorder(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RestoreBorder(evt);
            }
        });
        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 8, 0));

        CheckInLabel.setFont(new java.awt.Font("Arial", 1, 16));
        CheckInLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        CheckInLabel.setText("Check In");
        CheckInLabel.setMaximumSize(new java.awt.Dimension(620, 16));
        add(CheckInLabel);

        IconLabel.setMaximumSize(new java.awt.Dimension(24, 24));
        IconLabel.setMinimumSize(new java.awt.Dimension(24, 24));
        IconLabel.setPreferredSize(new java.awt.Dimension(24, 24));
        add(IconLabel);
    }// </editor-fold>//GEN-END:initComponents

    private void ChangeBorder(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ChangeBorder
        setBorder(new javax.swing.border.BevelBorder(javax.swing.border.BevelBorder.LOWERED));
    }//GEN-LAST:event_ChangeBorder

    private void RestoreBorder(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RestoreBorder
        setBorder(new javax.swing.border.BevelBorder(javax.swing.border.BevelBorder.RAISED));
    }//GEN-LAST:event_RestoreBorder
    
    private class AlertIsOnThread extends Thread {
        public boolean runMe;
        public AlertIsOnThread() {
            runMe = true;
        }
        
        public void mySleep(int amt) {
            try {
                sleep(amt);
            } catch (Exception e) {
                
            }
        }
        
        public void run() {
            this.setPriority(Thread.MIN_PRIORITY);
            while (runMe) {
                mySleep(5000);
                while (checkIfAlertStillIsOn()) {
                    ToggleAlertGraphicsOn();
                    mySleep(1000);
                    ToggleAlertGraphicsOff();
                    mySleep(1000);
                }
            }
        }
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CheckInLabel;
    private javax.swing.JLabel IconLabel;
    // End of variables declaration//GEN-END:variables
    
}