package fr.dogstellar.view;

import java.awt.event.*;
import javax.swing.*;

import fr.dogstellar.core.*;
import fr.dogstellar.game.Fight;

/**
 * This class allows to set an image for a perso
 *
 * @author Group 3
 * @version V02
 */
public class PersoView extends PictureButton {

	
    /**
     * The constructor of this class
     *
     * @param picturePath is the path of the pictures
     * @param monster is the monster to add in the interface
     */
    public PersoView(String picturePath, Perso monster) {
        super(picturePath, "Monstre", ".png");

        //Add  an action listener for this Perso button
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null, "There is still time to turn back, are you sure you want to attack?", "choose one", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    Fight theFight = new Fight(monster, StartGame.getPlayer());
                    StartGame.getInterf().getTheWindow().adjustWindow();
                }
            }
        });
    }
}
