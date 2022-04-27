/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.AirlineCompany;

import api.DB4oUtil.DB4OUtil;
import api.TravelSystem;
import api.employee.Employee;
import api.enterprise.Enterprise;
import api.organization.AirlineCompany;
import api.organization.Organization;
import api.property.Airplane;
import api.userAccount.UserAccount;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import ui.AirlineCompany.*;

/**
 *
 * @author Lynn Wei
 */
public class ShowPlaneJPanel extends javax.swing.JPanel {
    private javax.swing.JPanel userProcessContainer;
    private TravelSystem system;
    private Employee employee;
    private Organization origanization;
    
    public ShowPlaneJPanel(JPanel userProcessContainer, Employee employee, TravelSystem system, Organization origanization) {
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
        AirlineCompany airLineCompany = (AirlineCompany)origanization;
        List<Airplane> airplaneList = airLineCompany.getAirplaneList();
        for (Airplane airPlane : airplaneList) {
            Object[] row = new Object[5];
            row[0] = airPlane.getId();
            row[1] = airPlane.getType();
            row[2] = airPlane.getYear();
            row[3] = airPlane.getSeatNumber();
            model.addRow(row);
        }
    }
        
    public void initDate(Airplane airPlane){
        DefaultTableModel model = (DefaultTableModel) tblPlane.getModel();
        Object[] row = new Object[4];
        row[0] = airPlane.getId();
        row[1] = airPlane.getType();
        row[2] = airPlane.getYear();
        row[3] = airPlane.getSeatNumber();
        model.addRow(row);  
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
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitle1.setFont(new java.awt.Font("Gabriola", 1, 48)); // NOI18N
        lblTitle1.setText("Plane Information");
        add(lblTitle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, -1, -1));

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
                "Aircraft Id", "Aircraft Type", "Year", "Seats Number"
            }
        ));
        tblPlane.setRowHeight(30);
        jScrollPane1.setViewportView(tblPlane);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 800, 302));

        btnAdd.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        btnAdd.setText("Add Plane");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 520, 120, 50));

        btnView.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        btnView.setText("View Plane");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });
        add(btnView, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 520, 120, 50));

        btnDelete.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        btnDelete.setText("Delete Plane");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 520, 130, 50));

        lblTitle.setFont(new java.awt.Font("Gabriola", 1, 40)); // NOI18N
        lblTitle.setText("Airline Company:");
        add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, -1, -1));

        lblCompany.setFont(new java.awt.Font("Gabriola", 1, 40)); // NOI18N
        lblCompany.setText(origanization.getName());
        add(lblCompany, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, 540, 40));

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/AirlineCompany/Backbutton_3.png"))); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 60, 60));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/AirlineCompany/airplane3_1.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 40, 110, 50));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/AirlineCompany/man_1.png"))); // NOI18N
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 260, 320, 410));
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        // TODO add your handling code here:
        int i = tblPlane.getSelectedRow();
        if (i < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row.");
            return;
        }
        AirlineCompany airLineCompany = (AirlineCompany)origanization;
        List<Airplane> airplaneList = airLineCompany.getAirplaneList();
        UpdatePlaneJPanel rwajp = new UpdatePlaneJPanel(userProcessContainer, employee, system, origanization, airplaneList.get(i));
        userProcessContainer.add("AirlineCompanyPanel", rwajp);
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
        AirlineCompany airLineCompany = (AirlineCompany)origanization;
        List<Airplane> airplaneList = airLineCompany.getAirplaneList();
        airplaneList.remove(i);
        DefaultTableModel model = (DefaultTableModel) tblPlane.getModel();
        model.removeRow(i);
        DB4OUtil.getInstance().storeSystem(system);
        JOptionPane.showMessageDialog(null, "Information Deleted Succesfully!");
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        AddPlaneJPanel rwajp = new AddPlaneJPanel(userProcessContainer, employee, system, origanization);
        userProcessContainer.add("AddPlaneJPanel", rwajp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        AirlineCompanyPanel rwajp = new AirlineCompanyPanel(userProcessContainer, null, employee, system, origanization);
        userProcessContainer.add("AirlineCompanyPanel", rwajp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnView;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCompany;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitle1;
    private javax.swing.JTable tblPlane;
    // End of variables declaration//GEN-END:variables
}
