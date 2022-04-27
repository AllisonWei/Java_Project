/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Search;

import data.AppData;
import java.awt.CardLayout;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import model.City;
import model.Community;
import model.Encounter;
import model.Patient;
import model.SearchVO;
import ui.City.ShowHouse;

/**
 *
 * @author Lynn Wei
 */
public class PersonDirectoryJPanel extends javax.swing.JPanel {
 private javax.swing.JPanel userProcessContainer;
  private Object[][] obj;
   List<SearchVO> data;
    /**
     * Creates new form DetailJPanel
     */
    public PersonDirectoryJPanel(javax.swing.JPanel userProcessContainer) {
        this.userProcessContainer=userProcessContainer;
        initComponents();
        
        List<Community> communitys=AppData.getCommunityList();
        List<String> cityStrs=new ArrayList<String>();
        cityStrs.add("all");
        for(Community c:communitys){
            cityStrs.add(c.getCommunityName());
        }
        cmbCommunity.setModel(new javax.swing.DefaultComboBoxModel<>(cityStrs.toArray(new String[0])));
        
        initDate();
    }
    

     public void initDate(){
        data=new ArrayList<SearchVO>();
        //获取所有数据
         List<Patient> appPersonList=AppData.getPatientList();
         //人数
         for(Patient p:appPersonList){
             
             if(txtNameSearch.getText().length()>0){
                if(!txtNameSearch.getText().equals(p.getName())){
                    continue;
                }
             }
             if(txtIDSearch.getText().length()>0){
                if(!txtIDSearch.getText().equals(p.getID())){
                    continue;
                }
             }
             
             if(!cmbCommunity.getSelectedItem().toString().equals("all")){
                if(!cmbCommunity.getSelectedItem().toString().equals(p.getCommunityName())){
                    continue;
                }
             }
             
             //age all", "20-30", "30-40", "40-50", "50-60", "60-70", "70+"
                 if(!cmbAge.getSelectedItem().toString().equals("all")){
                    if(cmbAge.getSelectedItem().toString().equals("20-30")){
                        if(p.getAge()<20||p.getAge()>30){
                            continue;
                        }
                    }
                    if(cmbAge.getSelectedItem().toString().equals("30-40")){
                      if(p.getAge()<30||p.getAge()>40){
                            continue;
                        }
                    }
                    if(cmbAge.getSelectedItem().toString().equals("40-50")){
                      if(p.getAge()<40||p.getAge()>50){
                            continue;
                        }
                    }
                    if(cmbAge.getSelectedItem().toString().equals("50-60")){
                      if(p.getAge()<50||p.getAge()>60){
                            continue;
                        }
                    }
                    if(cmbAge.getSelectedItem().toString().equals("60-70")){
                      if(p.getAge()<60||p.getAge()>70){
                            continue;
                        }
                    }
                    if(cmbAge.getSelectedItem().toString().equals("70+")){
                      if(p.getAge()<70){
                            continue;
                        }
                    }
                 }
             
             for(Encounter e:p.getEncounterHistory().getEncounters()){    

                 //cmbBloodP", "90-139/60-89", "Normal", "Abnormal
                 if(!cmbBloodP.getSelectedItem().toString().equals("all")){
                     
                    String[] bloodPstr = e.getBloodPressure().split("/");
                    int hp=Integer.valueOf(bloodPstr[0]);//高压
                    int lp=Integer.valueOf(bloodPstr[1]);//低压
                    //需要正常的血压数据，则把不正常跳过continue
                    if(cmbBloodP.getSelectedItem().toString().equals("Normal")){
                        if(hp>139||hp<90||lp>89||hp<60){
                            continue;
                        }
                    }else if(cmbBloodP.getSelectedItem().toString().equals("Abnormal")){
                        if(hp<=139&&hp>=90&&lp<=89&&lp>=60){
                            continue;
                        }
                    }
                 }

                 
                 //cmbBodyT", "小于37.3", "Normal", "Abnormal
                 if(!cmbBodyT.getSelectedItem().toString().equals("all")){
                    BigDecimal cmbBodyTB = new BigDecimal(e.getBodyTemperature());
                    if(cmbBodyT.getSelectedItem().toString().equals("Normal")){
                        if(cmbBodyTB.compareTo(new BigDecimal("37.3"))>0){
                 
                            continue;
                        }
                    }else if(cmbBodyT.getSelectedItem().toString().equals("Abnormal")){
                        if(cmbBodyTB.compareTo(new BigDecimal("37.3"))<=0){
  
                            continue;
                        }
                    }
                 }
                         
                 //cmbPulse", "60-100", "Normal", "Abnormal
                 if(!cmbPulse.getSelectedItem().toString().equals("all")){
                    if(cmbPulse.getSelectedItem().toString().equals("Normal")){
                        if(60>e.getPulse()||e.getPulse()>100){
                            continue;
                        }
                    }
                    if(cmbPulse.getSelectedItem().toString().equals("Abnormal")){
                        if(e.getPulse()>=60&&e.getPulse()<=100){
                            continue;
                        }
                    }
                
                 }
                 SearchVO vo=new SearchVO();
                    vo.setCityName(p.getCityName());
                    vo.setCommunityName(p.getCommunityName());
                    vo.setHouseName(p.getHouseName());
                    vo.setName(p.getName());
                    vo.setID(p.getID());
                    vo.setGender(p.getGender());
                    vo.setAge(p.getAge());
                    vo.setDate(e.getDate());
                    vo.setBloodPressure(e.getBloodPressure());
                    vo.setBodyTemperature(e.getBodyTemperature());
                    vo.setPulse(e.getPulse());
                    data.add(vo);
                 
                    
             }
   
         }
         
        
         //组装数据
         obj = new Object[data.size()][16];  
         
         //利用set的不可重复原理统计人数
        Set<String> set = new HashSet<String>();
        for(int i=0;i<data.size();i++){
            set.add(data.get(i).getName());
            obj[i][0]= i+1;
            obj[i][1]= data.get(i).getName();
            obj[i][2]= data.get(i).getID();
            obj[i][3]= data.get(i).getGender();
            obj[i][4]= data.get(i).getAge();
            obj[i][5]= data.get(i).getHouseName();
            obj[i][6]= data.get(i).getCommunityName();
            obj[i][7]= data.get(i).getCityName();
            obj[i][8]= data.get(i).getBloodPressure();
            obj[i][9]= data.get(i).getBodyTemperature();
            obj[i][10]= data.get(i).getPulse();
        }
        
        tblSearchCatalog.setModel(new javax.swing.table.DefaultTableModel(
            obj,
            new String [] {
                "NO.", "Name", "ID", "Gender", "Age", "House", 
                "Community", "City", "Blood Pressure", 
                "Body Temperature",  "Pulse"
            }
        ));
        
        //设置显示人数
         txtPersonNumber.setText(set.size()+"");
       
     }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblSearchCatalog = new javax.swing.JTable();
        txtNameSearch = new javax.swing.JTextField();
        txtIDSearch = new javax.swing.JTextField();
        btnIDSearch = new javax.swing.JButton();
        lblAge = new javax.swing.JLabel();
        cmbAge = new javax.swing.JComboBox<>();
        cmbCommunity = new javax.swing.JComboBox<>();
        lblCommunity = new javax.swing.JLabel();
        lblBloodP = new javax.swing.JLabel();
        cmbBloodP = new javax.swing.JComboBox<>();
        lblBodyT = new javax.swing.JLabel();
        cmbBodyT = new javax.swing.JComboBox<>();
        lblPulse = new javax.swing.JLabel();
        cmbPulse = new javax.swing.JComboBox<>();
        lblPersonNumber = new javax.swing.JLabel();
        txtPersonNumber = new javax.swing.JTextField();
        lblTitle = new javax.swing.JLabel();
        lblAge1 = new javax.swing.JLabel();
        lblBloodP1 = new javax.swing.JLabel();

        tblSearchCatalog.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "NO.", "Name", "ID", "Gender", "Age", "House", "Community", "City", "Blood Pressure", "Abnormal", "Body Temperature", "Abnormal", "Pulse", "Abnormal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblSearchCatalog.setRowHeight(30);
        jScrollPane1.setViewportView(tblSearchCatalog);

        btnIDSearch.setText("Search");
        btnIDSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIDSearchActionPerformed(evt);
            }
        });

        lblAge.setText("Age:");

        cmbAge.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "all", "20-30", "30-40", "40-50", "50-60", "60-70", "70+" }));
        cmbAge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAgeActionPerformed(evt);
            }
        });

        cmbCommunity.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "all", "Fenway", "Chinatown", "West End" }));
        cmbCommunity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCommunityActionPerformed(evt);
            }
        });

        lblCommunity.setText("Community:");

        lblBloodP.setText("Blood Pressure: ");

        cmbBloodP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "all", "Normal", "Abnormal" }));
        cmbBloodP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbBloodPActionPerformed(evt);
            }
        });

        lblBodyT.setText("Body Temperature: ");

        cmbBodyT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "all", "Normal", "Abnormal" }));
        cmbBodyT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbBodyTActionPerformed(evt);
            }
        });

        lblPulse.setText("Pulse: ");

        cmbPulse.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "all", "Normal", "Abnormal" }));
        cmbPulse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPulseActionPerformed(evt);
            }
        });

        lblPersonNumber.setText("The number of Person is:");

        txtPersonNumber.setEditable(false);

        lblTitle.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 36)); // NOI18N
        lblTitle.setText("Person Information");

        lblAge1.setText("Name:");

        lblBloodP1.setText("ID: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblPersonNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtPersonNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 105, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCommunity)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbCommunity, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(357, 357, 357)
                                .addComponent(lblTitle))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblBodyT)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblAge)
                                            .addComponent(lblAge1))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtNameSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(cmbAge, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(63, 63, 63)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblBloodP1)
                                            .addComponent(lblBloodP))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtIDSearch)
                                    .addComponent(cmbBloodP, 0, 162, Short.MAX_VALUE)
                                    .addComponent(cmbBodyT, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(59, 59, 59)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnIDSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblPulse)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbPulse, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNameSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAge1))
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblBloodP1)
                            .addComponent(txtIDSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPulse, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblAge)
                        .addComponent(cmbAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblBloodP)
                        .addComponent(cmbBloodP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbPulse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBodyT)
                    .addComponent(cmbBodyT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCommunity)
                    .addComponent(cmbCommunity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIDSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPersonNumber)
                    .addComponent(txtPersonNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(116, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnIDSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIDSearchActionPerformed
        initDate();
    }//GEN-LAST:event_btnIDSearchActionPerformed

    private void cmbAgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAgeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbAgeActionPerformed

    private void cmbBloodPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbBloodPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbBloodPActionPerformed

    private void cmbBodyTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbBodyTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbBodyTActionPerformed

    private void cmbPulseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPulseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbPulseActionPerformed

    private void cmbCommunityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCommunityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCommunityActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIDSearch;
    private javax.swing.JComboBox<String> cmbAge;
    private javax.swing.JComboBox<String> cmbBloodP;
    private javax.swing.JComboBox<String> cmbBodyT;
    private javax.swing.JComboBox<String> cmbCommunity;
    private javax.swing.JComboBox<String> cmbPulse;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAge;
    private javax.swing.JLabel lblAge1;
    private javax.swing.JLabel lblBloodP;
    private javax.swing.JLabel lblBloodP1;
    private javax.swing.JLabel lblBodyT;
    private javax.swing.JLabel lblCommunity;
    private javax.swing.JLabel lblPersonNumber;
    private javax.swing.JLabel lblPulse;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblSearchCatalog;
    private javax.swing.JTextField txtIDSearch;
    private javax.swing.JTextField txtNameSearch;
    private javax.swing.JTextField txtPersonNumber;
    // End of variables declaration//GEN-END:variables
}
