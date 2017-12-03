package fr.dogstellar.view;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * This class PictureButton allows to set picture in a specific button
 *
 * @author Group 3
 * @version V02
 */
public abstract class PictureButton extends JButton {

    private final String buttonPicturePath;                                                             // The path of the picture.

    /**
     * The constructor of the class
     *
     * @param picturePath is the path of the pictures
     * @param nameButtonPicture is the name of the button which needs a picture
     * @param formatPicture is the image to set
     */
    public PictureButton(String picturePath, String nameButtonPicture, String formatPicture) {
        super();
        buttonPicturePath = picturePath + nameButtonPicture;
        this.setIcon(new ImageIcon(buttonPicturePath + formatPicture));
        this.setRolloverIcon(new ImageIcon(buttonPicturePath + "Roll" + formatPicture));
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setContentAreaFilled(false);
    }

}
