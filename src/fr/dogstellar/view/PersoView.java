package fr.dogstellar.view;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class PersoView extends JButton {

		
		/**
		 * Set the picture of the graphical arrow. The arrow take the direction 
		 * given in parameter. If the direction is not NORTH, SOUTH, EAST or WEST, 
		 * then, the direction taken is NORTH by default.
		 */
		
		private String MonsterPicturePath;// The path of the picture.
		
		public PersoView (String picturePath) {
			super();
			MonsterPicturePath = new String(picturePath + "Monstre");
			this.setIcon(new ImageIcon(MonsterPicturePath + ".png"));
			this.setRolloverIcon(new ImageIcon (MonsterPicturePath + "2.png"));
			this.setBorder(BorderFactory.createEmptyBorder());
			this.setContentAreaFilled(false);
		}
}
