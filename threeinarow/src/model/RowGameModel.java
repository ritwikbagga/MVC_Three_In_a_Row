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

public class RowGameModel  implements RowGameRulesStrategy
{
    protected static final String GAME_END_NOWINNER = "Game ends in a draw";
    public static final String player1 = "1";
    public static final String player2 = "2";
    protected RowBlockModel[][] blocksData = new RowBlockModel[10][10];
    protected  RowGameGUI gameView; 
    protected String player ; 
    protected int movesLeft; 
    protected String finalResult = null;
    protected int row_count ; 
    protected int col_count; 
    

    

    public RowGameModel() {
    this.row_count=3; 
    this.col_count=3; 
    this.movesLeft = row_count*col_count ;
    this.player = player1;
    this.gameView = new RowGameGUI(this); 
	for (int row = 0; row < 3; row++) {
	    for (int col = 0; col < 3; col++) {
		blocksData[row][col] = new RowBlockModel(this);
	    } // end for col
    } // end for row
    resetGame(); 
    }
    public RowGameModel(int r, int c) {
        this.row_count = r; 
        this.col_count = c; 
        this.movesLeft = r*c ;
        this.player = player1;
        this.blocksData = new RowBlockModel[r][c] ; 
        this.gameView = new RowGameGUI(this); 
        for (int row = 0; row < row_count; row++) {
            for (int col = 0; col < col_count; col++) {
            blocksData[row][col] = new RowBlockModel(this);
            } // end for col
        } // end for row
        resetGame(); 
        }
    public void add_view(RowGameGUI v){ 
        this.gameView = new RowGameGUI(this); 
    }

    public String get_Player_id(){
        return this.player; 
    }

    public int get_rowCount(){
        return row_count; 
    }

    public int get_colCount(){
        return col_count; 
    }


    public String get_player_symbol(){ //return the "X" or "O" depending on Player "1" or player "2"
        String symbol2 = "O"; 
        if(player1.equals(get_Player_id()))
        {   String symbol = "X"; 
            return symbol; 
        }
        return symbol2; 
    }

    public int get_MovesLeft(){ 
        return movesLeft; 
    }

    public void set_MovesLeft(int movesLeft){ 
        this.movesLeft = movesLeft; 
    }

    public void set_Player_id(String s){ 
        this.player = s;
    }

    public String getFinalResult() {
	return this.finalResult;
    }

  

    public void setFinalResult(String finalResult) {
	this.finalResult = finalResult;
    }
    public RowBlockModel[][] get_blocksData(){ 
        return this.blocksData ; 
    }

    public void startUp() {
        getView().get_gui().setVisible(true);
        }

    
     public RowGameGUI getView() {
	    return this.gameView;
     }

     

     public int[] get_button_index(JButton block)
     {
        int x=0; 
        int y =0; 
        int[] coordinates= new int[2] ; 
        int board_length = gameView.get_GameBoardView().get_blocks().length;
        for(int i = 0 ; i<row_count; i++)
        {   
            for(int j  =0; j<col_count ; j++)
            { 
                if( block==gameView.get_GameBoardView().get_blocks()[i][j])
                {
                    x = i; 
                    y = j ; 
                    break; 
                }
              
            }
        }

        coordinates[0] =x;
        coordinates[1]= y ; 
        return coordinates; 
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




        //To check for winner
    public boolean isWinner(JButton block)
    {
        int row_count = 0;
        int col_count = 0 ;
        int RDiag_count = 0;
        int LDiag_count = 0 ;
        String current_player_symbol = get_player_symbol(); 
        int board_length = gameView.get_GameBoardView().get_blocks().length; 
        int pos_x = get_button_index(block)[0] ; 
        int pos_y = get_button_index(block)[1]; 
        for (int i = 0; i<board_length; i++)
         { 
             if(this.blocksData[pos_x][i].getContents().equals(current_player_symbol))
                row_count++; 
            if(this.blocksData[i][pos_y].getContents().equals(current_player_symbol))
                col_count++;
            if(this.blocksData[i][i].getContents().equals(current_player_symbol))
            RDiag_count++;
            if(this.blocksData[board_length-1-i][i].getContents().equals(current_player_symbol))
               LDiag_count++;
         }

         if(row_count==board_length || col_count==board_length || RDiag_count==board_length || LDiag_count==board_length)
            return true;
        return false;
    }




        /**
     * Ends the game disallowing further player turns.
     */


    public void endGame() {
        for(int row = 0;row<row_count;row++) {
            for(int column = 0;column<col_count;column++) {
            this.blocksData[row][column].setIsLegalMove(false);
            }
        }
    
        gameView.update(this);
        }
    

    /**
 * Resets the game to be able to start playing again.
 */
    public void resetGame() 
        {
            for(int row = 0;row<row_count;row++) 
            {
                for(int column = 0;column<col_count;column++) 
                {
                        get_blocksData()[row][column].reset();
                // Enable the bottom row
                    get_blocksData()[row][column].setIsLegalMove(row == row_count-1);
                }
            }
            player = player1;
            movesLeft = row_count*col_count;
            setFinalResult(null);
            gameView.update(this);
        }
    


}
