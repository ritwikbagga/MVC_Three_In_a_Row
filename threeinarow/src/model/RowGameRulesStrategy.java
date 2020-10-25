package model;
import javax.swing.JButton;

import model.RowGameModel;


public interface RowGameRulesStrategy
{
    public void resetGame();

    public void move(JButton block);

    public boolean isWinner(JButton block);

    public boolean isTie();
}
//