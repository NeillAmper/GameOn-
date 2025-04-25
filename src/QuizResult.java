
import java.awt.Color;
import java.awt.Font;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import javax.swing.table.DefaultTableModel;

public final class QuizResult extends javax.swing.JFrame {

    private final String playerName;
    private final String usname;
    private final String category;
    private final int maxScore;
    private final int finalScore;
    private final String quizData;
    private final JSONArray answers; // Store the answers passed from Quiz.java
    private final String quizTitle; // Quiz Title
    private final String creator; // Quiz Creator
    private final String timestamp; // Timestamp for the quiz

    public QuizResult(String playerName, String quizData, int finalScore, int maxScore, String category, String usname, JSONArray answers, String quizTitle, String creator, String timestamp) {
        // Initialize fields and UI components
        this.quizData = quizData;
        this.playerName = playerName;
        this.usname = usname;
        this.finalScore = finalScore;
        this.maxScore = maxScore;
        this.category = category;
        this.answers = answers;
        this.quizTitle = quizTitle;
        this.creator = creator;
        this.timestamp = timestamp;

        initComponents();
        displayResults(); // Populate the results table
        
        resultTable.getTableHeader().setFont(new Font("ORC A Extended", Font.BOLD, 14));
        resultTable.getTableHeader().setOpaque(false);
        resultTable.getTableHeader().setBackground(new Color(102,0,153));
        resultTable.getTableHeader().setForeground(new Color(242, 242, 242));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        scoreLabel = new javax.swing.JLabel();
        congratulatoryMessage = new javax.swing.JLabel();
        MenuButton = new javax.swing.JButton();
        LeaderboardButton = new javax.swing.JButton();
        RetryButton = new javax.swing.JButton();
        quizDetailsLabel = new javax.swing.JLabel();
        categoryUI = new javax.swing.JLabel();
        scoreUI = new javax.swing.JLabel();
        timestampLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Quiz Result BG.png"))); // NOI18N
        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("OCR A Extended", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("QUIZ DONE!");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, -1, -1));

        scoreLabel.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        scoreLabel.setForeground(new java.awt.Color(255, 255, 255));
        scoreLabel.setText("Score:");
        jPanel1.add(scoreLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, -1, 20));

        congratulatoryMessage.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        congratulatoryMessage.setForeground(new java.awt.Color(255, 255, 255));
        congratulatoryMessage.setText("Good Job!");
        jPanel1.add(congratulatoryMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, -1, -1));

        MenuButton.setBackground(new java.awt.Color(51, 255, 51));
        MenuButton.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        MenuButton.setForeground(new java.awt.Color(255, 255, 255));
        MenuButton.setText("Menu");
        MenuButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuButtonActionPerformed(evt);
            }
        });
        jPanel1.add(MenuButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 440, 130, 30));

        LeaderboardButton.setBackground(new java.awt.Color(51, 255, 51));
        LeaderboardButton.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        LeaderboardButton.setForeground(new java.awt.Color(255, 255, 255));
        LeaderboardButton.setText("Leaderboard");
        LeaderboardButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        LeaderboardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LeaderboardButtonActionPerformed(evt);
            }
        });
        jPanel1.add(LeaderboardButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 440, 140, 30));

        RetryButton.setBackground(new java.awt.Color(51, 255, 51));
        RetryButton.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        RetryButton.setForeground(new java.awt.Color(255, 255, 255));
        RetryButton.setText("Retry");
        RetryButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        RetryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RetryButtonActionPerformed(evt);
            }
        });
        jPanel1.add(RetryButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 440, 130, 30));

        quizDetailsLabel.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        quizDetailsLabel.setForeground(new java.awt.Color(255, 255, 255));
        quizDetailsLabel.setText("Quiz Details");
        quizDetailsLabel.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                quizDetailsLabelAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jPanel1.add(quizDetailsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, -1, -1));
        jPanel1.add(categoryUI, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 66, 162, 16));
        jPanel1.add(scoreUI, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 141, 16));

        timestampLabel.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        timestampLabel.setForeground(new java.awt.Color(255, 255, 255));
        timestampLabel.setText("Timestamp");
        jPanel1.add(timestampLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, -1, 20));

        resultTable.setBackground(new java.awt.Color(153, 0, 204));
        resultTable.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        resultTable.setForeground(new java.awt.Color(255, 255, 255));
        resultTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Question", "Selected Answer", "Correct Answer", "Result"
            }
        ));
        jScrollPane1.setViewportView(resultTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 480, 250));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Quiz Result BG.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 560));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void RetryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RetryButtonActionPerformed
        this.setVisible(false);
        new QuizSelection(playerName, "Player", "Player", usname).setVisible(true);
    }//GEN-LAST:event_RetryButtonActionPerformed

    private void LeaderboardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LeaderboardButtonActionPerformed
        this.setVisible(false);
        new Leaderboard(playerName, quizData, "Player", "GameMaster").setVisible(true);
    }//GEN-LAST:event_LeaderboardButtonActionPerformed

    private void MenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuButtonActionPerformed
        Player p = new Player(playerName, "Player", 1, 2, "Player", usname);
        p.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_MenuButtonActionPerformed

    private void quizDetailsLabelAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_quizDetailsLabelAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_quizDetailsLabelAncestorAdded

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            String playerName = "JohnDoe";
            String quizData = "Science";
            int finalScore = 2;
            int maxScore = 3;
            String category = "Science";
            String usname = "testUser";
            String quizTitle = "General Science Quiz";
            String creator = "QuizMaster";
            String timestamp = "2025-04-19, 07:25 PM";

            JSONArray answers = new JSONArray();
            JSONObject answer1 = new JSONObject();
            answer1.put("question", "What is the capital of France?");
            answer1.put("selectedAnswer", "Paris");
            answer1.put("correctAnswer", "Paris");
            answer1.put("result", "correct");
            answers.add(answer1);

            JSONObject answer2 = new JSONObject();
            answer2.put("question", "What is 2 + 2?");
            answer2.put("selectedAnswer", "4");
            answer2.put("correctAnswer", "4");
            answer2.put("result", "correct");
            answers.add(answer2);

            JSONObject answer3 = new JSONObject();
            answer3.put("question", "What is the boiling point of water?");
            answer3.put("selectedAnswer", "80 degrees");
            answer3.put("correctAnswer", "100 degrees");
            answer3.put("result", "incorrect");
            answers.add(answer3);

            new QuizResult(playerName, quizData, finalScore, maxScore, category, usname, answers, quizTitle, creator, timestamp).setVisible(true);
        });
    }

    private void displayResults() {
        // Set dynamic labels
        quizDetailsLabel.setText("Title: " + quizTitle + " | Creator: " + creator + " | Category: " + category);
        scoreLabel.setText("Score: " + finalScore + " / " + maxScore); // Display total score dynamically
        timestampLabel.setText("Timestamp: " + (timestamp != null ? timestamp : "N/A")); // Display timestamp dynamically

        // Populate the resultTable
        DefaultTableModel model = (DefaultTableModel) resultTable.getModel();
        model.setRowCount(0); // Clear existing rows

        for (Object answerObj : answers) {
            JSONObject answer = (JSONObject) answerObj;
            String question = (String) answer.get("question");
            String selectedAnswer = (String) answer.get("selectedAnswer");
            String correctAnswer = (String) answer.get("correctAnswer");
            String result = (String) answer.get("result");

            model.addRow(new Object[]{question, selectedAnswer, correctAnswer, result});
        }

        // Set dynamic congratulatory message
        String message = getCongratulatoryMessage(finalScore, maxScore);
        congratulatoryMessage.setText(message);
    }

    private String getCongratulatoryMessage(int score, int maxScore) {
        double percentage = ((double) score / maxScore) * 100;

        if (percentage <= 20) {
            return "Better luck next time! Keep learning and improving.";
        } else if (percentage <= 50) {
            return "Good effort! You're making progress.";
        } else if (percentage <= 80) {
            return "Great job! You're doing really well.";
        } else {
            return "Outstanding! You're a true quiz genius!";
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LeaderboardButton;
    private javax.swing.JButton MenuButton;
    private javax.swing.JButton RetryButton;
    private javax.swing.JLabel categoryUI;
    private javax.swing.JLabel congratulatoryMessage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel quizDetailsLabel;
    private javax.swing.JTable resultTable;
    private javax.swing.JLabel scoreLabel;
    private javax.swing.JLabel scoreUI;
    private javax.swing.JLabel timestampLabel;
    // End of variables declaration//GEN-END:variables
}
