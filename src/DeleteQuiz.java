
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DeleteQuiz extends javax.swing.JFrame {

    private static final String FILE_PATH = "src/QuizData.json";
    private final Stack<DeletedQuiz> deletedQuizzesStack = new Stack<>(); // Stack to store deletion history
    private final String adminName;
    private final String gameMasterName;
    private final String usname;
    private boolean isUndoDialogShown = false; // Flag to prevent duplicate dialogs

    public DeleteQuiz(String adminName, String gameMasterName, String usname) {
        this.adminName = adminName;
        this.gameMasterName = gameMasterName;
        this.usname = usname;
        initComponents();
        customizeQuizTableHeader(); // Customize table header after initialization
        initializeListeners();
        populateCategorySelection();

        // Ensure a category is selected before loading quizzes
        if (CategorySelection.getSelectedItem() != null) {
            loadCategoryQuizzes();
        }

        addSearchListener();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        BackButton = new javax.swing.JButton();
        deleteQuiz = new javax.swing.JLabel();
        searchField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        quizTable = new javax.swing.JTable();
        CategorySelection = new javax.swing.JComboBox<>();
        undoButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, -10, -1, 580));

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

        deleteQuiz.setFont(new java.awt.Font("OCR A Extended", 1, 18)); // NOI18N
        deleteQuiz.setForeground(new java.awt.Color(255, 255, 255));
        deleteQuiz.setText("Delete Quiz");
        getContentPane().add(deleteQuiz, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, -1, -1));

        searchField.setBackground(new java.awt.Color(102, 0, 255));
        searchField.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        searchField.setForeground(new java.awt.Color(255, 255, 255));
        searchField.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(searchField, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 90, 150, 30));

        quizTable.setBackground(new java.awt.Color(204, 153, 255));
        quizTable.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        quizTable.setForeground(new java.awt.Color(255, 255, 255));
        quizTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title", "Creator", "Category"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        quizTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(quizTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 470, 330));

        CategorySelection.setBackground(new java.awt.Color(102, 0, 255));
        CategorySelection.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        CategorySelection.setForeground(new java.awt.Color(255, 255, 255));
        CategorySelection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Math", "Science", "History", "English" }));
        CategorySelection.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        CategorySelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CategorySelectionActionPerformed(evt);
            }
        });
        getContentPane().add(CategorySelection, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 150, 30));

        undoButton.setBackground(new java.awt.Color(102, 0, 255));
        undoButton.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        undoButton.setForeground(new java.awt.Color(255, 255, 255));
        undoButton.setText("Undo");
        undoButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        undoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undoButtonActionPerformed(evt);
            }
        });
        getContentPane().add(undoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 470, 120, 30));

        DeleteButton.setBackground(new java.awt.Color(102, 0, 255));
        DeleteButton.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        DeleteButton.setForeground(new java.awt.Color(255, 255, 255));
        DeleteButton.setText("Delete");
        DeleteButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });
        getContentPane().add(DeleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 470, 120, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/GameOn! (Purple BG).png"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 560));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void undoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undoButtonActionPerformed
        // Check if the stack is empty
        if (deletedQuizzesStack.isEmpty()) {
            if (!isUndoDialogShown) {
                isUndoDialogShown = true; // Set flag to true
                JOptionPane.showMessageDialog(this, "Nothing to undo.", "Undo Error", JOptionPane.WARNING_MESSAGE);
            }
            return; // Exit early
        }

        // Reset the flag since there is something to undo
        isUndoDialogShown = false;

        // Proceed with undo logic if the stack is not empty
        DeletedQuiz lastDeleted = deletedQuizzesStack.pop();

        try (FileReader reader = new FileReader(FILE_PATH)) {
            JSONParser parser = new JSONParser();
            JSONObject root = (JSONObject) parser.parse(reader);
            JSONArray quizzes = (JSONArray) root.get("Quizzes");

            // Add the last deleted quiz back to the JSON file
            quizzes.add(lastDeleted.getQuiz());

            try (FileWriter writer = new FileWriter(FILE_PATH)) {
                writer.write(root.toJSONString());
            }

            // Reinsert the row in the table
            ((DefaultTableModel) quizTable.getModel()).insertRow(lastDeleted.getRowIndex(), new Object[]{
                lastDeleted.getQuiz().get("QuizTitle"),
                lastDeleted.getQuiz().get("Creator"),
                lastDeleted.getQuiz().get("Category")
            });

            JOptionPane.showMessageDialog(this, "Undo successful!");

        } catch (IOException | ParseException e) {
            JOptionPane.showMessageDialog(this, "Failed to undo delete.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_undoButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        // Show confirmation dialog only once
        int confirm = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to delete this quiz?",
                "Confirm Quiz Deletion",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            int row = quizTable.getSelectedRow();
            if (row == -1) {
                // Show a single error message if no quiz is selected
                JOptionPane.showMessageDialog(this, "No quiz selected.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String quizTitle = (String) quizTable.getValueAt(row, 0);
            String creator = (String) quizTable.getValueAt(row, 1);
            String category = (String) quizTable.getValueAt(row, 2);

            if (!creator.equals(gameMasterName)) {
                // Show a single warning message if the user tries to delete a quiz they didn't create
                JOptionPane.showMessageDialog(this, "You can only delete quizzes you created.", "Access Denied", JOptionPane.WARNING_MESSAGE);
                return;
            }

            try (FileReader reader = new FileReader(FILE_PATH)) {
                JSONParser parser = new JSONParser();
                JSONObject root = (JSONObject) parser.parse(reader);
                JSONArray quizzes = (JSONArray) root.get("Quizzes");

                boolean quizFound = false;
                for (int i = 0; i < quizzes.size(); i++) {
                    JSONObject quiz = (JSONObject) quizzes.get(i);
                    if (quizTitle.equals(quiz.get("QuizTitle"))
                            && creator.equals(quiz.get("Creator"))
                            && category.equals(quiz.get("Category"))) {
                        deletedQuizzesStack.push(new DeletedQuiz(quiz, row));
                        quizzes.remove(i);
                        quizFound = true;
                        break;
                    }
                }

                if (quizFound) {
                    try (FileWriter writer = new FileWriter(FILE_PATH)) {
                        writer.write(root.toJSONString());
                    }

                    ((DefaultTableModel) quizTable.getModel()).removeRow(row);
                    // Show success message once
                    JOptionPane.showMessageDialog(this, "Quiz deleted successfully!");
                } else {
                    // Show error message if the quiz was not found
                    JOptionPane.showMessageDialog(this, "Quiz not found in the database.", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } catch (IOException | ParseException e) {
                JOptionPane.showMessageDialog(this, "Error deleting quiz.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void CategorySelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CategorySelectionActionPerformed
        loadCategoryQuizzes();
    }//GEN-LAST:event_CategorySelectionActionPerformed

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed

        if (adminName != null && !adminName.isEmpty()) {
            Administrator admin = new Administrator(adminName, usname);
            admin.setVisible(true);
        } else if (gameMasterName != null && !gameMasterName.isEmpty()) {
            GameMaster g = new GameMaster(gameMasterName, usname);
            g.setVisible(true);
        }
        this.setVisible(false);
    }//GEN-LAST:event_BackButtonActionPerformed

    private void populateCategorySelection() {
        try (FileReader reader = new FileReader(FILE_PATH)) {
            JSONParser parser = new JSONParser();
            JSONObject root = (JSONObject) parser.parse(reader);
            JSONArray quizzes = (JSONArray) root.get("Quizzes");

            Set<String> categories = new HashSet<>();
            for (Object obj : quizzes) {
                JSONObject quiz = (JSONObject) obj;
                categories.add((String) quiz.get("Category"));
            }

            CategorySelection.removeAllItems();
            CategorySelection.addItem("All");
            for (String category : categories) {
                CategorySelection.addItem(category);
            }

            if (CategorySelection.getItemCount() > 0) {
                CategorySelection.setSelectedIndex(0);
            }

        } catch (IOException | ParseException e) {
            JOptionPane.showMessageDialog(this, "Error loading categories.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadCategoryQuizzes() {
        String selectedCategory = (String) CategorySelection.getSelectedItem();

        if (selectedCategory == null) {
            return;
        }

        String searchText = searchField.getText().trim().toLowerCase();
        DefaultTableModel model = (DefaultTableModel) quizTable.getModel();
        model.setRowCount(0);

        try (FileReader reader = new FileReader(FILE_PATH)) {
            JSONParser parser = new JSONParser();
            JSONObject root = (JSONObject) parser.parse(reader);
            JSONArray quizzes = (JSONArray) root.get("Quizzes");

            for (Object obj : quizzes) {
                JSONObject quiz = (JSONObject) obj;
                String title = (String) quiz.get("QuizTitle");
                String creator = (String) quiz.get("Creator");
                String category = (String) quiz.get("Category");

                // Show all quizzes if the user is an Administrator
                boolean isAdmin = adminName != null && !adminName.isEmpty();
                boolean matchesCreator = isAdmin || creator.equals(gameMasterName);

                boolean matchesCategory = "All".equals(selectedCategory) || category.equalsIgnoreCase(selectedCategory);
                boolean matchesSearch = title.toLowerCase().contains(searchText) || category.toLowerCase().contains(searchText);

                if (matchesCreator && matchesCategory && matchesSearch) {
                    model.addRow(new Object[]{title, creator, category});
                }
            }

        } catch (IOException | ParseException e) {
            JOptionPane.showMessageDialog(this, "Error loading quizzes.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addSearchListener() {
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

    // ✅ ADDED METHOD: Filters quiz table based on search query
    private void initializeListeners() {
        // Listener for Back button to navigate back to the main screen
        BackButton.addActionListener(this::BackButtonActionPerformed);

        // Listener for category selection changes to reload quizzes
        CategorySelection.addActionListener(this::CategorySelectionActionPerformed);

        // Listener for delete button to delete a selected quiz
        DeleteButton.addActionListener(this::DeleteButtonActionPerformed);

        // Listener for undo button to undo the last deletion
        undoButton.addActionListener(this::undoButtonActionPerformed);

        // Add a search listener for the searchField to filter quizzes dynamically
        addSearchListener();
    }

    private static class DeletedQuiz {

        private final JSONObject quiz;
        private final int rowIndex;

        public DeletedQuiz(JSONObject quiz, int rowIndex) {
            this.quiz = quiz;
            this.rowIndex = rowIndex;
        }

        public JSONObject getQuiz() {
            return quiz;
        }

        public int getRowIndex() {
            return rowIndex;
        }
    }

    private void customizeQuizTableHeader() {
        if (quizTable != null && quizTable.getTableHeader() != null) {
            quizTable.getTableHeader().setFont(new Font("ORC A Extended", Font.BOLD, 14));
            quizTable.getTableHeader().setOpaque(false);
            quizTable.getTableHeader().setBackground(new Color(102, 0, 255));
            quizTable.getTableHeader().setForeground(new Color(242, 242, 242));
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new DeleteQuiz("Test", "Testss", "Testsss").setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JComboBox<String> CategorySelection;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JLabel deleteQuiz;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable quizTable;
    private javax.swing.JTextField searchField;
    private javax.swing.JButton undoButton;
    // End of variables declaration//GEN-END:variables
}
