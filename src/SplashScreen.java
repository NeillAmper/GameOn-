
import java.awt.Color;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SplashScreen extends javax.swing.JFrame {

    public SplashScreen() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();
        LoadingValue = new javax.swing.JLabel();
        LoadingMsg = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("OCR A Extended", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("WELCOME TO");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, -1, -1));

        progressBar.setBackground(new java.awt.Color(102, 153, 255));
        progressBar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        getContentPane().add(progressBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 370, 490, 30));

        LoadingValue.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        LoadingValue.setForeground(new java.awt.Color(255, 255, 255));
        LoadingValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LoadingValue.setText("0%");
        getContentPane().add(LoadingValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 350, 40, 20));

        LoadingMsg.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        LoadingMsg.setForeground(new java.awt.Color(255, 255, 255));
        LoadingMsg.setText("Loading...");
        getContentPane().add(LoadingMsg, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, -1, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/For real this time, new splash screen Bg.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 550));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        SplashScreen sp = new SplashScreen();
        sp.setVisible(true);

        // Use a Timer to update the progress bar and loading messages
        Timer timer = new Timer(100, new ActionListener() {
            int progress = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                progress++;
                sp.LoadingValue.setText(progress + "%");

                if (progress == 20) {
                    sp.LoadingMsg.setText("Loading Assets");
                }
                if (progress == 50) {
                    sp.LoadingMsg.setText("Preparing stuff");
                }
                if (progress == 80) {
                    sp.LoadingMsg.setText("Almost there...");
                }

                sp.progressBar.setValue(progress);

                // When progress reaches 100%, stop the timer and transition to the next screen
                if (progress >= 100) {
                    ((Timer) e.getSource()).stop();
                    sp.dispose();
                    new SignIn("Test", "Tests").setVisible(true);
                }
            }
        });

        timer.start();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LoadingMsg;
    private javax.swing.JLabel LoadingValue;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JProgressBar progressBar;
    // End of variables declaration//GEN-END:variables
}
