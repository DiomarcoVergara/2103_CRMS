package Classes;

import DB.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Student {
        
    // Database connection utility
    private Connection connectDatabase() {
        DBConnect dbcon = new DBConnect();
        return dbcon.getConnection();
    }

    // Method for a student to join a class
    public boolean joinClass(String classCode) {
        if (classCode == null || classCode.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Class code cannot be empty.");
            return false;
        }

        // Retrieve the logged-in user
        User loggedInUser = User.getLoggedInUser();
        if (loggedInUser == null || loggedInUser.getRole() == null || !"Student".equalsIgnoreCase(loggedInUser.getRole())) {
            JOptionPane.showMessageDialog(null, "You must be logged in as a student to join a class.");
            return false;
        }

        int studentId = loggedInUser.getStudentId();
        if (studentId == 0) {
            JOptionPane.showMessageDialog(null, "Unable to retrieve student ID. Please log in again.");
            return false;
        }

        try (Connection conn = connectDatabase()) {
            if (conn == null) {
                JOptionPane.showMessageDialog(null, "Failed to connect to the database.");
                return false;
            }

            // Find class ID based on class code
            String findClassQuery = "SELECT Class_ID FROM classroom WHERE Class_ID = ?";
            try (PreparedStatement findClassStmt = conn.prepareStatement(findClassQuery)) {
                findClassStmt.setString(1, classCode);
                try (ResultSet classResult = findClassStmt.executeQuery()) {
                    if (classResult.next()) {
                        int classId = classResult.getInt("Class_ID");

                        // Check if the student is already enrolled
                        String checkEnrollmentQuery = "SELECT * FROM enrollment WHERE Student_ID = ? AND Class_ID = ?";
                        try (PreparedStatement checkEnrollmentStmt = conn.prepareStatement(checkEnrollmentQuery)) {
                            checkEnrollmentStmt.setInt(1, studentId);
                            checkEnrollmentStmt.setInt(2, classId);
                            try (ResultSet enrollmentResult = checkEnrollmentStmt.executeQuery()) {
                                if (enrollmentResult.next()) {
                                    JOptionPane.showMessageDialog(null, "You are already enrolled in this class.");
                                    return false;
                                }
                            }
                        }

                        // Enroll the student in the class
                        String enrollQuery = "INSERT INTO enrollment (Student_ID, Class_ID) VALUES (?, ?)";
                        try (PreparedStatement enrollStmt = conn.prepareStatement(enrollQuery)) {
                            enrollStmt.setInt(1, studentId);
                            enrollStmt.setInt(2, classId);
                            int rowsInserted = enrollStmt.executeUpdate();

                            if (rowsInserted > 0) {
                                JOptionPane.showMessageDialog(null, "Successfully joined the class!");
                                return true;
                            } else {
                                JOptionPane.showMessageDialog(null, "Failed to join the class.");
                                return false;
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Class code not found.");
                        return false;
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "An error occurred: " + ex.getMessage());
            return false;
        }
    }
}
