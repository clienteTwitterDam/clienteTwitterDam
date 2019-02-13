package componentetwitter.tweet;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Tweet extends javax.swing.JPanel implements Serializable {

    private int limiteCaracteres;

    public Tweet() {
        initComponents();
        //cambiarImagenUser("");
        this.limiteCaracteres = 280;
        jTextAreaTweet.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (jTextAreaTweet.getText().length() >= limiteCaracteres) {
                    jTextAreaTweet.setEditable(false);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {

            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });

        jTextAreaTweet.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == 8) {
                    if (jTextAreaTweet.getText().length() > limiteCaracteres) {
                        jTextAreaTweet.setText(jTextAreaTweet.getText().substring(0, jTextAreaTweet.getText().length() - 1));
                        jButtonTwittear.setEnabled(false);
                    } else {
                        jTextAreaTweet.setEditable(true);
                        jButtonTwittear.setEnabled(true);
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
    }

    public int getLimiteCaracteres() {
        return limiteCaracteres;
    }

    public void setLimiteCaracteres(int limiteCaracteres) {
        this.limiteCaracteres = limiteCaracteres;
    }
/*
    public void cambiarImagenUser(String rutaAvatar) {
        ImageIcon avatar = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../img/Avatar.png")));
        Image imgAvatar = avatar.getImage();
        Image imgAvatarEscalado = imgAvatar.getScaledInstance(jLabelAvatar.getWidth(), jLabelAvatar.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon avatarFinal = new ImageIcon(imgAvatarEscalado);
        jLabelAvatar.setIcon(avatarFinal);
    }
*/
    
    
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
        jTextAreaTweet = new javax.swing.JTextArea();
        jButtonTwittear = new javax.swing.JButton();
        jButtonAnnadirTweet = new javax.swing.JButton();
        jButtonSubirImg = new javax.swing.JButton();
        jButtonGif = new javax.swing.JButton();
        jButtonEncuesta = new javax.swing.JButton();
        jButtonUbicacion = new javax.swing.JButton();

        setBackground(new java.awt.Color(200, 232, 242));

        jLabelAvatar.setText("UserAvatar");

        jTextAreaTweet.setColumns(20);
        jTextAreaTweet.setLineWrap(true);
        jTextAreaTweet.setRows(5);
        jScrollPane1.setViewportView(jTextAreaTweet);

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonTwittear)
                        .addComponent(jButtonAnnadirTweet))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonSubirImg)
                        .addComponent(jButtonGif)
                        .addComponent(jButtonEncuesta)
                        .addComponent(jButtonUbicacion)))
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
    private javax.swing.JTextArea jTextAreaTweet;
    // End of variables declaration//GEN-END:variables
}
