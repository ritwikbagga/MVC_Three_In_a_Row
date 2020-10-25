import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import model.RowBlockModel;
import model.RowGameModel;
import model.ThreeInARow;
import model.TicTacTo;


/**
 * An example test class, which merely shows how to write JUnit tests.
 */
public class TestExample {
   // private RowGameModel gameModel;
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
    
    }

    @Test
    public void testNewGame() {
        assertEquals ("1", TicTacTo_model.get_Player_id());
        assertEquals (9, TicTacTo_model.get_MovesLeft());
        assertEquals ("1", ThreeinaRow_model.get_Player_id());
        assertEquals (9, ThreeinaRow_model.get_MovesLeft());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNewBlockViolatesPrecondition() {
	RowBlockModel block = new RowBlockModel(null);
    }


    @Test
    public void test_legal_move() {
        assertEquals (true, TicTacTo_model.get_blocksData()[2][0].getIsLegalMove());
        assertEquals (true, ThreeinaRow_model.get_blocksData()[0][0].getIsLegalMove());

       // ThreeinaRow_model.get_blocksData()[2][0].setContents("X"); 
       // assertEquals (true, ThreeinaRow_model.get_blocksData()[1][0].getIsLegalMove());

       // TicTacTo_model.get_blocksData()[2][0].setContents("X"); 
       // assertEquals (true, TicTacTo_model.get_blocksData()[1][0].getIsLegalMove());
        
    }

    @Test
    public void test_illegal_move() {
        TicTacTo_model.get_blocksData()[0][0].setContents("X"); 
        assertEquals (false, TicTacTo_model.get_blocksData()[0][0].getIsLegalMove());

        ThreeinaRow_model.get_blocksData()[2][0].setContents("X"); 
        assertEquals (false, ThreeinaRow_model.get_blocksData()[2][0].getIsLegalMove());

       // assertEquals (false, ThreeinaRow_model.get_blocksData()[0][0].getIsLegalMove());

    }

    @Test
    public void test_reset() {
        assertEquals ("1", gameModel.get_Player_id());
        assertEquals (9, gameModel.get_MovesLeft());
    }


    




}
