package view;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import adaptor.Adaptor;
import model.RowGameModel;
import controller.RowGameController;


public class RowGameGUI implements RowGameView
{
    private  JFrame gui = new JFrame("Game");
    private RowGameBoardView gameBoardView;
    private JButton reset = new JButton("Reset");
    private RowGameStatusView gameStatusView; 
    private RowGameModel gameModel;
    private Adaptor adaptor; 
    private RowGameController c  ; 


    /**
     * Creates a new game initializing the GUI.
     */
    public RowGameGUI(RowGameModel gameModel, RowGameController c) {
    this.gameModel = gameModel;
    this.c = c; 
	
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(new Dimension(500, 350));
        gui.setResizable(true);

	gameBoardView = new RowGameBoardView(this.gameModel, this.adaptor);
        JPanel gamePanel = gameBoardView.get_gamePanel();

        JPanel options = new JPanel(new FlowLayout());
        options.add(reset);

	gameStatusView = new RowGameStatusView(this.gameModel);
        JPanel messages = gameStatusView.get_messages();

        gui.add(gamePanel, BorderLayout.NORTH);
        gui.add(options, BorderLayout.CENTER);
        gui.add(messages, BorderLayout.SOUTH);
        this.adaptor = new Adaptor(this.c, this);  //initialze adaptor
        reset.addActionListener(adaptor); //Adaptor used
    }
    public JFrame get_gui(){  //RowGameBoardView
        return this.gui;
    }

    public boolean isReset(JButton button){ 
        if (button==this.reset)
         return true; 
    return false;
    }

    public Adaptor get_adaptor(){ 
        return this.adaptor; 
    }

    // public void setActionListener(RowGameController c )
    // {
    //     this.adaptor = new Adaptor(c, this); 
        

    // }

 
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
