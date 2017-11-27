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
import java.io.File;
import java.io.IOException;
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.*;

import fr.dogstellar.core.AreaPlanet;
import fr.dogstellar.core.Perso;
import fr.dogstellar.core.Element;

import java.util.*;
import java.util.List;

public class Window extends JFrame {

	GraphicalArrow eastArrow;//The east Arrow
	GraphicalArrow westArrow;//The west Arrow
	GraphicalArrow northArrow;//The north Arrow
	GraphicalArrow southArrow;//The south Arrow
	HashMap<Integer,Component> components; //The coordinates (xxyy) linked to a component (arrow for example)
	int height;//The number of column
	int length;//The number of lines
	String picturePath;
	String nameOfFirstBackgroundPicture;
	AreaPlanet area; //The areaPlanet to show.
	
	/**
	 * The constructor of Window.
	 * Create the window with its components.
	 * Set set the background image of the world.
	 * Set all elements in in the window.
	 * The heigh and length are initialized. If they are greater than 100 or lower than 0 they
	 * are initialized to 3. The height and length are managed by setHeight and setLength.
	 */
	public Window (String pictureName, AreaPlanet firstArea)
	{
            components = new HashMap<Integer,Component>();
            setHeight(15);
            setLength(21);
            picturePath = new String(System.getProperty("user.dir") + "/pictures/");
            nameOfFirstBackgroundPicture = pictureName;
            area = firstArea;
		
            try 
            {
                this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File(picturePath + nameOfFirstBackgroundPicture )))));
            }
            catch (IOException e) 
            {
                e.printStackTrace();
            }
		
            eastArrow = new GraphicalArrow ("east", picturePath);
            westArrow = new GraphicalArrow ("west", picturePath);
            northArrow = new GraphicalArrow ("north", picturePath);
            southArrow = new GraphicalArrow ("south", picturePath);
		
            int maxHeight = (height-1);
            int maxLength = (length-1);
		
            int middleHeight = maxHeight/2;
            int middleLength = maxLength/2;
		
            addComponentToGrid(eastArrow, maxLength, middleHeight);
            addComponentToGrid(westArrow, 0, middleHeight);
            addComponentToGrid(northArrow, middleLength, 0);
            addComponentToGrid(southArrow, middleLength, maxHeight);
            
            int nbComp = area.getPerso().size() + area.getElement().size();
            
            int j = middleHeight;
            int i = 3;
            for (Perso p : area.getPerso())
            {
            	addComponentToGrid(new MonsterView(picturePath), i, j);
            	if (i < height)
            	{
            		i++;
            	}
            	else
            	{
            		i = 3;
            		j++;
            	}
            }
            
            i = 13;
            j = 10;
                    
            for (Element e : area.getElement())
            {
            
                {
                    addComponentToGrid(new ElementView(picturePath,e), i, j);
                    if (i < height)
                    {
                            i++;
                    }
                    else
                    {
                            i = 10;
                            j++;
                    }
                }
            }
                      
            /*for (int j = 1; j < height-1; j++)
            {
            	for (int i = 1; i <length-1 ; i++)
            	{
                    MonsterView newM = new MonsterView (picturePath);
                    newM.addActionListener (new ActionListener () 
                    {
                        public void actionPerformed (ActionEvent e) 
                        {
                        	Window.this.newGrid();
                        	System.out.println("Coucou");
                        }
                    });
                    addComponentToGrid(newM, i, j);
            	}
            }*/
                     
            //this.setLayout(new GridLayout(2,0));
            //this.add(topPanel);
            //this.add(bottomPanel);
            this.drawGrid();
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
		c.removeAll();
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
					c.add(new JLabel());
				}
			}
		}

	}

        
	/**
	 * Erase the component in the components hashmap.
	 * Keep the arrows.
	 */
	private void erraseGrid()
	{
		List<Integer> toRemove = new ArrayList<Integer>();
		for (Map.Entry<Integer,Component> e : components.entrySet()){
		    e.getKey();
		    
		    if(!(e.getValue() == eastArrow ||
		    		e.getValue() == westArrow ||
		    		e.getValue() == northArrow ||
		    		e.getValue() == southArrow))
		    {
		        	toRemove.add(e.getKey());
		    }
		}
		
		for (Integer i : toRemove)
		{
			components.remove(i);
		}
		
		
	}
	
	
	public void newGrid ()
	{
		erraseGrid();
		drawGrid();
		this.pack();

	}
	
	/**
	 * Set the number of line of the grid.
	 * If h <0 or >100 it is initialized to 3
	 * If the h is pair, it is incremented
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
	 * If the l is pair, it is incremented
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
