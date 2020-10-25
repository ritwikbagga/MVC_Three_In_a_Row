package model;
import view.* ;

import javax.naming.ldap.LdapContext;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import view.RowGameGUI;

public class ThreeInARow extends RowGameModel{
    public ThreeInARow()
    { 
        super(); 
    }

    public void move(JButton block) {
        super.move(block);
     }

     @Override
     public void resetGame() 
     {
         for(int row = 0;row<row_count;row++) 
         {
             for(int column = 0;column<col_count;column++) 
             {
                     get_blocksData()[row][column].reset();
             // Enable the bottom row
                 get_blocksData()[row][column].setIsLegalMove(row == row_count-1);
             }
         }
         player = player1;
         movesLeft = row_count*col_count;
         setFinalResult(null);
         gameView.update(this);
     }



}
