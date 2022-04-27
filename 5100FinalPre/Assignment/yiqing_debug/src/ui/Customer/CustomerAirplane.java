/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.Customer;

import api.TravelSystem;
import api.enterprise.Enterprise;
import api.organization.Organization;
import api.request.Flight;
import api.request.FlightTicket;
import api.request.request;
import api.userAccount.UserAccount;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 10857
 */
public class CustomerAirplane extends javax.swing.JPanel {

    /**
     * Creates new form CustomerAirplane
     */
    
    private TravelSystem system;
    private UserAccount account;
    private Organization organization;
    private double discount;
    
    public CustomerAirplane(TravelSystem system, UserAccount account, Organization organization) {
        initComponents();
        this.system = system;
        this.account = account;
        this.organization = organization;
        CbxOr.removeAllItems();
        for(Organization o : this.system.getEnterpriseDirectory().getEnterpriseList().get(2).getOrganizationDirectory().getOrganizationList()){
            CbxOr.addItem(o.getName());
        }
        CbxOr.addItem("Unlimited");
        CbxOr.setSelectedItem("Unlimited");
        if(this.account.getRole().getRole().equals("Customer")){
            this.discount = 1.0;
        }
        else{
            this.discount = 0.8;
        }
        this.populate();
    }
    
    
    public void populate(){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int rowNumber = model.getRowCount();
        for(int i = 0; i < rowNumber;i++){
            model.removeRow(0);
        }
        for(Organization o : this.system.getEnterpriseDirectory().getEnterpriseList().get(2).getOrganizationDirectory().getOrganizationList()){
            for(int i = 0; i < o.getRequestDirectory().getRequestList().size(); i++){
                if(o.getRequestDirectory().getRequestList().get(i).getType().equals("Normal")){
                    Flight f = (Flight)o.getRequestDirectory().getRequestList().get(i);
                    Object[] row = new Object[12];
                    row[0] = f.getId();
                    row[1] = f.getOrganizationId();
                    row[2] = f.getStartAirport();
                    row[3] = f.getEndAirport();
                    SimpleDateFormat ft = new SimpleDateFormat ("MM-dd HH:mm");
                    row[4] = ft.format(f.getStartDate());
                    row[5] = f.getEcoPrice() * this.discount;
                    row[6] = f.getRemainEco();
                    row[7] = f.getBusPrice() * this.discount;
                    row[8] = f.getRemainBus();
                    row[9] = f.getFirstPrice() * this.discount;
                    row[10] = f.getRemainFirst();
                    row[11] = f.getStatus();
                    model.addRow(row);
                }
            }
        }
    }
    
    
    public void populateByFilter(){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int rowNumber = model.getRowCount();
        for(int i = 0; i < rowNumber;i++){
            model.removeRow(0);
        }
        for(Organization o : this.system.getEnterpriseDirectory().getEnterpriseList().get(2).getOrganizationDirectory().getOrganizationList()){
            if(CbxOr.getSelectedItem().toString().equals("Unlimited") || CbxOr.getSelectedItem().toString().equals(o.getName())){
                for(int i = 0; i < o.getRequestDirectory().getRequestList().size(); i++){
                    if(o.getRequestDirectory().getRequestList().get(i).getType().equals("Normal") && o.getRequestDirectory().getRequestList().get(i).getStatus().equals("Not Started")){
                        Flight f = (Flight)o.getRequestDirectory().getRequestList().get(i);
                        if(((radioEco.isSelected()&&f.getRemainEco() > 0) || !radioEco.isSelected()) && ((radioBus.isSelected()&&f.getRemainBus() > 0) || !radioBus.isSelected())  && ((radioFirst.isSelected()&&f.getRemainFirst() > 0) || !radioFirst.isSelected())){
                            if((f.getStartAirport().contains(txtStart.getText()) || txtStart.getText().equals(""))  &&  (f.getEndAirport().contains(txtEnd.getText()) || txtEnd.getText().equals(""))){
                                Object[] row = new Object[12];
                                row[0] = f.getId();
                                row[1] = f.getOrganizationId();
                                row[2] = f.getStartAirport();
                                row[3] = f.getEndAirport();
                                SimpleDateFormat ft = new SimpleDateFormat ("MM-dd HH:mm");
                                row[4] = ft.format(f.getStartDate());
                                row[5] = f.getEcoPrice() * this.discount;
                                row[6] = f.getRemainEco();
                                row[7] = f.getBusPrice() * this.discount;
                                row[8] = f.getRemainBus();
                                row[9] = f.getFirstPrice() * this.discount;
                                row[10] = f.getRemainFirst();
                                row[11] = f.getStatus();
                                model.addRow(row);
                            }
                        }
                    }
                }
            }
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        CbxOr = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        radioEco = new javax.swing.JRadioButton();
        radioBus = new javax.swing.JRadioButton();
        radioFirst = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        txtStart = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtEnd = new javax.swing.JTextField();
        search = new javax.swing.JButton();
        BuyTicket = new javax.swing.JButton();
        txtNumber = new javax.swing.JTextField();
        Number = new javax.swing.JLabel();
        CbxType = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Gabriola", 1, 40)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Airplane");

        table.setFont(new java.awt.Font("Gabriola", 0, 20)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "FlightId", "Company", "Start", "End", "Date", "EcoPrice", "EcoRemain", "BusPrice", "BusRemain", "FirstPrice", "FirstRemain", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);

        CbxOr.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        CbxOr.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        jLabel2.setText("Organization: ");

        radioEco.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        radioEco.setText("haveRemainEcoTicket");

        radioBus.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        radioBus.setText("haveRemainBusTicket");

        radioFirst.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        radioFirst.setText("haveRemainFirstTicket");

        jLabel6.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        jLabel6.setText("Start: ");

        txtStart.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        jLabel7.setText("End: ");

        txtEnd.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        txtEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEndActionPerformed(evt);
            }
        });

        search.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        search.setText("Search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        BuyTicket.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        BuyTicket.setText("Buy");
        BuyTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuyTicketActionPerformed(evt);
            }
        });

        txtNumber.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        txtNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumberActionPerformed(evt);
            }
        });

        Number.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        Number.setText("Number: ");

        CbxType.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        CbxType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Economy", "Bussiness", "First" }));

        jLabel4.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        jLabel4.setText("Ticket Type: ");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/Customer/customer1_副本.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel6)
                                        .addGap(25, 25, 25)
                                        .addComponent(txtStart, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(41, 41, 41)
                                        .addComponent(jLabel7)
                                        .addGap(13, 13, 13)
                                        .addComponent(txtEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(11, 11, 11)
                                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addGap(36, 36, 36)
                                                .addComponent(CbxOr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(radioEco))
                                        .addGap(4, 4, 4)
                                        .addComponent(radioBus)
                                        .addGap(50, 50, 50)
                                        .addComponent(radioFirst))
                                    .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel4)
                                        .addGap(44, 44, 44)
                                        .addComponent(CbxType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(8, 8, 8)
                                        .addComponent(Number)
                                        .addGap(8, 8, 8)
                                        .addComponent(txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(15, 15, 15)
                                        .addComponent(BuyTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(189, 189, 189)))
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(CbxOr, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(9, 9, 9)
                                .addComponent(radioEco, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(radioBus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(radioFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(txtStart, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(CbxType, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(Number, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(BuyTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEndActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEndActionPerformed

    private void txtNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumberActionPerformed

    private void BuyTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuyTicketActionPerformed
        // TODO add your handling code here:
        if(table.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this,"please select a Flight");
        }
        else{
            int row = table.getSelectedRow();
            if(txtNumber.getText().matches("^[0-9]+$")){
                for(Organization o : this.system.getEnterpriseDirectory().getEnterpriseList().get(2).getOrganizationDirectory().getOrganizationList()){
                    if(o.getId().equals(table.getValueAt(row, 1).toString())){
                        for(int i = 0; i < o.getRequestDirectory().getRequestList().size(); i++){
                            if(o.getRequestDirectory().getRequestList().get(i).getId() == Integer.valueOf(table.getValueAt(row, 0).toString())
                                        &&o.getRequestDirectory().getRequestList().get(i).getStatus().equals("Not Started")){
                                Flight f = (Flight)o.getRequestDirectory().getRequestList().get(i);
                                if(CbxType.getSelectedItem().equals("Economy") && f.getRemainEco() < Integer.valueOf(txtNumber.getText())){
                                    JOptionPane.showMessageDialog(this,"Economy Seats Not Enough");
                                }
                                else if(CbxType.getSelectedItem().equals("Bussiness") && f.getRemainBus() < Integer.valueOf(txtNumber.getText())){
                                    JOptionPane.showMessageDialog(this,"Bussiness Seats Not Enough");
                                }
                                else if(CbxType.getSelectedItem().equals("First") && f.getRemainFirst() < Integer.valueOf(txtNumber.getText())){
                                    JOptionPane.showMessageDialog(this,"First Seats Not Enough");
                                }
                                else{
                                    String Type = "FlightTicket" + CbxType.getSelectedItem();
                                    SimpleDateFormat df = new SimpleDateFormat ("MM-dd HH:mm");
                                    Date sDate = new Date();
                                    FlightTicket ft = new FlightTicket(String.valueOf(this.account.getId()), o.getId(),Type,"Not Started",sDate, null, o.getRequestDirectory().getRequestList().size() + 1);
                                    Double price = null;
                                    int number = Integer.valueOf(txtNumber.getText());
                                    if(CbxType.getSelectedItem().equals("Economy")){
                                        f.setRemainEco(f.getRemainEco() - number);
                                        price = f.getEcoPrice() * this.discount;
                                    }
                                    else if(CbxType.getSelectedItem().equals("Bussiness")){
                                        f.setRemainBus(f.getRemainBus() - number);
                                        price = f.getBusPrice() * this.discount;
                                    }
                                    else{
                                        f.setRemainFirst(f.getRemainFirst() - number);
                                        price = f.getFirstPrice() * this.discount;
                                    }
                                    ft.setFlightTicket(Integer.valueOf(table.getValueAt(row, 0).toString()), number, number * price);
                                    account.getRequestDirectory().addRequest(ft);
                                    o.getRequestDirectory().addRequest(ft);
                                    if(account.getRole().getRole().equals("VIPCustomer")){
                                        this.populateByFilter();
                                    }
                                    else{
                                        this.populate();
                                    }
                                    JOptionPane.showMessageDialog(this,"Buy success");
                                }
                            }
                        }
                    }
                }
            }
            else{
                JOptionPane.showMessageDialog(this,"please input valid number");
            }
        }
    }//GEN-LAST:event_BuyTicketActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
        if(account.getRole().getRole().equals("VIPCustomer")){
            this.populateByFilter();
        }
        else{
            JOptionPane.showMessageDialog(this,"You can charge to VIP to unlock this function");
        }
    }//GEN-LAST:event_searchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BuyTicket;
    private javax.swing.JComboBox<String> CbxOr;
    private javax.swing.JComboBox<String> CbxType;
    private javax.swing.JLabel Number;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton radioBus;
    private javax.swing.JRadioButton radioEco;
    private javax.swing.JRadioButton radioFirst;
    private javax.swing.JButton search;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtEnd;
    private javax.swing.JTextField txtNumber;
    private javax.swing.JTextField txtStart;
    // End of variables declaration//GEN-END:variables
}
