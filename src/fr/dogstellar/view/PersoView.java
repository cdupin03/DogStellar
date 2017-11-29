package fr.dogstellar.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import fr.dogstellar.core.Perso;
import fr.dogstellar.core.Player;
import fr.dogstellar.core.QuestElement;
import fr.dogstellar.core.Stuff;

public class PersoView extends JButton {

		
		/**
		 * Set the picture of the graphical arrow. The arrow take the direction 
		 * given in parameter. If the direction is not NORTH, SOUTH, EAST or WEST, 
		 * then, the direction taken is NORTH by default.
		 */
		
		private String MonsterPicturePath;
		private StartGame startG;
		private Interface interfa;
		private Window wind;
		
		
		public PersoView (String picturePath) {
			super();
			MonsterPicturePath = new String(picturePath + "Monstre");
			this.setIcon(new ImageIcon(MonsterPicturePath + ".png"));
			this.setRolloverIcon(new ImageIcon (MonsterPicturePath + "2.png"));
			this.setBorder(BorderFactory.createEmptyBorder());
			this.setContentAreaFilled(false);
			
			this.addActionListener(new ActionListener (){
	            public void actionPerformed(ActionEvent e) {
	            	startG.interf.addMessageToConsole("Are you sure that you want to attack the monster ?");
	            	System.out.println(StartGame.interf.getAnswer());
	            	if (interfa.answer!=null && StartGame.interf.getAnswer()=="YES"){
		    	    	//modify access to the button
	            		interfa.attack.setEnabled(true);
		    	    	wind.eastArrow.setEnabled(false);
		    	    	wind.westArrow.setEnabled(false);
		    	    	wind.northArrow.setEnabled(false);
		    	    	wind.southArrow.setEnabled(false);
		    	    	//Fight(Interface.monstre1, Player myPlayer, QuestElement partOfShip, Stuff otherStuff);
	            	}
	    	    	
	    	    }
	        });
		}
}
