/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui.Customer;

import api.TravelSystem;
import api.organization.Organization;
import api.request.Flight;
import api.request.FlightTicket;
import api.request.TrainLine;
import api.request.TrainTicket;
import api.request.request;
import api.request.requestDirectory;
import api.userAccount.UserAccount;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author 10857
 */
public class OrderDetail extends javax.swing.JFrame {

    /**
     * Creates new form OrderDetail
     */
    private request r;
    private UserAccount account;
    private TravelSystem system;
    private Organization organization;
    public OrderDetail(UserAccount user, request r, TravelSystem system, Organization o) {
        initComponents();
        this.account = user;
        this.r = r;
        this.system = system;
        this.organization = o;
        order.setVisible(false);
        if(this.r != null){
            if(!r.getStatus().equals("Finished")){
                Evaluate.setVisible(false);
            }
        }
        this.DataInit();
    }

    
    public void DataInit(){
        if(this.r == null){
            title.setText("Order VIP Line");
            txtComment.setVisible(false);
            lblTotal.setVisible(false);
            totalTitle.setVisible(false);
            jLabel11.setVisible(false);
            Evaluate.setVisible(false);
            lblid.setText(String.valueOf(this.organization.getRequestDirectory().getRequestList().size() + 1));
            lblOid.setText(this.organization.getId());
            lblOtype.setText("VIP");
            CbxEnd.setSelectedIndex(1);
            lblStatus.setVisible(false);
            status.setVisible(false);
            order.setVisible(true);
        }
        else if(this.r.getType().startsWith("FlightTicket")){
            FlightTicket ft = (FlightTicket)this.r;
            for(Organization o : this.system.getEnterpriseDirectory().getEnterpriseList().get(2).getOrganizationDirectory().getOrganizationList()){
                if(o.getId().equals(ft.getOrganizationId())){
                    for(int i = 0; i < o.getRequestDirectory().getRequestList().size(); i++){
                        if(o.getRequestDirectory().getRequestList().get(i).getId() == ft.getFlightId()){
                            Flight f = (Flight)o.getRequestDirectory().getRequestList().get(i);
                            lblid.setText(String.valueOf(ft.getId()));
                            lblOid.setText(ft.getOrganizationId());
                            lblOtype.setText(ft.getType());
                            txtNumber.setText(String.valueOf(ft.getNumber()));
                            txtNumber.setEnabled(false);
                            SimpleDateFormat df = new SimpleDateFormat ("MM-dd HH:mm");
                            txtDate.setText(df.format(ft.getStartDate()));
                            txtDate.setEnabled(false);
                            CbxStart.setSelectedItem(f.getStartAirport());
                            CbxStart.setEnabled(false);
                            CbxEnd.setSelectedItem(f.getEndAirport());
                            CbxEnd.setEnabled(false);
                            lblTotal.setText(String.valueOf(ft.getTotalPrice()));
                            lblStatus.setText(ft.getStatus());
                            txtComment.setText(ft.getMessage());
                            txtComment.setEditable(false);
                            if(ft.getStatus().equals("Finished")){
                                txtComment.setEditable(true);
                            }
                        }
                    }
                }
            }
        }
        else if(this.r.getType().startsWith("TrainTicket")){
            TrainTicket ft = (TrainTicket)this.r;
            for(Organization o : this.system.getEnterpriseDirectory().getEnterpriseList().get(3).getOrganizationDirectory().getOrganizationList()){
                if(o.getId().equals(ft.getOrganizationId())){
                    for(int i = 0; i < o.getRequestDirectory().getRequestList().size(); i++){
                        if(o.getRequestDirectory().getRequestList().get(i).getId() == ft.getTrainLineId()){
                            TrainLine t = (TrainLine)o.getRequestDirectory().getRequestList().get(i);
                            lblid.setText(String.valueOf(ft.getId()));
                            lblOid.setText(ft.getOrganizationId());
                            lblOtype.setText(ft.getType());
                            txtNumber.setText(String.valueOf(ft.getNumber()));
                            txtNumber.setEnabled(false);
                            SimpleDateFormat df = new SimpleDateFormat ("MM-dd HH:mm");
                            txtDate.setText(df.format(ft.getStartDate()));
                            txtDate.setEnabled(false);
                            CbxStart.setSelectedItem(t.getStationList().get(0));
                            CbxStart.setEnabled(false);
                            CbxEnd.setSelectedItem(t.getStationList().get(t.getStationList().size() - 1));
                            CbxEnd.setEnabled(false);
                            lblTotal.setText(String.valueOf(ft.getTotalPrice()));
                            lblStatus.setText(ft.getStatus());
                            txtComment.setText(ft.getMessage());
                            txtComment.setEditable(false);
                            if(ft.getStatus().equals("Finished")){
                                txtComment.setEditable(true);
                            }
                        }
                    }
                }
            }
        }
        else if(this.r.getType().equals("VIP") && this.organization.getName().contains("Air")){
            Flight f = (Flight) this.r;
            lblid.setText(String.valueOf(f.getId()));
            lblOid.setText(this.organization.getId());
            lblOtype.setText("VIP");
            txtNumber.setText(String.valueOf(10 - f.getRemainFirst()));
            txtNumber.setEnabled(false);
            SimpleDateFormat df = new SimpleDateFormat ("MM-dd HH:mm");
            txtDate.setText(df.format(f.getStartDate()));
            txtDate.setEnabled(false);
            CbxStart.setSelectedItem(f.getStartAirport());
            CbxStart.setEnabled(false);
            CbxEnd.setSelectedItem(f.getEndAirport());
            CbxEnd.setEnabled(false);
            lblTotal.setText("1000000");
            lblStatus.setText(f.getStatus());
            txtComment.setVisible(false);
            Evaluate.setVisible(false);
            jLabel11.setVisible(false);
        }
        else if(this.r.getType().equals("VIP") && this.organization.getName().contains("Rail")){
            TrainLine f = (TrainLine) this.r;
            lblid.setText(String.valueOf(f.getId()));
            lblOid.setText(this.organization.getId());
            lblOtype.setText("VIP");
            txtNumber.setText(String.valueOf(40 - f.getRemainFirstSleeper()));
            txtNumber.setEnabled(false);
            SimpleDateFormat df = new SimpleDateFormat ("MM-dd HH:mm");
            txtDate.setText(df.format(f.getStartDate()));
            txtDate.setEnabled(false);
            CbxStart.setSelectedItem(f.getStationList().get(0));
            CbxStart.setEnabled(false);
            CbxEnd.setSelectedItem(f.getStationList().get(f.getStationList().size() - 1));
            CbxEnd.setEnabled(false);
            lblTotal.setText("500000");
            lblStatus.setText(f.getStatus());
            txtComment.setVisible(false);
            Evaluate.setVisible(false);
            jLabel11.setVisible(false);
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

        title = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        totalTitle = new javax.swing.JLabel();
        lblid = new javax.swing.JLabel();
        lblOid = new javax.swing.JLabel();
        lblOtype = new javax.swing.JLabel();
        txtNumber = new javax.swing.JTextField();
        txtDate = new javax.swing.JTextField();
        lblTotal = new javax.swing.JLabel();
        CbxStart = new javax.swing.JComboBox<>();
        CbxEnd = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        Evaluate = new javax.swing.JButton();
        order = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        txtComment = new javax.swing.JTextField();
        status = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        title.setFont(new java.awt.Font("Gabriola", 1, 40)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Order Detail");

        jLabel2.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        jLabel2.setText("Id");

        jLabel3.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        jLabel3.setText("OrganizationId: ");

        jLabel4.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        jLabel4.setText("Order Type: ");

        jLabel6.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        jLabel6.setText("Number: ");

        jLabel7.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        jLabel7.setText("Start Date: ");

        jLabel8.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        jLabel8.setText("Start: ");

        jLabel9.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        jLabel9.setText("End: ");

        totalTitle.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        totalTitle.setText("Total Price: ");

        lblid.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        lblid.setText("jLabel11");

        lblOid.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        lblOid.setText("jLabel12");

        lblOtype.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        lblOtype.setText("jLabel13");

        txtNumber.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N

        txtDate.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N

        lblTotal.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        lblTotal.setText("jLabel15");

        CbxStart.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        CbxStart.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "New York", "Boston", "Danville" }));

        CbxEnd.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        CbxEnd.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "New York", "Boston", "Danville" }));

        jLabel11.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        jLabel11.setText("Comment: ");

        Evaluate.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        Evaluate.setText("Evaluate");
        Evaluate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EvaluateActionPerformed(evt);
            }
        });

        order.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        order.setText("Order");
        order.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/Customer/Backbutton_3.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtComment.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N

        status.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        status.setText("Status: ");

        lblStatus.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        lblStatus.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblStatus.setText("jLabel5");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/Customer/customer5_副本.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(189, 189, 189)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(234, 234, 234)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(lblid))
            .addGroup(layout.createSequentialGroup()
                .addGap(234, 234, 234)
                .addComponent(jLabel3)
                .addGap(88, 88, 88)
                .addComponent(lblOid))
            .addGroup(layout.createSequentialGroup()
                .addGap(234, 234, 234)
                .addComponent(jLabel4)
                .addGap(120, 120, 120)
                .addComponent(lblOtype))
            .addGroup(layout.createSequentialGroup()
                .addGap(234, 234, 234)
                .addComponent(jLabel6)
                .addGap(109, 109, 109)
                .addComponent(txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(234, 234, 234)
                .addComponent(jLabel7)
                .addGap(96, 96, 96)
                .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(234, 234, 234)
                .addComponent(jLabel8)
                .addGap(135, 135, 135)
                .addComponent(CbxStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(234, 234, 234)
                .addComponent(jLabel9)
                .addGap(141, 141, 141)
                .addComponent(CbxEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(234, 234, 234)
                .addComponent(totalTitle)
                .addGap(124, 124, 124)
                .addComponent(lblTotal))
            .addGroup(layout.createSequentialGroup()
                .addGap(234, 234, 234)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addComponent(order, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(status)
                        .addGap(96, 96, 96)
                        .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel11)
                    .addComponent(txtComment, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(Evaluate)))
                .addGap(43, 43, 43)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblid, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOid, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOtype, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(CbxStart, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(CbxEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(order, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(29, 29, 29)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(txtComment, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(Evaluate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void EvaluateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EvaluateActionPerformed
        // TODO add your handling code here:
        if(this.r.getType().startsWith("FlightTicket")){
            FlightTicket f = (FlightTicket) this.r;
            f.setMessage(txtComment.getText());
            f.setStatus("Evaluated");
            JOptionPane.showMessageDialog(this,"Evaluate success");
        }
        else{
            TrainTicket t = (TrainTicket) this.r;
            t.setMessage(txtComment.getText());
            t.setStatus("Evaluated");
            JOptionPane.showMessageDialog(this,"Evaluate success");
        }
    }//GEN-LAST:event_EvaluateActionPerformed

    private void orderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderActionPerformed
        // TODO add your handling code here:
        Boolean flag = true;
        if(!txtNumber.getText().matches("^[0-9]+$")){
            txtNumber.setForeground(Color.red);
            flag = false;
        }
        else{
            if(Integer.valueOf(txtNumber.getText()) == 0||Integer.valueOf(txtNumber.getText()) > 10){
                txtNumber.setForeground(Color.red);
                flag = false;
            }
            else
            {
                txtNumber.setForeground(Color.black);
            }
        }
        
        if(!txtDate.getText().matches("^[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}$")){
            txtDate.setForeground(Color.red);
            flag = false;
        }
        else{
            String s = txtDate.getText();
            int m1 = s.charAt(0) -48;
            int m2 = s.charAt(1) -48;
            int m = m1 * 10 + m2;
            int d1 = s.charAt(3) -48;
            int d2 = s.charAt(4) -48;
            int d = d1 * 10 + d2;
            int h1 = s.charAt(6) -48;
            int h2 = s.charAt(7) -48;
            int h = h1 * 10 + h2;
            int mi1 = s.charAt(9) -48;
            int mi2 = s.charAt(10) -48;
            int mi = mi1 * 10 + mi2;
            if(h >= 24 || h < 0 || mi > 60 || mi < 0 || m > 12 || m < 1 || d > 31 || d < 1){
               txtDate.setForeground(Color.red); 
               flag = false;
            }
            else if((m == 4||m == 6||m == 9| m == 11) && d > 30){
               txtDate.setForeground(Color.red); 
               flag = false;                
            }
            else if(m == 2 && d > 28){
               txtDate.setForeground(Color.red); 
               flag = false;
            }
            else{
                txtDate.setForeground(Color.black);
            }
        }
        
        if(CbxStart.getSelectedItem().toString().equals(CbxEnd.getSelectedItem().toString())){
            flag = false;               
        }
        
        if(flag){
            if(this.organization.getName().contains("Air")){
                SimpleDateFormat df = new SimpleDateFormat ("MM-dd HH:mm");
                Flight f = null;
                try {
                    f = new Flight(String.valueOf(this.account.getId()), this.organization.getId(), "VIP", "Unsolved",df.parse(txtDate.getText()), null, this.organization.getRequestDirectory().getRequestList().size() + 1 );
                } catch (ParseException ex) {
                    Logger.getLogger(OrderDetail.class.getName()).log(Level.SEVERE, null, ex);
                }
                f.setFlight(CbxStart.getSelectedItem().toString(), CbxEnd.getSelectedItem().toString(), null, null, 0, 0, 10 - Integer.valueOf(txtNumber.getText()), 0, 0, 0);
                this.organization.getRequestDirectory().addRequest(f);
                this.account.getRequestDirectory().addRequest(f);
            }
            else{
                SimpleDateFormat df = new SimpleDateFormat ("MM-dd HH:mm");
                TrainLine t = null;
                try {
                    t = new TrainLine(String.valueOf(this.account.getId()), this.organization.getId(), "VIP", "Unsolved",df.parse(txtDate.getText()), null, this.organization.getRequestDirectory().getRequestList().size() + 1 );
                } catch (ParseException ex) {
                    Logger.getLogger(OrderDetail.class.getName()).log(Level.SEVERE, null, ex);
                }
                ArrayList<String> sL = new ArrayList<String>();
                sL.add(CbxStart.getSelectedItem().toString());
                sL.add(CbxEnd.getSelectedItem().toString());
                t.setTrainLine(sL, 15, null, null, 0, 0, 0, 10 - Integer.valueOf(txtNumber.getText()), 0, 0, 0, 0);
                this.organization.getRequestDirectory().addRequest(t);
                this.account.getRequestDirectory().addRequest(t);
            }
            JOptionPane.showMessageDialog(this,"Order success");
        }
        else{
            JOptionPane.showMessageDialog(this,"input invalid");
        }
    }//GEN-LAST:event_orderActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CbxEnd;
    private javax.swing.JComboBox<String> CbxStart;
    private javax.swing.JButton Evaluate;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblOid;
    private javax.swing.JLabel lblOtype;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblid;
    private javax.swing.JButton order;
    private javax.swing.JLabel status;
    private javax.swing.JLabel title;
    private javax.swing.JLabel totalTitle;
    private javax.swing.JTextField txtComment;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtNumber;
    // End of variables declaration//GEN-END:variables
}
