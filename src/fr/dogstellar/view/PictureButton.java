package fr.dogstellar.view;

import java.awt.Image;
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
        
        ImageIcon ImageIcon1 = new ImageIcon (buttonPicturePath + formatPicture);
        ImageIcon1 = ConvertImg(60, 60, ImageIcon1);
        
        ImageIcon ImageIcon2 = new ImageIcon (buttonPicturePath + "Roll" + formatPicture);
        ImageIcon2 = ConvertImg(60, 60, ImageIcon2);
        
        this.setIcon(ImageIcon1);
        this.setRolloverIcon(ImageIcon2);
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setContentAreaFilled(false);
    }

     public ImageIcon ConvertImg(int largeur, int hauteur, ImageIcon img) {
        Image image = img.getImage();
        Image newimg = image.getScaledInstance(largeur, hauteur, java.awt.Image.SCALE_SMOOTH);
        img = new ImageIcon(newimg);
        return img;
    }
    
}
