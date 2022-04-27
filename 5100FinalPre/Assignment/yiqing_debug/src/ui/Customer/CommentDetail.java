/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui.Customer;

import api.organization.Organization;
import api.request.VIPComment;
import api.userAccount.UserAccount;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author 10857
 */
public class CommentDetail extends javax.swing.JFrame {

    /**
     * Creates new form CommentDetail
     */
    private Organization organization;
    private UserAccount account;
    private VIPComment vc;
    private VIPCommentPanel vip;
    public CommentDetail(Organization o, UserAccount user, VIPComment vc, VIPCommentPanel vip) {
        initComponents();
        this.account = user;
        this.organization = o;
        this.vc = vc;
        com.setText(o.getName());
        id.setText(String.valueOf(this.vc.getId()));
        SimpleDateFormat df = new SimpleDateFormat ("MM-dd HH:mm");
        date.setText(df.format(this.vc.getStartDate()));
        status.setText(this.vc.getStatus());
        if(this.vc.getComment() == null){
            comment.setEditable(true);
            comment.setText("");
        }
        else{
            comment.setText(this.vc.getComment());
            comment.setEditable(false);
            add.setVisible(false);
        }
        this.vip =vip;
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
        comment = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        status = new javax.swing.JLabel();
        add = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        com = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Gabriola", 1, 30)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Comment");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, -1, -1));

        comment.setColumns(20);
        comment.setFont(new java.awt.Font("Gabriola", 0, 20)); // NOI18N
        comment.setRows(5);
        jScrollPane1.setViewportView(comment);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 280, 218));

        jLabel2.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        jLabel2.setText("Id: ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 112, -1, -1));

        id.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        id.setText("jLabel3");
        getContentPane().add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 112, -1, -1));

        jLabel4.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        jLabel4.setText("Date: ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 148, -1, -1));

        date.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        date.setText("jLabel5");
        getContentPane().add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 148, -1, -1));

        jLabel6.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        jLabel6.setText("Status: ");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 181, -1, -1));

        status.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        status.setText("jLabel7");
        getContentPane().add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 181, -1, -1));

        add.setFont(new java.awt.Font("Gabriola", 0, 20)); // NOI18N
        add.setText("Send");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        getContentPane().add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(209, 493, 83, -1));

        jLabel3.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        jLabel3.setText("Send to: ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 224, -1, -1));

        com.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        com.setText("jLabel5");
        getContentPane().add(com, new org.netbeans.lib.awtextra.AbsoluteConstraints(246, 224, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/Customer/Backbutton_3.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 50, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        vip.populate();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
        vc.setComment(comment.getText());
        this.account.getRequestDirectory().addRequest(vc);
        this.organization.getRequestDirectory().addRequest(vc);
        JOptionPane.showMessageDialog(this,"Send success");
    }//GEN-LAST:event_addActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JLabel com;
    private javax.swing.JTextArea comment;
    private javax.swing.JLabel date;
    private javax.swing.JLabel id;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel status;
    // End of variables declaration//GEN-END:variables
}