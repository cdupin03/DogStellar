/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.dogstellar.view;
/** 
 * This class allows to display a graphical ship. This ship is clickable.
 * When the ship is clicked, we go in the vaissault. 
 * 
 * @author (G3)
 * @version (30/11/17)
 */

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;
import java.lang.String;

public class ShipView  extends PictureButton{
	
	/**
	 * Set the picture of the graphical ship.
	 */
	
	public ShipView (String picturePath) {
		super(picturePath, "Ship", ".png");
	}

}

