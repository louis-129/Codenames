
package codenameswindow;
import java.awt.*;

public class Board {
    private final static int NUM_ROWS = 5;
    private final static int NUM_COLUMNS = 5;      
    private static Cards board[][] = new Cards[NUM_ROWS][NUM_COLUMNS];
   static Color tan = new Color(215,200,176);
     final int CARD = 2;
  
     
    public static void Reset(){
        for (int zrow=0;zrow<NUM_ROWS;zrow++){
            for (int zcol=0;zcol<NUM_COLUMNS;zcol++){
                board[zrow][zcol]=null;
            }
        }
    }
    public static void SpyReset(){
        for (int zrow=0;zrow<NUM_ROWS;zrow++){
            for (int zcol=0;zcol<NUM_COLUMNS;zcol++){
                
                
                
                if(board[zrow][zcol]==null)
                {
                    
                    if(NeutralCard.numNeutral>0){
                        int row = (int)(Math.random()*NUM_ROWS);
                        int col = (int)(Math.random()*NUM_COLUMNS);
                            if(board[row][col]==null){
                                board[row][col]= new NeutralCard();
                                NeutralCard.numNeutral--;
                            }
                            else
                            {
                                while(board[row][col]!=null){
                                     row = (int)(Math.random()*NUM_ROWS);
                                     col = (int)(Math.random()*NUM_COLUMNS);
                                }
                                board[row][col]=new NeutralCard();
                                NeutralCard.numNeutral--;
                            }
                        
                        
                        
                    }
                    if(RedCard.numRed>0){
                        int row = (int)(Math.random()*NUM_ROWS);
                        int col = (int)(Math.random()*NUM_COLUMNS);
                        if(board[row][col]==null){
                            board[row][col] = new RedCard();
                            RedCard.numRed--;

                        }   
                        else
                        {
                            while(board[row][col]!=null)
                            {
                                 row = (int)(Math.random()*NUM_ROWS);
                                 col = (int)(Math.random()*NUM_COLUMNS);
                            }
                             board[row][col] = new RedCard();    

                            RedCard.numRed--;
                        }
                        
                    }
                    if(BlueCard.numBlue>0){
                        int row = (int)(Math.random()*NUM_ROWS);
                        int col = (int)(Math.random()*NUM_COLUMNS);
                        if(board[row][col]==null){
                            board[row][col]= new BlueCard();
                             BlueCard.numBlue--;
                            }
                        else{
                            while(board[row][col]!=null){
                                 row = (int)(Math.random()*NUM_ROWS);
                                 col = (int)(Math.random()*NUM_COLUMNS);
                            }
                             board[row][col]= new BlueCard();
                             BlueCard.numBlue--;
                        }
                       
                            
                        
                    }
                    if(BlackCard.numBlack>0){
                        int row = (int)(Math.random()*NUM_ROWS);
                        int col = (int)(Math.random()*NUM_COLUMNS);
                        if(board[row][col]==null){
                            board[row][col]= new BlackCard();
                            BlackCard.numBlack--;
                        }
                        else
                        {
                            while(board[row][col]!=null){
                                 row = (int)(Math.random()*NUM_ROWS);
                                 col = (int)(Math.random()*NUM_COLUMNS);
                            }
                             board[row][col]= new BlackCard();
                            BlackCard.numBlack--;
                        }
                       
                    }
                    if(SpecialCard.numSpecial>0){
                        int row = (int)(Math.random()*NUM_ROWS);
                        int col = (int)(Math.random()*NUM_COLUMNS);
                        if(board[row][col]==null)
                        {
                            board[row][col]= new SpecialCard();
                              SpecialCard.numSpecial--;
                        }
                        else
                        {
                            while(board[row][col]!=null){
                                 row = (int)(Math.random()*NUM_ROWS);
                                 col = (int)(Math.random()*NUM_COLUMNS);
                            }
                            board[row][col]= new SpecialCard();
                            SpecialCard.numSpecial--;
                        }
                          
                        
                    }
                    
                }
                
            }
            
        }    
        
    }
    public static void GuessReset() {
//clear the board.

        
        
    
        for (int zrow=0;zrow<NUM_ROWS;zrow++){
            for (int zcol=0;zcol<NUM_COLUMNS;zcol++){
                
                
                
                if(board[zrow][zcol]==null)
                {
                    
                    if(NeutralCard.numNeutral>0){
                        int row = (int)(Math.random()*NUM_ROWS);
                        int col = (int)(Math.random()*NUM_COLUMNS);
                            if(board[row][col]==null){
                                board[row][col]= new NeutralCard(tan);
                                NeutralCard.numNeutral--;
                            }
                            else
                            {
                                while(board[row][col]!=null){
                                     row = (int)(Math.random()*NUM_ROWS);
                                     col = (int)(Math.random()*NUM_COLUMNS);
                                }
                                board[row][col]=new NeutralCard(tan);
                                NeutralCard.numNeutral--;
                            }
                        
                        
                        
                    }
                    if(RedCard.numRed>0){
                        int row = (int)(Math.random()*NUM_ROWS);
                        int col = (int)(Math.random()*NUM_COLUMNS);
                        if(board[row][col]==null){
                            board[row][col] = new RedCard(tan);
                            RedCard.numRed--;
                        }   
                        else
                        {
                            while(board[row][col]!=null)
                            {
                                 row = (int)(Math.random()*NUM_ROWS);
                                 col = (int)(Math.random()*NUM_COLUMNS);
                            }
                             board[row][col] = new RedCard(tan);    

                            RedCard.numRed--;
                        }
                        
                    }
                    if(BlueCard.numBlue>0){
                        int row = (int)(Math.random()*NUM_ROWS);
                        int col = (int)(Math.random()*NUM_COLUMNS);
                        if(board[row][col]==null){
                            board[row][col]= new BlueCard(tan);
                            BlueCard.numBlue--;
                        }
                        else{
                            while(board[row][col]!=null){
                                 row = (int)(Math.random()*NUM_ROWS);
                                 col = (int)(Math.random()*NUM_COLUMNS);
                            }
                             board[row][col]= new BlueCard(tan);
                             BlueCard.numBlue--;
                        }
                       
                            
                        
                    }
                    if(BlackCard.numBlack>0){
                        int row = (int)(Math.random()*NUM_ROWS);
                        int col = (int)(Math.random()*NUM_COLUMNS);
                        if(board[row][col]==null){
                            board[row][col]= new BlackCard(tan);
                            BlackCard.numBlack--;
                        }
                        else
                        {
                            while(board[row][col]!=null){
                                 row = (int)(Math.random()*NUM_ROWS);
                                 col = (int)(Math.random()*NUM_COLUMNS);
                            }
                             board[row][col]= new BlackCard(tan);
                            BlackCard.numBlack--;
                        }
                       
                    }
                    if(SpecialCard.numSpecial>0){
                        int row = (int)(Math.random()*NUM_ROWS);
                        int col = (int)(Math.random()*NUM_COLUMNS);
                        if(board[row][col]==null)
                        {
                            board[row][col]= new SpecialCard(tan);
                              SpecialCard.numSpecial--;
                        }
                        else
                        {
                            while(board[row][col]!=null){
                                 row = (int)(Math.random()*NUM_ROWS);
                                 col = (int)(Math.random()*NUM_COLUMNS);
                            }
                            board[row][col]= new SpecialCard(tan);
                            SpecialCard.numSpecial--;
                        }
                          
                        
                    }
                    
                }
                
            }
            
        }    
        
         

    }
    public static void Words(){
        Cards.SortWord();
        int count =0;
        for(int i =0; i<NUM_ROWS; i++){
                    
            for(int j = 0; j<NUM_COLUMNS; j++){
                
                board[i][j].word= Cards.wordBank.get(count);
                count++;
            
                
            }
        }
    }
    
    public static void SelectCard(int xpixel,int ypixel) { 
        int ydelta = Window.getHeight2()/NUM_ROWS;
        int xdelta = Window.getWidth2()/NUM_COLUMNS;
        int xpixelOffset = xpixel - Window.getX(0);
        int ypixelOffset = ypixel - Window.getY(0);
        
        if (xpixelOffset < 0 || xpixelOffset > Window.getWidth2() ||
        ypixelOffset < 0 || ypixelOffset > Window.getHeight2())
            return;
        
        int row = ypixelOffset/ydelta;
        int col = xpixelOffset/xdelta;
        
        if(board[row][col]!=null)
            board[row][col].ChangeColor();

        
    }
    
    
    public static void Draw(Graphics2D g) {
//draw grid
        int ydelta = Window.getHeight2()/NUM_ROWS;
        int xdelta = Window.getWidth2()/NUM_COLUMNS;
        
        g.setColor(Color.black);
        
        for (int zi = 1;zi<NUM_ROWS;zi++)
        {
            g.drawLine(Window.getX(0),Window.getY(zi*ydelta),
                    Window.getX(Window.getWidth2()),Window.getY(zi*ydelta));
        }
        
        for (int zi = 1;zi<NUM_COLUMNS;zi++)
        {
            g.drawLine(Window.getX(zi*xdelta),Window.getY(0),
                    Window.getX(zi*xdelta),Window.getY(Window.getHeight2()));
        }
        for (int zrow=0;zrow<NUM_ROWS;zrow++)
        {
            for (int zcol=0;zcol<NUM_COLUMNS;zcol++)        
            {
                if (board[zrow][zcol] != null)
                {
                    
                    
                g.setColor(tan);
                board[zrow][zcol].draw(g, zrow, zcol,xdelta, ydelta);
                    

                }

            }
        }        

    }
}


 
