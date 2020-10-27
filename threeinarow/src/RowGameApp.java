import controller.RowGameController;
import java.util.Scanner;


public class RowGameApp 
{
    /**                                                                             
     * Starts a new game in the GUI.
     */
    public static void main(String[] args) {
    //RowGameController game = new RowGameController(); 
    //RowGameController game = new RowGameController("ThreeInARow");
    Scanner obj = new Scanner(System.in);
    System.out.print("Press 1 for Three in a Row and Press 2 for TicTacTo, then press enter!"); 
    int num = obj.nextInt(); 
    if(num==1)
        {
            RowGameController game = new RowGameController("ThreeInARow"); // player wants to play ThreeinARow
            game.getModel().startUp();

        }
   
    else
        {
            RowGameController game = new RowGameController("TicTacTo"); //player wants to play tictacto
            game.getModel().startUp();
        }
    


    }
}
