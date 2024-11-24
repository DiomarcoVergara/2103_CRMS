
package UI;

import Classes.Teacher;
import Classes.User;
import DB.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Classwork_form extends javax.swing.JFrame {
     private int classId;
    private Connection konek;
    private DBConnect dbcon;

    public Classwork_form(int classId) {
        this.classId = classId;
        initComponents();
        
        // Initialize DB connection
        dbcon = new DBConnect();
        konek = dbcon.getConnection();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ClassWorkTitletxt = new javax.swing.JTextField();
        Instructiontxt = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        Pointstxt = new javax.swing.JTextField();
        Duedatetxt = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        AssignButton = new javax.swing.JButton();
        BackButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        ClassWorkTitletxt.setBorder(javax.swing.BorderFactory.createTitledBorder("Title"));

        Instructiontxt.setBorder(javax.swing.BorderFactory.createTitledBorder("Instruction"));
        Instructiontxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InstructiontxtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Instructiontxt, javax.swing.GroupLayout.DEFAULT_SIZE, 662, Short.MAX_VALUE)
                    .addComponent(ClassWorkTitletxt))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(ClassWorkTitletxt, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Instructiontxt, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(216, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        Pointstxt.setBorder(javax.swing.BorderFactory.createTitledBorder("Points"));

        Duedatetxt.setBorder(javax.swing.BorderFactory.createTitledBorder("Due Date"));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Duedatetxt, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                    .addComponent(Pointstxt))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(Pointstxt, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Duedatetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(362, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Assignment");

        AssignButton.setBackground(new java.awt.Color(126, 217, 87));
        AssignButton.setText("ASSIGN");
        AssignButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AssignButtonActionPerformed(evt);
            }
        });

        BackButton.setText("<");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(AssignButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AssignButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 8, Short.MAX_VALUE)))
                        .addGap(10, 10, 10)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void InstructiontxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InstructiontxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InstructiontxtActionPerformed

    private void AssignButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AssignButtonActionPerformed
        String title = ClassWorkTitletxt.getText();
    String instruction = Instructiontxt.getText();
    String dueDate = Duedatetxt.getText();
    String pointsText = Pointstxt.getText();

    int points;
    try {
        points = Integer.parseInt(pointsText); // Validate numeric points
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Please enter a valid number for points.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        return;
    }

  
    if (title.isEmpty() || instruction.isEmpty() || dueDate.isEmpty()) {
        JOptionPane.showMessageDialog(this, "All fields are required.", "Missing Information", JOptionPane.ERROR_MESSAGE);
        return;
    }

  
    int loggedInTeacherId = User.getLoggedInUser().getTeacherId(); 
    String teacherName = User.getLoggedInUser().getName(); 


    String className = getClassNameById(classId); 

    Teacher teacher = new Teacher(loggedInTeacherId, teacherName);

    boolean success = teacher.addAssignment(classId, title, instruction, dueDate, points);


    if (success) {
        JOptionPane.showMessageDialog(this, "Assignment added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

        ClassWorkTitletxt.setText("");
        Instructiontxt.setText("");
        Duedatetxt.setText("");
        Pointstxt.setText("");
        
 
        Class_dashboard classDashboard = new Class_dashboard(classId, className, loggedInTeacherId);
        classDashboard.setVisible(true); 
        this.dispose();
    } else {
        JOptionPane.showMessageDialog(this, "Failed to add assignment.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_AssignButtonActionPerformed
    public String getClassNameById(int classId) {
        String query = "SELECT Class_Name FROM classroom WHERE Class_ID = ?";
        try (PreparedStatement ps = konek.prepareStatement(query)) {
            ps.setInt(1, classId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("Class_Name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; 
    }
    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        int classId = this.classId; 
    String className = getClassNameById(classId);
    int teacherId = User.getLoggedInUser().getTeacherId();

    
    Class_dashboard classDashboard = new Class_dashboard(classId, className, teacherId);

    // Reload data in Class_dashboard
    classDashboard.populateClassDetails();
    classDashboard.loadAnnouncements();
    classDashboard.loadStudents();
    classDashboard.loadAssignments();

    // Make Class_dashboard visible
    classDashboard.setVisible(true);

    // Hide the current screen (Classwork_form)
    this.setVisible(false);
    }//GEN-LAST:event_BackButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               new Classwork_form(1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AssignButton;
    private javax.swing.JButton BackButton;
    private javax.swing.JTextField ClassWorkTitletxt;
    private javax.swing.JTextField Duedatetxt;
    private javax.swing.JTextField Instructiontxt;
    private javax.swing.JTextField Pointstxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
