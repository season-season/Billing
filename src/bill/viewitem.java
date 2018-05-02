/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bill;

import static bill.dbconn.cn;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Sparrow
 */
public class viewitem extends javax.swing.JFrame {

    /**
     * Creates new form viewitem
     */
    public viewitem() {
        initComponents();
         try{
             Class.forName("com.mysql.jdbc.Driver");
             cn=DriverManager.getConnection("jdbc:mysql://localhost/billing", "root", "lbef");
        }
        catch(ClassNotFoundException | SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    fetchCategory();
    fetch();
    fetchfood();
    }
    public void fetchCategory(){

 try{
    String quer="SELECT MIN(ID),category FROM `category` GROUP BY category";
   PreparedStatement  pt = cn.prepareStatement(quer);
   ResultSet rscateg=pt.executeQuery();
    category1.setModel(DbUtils.resultSetToTableModel(rscateg));
}catch(Exception e){
    

}
    }
public void fetch(){
    try{
    String quer="select ID,Drinkname,Price,Category from Drinkmenu";
  PreparedStatement   pt = cn.prepareStatement(quer);
     
    ResultSet rs=pt.executeQuery();
    
    drinkmenu.setModel(DbUtils.resultSetToTableModel(rs));
    
    }catch(Exception e){
    

}
    }

public void fetchfood(){
    try{
    String quer="select *from Foodmenu";
    PreparedStatement pt = cn.prepareStatement(quer);
    ResultSet rs=pt.executeQuery();
    foodmenu.setModel(DbUtils.resultSetToTableModel(rs));
}catch(Exception e){
    

} }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        foodmenu = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        drinkmenu = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        category1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu30 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu36 = new javax.swing.JMenu();
        jMenu37 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 800));
        getContentPane().setLayout(null);

        foodmenu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "ITEMNAME", "CATEGORY"
            }
        ));
        foodmenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                foodmenuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(foodmenu);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 190, 257, 402);

        drinkmenu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID ", "DRINK", "CAEGORY"
            }
        ));
        drinkmenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                drinkmenuMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(drinkmenu);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(310, 190, 302, 402);

        category1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CATEGORY"
            }
        ));
        category1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                category1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(category1);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(650, 190, 321, 402);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 943, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(617, 11, 943, 100);

        jLabel1.setText("FOOD ITEM LIST");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 150, 171, 41);

        jLabel2.setText("DRINK ITEM LIST");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(340, 150, 128, 41);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/listitem.png"))); // NOI18N
        jButton6.setText("Edit Item");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Icon-Foodnew.png"))); // NOI18N
        jButton7.setText("View Item");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/report.png"))); // NOI18N
        jButton8.setText("Sales Report");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home.png"))); // NOI18N
        jButton9.setText("Home");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cropone.png"))); // NOI18N
        jButton5.setText("category");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 107, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(1140, 200, 190, 400);

        jLabel3.setText("CATEGORY LIST");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(670, 150, 168, 29);

        jMenu30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cropone.png"))); // NOI18N
        jMenu30.setText("Category");
        jMenu30.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenu30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu30MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu30);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/listitem.png"))); // NOI18N
        jMenu1.setText("Item");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Icon-Foodnew.png"))); // NOI18N
        jMenu2.setText("ViewItem");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        jMenu36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home.png"))); // NOI18N
        jMenu36.setText("Home");
        jMenu36.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu36MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu36);

        jMenu37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/report.png"))); // NOI18N
        jMenu37.setText("Sales Report");
        jMenu37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu37MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu37);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void category1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_category1MouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_category1MouseClicked

    private void drinkmenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_drinkmenuMouseClicked
        // TODO add your handling code here:

try{
     Class.forName("com.mysql.jdbc.Driver");
             cn=DriverManager.getConnection("jdbc:mysql://localhost/billing", "root", "lbef");
        
     int row =drinkmenu.getSelectedRow();
     String table_click=(drinkmenu.getModel().getValueAt(row, 0).toString());
    String quer="select *from Drinkmenu where ID=' "+table_click+"' ";
     PreparedStatement pts4 = cn.prepareStatement(quer);
    ResultSet rst4=pts4.executeQuery();
     
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        
        
        
        
        
        
        
                                           





    }//GEN-LAST:event_drinkmenuMouseClicked

    private void foodmenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_foodmenuMouseClicked
        // TODO add your handling code here:


        try{
     Class.forName("com.mysql.jdbc.Driver");
             cn=DriverManager.getConnection("jdbc:mysql://localhost/billing", "root", "lbef");
        
     int row =foodmenu.getSelectedRow();
     String table_click=(foodmenu.getModel().getValueAt(row, 0).toString());
    String quer="select *from foodmenu where ID=' "+table_click+"' ";
  PreparedStatement   pts = cn.prepareStatement(quer);
   ResultSet rst=pts.executeQuery();
     
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        
        
        



    }//GEN-LAST:event_foodmenuMouseClicked

    private void jMenu30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu30MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        category ct=new category();
        ct.setVisible(true);
    }//GEN-LAST:event_jMenu30MouseClicked

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked

        // TODO add your handling code here:
        this.setVisible(false);
        menuupdate mn=new menuupdate();
        mn.setVisible(true);
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        viewitem vw=new viewitem();
        vw.setVisible(true);
    }//GEN-LAST:event_jMenu2MouseClicked

    private void jMenu36MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu36MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        billing Bil=new billing();
        Bil.setVisible(true);
    }//GEN-LAST:event_jMenu36MouseClicked

    private void jMenu37MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu37MouseClicked
        // TODO add your handling code here:
        // TODO add your handling code here:
        this.setVisible(false);
        NewJFrame jf=new NewJFrame();
        jf.setVisible(true);
    }//GEN-LAST:event_jMenu37MouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        this.setVisible(false);
        menuupdate mn=new menuupdate();
        mn.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        viewitem vw=new viewitem();
        vw.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        NewJFrame jf=new NewJFrame();
        jf.setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:

        this.setVisible(false);
        billing bl=new billing();
        bl.setVisible(true);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        category ct=new category();
        ct.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(viewitem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewitem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewitem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewitem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewitem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable category1;
    private javax.swing.JTable drinkmenu;
    private javax.swing.JTable foodmenu;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu30;
    private javax.swing.JMenu jMenu36;
    private javax.swing.JMenu jMenu37;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}