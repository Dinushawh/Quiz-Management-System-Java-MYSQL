
import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.UIManager;



public final class Quizzes extends javax.swing.JLayeredPane {
    


    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    public String value,QuizCode,Status;
    
    public Quizzes(String quizecode,String answer,String status) {
        

        initComponents();

         con = Database_connection_CLASS.connection();
         
        jLabel2.setText(quizecode);
        jLabel1.setText(answer);
        jLabel6.setText(status);
        QuizCode = quizecode;
        Status = status;
        
        buttonColors();
       
        

    }
    
    public void buttonColors(){
    
        try{
        
            if("Active".equals(Status)){
            value = "1";
            jButton2.setText("Deavtivate");
            Color c1 = new Color(33, 97, 140);  
            jButton2.setBackground(c1);        
        }
        else{
            value = "2";
            jButton2.setText("Active");
            Color c1 = new Color(19, 141, 117 );  
            jButton2.setBackground(c1);        
        }
        }
        catch(Exception e){
        
        }
    }
    public void updateStatus (){
    
        try{
            String stat;
            if ("1".equals(value)){
                
                stat = "Deactive"; 
            }
            else {
                stat = "Active"; 
            }

            String Query = "UPDATE `quizes` SET `status` = ? WHERE `quizcode` = ?;"; 
            PreparedStatement preparedStmt = con.prepareStatement(Query);
            preparedStmt.setString(1, stat);
            preparedStmt.setString(2, QuizCode);
           
            preparedStmt.execute();
            
            JOptionPane.showMessageDialog (null, "Quiz status updated", "SUCESS!", JOptionPane.INFORMATION_MESSAGE);
            UIManager UI=new UIManager();
            UIManager.put("OptionPane.background", Color.white);
            UIManager.put("Panel.background", Color.white);
            jLabel6.setText(stat);
            Status = stat;
            buttonColors();
            
            
            

        }
        catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public void delete (){
    
    try{
            
            int res = JOptionPane.showOptionDialog(null, "This Actione cannont be undone", "WARNING!",
            JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null,
            new Object[] { "Yes", "No" }, JOptionPane.YES_OPTION);
            if (res == JOptionPane.YES_OPTION) {
                 
                stmt = con.createStatement();
                String Query = "DELETE FROM `quizes` WHERE `quizcode` = ?;"; 
                PreparedStatement preparedStmt = con.prepareStatement(Query);
                preparedStmt.setString(1, QuizCode);
                preparedStmt.execute();
                
                String Query2 = "DELETE FROM `quizlist` WHERE `quizcode` = ?;"; 
                PreparedStatement preparedStmt2 = con.prepareStatement(Query2);
                preparedStmt2.setString(1, QuizCode);
                preparedStmt2.execute();
                
                JOptionPane.showMessageDialog (null, "Quize Removed Successfully", "SUCESS!", JOptionPane.INFORMATION_MESSAGE);
                UIManager UI=new UIManager();
                UIManager.put("OptionPane.background", Color.white);
                UIManager.put("Panel.background", Color.white);
                
                }
            else{

                JOptionPane.showMessageDialog(null,"Canselled ");
                
            }
            }



        catch(HeadlessException | SQLException e){
        
            System.out.println("Error delete Quizz ");
        }
    }
    
    public void deleteQuizdata (){
    
        try{
            
            JOptionPane.showMessageDialog (null, "This Actione cannont be undone", "SUCESS!", JOptionPane.WARNING_MESSAGE);
            UIManager UI=new UIManager();
            UIManager.put("OptionPane.background", Color.white);
            UIManager.put("Panel.background", Color.white);
            
        
            String Query = "DELETE FROM `quizes` WHERE `quizcode` = ?;"; 
            PreparedStatement preparedStmt = con.prepareStatement(Query);
            preparedStmt.setString(1, QuizCode);
           
            String Query2 = "DELETE FROM `quizlist` WHERE `quizcode` = ?;"; 
            PreparedStatement preparedStmt2 = con.prepareStatement(Query2);
            preparedStmt2.setString(1, QuizCode);
            
            preparedStmt2.execute();
            
            JOptionPane.showMessageDialog (null, "Quiz status updated", "SUCESS!", JOptionPane.INFORMATION_MESSAGE);
            UIManager.put("OptionPane.background", Color.white);
            UIManager.put("Panel.background", Color.white);
        }
        catch(HeadlessException | SQLException e){
        
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

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI Semilight", 0, 20)); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 22, 960, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        jLabel1.setText("Active");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 1334, 37));

        jLabel3.setFont(new java.awt.Font("Segoe UI Semilight", 0, 20)); // NOI18N
        jLabel3.setText("Quiz Code :");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 111, 49));

        jLabel4.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Status");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 50, 26));

        jLabel5.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Titel");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 439, 26));

        jLabel6.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        jLabel6.setText("Actice");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 1334, 37));

        jButton1.setBackground(new java.awt.Color(255, 0, 51));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Delete Quiz");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 140, 40));

        jButton2.setBackground(new java.awt.Color(0, 0, 255));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Deactivate");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 140, 40));

        setLayer(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_formMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try{
        
            updateStatus ();
        }
        catch(Exception e){
        
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try{

            delete ();
        }
        catch(Exception e){

        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
