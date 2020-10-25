package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.RowGameController;
import model.RowGameModel;


public class RowGameBoardView implements RowGameView
{   
    private JButton[][] blocks = new JButton[10][10];
    private JPanel gamePanel = new JPanel(new FlowLayout());

    
    public RowGameBoardView(RowGameModel gameModel) {
        
	super();

        JPanel game = new JPanel(new GridLayout(gameModel.get_rowCount(),gameModel.get_colCount()));
        gamePanel.add(game, BorderLayout.CENTER);
        this.blocks = new JButton[gameModel.get_rowCount()][gameModel.get_colCount()]; 
	
       // Initialize a JButton for each cell of the 3x3 game board.
        for(int row = 0; row<gameModel.get_rowCount(); row++) {
            for(int column = 0; column<gameModel.get_colCount() ;column++) {
                blocks[row][column] = new JButton();
                blocks[row][column].setPreferredSize(new Dimension(75,75));
                game.add(blocks[row][column]);
                blocks[row][column].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
			gameModel.move((JButton)e.getSource());
                    }
                });
            }
        }	
    }

    /**
     * Updates the game view after the game model
     * changes state.
     *
     * @param gameModel The current game model
     */
    public void update(RowGameModel gameModel) {
	for (int row = 0; row < gameModel.get_rowCount(); row++) {
	    for (int column = 0; column < gameModel.get_colCount(); column++) {
		this.updateBlock(gameModel, row, column);
	    } // end for col
	} // end for row	
    }
    //TO DO (getters and setters)
    public JPanel get_gamePanel(){ 
        return this.gamePanel; 
    }
    public JButton[][] get_blocks(){ 
        return this.blocks; 
    }

    /**
     * Updates the block view at the given row and column 
     * after the game model changes state.
     *
     * @param gameModel The game model
     * @param row The row that contains the block
     * @param column The column that contains the block
     */
    protected void updateBlock(RowGameModel gameModel, int row, int col) {
	blocks[row][col].setText(gameModel.get_blocksData()[row][col].getContents());
	blocks[row][col].setEnabled(gameModel.get_blocksData()[row][col].getIsLegalMove());	
    }
}
