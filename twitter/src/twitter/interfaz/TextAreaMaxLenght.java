/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitter.interfaz;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextArea;

/**
 *
 * @author migue
 */
public class TextAreaMaxLenght extends JTextArea{
    
    public TextAreaMaxLenght(){
        this.setLineWrap(true);
        this.setWrapStyleWord(true);
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                
                char keyChar = e.getKeyChar();
                String valueOfChar = String.valueOf(keyChar);
                comprobarLongitud();
            }

            @Override
            public void keyPressed(KeyEvent e) {;
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
    }
    
    private int lontigudMax=280;
    
    public int getLongitudMax() {
        return lontigudMax;
    }

    public void setLongitudMax(int longitudMax) {
        this.lontigudMax = longitudMax;
    }
    
    private void comprobarLongitud() {
        if (getText().length() >=lontigudMax) {
            this.setEnabled(false);
        }
    }
    
    
}
