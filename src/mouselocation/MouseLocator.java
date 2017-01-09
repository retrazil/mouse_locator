/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mouselocation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.lang.reflect.Executable;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.WindowConstants;

/**
 *
 * @author suraj
 */
public class MouseLocator extends Thread implements ActionListener {

    private JFrame frame;
    private JLabel currentPos;
    private Point p;
    private Timer fireMouseLocation;

    public MouseLocator() {
        fireMouseLocation = new Timer(100, this);
        fireMouseLocation.start();
    }

    @Override
    public void run() {
        frame = new JFrame();
        frame.setPreferredSize(new Dimension(700, 500));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        frame.setLayout(new GridLayout(0, 1));

        p = MouseInfo.getPointerInfo().getLocation();
        
        String cordinates = "Current: (" + p.getX() + ", " + p.getY() + ")";

        currentPos = new JLabel(cordinates, JLabel.CENTER); // to center the label on window
        currentPos.setOpaque(true); // http://stackoverflow.com/questions/2380314/how-do-i-set-a-jlabels-background-color
        currentPos.setBackground(new Color(255, 204, 153)); // Faint Peach. Values in rgb.
        currentPos.setFont(new Font(null, Font.BOLD, 45));
        currentPos.setForeground(Color.DARK_GRAY);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));

        panel.add(currentPos);
        frame.getContentPane().add(panel);
        frame.addKeyListener(new KeyboardListener(currentPos, panel));
        frame.pack();
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        p = MouseInfo.getPointerInfo().getLocation();
        String cordinates = "Current: (" + p.getX() + ", " + p.getY() + ")";
        currentPos.setText(cordinates);
    }
}
