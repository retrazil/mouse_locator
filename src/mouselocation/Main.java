/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mouselocation;

import java.awt.MouseInfo;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.SwingUtilities;

/**
 *
 * @author suraj
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(new MouseLocator());
        
    }

}
