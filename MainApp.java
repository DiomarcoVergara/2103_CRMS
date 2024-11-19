package Main;
import DB.DatabaseConnector;
import UI.Log_in;
import UI.Sign_up;


public class MainApp {
    // Main entry point of the application
    public static void main(String[] args) {
        // Show the initial screen (e.g., Login)
        new MainApp().showLoginScreen();
    }
    
    public void showLoginScreen() {
        Log_in loginFrame = new Log_in();
        loginFrame.setVisible(true);

        
    }

    public void showSignupScreen() {
        Sign_up signupFrame = new Sign_up();
        signupFrame.setVisible(true);

        
    }
}
