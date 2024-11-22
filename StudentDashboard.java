
package UI;


import Classes.User;
import DB.DatabaseConnector;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.JOptionPane;

public class StudentDashboard extends javax.swing.JFrame {
    private int studentId; // Store the student ID
    private Connection konek;

    public StudentDashboard() {
    
    User loggedInUser = User.getLoggedInUser();
    if (loggedInUser != null) {
        this.studentId = loggedInUser.getStudentId();
        try {
            this.konek = DatabaseConnector.getConnection(); 
        } catch (SQLException e) {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "Error establishing database connection: " + e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }
    
    initComponents();
    loadClasses();
}


    private void loadClasses() {
    // Ensure the classTable model is correctly linked
    DefaultTableModel model = (DefaultTableModel) classTable.getModel();

    // Clear any existing rows
    model.setRowCount(0);

    // Validate database connection and student ID
    if (konek == null || studentId == 0) {
        JOptionPane.showMessageDialog(this, 
            "Unable to load classes. Database connection or student ID is invalid.", 
            "Error", 
            JOptionPane.ERROR_MESSAGE);
        return;
    }

    
    String sql = "SELECT c.Class_ID, c.Class_Name, c.Subject_Code, c.Section " +
                 "FROM classroom c " +
                 "INNER JOIN enrollment e ON c.Class_ID = e.Class_ID " +
                 "WHERE e.Student_ID = ?";

    try (PreparedStatement pstmt = konek.prepareStatement(sql)) {
        // Bind the studentId parameter
        pstmt.setInt(1, studentId);

        // Execute the query
        ResultSet rs = pstmt.executeQuery();

        // Populate the table with data from the query
        while (rs.next()) {
            int classId = rs.getInt("Class_ID");
            String className = rs.getString("Class_Name");
            String subjectCode = rs.getString("Subject_Code");
            String section = rs.getString("Section");

            // Add the row to the table model
            model.addRow(new Object[]{classId, className, subjectCode, section});
        }

        // Check if no classes were found
        if (model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, 
                "No classes found for the current student.", 
                "Info", 
                JOptionPane.INFORMATION_MESSAGE);
        }
    } catch (SQLException e) {
        // Handle SQL exceptions
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, 
            "Error loading classes: " + e.getMessage(), 
            "Error", 
            JOptionPane.ERROR_MESSAGE);
    }
}



    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        JoinNewButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        classTable = new javax.swing.JTable();
        openClassButton = new javax.swing.JButton();
        openclassButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(126, 217, 87));

        JoinNewButton.setText("Join new Class");
        JoinNewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JoinNewButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JoinNewButton)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(JoinNewButton)
                .addContainerGap(453, Short.MAX_VALUE))
        );

        classTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Class ID", "Class Name", "Subject Code", "Section"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(classTable);

        openClassButton.setText("Open Class");

        openclassButton.setText("Open Class");
        openclassButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openclassButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(582, Short.MAX_VALUE)
                .addComponent(openclassButton)
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1)
                    .addContainerGap()))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(openClassButton)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(openclassButton)
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(40, 40, 40)))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(openClassButton)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JoinNewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JoinNewButtonActionPerformed
        this.dispose();
        Join_Class_form joinnew = new Join_Class_form();
        joinnew.setVisible(true);
    }//GEN-LAST:event_JoinNewButtonActionPerformed

    private void openclassButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openclassButtonActionPerformed
         
    int selectedRow = classTable.getSelectedRow();
    if (selectedRow != -1) {
        // Fetch class details from the table
        String className = (String) classTable.getValueAt(selectedRow, 1); // Column index 1 for Class Name
        String subjectCode = (String) classTable.getValueAt(selectedRow, 2); // Column index 2 for Subject Code
        int classId = (int) classTable.getValueAt(selectedRow, 0); // Assuming column index 0 contains classId

        System.out.println("Opening Class: " + className + " (Subject Code: " + subjectCode + ", Class ID: " + classId + ")");

        // Check if the student ID is valid
        if (studentId == 0) {
            JOptionPane.showMessageDialog(this, "Student ID is not valid.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Dispose of the current dashboard
        this.dispose();

        // Open the Student Class Dashboard
        Student_Class_Dashboard dashboard = new Student_Class_Dashboard(className, subjectCode, classId, studentId);
        dashboard.setVisible(true);

    } else {
        JOptionPane.showMessageDialog(this, "No class selected.", "Error", JOptionPane.ERROR_MESSAGE);
    }


    }//GEN-LAST:event_openclassButtonActionPerformed
        
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JoinNewButton;
    private javax.swing.JTable classTable;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton openClassButton;
    private javax.swing.JButton openclassButton;
    // End of variables declaration//GEN-END:variables
}
