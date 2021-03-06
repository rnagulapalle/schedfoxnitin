/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmischedule.event_log;

import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import javax.swing.table.AbstractTableModel;
import rmischedule.components.jcalendar.JCalendarComboBox;
import rmischeduleserver.control.ClientController;
import rmischeduleserver.control.EmployeeController;
import rmischeduleserver.control.ScheduleController;
import schedfoxlib.model.Client;
import schedfoxlib.model.Employee;
import schedfoxlib.model.ScheduleData;

/**
 *
 * @author ira
 */
public class EventSearchShiftsDialog extends javax.swing.JDialog {

    private JCalendarComboBox begCal;
    private JCalendarComboBox endCal;
    
    private String companyId;
    private Integer employeeId;
    
    private HashMap<Integer, Client> clientsHash = new HashMap<Integer, Client>();
    private HashMap<Integer, Employee> employeesHash = new HashMap<Integer, Employee>();
    
    private ScheduleTableModel scheduleTableModel = new ScheduleTableModel();
    
    private ScheduleData scheduleData;

    /**
     * Creates new form EventSearchShiftsDialog
     */
    public EventSearchShiftsDialog(java.awt.Frame parent, boolean modal, String companyId, Integer employeeId, Integer clientId, ArrayList<Integer> branchIds) {
        super(parent, modal);
        initComponents();

        this.companyId = companyId;
        this.employeeId = employeeId;
        
        Calendar startCal = Calendar.getInstance();
        startCal.add(Calendar.DAY_OF_YEAR, -7);

        begCal = new JCalendarComboBox();
        begCal.setCalendar(startCal);
        begCal.setMinimumSize(new Dimension(140, 30));
        begCal.setMaximumSize(new Dimension(140, 30));
        begCal.setPreferredSize(new Dimension(140, 30));
        startPanel.add(begCal);

        endCal = new JCalendarComboBox();
        endCal.setMinimumSize(new Dimension(140, 30));
        endCal.setMaximumSize(new Dimension(140, 30));
        endCal.setPreferredSize(new Dimension(140, 30));
        endPanel.add(endCal);

        try {
            ClientController clientController = ClientController.getInstance(companyId);
            ArrayList<Client> clients = clientController.getClientsByBranch(branchIds);
            Client allClient = new Client();
            allClient.setClientName("All Clients");
            clientCombo.addItem(allClient);
            for (int c = 0; c < clients.size(); c++) {
                clientCombo.addItem(clients.get(c));
                clientsHash.put(clients.get(c).getClientId(), clients.get(c));
                if (clientId != null && clients.get(c).getClientId().equals(clientId)) {
                    clientCombo.setSelectedItem(clients.get(c));
                }
            }
        } catch (Exception exe) {
        }

        try {
            EmployeeController employeeController = EmployeeController.getInstance(companyId);
            ArrayList<Employee> employees = employeeController.getAllActiveEmployeesByBranch(branchIds);
            Employee allEmployee = new Employee();
            allEmployee.setEmployeeFirstName("All");
            allEmployee.setEmployeeLastName("Employees");
            employeeCombo.addItem(allEmployee);
            for (int e = 0; e < employees.size(); e++) {
                employeeCombo.addItem(employees.get(e));
                employeesHash.put(employees.get(e).getEmployeeId(), employees.get(e));
                if (employeeId != null && employees.get(e).getEmployeeId().equals(employeeId)) {
                    employeeCombo.setSelectedItem(employees.get(e));
                }
            }
        } catch (Exception exe) {
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        startPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        employeeCombo = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        endPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        clientCombo = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        searchShiftBtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        scheduleTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        setScheduleBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        startPanel.setMaximumSize(new java.awt.Dimension(32767, 35));
        startPanel.setMinimumSize(new java.awt.Dimension(100, 35));
        startPanel.setPreferredSize(new java.awt.Dimension(451, 35));
        startPanel.setLayout(new javax.swing.BoxLayout(startPanel, javax.swing.BoxLayout.LINE_AXIS));

        jLabel1.setText("Employee");
        jLabel1.setMaximumSize(new java.awt.Dimension(70, 16));
        jLabel1.setMinimumSize(new java.awt.Dimension(70, 16));
        jLabel1.setName(""); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(70, 16));
        startPanel.add(jLabel1);

        employeeCombo.setMaximumSize(new java.awt.Dimension(260, 32767));
        employeeCombo.setMinimumSize(new java.awt.Dimension(260, 22));
        employeeCombo.setPreferredSize(new java.awt.Dimension(260, 22));
        startPanel.add(employeeCombo);

        jLabel3.setText("Start Date");
        jLabel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 3, 0, 0));
        jLabel3.setMaximumSize(new java.awt.Dimension(80, 16));
        jLabel3.setMinimumSize(new java.awt.Dimension(80, 16));
        jLabel3.setPreferredSize(new java.awt.Dimension(80, 16));
        startPanel.add(jLabel3);

        getContentPane().add(startPanel);

        endPanel.setMaximumSize(new java.awt.Dimension(32767, 35));
        endPanel.setMinimumSize(new java.awt.Dimension(100, 35));
        endPanel.setPreferredSize(new java.awt.Dimension(451, 35));
        endPanel.setLayout(new javax.swing.BoxLayout(endPanel, javax.swing.BoxLayout.LINE_AXIS));

        jLabel2.setText("Client");
        jLabel2.setMaximumSize(new java.awt.Dimension(70, 16));
        jLabel2.setMinimumSize(new java.awt.Dimension(70, 16));
        jLabel2.setPreferredSize(new java.awt.Dimension(70, 16));
        endPanel.add(jLabel2);

        clientCombo.setMaximumSize(new java.awt.Dimension(260, 32767));
        clientCombo.setMinimumSize(new java.awt.Dimension(260, 22));
        clientCombo.setPreferredSize(new java.awt.Dimension(260, 22));
        endPanel.add(clientCombo);

        jLabel4.setText("End Date");
        jLabel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 3, 0, 0));
        jLabel4.setMaximumSize(new java.awt.Dimension(80, 16));
        jLabel4.setMinimumSize(new java.awt.Dimension(80, 16));
        jLabel4.setPreferredSize(new java.awt.Dimension(80, 16));
        endPanel.add(jLabel4);

        getContentPane().add(endPanel);

        jPanel1.setMaximumSize(new java.awt.Dimension(32767, 35));
        jPanel1.setMinimumSize(new java.awt.Dimension(0, 35));
        jPanel1.setPreferredSize(new java.awt.Dimension(575, 35));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 0, 4));

        searchShiftBtn.setText("Search Shifts");
        searchShiftBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchShiftBtnActionPerformed(evt);
            }
        });
        jPanel1.add(searchShiftBtn);

        getContentPane().add(jPanel1);

        jPanel3.setLayout(new java.awt.GridLayout());

        scheduleTable.setModel(scheduleTableModel);
        jScrollPane1.setViewportView(scheduleTable);

        jPanel3.add(jScrollPane1);

        getContentPane().add(jPanel3);

        jPanel2.setMaximumSize(new java.awt.Dimension(32767, 35));
        jPanel2.setMinimumSize(new java.awt.Dimension(0, 35));
        jPanel2.setPreferredSize(new java.awt.Dimension(592, 35));
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 0, 5));

        setScheduleBtn.setText("Set Schedule");
        setScheduleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setScheduleBtnActionPerformed(evt);
            }
        });
        jPanel2.add(setScheduleBtn);

        getContentPane().add(jPanel2);

        setSize(new java.awt.Dimension(610, 361));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void searchShiftBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchShiftBtnActionPerformed
        Employee emp = (Employee)employeeCombo.getSelectedItem();
        Client cli = (Client)clientCombo.getSelectedItem();
        try {
            if (cli.getClientId() == null) {
                cli = null;
            }
            if (emp.getEmployeeId() == null) {
                emp = null;
            }
            ScheduleController schedController = new ScheduleController(companyId);
            ArrayList<ScheduleData> schedules = schedController.getSchedule(begCal.getCalendar().getTime(), endCal.getCalendar().getTime(), emp, cli);
            scheduleTableModel.setSchedules(schedules);
        } catch (Exception exe) {
            exe.printStackTrace();
        }
        
    }//GEN-LAST:event_searchShiftBtnActionPerformed

    private void setScheduleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setScheduleBtnActionPerformed
        this.scheduleData = this.scheduleTableModel.getScheduleData(scheduleTable.getSelectedRow());
        this.dispose();
    }//GEN-LAST:event_setScheduleBtnActionPerformed

    /**
     * @return the scheduleData
     */
    public ScheduleData getScheduleData() {
        return scheduleData;
    }

    /**
     * @param scheduleData the scheduleData to set
     */
    public void setScheduleData(ScheduleData scheduleData) {
        this.scheduleData = scheduleData;
    }

    private class ScheduleTableModel extends AbstractTableModel {

        private ArrayList<ScheduleData> schedules;
        private SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        
        public ScheduleTableModel() {
            schedules = new ArrayList<ScheduleData>();
        }
        
        @Override
        public int getRowCount() {
            return schedules.size();
        }

        @Override
        public int getColumnCount() {
            return 5;
        }
        
        public ScheduleData getScheduleData(int row) {
            return schedules.get(row);
        }
        
        public void setSchedules(ArrayList<ScheduleData> sched) {
            schedules = sched;
            super.fireTableDataChanged();
        }
        
        public String getColumnName(int columnIndex) {
            if (columnIndex == 0) {
                return "Client";
            } else if (columnIndex == 1) {
                return "Employee";
            } else if (columnIndex == 2) {
                return "Date";
            } else if (columnIndex == 3) {
                return "Start Time";
            } else {
                return "End Time";
            }
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            if (columnIndex == 0) {
                try {
                    return clientsHash.get(schedules.get(rowIndex).getClientId()).getClientName();
                } catch (Exception exe) {}
            } else if (columnIndex == 1) {
                try {
                    return employeesHash.get(schedules.get(rowIndex).getEmployeeId()).getEmployeeFullName();
                } catch (Exception exe) {}
            } else if (columnIndex == 2) {
                try {
                    return dateFormat.format(schedules.get(rowIndex).getDate());
                } catch (Exception exe) {}
            } else if (columnIndex == 3) {
                return schedules.get(rowIndex).getStartTimeStr();
            } else {
                return schedules.get(rowIndex).getEndTimeStr();
            }
            
            return "";
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox clientCombo;
    private javax.swing.JComboBox employeeCombo;
    private javax.swing.JPanel endPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable scheduleTable;
    private javax.swing.JButton searchShiftBtn;
    private javax.swing.JButton setScheduleBtn;
    private javax.swing.JPanel startPanel;
    // End of variables declaration//GEN-END:variables
}
