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
import java.awt.Graphics;

import fr.dogstellar.core.AreaPlanet;
import fr.dogstellar.core.Perso;
import fr.dogstellar.core.Element;

import java.util.*;
import java.util.List;

public class Window extends JPanel {

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
	Image back;
	JFrame interfac;
	
	/**
	 * The constructor of Window.
	 * Create the window with its components.
	 * Set set the background image of the world.
	 * Set all elements in in the window.
	 * The heigh and length are initialized. If they are greater than 100 or lower than 0 they
	 * are initialized to 3. The height and length are managed by setHeight and setLength.
	 */
	public Window (AreaPlanet firstArea, JFrame inter)
	{
			interfac = inter;
            components = new HashMap<Integer,Component>();
            setHeight(7); //
            setLength(13);
            picturePath = new String(System.getProperty("user.dir") + "/pictures/");
            
            adjustWindowToAreaPlanet(firstArea);
		
            eastArrow = new GraphicalArrow ("east", picturePath);
            westArrow = new GraphicalArrow ("west", picturePath);
            northArrow = new GraphicalArrow ("north", picturePath);
            southArrow = new GraphicalArrow ("south", picturePath);
            
            southArrow.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					adjustWindowToAreaPlanet(area.getOrientationArea("SOUTH"));
				}
			});
            
            northArrow.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					adjustWindowToAreaPlanet(area.getOrientationArea("NORTH"));
				}
			});
            
            eastArrow.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					adjustWindowToAreaPlanet(area.getOrientationArea("EAST"));
				}
			});
            
            westArrow.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					adjustWindowToAreaPlanet(area.getOrientationArea("WEST"));
				}
			});
		
            int maxHeight = (height-1);
            int maxLength = (length-1);
		
            int middleHeight = maxHeight/2;
            int middleLength = maxLength/2;
            System.out.println(middleHeight);
            System.out.println(middleLength);
		
            addComponentToGrid(eastArrow, maxLength, middleHeight);
            addComponentToGrid(westArrow, 0, middleHeight);
            addComponentToGrid(northArrow, middleLength, 0);
            addComponentToGrid(southArrow, middleLength, maxHeight);
            
            this.drawGrid();
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
		this.removeAll();
		this.setLayout(new GridLayout(height,length));
		
		for (int j = 0; j < height; j++)
		{
			for (int i = 0; i <length; i++)
			{
				int key = i*100+j;
				if (components.containsKey(key))
				{
					this.add(components.get(key));
				}
				else
				{
					this.add(new JLabel());
				}
			}
		}
		interfac.pack();
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
	
	/**
	 * Reinitialise the grid.
	 */
	@Deprecated
	public void newGrid ()
	{
		erraseGrid();
		drawGrid();

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
	/**
	 * draw the background of this panel.
	 */
	public void paintComponent(Graphics g){
		   g.drawImage(back,0,0,this.getWidth(),this.getHeight(),this);
	}
	/**
	 * This method display a new area in the window.
	 * @param newArea the new area to display in the window
	 */
	public void adjustWindowToAreaPlanet(AreaPlanet newArea)
	{
		area = newArea;
        nameOfFirstBackgroundPicture = area.getPicture();
	
        try 
        {
            System.out.println(nameOfFirstBackgroundPicture );
        	back = ImageIO.read(new File(picturePath + nameOfFirstBackgroundPicture ));
            //draw
        }
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        
        erraseGrid();
        
        int maxHeight = (height-1);
        int maxLength = (length-1);
	
        int middleHeight = maxHeight/2;
        int middleLength = maxLength/2;
        
        int j = middleHeight;
        int i = 3;
        for (Perso p : area.getPerso())
        {
        	addComponentToGrid(new PersoView(picturePath), i, j);
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

        drawGrid();
        
	}
	
}
