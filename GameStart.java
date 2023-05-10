
package codenames;


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

public class GameStart implements ActionListener {
    

    JFrame frame = new JFrame();
    JButton play = new JButton("PLAY");
    JButton rules = new JButton("RULES");
    JLabel title = new JLabel();
    JLabel spy = new JLabel();
    
//    javax.swing.border.Border border = BorderFactory.createLineBorder(Color.red, 5, false);
    ImageIcon logo = new ImageIcon("codenames.jfif");
    ImageIcon spyPic = new ImageIcon("spy.jfif");
    

    
    public GameStart(){

        
        frame = new CodeNames();
        frame.setSize(700,700);
        frame.setIconImage(logo.getImage());//ADD IMAGE TO TOP LEFT CORNER
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        frame.add(rules);
        frame.add(play);
        frame.add(title);
       
        
        
        
        title.setText("CODENAMES");
        title.setVisible(true);
        title.setSize(800, 400);
        title.setFont(new Font("MV Boli",Font.BOLD,80));
        title.setHorizontalTextPosition(JLabel.CENTER);
        title.setVerticalTextPosition(JLabel.TOP);
        title.setVerticalAlignment(JLabel.TOP);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setBackground(Color.black);
        title.setOpaque(true);      // MAKES VISIBLE
//        title.setBorder(border);
        title.setForeground(Color.blue);//TEXT COLOR
        
       
        
        

        play.setBounds(200 ,175,300,75);
        play.setVisible(true);
        play.setFocusable(false);
        play.addActionListener(this);
        play.setBackground(Color.white);
        play.setText("PLAY");
        play.setFont(new Font("MV Boli",Font.BOLD,75));
        
        rules.setBounds(200 ,350,300,75);
        rules.setVisible(true);
        rules.setFocusable(false);
        rules.addActionListener(this);
        rules.setBackground(Color.white);
        rules.setText("rules");
        rules.setFont(new Font("MV Boli",Font.BOLD,75));
        
       


        
        

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==play){
            
            GameWindow window = new GameWindow();
            frame.dispose();
            
        }
        else if(e.getSource()==rules){
            
        }
            
    }
}
