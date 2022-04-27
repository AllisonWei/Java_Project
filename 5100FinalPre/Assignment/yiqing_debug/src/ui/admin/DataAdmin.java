/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.admin;

import api.TravelSystem;
import api.employee.Employee;
import api.enterprise.Enterprise;
import api.organization.AirlineCompany;
import api.organization.Organization;
import api.organization.RailwayCompany;
import api.request.FlightTicket;
import api.request.TrainTicket;
import api.request.request;
import api.userAccount.UserAccount;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;


/**
 *
 * @author 10857
 */
public class DataAdmin extends javax.swing.JPanel {

    /**
     * Creates new form DataAdmin
     */
    private TravelSystem system;
    private Organization organization;
    private ArrayList<JLabel> labelList;
    public DataAdmin(UserAccount user,Employee e,TravelSystem system, Organization o) {
        initComponents();
        this.organization= o;
        this.system = system;
        CbxEnter.removeAllItems();
        CbxRole.removeAllItems();
        CbxUser.removeAllItems();
        CbxOr.removeAllItems();
        CbxEnter.addItem("Unlimited");
        CbxEnter.setSelectedItem("Unlimited");
        for(Enterprise en : this.system.getEnterpriseDirectory().getEnterpriseList()){
            CbxEnter.addItem(en.getName());
        }
        CbxOr.setSelectedItem("Unlimited");
        CbxRole.setSelectedItem("Unlimited");
        CbxUser.setSelectedItem("Unlimited");
        this.populate();
    }

    public void populate(){
        if(!CbxEnter.getSelectedItem().toString().equals("Unlimited")){
            if(CbxOr.getSelectedItem() !=null && CbxOr.getSelectedItem().toString().equals("Unlimited")){
                for(Enterprise en : this.system.getEnterpriseDirectory().getEnterpriseList()){
                    if(en.getName().equals(CbxEnter.getSelectedItem().toString())){
                        this.populate(en);
                    }
                }
            }
            if(CbxOr.getSelectedItem() != null && !CbxOr.getSelectedItem().toString().equals("Unlimited") && CbxUser.getSelectedItem() != null &&CbxUser.getSelectedItem().equals("Unlimited")){
                for(Enterprise en : this.system.getEnterpriseDirectory().getEnterpriseList()){
                    if(en.getName().equals(CbxEnter.getSelectedItem().toString())){
                        for(Organization o : en.getOrganizationDirectory().getOrganizationList()){
                            if(o.getName().equals(CbxOr.getSelectedItem().toString())){
                                populate(o);
                            }
                        }
                    }
                }
            }
            if(CbxOr.getSelectedItem() != null&&CbxUser.getSelectedItem() != null&&CbxRole.getSelectedItem() != null){
                if(!CbxUser.getSelectedItem().toString().equals("Unlimited")){
                    for(Enterprise en : this.system.getEnterpriseDirectory().getEnterpriseList()){
                        if(en.getName().equals(CbxEnter.getSelectedItem().toString())){
                            for(Organization o : en.getOrganizationDirectory().getOrganizationList()){
                                if(o.getName().equals(CbxOr.getSelectedItem().toString())){
                                    for(UserAccount u : o.getUserAccountDirectory().getUserAccountList()){
                                        if(u.getUsername().equals(CbxUser.getSelectedItem().toString())){
                                            populate(u);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        else{
            txtName.setText("Travel System");
            txtID.setText("007");
            txtType.setText("TravelSystem");
            txtStatus.setText("Activated");
            int Flight = 0;
            int Train = 0;
            int[] Ticket = new int [20];
            int[] employee = new int[20];
            int[] UserAccount = new int[20];
            Double[] total = new Double[20];
            int i = 0;
            for(Enterprise e : this.system.getEnterpriseDirectory().getEnterpriseList()){
                for(Organization o : e.getOrganizationDirectory().getOrganizationList()){
                    if(total[i] == null){
                        total[i] = 0.0;
                    }
                    for(Employee em : o.getEmployeeDirectory().getEmployeeList()){
                        if(em.getStatus().equals("Activated")){
                            employee[i]++;
                        }
                    }
                    if(o.getName().contains("Company")){
                        if(o.getName().contains("Air")){
                            AirlineCompany a = (AirlineCompany)o;
                            Flight += a.getAirplaneList().size();
                        }
                        else{
                            RailwayCompany ra = (RailwayCompany)o;
                            Train += ra.getTrainList().size();
                        }
                        for(UserAccount u : o.getUserAccountDirectory().getUserAccountList()){
                            UserAccount[i]++;
                        }
                        for(request r : o.getRequestDirectory().getRequestList()){
                            if(r.getType().contains("FlightTicket") && !r.getStatus().equals("Canceled")){
                                FlightTicket f = (FlightTicket)r;
                                Ticket[i] += f.getNumber();
                                total[i] += f.getTotalPrice();
                            }
                            else if(r.getType().contains("TrainTicket") && !r.getStatus().equals("Canceled")){
                                TrainTicket t = (TrainTicket)r;
                                Ticket[i] += t.getNumber();
                                total[i] += t.getTotalPrice();
                            }
                            if(r.getType().equals("VIP")&& !r.getStatus().equals("Canceled")){
                                if(o.getName().contains("Air")){
                                    total[i] += 1000000;
                                }
                                else{
                                    total[i] += 500000;
                                }
                            }
                        }   
                    }
                    else{
                        UserAccount[i] = -1;
                        Ticket[i] = -1;
                    }
                    i++;
                }
            }
            
            ChartTab.removeAll();
            DefaultPieDataset Cdata = new DefaultPieDataset();
            DefaultPieDataset Tdata = new DefaultPieDataset();
            DefaultPieDataset Edata = new DefaultPieDataset();
            DefaultPieDataset Pdata = new DefaultPieDataset();
            int j = 0;
            for(Enterprise e : this.system.getEnterpriseDirectory().getEnterpriseList()){
                for(Organization o : e.getOrganizationDirectory().getOrganizationList()){
                    Edata.setValue(o.getId(),employee[j]);
                    if(o.getName().contains("Company")){
                        Cdata.setValue(o.getId(), UserAccount[j]);
                        Tdata.setValue(o.getId(), Ticket[j]);
                        Pdata.setValue(o.getId(), total[j]);
                    }
                    j++;
                }
            }
            JFreeChart Cchart = ChartFactory.createPieChart("Customer Information", Cdata);
            JFreeChart Tchart = ChartFactory.createPieChart("Ticket Information", Tdata);
            JFreeChart Echart = ChartFactory.createPieChart("Employee Information", Edata);
            JFreeChart Pchart = ChartFactory.createPieChart("Sales Information", Pdata);
            ChartTab.add("Customer Info",new ChartPanel(Cchart));
            ChartTab.add("Ticket Info",new ChartPanel(Tchart));
            ChartTab.add("Employee Info",new ChartPanel(Echart));
            ChartTab.add("Sales Info",new ChartPanel(Pchart));
            
        }
    }
    
   
    public void populate(Enterprise e){
        int[] Flight = new int[20];
        int[] Train = new int[20];
        int[] Ticket = new int [20];
        int[] employee = new int[20];
        int[] UserAccount = new int[20];
        int[] VIP = new int[20];
        Double[] total = new Double[20];
        int i = 0;
        txtName.setText(e.getName());
        txtID.setText(String.valueOf(e.getId()));
        txtType.setText(e.getName());
        txtStatus.setText("Activated");
        for(Organization o : e.getOrganizationDirectory().getOrganizationList()){
            if(total[i] == null){
                total[i] = 0.0;
            }
            for(Employee em : o.getEmployeeDirectory().getEmployeeList()){
                if(em.getStatus().equals("Activated")){
                    employee[i]++;
                }
            }
            if(o.getName().contains("Company")){
                if(o.getName().contains("Air")){
                    AirlineCompany a = (AirlineCompany)o;
                    Flight[i] = a.getAirplaneList().size();
                }
                else{
                    RailwayCompany ra = (RailwayCompany)o;
                    Train[i] = ra.getTrainList().size();
                }
                for(UserAccount u : o.getUserAccountDirectory().getUserAccountList()){
                    if(u.getRole().getRole().equals("Customer")){
                        UserAccount[i]++;
                    }
                    else{
                        VIP[i]++;
                    }
                }
                for(request r : o.getRequestDirectory().getRequestList()){
                    if(r.getType().contains("FlightTicket") && !r.getStatus().equals("Canceled")){
                        FlightTicket f = (FlightTicket)r;
                        Ticket[i] += f.getNumber();
                        total[i] += f.getTotalPrice();
                    }
                    else if(r.getType().contains("TrainTicket") && !r.getStatus().equals("Canceled")){
                        TrainTicket t = (TrainTicket)r;
                        Ticket[i] += t.getNumber();
                        total[i] += t.getTotalPrice();
                    }
                    if(r.getType().equals("VIP")&& !r.getStatus().equals("Canceled")){
                        if(o.getName().contains("Air")){
                            total[i] += 1000000;
                        }
                        else{
                            total[i] += 500000;
                        }
                    }
                }   
            }
            else{
                Ticket[i] = o.getRequestDirectory().getRequestList().size();
            }
            i++;
        }
        
        ChartTab.removeAll();
        int j = 0;
        if(e.getName().contains("Airport")||e.getName().contains("Station")){
            DefaultPieDataset Edata = new DefaultPieDataset();
            DefaultPieDataset Tdata = new DefaultPieDataset();
            for(Organization o : e.getOrganizationDirectory().getOrganizationList()){
                Edata.setValue(o.getId(), employee[j]);
                Tdata.setValue(o.getId(), Ticket[j]);
                j++;
            }
            JFreeChart Tchart = ChartFactory.createPieChart("Request Times Information", Tdata);
            JFreeChart Echart = ChartFactory.createPieChart("Employee Information", Edata);
            ChartTab.add("Request Times Info", new ChartPanel(Tchart));
            ChartTab.add("Employee Info", new ChartPanel(Echart));
        }
        else{
            DefaultPieDataset Cdata = new DefaultPieDataset();
            DefaultPieDataset Tdata = new DefaultPieDataset();
            DefaultPieDataset Edata = new DefaultPieDataset();
            DefaultPieDataset Pdata = new DefaultPieDataset();
            for(Organization o : e.getOrganizationDirectory().getOrganizationList()){
                Edata.setValue(o.getId(),employee[j]);
                Cdata.setValue(o.getId(), UserAccount[j]);
                Tdata.setValue(o.getId(), Ticket[j]);
                Pdata.setValue(o.getId(), total[j]);
                j++;
            }
            JFreeChart Cchart = ChartFactory.createPieChart("Customer Information", Cdata);
            JFreeChart Tchart = ChartFactory.createPieChart("Ticket Information", Tdata);
            JFreeChart Echart = ChartFactory.createPieChart("Employee Information", Edata);
            JFreeChart Pchart = ChartFactory.createPieChart("Sales Information", Pdata);
            ChartTab.add("Customer Info",new ChartPanel(Cchart));
            ChartTab.add("Ticket Info",new ChartPanel(Tchart));
            ChartTab.add("Employee Info",new ChartPanel(Echart));
            ChartTab.add("Sales Info",new ChartPanel(Pchart));  
        }
        
    }
    
    public void populate(Organization o){
        int CS = 0;
        int VCS = 0;
        int Cap = 0;
        int Manager = 0;
        int Ticket = 0;
        int VIP = 0;
        int C = 0;
        int VC = 0;
        int total = 0;
        txtName.setText(o.getName());
        txtID.setText(o.getId());
        txtStatus.setText("Activated");
        txtType.setText(o.getName());
        if(o.getName().contains("Company")){
            for(Employee e : o.getEmployeeDirectory().getEmployeeList()){
                if(e.getRole().getRole().contains("Manager")){
                    Manager++;
                }
                if(e.getRole().getRole().contains("VIP")){
                    VCS++;
                }
                if(e.getRole().getRole().equals("CustomerService")){
                    CS++;
                }
                if(e.getRole().getRole().contains("Captain")){
                    Cap++;
                }
            }
            for(UserAccount u : o.getUserAccountDirectory().getUserAccountList()){
                if(u.getRole().getRole().equals("Customer")){
                    C++;
                }
                else{
                    VC++;
                }
            }
            for(request r : o.getRequestDirectory().getRequestList()){
                    if(r.getType().contains("FlightTicket") && !r.getStatus().equals("Canceled")){
                        FlightTicket f = (FlightTicket)r;
                        Ticket += f.getNumber();
                        total += f.getTotalPrice();
                    }
                    else if(r.getType().contains("TrainTicket") && !r.getStatus().equals("Canceled")){
                        TrainTicket t = (TrainTicket)r;
                        Ticket += t.getNumber();
                        total += t.getTotalPrice();
                    }
                    if(r.getType().equals("VIP")&& !r.getStatus().equals("Canceled")){
                        VIP++;
                        if(o.getName().contains("Air")){
                            total += 1000000;
                        }
                        else{
                            total += 500000;
                        }
                    }
            }
            DefaultPieDataset Cdata = new DefaultPieDataset();
            DefaultPieDataset Tdata = new DefaultPieDataset();
            DefaultPieDataset Edata = new DefaultPieDataset();
            Cdata.setValue("VIPCustomer", VC);
            Cdata.setValue("Customer", C);
            Tdata.setValue("VIP", VIP * 10);
            Tdata.setValue("NomalTicket", Ticket);
            Edata.setValue("Manager", Manager);
            Edata.setValue("CustomerService", CS);
            Edata.setValue("VIPCustomer", VCS);
            Edata.setValue("Captain", Cap);
            ChartTab.removeAll();
            JFreeChart Cchart = ChartFactory.createPieChart("Customer Information", Cdata);
            JFreeChart Tchart = ChartFactory.createPieChart("Total Sales: " + total, Tdata);
            JFreeChart Echart = ChartFactory.createPieChart("Employee Information", Edata);
            ChartTab.add("Customer Info",new ChartPanel(Cchart));
            ChartTab.add("Ticket Info",new ChartPanel(Tchart));
            ChartTab.add("Employee Info",new ChartPanel(Echart));
        }
        else{
            ChartTab.removeAll();
            DefaultCategoryDataset dataset=new DefaultCategoryDataset();
            dataset.setValue(o.getRequestDirectory().getRequestList().size(), "request", "Request Number");
            dataset.setValue(o.getEmployeeDirectory().getEmployeeList().size(), "controller", "Controller Number");
            JFreeChart Echart=ChartFactory.createBarChart(o.getName(),"","Number",dataset);
            ChartTab.add(o.getName() + " Info",new ChartPanel(Echart));
        }
    }
    
    public void populate(UserAccount u){
        int Flight = 0;
        int Train = 0;
        int VIP = 0;
        int VC = 0;
        double tf = 0.0;
        double tt = 0.0;
        txtName.setText(u.getUsername());
        txtID.setText(String.valueOf(u.getId()));
        txtStatus.setText(u.getStatus());
        txtType.setText(u.getRole().getRole());
        for(request r : u.getRequestDirectory().getRequestList()){
            if(r.getType().contains("Flight")){
                Flight++;
                FlightTicket f = (FlightTicket)r;
                tf += f.getTotalPrice();
            }
            if(r.getType().contains("Train")){
                Train++;
                TrainTicket t = (TrainTicket)r;
                tt += t.getTotalPrice();
            }
            if(r.getType().equals("VIP")){
                VIP++;
            }
            if(r.getType().contains("Comment")){
                VC++;
            }
        }
        ChartTab.removeAll();
        DefaultPieDataset Cdata = new DefaultPieDataset();
        DefaultPieDataset Tdata = new DefaultPieDataset();
        Cdata.setValue("FlightTicket", Flight);
        Cdata.setValue("TrainTicket", Train);
        Cdata.setValue("VIP Line", VIP);
        Cdata.setValue("VIP Comment", VC);
        Tdata.setValue("FlightTicket", tf);
        Tdata.setValue("TrainTicket", tt);
        JFreeChart Cchart = ChartFactory.createPieChart("Customer Request", Cdata);
        JFreeChart Tchart = ChartFactory.createPieChart("Customer Total Price", Tdata);
        ChartTab.add(u.getUsername() + "Request Info",new ChartPanel(Cchart));
        ChartTab.add(u.getUsername() + "Spend Info",new ChartPanel(Tchart));
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CbxEnter = new javax.swing.JComboBox<>();
        CbxOr = new javax.swing.JComboBox<>();
        CbxRole = new javax.swing.JComboBox<>();
        CbxUser = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txtName = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtID = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtType = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtStatus = new javax.swing.JLabel();
        ChartTab = new javax.swing.JTabbedPane();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CbxEnter.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        CbxEnter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CbxEnter.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CbxEnterItemStateChanged(evt);
            }
        });
        add(CbxEnter, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 90, 30));

        CbxOr.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        CbxOr.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CbxOr.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CbxOrItemStateChanged(evt);
            }
        });
        add(CbxOr, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 90, 30));

        CbxRole.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        CbxRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CbxRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbxRoleActionPerformed(evt);
            }
        });
        add(CbxRole, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 90, 30));

        CbxUser.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        CbxUser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CbxUser.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CbxUserItemStateChanged(evt);
            }
        });
        add(CbxUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, 90, 30));

        jLabel1.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        jLabel1.setText("Name: ");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        txtName.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        txtName.setText("jLabel2");
        add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 160, -1));

        jLabel3.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        jLabel3.setText("ID: ");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, -1, -1));

        txtID.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        txtID.setText("jLabel4");
        add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, 100, -1));

        jLabel5.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        jLabel5.setText("Type: ");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 140, -1, -1));

        txtType.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        txtType.setText("jLabel6");
        add(txtType, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, 160, -1));

        jLabel7.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        jLabel7.setText("Status: ");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 140, -1, -1));

        txtStatus.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        txtStatus.setText("jLabel8");
        add(txtStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 140, 120, -1));
        add(ChartTab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 1080, 360));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/admin/admin_副本.png"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 0, 270, 230));
    }// </editor-fold>//GEN-END:initComponents

    private void CbxEnterItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CbxEnterItemStateChanged
        // TODO add your handling code here:
        if(CbxEnter.getSelectedItem() != null){
            if(CbxEnter.getSelectedItem().toString().equals("Unlimited")){
                CbxUser.removeAllItems();
                CbxRole.removeAllItems();
                CbxOr.removeAllItems();
                CbxUser.addItem("Unlimited");
                CbxUser.setSelectedItem("Unlimited");
                CbxRole.addItem("Unlimited");
                CbxRole.setSelectedItem("Unlimited");
                CbxOr.addItem("Unlimited");
                CbxOr.setSelectedItem("Unlimited");
                populate();
            }
            else{
                CbxOr.removeAllItems();
                CbxRole.removeAllItems();
                CbxUser.removeAllItems();
                for(Enterprise e : this.system.getEnterpriseDirectory().getEnterpriseList()){
                    if(CbxEnter.getSelectedItem().toString().equals(e.getName())){
                        for(Organization o : e.getOrganizationDirectory().getOrganizationList()){
                            CbxOr.addItem(o.getName());
                        }
                        if(e.getName().contains("Company")){
                            CbxRole.addItem("Customer");
                        }
                    }
                }
                CbxOr.addItem("Unlimited");
                CbxRole.addItem("Unlimited");
                CbxUser.addItem("Unlimited");
                CbxOr.setSelectedItem("Unlimited");
                CbxRole.setSelectedItem("Unlimited");
                CbxUser.setSelectedItem("Unlimited");
                populate();
            }
        }
    }//GEN-LAST:event_CbxEnterItemStateChanged

    private void CbxOrItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CbxOrItemStateChanged
        // TODO add your handling code here:
        if(CbxOr.getSelectedItem() != null){
            if(CbxEnter.getSelectedItem().toString().equals("Unlimited")){
                CbxOr.setSelectedItem("Unlimited");
            }
            else if(!CbxEnter.getSelectedItem().toString().equals("Unlimited") && CbxOr.getSelectedItem().toString().equals("Unlimited")){
                CbxRole.removeAllItems();
                CbxUser.removeAllItems();
                CbxRole.addItem("Unlimited");
                CbxUser.addItem("Unlimited");
                CbxRole.setSelectedItem("Unlimited");
                CbxUser.setSelectedItem("Unlimited");
                populate();
            }
            else{
                CbxRole.removeAllItems();
                CbxUser.removeAllItems();
                for(Enterprise e : this.system.getEnterpriseDirectory().getEnterpriseList()){
                    if(e.getName().equals(CbxEnter.getSelectedItem().toString())){
                        for(Organization o : e.getOrganizationDirectory().getOrganizationList()){
                            if(o.getName().equals(CbxOr.getSelectedItem().toString())){
                                CbxRole.removeAllItems();
                                if(o.getName().contains("Company")){
                                    CbxRole.addItem("Customer");
                                }
                                CbxRole.addItem("Unlimited");
                                CbxRole.setSelectedItem("Unlimited");
                                CbxUser.setSelectedItem("Unlimited");
                            }
                        }
                    }
                }
                populate();
            }
        }
    }//GEN-LAST:event_CbxOrItemStateChanged

    private void CbxRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbxRoleActionPerformed
        // TODO add your handling code here:
        if(CbxRole.getSelectedItem() != null){
            if(CbxOr.getSelectedItem() != null && CbxOr.getSelectedItem().toString().equals("Unlimited")){
                CbxRole.setSelectedItem("Unlimited");
            }
            else if(CbxOr.getSelectedItem() != null && !CbxOr.getSelectedItem().toString().equals("Unlimited") && CbxRole.getSelectedItem().toString().equals("Unlimited")){
                CbxUser.removeAllItems();
                CbxUser.addItem("Unlimited");
                CbxUser.setSelectedItem("Unlimited");
                populate();
            }
            else{
                for(Enterprise e : this.system.getEnterpriseDirectory().getEnterpriseList()){
                    if(e.getName().equals(CbxEnter.getSelectedItem().toString())){
                        for(Organization o : e.getOrganizationDirectory().getOrganizationList()){
                            if(CbxOr.getSelectedItem().toString().equals(o.getName())){
                                CbxUser.removeAllItems();
                                if(CbxRole.getSelectedItem().toString().equals("Customer")){
                                    for(UserAccount u : o.getUserAccountDirectory().getUserAccountList()){
                                        CbxUser.addItem(u.getUsername());
                                    }
                                }
                                else{
                                    for(Employee em : o.getEmployeeDirectory().getEmployeeList()){
                                        CbxUser.addItem(em.getEmployeeAccount());
                                    }
                                }
                                CbxUser.addItem("Unlimited");
                                CbxUser.setSelectedItem("Unlimited");
                                populate();
                            }
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_CbxRoleActionPerformed

    private void CbxUserItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CbxUserItemStateChanged
        // TODO add your handling code here:
        if(CbxUser.getSelectedItem() != null){

            populate();
        }
    }//GEN-LAST:event_CbxUserItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CbxEnter;
    private javax.swing.JComboBox<String> CbxOr;
    private javax.swing.JComboBox<String> CbxRole;
    private javax.swing.JComboBox<String> CbxUser;
    private javax.swing.JTabbedPane ChartTab;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel txtID;
    private javax.swing.JLabel txtName;
    private javax.swing.JLabel txtStatus;
    private javax.swing.JLabel txtType;
    // End of variables declaration//GEN-END:variables
}
