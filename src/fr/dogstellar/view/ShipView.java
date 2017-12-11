package fr.dogstellar.view;

/**
 * This class allows to display a graphical ship. This ship is clickable. When
 * the ship is clicked, we go in the vaissault.
 *
 * @author Group 3
 * @version V01
 */
public class ShipView extends PictureButton {

    /**
     * Set the picture of the graphical ship.
     *
     * @param picturePath is the path of the picture
     */
    public ShipView(String picturePath) {
        super(picturePath, "Ship", ".png");
    }

}
