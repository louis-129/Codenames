/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codenames2;

import java.io.*; 
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;

public class Codenames2 extends JFrame implements Runnable {

    static final int numRows = 5;
    static final int numColumns = 5;
    static final int XBORDER = 40;
    static final int YBORDER = 60;
    static final int YTITLE = 30;
    static final int WINDOW_BORDER = 8;
    static final int WINDOW_WIDTH = 10*(WINDOW_BORDER + XBORDER) + numColumns*30;
    static final int WINDOW_HEIGHT = YTITLE + WINDOW_BORDER + 8 * YBORDER + numRows*30;
    
    boolean animateFirstTime = true;
    int xsize = -1;
    int ysize = -1;
    Image image;
    Graphics2D g;

    boolean secretActive;
    final int PATH = 0;
    final int WALL = 1;
    final int SECR = 2;

    
    int board[][] = 
    {{PATH,PATH,PATH,PATH,PATH,},
     {PATH,PATH,PATH,PATH,PATH,},        
     {PATH,PATH,PATH,PATH,PATH,},        
     {PATH,PATH,PATH,PATH,PATH,},        
     {PATH,PATH,PATH,PATH,PATH,},        
   
    };
    
        
//Variable for player.
    Character player;
//Variable for coins.
    Coin coins[] = new Coin[Coin.numCoins];
    Coin2 coins2[] = new Coin2[Coin2.numCoins];
//Variable for npcs.
   // Character npcs[] = new Character[Character.numNpcs];
    
    boolean gameOver;
    int timeCount;
    
    static Codenames2 frame;
    public static void main(String[] args) {
        frame = new Codenames2();
        frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public Codenames2() {
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (e.BUTTON1 == e.getButton()) {
                    //left button

// location of the cursor.
                    int xpos = e.getX();
                    int ypos = e.getY();

                }
                if (e.BUTTON3 == e.getButton()) {
                    //right button
                    reset();
                }
                repaint();
            }
        });

    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseDragged(MouseEvent e) {
        repaint();
      }
    });

    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseMoved(MouseEvent e) {

        repaint();
      }
    });

        addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent e) {

                if (gameOver)
                    return;
                
//Call methods to try and move the player.                
                if (e.VK_UP == e.getKeyCode()) {
             //       player.DirUp();
                } else if (e.VK_DOWN == e.getKeyCode()) {
               //     player.DirDown();
                } else if (e.VK_LEFT == e.getKeyCode()) {
             //       player.DirLeft();                    
                } else if (e.VK_RIGHT == e.getKeyCode()) {
             //       player.DirRight();
                }
                
                repaint();
            }
        });
        init();
        start();
    }
    Thread relaxer;
////////////////////////////////////////////////////////////////////////////
    public void init() {
        requestFocus();
    }
////////////////////////////////////////////////////////////////////////////
    public void destroy() {
    }

 

////////////////////////////////////////////////////////////////////////////
    public void paint(Graphics gOld) {
        if (image == null || xsize != getSize().width || ysize != getSize().height) {
            xsize = getSize().width;
            ysize = getSize().height;
            image = createImage(xsize, ysize);
            g = (Graphics2D) image.getGraphics();
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
        }
//fill background
        g.setColor(Color.cyan);
        g.fillRect(0, 0, xsize, ysize);

        int x[] = {getX(0), getX(getWidth2()), getX(getWidth2()), getX(0), getX(0)};
        int y[] = {getY(0), getY(0), getY(getHeight2()), getY(getHeight2()), getY(0)};
//fill border
        g.setColor(Color.white);
        g.fillPolygon(x, y, 4);
// draw border
        g.setColor(Color.red);
        g.drawPolyline(x, y, 5);

        if (animateFirstTime) {
            gOld.drawImage(image, 0, 0, null);
            return;
        }

        
        g.setColor(Color.red);
//horizontal lines
        for (int zi=1;zi<numRows;zi++)
        {
            g.drawLine(getX(0) ,getY(0)+zi*getHeight2()/numRows ,
            getX(getWidth2()) ,getY(0)+zi*getHeight2()/numRows );
        }
//vertical lines
        for (int zi=1;zi<numColumns;zi++)
        {
            g.drawLine(getX(0)+zi*getWidth2()/numColumns ,getY(0) ,
            getX(0)+zi*getWidth2()/numColumns,getY(getHeight2())  );
        }
        
//Display the objects of the board
        for (int zrow=0;zrow<numRows;zrow++)
        {
            for (int zcolumn=0;zcolumn<numColumns;zcolumn++)
            {
//Draw the square gray if the square location is a WALL.                 
                if (board[zrow][zcolumn] == WALL )
                {
                    g.setColor(Color.magenta);
                    g.fillRect(getX(0)+zcolumn*getWidth2()/numColumns,
                    getY(0)+zrow*getHeight2()/numRows,
                    getWidth2()/numColumns,
                    getHeight2()/numRows);
                }  
//Draw the square gray if the square location is SECR and the secret passage is not active.                
              //  else if (board[zrow][zcolumn] == SECR && !secretActive) 
              //  {
                //    g.setColor(Color.gray);
                //    g.fillRect(getX(0)+zcolumn*getWidth2()/numColumns,
               //     getY(0)+zrow*getHeight2()/numRows,
                //    getWidth2()/numColumns,
                //    getHeight2()/numRows);  
               // }
//Draw the square magenta if the square location is SECR and the secret passage is active.                
              //  else if (board[zrow][zcolumn] == SECR && secretActive)
               // {
              //      g.setColor(Color.magenta);
               //     g.fillRect(getX(0)+zcolumn*getWidth2()/numColumns,
              //      getY(0)+zrow*getHeight2()/numRows,
               //     getWidth2()/numColumns,
               //     getHeight2()/numRows);  
               //}                    
            }
        }            

//Draw the npcs.
      //  for (int i=0;i<Character.numNpcs;i++)
      //      npcs[i].Draw(g, frame);
//Draw the coins.
for (int zrow=0;zrow<numRows;zrow++)
        {
            for (int zcolumn=0;zcolumn<numColumns;zcolumn++)
            {
        for (int i=0;i<Coin.numCoins;i++)
            coins[i].Draw(g, frame);
         for (int i=0;i<Coin2.numCoins;i++)
            coins2[i].Draw(g, frame);
            }
//Draw the player
      //  player.Draw(g, frame);
                       
        if (gameOver)
        {
            g.setColor(Color.black);
            g.setFont (new Font ("Arial",Font.PLAIN, 80));  
            g.drawString("Game Over",100,400);
        }
        
        gOld.drawImage(image, 0, 0, null);
        }
    }
////////////////////////////////////////////////////////////////////////////
// needed for     implement runnable
    public void run() {
        while (true) {
            animate();
            repaint();
            
            
            double seconds = .05;    //time that 1 frame takes.
            int miliseconds = (int) (1000.0 * seconds);
            try {
                Thread.sleep(miliseconds);
            } catch (InterruptedException e) {
            }
        }
    }
/////////////////////////////////////////////////////////////////////////
    public void reset() {
        timeCount = 0;
        gameOver = false;
        secretActive = false;
//Initialize the player variables.        
      //  player = new Character(frame,true);
      //  player.setColor(Color.green);
      //  player.setName("Player");
//Initialize the coin variables.
        for (int i=0;i<Coin.numCoins;i++)
            coins[i] = new Coin(frame);
         for (int i=0;i<Coin2.numCoins;i++)
            coins2[i] = new Coin2(frame);
//Initialize the npc variables.        
      //  for (int i=0;i<Character.numNpcs;i++)
      //      npcs[i] = new Character(frame,false);
      //  npcs[0].setColor(Color.red);
      //  npcs[0].setName("Freddy");
      //  npcs[0].setSpeed(2);
      //  npcs[1].setColor(Color.blue);
      //  npcs[1].setName("Kiki");
      //  npcs[1].setSpeed(8);
       // npcs[2].setColor(Color.cyan);
       // npcs[2].setName("Tino");
        //npcs[2].setSpeed(12);
        //npcs[3].setColor(Color.pink);
       // npcs[3].setName("Rocky");
       // npcs[3].setSpeed(4);
    }
/////////////////////////////////////////////////////////////////////////
    public void animate() {
        if (animateFirstTime) {
            animateFirstTime = false;
            if (xsize != getSize().width || ysize != getSize().height) {
                xsize = getSize().width;
                ysize = getSize().height;
            }
            reset();
        }

      //  if (gameOver)
      //      return;
//Game over if an npc runs into the player.        
      //  for (int i=0;i<Character.numNpcs;i++)
     //   {
    //        if (npcs[i].Collide(player.row,player.column))
     //           gameOver = true;
     //   }

//Move the npcs.
     //   for (int i=0;i<Character.numNpcs;i++)
  //          npcs[i].Move(frame,timeCount);
//Move the player.        
  //      player.Move(frame,timeCount);
//Determine if the player has collected a coin.
     //   for (int i=0;i<Coin.numCoins;i++)
     //   {
       //     int value = coins[i].Collect(player.row,player.column);
       //     player.value += value;
       // }        
//Show the secret passage if the player has an odd number of coins.            
      //  if (player.value % 2 == 1)
      //      secretActive = true;          
    //    else
         //   secretActive = false;

//Determine if an npc has collected a coin.       
     //  for (int i=0;i<Coin.numCoins;i++)
      //  {
         //   for (int j=0;j<Character.numNpcs;j++)
         //   {
         //       int value = coins[i].Collect(npcs[j].row,npcs[j].column);
          //      npcs[j].value += value;
          //  }
       // }        
        
        timeCount++;
    }
    
////////////////////////////////////////////////////////////////////////////
    public void start() {
        if (relaxer == null) {
            relaxer = new Thread(this);
            relaxer.start();
        }
    }
////////////////////////////////////////////////////////////////////////////
    public void stop() {
        if (relaxer.isAlive()) {
            relaxer.stop();
        }
        relaxer = null;
    }


/////////////////////////////////////////////////////////////////////////
    public int getX(int x) {
        return (x + XBORDER + WINDOW_BORDER);
    }

    public int getY(int y) {
        return (y + YBORDER + YTITLE );
    }

    public int getYNormal(int y) {
        return (-y + YBORDER + YTITLE + getHeight2());
    }
    
    public int getWidth2() {
        return (xsize - 2 * (XBORDER + WINDOW_BORDER));
    }

    public int getHeight2() {
        return (ysize - 2 * YBORDER - WINDOW_BORDER - YTITLE);
    }
}

//Coin class========================================================
class Coin {
    public static int numCoins = 10;
    public int row;
    public int column;
    public int value;
  //  public boolean active;

    Coin(Codenames2 frame)
    {
//Give the coin a random value from 2 to 6.        
        //value = (int)(Math.random()*5)+2;
    //    active = true;
//Position the coin on a random path location.        
        do {
            row = (int)(Math.random()*Codenames2.numRows);
            column = (int)(Math.random()*Codenames2.numColumns);
        } while (frame.board[row][column] != frame.PATH);         
    }
    
    public int Collect(int objectRow,int objectColumn)
    {
//Don't collect a non active coin.
     //   if (!active)
       //     return 0;

//If the character collects this coin.
        if (row == objectRow && column == objectColumn)
        {
       //     active = false;   // make the coin go away.
            return value;      //return the value of the coin.
        }
        return 0;   //the coin is not collected.
    }
    
    public void Draw(Graphics2D g,Codenames2 frame)
    {
//Don't draw non active coins.
        //if (!active)
          //  return;
        
        g.setColor(Color.red);
        g.fillRect(frame.getX(0)+column*frame.getWidth2()/Codenames2.numColumns,
        frame.getY(0)+row*frame.getHeight2()/Codenames2.numRows,
        frame.getWidth2()/Codenames2.numColumns,
        frame.getHeight2()/Codenames2.numRows);
        g.setColor(Color.black);
        g.drawRect(frame.getX(0)+column*frame.getWidth2()/Codenames2.numColumns,
        frame.getY(0)+row*frame.getHeight2()/Codenames2.numRows,
        frame.getWidth2()/Codenames2.numColumns,
        frame.getHeight2()/Codenames2.numRows);
        
        g.setColor(Color.black);
        g.setFont (new Font ("Arial",Font.PLAIN, 20));             
        g.drawString("" + value, 
        frame.getX(0)+column*frame.getWidth2()/Codenames2.numColumns+10,
        frame.getY(0)+row*frame.getHeight2()/Codenames2.numRows+20);
        
    }
}
class Coin2 {
    public static int numCoins = 9;
    public int row;
    public int column;
    public int value;
  //  public boolean active;

    Coin2(Codenames2 frame)
    {
//Give the coin a random value from 2 to 6.        
        //value = (int)(Math.random()*5)+2;
    //    active = true;
//Position the coin on a random path location.        
        do {
            row = (int)(Math.random()*Codenames2.numRows);
            column = (int)(Math.random()*Codenames2.numColumns);
        } while (frame.board[row][column] != frame.PATH);         
    }
    
    public int Collect(int objectRow,int objectColumn)
    {
//Don't collect a non active coin.
     //   if (!active)
       //     return 0;

//If the character collects this coin.
        if (row == objectRow && column == objectColumn)
        {
       //     active = false;   // make the coin go away.
            return value;      //return the value of the coin.
        }
        return 0;   //the coin is not collected.
    }
    
    public void Draw(Graphics2D g,Codenames2 frame)
    {
//Don't draw non active coins.
        //if (!active)
          //  return;
        
        g.setColor(Color.blue);
        g.fillRect(frame.getX(0)+column*frame.getWidth2()/Codenames2.numColumns,
        frame.getY(0)+row*frame.getHeight2()/Codenames2.numRows,
        frame.getWidth2()/Codenames2.numColumns,
        frame.getHeight2()/Codenames2.numRows);
        g.setColor(Color.black);
        g.drawRect(frame.getX(0)+column*frame.getWidth2()/Codenames2.numColumns,
        frame.getY(0)+row*frame.getHeight2()/Codenames2.numRows,
        frame.getWidth2()/Codenames2.numColumns,
        frame.getHeight2()/Codenames2.numRows);
        
        g.setColor(Color.black);
        g.setFont (new Font ("Arial",Font.PLAIN, 20));             
        g.drawString("" + value, 
        frame.getX(0)+column*frame.getWidth2()/Codenames2.numColumns+10,
        frame.getY(0)+row*frame.getHeight2()/Codenames2.numRows+20);
        
    }
}



 
