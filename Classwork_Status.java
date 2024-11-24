/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;



import DB.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Classwork_Status extends javax.swing.JFrame {
    private Connection konek;
    private DBConnect dbcon;
    private int classworkId;
    private int classId;

   
    public Classwork_Status(int classworkId) {
        initComponents();
        this.classworkId = classworkId;
        dbcon = new DBConnect();
        konek = dbcon.getConnection();
        fetchData(classworkId); 
    }

   
    private void fetchData(int classworkId) {
    try {
        
        String classworkQuery = "SELECT Classwork_Name, Classwork_Instruction, Class_ID FROM classwork WHERE Classwork_ID = ?";
        try (PreparedStatement pstmt = konek.prepareStatement(classworkQuery)) {
            pstmt.setInt(1, classworkId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                TitleTextField.setText(rs.getString("Classwork_Name"));
                ClassInstructionTextArea.setText(rs.getString("Classwork_Instruction"));
                classId = rs.getInt("Class_ID"); 
            }
        }

        int totalStudents = 0;
        int totalSubmissions = 0;


        String studentCountQuery = "SELECT COUNT(*) AS TotalStudents FROM enrollment WHERE Class_ID = ?";
        try (PreparedStatement pstmt2 = konek.prepareStatement(studentCountQuery)) {
            pstmt2.setInt(1, classId);
            ResultSet rs2 = pstmt2.executeQuery();
            if (rs2.next()) {
                totalStudents = rs2.getInt("TotalStudents"); 
            }
        }


        String submissionsQuery = "SELECT COUNT(*) AS TotalSubmissions FROM submission WHERE Classwork_ID = ?";
        try (PreparedStatement pstmt3 = konek.prepareStatement(submissionsQuery)) {
            pstmt3.setInt(1, classworkId);
            ResultSet rs3 = pstmt3.executeQuery();
            if (rs3.next()) {
                totalSubmissions = rs3.getInt("TotalSubmissions"); 
                TurnIntxt.setText(String.valueOf(totalSubmissions));
            } else {
                TurnIntxt.setText("0");
            }
        }

       
        int notTurnedIn = totalStudents - totalSubmissions;
        if (notTurnedIn < 0) {
            notTurnedIn = 0; 
        }
        AssignStudenttxt.setText(String.valueOf(notTurnedIn)); 

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error fetching data: " + e.getMessage());
    }
}




    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        TitleTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        ClassInstructionTextArea = new javax.swing.JTextArea();
        AssignStudenttxt = new javax.swing.JTextField();
        TurnIntxt = new javax.swing.JTextField();
        ViewSubmissiontxt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        TitleTextField.setBorder(javax.swing.BorderFactory.createTitledBorder("TITLE"));

        ClassInstructionTextArea.setColumns(20);
        ClassInstructionTextArea.setRows(5);
        ClassInstructionTextArea.setBorder(javax.swing.BorderFactory.createTitledBorder("INSTRUCTION"));
        jScrollPane1.setViewportView(ClassInstructionTextArea);

        AssignStudenttxt.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        AssignStudenttxt.setBorder(javax.swing.BorderFactory.createTitledBorder("ASSIGNED"));

        TurnIntxt.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        TurnIntxt.setBorder(javax.swing.BorderFactory.createTitledBorder("TURN IN"));

        ViewSubmissiontxt.setText("View Submissions");
        ViewSubmissiontxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewSubmissiontxtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AssignStudenttxt)
                            .addComponent(TurnIntxt)
                            .addComponent(ViewSubmissiontxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(TitleTextField))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TitleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(TurnIntxt, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AssignStudenttxt, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addComponent(ViewSubmissiontxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ViewSubmissiontxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewSubmissiontxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ViewSubmissiontxtActionPerformed

    /**
     * @param args the command line arguments
     */
   public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            int exampleClassworkId = 1; // Gamitin ang valid na ID mula sa iyong database
            new Classwork_Status(exampleClassworkId).setVisible(true);
        }
    });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AssignStudenttxt;
    private javax.swing.JTextArea ClassInstructionTextArea;
    private javax.swing.JTextField TitleTextField;
    private javax.swing.JTextField TurnIntxt;
    private javax.swing.JButton ViewSubmissiontxt;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
