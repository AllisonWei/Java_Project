/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.Customer;

import api.TravelSystem;
import api.organization.Organization;
import api.property.Train;
import api.request.Flight;
import api.request.FlightTicket;
import api.request.TrainLine;
import api.request.TrainTicket;
import api.userAccount.UserAccount;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 10857
 */
public class CustomerTrain extends javax.swing.JPanel {

    /**
     * Creates new form CustomerTrain
     */
    private TravelSystem system;
    private UserAccount account;
    private Organization organization;
    private double discount;
    
    public CustomerTrain(TravelSystem system, UserAccount account, Organization organization) {
        initComponents();
        this.system = system;
        this.account = account;
        this.organization = organization;
        
        CbxOr.removeAllItems();
        for(Organization o : this.system.getEnterpriseDirectory().getEnterpriseList().get(3).getOrganizationDirectory().getOrganizationList()){
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
        for(Organization o : this.system.getEnterpriseDirectory().getEnterpriseList().get(3).getOrganizationDirectory().getOrganizationList()){
            if(CbxOr.getSelectedItem().toString().equals("Unlimited") || CbxOr.getSelectedItem().toString().equals(o.getName()) || account.getRole().getRole().equals("Customer")){
                for(int i = 0; i < o.getRequestDirectory().getRequestList().size(); i++){
                    if(o.getRequestDirectory().getRequestList().get(i).getType().equals("Normal") ){
                        TrainLine t = (TrainLine)o.getRequestDirectory().getRequestList().get(i);
                        if(this.isMatchFilter(t) || account.getRole().getRole().equals("Customer")){
                            Object[] row = new Object[15];
                            row[0] = t.getId();
                            row[1] = t.getOrganizationId();
                            row[2] = t.getStationList().get(0);
                            row[3] = "";
                            if(t.getStationList().size() > 2){
                                for(int j = 1; j < t.getStationList().size() - 1; j++){
                                    row[3] = row[3] + t.getStationList().get(j) + " ";
                                }
                            }
                            else{
                                row[3] = "None";
                            }
                            row[4] = t.getStationList().get(t.getStationList().size() - 1);
                            SimpleDateFormat ft = new SimpleDateFormat ("MM-dd HH:mm");
                            row[5] = ft.format(t.getStartDate());
                            row[6] = t.getSecondSeatPrice() * this.discount;
                            row[7] = t.getRemainSecondSeat();
                            row[8] = t.getFirstSeatPrice() * this.discount;
                            row[9] = t.getRemainFirstSeat();
                            row[10] = t.getSleeperPrice() * this.discount;
                            row[11] = t.getRemainSleeper();
                            row[12] = t.getFirstSleeperPrice() * this.discount;
                            row[13] = t.getRemainFirstSleeper();
                            row[14] = t.getStatus();
                            model.addRow(row);
                        }
                    }
                }
            }
        }
    }
    
    
    public Boolean isMatchFilter(TrainLine t){
        if(((radioSecond.isSelected()&&t.getRemainSecondSeat() > 0) || !radioSecond.isSelected()) && ((radioFirst.isSelected()&&t.getRemainFirstSeat() > 0) || !radioFirst.isSelected())  && ((radioSleeper.isSelected()&&t.getRemainSleeper() > 0) || !radioSleeper.isSelected())  && ((radioFirstSleeper.isSelected()&&t.getRemainFirstSleeper() > 0) || !radioFirstSleeper.isSelected())){
            if((t.getStationList().get(0).contains(txtStart.getText()) || txtStart.getText().equals(""))  &&  (t.getStationList().get(t.getStationList().size() - 1).contains(txtEnd.getText()) || txtEnd.getText().equals(""))){
                if(t.getStationList().size() == 2 && !txtPass.getText().equals("")){
                    return false;
                }
                else{
                    for(int j = 1; j < t.getStationList().size() - 1; j++){
                        if(t.getStationList().get(j).contains(txtPass.getText()) || txtPass.getText().equals("")){
                            return true;
                        }
                        else{
                            return false;
                        }
                    }
                }
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
        return true;
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
        jLabel2 = new javax.swing.JLabel();
        CbxOr = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        radioSecond = new javax.swing.JRadioButton();
        radioFirst = new javax.swing.JRadioButton();
        radioSleeper = new javax.swing.JRadioButton();
        radioFirstSleeper = new javax.swing.JRadioButton();
        txtStart = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtEnd = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPass = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        txtNumber = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        CbxType = new javax.swing.JComboBox<>();
        btnBuy = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Gabriola", 1, 40)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Train");

        jLabel2.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        jLabel2.setText("Organization: ");

        CbxOr.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        CbxOr.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Start: ");

        radioSecond.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        radioSecond.setText("haveSecondSeatRemain");

        radioFirst.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        radioFirst.setText("haveFirstSeatRemain");

        radioSleeper.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        radioSleeper.setText("haveSleeperRemain");

        radioFirstSleeper.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        radioFirstSleeper.setText("haveFirstSleeperRemain");

        txtStart.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        jLabel4.setText("End: ");

        txtEnd.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        txtEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEndActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        jLabel5.setText("Pass by: ");

        txtPass.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N

        btnSearch.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        table.setFont(new java.awt.Font("Gabriola", 0, 20)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "TrainId", "Company", "Start", "PassBy", "End", "Date", "SecondSeatPrice", "SecondSeatRemain", "FirstSeatPrice", "FirstSeatRemain", "SleeperPrice", "SleeperRemain", "FirstPrice", "FirstRemain", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);

        jLabel7.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        jLabel7.setText("Number:  ");

        txtNumber.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        jLabel8.setText("Ticket Type: ");

        CbxType.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        CbxType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SecondSeat", "FirstSeat", "Sleeper", "FirstSleeper" }));
        CbxType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbxTypeActionPerformed(evt);
            }
        });

        btnBuy.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        btnBuy.setText("Buy");
        btnBuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuyActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/Customer/customer4_副本.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addGap(33, 33, 33)
                                                .addComponent(CbxOr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addGap(15, 15, 15)
                                                .addComponent(txtStart, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(52, 52, 52)
                                                .addComponent(jLabel4)
                                                .addGap(22, 22, 22)
                                                .addComponent(txtEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(40, 40, 40)
                                                .addComponent(jLabel5)
                                                .addGap(33, 33, 33)
                                                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(58, 58, 58)
                                        .addComponent(btnSearch))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(radioSecond)
                                                .addGap(18, 18, 18)
                                                .addComponent(radioFirst)
                                                .addGap(18, 18, 18)
                                                .addComponent(radioSleeper)))
                                        .addGap(18, 18, 18)
                                        .addComponent(radioFirstSleeper))))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel8)
                                .addGap(29, 29, 29)
                                .addComponent(CbxType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)
                                .addComponent(jLabel7)
                                .addGap(16, 16, 16)
                                .addComponent(txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addComponent(btnBuy, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1152, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(CbxOr, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(radioSecond, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(radioFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(radioSleeper, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(radioFirstSleeper, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtStart, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuy, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CbxType, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEndActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEndActionPerformed

    private void btnBuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuyActionPerformed
        // TODO add your handling code here:
        
        if(table.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this,"please select a TrainLine");
        }
        else{
            int row = table.getSelectedRow();
            if(txtNumber.getText().matches("^[0-9]+$")){
                for(Organization o : this.system.getEnterpriseDirectory().getEnterpriseList().get(3).getOrganizationDirectory().getOrganizationList()){
                    if(o.getId().equals(table.getValueAt(row, 1).toString())){
                        for(int i = 0; i < o.getRequestDirectory().getRequestList().size(); i++){
                            if(o.getRequestDirectory().getRequestList().get(i).getId() == Integer.valueOf(table.getValueAt(row, 0).toString())
                                        && o.getRequestDirectory().getRequestList().get(i).getStatus().equals("Not Started")){
                                TrainLine t = (TrainLine)o.getRequestDirectory().getRequestList().get(i);
                                if(CbxType.getSelectedItem().equals("SecondSeat") && t.getRemainSecondSeat()< Integer.valueOf(txtNumber.getText())){
                                    JOptionPane.showMessageDialog(this,"Second Seats Not Enough");
                                }
                                else if(CbxType.getSelectedItem().equals("FirstSeat") && t.getRemainFirstSeat() < Integer.valueOf(txtNumber.getText())){
                                    JOptionPane.showMessageDialog(this,"First Seats Not Enough");
                                }
                                else if(CbxType.getSelectedItem().equals("Sleeper") && t.getRemainSleeper() < Integer.valueOf(txtNumber.getText())){
                                    JOptionPane.showMessageDialog(this,"Sleepers Not Enough");
                                }
                                else if(CbxType.getSelectedItem().equals("FirstSleeper") && t.getRemainFirstSleeper() < Integer.valueOf(txtNumber.getText())){
                                    JOptionPane.showMessageDialog(this,"First Sleepers Not Enough");
                                }
                                else{
                                    String Type = "TrainTicket" + CbxType.getSelectedItem();
                                    SimpleDateFormat df = new SimpleDateFormat ("MM-dd hh:mm");
                                    Date sDate = new Date();
                                    TrainTicket tt = new TrainTicket(String.valueOf(this.account.getId()), o.getId(),Type,"Not Started",sDate, null, o.getRequestDirectory().getRequestList().size() + 1);
                                    Double price = null;
                                    int number = Integer.valueOf(txtNumber.getText());
                                    if(CbxType.getSelectedItem().equals("SecondSeat")){
                                        t.setRemainSecondSeat(t.getRemainSecondSeat() - number);
                                        price = t.getSecondSeatPrice() * this.discount;
                                    }
                                    else if(CbxType.getSelectedItem().equals("FirstSeat")){
                                        t.setRemainFirstSeat(t.getRemainFirstSeat() - number);
                                        price = t.getFirstSeatPrice() * this.discount;
                                    }
                                    else if(CbxType.getSelectedItem().equals("Sleeper")){
                                        t.setRemainSleeper(t.getRemainSleeper() - number);
                                        price = t.getSleeperPrice() * this.discount;
                                    }
                                    else{
                                        t.setRemainFirstSleeper(t.getRemainFirstSleeper() - number);
                                        price = t.getFirstSleeperPrice() * this.discount;
                                    }
                                    tt.setTrainTicket(t.getStationList(),t.getTime(),t.getId() , number * price, number);
                                    account.getRequestDirectory().addRequest(tt);
                                    o.getRequestDirectory().addRequest(tt);
                                    this.populate();
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
    }//GEN-LAST:event_btnBuyActionPerformed

    private void CbxTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbxTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CbxTypeActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        if(account.getRole().getRole().equals("Customer")){
            JOptionPane.showMessageDialog(this,"You can charge to VIP to unlock this function");
        }
        else{
            this.populate();
        }
        
    }//GEN-LAST:event_btnSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CbxOr;
    private javax.swing.JComboBox<String> CbxType;
    private javax.swing.JButton btnBuy;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton radioFirst;
    private javax.swing.JRadioButton radioFirstSleeper;
    private javax.swing.JRadioButton radioSecond;
    private javax.swing.JRadioButton radioSleeper;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtEnd;
    private javax.swing.JTextField txtNumber;
    private javax.swing.JTextField txtPass;
    private javax.swing.JTextField txtStart;
    // End of variables declaration//GEN-END:variables
}
