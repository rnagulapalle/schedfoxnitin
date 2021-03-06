/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Text_Messaging_Template.java
 *
 * Created on Jul 8, 2010, 4:11:44 PM
 */
package rmischedule.messaging.components;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;
import rmischedule.main.Main_Window;
import rmischeduleserver.mysqlconnectivity.queries.messaging.sms.AddTemplateQuery;
import rmischeduleserver.mysqlconnectivity.queries.messaging.sms.GetSmsTemplates;
import rmischeduleserver.mysqlconnectivity.queries.messaging.sms.RemoveTemplateFromDB;
import rmischedule.messaging.datacomponents.Template;
import rmischedule.messagingboard.AutoCompleteComboBox;
import rmischedule.schedule.components.DShift;
import schedfoxlib.model.util.Record_Set;

/**
 *
 * @author vnguyen
 */
public class Text_Messaging_Template extends javax.swing.JInternalFrame {
    //parent to have a bi-directional reference to set states

    Text_Messaging myParent;
    //combobox to have templates, the combo box allows for autocomplet of their name
    AutoCompleteComboBox comboBoxSavedTemplates = new AutoCompleteComboBox();
    /**
     * SLOT HOLDER for company to be placed within Templates
     */
    public static final String COMPANY_TAG = "[COMPANY]";
    /**
     * SLOT HOLDER for Date to be placed within Templates
     */
    public static final String DATE_TAG = "[DATE]";
    /**
     * SLOT HOLDER for shift to be placed within Templates
     */
    public static final String SHIFT_TIME_TAG = "[SHIFT TIME]";
    /**
     * SLOT HOLDER for branch to be placed within Templates
     */
    public static final String BRANCH_TAG = "[BRANCH]";
    /**
     * SLOT HOLDER for user to be placed within Templates
     */
    public static final String USER_TAG = "[USER]";

    /** Creates new form Text_Messaging_Template */
    public Text_Messaging_Template(Text_Messaging parent) {
        this.intialLoad(parent);
        parent.getMyParent().setVisible(false);
    }

    private void addTxtCharCount() {
        //sets a new document to limit total characters
        JTextFieldLimit doc = new JTextFieldLimit(275);
        this.jTextArea1.setDocument(doc);
        doc.addDocumentListener((DocumentListener) new MyDocumentListener(this.jLabelCharCount));
    }

    private void adjustText(JTextArea j, String tag) {
        //grabs position of caret
        Integer pos = new Integer(j.getCaretPosition());
        StringBuilder str = new StringBuilder();
        try {
            //if caret is not at the end add it in the middle of the caret
            if (pos < j.getText().length() - 1) {
                str.append(j.getText(0, pos));
                str.append(" " + tag + " ");
                str.append(j.getText(pos, j.getText().length() - pos - 1));
            } else if (pos == j.getText().length() - 1) {
                //if caret is right at the end att
                str.append(j.getText());
                str.append(tag + " ");
            } else {
                str.append(j.getText());
                for (int i = j.getText().length(); i <= pos; i++) {
                    str.append(" ");
                }
                str.append(tag + " ");
            }
            // grabs the limit and checks before inserting
            int lim = ((JTextFieldLimit) j.getDocument()).getLimit();
            if (str.length() <= lim) {
                j.setText(str.toString());
            } else {
                //pops up a warning because the max is exceeded
                JOptionPane.showMessageDialog(Main_Window.parentOfApplication.desktop, "Maximum characters is " + lim + " and has been reached");
            }

        } catch (Exception e) {
            e.printStackTrace();
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
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jPanelButtons = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelCharCount = new javax.swing.JLabel();
        jButtonAddCompanyTag = new javax.swing.JButton();
        jButtonAddDateTag = new javax.swing.JButton();
        jButtonAddBranch = new javax.swing.JButton();
        jButtonShiftTime = new javax.swing.JButton();
        jButtonUser = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        jButtonDone = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();

        setClosable(true);
        setLayer(1);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanelButtons.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Saved Templates");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanelButtons.add(jLabel1, gridBagConstraints);

        jLabel2.setText("Char Count:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanelButtons.add(jLabel2, gridBagConstraints);

        jLabelCharCount.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        jPanelButtons.add(jLabelCharCount, gridBagConstraints);

        jButtonAddCompanyTag.setText("Company");
        jButtonAddCompanyTag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddCompanyTagActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanelButtons.add(jButtonAddCompanyTag, gridBagConstraints);

        jButtonAddDateTag.setText("Date");
        jButtonAddDateTag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddDateTagActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanelButtons.add(jButtonAddDateTag, gridBagConstraints);

        jButtonAddBranch.setText("Branch");
        jButtonAddBranch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddBranchActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanelButtons.add(jButtonAddBranch, gridBagConstraints);

        jButtonShiftTime.setText("ShiftTime");
        jButtonShiftTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonShiftTimeActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanelButtons.add(jButtonShiftTime, gridBagConstraints);

        jButtonUser.setText("User");
        jButtonUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUserActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanelButtons.add(jButtonUser, gridBagConstraints);

        jButtonDelete.setText("Delete");
        jButtonDelete.setEnabled(false);
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        jPanelButtons.add(jButtonDelete, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.4;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(jPanelButtons, gridBagConstraints);

        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setMinimumSize(new java.awt.Dimension(6, 22));
        jScrollPane1.setViewportView(jTextArea1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.6;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 6, 0);
        jPanel1.add(jScrollPane1, gridBagConstraints);

        btnSave.setText("SAVE");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel2.add(btnSave);

        jButtonDone.setText("DONE");
        jButtonDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDoneActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonDone);

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        jPanel2.add(btnCancel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.3;
        jPanel1.add(jPanel2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        jPanel1.add(jPanel3, gridBagConstraints);

        getContentPane().add(jPanel1);

        getAccessibleContext().setAccessibleParent(this);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-400)/2, (screenSize.height-300)/2, 400, 300);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddCompanyTagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddCompanyTagActionPerformed
        //swaps out the company tag
        this.adjustText(this.jTextArea1, COMPANY_TAG);
    }//GEN-LAST:event_jButtonAddCompanyTagActionPerformed

    private void jButtonAddDateTagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddDateTagActionPerformed
        // swaps out the date tag
        this.adjustText(this.jTextArea1, DATE_TAG);
    }//GEN-LAST:event_jButtonAddDateTagActionPerformed

    private void jButtonAddBranchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddBranchActionPerformed
        // swaps out the branch tag
        this.adjustText(this.jTextArea1, BRANCH_TAG);
    }//GEN-LAST:event_jButtonAddBranchActionPerformed

    private void jButtonShiftTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonShiftTimeActionPerformed
        // swap out the shift time tag
        this.adjustText(jTextArea1, SHIFT_TIME_TAG);
    }//GEN-LAST:event_jButtonShiftTimeActionPerformed

    private void settingTemplate() {
        //done on exit of screen, passes the text back and disposes of the form
        String template = this.jTextArea1.getText().trim();
        this.myParent.setTemplate(template);
        this.dispose();
    }
    private void jButtonDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDoneActionPerformed
        this.settingTemplate();
    }//GEN-LAST:event_jButtonDoneActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // Save template action
        String tempName = JOptionPane.showInputDialog(this, "Please chose a template name");
        if (tempName != null && tempName.compareToIgnoreCase("") != 0) {
            //save name and sets template
            this.addTemplateToDb(tempName);
            this.settingTemplate();
        } else if (tempName != null) {
            //calls it self recursively on bad input
            JOptionPane.showMessageDialog(this, "Please Enter a Template Name");
            this.btnSaveActionPerformed(evt);
        } else {
            //cancel action
            JOptionPane.showMessageDialog(this, "Message Save is cancelled and will not be saved");
        }

    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        //explicitly closes thsi form
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void jButtonUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUserActionPerformed
        //swaps user tag
        this.adjustText(jTextArea1, USER_TAG);
    }//GEN-LAST:event_jButtonUserActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        // Delete template from combobox and DB
        Object o = this.comboBoxSavedTemplates.getSelectedItem();
        if (o instanceof Template) {
            Template t = (Template) o;
            if (t.getTemplateName().compareToIgnoreCase("") != 0) {
                this.comboBoxSavedTemplates.removeItem(t);
                this.comboBoxSavedTemplates.setSelectedIndex(0);
                this.removeFromDb(t);
            }
        }
    }//GEN-LAST:event_jButtonDeleteActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton jButtonAddBranch;
    private javax.swing.JButton jButtonAddCompanyTag;
    private javax.swing.JButton jButtonAddDateTag;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonDone;
    private javax.swing.JButton jButtonShiftTime;
    private javax.swing.JButton jButtonUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelCharCount;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelButtons;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void dispose() {
        //disposes of this screen and resets the other screen
        this.myParent.getMyParent().setVisible(true);
        this.myParent.getMyParent().setEnabled(true);
        try {
            this.myParent.getMyParent().setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Text_Messaging_Template.class.getName()).log(Level.SEVERE, null, ex);
        }
        super.dispose();
    }

    private void intialLoad(Text_Messaging parent) {
        //set intial settings of the form
        initComponents();
        this.myParent = parent;
        this.setSize(new Dimension(600, 300));
        this.setVisible(true);
        //adds grid constraint for combo box to be placed
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 0;
        c.weighty = 0;
        c.anchor = GridBagConstraints.NORTH;
        c.fill = GridBagConstraints.HORIZONTAL;
        this.jPanelButtons.add(this.comboBoxSavedTemplates, c);
        addTxtCharCount();
        this.comboBoxSavedTemplates.addItem(new Template());
        this.getTemplatesFromDB();

        this.comboBoxSavedTemplates.addItemListener(new ItemListener() {
            //add an anonymous actionlistener, to give delete button option

            public void itemStateChanged(ItemEvent e) {
                Object o = comboBoxSavedTemplates.getSelectedItem();
                if (o instanceof Template) {
                    Template n = (Template) comboBoxSavedTemplates.getSelectedItem();
                    jTextArea1.setText(n.getTemplate());
                    if (n.getTemplateName().compareToIgnoreCase("") == 0) {
                        jButtonDelete.setEnabled(false);
                    } else {
                        jButtonDelete.setEnabled(true);


                    }
                }
            }
        });

    }

    private void addTemplateToDb(String tempName) {
        //adds the template to the db
        AddTemplateQuery query = new AddTemplateQuery(tempName, this.jTextArea1.getText());
        this.myParent.getMyConnection().prepQuery(query);
        this.myParent.getMyConnection().executeQuery(query);
    }

    private void getTemplatesFromDB() {
        //grabs all the templates from the db
        GetSmsTemplates query = new GetSmsTemplates();
        this.myParent.getMyConnection().prepQuery(query);
        Record_Set rs = this.myParent.getMyConnection().executeQuery(query);
        // parses the result set out and creates appropiate dataObjects for templates
        do {
            String msg_sms_temp_id = rs.getString("message_sms_template_id");
            String msg_sms_type_id = rs.getString("message_sms_type_id");
            String msg_sms_name = rs.getString("message_sms_name");
            String msg_sms_txt = rs.getString("message_sms_text");

            Template temp = new Template(msg_sms_name, msg_sms_temp_id, msg_sms_type_id, msg_sms_txt);
            this.comboBoxSavedTemplates.addItem(temp);
        } while (rs.moveNext());
    }

    private void removeFromDb(Template t) {
        // remove selected Template form db
        RemoveTemplateFromDB query = new RemoveTemplateFromDB(t.getTemplate_db_id());
        this.myParent.getMyConnection().prepQuery(query);
        this.myParent.getMyConnection().executeQuery(query);
    }
    // End of variables declaration

    /**
     * Creates a document to handle char count and update a label
     */
    public class JTextFieldLimit extends PlainDocument {
        //var to determin limit of chars

        private int limit;

        private JTextFieldLimit() {
            //made the access modifier private so it would have to be called with an overloaded constructor
        }

        /**
         * OverLoaded PlainDocument with a parameter of max count
         * @param limit - max char for this document
         */
        public JTextFieldLimit(int limit) {
            //overloaded constructor sets the limit
            super();
            this.limit = limit;
        }

        @Override
        public void insertString(int offset, String str, AttributeSet attr)
                throws BadLocationException {
            if (str == null) {
                return;
            }
            //inserts chars if not over the limit
            if ((getLength() + str.length()) <= limit) {
                super.insertString(offset, str, attr);
            } else {
                JOptionPane.showMessageDialog(Main_Window.parentOfApplication.desktop, "Maximum characters is " + this.limit + " and has been reached");
            }
        }

        /**
         * 
         * @return Limit of chars in the associated TextField
         */
        public int getLimit() {
            return this.limit;
        }
    }

    private class MyDocumentListener implements DocumentListener {
        //LABEL TO BE UPDATED WITH CHAR COUNT

        private JLabel lblCharCount;

        public MyDocumentListener(JLabel lbl) {
            this.lblCharCount = lbl;
        }

        public void insertUpdate(DocumentEvent e) {
            //action to update label
            displayEditInfo(e);
        }

        public void removeUpdate(DocumentEvent e) {
            //action to update label
            displayEditInfo(e);
        }

        public void changedUpdate(DocumentEvent e) {
            //action to update label
            displayEditInfo(e);
        }

        private void displayEditInfo(DocumentEvent e) {
            //grabs doc associated and recalcs char count based on doc
            Document document = (Document) e.getDocument();
            this.lblCharCount.setText(Integer.toString(document.getLength()));
        }
    }
}
