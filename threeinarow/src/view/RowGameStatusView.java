package view;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import controller.RowGameController;
import model.RowGameModel;


public class RowGameStatusView implements RowGameView
{
    private JTextArea playerturn = new JTextArea();
    private JPanel messages = new JPanel(new FlowLayout()); //get Message

    
    public RowGameStatusView(RowGameModel gameModel) {
	super();

	messages.setBackground(Color.white);
	messages.add(playerturn);
    }

    public void update(RowGameModel gameModel) {
	if (gameModel.getFinalResult() == null) {
	    if (gameModel.player.equals("1")) {
		playerturn.setText("Player 1 to play 'X'");
	    }
	    else {
		playerturn.setText("Player 2 to play 'O'");
	    }
	}
	else {
	    playerturn.setText(gameModel.getFinalResult());
	}	
	}
	public JPanel get_messages(){ 
		return this.messages; 
	}
}
