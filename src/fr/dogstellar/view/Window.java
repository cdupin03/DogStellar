/**
 * 
 */
package fr.dogstellar.view;

import java.awt.*;
import javax.swing.*;

/**
 * @author clarisse
 *
 */
public class Window extends JFrame {
	GraphicalArrow eastArrow;
	GraphicalArrow westArrow;
	GraphicalArrow northArrow;
	GraphicalArrow southArrow;
	
	public Window ()
	{
		int height = 3;
		int weight = 3;
		Container c = this.getContentPane();
		c.setLayout(new GridLayout(height,weight));
		eastArrow = new GraphicalArrow ("east");
		westArrow = new GraphicalArrow ("west");
		northArrow = new GraphicalArrow ("north");
		southArrow = new GraphicalArrow ("south");
		
		for (int i = 0; i<height; i++)
		{
			for (int j = 0; j<weight; j++)
			{
				if (i == 0 && j==1)
				{
					c.add(northArrow);
				}
				else if (i == 1 && j==0)
				{
					c.add(westArrow);
				}
				else if (i == 1 && j == 2)
				{
					c.add(eastArrow);
				}
				else if (i == 2 && j == 1)
				{
					c.add(southArrow);
				}
				else
				{
					c.add(new JPanel());
				}
			}
		}
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
	}
	
}
