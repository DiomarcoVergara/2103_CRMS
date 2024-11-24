
package UI;
import Classes.Teacher;
import Classes.User;

import javax.swing.JOptionPane;

public class Create_Class_form extends javax.swing.JFrame {
      private int loggedInTeacherId; // ID of the currently logged-in teacher
     private User currentUser;

 
    public Create_Class_form() {
    initComponents();
    
    // Retrieve the logged-in user
    this.currentUser = User.getLoggedInUser();
    
    if (this.currentUser != null && "Teacher".equalsIgnoreCase(this.currentUser.getRole())) {
        this.loggedInTeacherId = this.currentUser.getTeacherId(); // Store the teacher's ID
    } else {
        // Show error message and close the form
        JOptionPane.showMessageDialog(this, 
                "Unauthorized access. Only teachers can create classes.", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        this.dispose(); // Close the form
    }
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Logo = new javax.swing.JLabel();
        DashboardLabel = new javax.swing.JLabel();
        Class_listPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        createclassPanel = new javax.swing.JPanel();
        CreateClassLabel = new javax.swing.JLabel();
        ClassNametxt = new javax.swing.JTextField();
        Sectiontxt = new javax.swing.JTextField();
        Subjecttxt = new javax.swing.JTextField();
        Roomtxt = new javax.swing.JTextField();
        CreateButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();
        ClassNameLabel = new javax.swing.JLabel();
        SectionLabel = new javax.swing.JLabel();
        SubjectLabel = new javax.swing.JLabel();
        RoomLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/1mikodiorven.jpg"))); // NOI18N

        DashboardLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        DashboardLabel.setText("CREATE CLASS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(Logo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(DashboardLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(Logo, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(DashboardLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Class_listPanel.setBackground(new java.awt.Color(126, 217, 87));

        javax.swing.GroupLayout Class_listPanelLayout = new javax.swing.GroupLayout(Class_listPanel);
        Class_listPanel.setLayout(Class_listPanelLayout);
        Class_listPanelLayout.setHorizontalGroup(
            Class_listPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Class_listPanelLayout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jLabel2)
                .addContainerGap(93, Short.MAX_VALUE))
        );
        Class_listPanelLayout.setVerticalGroup(
            Class_listPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Class_listPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        createclassPanel.setBackground(new java.awt.Color(255, 255, 255));

        CreateClassLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CreateClassLabel.setText("Create Class");

        ClassNametxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClassNametxtActionPerformed(evt);
            }
        });

        Roomtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RoomtxtActionPerformed(evt);
            }
        });

        CreateButton.setBackground(new java.awt.Color(0, 102, 0));
        CreateButton.setForeground(new java.awt.Color(255, 255, 255));
        CreateButton.setText("Create");
        CreateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateButtonActionPerformed(evt);
            }
        });

        CancelButton.setBackground(new java.awt.Color(0, 102, 0));
        CancelButton.setForeground(new java.awt.Color(255, 255, 255));
        CancelButton.setText("Cancel");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });

        ClassNameLabel.setText("Class name");

        SectionLabel.setText("Section");

        SubjectLabel.setText("Subject");

        RoomLabel.setText("Room");

        javax.swing.GroupLayout createclassPanelLayout = new javax.swing.GroupLayout(createclassPanel);
        createclassPanel.setLayout(createclassPanelLayout);
        createclassPanelLayout.setHorizontalGroup(
            createclassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(createclassPanelLayout.createSequentialGroup()
                .addGroup(createclassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Roomtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(createclassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(createclassPanelLayout.createSequentialGroup()
                            .addGap(171, 171, 171)
                            .addGroup(createclassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Subjecttxt, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(SubjectLabel)
                                .addComponent(RoomLabel)
                                .addComponent(Sectiontxt, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(SectionLabel)
                                .addComponent(ClassNametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ClassNameLabel)
                                .addComponent(CreateClassLabel)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, createclassPanelLayout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CancelButton)
                            .addGap(36, 36, 36)
                            .addComponent(CreateButton))))
                .addContainerGap(237, Short.MAX_VALUE))
        );
        createclassPanelLayout.setVerticalGroup(
            createclassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(createclassPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(CreateClassLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(ClassNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ClassNametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SectionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Sectiontxt, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SubjectLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Subjecttxt, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(RoomLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Roomtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(createclassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CancelButton)
                    .addComponent(CreateButton))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Class_listPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(createclassPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Class_listPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(createclassPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
      if (this.currentUser != null && this.currentUser.hasCreatedClassroom()) {
        // Redirect to teacher's class list
        Teacher_classlist_dashboard tcl = new Teacher_classlist_dashboard();
        tcl.setVisible(true);
        this.dispose(); // Close the current window
    } else {
        // Redirect to teacher's dashboard
        Teacher_dashboard td = new Teacher_dashboard();
        td.setVisible(true);
        this.dispose(); // Close the current window
    }
    
    }//GEN-LAST:event_CancelButtonActionPerformed

    private void RoomtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RoomtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RoomtxtActionPerformed

    private void ClassNametxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClassNametxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ClassNametxtActionPerformed

    private void CreateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateButtonActionPerformed
                                              
    String className = ClassNametxt.getText();
    String section = Sectiontxt.getText();
    String subjectName = Subjecttxt.getText();
    String room = Roomtxt.getText();

    if (className.isEmpty() || section.isEmpty() || subjectName.isEmpty() || room.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
        int loggedInTeacherId = User.getLoggedInUser().getTeacherId();

            // Create teacher object with actual name (if available, fetch it from User or login info)
            Teacher teacher = new Teacher(loggedInTeacherId, "Teacher Name"); 
    if (teacher.createClass(className, section, subjectName, room)) {
        JOptionPane.showMessageDialog(this, "Class created successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
        new Teacher_classlist_dashboard().setVisible(true);
    } else {
        JOptionPane.showMessageDialog(this, "Failed to create class.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}


    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Teacher_dashboard().setVisible(true);   
            }
        });
    
    }//GEN-LAST:event_CreateButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelButton;
    private javax.swing.JLabel ClassNameLabel;
    private javax.swing.JTextField ClassNametxt;
    private javax.swing.JPanel Class_listPanel;
    private javax.swing.JButton CreateButton;
    private javax.swing.JLabel CreateClassLabel;
    private javax.swing.JLabel DashboardLabel;
    private javax.swing.JLabel Logo;
    private javax.swing.JLabel RoomLabel;
    private javax.swing.JTextField Roomtxt;
    private javax.swing.JLabel SectionLabel;
    private javax.swing.JTextField Sectiontxt;
    private javax.swing.JLabel SubjectLabel;
    private javax.swing.JTextField Subjecttxt;
    private javax.swing.JPanel createclassPanel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
