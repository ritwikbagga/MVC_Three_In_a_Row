import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import controller.RowGameController;
import model.RowBlockModel;
import model.RowGameModel;
import model.ThreeInARow;
import model.TicTacTo;
import view.RowGameGUI;

import javax.swing.JButton;

public class ViewTest {

    @Test
    public void ViewTestState()
    { 
         RowGameController game1 = new RowGameController("ThreeInARow");
         RowGameController game2 = new RowGameController("TicTacTo");

         game1.getModel().get_blocksData()[1][1].setContents("X");
         assertEquals("X", game1.getModel().get_blocksData()[1][1].getContents());

         game2.getModel().get_blocksData()[1][1].setContents("X");
         assertEquals("X", game2.getModel().get_blocksData()[1][1].getContents());

         //check if the tittle of JFrame is correct
         assertEquals("You are playing 3 in a row!" , game1.getModel().getView().get_gui().getTitle());
         assertEquals("You are playing TicTacToe!" , game2.getModel().getView().get_gui().getTitle());
       
 

    }
}
