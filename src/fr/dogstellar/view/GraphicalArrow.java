package fr.dogstellar.view;

/* 
 * This class allows to display a graphique arrow. This arrow is clickable.
 * When the arrow is clicked, we change of area. 
 * There is 4 forms of arrows North, South, East West
 * Each form brings to a different area.
 * Each form has different picture.
 * 
 * @author (G3)
 * @version (21/11/17)
 */

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;
import java.lang.String;
import java.awt.event.*;

public class GraphicalArrow  extends JButton{
	
	/*
	 * Set the picture of the graphical arrow. The arrow take the direction 
	 * given in parameter. If the direction is not NORTH, SOUTH, EAST or WEST, 
	 * then, the direction taken is NORTH by default.
	 */
	
	private String picturePath;
	
	public GraphicalArrow (String direction) {
		super();
		picturePath = System.getProperty("user.dir") + "/pictures/Fleche";
		
		direction = direction.toUpperCase();
		if (!(direction.equals("NORTH") || direction.equals("SOUTH")
				|| direction.equals("EAST") || direction.equals("WEST"))) {
			direction = "NORTH";
		}
		picturePath = picturePath + direction;
		System.out.println(picturePath);
		this.setIcon(new ImageIcon(picturePath + ".png"));
		this.setPressedIcon(new ImageIcon(picturePath + "Click.png"));
		this.setRolloverIcon(new ImageIcon (picturePath + "Roll.png"));
		this.setBorder(BorderFactory.createEmptyBorder());
		this.setContentAreaFilled(false);
	}

}
