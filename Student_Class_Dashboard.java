
package UI;

import DB.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Student_Class_Dashboard extends javax.swing.JFrame {
     private String className;
    private String subjectCode;
    private int classId;
    private int studentId;

    // Constructor with parameters
    public Student_Class_Dashboard(String className, String subjectCode, int classId, int studentId) {
        initComponents();
        this.className = className;
        this.subjectCode = subjectCode;
        this.classId = classId;
        this.studentId = studentId;

        // Set class details in UI
        Name_and_Subject_code_txt.setText("Class: " + className + "\nSubject Code: " + subjectCode);

        // Load announcements
        loadAnnouncements();
        loadStudents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ClassHomePane = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        ClassName_SubjectCodePane = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Name_and_Subject_code_txt = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        Display_All_Announcements_txtArea = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        List_of_students_Table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 791, Short.MAX_VALUE)
                .addContainerGap())
        );
        ClassName_SubjectCodePaneLayout.setVerticalGroup(
            ClassName_SubjectCodePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ClassName_SubjectCodePaneLayout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Display_All_Announcements_txtArea.setColumns(20);
        Display_All_Announcements_txtArea.setRows(5);
        jScrollPane3.setViewportView(Display_All_Announcements_txtArea);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ClassName_SubjectCodePane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(ClassName_SubjectCodePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE))
        );

        ClassHomePane.addTab("HOME", jPanel3);

        List_of_students_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Classmates"
            }
        ));
        jScrollPane4.setViewportView(List_of_students_Table);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 797, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                .addGap(51, 51, 51))
        );

        ClassHomePane.addTab("PEOPLE", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(ClassHomePane)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ClassHomePane)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
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

            System.out.println("Executing query for classId: " + classId);  // Debugging line
            
            ResultSet rs = stmt.executeQuery();
            int rowCount = 0;  

            // Loop through the result set and append each announcement to the text area
            while (rs.next()) {
                String content = rs.getString("Content");
                String datePosted = rs.getString("Date_Posted");
                String teacherName = rs.getString("TeacherName");

                // Format and display each announcement
                Display_All_Announcements_txtArea.append("Teacher: " + teacherName + "\n" +
                                                         "Announcement: " + content + "\n" +
                                                         "Date: " + datePosted + "\n\n");
                rowCount++;
            }

            // If no announcements were found, display a message
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
    model.setRowCount(0); // Clear the table

    try (Connection conn = new DBConnect().getConnection()) {
        String sql = "SELECT s.Name, s.Student_ID " +
                     "FROM student s " +
                     "JOIN enrollment ce ON s.Student_ID = ce.Student_ID " +
                     "WHERE ce.Class_ID = ?"; 
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, classId);  // Set the class ID for the query

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            String studentName = rs.getString("Name");
            
            // Add the student details to the table
            model.addRow(new Object[]{studentName});
        }

        if (model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "No students found for this class.", "Information", JOptionPane.INFORMATION_MESSAGE);
        }

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error loading students.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              String className = "Math 101";
            String subjectCode = "MTH101";
            int classId = 1;
            int studentId = 123;

            new Student_Class_Dashboard(className, subjectCode, classId, studentId).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane ClassHomePane;
    private javax.swing.JPanel ClassName_SubjectCodePane;
    private javax.swing.JTextArea Display_All_Announcements_txtArea;
    private javax.swing.JTable List_of_students_Table;
    private javax.swing.JTextArea Name_and_Subject_code_txt;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables
}
