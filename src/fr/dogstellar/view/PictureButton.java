/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.dogstellar.view;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author alexandre
 */
public abstract class PictureButton extends JButton {
    private final String buttonPicturePath;// The path of the picture.
	
	public PictureButton (String picturePath, String nameButtonPicture, String formatPicture) {
		super();
		buttonPicturePath = picturePath + nameButtonPicture;
		this.setIcon(new ImageIcon(buttonPicturePath + formatPicture));
		this.setRolloverIcon(new ImageIcon (buttonPicturePath + "Roll" + formatPicture));
		this.setBorder(BorderFactory.createEmptyBorder());
		this.setContentAreaFilled(false);
	}
    
}
