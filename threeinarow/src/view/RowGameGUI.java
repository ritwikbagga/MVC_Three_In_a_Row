package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;

import model.RowGameModel;
import controller.RowGameController;


public class RowGameGUI implements RowGameView
{
    private  JFrame gui = new JFrame("Game");
    private RowGameBoardView gameBoardView;
    private JButton reset = new JButton("Reset");
    private RowGameStatusView gameStatusView; 
    private RowGameModel gameModel;


    /**
     * Creates a new game initializing the GUI.
     */
    public RowGameGUI(RowGameModel gameModel) {
	this.gameModel = gameModel;
	
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(new Dimension(500, 350));
        gui.setResizable(true);

	gameBoardView = new RowGameBoardView(this.gameModel);
        JPanel gamePanel = gameBoardView.get_gamePanel();

        JPanel options = new JPanel(new FlowLayout());
        options.add(reset);

	gameStatusView = new RowGameStatusView(this.gameModel);
        JPanel messages = gameStatusView.get_messages();

        gui.add(gamePanel, BorderLayout.NORTH);
        gui.add(options, BorderLayout.CENTER);
        gui.add(messages, BorderLayout.SOUTH);

        reset.addActionListener(new ActionListener() { //add adaptor
            public void actionPerformed(ActionEvent e) {
                gameModel.resetGame();
            }
        });
    }
    public JFrame get_gui(){  //RowGameBoardView
        return this.gui;
    }

 
    public RowGameBoardView get_GameBoardView(){ 
        return this.gameBoardView;
    }

    /**
     * Updates the game view after the game model
     * changes state.
     *
     * @param gameModel The current game model
     */
    public void update(RowGameModel gameModel) {
	gameBoardView.update(gameModel);

	gameStatusView.update(gameModel);
    }
    public RowGameBoardView get_RowGameBoardView(){ 
        return this.gameBoardView; 
    }
}
