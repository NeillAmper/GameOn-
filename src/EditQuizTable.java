
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.HashSet;
import java.util.Set;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class EditQuizTable extends javax.swing.JFrame {

    private static final String[] FILE_PATH = {"src/QuizData.json", "src/UserData.json"};
    private final String adminName;
    private final String gameMasterName;
    private final String usname;

    public EditQuizTable(String adminName, String gameMasterName, String usname, String selectedQuizTitle) {
        this.adminName = adminName;
        this.gameMasterName = (gameMasterName != null) ? gameMasterName : ""; // Default to empty string
        this.usname = usname;
        initComponents();
        loadQuizzesByCreator();
        populateCategorySelection(); // Populates category combo box with available categories
        loadCategoryQuizzes(); // Loads quizzes based on the selected category
        addSearchListener(); // Adds listener to search field for live updates

        QuizTable.getTableHeader().setFont(new Font("ORC A Extended", Font.BOLD, 14));
        QuizTable.getTableHeader().setOpaque(false);
        QuizTable.getTableHeader().setBackground(new Color(102, 0, 255));
        QuizTable.getTableHeader().setForeground(new Color(242, 242, 242));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        QuizTable = new javax.swing.JTable();
        CategorySelection = new javax.swing.JComboBox<>();
        EditButton = new javax.swing.JButton();
        searchField = new javax.swing.JTextField();
        BackButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        QuizTable.setBackground(new java.awt.Color(204, 153, 255));
        QuizTable.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        QuizTable.setForeground(new java.awt.Color(255, 255, 255));
        QuizTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title", "Creator", "Category"
            }
        ));
        QuizTable.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                QuizTableAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(QuizTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 500, 340));

        CategorySelection.setBackground(new java.awt.Color(102, 0, 255));
        CategorySelection.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        CategorySelection.setForeground(new java.awt.Color(255, 255, 255));
        CategorySelection.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        CategorySelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CategorySelectionActionPerformed(evt);
            }
        });
        getContentPane().add(CategorySelection, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 82, 160, 30));

        EditButton.setBackground(new java.awt.Color(102, 0, 255));
        EditButton.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        EditButton.setForeground(new java.awt.Color(255, 255, 255));
        EditButton.setText("Edit");
        EditButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        EditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditButtonActionPerformed(evt);
            }
        });
        getContentPane().add(EditButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 470, 160, 30));

        searchField.setBackground(new java.awt.Color(102, 0, 255));
        searchField.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        searchField.setForeground(new java.awt.Color(255, 255, 255));
        searchField.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });
        getContentPane().add(searchField, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 78, 160, 30));

        BackButton.setBackground(new java.awt.Color(102, 0, 255));
        BackButton.setFont(new java.awt.Font("OCR A Extended", 1, 24)); // NOI18N
        BackButton.setForeground(new java.awt.Color(255, 0, 51));
        BackButton.setText("<");
        BackButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });
        getContentPane().add(BackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 120, 30));

        jLabel2.setFont(new java.awt.Font("OCR A Extended", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Edit Quiz Table");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/GameOn! (Purple BG).png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 550));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        if (adminName != null && !adminName.isEmpty()) {
            // Navigate back to Administrator.java for adminName
            Administrator admin = new Administrator(adminName, usname);
            admin.setVisible(true);
        } else if (gameMasterName != null && !gameMasterName.isEmpty()) {
            // Navigate back to GameMaster.java for gameMasterName
            GameMaster g = new GameMaster(gameMasterName, usname);
            g.setVisible(true);
        }

        this.dispose(); // Close the current EditQuizTable window
    }//GEN-LAST:event_BackButtonActionPerformed

    private void CategorySelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CategorySelectionActionPerformed
        loadCategoryQuizzes(); // WHEN CATEGORY IS CHANGED, RELOAD QUIZZES
    }//GEN-LAST:event_CategorySelectionActionPerformed

    private void EditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditButtonActionPerformed
        int selectedRow = QuizTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a quiz to edit.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Object value = QuizTable.getValueAt(selectedRow, 0);
        if (value == null || value.toString().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "The selected quiz title is empty or invalid.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String selectedTitle = value.toString().trim();

        try (FileReader reader = new FileReader(FILE_PATH[0])) {
            JSONParser parser = new JSONParser();
            JSONObject root = (JSONObject) parser.parse(reader);
            JSONArray quizzes = (JSONArray) root.get("Quizzes");

            boolean quizExists = false;
            for (Object obj : quizzes) {
                JSONObject quiz = (JSONObject) obj;
                if (selectedTitle.equals(quiz.get("QuizTitle"))) {
                    quizExists = true;
                    break;
                }
            }

            if (!quizExists) {
                JOptionPane.showMessageDialog(this, "The selected quiz does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (IOException | ParseException e) {
            JOptionPane.showMessageDialog(this, "Failed to validate the quiz. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        EditQuiz editQuiz = new EditQuiz(selectedTitle, adminName, gameMasterName, usname);
        editQuiz.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_EditButtonActionPerformed

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        // Optional: Handle search field enter key
    }//GEN-LAST:event_searchFieldActionPerformed

    private void QuizTableAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_QuizTableAncestorAdded
        // Optional: Handle table ancestor events
    }//GEN-LAST:event_QuizTableAncestorAdded

    private void populateCategorySelection() {
        // Clear the current items in the combo box
        CategorySelection.removeAllItems();

        try (FileReader reader = new FileReader(FILE_PATH[0])) {
            JSONParser parser = new JSONParser();
            JSONObject root = (JSONObject) parser.parse(reader);
            JSONArray quizzes = (JSONArray) root.get("Quizzes");
            Set<String> categories = new HashSet<>();

            // Extract unique categories from the JSON file
            for (Object obj : quizzes) {
                JSONObject quiz = (JSONObject) obj;
                Object categoryObj = quiz.get("Category");
                if (categoryObj != null) {
                    categories.add(categoryObj.toString());
                }
            }

            // Add the "All" option first
            CategorySelection.addItem("All");

            // Add categories dynamically
            for (String category : categories) {
                CategorySelection.addItem(category);
            }

            // Set default selection to "All"
            CategorySelection.setSelectedItem("All");

        } catch (IOException | ParseException e) {
            // Log the exception and show an error message
            Logger.getLogger(EditQuizTable.class.getName()).log(Level.SEVERE, "Failed to load categories", e);
            JOptionPane.showMessageDialog(this, "Failed to load categories.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadCategoryQuizzes() {
        DefaultTableModel model = (DefaultTableModel) QuizTable.getModel();
        model.setRowCount(0); // Clear current table data

        try (FileReader reader = new FileReader(FILE_PATH[0])) {
            JSONParser parser = new JSONParser();
            JSONObject root = (JSONObject) parser.parse(reader);
            JSONArray quizzes = (JSONArray) root.get("Quizzes");

            Object selectedItem = CategorySelection.getSelectedItem();
            if (selectedItem == null) {
                return; // No category selected yet
            }

            String selectedCategory = selectedItem.toString();
            String keyword = searchField.getText().toLowerCase();
            boolean isAdmin = isAdminUser();

            for (Object obj : quizzes) {
                JSONObject quiz = (JSONObject) obj;

                if (doesQuizMatchFilters(quiz, selectedCategory, keyword, isAdmin)) {
                    model.addRow(new Object[]{
                        quiz.get("QuizTitle"),
                        quiz.get("Creator"),
                        quiz.get("Category")
                    });
                }
            }
        } catch (IOException | ParseException e) {
            JOptionPane.showMessageDialog(this, "Failed to load quizzes.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addSearchListener() {
        if (searchField != null) {
            searchField.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    loadCategoryQuizzes();
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    loadCategoryQuizzes();
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    loadCategoryQuizzes();
                }
            });
        }
    }

    private void loadQuizzesByCreator() {
        try {
            JSONParser parser = new JSONParser();
            JSONObject data = (JSONObject) parser.parse(new FileReader(FILE_PATH[0]));
            JSONArray quizzes = (JSONArray) data.get("Quizzes");

            DefaultTableModel model = (DefaultTableModel) QuizTable.getModel();
            model.setRowCount(0);

            for (Object obj : quizzes) {
                JSONObject quiz = (JSONObject) obj;

                if (gameMasterName != null && gameMasterName.equals(quiz.get("Creator"))) {
                    model.addRow(new Object[]{
                        quiz.get("QuizTitle"),
                        quiz.get("Creator"),
                        quiz.get("Category")
                    });
                }
            }
        } catch (IOException | ParseException e) {
            Logger.getLogger(EditQuizTable.class.getName()).log(Level.SEVERE, "Error loading quizzes by creator", e);
            JOptionPane.showMessageDialog(this, "Failed to load quizzes.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean isAdminUser() {
        if (adminName == null || adminName.isEmpty()) {
            return false;
        }

        try (FileReader reader = new FileReader(FILE_PATH[1])) {
            JSONParser parser = new JSONParser();
            JSONObject root = (JSONObject) parser.parse(reader);
            JSONArray users = (JSONArray) root.get("Accounts");

            for (Object obj : users) {
                JSONObject user = (JSONObject) obj;
                String username = user.get("username").toString();
                String type = user.get("type").toString();

                if (adminName.equals(username)) {
                    return type.equalsIgnoreCase("Administrator");
                }
            }
        } catch (IOException | ParseException e) { // Log the exception
            // Log the exception
            JOptionPane.showMessageDialog(this, "Error reading user data.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return false;
    }

    private boolean doesQuizMatchFilters(JSONObject quiz, String selectedCategory, String keyword, boolean isAdmin) {
        String title = quiz.get("QuizTitle") != null ? quiz.get("QuizTitle").toString().toLowerCase() : "";
        String creator = quiz.get("Creator") != null ? quiz.get("Creator").toString().toLowerCase() : "";
        String category = quiz.get("Category") != null ? quiz.get("Category").toString().toLowerCase() : "";

        boolean categoryMatch = selectedCategory.equals("All") || category.equals(selectedCategory.toLowerCase());
        boolean keywordMatch = keyword.isEmpty() || title.contains(keyword) || creator.contains(keyword) || category.contains(keyword);
        boolean creatorMatch = isAdmin || creator.equals(gameMasterName.toLowerCase());

        return categoryMatch && keywordMatch && creatorMatch;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JComboBox<String> CategorySelection;
    private javax.swing.JButton EditButton;
    private javax.swing.JTable QuizTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField searchField;
    // End of variables declaration//GEN-END:variables

}
