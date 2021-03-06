/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitter.interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import logica.GestionTwitter;
import mdlaf.MaterialLookAndFeel;
import mdlaf.utils.MaterialColors;
import twitter4j.Twitter;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.help.HelpSetException;

/**
 *
 * @author zapia
 */
public class Inicio extends javax.swing.JFrame {
    
    /**
     * Creates new form Inicio
     */
    public Inicio() {
        initComponents();
        ImageIcon background = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/twitter/img/pajaro.jpg")));
        Image imgBackground = background.getImage();
        Image imgBackgroundEscalado = imgBackground.getScaledInstance(jLabelBackground.getWidth(), jLabelBackground.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon backgroundFinal = new ImageIcon(imgBackgroundEscalado);
        jLabelBackground.setIcon(backgroundFinal);
        setResizable(false);
        setLocationRelativeTo(null);
        try {
            File fichero = new File("help/help_set.hs");
            URL hsURL = fichero.toURI().toURL();
        // Crea el HelpSet y el HelpBroker
            HelpSet helpset = new HelpSet(getClass().getClassLoader(), hsURL);
            HelpBroker hb = helpset.createHelpBroker();
        // Pone ayuda a item de menu al pulsarlo.
            hb.enableHelpKey(this.getContentPane(), "ventana_principal", helpset);
        } catch (MalformedURLException | HelpSetException ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*try {
            UIManager.setLookAndFeel(new MaterialLookAndFeel());
            UIManager.put("Button.background", MaterialColors.BLUE_600);
            UIManager.put("Button.foreground", MaterialColors.WHITE);
            SwingUtilities.updateComponentTreeUI(this);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }*/
            
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImagePanel = new javax.swing.JPanel();
        jLabelSigueInteresa = new javax.swing.JLabel();
        jLabelUnete = new javax.swing.JLabel();
        jLabelEnterate = new javax.swing.JLabel();
        jLabelBackground = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButtonLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ImagePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelSigueInteresa.setFont(new java.awt.Font("HelveticaNeueLT Pro 55 Roman", 0, 11)); // NOI18N
        jLabelSigueInteresa.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSigueInteresa.setText("Sigue lo que te interesa");
        ImagePanel.add(jLabelSigueInteresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, -1, -1));

        jLabelUnete.setFont(new java.awt.Font("HelveticaNeueLT Pro 55 Roman", 0, 11)); // NOI18N
        jLabelUnete.setForeground(new java.awt.Color(255, 255, 255));
        jLabelUnete.setText("Únete a la conversación.");
        ImagePanel.add(jLabelUnete, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, -1, -1));

        jLabelEnterate.setFont(new java.awt.Font("HelveticaNeueLT Pro 55 Roman", 0, 11)); // NOI18N
        jLabelEnterate.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEnterate.setText("Entérate de lo que está hablando la gente. ");
        ImagePanel.add(jLabelEnterate, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, -1, -1));
        ImagePanel.add(jLabelBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 460, 580));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("HelveticaNeueLT Pro 55 Roman", 0, 18)); // NOI18N
        jLabel1.setText("Descubre lo que está pasando en el mundo en este momento");

        jButtonLogin.setText("Iniciar Sesión");
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(48, 48, 48))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(255, 255, 255)
                .addComponent(jButtonLogin)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(247, 247, 247)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addComponent(jButtonLogin)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ImagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ImagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginActionPerformed
        Twitter connection = GestionTwitter.connectToTwitter();
        PantallaPrincipal pantalla= new PantallaPrincipal(this, rootPaneCheckingEnabled, connection);
        pantalla.setVisible(true);
    }//GEN-LAST:event_jButtonLoginActionPerformed

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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ImagePanel;
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelBackground;
    private javax.swing.JLabel jLabelEnterate;
    private javax.swing.JLabel jLabelSigueInteresa;
    private javax.swing.JLabel jLabelUnete;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
