package fr.dogstellar.view;

/**
 * This class allows to create a Pop-up window.
 * @author G3
 */
import javax.swing.*;


public class Popup {

	private String picturePath;

	public Popup() {
		
		picturePath = new String(System.getProperty("user.dir") + "/pictures/");
		
		ImageIcon img = new ImageIcon(picturePath + "message.png");
		JOptionPane.showMessageDialog(null, "You have a new message in the dialog box !", "Information", JOptionPane.INFORMATION_MESSAGE, img);      
		
	}
	
	public static void main(String[] args) 
	{
		Popup newPopup = new Popup();	
	}
	
}
