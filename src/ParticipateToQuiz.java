
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import net.miginfocom.swing.MigLayout;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dinus
 */
public final class ParticipateToQuiz extends javax.swing.JInternalFrame {

    /**
     * Creates new form ParticipateToQuiz
     */
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    public static String userid,QuizzCode;
    public String QuizeCode,DBQuestion,DBAnswer1,DBAnswer2,DBAnswer3,DBAnswer4,DBCorrectAsnswer;
    public int Order = 1;
    boolean customloop = false;
    String Answer;
    String SelectedAnswer;

    
    public ParticipateToQuiz() {
        initComponents();
        
        con = Database_connection_CLASS.connection();
        
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
        
        jScrollPane1.getViewport().setBackground(Color.WHITE);
        jScrollPane1.setBorder(BorderFactory.createEmptyBorder());
        
        
        list.setLayout(new MigLayout("fillx"));
        
        jPanel3.setVisible(false);
        jPanel9.setVisible(false);
        jPanel11.setVisible(false);
        jPanel13.setVisible(false);
        
        getAvailableQuizzList();
        
        ButtonGroup bG = new ButtonGroup();        
        bG.add(c1);
        bG.add(c2);
        bG.add(c3);
        bG.add(c4);
    }

    public void checkQuizz (){
    
        try{
            boolean loopcheck = false;
            if( jTextField1.getText().equals(""))
            {
                jLabel9.setVisible(true);
                jLabel9.setText("Some fields are missing");
            }
            else
            {
                

                stmt = con.createStatement();
                String query = "SELECT * FROM quizes";

                ResultSet rs = stmt.executeQuery(query);

                while(rs.next())
                {
                    if ((jTextField1.getText().equals(rs.getString(3))))
                    {
                        loopcheck = true;
                        QuizeCode = jTextField1.getText();
                        jLabel6.setText(rs.getString(3));
                        jLabel10.setText(rs.getString(2));  
                        jLabel9.setVisible(false);
                        jPanel2.setVisible(false);
                        jPanel3.setVisible(true);
                        attendenceCheck();
                    }
                }
                if(!loopcheck){

                    jLabel9.setVisible(true);jLabel9.setText("Quiz Not found");
                }
            
            }
        }
        catch(SQLException e){
            System.out.println("error cheking data");
        }
    }
    
    public void attendenceCheck(){
    
        try{
        
            boolean loopcheck2 = false;
            System.out.println("1");
            String st = "Completed";
            stmt = con.createStatement();
            String query2 = "SELECT * FROM `attendence`";
            ResultSet rs2= stmt.executeQuery(query2);
            System.out.println("1");
            while(rs2.next())
            {
                System.out.println("1"+QuizeCode+st+userid);
                
                if ( QuizeCode.equals(rs2.getString(1))  &&  st.equals(rs2.getString(3))  && userid.equals(rs2.getString(2)) )
                {
                    System.out.println("1");
                    loopcheck2 = true;
                    jPanel2.setVisible(false);
                    jPanel3.setVisible(false);
                    jPanel9.setVisible(false);
                    jPanel11.setVisible(false);
                    jPanel13.setVisible(true);
                }
            }
            if(!loopcheck2){

                getQuestionsAndAnswers ();

            }    
        }
        catch(SQLException e){
        
        }
    }
    
        public void getQuestionsAndAnswers (){
        
        try{
            boolean loopcheck = false;
            
            stmt = con.createStatement();
            String query = "SELECT * FROM quizlist";

            ResultSet rs = stmt.executeQuery(query);

            while(rs.next())
            {
                String Count = String.valueOf(Order);
                
                
                if (QuizeCode.equals(rs.getString(1)) && Count.equals(rs.getString(2)) )
                {
                    loopcheck = true;
//                    
//                    customloop  = true;
                    DBQuestion = rs.getString(3);question.setText(DBQuestion);
                            
                    DBAnswer1 = rs.getString(4); 
                            
                    DBAnswer2 = rs.getString(5); 
                    DBAnswer3 = rs.getString(6);
                            
                    DBAnswer4 = rs.getString(7); 

                    
                        c1.setText(DBAnswer1);
                        c2.setText(DBAnswer2);
                        c3.setText(DBAnswer3);
                        c4.setText(DBAnswer4);
                    
                    DBCorrectAsnswer = rs.getString(8);String CorrectAnswer = DBCorrectAsnswer;


                }
                
            }
            if(!loopcheck){
                
                if (!customloop){
                    
                    jPanel2.setVisible(false);
                    jPanel3.setVisible(false);
                    jPanel9.setVisible(false);
                    jPanel11.setVisible(true);
                    updateMarkAndAttendance();
                    
                    
                }
                else{

                    jPanel2.setVisible(false);
                    jPanel3.setVisible(false);
                    jPanel9.setVisible(true);
                }
                    
                }
                
     
        }
        catch(SQLException e){
            System.out.println("error cheking data");
        }
        
    }
    
    public void getAvailableQuizzList(){
    
        try{
            con = Database_connection_CLASS.connection();
            stmt = con.createStatement();
            String status = "Active";
            String query = "SELECT * FROM quizes";
            ResultSet rsd = stmt.executeQuery(query);

            while(rsd.next())
            {
                
                if(status.equals(rsd.getString(4))){
                    
                    String quizecode = rsd.getString(3);
                    String answer = rsd.getString(2);
                    String Byuser = rsd.getString(5);
                    AvailableQuiz item = new AvailableQuiz(quizecode,answer,Byuser);
                    list.add(item, "wrap, w 80%");
                    list.repaint();
                    list.revalidate();
                    
                }
                
            }
        }
        catch(SQLException e){
        
        }
    }
    public void checkAnswersAndupdateMArksheet(){
    
        try{
            
            if(c1.isSelected()){
                
                SelectedAnswer = "A";
                
            }
            else if(c2.isSelected()){
                SelectedAnswer = "B";
            }
            
            else if(c2.isSelected()){
                SelectedAnswer = "C";
            }
            else {
            
                SelectedAnswer = "D";
            }
            
            if (SelectedAnswer.equals(DBCorrectAsnswer)){
                
                Answer = "Correct";
                
            }
            else {
            
                Answer = "Wrong";
                
            }

   
        }
        catch(Exception e){
        
        }
    }
    
   
    public void updateMarksheet(){
    
        try{
        
            String stst = "Ongoing";
            con = Database_connection_CLASS.connection();
            stmt = con.createStatement();
            String query = "INSERT INTO `marks` (`quizcode`, `ordernumber`, `userid`, `appliedanswer`, `correctorwrong`, `status`) VALUES (?,?,?,?,?,?)";
            
            System.out.println(QuizeCode+String.valueOf(Order)+userid+SelectedAnswer+Answer+stst);
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1,QuizeCode);
            preparedStmt.setString(2,String.valueOf(Order));
            preparedStmt.setString(3, userid);
            preparedStmt.setString(4, SelectedAnswer);
            preparedStmt.setString(5, Answer);
            preparedStmt.setString(6, stst);
            preparedStmt.execute();
            
        }
        catch(SQLException e){
            System.out.println("Eroor");
        }
    }
    
    public void updateMarkAndAttendance (){
    
        try{
        
            int count = 1;
            String stst = "Finished";
            
            stmt = con.createStatement();
            String status = "Active";
            String query = "SELECT * FROM marks";
            ResultSet rsd = stmt.executeQuery(query);

            while(rsd.next())
            {
                
                if(QuizeCode.equals(rsd.getString(1)) && String.valueOf(count).equals(rsd.getString(2)) && userid.equals(rsd.getString(3)) ){
                    
                    String Query = "UPDATE `marks` SET `status` = ? WHERE `userid` = ?;";
                    PreparedStatement preparedStmt = con.prepareStatement(Query);
                    preparedStmt.setString(1, stst);
                    preparedStmt.setString(2, userid);
                    preparedStmt.execute();
            
                }
                
            }
            
            stmt = con.createStatement();
            String query2 = "INSERT INTO `attendence` (`quizcode`, `userid`, `status`) VALUES (?,?,?)";            
            String st = "Completed";
            PreparedStatement preparedStmt2 = con.prepareStatement(query2);
            preparedStmt2.setString(1,QuizeCode);
            preparedStmt2.setString(2,userid);
            preparedStmt2.setString(3, st);
            preparedStmt2.execute();
            

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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel5 = new javax.swing.JPanel();
        list = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        c1 = new javax.swing.JRadioButton();
        c2 = new javax.swing.JRadioButton();
        c4 = new javax.swing.JRadioButton();
        c3 = new javax.swing.JRadioButton();
        jButton3 = new javax.swing.JButton();
        question = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI Semilight", 0, 24)); // NOI18N
        jLabel3.setText("Available Quizzes");

        list.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout listLayout = new javax.swing.GroupLayout(list);
        list.setLayout(listLayout);
        listLayout.setHorizontalGroup(
            listLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1492, Short.MAX_VALUE)
        );
        listLayout.setVerticalGroup(
            listLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 708, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(list, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(list, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel5);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1331, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1471, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(159, 159, 159))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 164, -1, 610));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semilight", 0, 24)); // NOI18N
        jLabel1.setText("Enter Quiz code to partcipate to the Quiz");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 0, 458, 41));

        jLabel2.setText("* ask to teacher to provide correct quize code *");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 458, -1));
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 458, 40));

        jButton1.setText("Enter");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, 173, 40));

        jLabel9.setText("jLabel9");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 458, 28));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(255, 255, 78));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 7, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 7, 70));

        jLabel5.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Quiz Code");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 160, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Question");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 150, 47));

        jLabel7.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Questions List");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 109, 47));

        c1.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        c1.setText("jRadioButton1");
        jPanel3.add(c1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 1402, 44));

        c2.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        c2.setText("jRadioButton1");
        jPanel3.add(c2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 1402, 44));

        c4.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        c4.setText("jRadioButton1");
        jPanel3.add(c4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 1402, 44));

        c3.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        c3.setText("jRadioButton1");
        jPanel3.add(c3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 1402, 44));

        jButton3.setText("Submit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 200, 40));

        question.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        question.setForeground(new java.awt.Color(102, 102, 102));
        question.setText("Questions");
        jPanel3.add(question, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 1632, 47));

        jLabel8.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Quiz Titel");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 786, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Question");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 1038, 47));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(255, 255, 78));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 7, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        jPanel9.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 7, 70));

        jLabel12.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("Status");
        jPanel9.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 160, 30));

        jLabel13.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("No Questions and anwers available at the movement please try again later");
        jPanel9.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 610, 47));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel12.setBackground(new java.awt.Color(255, 255, 78));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 7, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        jPanel11.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 7, 70));

        jLabel14.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 102, 102));
        jLabel14.setText("Status");
        jPanel11.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 160, 30));

        jLabel17.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setText("Summary of the quiz");
        jPanel11.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 610, 47));

        jLabel18.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(102, 102, 102));
        jLabel18.setText("Correct answers");
        jPanel11.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 140, 47));

        jLabel20.setFont(new java.awt.Font("Segoe UI Semilight", 0, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(102, 102, 102));
        jLabel20.setText("50");
        jPanel11.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 140, 47));

        jLabel21.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(102, 102, 102));
        jLabel21.setText("Excellent you have been successfully completed the quiz");
        jPanel11.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 610, 47));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel14.setBackground(new java.awt.Color(0, 204, 102));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 7, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        jPanel13.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 7, 70));

        jLabel16.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 102, 102));
        jLabel16.setText("Status");
        jPanel13.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 160, 30));

        jLabel23.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(102, 102, 102));
        jLabel23.setText("Here is the Summary of the quiz you gave done..!");
        jPanel13.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 610, 47));

        jLabel24.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(102, 102, 102));
        jLabel24.setText("Correct answers");
        jPanel13.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 140, 47));

        jLabel26.setFont(new java.awt.Font("Segoe UI Semilight", 0, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(102, 102, 102));
        jLabel26.setText("50");
        jPanel13.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 140, 47));

        jLabel27.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(102, 102, 102));
        jLabel27.setText("You have been already done this Quiz");
        jPanel13.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 610, 47));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(48, 48, 48)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(38, 38, 38)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(2, 2, 2)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(221, 221, 221)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(1, 1, 1)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(217, 217, 217)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(207, 207, 207)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(222, 222, 222)))
        );

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        checkQuizz();
       
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
            checkAnswersAndupdateMArksheet();
            updateMarksheet();
            Order++;
            getQuestionsAndAnswers ();
            
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton c1;
    private javax.swing.JRadioButton c2;
    private javax.swing.JRadioButton c3;
    private javax.swing.JRadioButton c4;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel list;
    private javax.swing.JLabel question;
    // End of variables declaration//GEN-END:variables
}
