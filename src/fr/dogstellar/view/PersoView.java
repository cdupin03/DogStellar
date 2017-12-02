package fr.dogstellar.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import fr.dogstellar.core.Perso;
import fr.dogstellar.core.Player;
import fr.dogstellar.core.QuestElement;
import fr.dogstellar.core.Stuff;

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
            int result = JOptionPane.showConfirmDialog(null,"Are you sure you want to attack the monster ?", "choose one", JOptionPane.YES_NO_OPTION);
            if (result==JOptionPane.YES_OPTION) {
                    StartGame.getInterf().isAttackEnabled(true);
                    StartGame.getInterf().getTheWindow().setEnableArrows(false);
            }
        }
    });
    }
}
