package fr.dogstellar.view;

import java.awt.event.*;
import java.util.ArrayList;

import fr.dogstellar.core.AreaPlanet;
import fr.dogstellar.core.Planet;

/**
 * This class is the representation of a simple Window of the game. The window
 * is made as a grid with a background. The grid contains the arrows to move,
 * the element and monsters to interact with
 *
 * @author Group 3
 * @version V03
 */
public final class Window extends GeneralWindow {

    private GraphicalArrow eastArrow;                                           //The east Arrow
    private GraphicalArrow westArrow;                                           //The west Arrow
    private GraphicalArrow northArrow;                                          //The north Arrow
    private GraphicalArrow southArrow;                                          //The south Arrow
    private AreaPlanet area;                                                    //The areaPlanet to show.
    private final ArrayList<Planet> planets;                                          //The planets
    private final String south = "SOUTH";
    private final String north = "NORTH";
    private final String east = "EAST";
    private final String west = "WEST";

    /**
     * The constructor of Window. Create the window with its components. Set set
     * the background image of the world. Set all elements in in the window. The
     * heigh and length are initialized. If they are greater than 100 or lower
     * than 0 they are initialized to 3. The height and length are managed by
     * setHeight and setLength.
     *
     * @param thePlanets is list of planets
     * @param inter the interface.
     */
    public Window(ArrayList<Planet> thePlanets, Interface inter) {
        super(inter);
        planets = thePlanets;
        returnToFirstMap();
    }

    /**
     * Create and add all arrows to the components. The arrows are conected to
     * to their click. If there is no areas in the arrow direction, the arrow is
     * disabled.
     */
    public void addArrows() {
        eastArrow = new GraphicalArrow(east, getPicturePath());
        westArrow = new GraphicalArrow(west, getPicturePath());
        northArrow = new GraphicalArrow(north, getPicturePath());
        southArrow = new GraphicalArrow(south, getPicturePath());

        int maxHeight = (getHeightGrid() - 1);
        int maxLength = (getLengthGrid() - 1);

        int middleHeight = maxHeight / 2;
        int middleLength = maxLength / 2;

        int key;

        if (area.getOrientationArea(south).equals(area)) {
            southArrow.setEnabled(false);
        } else {
            southArrow.addActionListener((ActionEvent e) -> {
                adjustWindow(area.getOrientationArea(south));
            });
        }

        if (area.getOrientationArea(north).equals(area)) {
            northArrow.setEnabled(false);
        } else {
            northArrow.addActionListener((ActionEvent e) -> {
                adjustWindow(area.getOrientationArea(north));
            });
        }

        if (area.getOrientationArea(east).equals(area)) {
            eastArrow.setEnabled(false);
        } else {
            eastArrow.addActionListener((ActionEvent e) -> {
                adjustWindow(area.getOrientationArea(east));
            });
        }

        if (area.getOrientationArea(west).equals(area)) {
            westArrow.setEnabled(false);
        } else {
            westArrow.addActionListener((ActionEvent e) -> {
                adjustWindow(area.getOrientationArea(west));
            });
        }

        key = generateKey(middleLength, maxHeight);
        getComponentsMap().put(key, southArrow);

        key = generateKey(middleLength, 0);
        getComponentsMap().put(key, northArrow);

        key = generateKey(maxLength, middleHeight);
        getComponentsMap().put(key, eastArrow);

        key = generateKey(0, middleHeight);
        getComponentsMap().put(key, westArrow);
    }

    /**
     * This method display a new area in the window.
     *
     * @param newArea the new area to display in the window
     */
    public void adjustWindow(AreaPlanet newArea) {
        catchPicture(newArea);
        adjustWindow();
    }

    /**
     * This method refresh the area
     */
    @Override
    public void adjustWindow() {
        erraseGrid();

        if (planets.get(0).getAreas().equals(area)) {
            ShipView ship = new ShipView(getPicturePath());
            ship.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    InShip theShip = new InShip(getInterfac(), planets);
                    getInterfac().setWindow(theShip);
                }
            });
            addComponentToGrid(ship, (getLengthGrid() - 1) / 2, (getHeightGrid() - 1) / 2);
        }

        addArrows();

        area.getElement().stream().forEach((e) -> {
            addElementToGrid(new ElementView(getPicturePath(), e, this));
        });
        
        area.getPerso().stream().forEach((_item) -> {
            if (_item.getIsDead() == false) {
                System.out.println("Monster : " + _item.getNamePerso() + _item.getIsDead());
                addRandomlyComponent(new PersoView(getPicturePath(), _item));
            }
        });

        
        drawGrid();
    }

    /**
     * Call the function setEnabled(ena) of all arrows. If it is true, the arrow
     * is enabled, so it is colored and clickable If it is false, the arrow is
     * disabled, so it is greyed and not clickable
     *
     * @param ena If true enable if false disable.
     */
    @Override
    public void setEnableArrows(boolean ena) {
        southArrow.setEnabled(ena);
        northArrow.setEnabled(ena);
        eastArrow.setEnabled(ena);
        westArrow.setEnabled(ena);
    }

    /**
     * Allows to get the picture of the area.
     *
     * @param newArea the new Area to display
     */
    protected void catchPicture(AreaPlanet newArea) {
        area = newArea;
        setNameOfFirstBackgroundPicture(area.getPicture());
        super.catchPicture();
    }

    @Override
    public void returnToFirstMap() {
        area = planets.get(0).getAreas();
        adjustWindow(area);
    }
    
    /**
     * add the element on its right coordonates on the grid.
     * @param elt 
     */
    public void addElementToGrid (ElementView elt)
    {
        addComponentToGrid(elt, elt.getE().getInformation().getX(), elt.getE().getInformation().getY());
    }

}
