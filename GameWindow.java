package codenames;


import codenames.GameStart;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.scene.layout.Border;
import javax.swing.BorderFactory;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GameWindow implements ActionListener {
    
    JFrame gameWindow = new JFrame();
    
   
    

    

    
    public GameWindow(){
        
        gameWindow = new CodeNames();
        gameWindow.setSize(GameStart.width,GameStart.height);
        gameWindow.setResizable(true);
        gameWindow.setVisible(true);
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.setBackground(Color.black);
        gameWindow.setForeground(Color.BLACK);
        
        
        
       


        
        

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
       
            
    }
}
