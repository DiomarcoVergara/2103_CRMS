
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
    private Connection konek;

    // Constructor with parameters
    public Student_Class_Dashboard(String className, String subjectCode, int classId, int studentId) {
         initComponents();
        this.className = className;
        this.subjectCode = subjectCode;
        this.classId = classId;
        this.studentId = studentId;

        // Set class details in the UI
        Name_and_Subject_code_txt.setText("Class: " + className + "\nSubject Code: " + subjectCode);

        loadAssignments();
        loadAnnouncements();
        loadStudents();
    }
        public int getClassId() {
        return classId;
    }

    public int getStudentId() {
        return studentId;
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
        jPanel1 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        ClassWorkTable = new javax.swing.JTable();
        OpenAssButton = new javax.swing.JButton();
        ViewAllClassesButton = new javax.swing.JButton();

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
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE))
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
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 789, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        ClassHomePane.addTab("PEOPLE", jPanel4);

        ClassWorkTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Classwork ID", "Title", "Due Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(ClassWorkTable);

        OpenAssButton.setText("Open");
        OpenAssButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenAssButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 782, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OpenAssButton, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(OpenAssButton)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        ClassHomePane.addTab("CLASSWORK", jPanel1);

        ViewAllClassesButton.setText("All Classes");
        ViewAllClassesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewAllClassesButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(ViewAllClassesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(ClassHomePane)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ClassHomePane)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(ViewAllClassesButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ViewAllClassesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewAllClassesButtonActionPerformed
        StudentDashboard studentDashboard = new StudentDashboard();
                studentDashboard.setVisible(true);
                this.dispose();
    }//GEN-LAST:event_ViewAllClassesButtonActionPerformed
        private int getSelectedClassworkId() {
        int selectedRow = ClassWorkTable.getSelectedRow();
        if (selectedRow != -1) {
            return Integer.parseInt(ClassWorkTable.getValueAt(selectedRow, 0).toString()); // Assuming the first column stores classwork IDs
        } else {
            JOptionPane.showMessageDialog(this, "Please select a classwork.");
            return 0;
        }
    }
    private void OpenAssButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenAssButtonActionPerformed
         int classworkId = getSelectedClassworkId(); // Retrieve the selected classwork ID
    if (classworkId == 0) return; // If no classwork is selected, return
    
    // Retrieve classId and studentId (You may need to get these values from elsewhere in your app)
    int classId = getClassId();  // Assume this method retrieves the current class ID
    int studentId = getStudentId();  // Assume this method retrieves the current student ID
    
    // Pass all three parameters to the Submit_Classwork constructor
    Submit_Classwork submitClasswork = new Submit_Classwork(classworkId, classId, studentId);
    submitClasswork.setVisible(true);
    this.dispose();

    }//GEN-LAST:event_OpenAssButtonActionPerformed
    public void loadAssignments() {
        DefaultTableModel tableModel = (DefaultTableModel) ClassWorkTable.getModel();
        // Clear any existing data
        tableModel.setRowCount(0);

        try {
            // Query to get assignments for the given class ID
            String query = "SELECT Classwork_ID, Classwork_Name, Due_Date FROM classwork WHERE Class_ID = ?";
            DBConnect dbcon = new DBConnect();
            Connection konek = dbcon.getConnection();
            PreparedStatement stmt = konek.prepareStatement(query);
            stmt.setInt(1, classId); // Set classId in the query
            ResultSet rs = stmt.executeQuery();

            // Process the result set and add rows to the table
            while (rs.next()) {
                int classworkId = rs.getInt("Classwork_ID");
                String title = rs.getString("Classwork_Name");
                String dueDate = rs.getString("Due_Date");

                // Add a new row with the data to the table model
                tableModel.addRow(new Object[] { classworkId, title, dueDate });
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error loading assignments.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
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
    private javax.swing.JTable ClassWorkTable;
    private javax.swing.JTextArea Display_All_Announcements_txtArea;
    private javax.swing.JTable List_of_students_Table;
    private javax.swing.JTextArea Name_and_Subject_code_txt;
    private javax.swing.JButton OpenAssButton;
    private javax.swing.JButton ViewAllClassesButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    // End of variables declaration//GEN-END:variables
}
