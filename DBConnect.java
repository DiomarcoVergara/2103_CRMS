package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    private static Connection konek;
    private static final String URL = "jdbc:mysql://localhost:3306/crms"; 
    private static final String USER = "root"; 
    private static final String PASSWORD = ""; 
    
    public DBConnect() {
        try {
            konek = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database connection successful!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to connect to the database.");
        }
    }

    public Connection getConnection() {
        return konek;
    }
}
