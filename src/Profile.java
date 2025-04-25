
import java.awt.HeadlessException;
import javax.swing.*;
import java.io.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class Profile extends javax.swing.JFrame {

    private final String usname; // The username of the signed-in user
    private static final String FILE_PATH = "src/UserData.json"; // Path to UserData.json

    public Profile(String usname) {
        this.usname = usname;

        initComponents();

        // Fetch the user type and validate the username
        String userType = fetchUserType();
        String displayName = (this.usname != null && !this.usname.trim().isEmpty()) ? this.usname : "Unknown User";

        // Update the label to display the username and user type
        jLabel1.setText("Edit Profile Information for " + displayName);

        // Set the user type in the TypeComboBox
        if ("Game Master".equalsIgnoreCase(userType)) {
            TypeComboBox.setSelectedItem("Game Master");
        } else if ("Player".equalsIgnoreCase(userType)) {
            TypeComboBox.setSelectedItem("Player");
        } else if ("Administrator".equalsIgnoreCase(userType)) {
            TypeComboBox.setSelectedItem("Administrator");
        } else {
            TypeComboBox.setSelectedItem("Unknown"); // Fallback for invalid or missing type
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        BackButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        NewUsernameField = new javax.swing.JTextField();
        NewPasswordField = new javax.swing.JTextField();
        ConfirmNewPasswordField = new javax.swing.JTextField();
        ConfirmButton = new javax.swing.JButton();
        TypeComboBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        DeleteButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BackButton.setBackground(new java.awt.Color(0, 51, 255));
        BackButton.setFont(new java.awt.Font("OCR A Extended", 1, 24)); // NOI18N
        BackButton.setForeground(new java.awt.Color(255, 0, 51));
        BackButton.setText("<");
        BackButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });
        jPanel1.add(BackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 120, 30));

        jLabel1.setFont(new java.awt.Font("OCR A Extended", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Edit Profile Information for (...)");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, -1, -1));

        NewUsernameField.setBackground(new java.awt.Color(102, 102, 255));
        NewUsernameField.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        NewUsernameField.setForeground(new java.awt.Color(255, 255, 255));
        NewUsernameField.setText("Enter New Username");
        NewUsernameField.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        NewUsernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewUsernameFieldActionPerformed(evt);
            }
        });
        jPanel1.add(NewUsernameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, 190, 30));

        NewPasswordField.setBackground(new java.awt.Color(102, 102, 255));
        NewPasswordField.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        NewPasswordField.setForeground(new java.awt.Color(255, 255, 255));
        NewPasswordField.setText("Enter New Password");
        NewPasswordField.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(NewPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 160, 190, 30));

        ConfirmNewPasswordField.setBackground(new java.awt.Color(102, 102, 255));
        ConfirmNewPasswordField.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        ConfirmNewPasswordField.setForeground(new java.awt.Color(255, 255, 255));
        ConfirmNewPasswordField.setText("Confirm New Password");
        ConfirmNewPasswordField.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        ConfirmNewPasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmNewPasswordFieldActionPerformed(evt);
            }
        });
        jPanel1.add(ConfirmNewPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 210, 190, 30));

        ConfirmButton.setBackground(new java.awt.Color(0, 51, 255));
        ConfirmButton.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        ConfirmButton.setForeground(new java.awt.Color(255, 255, 255));
        ConfirmButton.setText("Confirm");
        ConfirmButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ConfirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmButtonActionPerformed(evt);
            }
        });
        jPanel1.add(ConfirmButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 430, 150, 30));

        TypeComboBox.setBackground(new java.awt.Color(102, 102, 255));
        TypeComboBox.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        TypeComboBox.setForeground(new java.awt.Color(255, 255, 255));
        TypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Player", "Game Master" }));
        TypeComboBox.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(TypeComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 260, 190, 30));

        jLabel2.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Enter New Username:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, -1, 30));

        jLabel3.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Enter New Password:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, -1, 30));

        jLabel4.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Confirm New Password:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, -1, 30));

        DeleteButton.setBackground(new java.awt.Color(0, 51, 255));
        DeleteButton.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        DeleteButton.setForeground(new java.awt.Color(255, 255, 255));
        DeleteButton.setText("Delete Account");
        DeleteButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });
        jPanel1.add(DeleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 430, 150, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/GameOn! Blue BG (Big Logo Ver.).png"))); // NOI18N
        jLabel5.setText("jLabel5");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 560));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        try {
            String userType = fetchUserType(); // Fetch the user type
            switch (userType) {
                case "Administrator" -> {
                    new Administrator(usname, usname).setVisible(true);
                }
                case "Game Master" -> {
                    new GameMaster(usname, usname).setVisible(true);
                }
                case "Player" -> {
                    new Player(usname, "Player", 1, 2, "Player", usname).setVisible(true);
                }
                default -> {
                    JOptionPane.showMessageDialog(this, "Error: No valid user type found to navigate back.", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(this, "Error navigating back: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            this.dispose();
        }
    }//GEN-LAST:event_BackButtonActionPerformed

    private void ConfirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmButtonActionPerformed
        String newUsername = NewUsernameField.getText().trim();
        String newPassword = NewPasswordField.getText().trim();
        String confirmPassword = ConfirmNewPasswordField.getText().trim();
        String newType = TypeComboBox.getSelectedItem().toString();

        try {
            // Parse the JSON file to get the current user data
            JSONParser parser = new JSONParser();
            JSONObject userData = (JSONObject) parser.parse(new FileReader(FILE_PATH));
            JSONArray users = (JSONArray) userData.get("Accounts");

            // Find the current user's account in the JSON file
            for (Object obj : users) {
                JSONObject user = (JSONObject) obj;
                if (user.get("username").toString().equals(usname)) {
                    String currentPassword = user.get("password").toString();
                    String currentUsername = user.get("username").toString();
                    String currentType = user.get("type").toString();

                    // Check if no changes were made
                    if (newPassword.equals(currentPassword)
                            && newUsername.equals(currentUsername)
                            && confirmPassword.isBlank()
                            && newType.equalsIgnoreCase(currentType)) {
                        JOptionPane.showMessageDialog(this, "Nothing was changed.", "No Changes", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }

                    // Check if only user type is being updated
                    if (confirmPassword.isBlank() && newPassword.equals(currentPassword) && !newType.equalsIgnoreCase(currentType)) {
                        user.put("type", newType);

                        try (FileWriter writer = new FileWriter(FILE_PATH)) {
                            userData.put("Accounts", users);
                            writer.write(userData.toJSONString());
                        }

                        JOptionPane.showMessageDialog(this, "User type successfully edited!", "Success", JOptionPane.INFORMATION_MESSAGE);

                        // Navigate back to the appropriate dashboard
                        switch (newType) {
                            case "Game Master" ->
                                new GameMaster(usname, usname).setVisible(true);
                            case "Player" ->
                                new Player(usname, "Player", 1, 2, "Player", usname).setVisible(true);
                            case "Administrator" ->
                                new Administrator(usname, usname).setVisible(true);
                            default -> {
                            }
                        }

                        this.dispose();
                        return;
                    }

                    // Check if passwords match before updating
                    if (!newPassword.isBlank() && !newPassword.equals(confirmPassword)) {
                        JOptionPane.showMessageDialog(this, "Passwords do not match!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // Update the user's data in the JSON file
                    if (!newUsername.isBlank() && !newUsername.equals(currentUsername)) {
                        user.put("username", newUsername);
                    }

                    if (!newPassword.isBlank() && !newPassword.equals(currentPassword)) {
                        user.put("password", newPassword);
                    }

                    if (!newType.equalsIgnoreCase(currentType)) {
                        user.put("type", newType);
                    }

                    // Save the updated data back to the JSON file
                    try (FileWriter writer = new FileWriter(FILE_PATH)) {
                        userData.put("Accounts", users);
                        writer.write(userData.toJSONString());
                    }

                    JOptionPane.showMessageDialog(this, "Profile updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

                    // Navigate back to the appropriate dashboard
                    switch (newType) {
                        case "Game Master" ->
                            new GameMaster(newUsername, usname).setVisible(true);
                        case "Player" ->
                            new Player(newUsername, "Player", 1, 2, "Player", usname).setVisible(true);
                        case "Administrator" ->
                            new Administrator(newUsername, usname).setVisible(true);
                        default -> {
                        }
                    }

                    this.dispose();
                    return;
                }
            }

            JOptionPane.showMessageDialog(this, "User not found!", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException | ParseException e) {
            JOptionPane.showMessageDialog(this, "Error updating profile: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_ConfirmButtonActionPerformed

    private void NewUsernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewUsernameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NewUsernameFieldActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to permanently delete your account?\nThis will remove all associated data.", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        try {
            JSONParser parser = new JSONParser();
            JSONObject userData = (JSONObject) parser.parse(new FileReader(FILE_PATH));
            JSONArray accounts = (JSONArray) userData.get("Accounts");
            JSONArray history = (JSONArray) userData.get("History");
            JSONArray standing = (JSONArray) userData.get("Standing");

            accounts.removeIf(obj -> ((JSONObject) obj).get("username").toString().equals(usname));
            if (history != null) {
                history.removeIf(obj -> ((JSONObject) obj).get("player").toString().equals(usname));
            }
            if (standing != null) {
                standing.removeIf(obj -> ((JSONObject) obj).get("player").toString().equals(usname));
            }

            try (FileWriter writer = new FileWriter(FILE_PATH)) {
                userData.put("Accounts", accounts);
                userData.put("History", history);
                userData.put("Standing", standing);
                writer.write(userData.toJSONString());
            }

            // Remove user's quizzes
            JSONObject quizData = (JSONObject) parser.parse(new FileReader(FILE_PATH));
            JSONArray quizzes = (JSONArray) quizData.get("Quizzes");
            quizzes.removeIf(obj -> {
                return usname.equals(((JSONObject) obj).get("creator").toString());
            });

            try (FileWriter writer = new FileWriter(FILE_PATH)) {
                quizData.put("Quizzes", quizzes);
                writer.write(quizData.toJSONString());
            }

            JOptionPane.showMessageDialog(this, "Account deleted successfully.");
            new SignIn(usname, null).setVisible(true);
            this.dispose();

        } catch (IOException | ParseException e) {
            JOptionPane.showMessageDialog(this, "Error deleting account: " + e.getMessage());
        }
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void ConfirmNewPasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmNewPasswordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ConfirmNewPasswordFieldActionPerformed

    private String fetchUserType() {
        try (FileReader reader = new FileReader(FILE_PATH)) {
            JSONParser parser = new JSONParser();
            JSONObject userData = (JSONObject) parser.parse(reader);
            JSONArray accounts = (JSONArray) userData.get("Accounts");

            // Iterate through accounts to find the matching username
            for (Object obj : accounts) {
                JSONObject user = (JSONObject) obj;
                if (user.get("username").toString().equals(usname)) {
                    // Populate fields with user data
                    NewUsernameField.setText(user.get("username").toString());
                    NewPasswordField.setText(user.get("password").toString()); // Set current password
                    ConfirmNewPasswordField.setText(""); // Default to empty

                    // Update the dynamic message with the username and type
                    String userType = user.get("type").toString();
                    jLabel1.setText("Edit Profile Information for " + user.get("username") + " (" + userType + ")");
                    return userType;
                }
            }
        } catch (IOException | ParseException e) {
            JOptionPane.showMessageDialog(this, "Error fetching user type: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return "Unknown"; // Default return value if user not found
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new Profile("User").setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JButton ConfirmButton;
    private javax.swing.JTextField ConfirmNewPasswordField;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JTextField NewPasswordField;
    private javax.swing.JTextField NewUsernameField;
    private javax.swing.JComboBox<String> TypeComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
