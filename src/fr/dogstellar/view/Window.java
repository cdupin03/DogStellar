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

import java.awt.event.*;
import javax.swing.*;


import fr.dogstellar.core.AreaPlanet;
import fr.dogstellar.core.Planet;
import java.util.ArrayList;


public final class Window extends GeneralWindow {

	public GraphicalArrow eastArrow;//The east Arrow
	public GraphicalArrow westArrow;//The west Arrow
	public GraphicalArrow northArrow;//The north Arrow
	public GraphicalArrow southArrow;//The south Arrow
	private AreaPlanet area; //The areaPlanet to show.
        private ArrayList<Planet> planets; //The planet
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
        * @param inter the interface.
	*/
	public Window (ArrayList<Planet> thePlanets, JFrame inter)
	{
            super(inter);
            planets = thePlanets;
            area = planets.get(0).getAreas();
            adjustWindowToAreaPlanet(area);
	}
        
        /**
         * Create and add all arrows to the components.
         * The arrows are conected to to their click.
         * If there is no areas in the arrow direction, the arrow is disabled.
         */
        public void addArrows ()
        {
            eastArrow = new GraphicalArrow (east, getPicturePath());
            westArrow = new GraphicalArrow (west, getPicturePath());
            northArrow = new GraphicalArrow (north, getPicturePath());
            southArrow = new GraphicalArrow (south, getPicturePath());
            
            int maxHeight = (getHeightGrid()-1);
            int maxLength = (getLengthGrid()-1);
	
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
            getComponentsMap().put(key, southArrow);
            
            key = generateKey(middleLength, 0);
            getComponentsMap().put(key, northArrow);
            
            key = generateKey(maxLength, middleHeight);
            getComponentsMap().put(key, eastArrow);
            
            key = generateKey(0,  middleHeight);
            getComponentsMap().put(key, westArrow);
            
        }

	/**
	 * This method display a new area in the window.
	 * @param newArea the new area to display in the window
	 */
	public void adjustWindowToAreaPlanet(AreaPlanet newArea)
	{
            catchPicture(newArea);
            erraseGrid();
            
            if (planets.get(0).getAreas().equals(newArea))
            {
                ShipView ship = new ShipView(getPicturePath());
                addComponentToGrid(ship, (getLengthGrid()-1)/2, (getHeightGrid()-1)/2);
            }

            addArrows();

            area.getPerso().stream().forEach((_item) -> {
                addRandomlyComponent(new PersoView(getPicturePath()));
                });

            area.getElement().stream().forEach((e) -> {
                addRandomlyComponent(new ElementView(getPicturePath(), e));
                });
            drawGrid();
        
	};
	
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
        
        protected void catchPicture (AreaPlanet newArea)
        {
            area = newArea;
            setNameOfFirstBackgroundPicture(area.getPicture());
            super.catchPicture();
        }
        
	
}
