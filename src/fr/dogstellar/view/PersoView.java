package fr.dogstellar.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import fr.dogstellar.core.*;
import fr.dogstellar.game.*;

public class PersoView extends PictureButton {


    /**
     * Set the picture of the graphical arrow. The arrow take the direction 
     * given in parameter. If the direction is not NORTH, SOUTH, EAST or WEST, 
     * then, the direction taken is NORTH by default.
     */

    private Window wind;		

    public PersoView (String picturePath) {
        super(picturePath, "Monstre", ".png");

        this.addActionListener(new ActionListener (){
        @Override
        public void actionPerformed(ActionEvent e) {
        	// open a window with YES NO choice to know if the player wants to fight the monster (the monster that has been selected)
            int result = JOptionPane.showConfirmDialog(null,"Are you sure you want to attack the monster ?", "choose one", JOptionPane.YES_NO_OPTION);
            //if he wants, all button is block during the fight and the fight begin with the monster that has been selected
            if (result==JOptionPane.YES_OPTION) {
                    StartGame.getInterf().isAttackEnabled(true);
                    StartGame.getInterf().getTheWindow().setEnableArrows(false);
                    Fight theFight = new Fight();
            }
        }
    });
    }
}
