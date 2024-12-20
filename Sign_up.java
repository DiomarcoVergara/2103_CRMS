package UI;

import Classes.User;
import DB.DBConnect;
import java.sql.Connection;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;


public class Sign_up extends javax.swing.JFrame {
private Connection konek;
   private ButtonGroup buttonGroup; 
    private Runnable onLoginClicked;
/**
     * Creates new form NewJFrame
     */
    public Sign_up() {
        
        initComponents();
        DBConnect dbcon =new DBConnect();
        buttonGroup = new ButtonGroup();
        buttonGroup.add(jRadioButton1);
        buttonGroup.add(jRadioButton2);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        LoginLabel = new javax.swing.JLabel();
        EmailTextField = new javax.swing.JTextField();
        PasswordLabel = new javax.swing.JLabel();
        EmailLabel = new javax.swing.JLabel();
        SignupButton = new javax.swing.JButton();
        switchLabel = new javax.swing.JLabel();
        LButton = new javax.swing.JButton();
        PasswordTextField = new javax.swing.JPasswordField();
        jRadioButton1 = new javax.swing.JRadioButton();
        NameTextField1 = new javax.swing.JTextField();
        NameLabel1 = new javax.swing.JLabel();
        jRadioButton2 = new javax.swing.JRadioButton();
        Logo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SIGN UP");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(126, 217, 87));

        LoginLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        LoginLabel.setText("SIGN UP");

        EmailTextField.setBackground(new java.awt.Color(126, 217, 87));
        EmailTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        EmailTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailTextFieldActionPerformed(evt);
            }
        });

        PasswordLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        PasswordLabel.setText("Password");

        EmailLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        EmailLabel.setText("Email");

        SignupButton.setBackground(new java.awt.Color(0, 102, 0));
        SignupButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SignupButton.setForeground(new java.awt.Color(255, 255, 255));
        SignupButton.setText("SIGN UP");
        SignupButton.setToolTipText("");
        SignupButton.setBorder(null);
        SignupButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SignupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignupButtonActionPerformed(evt);
            }
        });

        switchLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        switchLabel.setText("Already have an account");

        LButton.setBackground(new java.awt.Color(0, 102, 0));
        LButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LButton.setForeground(new java.awt.Color(255, 255, 255));
        LButton.setText("LOG IN");
        LButton.setToolTipText("");
        LButton.setBorder(null);
        LButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LButtonActionPerformed(evt);
            }
        });

        PasswordTextField.setBackground(new java.awt.Color(126, 217, 87));
        PasswordTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PasswordTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordTextFieldActionPerformed(evt);
            }
        });

        jRadioButton1.setBackground(new java.awt.Color(126, 217, 87));
        jRadioButton1.setText("Students");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        NameTextField1.setBackground(new java.awt.Color(126, 217, 87));
        NameTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        NameTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameTextField1ActionPerformed(evt);
            }
        });

        NameLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        NameLabel1.setText("Name");

        jRadioButton2.setBackground(new java.awt.Color(126, 217, 87));
        jRadioButton2.setText("Teacher");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(SignupButton, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jRadioButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jRadioButton2))
                            .addComponent(EmailTextField)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(NameLabel1)
                                .addGap(51, 51, 51)
                                .addComponent(LoginLabel))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(switchLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(LButton, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(PasswordLabel)
                            .addComponent(EmailLabel)
                            .addComponent(PasswordTextField)
                            .addComponent(NameTextField1))
                        .addGap(29, 29, 29))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(LoginLabel)
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(NameLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(NameTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EmailLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EmailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PasswordLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addGap(18, 18, 18)
                .addComponent(SignupButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(switchLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/mikodiorven.jpg"))); // NOI18N
        Logo.setText("jLabel5");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Logo, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Logo, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EmailTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailTextFieldActionPerformed
       
    }//GEN-LAST:event_EmailTextFieldActionPerformed

    private void SignupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignupButtonActionPerformed
                                                    
        String name = NameTextField1.getText().trim();
        String email = EmailTextField.getText().trim();
        String password = new String(PasswordTextField.getPassword()).trim();
        String role = jRadioButton1.isSelected() ? "Student" : "Teacher";

        if (name.isEmpty() || email.isEmpty() || password.isEmpty() || role.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        User user = new User();
        boolean isSignedUp = user.signUpUser(name, email, password, role);

        if (isSignedUp) {
            JOptionPane.showMessageDialog(this, "User signed up successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();

        // Open the SignupFrame
        Log_in loginFrame = new Log_in();
        loginFrame.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Signup failed!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    



    }//GEN-LAST:event_SignupButtonActionPerformed

    private void LButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LButtonActionPerformed
        
        this.dispose();

    
    Log_in loginFrame = new Log_in();
    loginFrame.setVisible(true);
    }//GEN-LAST:event_LButtonActionPerformed
    public void setOnLoginClicked(Runnable action) {
        this.onLoginClicked = action;
    }
    private void PasswordTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordTextFieldActionPerformed
        
    }//GEN-LAST:event_PasswordTextFieldActionPerformed

    private void NameTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameTextField1ActionPerformed
        
    }//GEN-LAST:event_NameTextField1ActionPerformed
        
    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        
    }//GEN-LAST:event_jRadioButton2ActionPerformed
        
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sign_up().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel EmailLabel;
    private javax.swing.JTextField EmailTextField;
    private javax.swing.JButton LButton;
    private javax.swing.JLabel LoginLabel;
    private javax.swing.JLabel Logo;
    private javax.swing.JLabel NameLabel1;
    private javax.swing.JTextField NameTextField1;
    private javax.swing.JLabel PasswordLabel;
    private javax.swing.JPasswordField PasswordTextField;
    private javax.swing.JButton SignupButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JLabel switchLabel;
    // End of variables declaration//GEN-END:variables
}
