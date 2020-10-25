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
import controller.RowGameController;

public class ThreeInARow extends RowGameModel{
    public ThreeInARow(RowGameController c)
    { 
        super(c); 
        super.gameView.get_gui().setTitle("You are playing 3 in a row!"); //Set title for JFrame
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
