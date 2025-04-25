
import javax.swing.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class EditQuiz extends javax.swing.JFrame {

    private static final String FILE_PATH = "src/QuizData.json";
    private static final JSONParser jsonParser = new JSONParser();
    private final String adminName;
    private final String gameMasterName;
    private final String usname;
    private ButtonGroup answerGroup = new ButtonGroup();
    private final JSONArray quizArray = new JSONArray(); // Stores questions for the current quiz

    private int currentQuestionIndex = -1; // Tracks the currently displayed question

    public EditQuiz(String selectedQuizTitle, String adminName, String gameMasterName, String usname) {
        this.adminName = adminName; // Ensure adminName is always initialized
        this.gameMasterName = gameMasterName;
        this.usname = usname;

        if (selectedQuizTitle == null || selectedQuizTitle.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No quiz title provided. Cannot edit quiz.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Exit early, but adminName is already initialized
        }

        initComponents();

        // Group radio buttons for selecting the correct answer
        answerGroup = new ButtonGroup();
        answerGroup.add(option1Button);
        answerGroup.add(option2Button);
        answerGroup.add(option3Button);
        answerGroup.add(option4Button);

        // Load quiz data from the selected quiz
        loadQuizData(selectedQuizTitle);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CorrectAnswer = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        option4Field = new javax.swing.JTextField();
        option3Field = new javax.swing.JTextField();
        option2Field = new javax.swing.JTextField();
        option1Field = new javax.swing.JTextField();
        option4Button = new javax.swing.JRadioButton();
        option3Button = new javax.swing.JRadioButton();
        option2Button = new javax.swing.JRadioButton();
        option1Button = new javax.swing.JRadioButton();
        inputButton = new javax.swing.JButton();
        previousQuestionButton = new javax.swing.JButton();
        saveQuizButton = new javax.swing.JButton();
        nextQuestionButton = new javax.swing.JButton();
        quizTitleLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        editQuizTitle = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        newQuizTitle = new javax.swing.JTextField();
        Back = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        categorySelection = new javax.swing.JComboBox<>();
        questionAmount = new javax.swing.JComboBox<>();
        questionCounterLabel = new javax.swing.JLabel();
        questionField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 240, -1, -1));

        option4Field.setBackground(new java.awt.Color(102, 102, 255));
        option4Field.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        option4Field.setForeground(new java.awt.Color(255, 255, 255));
        option4Field.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(option4Field, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 390, 260, 30));

        option3Field.setBackground(new java.awt.Color(102, 102, 255));
        option3Field.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        option3Field.setForeground(new java.awt.Color(255, 255, 255));
        option3Field.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(option3Field, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 350, 260, 30));

        option2Field.setBackground(new java.awt.Color(102, 102, 255));
        option2Field.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        option2Field.setForeground(new java.awt.Color(255, 255, 255));
        option2Field.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(option2Field, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 310, 260, 30));

        option1Field.setBackground(new java.awt.Color(102, 102, 255));
        option1Field.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        option1Field.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        option1Field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option1FieldActionPerformed(evt);
            }
        });
        getContentPane().add(option1Field, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 270, 260, 30));

        CorrectAnswer.add(option4Button);
        option4Button.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        option4Button.setForeground(new java.awt.Color(255, 255, 255));
        option4Button.setText("Option #4:");
        option4Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option4ButtonActionPerformed(evt);
            }
        });
        getContentPane().add(option4Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 390, -1, 30));

        CorrectAnswer.add(option3Button);
        option3Button.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        option3Button.setForeground(new java.awt.Color(255, 255, 255));
        option3Button.setText("Option #3:");
        option3Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option3ButtonActionPerformed(evt);
            }
        });
        getContentPane().add(option3Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 350, 110, 30));

        CorrectAnswer.add(option2Button);
        option2Button.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        option2Button.setForeground(new java.awt.Color(255, 255, 255));
        option2Button.setText("Option #2:");
        option2Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option2ButtonActionPerformed(evt);
            }
        });
        getContentPane().add(option2Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 310, 110, 30));

        CorrectAnswer.add(option1Button);
        option1Button.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        option1Button.setForeground(new java.awt.Color(255, 255, 255));
        option1Button.setText("Option #1:");
        getContentPane().add(option1Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 270, 110, 30));

        inputButton.setBackground(new java.awt.Color(102, 0, 255));
        inputButton.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        inputButton.setForeground(new java.awt.Color(255, 255, 255));
        inputButton.setText("Input");
        inputButton.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(inputButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 190, 70, 30));

        previousQuestionButton.setBackground(new java.awt.Color(102, 0, 255));
        previousQuestionButton.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        previousQuestionButton.setForeground(new java.awt.Color(255, 255, 255));
        previousQuestionButton.setText("Previous");
        previousQuestionButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        previousQuestionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousQuestionButtonActionPerformed(evt);
            }
        });
        getContentPane().add(previousQuestionButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 440, 120, 30));

        saveQuizButton.setBackground(new java.awt.Color(102, 0, 255));
        saveQuizButton.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        saveQuizButton.setForeground(new java.awt.Color(255, 255, 255));
        saveQuizButton.setText("Save");
        saveQuizButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        saveQuizButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveQuizButtonActionPerformed(evt);
            }
        });
        getContentPane().add(saveQuizButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(492, 440, 110, 30));

        nextQuestionButton.setBackground(new java.awt.Color(102, 0, 255));
        nextQuestionButton.setForeground(new java.awt.Color(255, 255, 255));
        nextQuestionButton.setText("Next");
        nextQuestionButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        nextQuestionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextQuestionButtonActionPerformed(evt);
            }
        });
        getContentPane().add(nextQuestionButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 440, 110, 30));

        quizTitleLabel.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        quizTitleLabel.setForeground(new java.awt.Color(255, 255, 255));
        quizTitleLabel.setText("Quiz Title Label");
        getContentPane().add(quizTitleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, -1, 20));

        jLabel3.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Quiz Title:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, -1, 20));

        editQuizTitle.setFont(new java.awt.Font("OCR A Extended", 1, 18)); // NOI18N
        editQuizTitle.setForeground(new java.awt.Color(255, 255, 255));
        editQuizTitle.setText("Edit Quiz");
        getContentPane().add(editQuizTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, -1, 20));

        jLabel4.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("New Quiz Title:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, 130, 30));

        newQuizTitle.setBackground(new java.awt.Color(102, 102, 255));
        newQuizTitle.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        newQuizTitle.setForeground(new java.awt.Color(255, 255, 255));
        newQuizTitle.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(newQuizTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, 160, 30));

        Back.setBackground(new java.awt.Color(102, 0, 255));
        Back.setFont(new java.awt.Font("OCR A Extended", 1, 24)); // NOI18N
        Back.setForeground(new java.awt.Color(255, 0, 51));
        Back.setText("<");
        Back.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });
        getContentPane().add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 120, 30));

        jLabel1.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("# of Questions");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, -1, 30));

        jLabel2.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Category:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, -1, 30));

        categorySelection.setBackground(new java.awt.Color(102, 102, 255));
        categorySelection.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        categorySelection.setForeground(new java.awt.Color(255, 255, 255));
        categorySelection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Math", "Science", "History", "English" }));
        categorySelection.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(categorySelection, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 190, 80, 30));

        questionAmount.setBackground(new java.awt.Color(102, 102, 255));
        questionAmount.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        questionAmount.setForeground(new java.awt.Color(255, 255, 255));
        questionAmount.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        questionAmount.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(questionAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 150, 160, 30));

        questionCounterLabel.setText("Question #1:");
        getContentPane().add(questionCounterLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 360, -1, -1));

        questionField.setBackground(new java.awt.Color(102, 102, 255));
        questionField.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        questionField.setForeground(new java.awt.Color(255, 255, 255));
        questionField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        questionField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                questionFieldActionPerformed(evt);
            }
        });
        getContentPane().add(questionField, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 230, 210, 30));

        jLabel5.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/GameOn! (Purple BG).png"))); // NOI18N
        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 550));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        if (adminName != null && !adminName.isEmpty()) {
            // Navigate back to Administrator.java for adminName
            Administrator admin = new Administrator(adminName, usname);
            admin.setVisible(true);
        } else if (gameMasterName != null && !gameMasterName.isEmpty()) {
            // Navigate back to GameMaster.java for gameMasterName
            GameMaster g = new GameMaster(gameMasterName, usname);
            g.setVisible(true);
        }

        this.setVisible(false); // Close the current CreateQuiz window
    }//GEN-LAST:event_BackActionPerformed

    private void option2ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option2ButtonActionPerformed
        CorrectAnswer.clearSelection();
        option2Button.setSelected(true);
    }//GEN-LAST:event_option2ButtonActionPerformed

    private void saveQuizButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveQuizButtonActionPerformed
        saveCurrentQuestion(); // Ensure the current question is saved

        boolean changesMade = false; // Flag to track if any changes were made

        try (FileReader reader = new FileReader(FILE_PATH)) {
            JSONObject root = (JSONObject) jsonParser.parse(reader);
            JSONArray quizzes = (JSONArray) root.get("Quizzes");

            for (Object obj : quizzes) {
                JSONObject quizObject = (JSONObject) obj;

                if (quizTitleLabel.getText().equals(quizObject.get("QuizTitle"))) {
                    // Check for changes in category or questions
                    if (!quizObject.get("Category").equals(categorySelection.getSelectedItem())) {
                        changesMade = true;
                    }

                    JSONArray existingQuestions = (JSONArray) quizObject.get("Questions");
                    if (!existingQuestions.equals(quizArray)) {
                        changesMade = true;
                    }

                    // Update the quiz data if changes were made
                    if (changesMade) {
                        quizObject.put("Category", categorySelection.getSelectedItem());
                        quizObject.put("Questions", quizArray);
                    }
                    break;
                }
            }

            if (!changesMade) {
                showMessage("Nothing was changed.", "No Changes", JOptionPane.INFORMATION_MESSAGE);
                return; // Exit early if no changes were made
            }

            try (FileWriter writer = new FileWriter(FILE_PATH)) {
                writer.write(root.toJSONString());
                showMessage("Quiz updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (IOException | ParseException e) {
            Logger.getLogger(EditQuiz.class.getName()).log(Level.SEVERE, "Error saving quiz data", e);
            showMessage("Error saving quiz data. Please try again.", "Save Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_saveQuizButtonActionPerformed

    private void option3ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option3ButtonActionPerformed
        CorrectAnswer.clearSelection();
        option3Button.setSelected(true);
    }//GEN-LAST:event_option3ButtonActionPerformed

    private void option4ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option4ButtonActionPerformed
        CorrectAnswer.clearSelection();
        option4Button.setSelected(true);
    }//GEN-LAST:event_option4ButtonActionPerformed

    private void questionFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_questionFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_questionFieldActionPerformed

    private void option1FieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option1FieldActionPerformed
        CorrectAnswer.clearSelection();
        option1Button.setSelected(true);
    }//GEN-LAST:event_option1FieldActionPerformed

    private void previousQuestionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousQuestionButtonActionPerformed
        saveCurrentQuestion(); // Save the current question before navigating
        if (currentQuestionIndex > 0) {
            currentQuestionIndex--;
            loadQuestion(currentQuestionIndex);
        }
    }//GEN-LAST:event_previousQuestionButtonActionPerformed

    private void nextQuestionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextQuestionButtonActionPerformed
        saveCurrentQuestion(); // Save the current question before navigating
        if (currentQuestionIndex < quizArray.size() - 1) {
            currentQuestionIndex++;
            loadQuestion(currentQuestionIndex);
        }
    }//GEN-LAST:event_nextQuestionButtonActionPerformed

    private void loadQuizData(String selectedQuizTitle) {
        if (selectedQuizTitle == null || selectedQuizTitle.trim().isEmpty()) {
            showMessage("No quiz title provided for loading.", "Load Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (FileReader reader = new FileReader(FILE_PATH)) {
            JSONObject root = (JSONObject) jsonParser.parse(reader);
            JSONArray quizzes = (JSONArray) root.get("Quizzes");

            boolean quizFound = false;
            for (Object obj : quizzes) {
                JSONObject quizObject = (JSONObject) obj;

                if (selectedQuizTitle.equals(quizObject.get("QuizTitle"))) {
                    quizFound = true;

                    quizTitleLabel.setText(selectedQuizTitle);
                    categorySelection.setSelectedItem(quizObject.getOrDefault("Category", "Uncategorized"));

                    // Load questions into quiz array
                    JSONArray questions = (JSONArray) quizObject.getOrDefault("Questions", new JSONArray());
                    quizArray.clear();
                    quizArray.addAll(questions);

                    if (quizArray.isEmpty()) {
                        showMessage("The selected quiz has no questions to edit.", "No Questions", JOptionPane.WARNING_MESSAGE);
                        previousQuestionButton.setEnabled(false);
                        nextQuestionButton.setEnabled(false);
                    } else {
                        currentQuestionIndex = 0;
                        loadQuestion(currentQuestionIndex); // Load the first question
                    }
                    break;
                }
            }

            if (!quizFound) {
                showMessage("The selected quiz could not be found.", "Load Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException | ParseException e) {
            Logger.getLogger(EditQuiz.class.getName()).log(Level.SEVERE, "Error loading quiz data", e);
            showMessage("Error loading quiz data. Please try again.", "Load Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadQuestion(int index) {
        if (index < 0 || index >= quizArray.size()) {
            return; // No operation if index is out of bounds
        }

        JSONObject questionObject = (JSONObject) quizArray.get(index);

        // Safely populate fields
        questionField.setText(questionObject.getOrDefault("question", "").toString());
        option1Field.setText(questionObject.getOrDefault("option1", "").toString());
        option2Field.setText(questionObject.getOrDefault("option2", "").toString());
        option3Field.setText(questionObject.getOrDefault("option3", "").toString());
        option4Field.setText(questionObject.getOrDefault("option4", "").toString());

        // Set the correct answer
        String correctAnswer = questionObject.getOrDefault("answer", "").toString();
        if (correctAnswer.equals(option1Field.getText())) {
            answerGroup.setSelected(option1Button.getModel(), true);
        } else if (correctAnswer.equals(option2Field.getText())) {
            answerGroup.setSelected(option2Button.getModel(), true);
        } else if (correctAnswer.equals(option3Field.getText())) {
            answerGroup.setSelected(option3Button.getModel(), true);
        } else if (correctAnswer.equals(option4Field.getText())) {
            answerGroup.setSelected(option4Button.getModel(), true);
        }

        // Update the question counter
        questionCounterLabel.setText("Question #" + (index + 1));

        // Enable or disable navigation buttons
        previousQuestionButton.setEnabled(index > 0); // Disable if it's the first question
        nextQuestionButton.setEnabled(index < quizArray.size() - 1); // Disable if it's the last question
    }

    private void saveCurrentQuestion() {
        if (currentQuestionIndex < 0) {
            showMessage("No question selected to save.", "Save Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        JSONObject questionObject = new JSONObject();

        // Safely retrieve field values
        questionObject.put("question", questionField.getText() != null ? questionField.getText().trim() : "");
        questionObject.put("option1", option1Field.getText() != null ? option1Field.getText().trim() : "");
        questionObject.put("option2", option2Field.getText() != null ? option2Field.getText().trim() : "");
        questionObject.put("option3", option3Field.getText() != null ? option3Field.getText().trim() : "");
        questionObject.put("option4", option4Field.getText() != null ? option4Field.getText().trim() : "");

        // Save the selected correct answer
        if (option1Button.isSelected()) {
            questionObject.put("answer", questionObject.get("option1"));
        } else if (option2Button.isSelected()) {
            questionObject.put("answer", questionObject.get("option2"));
        } else if (option3Button.isSelected()) {
            questionObject.put("answer", questionObject.get("option3"));
        } else if (option4Button.isSelected()) {
            questionObject.put("answer", questionObject.get("option4"));
        }

        // Update the quiz array
        if (currentQuestionIndex < quizArray.size()) {
            quizArray.set(currentQuestionIndex, questionObject);
        } else {
            quizArray.add(questionObject);
        }
    }

    private void showMessage(String message, String title, int messageType) {
        JOptionPane.showMessageDialog(this, message, title, messageType);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new EditQuiz("Sample Quiz", "GameMaster", "testUser", "testss").setVisible(true));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.ButtonGroup CorrectAnswer;
    private javax.swing.JComboBox<String> categorySelection;
    private javax.swing.JLabel editQuizTitle;
    private javax.swing.JButton inputButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField newQuizTitle;
    private javax.swing.JButton nextQuestionButton;
    private javax.swing.JRadioButton option1Button;
    private javax.swing.JTextField option1Field;
    private javax.swing.JRadioButton option2Button;
    private javax.swing.JTextField option2Field;
    private javax.swing.JRadioButton option3Button;
    private javax.swing.JTextField option3Field;
    private javax.swing.JRadioButton option4Button;
    private javax.swing.JTextField option4Field;
    private javax.swing.JButton previousQuestionButton;
    private javax.swing.JComboBox<String> questionAmount;
    private javax.swing.JLabel questionCounterLabel;
    private javax.swing.JTextField questionField;
    private javax.swing.JLabel quizTitleLabel;
    private javax.swing.JButton saveQuizButton;
    // End of variables declaration//GEN-END:variables
}
