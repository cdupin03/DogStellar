package fr.dogstellar.view;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;
import java.lang.String;

/**
 * This class allows to display a graphique arrow. This arrow is clickable. When
 * the arrow is clicked, we change of area. There is 4 forms of arrows North,
 * South, East West Each form brings to a different area. Each form has
 * different picture.
 *
 * @author (G3)
 * @version (21/11/17)
 */
public class GraphicalArrow extends JButton {

    private String ArrowPicturePath;                                            // The path of the picture.

    /**
     * Set the picture of the graphical arrow. The arrow take the direction
     * given in parameter. If the direction is not NORTH, SOUTH, EAST or WEST,
     * then, the direction taken is NORTH by default.
     *
     * @param direction is the direction of the arrow
     * @param picturePath is the arrow image according to the direction
     */
    public GraphicalArrow(String direction, String picturePath) {
        super();
        ArrowPicturePath = picturePath + "Fleche";
        direction = direction.toUpperCase();
        if (!(direction.equals("NORTH") || direction.equals("SOUTH")
                || direction.equals("EAST") || direction.equals("WEST"))) {
            direction = "NORTH";
        }
        ArrowPicturePath = ArrowPicturePath + direction;
        this.setIcon(new ImageIcon(ArrowPicturePath + ".png"));
        this.setRolloverIcon(new ImageIcon(ArrowPicturePath + "Roll.png"));
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setContentAreaFilled(false);
    }

}
