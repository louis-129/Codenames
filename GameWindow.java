package codenames;


import codenames.GameStart;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javafx.scene.layout.Border;
import javax.swing.BorderFactory;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GameWindow implements ActionListener {
    
    JFrame gameWindow = new JFrame();
    JButton play = new JButton("PLAY");
    JButton back = new JButton("BACK");
    JLabel title = new JLabel();
    JLabel spy = new JLabel();
    JTextField ip = new JTextField();
    ImageIcon logo = new ImageIcon("codenames.jfif");
    String roles[] = {"SpyMaster", "Guesser"};
    JComboBox role = new JComboBox(roles);
   
    

    

    
    public GameWindow() throws UnknownHostException{
        
        gameWindow = new CodeNames();
        gameWindow.setSize(GameStart.width,GameStart.height);
        gameWindow.setResizable(true);
        gameWindow.setVisible(true);
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.setBackground(Color.black);
        gameWindow.setForeground(Color.BLACK);
        gameWindow.setIconImage(logo.getImage());
        
        gameWindow.add(back);
        gameWindow.add(role);
        gameWindow.add(play);
        gameWindow.add(ip);
        gameWindow.add(title);
        
        
        
        
       
        
        
        
        title.setText("ENTER IP ADDRESS");
        title.setVisible(true);
        title.setSize(300, 200);
        title.setFont(new Font("MV Boli",Font.BOLD,30));
        title.setHorizontalTextPosition(JLabel.CENTER);
        title.setVerticalTextPosition(JLabel.TOP);
        title.setVerticalAlignment(JLabel.TOP);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setBackground(Color.black);
        title.setOpaque(true);      // MAKES VISIBLE
        title.setForeground(Color.blue);//TEXT COLOR
        
        
       
//        ip.setSize(300,125);
        ip.setVisible(true);
        ip.setFont(new Font("MV Boli",Font.BOLD,30));
//        ip.setText("ENTER IP =  ");
//        ip.setHorizontalAlignment(JLabel.CENTER);
        ip.setBounds(150,50, 375, 50);
        ip.setEditable(true);
        
        
 
        play.setBounds(200,500,300,50);
        play.setVisible(true);
        play.setFocusable(false);
        play.addActionListener(this);
        play.setBackground(Color.white);
        play.setText("PLAY");
        play.setFont(new Font("MV Boli",Font.BOLD,50));
        
        back.setBounds(25,50,125,20);
        back.setVisible(true);
        back.setFocusable(false);
        back.addActionListener(this);
        back.setBackground(Color.white);
        back.setText("BACK");
        back.setFont(new Font("MV Boli",Font.BOLD,25));
        
        role.setBackground(Color.white);
        role.setBounds(200, 150, 300, 50);
        role.setFont(new Font("MV Boli",Font.BOLD,40));
        
        
        
        
        
        
        
        
        
        
        
       


        
        

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==play){
            System.out.println("IP ADDRESS IS " + ip.getText());
        }
        else if(e.getSource()==back){
            GameStart window = new GameStart();
            gameWindow.dispose();
        }
        
       
            
    }
}
