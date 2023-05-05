
package codenames;

import java.io.*; 
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;

public class CodeNames extends JFrame implements Runnable {

    static CodeNames frame;
    final static int WINDOW_WIDTH = 1920;
    final static int WINDOW_HEIGHT = 1080; 
    
    public static void main(String[] args) {
        
        frame = new CodeNames();
        frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
    }
    public void run() {
        while (true) {
            
            repaint();
            double seconds = 0.02;    //time that 1 frame takes.
            int miliseconds = (int) (1000.0 * seconds);
            try {
                Thread.sleep(miliseconds);
            } catch (InterruptedException e) {
            }
        }
    }
}
