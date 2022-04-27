/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.captain;

import ui.AirlineCompany.*;
import api.TravelSystem;
import api.employee.Employee;
import api.organization.Organization;
import api.property.Airplane;
import api.request.Flight;
import api.userAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author 10857
 */
public class TrainCaptainPanel extends javax.swing.JPanel {

    /**
     * Creates new form AirlineCompanyPanel
     */
    private JPanel userProcessContainer;
    private TravelSystem system;
    private Employee employee;
    private Organization origanization;
    private Airplane airplane;
    private Flight flight;
    
    public TrainCaptainPanel(JPanel userProcessContainer, UserAccount user, Employee employee, TravelSystem system, Organization origanization) {
        this.system = system;
        this.employee = employee;
        this.origanization = origanization;
        this.userProcessContainer = userProcessContainer;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCompany = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        btnFlight = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCompany.setFont(new java.awt.Font("Gabriola", 0, 40)); // NOI18N
        lblCompany.setText(employee.getName());
        add(lblCompany, new org.netbeans.lib.awtextra.AbsoluteConstraints(444, 59, 302, -1));

        lblTitle.setFont(new java.awt.Font("Gabriola", 1, 40)); // NOI18N
        lblTitle.setText("Train Captain:");
        add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(218, 59, -1, -1));

        btnFlight.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        btnFlight.setText("My Train");
        btnFlight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFlightActionPerformed(evt);
            }
        });
        add(btnFlight, new org.netbeans.lib.awtextra.AbsoluteConstraints(242, 225, 471, 54));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/captain/phone.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 290, 530, 310));
    }// </editor-fold>//GEN-END:initComponents

    private void btnFlightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFlightActionPerformed
        // TODO add your handling code here:
        TraCapPanel aircapPanel = new TraCapPanel(userProcessContainer, employee, system, origanization);
        userProcessContainer.add("TraCapPanel",aircapPanel);
        CardLayout layout = (CardLayout)  userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnFlightActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFlight;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblCompany;
    private javax.swing.JLabel lblTitle;
    // End of variables declaration//GEN-END:variables
}