/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.dogstellar.view;

import fr.dogstellar.core.*;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Thomas
 */
public class ElementView extends JButton {
    
		/**
		 * Set the picture of the graphical element.
		 */
		
		private String CoffrePicturePath;// The path of the picture.
                private Element E;
                
		public ElementView (String picturePath, Element newE) {
			super();
			CoffrePicturePath = new String(picturePath + "Coffre");
                        E = newE;
                        
			System.out.println(CoffrePicturePath);
                        
                        if (!E.getDone())
                        {    
                            this.setIcon(new ImageIcon(CoffrePicturePath + "_fermer.jpg"));
                            this.setRolloverIcon(new ImageIcon (CoffrePicturePath + "_selection.jpg"));
                            this.setBorder(BorderFactory.createEmptyBorder());
                            this.setContentAreaFilled(false);
                        }
                        else 
                        {
                            this.setIcon(new ImageIcon(CoffrePicturePath + "_ouvert.jpg"));
                            this.setBorder(BorderFactory.createEmptyBorder());
                            this.setContentAreaFilled(false);
                        }    
                //Once opened, use Coffre_ouvert.jpg
                
                
                
                
}

}