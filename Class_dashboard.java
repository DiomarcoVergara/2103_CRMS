
package UI;

import Classes.User;
import DB.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Class_dashboard extends javax.swing.JFrame {
       private int classId;
    private String className;
    private int teacherId;

    public Class_dashboard(int classId, String className, int teacherId) {
        this.classId = classId;
        this.className = className;
        this.teacherId = teacherId; 
        System.out.println("Class ID: " + classId); 
        System.out.println("Class Name: " + className); 
        System.out.println("Teacher ID: " + teacherId); 
        initComponents();
        setTitle("Class Dashboard - " + className);
        populateClassDetails();
        loadAnnouncements();
        loadStudents(); 
    }



    private void populateClassDetails() {
    // Set class ID
    ClassIDtxtpane.setText(String.valueOf(classId));

    try (Connection conn = new DBConnect().getConnection()) {
        String sql = "SELECT c.Class_Name, s.Subject_Code " +
                     "FROM classroom c " +
                     "JOIN subject s ON c.Subject_Code = s.Subject_Code " +
                     "WHERE c.Class_ID = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, classId);

        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            String className = rs.getString("Class_Name");
            String subjectCode = rs.getString("Subject_Code");
            // Update the text area with class details
            Name_and_Subject_code_txt.setText("Class Name: " + className + "\nSubject Code: " + subjectCode);
        } else {
            JOptionPane.showMessageDialog(this, "Class details not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error loading class details.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    
    /**
     * Creates new form Class_dashboard
     */
    public Class_dashboard() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ClassHomePane = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        ClassName_SubjectCodePane = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Name_and_Subject_code_txt = new javax.swing.JTextArea();
        announcementtxtfield = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        ClassIDtxtpane = new javax.swing.JTextPane();
        CancelAnnouncementButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        Display_All_Announcements_txtArea = new javax.swing.JTextArea();
        PostAnnouncementButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        List_of_students_Table = new javax.swing.JTable();
        RemovesStudentButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        ViewAllClassesButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        ClassName_SubjectCodePane.setBackground(new java.awt.Color(126, 217, 87));

        Name_and_Subject_code_txt.setColumns(20);
        Name_and_Subject_code_txt.setRows(5);
        jScrollPane1.setViewportView(Name_and_Subject_code_txt);

        javax.swing.GroupLayout ClassName_SubjectCodePaneLayout = new javax.swing.GroupLayout(ClassName_SubjectCodePane);
        ClassName_SubjectCodePane.setLayout(ClassName_SubjectCodePaneLayout);
        ClassName_SubjectCodePaneLayout.setHorizontalGroup(
            ClassName_SubjectCodePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ClassName_SubjectCodePaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        ClassName_SubjectCodePaneLayout.setVerticalGroup(
            ClassName_SubjectCodePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ClassName_SubjectCodePaneLayout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        announcementtxtfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                announcementtxtfieldActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(ClassIDtxtpane);

        CancelAnnouncementButton.setText("Cancel");
        CancelAnnouncementButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelAnnouncementButtonActionPerformed(evt);
            }
        });

        Display_All_Announcements_txtArea.setColumns(20);
        Display_All_Announcements_txtArea.setRows(5);
        jScrollPane3.setViewportView(Display_All_Announcements_txtArea);

        PostAnnouncementButton.setText("POST");
        PostAnnouncementButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PostAnnouncementButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Class Code");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ClassName_SubjectCodePane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(announcementtxtfield, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CancelAnnouncementButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(PostAnnouncementButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jScrollPane3))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(ClassName_SubjectCodePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(announcementtxtfield)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(CancelAnnouncementButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addComponent(PostAnnouncementButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE))
        );

        ClassHomePane.addTab("HOME", jPanel3);

        List_of_students_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Student Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(List_of_students_Table);

        RemovesStudentButton.setText("Remove");
        RemovesStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemovesStudentButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 797, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(RemovesStudentButton)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RemovesStudentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        ClassHomePane.addTab("PEOPLE", jPanel4);

        jPanel2.setBackground(new java.awt.Color(126, 217, 87));

        ViewAllClassesButton.setText("View all");
        ViewAllClassesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewAllClassesButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(ViewAllClassesButton)
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(ViewAllClassesButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ClassHomePane)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ClassHomePane)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PostAnnouncementButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PostAnnouncementButtonActionPerformed
            String announcement = announcementtxtfield.getText().trim();

    if (announcement.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Announcement cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

            // Get the logged-in user
        User user = User.getLoggedInUser();
        if (user == null) {
            JOptionPane.showMessageDialog(this, "No user is logged in.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int currentTeacherId = user.getTeacherId(); // Get the logged-in teacher's ID
        if (currentTeacherId == 0) {
            JOptionPane.showMessageDialog(this, "Teacher ID not found.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        
        try (Connection conn = new DBConnect().getConnection()) {
            String sql = "INSERT INTO announcement (Class_ID, Teacher_ID, Content) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, classId); // Class ID
            stmt.setInt(2, currentTeacherId); // Set current Teacher_ID
            stmt.setString(3, announcement); // Announcement content

            int rowsInserted = stmt.executeUpdate();

            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "Announcement posted successfully!");
                loadAnnouncements(); // Refresh the announcements list
                announcementtxtfield.setText(""); // Clear the announcement text field
            } else {
                JOptionPane.showMessageDialog(this, "Failed to post the announcement.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database error occurred.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_PostAnnouncementButtonActionPerformed
    private void loadAnnouncements() {
    Display_All_Announcements_txtArea.setText(""); // Clear previous content

    try (Connection conn = new DBConnect().getConnection()) {
        String sql = "SELECT a.Content, a.Date_Posted, t.Name AS TeacherName " +
                     "FROM announcement a " +
                     "JOIN teacher t ON t.Teacher_ID = a.Teacher_ID " +
                     "WHERE a.Class_ID = ? " +
                     "ORDER BY a.Date_Posted DESC";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, classId);

        System.out.println("Executing query for classId: " + classId); 
        ResultSet rs = stmt.executeQuery();
        int rowCount = 0;  // To count the rows

        while (rs.next()) {
            String content = rs.getString("Content");
            String datePosted = rs.getString("Date_Posted");
            String teacherName = rs.getString("TeacherName");

            // Display the announcement in the text area
            Display_All_Announcements_txtArea.append("Teacher: " + teacherName + "\n" +
                                                     "Announcement: " + content + "\n" +
                                                     "Date: " + datePosted + "\n\n");
            rowCount++;
        }

        if (rowCount == 0) {
            Display_All_Announcements_txtArea.append("No announcements found for this class.\n");
        }

    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error loading announcements.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

private void loadStudents() {
    // Clear previous data from the table
    DefaultTableModel model = (DefaultTableModel) List_of_students_Table.getModel();
    model.setRowCount(0); 

    try (Connection conn = new DBConnect().getConnection()) {
        String sql = "SELECT s.Name, s.Student_ID " +
                     "FROM student s " +
                     "JOIN enrollment ce ON s.Student_ID = ce.Student_ID " +
                     "WHERE ce.Class_ID = ?"; // Query to get students for the current class
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, classId);  // Set the class ID for the query

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            String studentName = rs.getString("Name");
            int studentId = rs.getInt("Student_ID");
            // Add the student details to the table
            model.addRow(new Object[]{studentName, studentId});
        }
        

        if (model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "No students found for this class.", "Information", JOptionPane.INFORMATION_MESSAGE);
        }

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error loading students.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}



    private void CancelAnnouncementButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelAnnouncementButtonActionPerformed
        announcementtxtfield.setText("");
    }//GEN-LAST:event_CancelAnnouncementButtonActionPerformed

    private void announcementtxtfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_announcementtxtfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_announcementtxtfieldActionPerformed

    private void ViewAllClassesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewAllClassesButtonActionPerformed
        this.dispose();
        new Teacher_classlist_dashboard().setVisible(true);
    }//GEN-LAST:event_ViewAllClassesButtonActionPerformed
      

   
    private void RemovesStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemovesStudentButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RemovesStudentButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Class_dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelAnnouncementButton;
    private javax.swing.JTabbedPane ClassHomePane;
    private javax.swing.JTextPane ClassIDtxtpane;
    private javax.swing.JPanel ClassName_SubjectCodePane;
    private javax.swing.JTextArea Display_All_Announcements_txtArea;
    private javax.swing.JTable List_of_students_Table;
    private javax.swing.JTextArea Name_and_Subject_code_txt;
    private javax.swing.JButton PostAnnouncementButton;
    private javax.swing.JButton RemovesStudentButton;
    private javax.swing.JButton ViewAllClassesButton;
    private javax.swing.JTextField announcementtxtfield;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables
}
