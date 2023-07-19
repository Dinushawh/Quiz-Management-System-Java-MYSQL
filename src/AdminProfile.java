

import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import sun.java2d.cmm.Profile;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dinus
 */
public class AdminProfile extends javax.swing.JInternalFrame {

    /**
     * Creates new form UserProfile
     */
    
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    public static String userid;
    
    public AdminProfile() {
        initComponents();
        
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
        
        con = Database_connection_CLASS.connection();
        
        chanegPassword.setLocationRelativeTo(null);changeSecurity.setLocationRelativeTo(null);deleteaccount.setLocationRelativeTo(null);
        
        setDetails ();
        numberofQuizz();
    }
    
    public void setDetails (){
    
        try{

            
            stmt = con.createStatement();
            String query = "SELECT * FROM users";
            ResultSet rsd = stmt.executeQuery(query);
            System.out.println(userid);
            while(rsd.next())
            {
                
                if(userid.equals(rsd.getString(1))){
                    
                    jLabel2.setText(rsd.getString(8)+" "+rsd.getString(9));
                    occupation.setText(rsd.getString(5));

                }
                
            }
        }
        catch (SQLException e){
        
        }
    }

    public void numberofQuizz (){
    
        try{

            int count = 0;
            stmt = con.createStatement();
            String query = "SELECT * FROM attendence";
            ResultSet rsd = stmt.executeQuery(query);
            System.out.println(userid);
            while(rsd.next())
            {
                
                if(userid.equals(rsd.getString(2))){
                    
                   count++;

                }
                
                
            }
            jLabel5.setText(String.valueOf(count));
        }
        catch (SQLException e){
        
        }
    }
    
    public void changePassword (){
    
        try{
        
            boolean loopcheck = false;
           
            if("".equals(pw1.getText()) ||  "".equals(pw2.getText()) ){
            
                JOptionPane.showMessageDialog (null, "Feilds are empyt", "ERROR!", JOptionPane.INFORMATION_MESSAGE);
                UIManager UI=new UIManager();
                UIManager.put("OptionPane.background", Color.white);
                UIManager.put("Panel.background", Color.white);
                
            }
            else{
                
                if (pw1.getText().equals(pw2.getText())){
            
                loopcheck = true;
                stmt = con.createStatement();
                String Query = "UPDATE `users` SET `password`=?  WHERE `userid` = ?;";

                PreparedStatement preparedStmt = con.prepareStatement(Query);
                preparedStmt.setString(1, pw1.getText());
                preparedStmt.setString(2, userid);
                preparedStmt.execute();


                JOptionPane.showMessageDialog (null, "Password changed successfully", "SUCCESS!", JOptionPane.INFORMATION_MESSAGE);
                UIManager UI=new UIManager();
                UIManager.put("OptionPane.background", Color.white);
                UIManager.put("Panel.background", Color.white);
                
                
                chanegPassword.setVisible(false);
                
            
            }
            if(!loopcheck){
                    
                    JOptionPane.showMessageDialog (null, "Passwords does not match", "ERROR!", JOptionPane.INFORMATION_MESSAGE);
                    UIManager UI=new UIManager();
                    UIManager.put("OptionPane.background", Color.white);
                    UIManager.put("Panel.background", Color.white);

                }   
            } 
            
        }
        catch(HeadlessException | SQLException e){
        
        }
        
    }
    
    public void securityOption () throws SQLException{
    
        try{
        
            if("".equals(SA.getText())){
            
                JOptionPane.showMessageDialog (null, "Feilds are empyt", "ERROR!", JOptionPane.INFORMATION_MESSAGE);
                UIManager UI=new UIManager();
                UIManager.put("OptionPane.background", Color.white);
                UIManager.put("Panel.background", Color.white);
                
            }
            else{
                
                stmt = con.createStatement();
                String Query = "UPDATE `users` SET `security question`=?, `answer`=?  WHERE `userid` = ?;";

                PreparedStatement preparedStmt = con.prepareStatement(Query);
                preparedStmt.setString(1, SQ.getSelectedItem().toString());
                preparedStmt.setString(2, SA.getText());
                preparedStmt.setString(3, userid);
                preparedStmt.execute();


                JOptionPane.showMessageDialog (null, "Security Question chnaged scusessfuly", "SUCCESS!", JOptionPane.INFORMATION_MESSAGE);
                UIManager UI=new UIManager();
                UIManager.put("OptionPane.background", Color.white);
                UIManager.put("Panel.background", Color.white);
                
               
                changeSecurity.setVisible(false);
                
            
            }
            
        }
        catch(HeadlessException e){
        
        }
    }
    
    public void deleteAccount(){
    
        try{
        
            con = Database_connection_CLASS.connection();
            stmt = con.createStatement();
            String Query2 = "DELETE FROM `users` WHERE `userid` = ?;";
            PreparedStatement preparedStmt1 = con.prepareStatement(Query2);
            preparedStmt1.setString(1, userid);
            preparedStmt1.execute();
            
            JOptionPane.showMessageDialog (null, "Your account has been sucsessfully deleted", "SUCCESS!", JOptionPane.INFORMATION_MESSAGE);
            UIManager UI=new UIManager();
            UIManager.put("OptionPane.background", Color.white);
            UIManager.put("Panel.background", Color.white);
            
            
            
            System.exit(0);
        }
        catch(SQLException e){
        
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

        chanegPassword = new javax.swing.JFrame();
        jPanel7 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        pw1 = new javax.swing.JPasswordField();
        pw2 = new javax.swing.JPasswordField();
        jLabel30 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        changeSecurity = new javax.swing.JFrame();
        jPanel8 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        SQ = new javax.swing.JComboBox<>();
        SA = new javax.swing.JTextField();
        jButton12 = new javax.swing.JButton();
        jLabel33 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        deleteaccount = new javax.swing.JFrame();
        jPanel4 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        occupation = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        chanegPassword.setSize(new java.awt.Dimension(400, 650));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setFont(new java.awt.Font("Segoe UI Semilight", 0, 16)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(102, 102, 102));
        jLabel29.setText("New password");
        jPanel7.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 296, 35));
        jPanel7.add(pw1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 300, 40));
        jPanel7.add(pw2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 296, 40));

        jLabel30.setFont(new java.awt.Font("Segoe UI Semilight", 0, 16)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(102, 102, 102));
        jLabel30.setText("Confirm new password");
        jPanel7.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 296, 35));

        jButton10.setText("Save changes");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 300, 40));

        jPanel2.setBackground(new java.awt.Color(0, 226, 110));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );

        jPanel7.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 75, 10, 90));

        jLabel3.setFont(new java.awt.Font("Segoe UI Semilight", 0, 20)); // NOI18N
        jLabel3.setText("Change Your Account Passowrd");
        jPanel7.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, -1));

        jLabel31.setFont(new java.awt.Font("Segoe UI Semilight", 0, 16)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(102, 102, 102));
        jLabel31.setText("and store in a safe place");
        jPanel7.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 308, -1));

        jLabel32.setFont(new java.awt.Font("Segoe UI Semilight", 0, 16)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(102, 102, 102));
        jLabel32.setText("Make sure remember your passowrd");
        jPanel7.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 308, 20));

        javax.swing.GroupLayout chanegPasswordLayout = new javax.swing.GroupLayout(chanegPassword.getContentPane());
        chanegPassword.getContentPane().setLayout(chanegPasswordLayout);
        chanegPasswordLayout.setHorizontalGroup(
            chanegPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        chanegPasswordLayout.setVerticalGroup(
            chanegPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
        );

        changeSecurity.setSize(new java.awt.Dimension(400, 650));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel34.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(102, 102, 102));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel34.setText("Change account security options");
        jPanel8.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 250, 37));

        jLabel35.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(102, 102, 102));
        jLabel35.setText("Security question");
        jPanel8.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 250, 31));

        jLabel36.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(102, 102, 102));
        jLabel36.setText("Security question");
        jPanel8.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 250, 31));

        SQ.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "In what city were you born?", "What is the name of your favorite pet?", "What is your mother's maiden name?", "What high school did you attend?", "What is the name of your first school?", "What was the make of your first car?", "What was your favorite food as a child?", "Where did you meet your spouse?" }));
        jPanel8.add(SQ, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 250, 35));
        jPanel8.add(SA, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 250, 35));

        jButton12.setText("change");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 250, 35));

        jLabel33.setFont(new java.awt.Font("Segoe UI Semilight", 0, 16)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(102, 102, 102));
        jLabel33.setText("question for unlock your account");
        jPanel8.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 270, -1));

        jPanel3.setBackground(new java.awt.Color(0, 226, 110));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );

        jPanel8.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 10, 90));

        jLabel37.setFont(new java.awt.Font("Segoe UI Semilight", 0, 16)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(102, 102, 102));
        jLabel37.setText("Make sure remember your security");
        jPanel8.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 270, 20));

        jLabel13.setFont(new java.awt.Font("Segoe UI Semilight", 0, 20)); // NOI18N
        jLabel13.setText("Change Your Security settings");
        jPanel8.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, -1));

        javax.swing.GroupLayout changeSecurityLayout = new javax.swing.GroupLayout(changeSecurity.getContentPane());
        changeSecurity.getContentPane().setLayout(changeSecurityLayout);
        changeSecurityLayout.setHorizontalGroup(
            changeSecurityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        changeSecurityLayout.setVerticalGroup(
            changeSecurityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
        );

        deleteaccount.setSize(new java.awt.Dimension(600, 300));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel39.setFont(new java.awt.Font("Segoe UI Semilight", 0, 16)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(102, 102, 102));
        jLabel39.setText("*Your account data will be deleted from server and cannot be undone");
        jPanel4.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 540, 20));

        jLabel9.setFont(new java.awt.Font("Segoe UI Semilight", 0, 20)); // NOI18N
        jLabel9.setText("Delete account");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, -1, -1));

        jPanel5.setBackground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 10, 80));

        jLabel41.setFont(new java.awt.Font("Segoe UI Semilight", 0, 16)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(102, 102, 102));
        jLabel41.setText("*Only important data willbe stored");
        jPanel4.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 308, 20));

        jButton1.setText("Delete account");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 290, 40));

        javax.swing.GroupLayout deleteaccountLayout = new javax.swing.GroupLayout(deleteaccount.getContentPane());
        deleteaccount.getContentPane().setLayout(deleteaccountLayout);
        deleteaccountLayout.setHorizontalGroup(
            deleteaccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deleteaccountLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        deleteaccountLayout.setVerticalGroup(
            deleteaccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_teacher_100px.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 119, 126));

        jLabel2.setFont(new java.awt.Font("Segoe UI Semilight", 0, 36)); // NOI18N
        jLabel2.setText("Dinusha Weerakoon");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 320, 64));

        occupation.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        occupation.setText("Student");
        jPanel1.add(occupation, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 310, 30));

        jLabel4.setText("jLabel4");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 870, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI Semilight", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("20");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 170, 40));

        jLabel6.setFont(new java.awt.Font("Segoe UI Semilight", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 153));
        jLabel6.setText("Change your password ?");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 220, 40));

        jLabel7.setFont(new java.awt.Font("Segoe UI Semilight", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Number of Quizes Fased");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 420, 40));

        jLabel8.setFont(new java.awt.Font("Segoe UI Semilight", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 51));
        jLabel8.setText("Delete your account ?");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 220, 40));

        jLabel10.setText("jLabel4");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1540, 90, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI Semilight", 0, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 51, 153));
        jLabel12.setText("Change your Security option ?");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 220, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        changePassword ();
        
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        chanegPassword.setVisible(true);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        try {
            // TODO add your handling code here:
            securityOption ();
        } catch (SQLException ex) {
            Logger.getLogger(UserProfile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        // TODO add your handling code here:
        changeSecurity.setVisible(true);
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
        deleteaccount.setVisible(true);
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         deleteAccount();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField SA;
    private javax.swing.JComboBox<String> SQ;
    private javax.swing.JFrame chanegPassword;
    private javax.swing.JFrame changeSecurity;
    private javax.swing.JFrame deleteaccount;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton12;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel occupation;
    private javax.swing.JPasswordField pw1;
    private javax.swing.JPasswordField pw2;
    // End of variables declaration//GEN-END:variables
}
