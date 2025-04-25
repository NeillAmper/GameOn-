
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public final class CreateQuiz extends javax.swing.JFrame {

    private String title, category, question, opt1, opt2, opt3, opt4, correctanswer;
    private int numberOfQuizToEnter = 0; // Total number of questions for the quiz
    private final JSONArray newQuizArray = new JSONArray(); // Stores questions for the current quiz
    private static final JSONParser jsonParser = new JSONParser();
    private static final String FILE_PATH = "src/QuizData.json";
    private final String gameMasterName;
    private final String adminName;
    private final String usname;
    private final ButtonGroup answerGroup;
    private int currentQuestionIndex = -1; // Tracks the currently displayed question
    private static final String DEFAULT_CATEGORY = "Select a Category";

    public CreateQuiz(String adminName, String gameMasterName, String usname) {
        initComponents();

        this.adminName = adminName;
        this.gameMasterName = gameMasterName;
        this.usname = usname;

        // Group radio buttons for selecting the correct answer
        answerGroup = new ButtonGroup();
        answerGroup.add(option1Button);
        answerGroup.add(option2Button);
        answerGroup.add(option3Button);
        answerGroup.add(option4Button);

        resetAllFields();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        categorySelection = new javax.swing.JComboBox<>();
        labelquestioncounter = new javax.swing.JLabel();
        questionField = new javax.swing.JTextField();
        option1Button = new javax.swing.JRadioButton();
        option1Field = new javax.swing.JTextField();
        option2Button = new javax.swing.JRadioButton();
        option3Button = new javax.swing.JRadioButton();
        option4Button = new javax.swing.JRadioButton();
        option2Field = new javax.swing.JTextField();
        option3Field = new javax.swing.JTextField();
        option4Field = new javax.swing.JTextField();
        saveQuizButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        numberOfQuestionsLabel = new javax.swing.JLabel();
        questionAmount = new javax.swing.JComboBox<>();
        inputButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        quizTitle = new javax.swing.JTextField();
        previousQuestionButton = new javax.swing.JButton();
        nextQuestionButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("OCR A Extended", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Create Quiz");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Category:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, 80, 30));

        categorySelection.setBackground(new java.awt.Color(102, 51, 255));
        categorySelection.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        categorySelection.setForeground(new java.awt.Color(255, 255, 255));
        categorySelection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select a Category", "Math", "Science", "History", "English" }));
        categorySelection.setActionCommand("");
        categorySelection.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        categorySelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categorySelectionActionPerformed(evt);
            }
        });
        jPanel1.add(categorySelection, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, 210, 30));

        labelquestioncounter.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        labelquestioncounter.setForeground(new java.awt.Color(255, 255, 255));
        labelquestioncounter.setText("Question #1:");
        jPanel1.add(labelquestioncounter, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, 110, 30));

        questionField.setBackground(new java.awt.Color(102, 51, 255));
        questionField.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        questionField.setForeground(new java.awt.Color(255, 255, 255));
        questionField.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        questionField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                questionFieldActionPerformed(evt);
            }
        });
        jPanel1.add(questionField, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 220, 240, 30));

        buttonGroup.add(option1Button);
        option1Button.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        option1Button.setForeground(new java.awt.Color(255, 255, 255));
        option1Button.setText("Option #1:");
        option1Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option1ButtonActionPerformed(evt);
            }
        });
        jPanel1.add(option1Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, 110, 30));

        option1Field.setBackground(new java.awt.Color(102, 51, 255));
        option1Field.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        option1Field.setForeground(new java.awt.Color(255, 255, 255));
        option1Field.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        option1Field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option1FieldActionPerformed(evt);
            }
        });
        jPanel1.add(option1Field, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 260, 240, 30));

        buttonGroup.add(option2Button);
        option2Button.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        option2Button.setForeground(new java.awt.Color(255, 255, 255));
        option2Button.setText("Option #2:");
        option2Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option2ButtonActionPerformed(evt);
            }
        });
        jPanel1.add(option2Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 300, 110, 30));

        buttonGroup.add(option3Button);
        option3Button.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        option3Button.setForeground(new java.awt.Color(255, 255, 255));
        option3Button.setText("Option #3:");
        option3Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option3ButtonActionPerformed(evt);
            }
        });
        jPanel1.add(option3Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 340, 110, 30));

        buttonGroup.add(option4Button);
        option4Button.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        option4Button.setForeground(new java.awt.Color(255, 255, 255));
        option4Button.setText("Option #4:");
        option4Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option4ButtonActionPerformed(evt);
            }
        });
        jPanel1.add(option4Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 380, -1, 30));

        option2Field.setBackground(new java.awt.Color(102, 51, 255));
        option2Field.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        option2Field.setForeground(new java.awt.Color(255, 255, 255));
        option2Field.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        option2Field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option2FieldActionPerformed(evt);
            }
        });
        jPanel1.add(option2Field, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 300, 240, 30));

        option3Field.setBackground(new java.awt.Color(102, 51, 255));
        option3Field.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        option3Field.setForeground(new java.awt.Color(255, 255, 255));
        option3Field.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(option3Field, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 340, 240, 30));

        option4Field.setBackground(new java.awt.Color(102, 51, 255));
        option4Field.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        option4Field.setForeground(new java.awt.Color(255, 255, 255));
        option4Field.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(option4Field, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 380, 240, 30));

        saveQuizButton.setBackground(new java.awt.Color(102, 0, 255));
        saveQuizButton.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        saveQuizButton.setForeground(new java.awt.Color(255, 255, 255));
        saveQuizButton.setText("Save");
        saveQuizButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        saveQuizButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveQuizButtonActionPerformed(evt);
            }
        });
        jPanel1.add(saveQuizButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 440, 120, 30));

        backButton.setBackground(new java.awt.Color(102, 0, 255));
        backButton.setFont(new java.awt.Font("OCR A Extended", 1, 24)); // NOI18N
        backButton.setForeground(new java.awt.Color(255, 0, 51));
        backButton.setText("<");
        backButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        jPanel1.add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 120, 30));

        numberOfQuestionsLabel.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        numberOfQuestionsLabel.setForeground(new java.awt.Color(255, 255, 255));
        numberOfQuestionsLabel.setText("# of Questions");
        jPanel1.add(numberOfQuestionsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, -1, 30));

        questionAmount.setBackground(new java.awt.Color(102, 51, 255));
        questionAmount.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        questionAmount.setForeground(new java.awt.Color(255, 255, 255));
        questionAmount.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        questionAmount.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        questionAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                questionAmountActionPerformed(evt);
            }
        });
        jPanel1.add(questionAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, 100, 30));

        inputButton.setBackground(new java.awt.Color(102, 0, 255));
        inputButton.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        inputButton.setForeground(new java.awt.Color(255, 255, 255));
        inputButton.setText("Input");
        inputButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        inputButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputButtonActionPerformed(evt);
            }
        });
        jPanel1.add(inputButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 130, 100, 30));

        jLabel4.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Quiz Title: ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, -1, 30));

        quizTitle.setBackground(new java.awt.Color(102, 51, 255));
        quizTitle.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        quizTitle.setForeground(new java.awt.Color(255, 255, 255));
        quizTitle.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(quizTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, 210, 30));

        previousQuestionButton.setBackground(new java.awt.Color(102, 0, 255));
        previousQuestionButton.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        previousQuestionButton.setForeground(new java.awt.Color(255, 255, 255));
        previousQuestionButton.setText("Previous");
        previousQuestionButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        previousQuestionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousQuestionButtonActionPerformed(evt);
            }
        });
        jPanel1.add(previousQuestionButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 440, 120, 30));

        nextQuestionButton.setBackground(new java.awt.Color(102, 0, 255));
        nextQuestionButton.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        nextQuestionButton.setForeground(new java.awt.Color(255, 255, 255));
        nextQuestionButton.setText("Next");
        nextQuestionButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        nextQuestionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextQuestionButtonActionPerformed(evt);
            }
        });
        jPanel1.add(nextQuestionButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 440, 120, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/GameOn! (Purple BG).png"))); // NOI18N
        jLabel3.setText("jLabel3");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 550));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void option1ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option1ButtonActionPerformed
        correctanswer = option1Field.getText();
    }//GEN-LAST:event_option1ButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        resetAllFields();
        if (adminName != null && !adminName.isEmpty()) {
            Administrator admin = new Administrator(adminName, usname);
            admin.setVisible(true);
        } else if (gameMasterName != null && !gameMasterName.isEmpty()) {
            GameMaster g = new GameMaster(gameMasterName, usname);
            g.setVisible(true);
        }
        this.setVisible(false);
    }//GEN-LAST:event_backButtonActionPerformed

    private void option4ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option4ButtonActionPerformed
        correctanswer = option4Field.getText();
    }//GEN-LAST:event_option4ButtonActionPerformed

    private void option2ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option2ButtonActionPerformed

        correctanswer = option2Field.getText();
    }//GEN-LAST:event_option2ButtonActionPerformed

    private void saveQuizButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveQuizButtonActionPerformed
        validateAndSaveQuiz();
    }//GEN-LAST:event_saveQuizButtonActionPerformed

    private void questionFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_questionFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_questionFieldActionPerformed

    private void option2FieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option2FieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_option2FieldActionPerformed

    private void option3ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option3ButtonActionPerformed
        correctanswer = option3Field.getText();
    }//GEN-LAST:event_option3ButtonActionPerformed

    private void savequizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savequizActionPerformed

    }//GEN-LAST:event_savequizActionPerformed

    private void categorySelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categorySelectionActionPerformed


    }//GEN-LAST:event_categorySelectionActionPerformed

    private void inputButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputButtonActionPerformed
        title = quizTitle.getText().trim();

        try {
            numberOfQuizToEnter = Integer.parseInt((String) questionAmount.getSelectedItem());
        } catch (NumberFormatException e) {
            showMessage("Invalid number of questions selected.", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (DEFAULT_CATEGORY.equals(categorySelection.getSelectedItem())) {
            showMessage("You must select a category.", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (title.isEmpty() || numberOfQuizToEnter <= 0) {
            showMessage("Please input a quiz title and number of questions.", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        currentQuestionIndex = 0;
        newQuizArray.clear();
        labelquestioncounter.setText("Question #1");
        toggleInputFields(true);
        updateNavigationButtons();
        saveQuizButton.setEnabled(true);
        showMessage("Ready to enter " + numberOfQuizToEnter + " questions.", "Quiz Setup", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_inputButtonActionPerformed

    private void questionAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_questionAmountActionPerformed


    }//GEN-LAST:event_questionAmountActionPerformed

    private void option1FieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option1FieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_option1FieldActionPerformed

    private void previousQuestionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousQuestionButtonActionPerformed
        saveCurrentQuestion(false);
        if (currentQuestionIndex > 0) {
            currentQuestionIndex--;
            loadQuestion(currentQuestionIndex);
        }
        updateNavigationButtons(); // Ensure proper button state
    }//GEN-LAST:event_previousQuestionButtonActionPerformed

    private void nextQuestionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextQuestionButtonActionPerformed
        saveCurrentQuestion(false);
        if (currentQuestionIndex < newQuizArray.size() - 1) {
            currentQuestionIndex++;
            loadQuestion(currentQuestionIndex);
        } else if (currentQuestionIndex < numberOfQuizToEnter - 1) {
            clearFields();
            currentQuestionIndex++;
            labelquestioncounter.setText("Question #" + (currentQuestionIndex + 1));
        } else {
            showMessage("You have reached the last question.", "Navigation Error", JOptionPane.WARNING_MESSAGE);
        }
        updateNavigationButtons();
    }//GEN-LAST:event_nextQuestionButtonActionPerformed

    private void resetAllFields() {
        quizTitle.setText("");
        quizTitle.setEnabled(true);
        categorySelection.setSelectedIndex(0);
        categorySelection.setEnabled(true);
        questionAmount.setSelectedIndex(0);
        questionAmount.setEnabled(true);
        inputButton.setEnabled(true);
        clearFields();
        newQuizArray.clear();
        currentQuestionIndex = -1;
        toggleInputFields(false);
        saveQuizButton.setEnabled(false);
        updateNavigationButtons();
    }

    private void updateNavigationButtons() {
        previousQuestionButton.setEnabled(currentQuestionIndex > 0);
        nextQuestionButton.setEnabled(currentQuestionIndex < numberOfQuizToEnter - 1);
        saveQuizButton.setEnabled(newQuizArray.size() == numberOfQuizToEnter);
    }

    private void loadQuestion(int index) {
        if (index < 0 || index >= newQuizArray.size()) {
            return;
        }

        JSONObject questionObject = (JSONObject) newQuizArray.get(index);
        questionField.setText((String) questionObject.getOrDefault("question", ""));
        option1Field.setText((String) questionObject.getOrDefault("option1", ""));
        option2Field.setText((String) questionObject.getOrDefault("option2", ""));
        option3Field.setText((String) questionObject.getOrDefault("option3", ""));
        option4Field.setText((String) questionObject.getOrDefault("option4", ""));

        String correctAnswer = (String) questionObject.getOrDefault("answer", null);
        if (correctAnswer != null) {
            if (correctAnswer.equalsIgnoreCase(option1Field.getText())) {
                answerGroup.setSelected(option1Button.getModel(), true);
            } else if (correctAnswer.equalsIgnoreCase(option2Field.getText())) {
                answerGroup.setSelected(option2Button.getModel(), true);
            } else if (correctAnswer.equalsIgnoreCase(option3Field.getText())) {
                answerGroup.setSelected(option3Button.getModel(), true);
            } else if (correctAnswer.equalsIgnoreCase(option4Field.getText())) {
                answerGroup.setSelected(option4Button.getModel(), true);
            }
        } else {
            answerGroup.clearSelection();
        }
        labelquestioncounter.setText("Question #" + (index + 1));
    }

    private void saveCurrentQuestion(boolean validate) {
        if (currentQuestionIndex < 0 || currentQuestionIndex >= numberOfQuizToEnter) {
            return;
        }

        if (validate && !validateQuestionInput()) {
            return;
        }

        JSONObject questionObject = new JSONObject();
        questionObject.put("questionnumber", currentQuestionIndex + 1);
        questionObject.put("question", questionField.getText().trim());
        questionObject.put("option1", option1Field.getText().trim());
        questionObject.put("option2", option2Field.getText().trim());
        questionObject.put("option3", option3Field.getText().trim());
        questionObject.put("option4", option4Field.getText().trim());

        // Save the selected correct answer
        if (option1Button.isSelected()) {
            questionObject.put("answer", option1Field.getText().trim());
        } else if (option2Button.isSelected()) {
            questionObject.put("answer", option2Field.getText().trim());
        } else if (option3Button.isSelected()) {
            questionObject.put("answer", option3Field.getText().trim());
        } else if (option4Button.isSelected()) {
            questionObject.put("answer", option4Field.getText().trim());
        } else {
            questionObject.put("answer", null); // No option selected
        }

        if (currentQuestionIndex < newQuizArray.size()) {
            newQuizArray.set(currentQuestionIndex, questionObject);
        } else {
            newQuizArray.add(questionObject);
        }
    }

    private boolean validateQuestionInput() {
        category = (String) categorySelection.getSelectedItem();
        question = questionField.getText().trim();
        opt1 = option1Field.getText().trim();
        opt2 = option2Field.getText().trim();
        opt3 = option3Field.getText().trim();
        opt4 = option4Field.getText().trim();

        if (DEFAULT_CATEGORY.equals(category) || question.isEmpty() || opt1.isEmpty() || opt2.isEmpty() || opt3.isEmpty() || opt4.isEmpty()) {
            showMessage("Please complete all fields and select a valid answer.", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        if (!areOptionsUnique(opt1, opt2, opt3, opt4)) {
            showMessage("Options must be unique.", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        if (correctanswer == null || !Arrays.asList(opt1, opt2, opt3, opt4).contains(correctanswer)) {
            showMessage("The correct answer must match one of the options.", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        return true;
    }

    private boolean areOptionsUnique(String... options) {
        return Arrays.stream(options).distinct().count() == options.length;
    }

    private void clearFields() {
        questionField.setText("");
        option1Field.setText("");
        option2Field.setText("");
        option3Field.setText("");
        option4Field.setText("");
        answerGroup.clearSelection();
    }

    private void saveQuizToFile() {
        try {
            JSONObject root = new JSONObject(); // Root object for JSON
            JSONArray quizzes = new JSONArray(); // Array to store all quizzes

            // Check if file exists and load existing data
            File file = new File(FILE_PATH);
            if (file.exists() && file.length() > 0) {
                try (FileReader reader = new FileReader(FILE_PATH)) {
                    Object parsedObject = jsonParser.parse(reader);
                    if (parsedObject instanceof JSONObject jSONObject) { // Ensure the content is a valid JSON object
                        root = jSONObject;
                        quizzes = (JSONArray) root.getOrDefault("Quizzes", new JSONArray());
                    } else {
                        Logger.getLogger(CreateQuiz.class.getName()).log(Level.WARNING, "Invalid JSON structure in file. Initializing new data.");
                    }
                } catch (IOException | ParseException e) {
                    Logger.getLogger(CreateQuiz.class.getName()).log(Level.WARNING, "Error reading or parsing file. Initializing new data.", e);
                }
            }

            // Create a new quiz object with the current session data
            JSONObject newQuiz = new JSONObject();
            newQuiz.put("QuizTitle", quizTitle.getText().trim()); // Save the text content of the quiz title
            newQuiz.put("Creator", gameMasterName);
            newQuiz.put("Category", category);
            newQuiz.put("Questions", newQuizArray);
            quizzes.add(newQuiz); // Add the new quiz to the array

            // Update the root object and write to the file
            root.put("Quizzes", quizzes);
            try (FileWriter writer = new FileWriter(FILE_PATH)) {
                writer.write(root.toJSONString());
            }
        } catch (IOException e) {
            showMessage("Failed to save the quiz.", "Save Error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(CreateQuiz.class.getName()).log(Level.SEVERE, "Error saving quiz.", e);
        }
    }

    private void showMessage(String message, String title, int messageType) {
        JOptionPane.showMessageDialog(this, message, title, messageType);
    }

    private void validateAndSaveQuiz() {
        // Check if the quiz title and category are valid
        if (quizTitle.getText().trim().isEmpty() || DEFAULT_CATEGORY.equals(categorySelection.getSelectedItem())) {
            showMessage("Incomplete or blank fields. Please fill out all required fields.", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Save the current question if not already saved
        saveCurrentQuestion(true);

        // Validate that all required questions have been entered
        if (newQuizArray.size() != numberOfQuizToEnter) {
            if (newQuizArray.size() < numberOfQuizToEnter) {
                showMessage("Please complete all " + numberOfQuizToEnter + " questions before saving.", "Validation Error", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }

        // Ensure at least one question exists
        if (newQuizArray.isEmpty()) {
            showMessage("Please complete at least one question before saving.", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Save the quiz to file
        saveQuizToFile();
        resetAllFields(); // Reset fields after saving
        showMessage("Quiz saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    private void toggleInputFields(boolean enable) {
        questionField.setEnabled(enable);
        option1Field.setEnabled(enable);
        option2Field.setEnabled(enable);
        option3Field.setEnabled(enable);
        option4Field.setEnabled(enable);
        option1Button.setEnabled(enable);
        option2Button.setEnabled(enable);
        option3Button.setEnabled(enable);
        option4Button.setEnabled(enable);
        saveQuizButton.setEnabled(enable);
        labelquestioncounter.setEnabled(enable);
        nextQuestionButton.setEnabled(enable);
        previousQuestionButton.setEnabled(enable);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            try {
                CreateQuiz createQuiz = new CreateQuiz("AdminName", "GameMasterName", "Username");
                createQuiz.setVisible(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Failed to initialize the application: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JComboBox<String> categorySelection;
    private javax.swing.JButton inputButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelquestioncounter;
    private javax.swing.JButton nextQuestionButton;
    private javax.swing.JLabel numberOfQuestionsLabel;
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
    private javax.swing.JTextField questionField;
    private javax.swing.JTextField quizTitle;
    private javax.swing.JButton saveQuizButton;
    // End of variables declaration//GEN-END:variables

}
