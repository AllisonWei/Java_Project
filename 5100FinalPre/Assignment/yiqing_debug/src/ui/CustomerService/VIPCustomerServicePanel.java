/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.CustomerService;

import java.awt.CardLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import api.TravelSystem;
import api.DB4oUtil.DB4OUtil;
import api.employee.Employee;
import api.organization.AirlineCompany;
import api.organization.Organization;
import api.organization.RailwayCompany;
import api.request.Flight;
import api.request.FlightTicket;
import api.request.TrainLine;
import api.request.TrainTicket;
import api.request.VIPComment;
import api.request.request;
import api.userAccount.UserAccount;

/**
 *
 * @author 10857
 */
public class VIPCustomerServicePanel extends javax.swing.JPanel {
    private JPanel userProcessContainer;
    private TravelSystem system;
    private Employee employee;
    private Organization origanization;
    private UserAccount user;
    
    private List<request> ticketRequests = new ArrayList<>();
    private List<request> ticketVipRequests = new ArrayList<>();
    private List<request> commentVipRequests = new ArrayList<>();
    
    public VIPCustomerServicePanel(UserAccount user, Employee em,TravelSystem system, Organization o) {
        initComponents();
        this.user = user;
        this.system = system;
        this.employee = em;
        this.origanization = o;
    }
    
    public VIPCustomerServicePanel(JPanel userProcessContainer, Employee employee, TravelSystem system, Organization origanization) {
        this.system = system;
        this.employee = employee;
        this.origanization = origanization;
        this.userProcessContainer = userProcessContainer;
        initComponents();
        populateRequestTable1();
        populateRequestTable2();
        populateRequestTable3();
    }
    
    private void populateRequestTable1(){
        // TrainTicket
        if (origanization instanceof AirlineCompany) {
            getTicketList("FlightTicket");
        } else if (origanization instanceof RailwayCompany) {
            getTicketList("TrainTicket");
        }
        addInitRowData();
    }
    
    private void getTicketList(String type) {
        List<UserAccount> userAccountList = origanization.getUserAccountDirectory().getUserAccountList();
        for (UserAccount userAccount : userAccountList) {
            if (!userAccount.getRole().getRole().equals("VIPCustomer")) {
                continue;
            }
            List<request> requests = userAccount.getRequestDirectory().getRequestList();
            for (request request : requests) {
                    if (!request.getType().startsWith(type)) {
                         continue;
                    }
                    ticketRequests.add(request);
                }     
            }
        }
    
    private void getTicketVipList() {
        List<request> requests = origanization.getRequestDirectory().getRequestList();
        for (request request : requests) {
            // "Id", "requestPersonID", "Type", "Status"
            if (!"VIP".equals(request.getType())) {
                continue;
            }
            ticketVipRequests.add(request);
        }
    }
    
    private void getVipComment(){
        List<request> requests = origanization.getRequestDirectory().getRequestList();
        for (request request : requests){
            if(!"VIPComment".equals(request.getType())){
                continue;
            }
            commentVipRequests.add(request);
        }
    }
    
    private void addInitRowData() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int size = model.getRowCount();
        for (int i = 0; i < size; i++) {
            model.removeRow(0);
        }
        for (request request : ticketRequests) {
            Object[] row = new Object[6];
            row[0] = request.getId();
            row[1] = request.getRequestPersonId();
            row[2] = request.getType();
            row[3] = request.getStatus();
            SimpleDateFormat sdf = new SimpleDateFormat("MM-dd HH:mm");
            row[4] = request.getStartDate()== null ? "" : sdf.format(request.getStartDate());
            row[5] = request.getEndDate() == null ? "" : sdf.format(request.getEndDate());    
            model.addRow(row);
        }
    }
    
    private void populateRequestTable2(){
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        int size = model.getRowCount();
        for (int i = 0; i < size; i++) {
            model.removeRow(0);
        }
        getTicketVipList();
        for (request request : ticketVipRequests) {
            Object[] row = new Object[4];
            row[0] = request.getId();
            row[1] = request.getRequestPersonId();
            row[2] = request.getType();
            row[3] = request.getStatus();
            model.addRow(row);
        }
    }
     private void populateRequestTable3() {
        DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
        int size = model.getRowCount();
        for (int i = 0; i < size; i++) {
            model.removeRow(0);
        }
        getVipComment();
        for (request request : commentVipRequests){
             Object[] row = new Object[4];
            row[0] = request.getId();
            row[1] = request.getRequestPersonId();
            SimpleDateFormat sdf = new SimpleDateFormat("MM-dd HH:mm");
            row[2] = request.getStartDate() == null ? "" : sdf.format(request.getStartDate());
            row[3] = request.getEndDate() == null ? "" : sdf.format(request.getEndDate());     
            model.addRow(row);
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

        lblTitle = new javax.swing.JLabel();
        btnApprove = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnProcess = new javax.swing.JButton();
        btnTicketsDetails = new javax.swing.JButton();
        lblTitle1 = new javax.swing.JLabel();
        lblCompany = new javax.swing.JLabel();
        btnRequestDetail = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        btnCommentDetails = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnProcess1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitle.setFont(new java.awt.Font("Gabriola", 1, 30)); // NOI18N
        lblTitle.setText("VIP Customer Service");
        add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 359, -1));

        btnApprove.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        btnApprove.setText("Approve");
        btnApprove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApproveActionPerformed(evt);
            }
        });
        add(btnApprove, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 600, 190, 30));

        jTable1.setFont(new java.awt.Font("Gabriola", 0, 20)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Request Person Id", "Type", "Status", "Start Date", "End Date"
            }
        ));
        jTable1.setRowHeight(30);
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 1030, 100));

        btnProcess.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        btnProcess.setText("Process");
        btnProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessActionPerformed(evt);
            }
        });
        add(btnProcess, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 280, 140, 30));

        btnTicketsDetails.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        btnTicketsDetails.setText("Tickets Details");
        btnTicketsDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTicketsDetailsActionPerformed(evt);
            }
        });
        add(btnTicketsDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, 191, 30));

        lblTitle1.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        lblTitle1.setText("Service Company:");
        add(lblTitle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 59, -1, -1));

        lblCompany.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        lblCompany.setText(origanization.getName());
        add(lblCompany, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 245, 30));

        btnRequestDetail.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        btnRequestDetail.setText("Request Detail");
        btnRequestDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestDetailActionPerformed(evt);
            }
        });
        add(btnRequestDetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 600, 200, 30));

        btnCancel.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 600, 190, 30));

        jTable2.setFont(new java.awt.Font("Gabriola", 0, 20)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "requestPersonID", "Type", "Status"
            }
        ));
        jTable2.setRowHeight(30);
        jScrollPane2.setViewportView(jTable2);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 520, 1020, 70));

        jTable3.setFont(new java.awt.Font("Gabriola", 0, 20)); // NOI18N
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "requestPersonId", "startDate", "endDate"
            }
        ));
        jTable3.setRowHeight(30);
        jScrollPane3.setViewportView(jTable3);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 1020, 100));

        btnCommentDetails.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        btnCommentDetails.setText("Comment Details");
        btnCommentDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCommentDetailsActionPerformed(evt);
            }
        });
        add(btnCommentDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 450, -1, 30));

        jLabel1.setFont(new java.awt.Font("Gabriola", 1, 24)); // NOI18N
        jLabel1.setText("Tickets:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 94, 26));

        jLabel2.setFont(new java.awt.Font("Gabriola", 1, 24)); // NOI18N
        jLabel2.setText("Flight/TrainLine Request:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 480, 410, 35));

        jLabel3.setFont(new java.awt.Font("Gabriola", 1, 24)); // NOI18N
        jLabel3.setText("VIP Comment:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 177, 35));

        btnProcess1.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        btnProcess1.setText("Process");
        btnProcess1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcess1ActionPerformed(evt);
            }
        });
        add(btnProcess1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 450, 140, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/CustomerService/train3_1.png"))); // NOI18N
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 0, 300, 170));
    }// </editor-fold>//GEN-END:initComponents

    private void btnRequestDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestDetailActionPerformed
        // TODO add your handling code here:
        int i = jTable2.getSelectedRow();
        if (i < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row.");
            return;
        }
        if (origanization instanceof AirlineCompany) {
            FlightRequestJPanel showPlaneJPanel = new FlightRequestJPanel(userProcessContainer, employee, system, origanization,
                (Flight)ticketVipRequests.get(i));
            userProcessContainer.add("FlightRequestJPanel", showPlaneJPanel);
            CardLayout layout = (CardLayout)userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        } else if (origanization instanceof RailwayCompany) {
            TrainRequestJPanel showPlaneJPanel = new TrainRequestJPanel(userProcessContainer, employee, system, origanization,
                (TrainLine)ticketVipRequests.get(i));
            userProcessContainer.add("TrainRequestJPanel", showPlaneJPanel);
            CardLayout layout = (CardLayout)userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }
    }//GEN-LAST:event_btnRequestDetailActionPerformed

    private void btnTicketsDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTicketsDetailsActionPerformed
        // TODO add your handling code here:
        int i = jTable1.getSelectedRow();
        if (i < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row.");
            return;
        }
        if (origanization instanceof AirlineCompany) {
            DetailAirCustomerJPanel showPlaneJPanel = new DetailAirCustomerJPanel(userProcessContainer, employee, system, origanization,
                (FlightTicket)ticketRequests.get(i));
            userProcessContainer.add("DetailAirCustomerJPanel", showPlaneJPanel);
            CardLayout layout = (CardLayout)userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        } else if (origanization instanceof RailwayCompany) {
            DetailTrainCustomerJPanel showPlaneJPanel = new DetailTrainCustomerJPanel(userProcessContainer, employee, system, origanization,
                (TrainTicket)ticketRequests.get(i));
            userProcessContainer.add("DetailTrainCustomerJPanel", showPlaneJPanel);
            CardLayout layout = (CardLayout)userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }
    }//GEN-LAST:event_btnTicketsDetailsActionPerformed

    private void btnProcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessActionPerformed
        // TODO add your handling code here:
        int i = jTable1.getSelectedRow();
        if (i < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row.");
            return;
        }
        request request = ticketRequests.get(i);
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd HH:mm");
        Date now = new Date();
        request.setEndDate(now);
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setValueAt(sdf.format(now), i, 5);
        DB4OUtil.getInstance().storeSystem(system);
        JOptionPane.showMessageDialog(null, "Information Process Succesfully!");
    }//GEN-LAST:event_btnProcessActionPerformed

    private void btnApproveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApproveActionPerformed
        // TODO add your handling code here:
        // aprove  Unsolved -> Approved
        int i = jTable2.getSelectedRow();
        if (i < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row.");
            return;
        }
        request request = ticketVipRequests.get(i);
        if (!"Unsolved".equals(request.getStatus())) {
            JOptionPane.showMessageDialog(null, "The row status is not Unsolved.");
            return;
        }
        request.setStatus("Not Started");
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setValueAt(request.getStatus(),i,3);
        DB4OUtil.getInstance().storeSystem(system);
        JOptionPane.showMessageDialog(null, "Information Approved Succesfully!");
    }//GEN-LAST:event_btnApproveActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        // cancel Unsolved -> Canceled
        int i = jTable2.getSelectedRow();
        if (i < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row.");
            return;
        }
        request request = ticketVipRequests.get(i);
        if (!"Unsolved".equals(request.getStatus())) {
            JOptionPane.showMessageDialog(null, "The row status is not Unsolved.");
            return;
        }
        request.setStatus("Canceled");
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setValueAt(request.getStatus(),i,3);
        DB4OUtil.getInstance().storeSystem(system);
        JOptionPane.showMessageDialog(null, "Information Canceled Succesfully!");
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnCommentDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCommentDetailsActionPerformed
        // TODO add your handling code here:
        int i = jTable3.getSelectedRow();
        if (i < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row.");
            return;
        }
        if (origanization instanceof AirlineCompany || origanization instanceof RailwayCompany) {
            CommentVIPJPanel cv = new CommentVIPJPanel(userProcessContainer, employee, system, origanization,
            (VIPComment) commentVipRequests.get(i));
            userProcessContainer.add("CommentVIPJPanel", cv);
            CardLayout layout = (CardLayout)userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        } 
    }//GEN-LAST:event_btnCommentDetailsActionPerformed

    private void btnProcess1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcess1ActionPerformed
        int i = jTable3.getSelectedRow();
        if (i < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row.");
            return;
        }
        request request = commentVipRequests.get(i);
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd HH:mm");
        Date now = new Date();
        request.setEndDate(now);
        DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
        model.setValueAt(sdf.format(now), i, 3);
        DB4OUtil.getInstance().storeSystem(system);
        JOptionPane.showMessageDialog(null, "Information Process Succesfully!");
    }//GEN-LAST:event_btnProcess1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApprove;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCommentDetails;
    private javax.swing.JButton btnProcess;
    private javax.swing.JButton btnProcess1;
    private javax.swing.JButton btnRequestDetail;
    private javax.swing.JButton btnTicketsDetails;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JLabel lblCompany;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitle1;
    // End of variables declaration//GEN-END:variables

   
}
