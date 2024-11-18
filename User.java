package Classes;

import DB.DBConnect;
import UI.Create_Class_form;
import UI.Teacher_classlist_dashboard;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class User {
    private String email;
    private String password;
    private String role;
    private int teacherId;  // Store teacher ID
    private int studentId;  // Store student ID
    private Connection konek;
    private DBConnect dbcon;

    // Static variable to store the logged-in user
    private static User loggedInUser = null;

    // Constructor for login
    public User(String email, String password) {
        this.email = email;
        this.password = password;
        dbcon = new DBConnect(); // Initialize DB connection
        konek = dbcon.getConnection(); // Obtain connection
    }

    // Constructor for general use
    public User() {
        dbcon = new DBConnect(); // Initialize DB connection
        konek = dbcon.getConnection(); // Obtain connection
    }

    public String getRole() {
        return role;
    }

    // Get the teacher ID
    public int getTeacherId() {
        return teacherId;
    }

    // Get the student ID
    public int getStudentId() {
        return studentId;
    }

    // Static method to get the logged-in user
    public static User getLoggedInUser() {
        return loggedInUser;
    }

    // Method for login
   public boolean login() {
    if (konek == null) {
        JOptionPane.showMessageDialog(null, "Database connection failed.", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    String sql = "SELECT * FROM user WHERE Email = ? AND Password = ?";

    try (PreparedStatement pstmt = konek.prepareStatement(sql)) {
        pstmt.setString(1, this.email);
        pstmt.setString(2, this.password);

        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            this.role = rs.getString("role");

            if ("Teacher".equalsIgnoreCase(role)) {
                // Retrieve Teacher ID
                String teacherSql = "SELECT Teacher_ID FROM teacher WHERE User_ID = ?";
                try (PreparedStatement teacherPstmt = konek.prepareStatement(teacherSql)) {
                    teacherPstmt.setInt(1, rs.getInt("User_ID")); 
                    ResultSet teacherRs = teacherPstmt.executeQuery();
                    if (teacherRs.next()) {
                        this.teacherId = teacherRs.getInt("Teacher_ID");
                    }
                }

                loggedInUser = this;

                // Check if the teacher has created a classroom
                if (this.hasCreatedClassroom()) {
                    // Redirect to Teacher_Classlist_Dashboard
                    new Teacher_classlist_dashboard().setVisible(true);
                } else {
                    // Redirect to Create_Class_Form
                    JOptionPane.showMessageDialog(null, "No classes found. Redirecting to Create Class Form.", "Info", JOptionPane.INFORMATION_MESSAGE);
                    new Create_Class_form().setVisible(true);
                }
                return true;
            } else if ("Student".equalsIgnoreCase(role)) {
                // Retrieve Student ID
                String studentSql = "SELECT Student_ID FROM student WHERE User_ID = ?";
                try (PreparedStatement studentPstmt = konek.prepareStatement(studentSql)) {
                    studentPstmt.setInt(1, rs.getInt("User_ID")); 
                    ResultSet studentRs = studentPstmt.executeQuery();
                    if (studentRs.next()) {
                        this.studentId = studentRs.getInt("Student_ID");
                    }
                }
                loggedInUser = this;

                // Redirect to Student Dashboard
                // Add your code to redirect students here

                return true;
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error during login: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }

    return false; // Login failed
}





    // Method to check if the teacher has a classroom
    // Method to check if the teacher has created a classroom using teacherId
public boolean hasCreatedClassroom() {
    if (this.teacherId == 0) {
        return false; // No teacherId available
    }

    String sql = "SELECT COUNT(*) FROM classroom WHERE Teacher_ID = ?"; // Use teacherId for the check
    boolean hasClassroom = false;

    try (PreparedStatement pstmt = konek.prepareStatement(sql)) {
        pstmt.setInt(1, this.teacherId); // Pass teacherId to check for classrooms
        ResultSet rs = pstmt.executeQuery();
        if (rs.next() && rs.getInt(1) > 0) {
            hasClassroom = true; // The teacher has at least one classroom
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error checking classrooms: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }

    return hasClassroom;
}


    // Sign up method
    public boolean signUpUser(String name, String email, String password, String role) {
        if (konek == null) {
            JOptionPane.showMessageDialog(null, "Database connection failed.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        String sql = "INSERT INTO user (name, email, password, role) VALUES (?, ?, ?, ?)";

        try (PreparedStatement pstmt = konek.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, password); // Hash the password before storing if needed
            pstmt.setString(4, role);

            pstmt.executeUpdate();
            return true; // Signup successful

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error during signup: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false; // Signup failed
        }
    }
}
