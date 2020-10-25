import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controller.RowGameController;

import static org.junit.Assert.*;
import model.RowBlockModel;
import model.RowGameModel;
import model.ThreeInARow;
import model.TicTacTo;
import view.RowGameGUI;

public class ViewTest {

    private TicTacTo TicTacTo_model; 
    private ThreeInARow ThreeinaRow_model; 

    @Before
    public void setUp() {
   // gameModel = new RowGameModel();
    TicTacTo_model=  new TicTacTo();
    ThreeinaRow_model = new ThreeInARow(); 
    }

    @After
    public void tearDown() {
    gameModel = null;
    TicTacTo_model=  null;
    ThreeinaRow_model =null; 

    @Test
    public void Test_state() {
        RowGameController c = new RowGameController(); 
        RowGameGUI v = new RowGameGUI()
        
  
    }





    
    }





    
}
