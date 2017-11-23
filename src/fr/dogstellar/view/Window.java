package fr.dogstellar.view;

/**
 * This class is the representation of a simple Window of the game.
 * The window is made as a grid with a background.
 * The grid contains Components.
 * 
 * @author (G3)
 * @version (21/11/17)
 *
 */

import java.awt.*;
import javax.swing.*;
import java.util.*;

public class Window extends JFrame {

	GraphicalArrow eastArrow;//The east Arrow
	GraphicalArrow westArrow;//The west Arrow
	GraphicalArrow northArrow;//The north Arrow
	GraphicalArrow southArrow;//The south Arrow
	HashMap<Integer,Component> components; //The coordinates (xxyy) linked to a component (arrow for example)
	int height;//The number of column
	int length;//The number of lines
	/**
	 * The constructor of Window.
	 * Create the window with its components.
	 * The heigh and length are initialized. If they are greater than 100 or lower than 0 they
	 * are initialized to 3.
	 */
	public Window ()
	{
		components = new HashMap<Integer,Component>();
		setHeight(3);
		setLength(3);
		
		
		eastArrow = new GraphicalArrow ("east");
		westArrow = new GraphicalArrow ("west");
		northArrow = new GraphicalArrow ("north");
		southArrow = new GraphicalArrow ("south");
		
		addComponentToGrid(eastArrow, 2, 1);
		addComponentToGrid(westArrow, 0, 1);
		addComponentToGrid(northArrow, 1, 0);
		addComponentToGrid(southArrow, 1, 2);
		
		drawGrid();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
	}
	/**
	 * Allow to add a component to components (hashmap). 
	 * If x or y are not valid (>0 or >height||weight) the comp is not added.
	 * @param comp The component to add
	 * @param x the x coordonate
	 * @param y the y coordonate
	 */
	private void addComponentToGrid(Component comp, int x, int y)
	{
		if (x>-1 && x<length && y>-1 && y <height)
		{
			int key = x*100+y;
			components.put(key, comp);
		}
	}
	
	/**
	 * Add each element previously put in the components map to the Window.
	 */
	private void drawGrid ()
	{
		Container c = this.getContentPane();
		c.setLayout(new GridLayout(height,length));
		
		for (int j = 0; j < height; j++)
		{
			for (int i = 0; i <length; i++)
			{
				int key = i*100+j;
				if (components.containsKey(key))
				{
					c.add(components.get(key));
				}
				else
				{
					c.add(new Label());
				}
			}
		}
	}
	/**
	 * Set the number of line of the grid.
	 * If h <0 or >100 it is initialized to 3
	 * @param h the height
	 */
	private void setHeight (int h)
	{
		if (h>0 && h < 100)
		{
			height = h;
		}
		else
		{
			height = 3;
		}
	}
	/**
	 * Set the number of column of the grid.
	 * If l <0 or >100 it is initialized to 3
	 * @param l the length
	 */
	private void setLength (int l)
	{
		if (l>0 && l < 100)
		{
			length = l;
		}
		else
		{
			length = 3;
		}
	}
	
}
