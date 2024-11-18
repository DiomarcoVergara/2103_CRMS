package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Teacher {
    private int teacherId;
    private String name;

    public Teacher(int teacherId, String name) {
        this.teacherId = teacherId;
        this.name = name;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public String getName() {
        return name;
    }

    /**
     * Fetch the subject code from the database based on the subject name.
     */
    public String getSubjectCode(String subjectName) {
        String subjectCode = null;
        String query = "SELECT Subject_Code FROM subject WHERE Subject_Name = ?";

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/crms", "root", "");
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, subjectName);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                subjectCode = resultSet.getString("Subject_Code");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database error while fetching subject code.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return subjectCode;
    }

    /**
     * Save class details to the database.
     */
    public boolean createClass(String className, String section, String subjectName, String room) {
        String subjectCode = getSubjectCode(subjectName);

        if (subjectCode == null) {
            JOptionPane.showMessageDialog(null, "Subject not found in the database.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        String query = "INSERT INTO classroom (Class_Name, Section, Subject_Code, Room_Number, Teacher_ID) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/crms", "root", "");
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, className);
            statement.setString(2, section);
            statement.setString(3, subjectCode);
            statement.setString(4, room);
            statement.setInt(5, teacherId);

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error saving class to the database.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
