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
import java.util.Random;

import com.sun.java.swing.plaf.gtk.GTKConstants.ArrowType;

import java.awt.Graphics;

import fr.dogstellar.core.AreaPlanet;
import fr.dogstellar.core.Perso;
import fr.dogstellar.core.Element;

import java.util.*;
import java.util.List;

public class Window extends JPanel {

	private GraphicalArrow eastArrow;//The east Arrow
	private GraphicalArrow westArrow;//The west Arrow
	private GraphicalArrow northArrow;//The north Arrow
	private GraphicalArrow southArrow;//The south Arrow
	private HashMap<Integer,Component> components; //The coordinates (xxyy) linked to a component (arrow for example)
	private int height;//The number of column
	private int length;//The number of lines
	private String picturePath;
	private String nameOfFirstBackgroundPicture;
	private AreaPlanet area; //The areaPlanet to show.
	private Image back;
	private JFrame interfac;
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
	 */
	public Window (AreaPlanet firstArea, JFrame inter)
	{
			interfac = inter;
            components = new HashMap<Integer,Component>();
            setHeight(7); //
            setLength(13);
            picturePath = new String(System.getProperty("user.dir") + "/pictures/");
            
            adjustWindowToAreaPlanet(firstArea);
		
            eastArrow = new GraphicalArrow (east, picturePath);
            westArrow = new GraphicalArrow (west, picturePath);
            northArrow = new GraphicalArrow (north, picturePath);
            southArrow = new GraphicalArrow (south, picturePath);
            
            southArrow.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					adjustWindowToAreaPlanet(area.getOrientationArea(south));
				}
			});
            
            northArrow.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					adjustWindowToAreaPlanet(area.getOrientationArea(north));
				}
			});
            
            eastArrow.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					adjustWindowToAreaPlanet(area.getOrientationArea(east));
				}
			});
            
            westArrow.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					adjustWindowToAreaPlanet(area.getOrientationArea(west));
				}
			});
		
            addArrow(northArrow, north);
            addArrow(southArrow, south);
            addArrow(eastArrow, east);
            addArrow(westArrow, west);
            
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
        	addRandomlyComponent(new PersoView(picturePath));
        }
        
        for (Element e : area.getElement())
        {
        	addRandomlyComponent(new ElementView(picturePath, e));
        }

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
		System.out.println("X : " + x);
		System.out.println("Y : " + y);
		x++;
		y++;
		addComponentToGrid(comp, x, y);
	}
	
}
