
package codenameswindow;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.layout.Border;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
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
    
    public static int width = 1920;
    public static int height = 1080;
//    javax.swing.border.Border border = BorderFactory.createLineBorder(Color.red, 5, false);
    ImageIcon logo = new ImageIcon("codenames.jfif");
    ImageIcon spyPic = new ImageIcon("spy.jfif");
    File file = new File("wii.wav");
    AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
    Clip clip = AudioSystem.getClip();

    
    public GameStart() throws UnsupportedAudioFileException, LineUnavailableException, IOException{
        
        
        
        clip.open(audioStream);
        clip.start();
        
        frame.setSize(width,height);
        frame.setIconImage(logo.getImage());//ADD IMAGE TO TOP LEFT CORNER
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        
        frame.add(rules);
        frame.add(play);
        frame.add(title);
       
        
        
        
        title.setText("CODENAMES");
        title.setVisible(true);
        title.setSize(1000, 500);
        title.setFont(new Font("MV Boli",Font.BOLD,80));
        title.setHorizontalTextPosition(JLabel.CENTER);
        title.setVerticalTextPosition(JLabel.TOP);
        title.setVerticalAlignment(JLabel.TOP);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setBackground(Color.black);
        title.setOpaque(true);      // MAKES VISIBLE
//        title.setBorder(border);
        title.setForeground(Color.blue);//TEXT COLOR
        
       
        
        

        play.setBounds(750,300,400,100);
      
        play.setVisible(true);
        play.setFocusable(false);
        play.addActionListener(this);
        play.setBackground(Color.white);
        play.setText("PLAY");
        play.setFont(new Font("MV Boli",Font.BOLD,75));
        
        rules.setBounds(750 ,500,400,100);
        rules.setVisible(true);
        rules.setFocusable(false);
        rules.addActionListener(this);
        rules.setBackground(Color.white);
        rules.setText("RULES");
        rules.setFont(new Font("MV Boli",Font.BOLD,75));
        
       


        
        

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==play){
           
            MainWindow lol = new MainWindow();
            try {
                lol.main();
                clip.stop();
            } catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(GameStart.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(GameStart.class.getName()).log(Level.SEVERE, null, ex);
            } catch (LineUnavailableException ex) {
                Logger.getLogger(GameStart.class.getName()).log(Level.SEVERE, null, ex);
            }
            frame.dispose();
        }
        else if(e.getSource()==rules){
            
            try {
                Rules window = new Rules();
            } catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(GameStart.class.getName()).log(Level.SEVERE, null, ex);
            } catch (LineUnavailableException ex) {
                Logger.getLogger(GameStart.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(GameStart.class.getName()).log(Level.SEVERE, null, ex);
            }
            clip.stop();
            frame.dispose();
        }
            
    }
}
