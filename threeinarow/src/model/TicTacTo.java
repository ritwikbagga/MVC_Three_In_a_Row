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


public class TicTacTo extends RowGameModel{
    
    public TicTacTo()
    { 
        super(); 
        super.gameView.get_gui().setTitle("You are playing TicTacToe!"); ////Set title for JFrame
    }

    public void move(JButton block) {

       super.move(block);
       
     }

     public void resetGame() 
     {
        super.resetGame();
     }

    }





