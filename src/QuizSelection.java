
import java.awt.Color;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.*;
import org.json.simple.parser.*;

public class QuizSelection extends javax.swing.JFrame {

    private final String playerName;
    private final String usname;
    private JSONArray quizzesArray;
    private static final String FILE_PATH = "src/QuizData.json";

    public QuizSelection(String playerName, String quizData, String selectedQuiz, String usname) {
        this.playerName = playerName;
        this.usname = usname;
        initComponents();
        setupLiveSearch(); // 👈 Add this
        loadQuizData();
        populateTable(quizzesArray);
        
        quizTable.getTableHeader().setFont(new Font("ORC A Extended", Font.BOLD, 14));
        quizTable.getTableHeader().setOpaque(false);
        quizTable.getTableHeader().setBackground(new Color(51, 51, 255));
        quizTable.getTableHeader().setForeground(new Color(242, 242, 242));
        

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        quizSelection = new javax.swing.JLabel();
        startButton = new javax.swing.JButton();
        Back = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        quizTable = new javax.swing.JTable();
        categorySelection = new javax.swing.JComboBox<>();
        searchField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        quizSelection.setFont(new java.awt.Font("OCR A Extended", 1, 18)); // NOI18N
        quizSelection.setForeground(new java.awt.Color(255, 255, 255));
        quizSelection.setText("Select a quiz!");
        jPanel1.add(quizSelection, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, -1, -1));

        startButton.setBackground(new java.awt.Color(51, 51, 255));
        startButton.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        startButton.setForeground(new java.awt.Color(255, 255, 255));
        startButton.setText("START GAME");
        startButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });
        jPanel1.add(startButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 470, 130, 30));

        Back.setBackground(new java.awt.Color(51, 51, 255));
        Back.setFont(new java.awt.Font("OCR A Extended", 1, 24)); // NOI18N
        Back.setForeground(new java.awt.Color(255, 0, 51));
        Back.setText("<");
        Back.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });
        jPanel1.add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 120, 30));

        quizTable.setBackground(new java.awt.Color(102, 102, 255));
        quizTable.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        quizTable.setForeground(new java.awt.Color(255, 255, 255));
        quizTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Quiz Title", "Creator", "Category"
            }
        ));
        jScrollPane1.setViewportView(quizTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, 410, 193));

        categorySelection.setBackground(new java.awt.Color(102, 102, 255));
        categorySelection.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        categorySelection.setForeground(new java.awt.Color(255, 255, 255));
        categorySelection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Math", "Science", "History", "English", " " }));
        categorySelection.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        categorySelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categorySelectionActionPerformed(evt);
            }
        });
        jPanel1.add(categorySelection, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 220, 130, 30));

        searchField.setBackground(new java.awt.Color(102, 102, 255));
        searchField.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        searchField.setForeground(new java.awt.Color(255, 255, 255));
        searchField.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });
        jPanel1.add(searchField, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 152, 410, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Quiz Select BG.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 560));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        new Player(playerName, "Player", 1, 2, "Player", usname).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackActionPerformed

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        int selectedRow = quizTable.getSelectedRow(); // Get the selected row from the table
        if (selectedRow != -1) {
            // Retrieve the quiz title and category from the selected row
            DefaultTableModel model = (DefaultTableModel) quizTable.getModel();
            String selectedQuizTitle = (String) model.getValueAt(selectedRow, 0);
            String selectedQuizCategory = (String) model.getValueAt(selectedRow, 2); // Get the category

            JSONObject chosenQuiz = null;

            // Find the corresponding JSON object from the loaded quizzes
            for (Object o : quizzesArray) {
                JSONObject quiz = (JSONObject) o;
                String title = (String) quiz.get("QuizTitle"); // Match the key from your JSON file
                if (title.equals(selectedQuizTitle)) {
                    chosenQuiz = quiz;
                    break;
                }
            }

            if (chosenQuiz != null) {
                // Pass the quiz title, category, and quiz data to the Quiz class
                new Quiz(playerName, chosenQuiz.toJSONString(), selectedQuizTitle, selectedQuizCategory, usname).setVisible(true);
                this.dispose(); // Close the current frame
            } else {
                JOptionPane.showMessageDialog(this, "Quiz not found.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a quiz.");
        }    }//GEN-LAST:event_startButtonActionPerformed

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
    ////
    }//GEN-LAST:event_searchFieldActionPerformed

    private void categorySelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categorySelectionActionPerformed
        String selectedCategory = (String) categorySelection.getSelectedItem();
        if (selectedCategory.equals("All")) {
            populateTable(quizzesArray);
            return;
        }

        JSONArray filtered = new JSONArray();
        for (Object o : quizzesArray) {
            JSONObject quiz = (JSONObject) o;
            String category = (String) quiz.get("Category");
            if (category.equalsIgnoreCase(selectedCategory)) {
                filtered.add(quiz);
            }
        }

        populateTable(filtered);
    }//GEN-LAST:event_categorySelectionActionPerformed

    private void loadQuizData() {
        try {
            JSONParser parser = new JSONParser();
            // Parse the JSON file
            JSONObject obj = (JSONObject) parser.parse(new FileReader(FILE_PATH));

            // Ensure "Quizzes" is correctly parsed as a JSONArray
            Object quizzes = obj.get("Quizzes");
            if (quizzes instanceof JSONArray jSONArray) {
                quizzesArray = jSONArray; // Cast safely to JSONArray
            } else {
                throw new ClassCastException("'Quizzes' is not a JSONArray in the JSON file.");
            }

            if (quizzesArray.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No quizzes found in the file.");
            }
        } catch (IOException | ParseException e) {
            JOptionPane.showMessageDialog(this, "Failed to load quiz data: " + e.getMessage());
            quizzesArray = new JSONArray(); // Default to an empty array on error
        } catch (ClassCastException e) {
            JOptionPane.showMessageDialog(this, "Error: 'Quizzes' is not a valid JSONArray. Please check the JSON file structure.");
            quizzesArray = new JSONArray(); // Handle invalid structure
        }
    }

    private void populateTable(JSONArray array) {
        DefaultTableModel model = (DefaultTableModel) quizTable.getModel();
        model.setRowCount(0); // Clear existing rows

        for (Object o : array) {
            JSONObject quiz = (JSONObject) o;
            String title = (String) quiz.get("QuizTitle");
            String creator = (String) quiz.get("Creator");
            String category = (String) quiz.get("Category");
            model.addRow(new Object[]{title, creator, category});
        }

        if (array.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No quizzes found.");
        }
    }

    private void searchQuizzes(String keyword) {
        try (FileReader reader = new FileReader(FILE_PATH)) {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            JSONArray quizArray = (JSONArray) jsonObject.get("Quizzes");

            JSONArray filtered = new JSONArray(); // Use JSONArray instead of List
            String keywordLower = keyword.toLowerCase();

            for (Object obj : quizArray) {
                JSONObject quiz = (JSONObject) obj;

                String title = (String) quiz.get("QuizTitle");
                String creator = (String) quiz.get("Creator");
                String category = (String) quiz.get("Category");

                if ((title != null && title.toLowerCase().contains(keywordLower))
                        || (creator != null && creator.toLowerCase().contains(keywordLower))
                        || (category != null && category.toLowerCase().contains(keywordLower))) {
                    filtered.add(quiz); // Add directly to JSONArray
                }
            }

            populateTable(filtered); // Now it's a proper JSONArray

        } catch (IOException | ParseException ex) {
            JOptionPane.showMessageDialog(this, "Error loading search results: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void setupLiveSearch() {
        searchField.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                performSearch();
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                performSearch();
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                performSearch();
            }

            private void performSearch() {
                String keyword = searchField.getText().trim();
                if (!keyword.isEmpty()) {
                    searchQuizzes(keyword);
                } else {
                    populateTable(quizzesArray);
                }
            }
        });
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new QuizSelection("TestPlayer", "Testsss", "Tetss", "testing").setVisible(true); // Pass only the player name
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> categorySelection;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel quizSelection;
    private javax.swing.JTable quizTable;
    private javax.swing.JTextField searchField;
    private javax.swing.JButton startButton;
    // End of variables declaration//GEN-END:variables
}
