package componentetwitter.tweet;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author zapia
 */
public class Tweet extends javax.swing.JPanel implements Serializable {

    /**
     * Creates new form Tempo
     */
    public Tweet() {
        initComponents();
    }

 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelAvatar = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButtonTwittear = new javax.swing.JButton();
        jButtonAnnadirTweet = new javax.swing.JButton();
        jButtonSubirImg = new javax.swing.JButton();
        jButtonGif = new javax.swing.JButton();
        jButtonEncuesta = new javax.swing.JButton();
        jButtonUbicacion = new javax.swing.JButton();

        setBackground(new java.awt.Color(200, 232, 242));

        jLabelAvatar.setText("UserAvatar");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButtonTwittear.setText("Twittear");

        jButtonAnnadirTweet.setText("+");

        jButtonSubirImg.setText("img/video");

        jButtonGif.setText("Gif");

        jButtonEncuesta.setText("Encuesta");

        jButtonUbicacion.setText("Ubicación");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelAvatar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonSubirImg)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonGif)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonEncuesta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonUbicacion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                        .addComponent(jButtonAnnadirTweet)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonTwittear))
                    .addComponent(jScrollPane1))
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                    .addComponent(jLabelAvatar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSubirImg)
                    .addComponent(jButtonGif)
                    .addComponent(jButtonEncuesta)
                    .addComponent(jButtonUbicacion)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonTwittear)
                        .addComponent(jButtonAnnadirTweet)))
                .addGap(7, 7, 7))
        );
    }// </editor-fold>//GEN-END:initComponents



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnnadirTweet;
    private javax.swing.JButton jButtonEncuesta;
    private javax.swing.JButton jButtonGif;
    private javax.swing.JButton jButtonSubirImg;
    private javax.swing.JButton jButtonTwittear;
    private javax.swing.JButton jButtonUbicacion;
    private javax.swing.JLabel jLabelAvatar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
