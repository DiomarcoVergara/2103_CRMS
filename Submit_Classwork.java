
package UI;


import DB.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Submit_Classwork extends javax.swing.JFrame {
          private int classworkId;
          private int classId;
          private int studentId;
    /**
     * Creates new form Submit_Classwork
     */
    public Submit_Classwork(int classworkId, int classId, int studentId) {
        this.classworkId = classworkId;
        this.classId = classId; // Pass classId
        this.studentId = studentId; // Pass studentId
        initComponents();
        loadClassworkDetails();
    } 
    
    private void loadClassworkDetails() {
        try {
            DBConnect db = new DBConnect();
            Connection conn = db.getConnection();

            String query = "SELECT Classwork_Name, Classwork_Instruction FROM classwork WHERE Classwork_ID = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, classworkId);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                TitleTextField.setText(rs.getString("Classwork_Name"));
                ClassInstructionTextArea.setText(rs.getString("Classwork_Instruction"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to load classwork details.");
        }
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TitleTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        ClassInstructionTextArea = new javax.swing.JTextArea();
        AnswerTextField = new javax.swing.JTextField();
        SubmitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TitleTextField.setBorder(javax.swing.BorderFactory.createTitledBorder("TITLE"));

        ClassInstructionTextArea.setColumns(20);
        ClassInstructionTextArea.setRows(5);
        ClassInstructionTextArea.setBorder(javax.swing.BorderFactory.createTitledBorder("INSTRUCTION"));
        jScrollPane1.setViewportView(ClassInstructionTextArea);

        AnswerTextField.setText("jTextField1");
        AnswerTextField.setBorder(javax.swing.BorderFactory.createTitledBorder("ANSWER"));

        SubmitButton.setText("SUBMIT");
        SubmitButton.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        SubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(AnswerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SubmitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(12, 12, 12))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                            .addComponent(TitleTextField))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(SubmitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TitleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AnswerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitButtonActionPerformed
         String answer = AnswerTextField.getText().trim();

        if (answer.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Answer cannot be empty. Please provide your answer before submitting.");
            return;
        }

        try {
            DBConnect db = new DBConnect();
            Connection conn = db.getConnection();

            String query = "INSERT INTO submission (Submission_Date, Answer, Classwork_ID, Class_ID, Student_ID) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setDate(1, new java.sql.Date(System.currentTimeMillis())); 
            ps.setString(2, answer); 
            ps.setInt(3, classworkId); 
            ps.setInt(4, classId);
            ps.setInt(5, studentId); 

            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Submission Successful!");

            // Redirect back to the Student Dashboard
            new Student_Class_Dashboard("Sample Class", "SUB123", classId, studentId).setVisible(true);
            this.dispose();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to submit assignment. Please try again later.");
        }
    }//GEN-LAST:event_SubmitButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Submit_Classwork(1, 1, 1).setVisible(true); // Pass mock IDs for testing
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AnswerTextField;
    private javax.swing.JTextArea ClassInstructionTextArea;
    private javax.swing.JButton SubmitButton;
    private javax.swing.JTextField TitleTextField;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
