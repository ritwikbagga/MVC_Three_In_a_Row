package Adaptor;
import controller.*;
import view.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.JButton;

public class Adaptor implements ActionListener{

    private RowGameController c ; //controller
    private RowGameGUI v ; // view

    public Adaptor( RowGameController c, RowGameGUI v)
    {
        this.c = c ; 
        this.v = v ; 
    }

    public void actionPerformed(ActionEvent e)
    { 
        if(v.isReset((JButton)e.getSource()))
        this.c.request(); 
        else
        { 
            this.c.request((JButton)e.getSource()); 
            
        }
    }

    
}
