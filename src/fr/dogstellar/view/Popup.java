package fr.dogstellar.view;

import javax.swing.*;

/**
 * This class allows to create a Pop-up window.
 *
 * @author Group 3
 * @version V01
 */
public class Popup {

    private final String picturePath;                                                     //The path of the pictures

    /**
     * The constructor of the PopUp class that allow to display a message in a
     * pop up window
     *
     * @param text is the text to add at the popup
     */
    public Popup(String text) {

        picturePath = System.getProperty("user.dir") + "/pictures/";    //Initialize the path of the pictures

        ImageIcon img = new ImageIcon(picturePath + "message.png");                 //Set the message image
        JOptionPane.showMessageDialog(null, text, "Information", JOptionPane.INFORMATION_MESSAGE, img);
    }

}
