/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dinus
 */
public final class HomeAdmin extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    
    public static String type,userid;
    
    public HomeAdmin() {
        initComponents();
        
        setuserid();
        
        CreateNewQuiz view = new CreateNewQuiz ();
        jDesktopPane1.removeAll();
        jDesktopPane1.add(view).setVisible(true);

    }
    
    public void setuserid(){
    
        try{
            CreateNewQuiz.userid = userid;
            QuizList.userid = userid;
            AdminProfile.userid = userid;
            MyQuizPreformance.userid = userid;
            
        }
        catch(Exception e){
        
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        teacherPane = new javax.swing.JPanel();
        addnew8 = new javax.swing.JButton();
        addnew10 = new javax.swing.JButton();
        addnew11 = new javax.swing.JButton();
        addnew12 = new javax.swing.JButton();
        addnew13 = new javax.swing.JButton();
        addnew14 = new javax.swing.JButton();
        addnew15 = new javax.swing.JButton();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo-01.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 60));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_teacher_40px.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1670, 0, 120, 70));

        teacherPane.setBackground(new java.awt.Color(255, 255, 255));

        addnew8.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        addnew8.setForeground(new java.awt.Color(51, 51, 51));
        addnew8.setText("Logout");
        addnew8.setContentAreaFilled(false);
        addnew8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addnew8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        addnew8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addnew8ActionPerformed(evt);
            }
        });

        addnew10.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        addnew10.setForeground(new java.awt.Color(51, 51, 51));
        addnew10.setText("Create new Quiz");
        addnew10.setContentAreaFilled(false);
        addnew10.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addnew10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        addnew10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addnew10ActionPerformed(evt);
            }
        });

        addnew11.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        addnew11.setForeground(new java.awt.Color(51, 51, 51));
        addnew11.setText("Edit Questions and answers");
        addnew11.setContentAreaFilled(false);
        addnew11.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addnew11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        addnew11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addnew11ActionPerformed(evt);
            }
        });

        addnew12.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        addnew12.setForeground(new java.awt.Color(51, 51, 51));
        addnew12.setText("My Quizzes status");
        addnew12.setContentAreaFilled(false);
        addnew12.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addnew12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        addnew12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addnew12ActionPerformed(evt);
            }
        });

        addnew13.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        addnew13.setForeground(new java.awt.Color(51, 51, 51));
        addnew13.setText("Profile");
        addnew13.setContentAreaFilled(false);
        addnew13.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addnew13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        addnew13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addnew13ActionPerformed(evt);
            }
        });

        addnew14.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        addnew14.setForeground(new java.awt.Color(51, 51, 51));
        addnew14.setText("Individual Check");
        addnew14.setContentAreaFilled(false);
        addnew14.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addnew14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        addnew14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addnew14ActionPerformed(evt);
            }
        });

        addnew15.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        addnew15.setForeground(new java.awt.Color(51, 51, 51));
        addnew15.setText("Quiz attendence");
        addnew15.setContentAreaFilled(false);
        addnew15.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addnew15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        addnew15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addnew15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout teacherPaneLayout = new javax.swing.GroupLayout(teacherPane);
        teacherPane.setLayout(teacherPaneLayout);
        teacherPaneLayout.setHorizontalGroup(
            teacherPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(teacherPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(teacherPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addnew8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addnew10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addnew11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addnew12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addnew14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addnew15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addnew13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        teacherPaneLayout.setVerticalGroup(
            teacherPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(teacherPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addnew10, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addnew12, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addnew11, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addnew14, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addnew15, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addnew13, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 429, Short.MAX_VALUE)
                .addComponent(addnew8, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 814, Short.MAX_VALUE)
        );

        jDesktopPane1.setLayer(jPanel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(295, 295, 295)
                .addComponent(jDesktopPane1)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(teacherPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1493, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktopPane1)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(56, 56, 56)
                    .addComponent(teacherPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(21, 21, 21)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addnew8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addnew8ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        Main load = new Main();
        load.setVisible(true);
        
    }//GEN-LAST:event_addnew8ActionPerformed

    private void addnew10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addnew10ActionPerformed
        // TODO add your handling code here:
        try
        {

            CreateNewQuiz view = new CreateNewQuiz ();
            jDesktopPane1.removeAll();
            jDesktopPane1.add(view).setVisible(true);

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }//GEN-LAST:event_addnew10ActionPerformed

    private void addnew11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addnew11ActionPerformed
        // TODO add your handling code here:
        try
        {

            UpdateQuiz view = new UpdateQuiz ();
            jDesktopPane1.removeAll();
            jDesktopPane1.add(view).setVisible(true);

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }//GEN-LAST:event_addnew11ActionPerformed

    private void addnew12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addnew12ActionPerformed
        // TODO add your handling code here:
         try
        {

            QuizList view = new QuizList ();
            jDesktopPane1.removeAll();
            jDesktopPane1.add(view).setVisible(true);

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }//GEN-LAST:event_addnew12ActionPerformed

    private void addnew13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addnew13ActionPerformed
        // TODO add your handling code here:
        try
        {

            AdminProfile  view = new AdminProfile ();
            jDesktopPane1.removeAll();
            jDesktopPane1.add(view).setVisible(true);

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }//GEN-LAST:event_addnew13ActionPerformed

    private void addnew14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addnew14ActionPerformed
        // TODO add your handling code here:
        try
        {

            MyQuizPreformance  view = new MyQuizPreformance ();
            jDesktopPane1.removeAll();
            jDesktopPane1.add(view).setVisible(true);

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }//GEN-LAST:event_addnew14ActionPerformed

    private void addnew15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addnew15ActionPerformed
        // TODO add your handling code here:
        try
        {

            IndividualCheck  view = new IndividualCheck ();
            jDesktopPane1.removeAll();
            jDesktopPane1.add(view).setVisible(true);

        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }//GEN-LAST:event_addnew15ActionPerformed

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
            java.util.logging.Logger.getLogger(HomeAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addnew10;
    private javax.swing.JButton addnew11;
    private javax.swing.JButton addnew12;
    private javax.swing.JButton addnew13;
    private javax.swing.JButton addnew14;
    private javax.swing.JButton addnew15;
    private javax.swing.JButton addnew8;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel teacherPane;
    // End of variables declaration//GEN-END:variables
}
