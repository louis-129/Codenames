
package codenames;


import java.io.*; 
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;

public class CodeNames extends JFrame implements Runnable {

    
    
    public static void main(String[] args) {
        
        GameStart startWindow = new GameStart();
        
        
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
