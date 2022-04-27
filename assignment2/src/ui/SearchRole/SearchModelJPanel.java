/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.SearchRole;

import java.awt.CardLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import model.Product;

/**
 *
 * @author Lynn Wei
 */
public class SearchModelJPanel extends javax.swing.JPanel {
	JPanel p;
	List<Product> lists;
    /**
     * Creates new form SearchModel
     */
    public SearchModelJPanel(JPanel p, List<Product> lists,String m) {
    	initComponents();
	    this.p = p;
	    this.lists = lists;
	    lblModelNumber.setText(m);
	    refreshTable();
	    productCatalog.setEnabled(false);
    }
    private void refreshTable() {
	    DefaultTableModel model = (DefaultTableModel) productCatalog.getModel();
	    for(Product p: lists){
	        Object row[] = new Object[9];
	        row[0] = p.getCarName();
	        row[1] = p.getManu();
	        row[2] = p.getYear();
	        row[3] = p.getSeat();
	        row[4] = p.getSerialNumber();
	        row[5] = p.getModelNumber();
	        row[6] = p.getCity();
	        row[7] = p.getCertificate();
	        row[8] = p.getAvail();
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

        lblModelNumber = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        productCatalog = new javax.swing.JTable();

        lblModelNumber.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 36)); // NOI18N
        lblModelNumber.setText("<ModelNumber>");

        btnBack.setText(">>BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        productCatalog.setModel(new javax.swing.table.DefaultTableModel(
            null,
            new String [] {
                "Name", "Manufacturer", "Year", "Seat", "Serial Number", "Model Number", "City", "Certificate EXP", "Availability"
            }
        ));
        productCatalog.setRowHeight(35);
        jScrollPane1.setViewportView(productCatalog);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92)
                        .addComponent(lblModelNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(138, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(24, 24, 24))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblModelNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
    	p.remove(this);
        CardLayout layout = (CardLayout) p.getLayout();
        layout.previous(p);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblModelNumber;
    private javax.swing.JTable productCatalog;
    // End of variables declaration//GEN-END:variables
}