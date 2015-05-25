/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DirectionPanel.java
 *
 * Created on Jan 27, 2011, 10:23:05 AM
 */
package rmischedule.mapping;

import java.text.DecimalFormat;
import rmischeduleserver.mapping.gson.Maneuver;
import rmischeduleserver.mapping.gson.Sign;

/** 
 *
 * @author user
 */
public class DirectionPanel extends javax.swing.JPanel {

    /** Creates new form DirectionPanel */
    public DirectionPanel(Maneuver maneuver) {
        initComponents();

        StringBuilder html = new StringBuilder();
        html.append("<html>");
        html.append("<table>");
        html.append("<td width=\"30px\">");
        if (maneuver.getIconUrl() != null && maneuver.getIconUrl().trim().length() > 0) {
            html.append("<img src=\"").append(maneuver.getIconUrl()).append("\"/><br/>");
        }
        if (maneuver.getSigns().size() > 0) {
            Sign sign = maneuver.getSigns().getFirst();
            if (sign.getIconUrl() != null && sign.getIconUrl().trim().length() > 0) {
                html.append("<img src=\"").append(sign.getIconUrl()).append("\"/><br/>");
            }
        }
        html.append("</td><td width=\"220px\">");
        html.append(maneuver.getNarrative());
        html.append("</td>");
        html.append("<td width=\"50px\">");
        html.append((maneuver.getTime() / 60) + " min<br/>");
        DecimalFormat format = new DecimalFormat("###,##");
        html.append(format.format(maneuver.getDistance())).append(" miles");
        html.append("</td>");
        html.append("</table>");
        html.append("</html>");
        this.maneuverText.setText(html.toString());
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        maneuverText = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(300, 55));
        setLayout(new java.awt.GridLayout(1, 0));

        maneuverText.setMaximumSize(new java.awt.Dimension(10000, 200));
        maneuverText.setMinimumSize(new java.awt.Dimension(300, 16));
        maneuverText.setPreferredSize(new java.awt.Dimension(300, 30));
        add(maneuverText);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel maneuverText;
    // End of variables declaration//GEN-END:variables
}