/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * IndividualAvailabilityFilter.java
 *
 * Created on Jul 14, 2010, 2:08:54 PM
 */

package rmischedule.schedule.components.availability;

import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author user
 */
public class IndividualAvailabilityFilter extends JPanel {

    private ImageIcon activeIcon;
    private ImageIcon partialIcon;
    private ImageIcon unselectedIcon;

    private boolean isSelected;
    private boolean isAllSelection;

    private Object object;

    /** Creates new form IndividualAvailabilityFilter */
    public IndividualAvailabilityFilter(ImageIcon activeIcon, ImageIcon partialIcon, ImageIcon unselectedIcon, String text, boolean isAll) {
        initComponents();
        textLabel.setText(text);

        this.activeIcon = activeIcon;
        this.partialIcon = partialIcon;
        this.unselectedIcon = unselectedIcon;

        this.setSelected(true);
        isAllSelection = isAll;
    }

    public void setObject(Object obj) {
        this.object = obj;
    }

    public Object getObject() {
        return this.object;
    }

    public void setPartialSelected() {
        iconLabel.setIcon(partialIcon);
    }

    @Override
    public void addMouseListener(MouseListener listener) {
        iconLabel.addMouseListener(listener);
        textLabel.addMouseListener(listener);
        super.addMouseListener(listener);
    }

    public boolean isAllFilter() {
        return isAllSelection;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
        if (this.isSelected) {
            iconLabel.setIcon(activeIcon);
        } else {
            iconLabel.setIcon(unselectedIcon);
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

        iconLabel = new javax.swing.JLabel();
        textLabel = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(3000, 18));
        setMinimumSize(new java.awt.Dimension(68, 18));
        setPreferredSize(new java.awt.Dimension(277, 18));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        iconLabel.setMaximumSize(new java.awt.Dimension(20, 16));
        iconLabel.setMinimumSize(new java.awt.Dimension(20, 16));
        iconLabel.setPreferredSize(new java.awt.Dimension(20, 16));
        add(iconLabel);

        textLabel.setMaximumSize(new java.awt.Dimension(3400, 24));
        textLabel.setMinimumSize(new java.awt.Dimension(34, 24));
        textLabel.setPreferredSize(new java.awt.Dimension(3000, 24));
        add(textLabel);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel iconLabel;
    private javax.swing.JLabel textLabel;
    // End of variables declaration//GEN-END:variables

}
