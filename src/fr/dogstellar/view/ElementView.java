/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.dogstellar.view;

import fr.dogstellar.core.*;
import java.awt.Container;
import java.awt.Image;

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
		
		private String PicturePath;// The path of the picture.
                private Element E;
                         
                
                public ImageIcon ConvertImg (int largeur, int hauteur, ImageIcon img)
                { Image image = img.getImage();
                  Image newimg = image.getScaledInstance( largeur,  hauteur,  java.awt.Image.SCALE_SMOOTH);
                  img = new ImageIcon(newimg);
                  return img;}
                
		public ElementView (String picturePath, Element newE) {
			super();
			PicturePath = new String(picturePath + "");
                        E = newE;
                        
			System.out.println(PicturePath);
                        
                         if (E.getType() == 1)
                        {   
                            
                            
                            ImageIcon imageIcon = new ImageIcon(PicturePath + "enigma.png");
                            imageIcon = ConvertImg (70, 60, imageIcon);
                            
                            ImageIcon imageIcon2 = new ImageIcon(PicturePath + "enigma2.png");
                            imageIcon2 = ConvertImg (70, 60, imageIcon2);
                            
                            
                            this.setIcon(imageIcon);
                            this.setRolloverIcon(imageIcon2);
                            this.setBorder(BorderFactory.createEmptyBorder());
                            this.setContentAreaFilled(false);
                        }
                        
                        
                         else if (E.getType() == 3)
                        {   
                            
                            
                            ImageIcon imageIcon = new ImageIcon(PicturePath + "toad1.jpg");
                            imageIcon = ConvertImg (70, 70, imageIcon);
                            
                            ImageIcon imageIcon2 = new ImageIcon(PicturePath + "toad2.jpg");
                            imageIcon2 = ConvertImg (70, 70, imageIcon2);
                            
                            
                            this.setIcon(imageIcon);
                            this.setRolloverIcon(imageIcon2);
                            this.setBorder(BorderFactory.createEmptyBorder());
                            this.setContentAreaFilled(false);
                        }
                        else if (E.getType() == 4)
                        {
                            if (!E.getDone())
                            {
                                ImageIcon imageIcon = new ImageIcon(PicturePath + "Coffre_fermer.jpg");
                                imageIcon = ConvertImg (70, 70, imageIcon);

                                ImageIcon imageIcon2 = new ImageIcon(PicturePath + "Coffre_selection.jpg");
                                imageIcon2 = ConvertImg (70, 70, imageIcon2);

                                this.setIcon(imageIcon);
                                this.setRolloverIcon(imageIcon2);
                                this.setBorder(BorderFactory.createEmptyBorder());
                                this.setContentAreaFilled(false);
                            }
                            else 
                            {
                                ImageIcon imageIcon = new ImageIcon(PicturePath + "Coffre_ouvert.jpg");
                                imageIcon = ConvertImg (70, 70, imageIcon);

                                this.setIcon(imageIcon);
                                this.setBorder(BorderFactory.createEmptyBorder());
                                this.setContentAreaFilled(false);
                                
                            }
                        }    
                            
                //Once opened, use Coffre_ouvert.jpg
                
                
                
                
}

}