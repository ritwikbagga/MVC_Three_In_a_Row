package controller;
import model.RowGameModel;
import model.ThreeInARow;
import model.TicTacTo;

import javax.swing.JButton;



/**
 * Java implementation of the 3 in a row game, using the Swing framework.
 *
 * This quick-and-dirty implementation violates a number of software engineering
 * principles and needs a thorough overhaul to improve readability,
 * extensibility, and testability.
 */
public class RowGameController {
   
    private RowGameModel gameModel; //private RowGameModel gameModel
    /**
     * Creates a new game initializing the GUI.
     */
	public void setModel(RowGameModel model){
		this.gameModel = model;
	}

	 
    public RowGameController() {
	gameModel = new RowGameModel(this); 
	}

	public RowGameController(String Game) {

		if (Game.equals("ThreeInARow"))
		gameModel = new ThreeInARow(this); 
		else if (Game.equals("TicTacTo"))
		gameModel = new TicTacTo(this);
		else
		gameModel = new RowGameModel(this); //default
		
	}


    public RowGameModel getModel() {
	return this.gameModel;
    }


    public void request(JButton block) {
		gameModel.move(block);
	}

	public void request()
	{
		gameModel.resetGame();
	}



}
