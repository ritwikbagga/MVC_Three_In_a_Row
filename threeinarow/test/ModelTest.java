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

public class ModelTest {

    @Test
    public void ModelTestState()
    { 
         RowGameController game1 = new RowGameController("ThreeInARow");
         RowGameController game2 = new RowGameController("TicTacTo");

         JButton b1 = game1.getModel().getView().get_GameBoardView().get_blocks()[1][1];
         game1.getModel().move(b1);
         //check moves left
         assertEquals(8, game1.getModel().get_MovesLeft());
        // check value at 1,1
         assertEquals("X", game1.getModel().get_blocksData()[1][1].getContents());

         JButton b2 = game2.getModel().getView().get_GameBoardView().get_blocks()[1][1];
         game2.getModel().move(b2);
         //check moves left
         assertEquals(8, game2.getModel().get_MovesLeft());
        // check value at 1,1
         assertEquals("X", game2.getModel().get_blocksData()[1][1].getContents());

         //reset test for model
         game1.getModel().resetGame();
         game2.getModel().resetGame();

         assertEquals(9, game1.getModel().get_MovesLeft());
         assertEquals(9, game2.getModel().get_MovesLeft()); 
     
          b1 = game1.getModel().getView().get_GameBoardView().get_blocks()[0][0]; 
          b2 = game1.getModel().getView().get_GameBoardView().get_blocks()[0][1]; //X
         JButton b3 = game1.getModel().getView().get_GameBoardView().get_blocks()[0][2]; 
         JButton b4 = game1.getModel().getView().get_GameBoardView().get_blocks()[1][0]; //O (in tie)
         JButton b5 = game1.getModel().getView().get_GameBoardView().get_blocks()[1][1]; //X (in tie)
         JButton b6 = game1.getModel().getView().get_GameBoardView().get_blocks()[1][2]; //O (in tie)
         JButton b7 = game1.getModel().getView().get_GameBoardView().get_blocks()[2][0]; //X (in tie)
         JButton b8 = game1.getModel().getView().get_GameBoardView().get_blocks()[2][1]; //O (in tie)
         JButton b9 = game1.getModel().getView().get_GameBoardView().get_blocks()[2][2]; //X (in tie)
 
          //one of the players win 
         game1.getModel().move(b7);
         game1.getModel().move(b8);
         game1.getModel().move(b4);
         game1.getModel().move(b5);
         game1.getModel().move(b1);
        assertEquals("Player " + "1"+ " " + "wins!", game1.getModel().getView().get_StatusView().get_textArea().getText()); 
        game1.getModel().resetGame();

        //Tie
        game1.getModel().move(b7);
        game1.getModel().move(b8);
        game1.getModel().move(b9);
        game1.getModel().move(b4);
        game1.getModel().move(b5);
        game1.getModel().move(b1);
        game1.getModel().move(b6);
        game1.getModel().move(b3);
        game1.getModel().move(b2);
        assertEquals(true, game1.getModel().isTie()); 
        game1.getModel().resetGame();

        //test new game
        game1.getModel().resetGame();
        assertEquals ("1", game1.getModel().get_Player_id());
        assertEquals (9, game1.getModel().get_MovesLeft());

        //legal move
        assertEquals (true, game1.getModel().get_blocksData()[2][0].getIsLegalMove());
        assertEquals (true, game2.getModel().get_blocksData()[2][2].getIsLegalMove());

        //illegal move
        game1.getModel().move(b1); //b1 is at 0,0
        assertEquals (false, game1.getModel().get_blocksData()[0][0].getIsLegalMove());
        game1.getModel().resetGame();


        






    }
}
