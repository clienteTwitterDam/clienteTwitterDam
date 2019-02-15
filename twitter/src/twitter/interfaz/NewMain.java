/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitter.interfaz;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author migue
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    JFrame frame = new JFrame("SpringLayout");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container contentPane = frame.getContentPane();

    JButton next = new JButton("Next");
    JPanel buttonPanel = new JPanel();
    buttonPanel.add(next);
    GridBagLayout layout = new GridBagLayout();
    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(layout);
    contentPane.setLayout(new BorderLayout());

    GridBagConstraints gbc = new GridBagConstraints();

    int j = 25;
    for (int i = 0; i < 50; i++) {
        JLabel label = new JLabel("Enter Name (" + i + ")");
        JTextField text = new JTextField(15);

        gbc.gridx = 0;
        gbc.gridy = i;

        mainPanel.add(label, gbc);

        gbc.gridx = 1;
        mainPanel.add(text, gbc);
    }
    contentPane.add(new JScrollPane(mainPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.CENTER);
    contentPane.add(buttonPanel, BorderLayout.SOUTH);
    frame.setSize(500, 800);
    frame.setVisible(true);
}
    
}
