package fr.dogstellar.view;

import fr.dogstellar.core.*;
import java.awt.Container;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * This class allow the display of element in the screen, a element is a Jbutton
 * represented by a picture
 *
 * @author Group 3
 * @version V02
 */
public class ElementView extends JButton {

    private String PicturePath;                                                 // The path of the picture.
    private Element E;                                                          // The element which needs a picture          

    /**
     * The constructor of the ElementViewClass
     *
     * @param picturePath the path of the picture
     * @param newE element which needs a picture
     */
    public ElementView(String picturePath, Element newE) {
        super();                                                                //call the constructor of the JButton
        PicturePath = new String(picturePath + "");                             //Define the path of the picture
        E = newE;                                                               //Define the element

        if (E.getType() == 1) //If the element is a enigma 
        {

            ImageIcon imageIcon = new ImageIcon(PicturePath + "enigma.png");
            imageIcon = ConvertImg(70, 60, imageIcon);

            ImageIcon imageIcon2 = new ImageIcon(PicturePath + "enigma2.png");
            imageIcon2 = ConvertImg(70, 60, imageIcon2);

            this.setIcon(imageIcon);
            this.setRolloverIcon(imageIcon2);
            this.setBorder(BorderFactory.createEmptyBorder());
            this.setContentAreaFilled(false);

            this.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    Popup newPopup = new Popup("You have an enigma to solve in the console !");
                }

            });
        } else if (E.getType() == 2) //If the element is a trap
        {
            int randomNum = ThreadLocalRandom.current().nextInt(0, 3);          // initialize random number
            String randompic;
            String randompic2;

            if (randomNum == 0) //enigma display
            {
                randompic = new String("enigma.png");
                randompic2 = new String("enigma2.png");
            } else if (randomNum == 1) // pnj display
            {
                randompic = new String("toad1.jpg");
                randompic2 = new String("toad2.jpg");
            } else // chest display
            {
                randompic = new String("Coffre_fermer.jpg");
                randompic2 = new String("Coffre_selection.jpg");
            }

            ImageIcon imageIcon = new ImageIcon(PicturePath + randompic);
            imageIcon = ConvertImg(70, 60, imageIcon);

            ImageIcon imageIcon2 = new ImageIcon(PicturePath + randompic2);
            imageIcon2 = ConvertImg(70, 60, imageIcon2);

            this.setIcon(imageIcon);
            this.setRolloverIcon(imageIcon2);
            this.setBorder(BorderFactory.createEmptyBorder());
            this.setContentAreaFilled(false);

        } else if (E.getType() == 3) //If the element is a pnj
        {

            ImageIcon imageIcon = new ImageIcon(PicturePath + "toad1.jpg");
            imageIcon = ConvertImg(70, 70, imageIcon);

            ImageIcon imageIcon2 = new ImageIcon(PicturePath + "toad2.jpg");
            imageIcon2 = ConvertImg(70, 70, imageIcon2);

            this.setIcon(imageIcon);
            this.setRolloverIcon(imageIcon2);
            this.setBorder(BorderFactory.createEmptyBorder());
            this.setContentAreaFilled(false);
        } else if (E.getType() == 4) //If the element is a chest
        {
            if (!E.getDone()) {
                ImageIcon imageIcon = new ImageIcon(PicturePath + "Coffre_fermer.jpg");
                imageIcon = ConvertImg(70, 70, imageIcon);

                ImageIcon imageIcon2 = new ImageIcon(PicturePath + "Coffre_selection.jpg");
                imageIcon2 = ConvertImg(70, 70, imageIcon2);

                this.setIcon(imageIcon);
                this.setRolloverIcon(imageIcon2);
                this.setBorder(BorderFactory.createEmptyBorder());
                this.setContentAreaFilled(false);
            } else {
                ImageIcon imageIcon = new ImageIcon(PicturePath + "Coffre_ouvert.jpg");
                imageIcon = ConvertImg(70, 70, imageIcon);

                this.setIcon(imageIcon);
                this.setBorder(BorderFactory.createEmptyBorder());
                this.setContentAreaFilled(false);

            }
        }
    }

    /**
     * Allow to resized a picture
     *
     * @param largeur width of the resized picture
     * @param hauteur height of the resized picture
     * @param img picture to resized
     * @return img picture resized
     */
    public ImageIcon ConvertImg(int largeur, int hauteur, ImageIcon img) {
        Image image = img.getImage();
        Image newimg = image.getScaledInstance(largeur, hauteur, java.awt.Image.SCALE_SMOOTH);
        img = new ImageIcon(newimg);
        return img;
    }

}
