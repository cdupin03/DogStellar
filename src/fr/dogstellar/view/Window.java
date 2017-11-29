package fr.dogstellar.view;

/**
 * This class is the representation of a simple Window of the game.
 * The window is made as a grid with a background.
 * The grid contains the arrows to move,
 * the element and monsters to interact with
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
import java.util.Random;
import java.awt.Graphics;

import fr.dogstellar.core.AreaPlanet;

import java.util.*;
import java.util.List;

public final class Window extends JPanel {

	public static GraphicalArrow eastArrow;//The east Arrow
	public static GraphicalArrow westArrow;//The west Arrow
	public static GraphicalArrow northArrow;//The north Arrow
	public static GraphicalArrow southArrow;//The south Arrow
	private HashMap<Integer,Component> components; //The coordinates (xxyy) linked to a component (arrow for example)
	private int height;//The number of column
	private int length;//The number of lines
	private final String picturePath;
	private String nameOfFirstBackgroundPicture;
	private AreaPlanet area; //The areaPlanet to show.
	private Image back;
	private final JFrame interfac;
	private final String south = "SOUTH";
	private final String north = "NORTH";
	private final String east = "EAST";
	private final String west =  "WEST";
	
	/**
	* The constructor of Window.
	* Create the window with its components.
	* Set set the background image of the world.
	* Set all elements in in the window.
	* The heigh and length are initialized. If they are greater than 100 or lower than 0 they
	* are initialized to 3. The height and length are managed by setHeight and setLength.
        * @param firstArea the first area of the player
        * @param inter the interface.
	*/
	public Window (AreaPlanet firstArea, JFrame inter)
	{
			interfac = inter;
            components = new HashMap<>();
            setHeight(7);
            setLength(13);
            picturePath = System.getProperty("user.dir") + "/pictures/";
            
            adjustWindowToAreaPlanet(firstArea);
            addArrows();
            
            this.drawGrid();
	}
	
	/**
	 * Generate a key to the hashmap with the x and y parameter
	 * @param x the x coordonates
	 * @param y the y coordonates
	 * @return the key in the hashmap.
	 */
	private int generateKey (int x, int y)
	{
		return x*100+y;
	}
	
	/**
	 * Add the arrows to the hashmap components. It add them according 
	 * to their direction.
	 * @param arrow the arrow to add
	 * @param direction the direction of the arrow
	 */
        @Deprecated 
	private void addArrow (GraphicalArrow arrow, String direction)
	{
	int maxHeight = (height-1);
        int maxLength = (length-1);
	
        int middleHeight = maxHeight/2;
        int middleLength = maxLength/2;
        
        int key;
        
		switch (direction)
		{
		case south:  key = generateKey(middleLength, maxHeight);
					components.put(key, arrow);
			break;
		case north: key = generateKey(middleLength, 0);
					components.put(key, arrow);
			break;
		case east: key = generateKey(maxLength, middleHeight);
					components.put(key, arrow);
			break;
		case west: key = generateKey(0,  middleHeight);
					components.put(key, arrow);
			break;
		default : System.out.println("Warning ! One arrow does not take the good direction."
				+ "It was not added to the window.");
		}
	}
        
        /**
         * Create and add all arrows to the components.
         * The arrows are conected to to their click.
         * If there is no areas in the arrow direction, the arrow is disabled.
         */
        public void addArrows ()
        {
            eastArrow = new GraphicalArrow (east, picturePath);
            westArrow = new GraphicalArrow (west, picturePath);
            northArrow = new GraphicalArrow (north, picturePath);
            southArrow = new GraphicalArrow (south, picturePath);
            
            int maxHeight = (height-1);
            int maxLength = (length-1);
	
            int middleHeight = maxHeight/2;
            int middleLength = maxLength/2;
            
            int key;
            
            if(area.getOrientationArea (south).equals(area))
            {
                southArrow.setEnabled(false);
            }
            else
            {
                southArrow.addActionListener((ActionEvent e) -> {
                    adjustWindowToAreaPlanet(area.getOrientationArea(south));
                });
            }
            
            if(area.getOrientationArea (north).equals(area))
            {
                northArrow.setEnabled(false);
            }
            else
            {
                northArrow.addActionListener((ActionEvent e) -> {
                    adjustWindowToAreaPlanet(area.getOrientationArea(north));
                });
            }
            
            if(area.getOrientationArea (east).equals(area))
            {
                eastArrow.setEnabled(false);
            }
            else
            {
                eastArrow.addActionListener((ActionEvent e) -> {
                    adjustWindowToAreaPlanet(area.getOrientationArea(east));
                });
            }
            
            if(area.getOrientationArea (west).equals(area))
            {
                westArrow.setEnabled(false);
            }
            else
            {
                westArrow.addActionListener((ActionEvent e) -> {
                    adjustWindowToAreaPlanet(area.getOrientationArea(west));
                });
            }
		
            
            key = generateKey(middleLength, maxHeight);
            components.put(key, southArrow);
            
            key = generateKey(middleLength, 0);
            components.put(key, northArrow);
            
            key = generateKey(maxLength, middleHeight);
            components.put(key, eastArrow);
            
            key = generateKey(0,  middleHeight);
            components.put(key, westArrow);
            
        }
        
        
	
	
	/**
	 * Allow to add a component to components (hashmap). Avoid to put component
	 * in the block adjacent to the borders.
	 * If the block is already taken, it put the component to the adjacent 
	 * available block recursively.
	 * @param comp The component to add
	 * @param x the x coordonate
	 * @param y the y coordonate
	 */
	private void addComponentToGrid(Component comp, int x, int y)
	{
		if (x<1)	
		{
			x=1;
		}
		else if (x>length-1)
		{
			x=1;
			y++;
		}
		if (y<1 || y>height-1)
		{
			y=1;
		}
		
		int key = generateKey(x, y);
		
		if (components.containsKey(key))
		{
			addComponentToGrid(comp, x+1, y);
		}
		else
		{
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
		
		for (int y = 0; y < height; y++)
		{
			for (int x = 0; x <length; x++)
			{
				int key = generateKey(x, y);
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
		List<Integer> toRemove = new ArrayList<>();
                components.entrySet().stream().forEach((e) -> {
                    toRemove.add(e.getKey());
            });
		
                toRemove.stream().forEach((i) -> {
                    components.remove(i);
            });
		
		
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
        @Override
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
        	back = ImageIO.read(new File(picturePath + nameOfFirstBackgroundPicture ));
            //draw
        }
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        
        erraseGrid();
        
        addArrows();
        
        area.getPerso().stream().forEach((_item) -> {
            addRandomlyComponent(new PersoView(picturePath));
            });
        
        area.getElement().stream().forEach((e) -> {
            addRandomlyComponent(new ElementView(picturePath, e));
            });
        drawGrid();
        
	}
	
	
	/**
	 * Add the comp to the grid at a random place. If the place is not
	 * accessible it redirects to the next place available.
	 * @param comp the component to add randomly
	 */
	private void addRandomlyComponent (Component comp)
	{
		Random r = new Random();
		int x = r.nextInt(length-2);//Take x between 0 and length-2
		int y = r.nextInt(height-2);//Take y between 0 and height-2
		x++;
		y++;
		addComponentToGrid(comp, x, y);
	}
        
        /**
         * Call the function setEnabled(ena) of all arrows.
         * If it is true, the arrow is enabled, so it is colored and clickable
         * If it is false, the arrow is disabled, so it is greyed and not clickable
         * @param ena If true enable if false disable.
         */
        public void setEnableArrows (boolean ena)
        {
            southArrow.setEnabled(ena);
            northArrow.setEnabled(ena);
            eastArrow.setEnabled(ena);
            westArrow.setEnabled(ena);
        }
        
        /**
         * Call the function setEnabled(ena) of all componenents in the map.
         * If it is true, the arrow is enabled, so it is colored and clickable
         * If it is false, the arrow is disabled, so it is greyed and not clickable
         * @param ena If true enable if false disable.
         */
        public void setAllComponentEnabled (boolean ena)
        {
            components.entrySet().stream().forEach((e) -> {
                e.getValue().setEnabled(ena);
            });
        }
	
}
