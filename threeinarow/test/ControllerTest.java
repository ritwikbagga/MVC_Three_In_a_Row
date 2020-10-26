import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import controller.RowGameController;
import model.RowBlockModel;
import model.RowGameModel;
import model.ThreeInARow;
import model.TicTacTo;
import javax.swing.JButton;

public class ControllerTest {
   
    @Test
    public void ControllerTestState()
    {
         RowGameController game1 = new RowGameController("ThreeInARow");
         RowGameController game2 = new RowGameController("TicTacTo");
  
       game1.getModel().get_blocksData()[1][1].setContents("X");
       JButton b1 = game1.getModel().getView().get_GameBoardView().get_blocks()[1][1];
       game1.request(b1);
       assertEquals("X",game1.getModel().get_blocksData()[1][1].getContents() );



       game2.getModel().get_blocksData()[1][1].setContents("X");
       JButton b2 = game2.getModel().getView().get_GameBoardView().get_blocks()[1][1];
       game2.request(b2);
       assertEquals("X",game2.getModel().get_blocksData()[1][1].getContents() );

    }

 
}
