package fr.dogstellar.view;

import javax.swing.*;

import fr.dogstellar.game.Fight;

/**
 * This class allows to create a Pop-up window.
 *
 * @author Group 3
 * @version V01
 */
public class Popup {

    private String picturePath;                                                     //The path of the pictures

    /**
     * The constructor of the PopUp class that allow to display a message in a
     * pop up window
     */
    public Popup( String text) {

        picturePath = new String(System.getProperty("user.dir") + "/pictures/");    //Initialize the path of the pictures

        ImageIcon img = new ImageIcon(picturePath + "message.png");                 //Set the message image
        JOptionPane.showMessageDialog(null, text, "Information", JOptionPane.INFORMATION_MESSAGE, img);


    }

}
