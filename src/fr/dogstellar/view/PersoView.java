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
     */
    public PersoView(String picturePath, Perso monster) {
        super(picturePath, "Monstre", ".png");

        //Add  an action listener for this Perso button
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to attack the monster ? Be carfull, you can not stop a fight", "choose one", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    Fight theFight = new Fight(monster, StartGame.getPlayer());
                    StartGame.getInterf().getTheWindow().adjustWindow();
                }
            }
        });
    }
}
