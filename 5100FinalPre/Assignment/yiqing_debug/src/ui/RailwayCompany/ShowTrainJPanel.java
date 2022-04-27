/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.RailwayCompany;

import java.awt.CardLayout;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import api.TravelSystem;
import api.DB4oUtil.DB4OUtil;
import api.employee.Employee;
import api.organization.Organization;
import api.organization.RailwayCompany;
import api.property.Train;
import ui.AirlineCompany.AddPlaneJPanel;

/**
 *
 * @author Lynn Wei
 */
public class ShowTrainJPanel extends javax.swing.JPanel {
    private javax.swing.JPanel userProcessContainer;
    private TravelSystem system;
    private Employee employee;
    private Organization origanization;
    
    public ShowTrainJPanel(JPanel userProcessContainer, Employee employee, TravelSystem system, Organization origanization) {
        this.system = system;
        this.employee = employee;
        this.origanization = origanization;
        this.userProcessContainer = userProcessContainer;
        initComponents();
        populateRequestTable();
    }
    
    private void populateRequestTable(){
        DefaultTableModel model = (DefaultTableModel) tblPlane.getModel();
        int size = model.getRowCount();
        for (int i = 0; i < size; i++) {
            model.removeRow(0);
        }
        RailwayCompany railwayCompany = (RailwayCompany)origanization;
        List<Train> trainList = railwayCompany.getTrainList();
        for (Train train : trainList) {
            // "Train Id", "Train Type", "Year", "Seats Number"
            Object[] row = new Object[5];
            row[0] = train.getId();
            row[1] = train.getType();
            row[2] = train.getYear();
            row[3] = train.getSeatNumber();
            model.addRow(row);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPlane = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnView = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        lblCompany = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitle1.setFont(new java.awt.Font("Gabriola", 1, 48)); // NOI18N
        lblTitle1.setText("Train Information");
        add(lblTitle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, -1, -1));

        tblPlane.setFont(new java.awt.Font("Gabriola", 0, 20)); // NOI18N
        tblPlane.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Train Id", "Train Type", "Year", "Seats Number"
            }
        ));
        tblPlane.setRowHeight(30);
        jScrollPane1.setViewportView(tblPlane);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 190, 710, 302));

        btnAdd.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        btnAdd.setText("Add Train");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 530, 153, -1));

        btnView.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        btnView.setText("View Train");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });
        add(btnView, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 530, 145, -1));

        btnDelete.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        btnDelete.setText("Delete Train");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 530, 151, -1));

        lblTitle.setFont(new java.awt.Font("Gabriola", 1, 40)); // NOI18N
        lblTitle.setText("Railway Company:");
        add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, -1, -1));

        lblCompany.setFont(new java.awt.Font("Gabriola", 1, 40)); // NOI18N
        lblCompany.setText(origanization.getName());
        add(lblCompany, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 120, 470, 50));

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/RailwayCompany/Backbutton_3.png"))); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 60, 50));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/RailwayCompany/littletrain_1.png"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, 140, 70));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/RailwayCompany/train2_1.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        // TODO add your handling code here:
        int i = tblPlane.getSelectedRow();
        if (i < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row.");
            return;
        }
        RailwayCompany railwayCompany = (RailwayCompany)origanization;
        List<Train> trainList = railwayCompany.getTrainList();
        UpdateTrainJPanel rwajp = new UpdateTrainJPanel(userProcessContainer, employee, 
            system, origanization, trainList.get(i));
        userProcessContainer.add("UpdateTrainJPanel", rwajp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnViewActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int i = tblPlane.getSelectedRow();
        if (i < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row.");
            return;
        }
        RailwayCompany railwayCompany = (RailwayCompany)origanization;
        List<Train> trainList = railwayCompany.getTrainList();
        trainList.remove(i);
        DefaultTableModel model = (DefaultTableModel) tblPlane.getModel();
        model.removeRow(i);
        DB4OUtil.getInstance().storeSystem(system);
        JOptionPane.showMessageDialog(null, "Information Deleted Succesfully!");
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        AddTrainJPanel rwajp = new AddTrainJPanel(userProcessContainer, employee, system, origanization);
        userProcessContainer.add("AddTrainJPanel", rwajp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        RailwayCompanyPanel showPlaneJPanel = new RailwayCompanyPanel(userProcessContainer, employee, system, origanization);
        userProcessContainer.add("RailwayCompanyPanel", showPlaneJPanel);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnView;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCompany;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitle1;
    private javax.swing.JTable tblPlane;
    // End of variables declaration//GEN-END:variables
}
