/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mouselocation;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.util.List;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author suraj
 */
public class KeyboardListener implements KeyListener {

    private JLabel currentPos;
    private JPanel contentPane;
    private int count = 0;

    public KeyboardListener(JLabel displayPos, JPanel contentPane) {
        this.currentPos = displayPos;
        this.contentPane = contentPane;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_SPACE && count < 3) {
            contentPane.add(savedPos());
            count++;
        }

        if (e.getKeyCode() == KeyEvent.VK_ESCAPE && count > 0) {            
            contentPane.remove(count);
            contentPane.revalidate();            
            count--;  
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
    } 

    private JTextField savedPos() {
        String pos = currentPos.getText().substring(7); // remove first 8 chars "Current" from displayed current pos
       
        JTextField savePos = new JTextField((count + 1) + pos, JTextField.CENTER); // because JLabel doesn't allow selecting text

        savePos.setHorizontalAlignment(JTextField.LEFT); // http://stackoverflow.com/questions/15507639/how-do-i-center-a-jtextfield
        savePos.setBorder(BorderFactory.createEmptyBorder(0, 80, 0, 0)); // set padding of 80 on left using border. 
        savePos.setEditable(false);

        savePos.setOpaque(true); // http://stackoverflow.com/questions/2380314/how-do-i-set-a-jlabels-background-color        
        savePos.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 50));
        savePos.setForeground(new Color(255, 204, 153)); // Faint Peach. Values in rgb. 
        savePos.setBackground(Color.DARK_GRAY);

        return savePos;
    }

}
