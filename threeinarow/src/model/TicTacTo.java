package model;
import view.* ;
import javax.naming.ldap.LdapContext;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import view.RowGameGUI;


public class TicTacTo extends RowGameModel{
    
    public TicTacTo()
    { 
        super(); 
    }




    public void move(JButton block) {

        if(get_MovesLeft()>0)
        { 

            set_MovesLeft(--movesLeft);
            int  x_index = get_button_index(block)[0]; 
            int  y_index = get_button_index(block)[1];
            this.blocksData[x_index][y_index].setContents(get_player_symbol()); 
            this.blocksData[x_index][y_index].setIsLegalMove(false);
            if (x_index>0)   //for gravity condition 
            {
                this.blocksData[x_index-1][y_index].setIsLegalMove(true);
            }
            

            if (isWinner(block)) 
                {
                    this.setFinalResult("Player " + get_Player_id()+ " " + "wins!");
                    endGame();
                }
            else if(get_MovesLeft()==0)
                { 
                    this.setFinalResult(GAME_END_NOWINNER);
                }
            else
                {  
                    if (player1.equals(get_Player_id()))
                        set_Player_id(player2); 
                    else
                        set_Player_id(player1);
                    
                    
                }
                gameView.update(this);

         }
        
     }

     public void resetGame() 
     {
         for(int row = 0;row<row_count;row++) 
         {
             for(int column = 0;column<col_count;column++) 
             {
                     get_blocksData()[row][column].reset();
             // Enable the bottom row
                 get_blocksData()[row][column].setIsLegalMove(true);
             }
         }
         player = player1;
         movesLeft = row_count*col_count;
         setFinalResult(null);
         gameView.update(this);
     }




}





