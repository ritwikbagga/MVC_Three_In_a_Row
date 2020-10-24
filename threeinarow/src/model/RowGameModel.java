package model;
import view.* ;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import view.RowGameGUI;

public class RowGameModel 
{
    private static final String GAME_END_NOWINNER = "Game ends in a draw";
    private RowBlockModel[][] blocksData = new RowBlockModel[3][3];
    private  RowGameGUI gameView; 
    private String player ; 
    private int movesLeft; 
    private String finalResult = null;

    

    public RowGameModel() {
    this.movesLeft = 9 ;
    this.player = "1";
    this.gameView = new RowGameGUI(this); 
	for (int row = 0; row < 3; row++) {
	    for (int col = 0; col < 3; col++) {
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

    // public void startUp() {
	// gameView.get_gui().setVisible(true);
    // }

    
    public void move(JButton block) {
        this.movesLeft = this.movesLeft - 1;
    
        String player = this.player;
        int movesLeft = this.movesLeft;
        if(player.equals("1")) {
            // Check whether player 1 won
            if(block==gameView.get_GameBoardView().get_blocks()[0][0]) {
            this.blocksData[0][0].setContents("X");
            this.blocksData[0][0].setIsLegalMove(false);
            this.player = "2";
            if(movesLeft<7) {
                if((this.blocksData[0][0].getContents().equals(this.blocksData[0][1].getContents()) &&
                this.blocksData[0][1].getContents().equals(this.blocksData[0][2].getContents())) ||
                    (this.blocksData[0][0].getContents().equals(this.blocksData[1][0].getContents()) &&
                this.blocksData[1][0].getContents().equals(this.blocksData[2][0].getContents())) ||
                    (this.blocksData[0][0].getContents().equals(this.blocksData[1][1].getContents()) &&
                this.blocksData[1][1].getContents().equals(this.blocksData[2][2].getContents()))) {
                this.setFinalResult("Player 1 wins!");
                endGame();
                } else if(movesLeft==0) {
                this.setFinalResult(GAME_END_NOWINNER);
                }
            }
            } else if(block==gameView.get_GameBoardView().get_blocks()[0][1]) {
            this.blocksData[0][1].setContents("X");
            this.blocksData[0][1].setIsLegalMove(false);
            this.player = "2";
            if(movesLeft<7) {
                if((this.blocksData[0][1].getContents().equals(this.blocksData[0][0].getContents()) &&
                this.blocksData[0][0].getContents().equals(this.blocksData[0][2].getContents())) ||
                    (this.blocksData[0][1].getContents().equals(this.blocksData[1][1].getContents()) &&
                this.blocksData[1][1].getContents().equals(this.blocksData[2][1].getContents()))) {
                this.setFinalResult("Player 1 wins!");
                endGame();
                } else if(movesLeft==0) {
                this.setFinalResult(GAME_END_NOWINNER);
                }
            }
            } else if(block==gameView.get_GameBoardView().get_blocks()[0][2]) {
            this.blocksData[0][2].setContents("X");
            this.blocksData[0][2].setIsLegalMove(false);
            this.player = "2";
            if(movesLeft<7) {
                if((this.blocksData[0][2].getContents().equals(this.blocksData[0][1].getContents()) &&
                this.blocksData[0][1].getContents().equals(this.blocksData[0][0].getContents())) ||
                    (this.blocksData[0][2].getContents().equals(this.blocksData[1][2].getContents()) &&
                this.blocksData[1][2].getContents().equals(this.blocksData[2][2].getContents())) ||
                    (this.blocksData[0][2].getContents().equals(this.blocksData[1][1].getContents()) &&
                this.blocksData[1][1].getContents().equals(this.blocksData[2][0].getContents()))) {
                this.setFinalResult("Player 1 wins!");
                endGame();
                } else if(movesLeft==0) {
                this.setFinalResult(GAME_END_NOWINNER);
                }
            }
            } else if(block==gameView.get_GameBoardView().get_blocks()[1][0]) {
            this.blocksData[1][0].setContents("X");
            this.blocksData[1][0].setIsLegalMove(false);
            // Enable the space on top of this one
            this.blocksData[0][0].setIsLegalMove(true);
            this.player = "2";
            if(movesLeft<7) {
                if((this.blocksData[1][0].getContents().equals(this.blocksData[1][1].getContents()) &&
                this.blocksData[1][1].getContents().equals(this.blocksData[1][2].getContents())) ||
                    (this.blocksData[1][0].getContents().equals(this.blocksData[0][0].getContents()) &&
                this.blocksData[0][0].getContents().equals(this.blocksData[2][0].getContents()))) {
                this.setFinalResult("Player 1 wins!");
                endGame();
                } else if(movesLeft==0) {
                this.setFinalResult(GAME_END_NOWINNER);
                }
            }
            } else if(block==gameView.get_GameBoardView().get_blocks()[1][1]) {
            this.blocksData[1][1].setContents("X");
            this.blocksData[1][1].setIsLegalMove(false);
            // Enable the space on top of this one
            this.blocksData[0][1].setIsLegalMove(true);
            this.player = "2";
            if(movesLeft<7) {
                if((this.get_blocksData()[1][1].getContents().equals(this.blocksData[1][0].getContents()) &&
                this.blocksData[1][0].getContents().equals(this.blocksData[1][2].getContents())) ||
                    (this.blocksData[1][1].getContents().equals(this.blocksData[0][1].getContents()) &&
                this.blocksData[0][1].getContents().equals(this.blocksData[2][1].getContents())) ||
                    (this.blocksData[1][1].getContents().equals(this.blocksData[0][0].getContents()) &&
                this.blocksData[0][0].getContents().equals(this.blocksData[2][2].getContents())) ||
                    (this.blocksData[1][1].getContents().equals(this.blocksData[0][2].getContents()) &&
                this.blocksData[0][2].getContents().equals(this.blocksData[2][0].getContents()))) {
                this.setFinalResult("Player 1 wins!");
                endGame();
                } else if(movesLeft==0) {
                this.setFinalResult(GAME_END_NOWINNER);
                }
            }
            } else if(block==gameView.get_GameBoardView().get_blocks()[1][2]) {
            this.blocksData[1][2].setContents("X");
            this.blocksData[1][2].setIsLegalMove(false);
            // Enable the space on top of this one
            this.blocksData[0][2].setIsLegalMove(true);
            this.player = "2";
            if(movesLeft<7) {
                if((this.blocksData[1][2].getContents().equals(this.blocksData[0][2].getContents()) &&
                this.blocksData[0][2].getContents().equals(this.blocksData[2][2].getContents())) ||
                    (this.blocksData[1][2].getContents().equals(this.blocksData[1][1].getContents()) &&
                this.blocksData[1][1].getContents().equals(this.blocksData[1][0].getContents()))) {
                this.setFinalResult("Player 1 wins!");
                endGame();
                } else if(movesLeft==0) {
                this.setFinalResult(GAME_END_NOWINNER);
                }
            }
            } else if(block==gameView.get_GameBoardView().get_blocks()[2][0]) {
            this.blocksData[2][0].setContents("X");
            this.blocksData[2][0].setIsLegalMove(false);
            // Enable the space on top of this one
            this.blocksData[1][0].setIsLegalMove(true);
            this.player = "2";
            if(movesLeft<7) {
                if((this.blocksData[2][0].getContents().equals(this.blocksData[2][1].getContents()) &&
                this.blocksData[2][1].getContents().equals(this.blocksData[2][2].getContents())) ||
                    (this.blocksData[2][0].getContents().equals(this.blocksData[1][0].getContents()) &&
                this.blocksData[1][0].getContents().equals(this.blocksData[0][0].getContents())) ||
                    (this.blocksData[2][0].getContents().equals(this.blocksData[1][1].getContents()) &&
                this.blocksData[1][1].getContents().equals(this.blocksData[0][2].getContents()))) {
                this.setFinalResult("Player 1 wins!");
                endGame();
                } else if(movesLeft==0) {
                    this.setFinalResult(GAME_END_NOWINNER);
                }
            }
            } else if(block==gameView.get_GameBoardView().get_blocks()[2][1]) {
            this.blocksData[2][1].setContents("X");
            this.blocksData[2][1].setIsLegalMove(false);
            // Enabled the space on top of this one
            this.blocksData[1][1].setIsLegalMove(true);
            this.player = "2";
            if(movesLeft<7) {
                if((this.blocksData[2][1].getContents().equals(this.blocksData[2][0].getContents()) &&
                this.blocksData[2][0].getContents().equals(this.blocksData[2][2].getContents())) ||
                    (this.blocksData[2][1].getContents().equals(this.blocksData[1][1].getContents()) &&
                this.blocksData[1][1].getContents().equals(this.blocksData[0][1].getContents()))) {
                    this.setFinalResult("Player 1 wins!");
                endGame();
                } else if(movesLeft==0) {
                this.setFinalResult(GAME_END_NOWINNER);
                }
            }
            } else if(block==gameView.get_GameBoardView().get_blocks()[2][2]) {
            this.blocksData[2][2].setContents("X");
            this.blocksData[2][2].setIsLegalMove(false);
            // Enable the space on top of this one
            this.blocksData[1][2].setIsLegalMove(true);
            this.player = "2";
            if(movesLeft<7) {
                if((this.blocksData[2][2].getContents().equals(this.blocksData[2][1].getContents()) &&
                this.blocksData[2][1].getContents().equals(this.blocksData[2][0].getContents())) ||
                    (this.blocksData[2][2].getContents().equals(this.blocksData[1][2].getContents()) &&
                this.blocksData[1][2].getContents().equals(this.blocksData[0][2].getContents())) ||
                    (this.blocksData[2][2].getContents().equals(this.blocksData[1][1].getContents()) &&
                this.blocksData[1][1].getContents().equals(this.blocksData[0][0].getContents()))) {
                this.setFinalResult("Player 1 wins!");
                endGame();
                } else if(movesLeft==0) {
                this.setFinalResult(GAME_END_NOWINNER);
                }
            }
            }
        } else {
            // Check whether player 2 won
            if(block==gameView.get_GameBoardView().get_blocks()[0][0]) {
            this.blocksData[0][0].setContents("O");
            this.blocksData[0][0].setIsLegalMove(false);
            this.player = "1";
            if(movesLeft<7) {
                if((this.blocksData[0][0].getContents().equals(this.blocksData[0][1].getContents()) &&
                this.blocksData[0][1].getContents().equals(this.blocksData[0][2].getContents())) ||
                    (this.blocksData[0][0].getContents().equals(this.blocksData[1][0].getContents()) &&
                this.blocksData[1][0].getContents().equals(this.blocksData[2][0].getContents())) ||
                    (this.blocksData[0][0].getContents().equals(this.blocksData[1][1].getContents()) &&
                this.blocksData[1][1].getContents().equals(this.blocksData[2][2].getContents()))) {
                this.setFinalResult("Player 2 wins!");
                endGame();
                } else if(movesLeft==0) {
                this.setFinalResult(GAME_END_NOWINNER);
                }
            }
            } else if(block==gameView.get_GameBoardView().get_blocks()[0][1]) {
            this.blocksData[0][1].setContents("O");
            this.blocksData[0][1].setIsLegalMove(false);
            this.player = "1";
            if(movesLeft<7) {
                if((this.blocksData[0][1].getContents().equals(this.blocksData[0][0].getContents()) &&
                this.blocksData[0][0].getContents().equals(this.blocksData[0][2].getContents())) ||
                    (this.blocksData[0][1].getContents().equals(this.blocksData[1][1].getContents()) &&
                this.blocksData[1][1].getContents().equals(this.blocksData[2][1].getContents()))) {
                this.setFinalResult("Player 2 wins!");
                endGame();
                } else if(movesLeft==0) {
                this.setFinalResult(GAME_END_NOWINNER);
                }
            }
            } else if(block==gameView.get_GameBoardView().get_blocks()[0][2]) {
            this.blocksData[0][2].setContents("O");
            this.blocksData[0][2].setIsLegalMove(false);
            this.player = "1";
            if(movesLeft<7) {
                if((this.blocksData[0][2].getContents().equals(this.blocksData[0][1].getContents()) &&
                this.blocksData[0][1].getContents().equals(this.blocksData[0][0].getContents())) ||
                    (this.blocksData[0][2].getContents().equals(this.blocksData[1][2].getContents()) &&
                this.blocksData[1][2].getContents().equals(this.blocksData[2][2].getContents())) ||
                    (this.blocksData[0][2].getContents().equals(this.blocksData[1][1].getContents()) &&
                this.blocksData[1][1].getContents().equals(this.blocksData[2][0].getContents()))) {
                this.setFinalResult("Player 2 wins!");
                endGame();
                } else if(movesLeft==0) {
                this.setFinalResult(GAME_END_NOWINNER);
                }
            }
            } else if(block==gameView.get_GameBoardView().get_blocks()[1][0]) {
            this.blocksData[1][0].setContents("O");
            this.blocksData[1][0].setIsLegalMove(false);
            // Enable the space on top of this one
            this.blocksData[0][0].setIsLegalMove(true);
            this.player = "1";
            if(movesLeft<7) {
                if((this.blocksData[1][0].getContents().equals(this.blocksData[1][1].getContents()) &&
                this.blocksData[1][1].getContents().equals(this.blocksData[1][2].getContents())) ||
                    (this.blocksData[1][0].getContents().equals(this.blocksData[0][0].getContents()) &&
                this.blocksData[0][0].getContents().equals(this.blocksData[2][0].getContents()))) {
                this.setFinalResult("Player 2 wins!");
                endGame();
                } else if(movesLeft==0) {
                this.setFinalResult(GAME_END_NOWINNER);
                }
            }
            } else if(block==gameView.get_GameBoardView().get_blocks()[1][1]) {
            this.blocksData[1][1].setContents("O");
            this.blocksData[1][1].setIsLegalMove(false);
            // Enable the space on top of this one
            this.blocksData[0][1].setIsLegalMove(true);
            this.player ="1";
            if(movesLeft<7) {
                if((this.blocksData[1][1].getContents().equals(this.blocksData[1][0].getContents()) &&
                this.blocksData[1][0].getContents().equals(this.blocksData[1][2].getContents())) ||
                    (this.blocksData[1][1].getContents().equals(this.blocksData[0][1].getContents()) &&
                this.blocksData[0][1].getContents().equals(this.blocksData[2][1].getContents())) ||
                    (this.blocksData[1][1].getContents().equals(this.blocksData[0][0].getContents()) &&
                this.blocksData[0][0].getContents().equals(this.blocksData[2][2].getContents())) ||
                    (this.blocksData[1][1].getContents().equals(this.blocksData[0][2].getContents()) &&
                this.blocksData[0][2].getContents().equals(this.blocksData[2][0].getContents()))) {
                this.setFinalResult("Player 2 wins!");
                endGame();
                } else if(movesLeft==0) {
                this.setFinalResult(GAME_END_NOWINNER);
                }
            }
            } else if(block==gameView.get_GameBoardView().get_blocks()[1][2]) {
            this.blocksData[1][2].setContents("O");
            this.blocksData[1][2].setIsLegalMove(false);
            // Enable the space on top of this one
            this.blocksData[0][2].setIsLegalMove(true);
            this.player ="1";
            if(movesLeft<7) {
                if((this.blocksData[1][2].getContents().equals(this.blocksData[0][2].getContents()) &&
                this.blocksData[0][2].getContents().equals(this.blocksData[2][2].getContents())) ||
                    (this.blocksData[1][2].getContents().equals(this.blocksData[1][1].getContents()) &&
                this.blocksData[1][1].getContents().equals(this.blocksData[1][0].getContents()))) {
                this.setFinalResult("Player 2 wins!");
                endGame();
                } else if(movesLeft==0) {
                this.setFinalResult(GAME_END_NOWINNER);
                }
            }
            } else if(block==gameView.get_GameBoardView().get_blocks()[2][0]) {
            this.blocksData[2][0].setContents("O");
            this.blocksData[2][0].setIsLegalMove(false);
            // Enable the space on top of this one
            this.blocksData[1][0].setIsLegalMove(true);
            this.player ="1";
            if(movesLeft<7) {
                if((this.blocksData[2][0].getContents().equals(this.blocksData[2][1].getContents()) &&
                this.blocksData[2][1].getContents().equals(this.blocksData[2][2].getContents())) ||
                    (this.blocksData[2][0].getContents().equals(this.blocksData[1][0].getContents()) &&
                this.blocksData[1][0].getContents().equals(this.blocksData[0][0].getContents())) ||
                    (this.blocksData[2][0].getContents().equals(this.blocksData[1][1].getContents()) &&
                this.blocksData[1][1].getContents().equals(this.blocksData[0][2].getContents()))) {
                this.setFinalResult("Player 2 wins!");
                endGame();
                } else if(movesLeft==0) {
                this.setFinalResult(GAME_END_NOWINNER);
                }
            }
            } else if(block==gameView.get_GameBoardView().get_blocks()[2][1]) {
            this.blocksData[2][1].setContents("O");
            this.blocksData[2][1].setIsLegalMove(false);
            // Enable the space on top of this one
            this.blocksData[1][1].setIsLegalMove(true);
            this.player ="1";
            if(movesLeft<7) {
                if((this.blocksData[2][1].getContents().equals(this.blocksData[2][0].getContents()) &&
                this.blocksData[2][0].getContents().equals(this.blocksData[2][2].getContents())) ||
                    (this.blocksData[2][1].getContents().equals(this.blocksData[1][1].getContents()) &&
                this.blocksData[1][1].getContents().equals(this.blocksData[0][1].getContents()))) {
                this.setFinalResult("Player 2 wins!");
                endGame();
                } else if(movesLeft==0) {
                this.setFinalResult(GAME_END_NOWINNER);
                }
            }
            } else if(block==gameView.get_GameBoardView().get_blocks()[2][2]) {
            this.blocksData[2][2].setContents("O");
            this.blocksData[2][2].setIsLegalMove(false);
            // Enable the space on top of this one
            this.blocksData[1][2].setIsLegalMove(true);
            this.player = "1";
            if(movesLeft<7) {
                if((this.blocksData[2][2].getContents().equals(this.blocksData[2][1].getContents()) &&
                this.blocksData[2][1].getContents().equals(this.blocksData[2][0].getContents())) ||
                    (this.blocksData[2][2].getContents().equals(this.blocksData[1][2].getContents()) &&
                this.blocksData[1][2].getContents().equals(this.blocksData[0][2].getContents())) ||
                    (this.blocksData[2][2].getContents().equals(this.blocksData[1][1].getContents()) &&
                this.blocksData[1][1].getContents().equals(this.blocksData[0][0].getContents()))) {
                this.setFinalResult("Player 2 wins!");
                endGame();
                } else if(movesLeft==0) {
                this.setFinalResult(GAME_END_NOWINNER);
                }
            }
            }
        }
    
        gameView.update(this);
        }

        /**
     * Ends the game disallowing further player turns.
     */
    public void endGame() {
        for(int row = 0;row<3;row++) {
            for(int column = 0;column<3;column++) {
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
            for(int row = 0;row<3;row++) 
            {
                for(int column = 0;column<3;column++) 
                {
                        get_blocksData()[row][column].reset();
                // Enable the bottom row
                    get_blocksData()[row][column].setIsLegalMove(row == 2);
                }
            }
            player = "1";
            movesLeft = 9;
            setFinalResult(null);
            gameView.update(this);
        }
    


}
