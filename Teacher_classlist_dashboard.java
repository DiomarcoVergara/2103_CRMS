
package UI;
import Classes.User;
import DB.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author RHAINE
 */
public class Teacher_classlist_dashboard extends javax.swing.JFrame {
    
     private int teacherId; 
    private Connection konek;
    
    
   
    public Teacher_classlist_dashboard() {
        
        User loggedInUser = User.getLoggedInUser();
        if (loggedInUser != null) {
            this.teacherId = loggedInUser.getTeacherId();
        } else {
            System.out.println("No user logged in.");
            return;
        }

        DBConnect dbcon = new DBConnect();
        konek = dbcon.getConnection();

        initComponents();
        loadClasses(); 
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header = new javax.swing.JPanel();
        Logo = new javax.swing.JLabel();
        headerLabel = new javax.swing.JLabel();
        Class_listPanel = new javax.swing.JPanel();
        CreateAnotherClassButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        classTable = new javax.swing.JTable();
        openClassButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        header.setBackground(new java.awt.Color(255, 255, 255));

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/1mikodiorven.jpg"))); // NOI18N

        headerLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        headerLabel.setText("MY CLASSES");

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(Logo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(headerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(442, Short.MAX_VALUE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addComponent(Logo, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(headerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Class_listPanel.setBackground(new java.awt.Color(126, 217, 87));

        CreateAnotherClassButton.setText("Create class");
        CreateAnotherClassButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateAnotherClassButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Class_listPanelLayout = new javax.swing.GroupLayout(Class_listPanel);
        Class_listPanel.setLayout(Class_listPanelLayout);
        Class_listPanelLayout.setHorizontalGroup(
            Class_listPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Class_listPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(CreateAnotherClassButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        Class_listPanelLayout.setVerticalGroup(
            Class_listPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Class_listPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(CreateAnotherClassButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        openClassButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openClassButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Class_listPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(openClassButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Class_listPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(openClassButton)
                        .addGap(0, 15, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
         private void loadClasses() {
        if (konek == null || teacherId == 0) {
            System.out.println("Database connection failed or Teacher ID is not set.");
            return;
        }

        String sql = "SELECT Class_ID, Class_Name, Subject_Code, Section FROM classroom WHERE Teacher_ID = ?";
        DefaultTableModel model = (DefaultTableModel) classTable.getModel();
        model.setRowCount(0); // Clear existing rows

        try (PreparedStatement pstmt = konek.prepareStatement(sql)) {
            pstmt.setInt(1, teacherId); // Use Teacher_ID to filter results
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Object[] row = {
                    rs.getInt("Class_ID"),
                    rs.getString("Class_Name"),
                    rs.getString("Subject_Code"),
                    rs.getString("Section")
                };
                model.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
         
         
    private void openClassButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openClassButtonActionPerformed
         int selectedRow = classTable.getSelectedRow();
    if (selectedRow != -1) {
        
        int classId = (int) classTable.getValueAt(selectedRow, 0);
        String className = (String) classTable.getValueAt(selectedRow, 1);
        System.out.println("Opening Class: " + className + " (ID: " + classId + ")");
        
        // Dispose of the current frame
        this.dispose();

        // Ensure that the user is logged in and retrieve the teacher ID
        User user = User.getLoggedInUser(); 
        if (user == null) {
            JOptionPane.showMessageDialog(this, "No user is logged in.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int teacherId = user.getTeacherId(); 
        if (teacherId == 0) {
            JOptionPane.showMessageDialog(this, "No teacher ID found.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Create and display the class dashboard
        Class_dashboard dashboard = new Class_dashboard(classId, className, teacherId);
        dashboard.setVisible(true);
    } else {
        JOptionPane.showMessageDialog(this, "No class selected.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_openClassButtonActionPerformed

    private void CreateAnotherClassButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateAnotherClassButtonActionPerformed
      this.dispose();

    
    Create_Class_form CreateFrame = new Create_Class_form();
    CreateFrame.setVisible(true);
    }//GEN-LAST:event_CreateAnotherClassButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Teacher_classlist_dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Teacher_classlist_dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Teacher_classlist_dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Teacher_classlist_dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Teacher_classlist_dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Class_listPanel;
    private javax.swing.JButton CreateAnotherClassButton;
    private javax.swing.JLabel Logo;
    private javax.swing.JTable classTable;
    private javax.swing.JPanel header;
    private javax.swing.JLabel headerLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton openClassButton;
    // End of variables declaration//GEN-END:variables
}
