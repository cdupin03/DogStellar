package fr.dogstellar.view;

import fr.dogstellar.core.*;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * The general window allows to display the map and the element on the map
 *
 * @author Group 3
 * @version V01
 */
public abstract class GeneralWindow extends JPanel {

    private HashMap<Integer, Component> components;                             //The coordinates (xxyy) linked to a component (arrow for example)
    private int height;                                                         //The number of column
    private int length;                                                         //The number of lines	private final String picturePath;
    private String nameOfFirstBackgroundPicture;                                //The name of the first background
    private final String picturePath;                                           //The path of the pictures
    private Image back;                                                         //The back Image
    private final Interface interfac;                                           //The interface that display this window
    protected String theCurrentZone;
    
    /**
     * The constructor of the GeneralWindow Class
     *
     * @param inter is the interface
     */
    public GeneralWindow(Interface inter) {
        super();                                                                //Call the JPanel constructor
        interfac = inter;                                                       //Initialize the Interfac attribut with the inter parameter
        picturePath = System.getProperty("user.dir") + "/pictures/";            //Initialize the path pictures
        nameOfFirstBackgroundPicture = "";                                      //Initialize the name of the background
        components = new HashMap<>();                                           //Instanciate the HashMap which displays the elements 
        setHeight(7);                                                           //The Height of the HashMap 
        setLength(13);                                                          //The Length of the HashMap
    }

    /**
     * Generate a key to the hashmap with the x and y parameter
     *
     * @param x the x coordonates
     * @param y the y coordonates
     * @return (x * 100 + y) = the key in the hashmap.
     */
    protected int generateKey(int x, int y) {
        return x * 100 + y;
    }

    /**
     * Allow to add a component to components (hashmap). Avoid to put component
     * in the block adjacent to the borders. If the block is already taken, it
     * put the component to the adjacent available block recursively.
     *
     * @param comp The component to add
     * @param x the x coordonate
     * @param y the y coordonate
     */
    protected void addComponentToGrid(Component comp, int x, int y) {
        if (x < 1) {
            x = 1;
        } else if (x > length - 1) {
            x = 1;
            y++;
        }
        if (y < 1 || y > height - 1) {
            y = 1;
        }

        int key = generateKey(x, y);

        if (components.containsKey(key)) {
            addComponentToGrid(comp, x + 1, y);
        } else {
            components.put(key, comp);
        }

    }

    /**
     * Add each element previously put in the components map to the Window.
     */
    protected void drawGrid() {
        this.removeAll();
        this.setLayout(new GridLayout(height, length));

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < length; x++) {
                int key = generateKey(x, y);
                if (components.containsKey(key)) {
                    this.add(components.get(key));
                } else {
                    this.add(new JLabel());
                }
            }
        }
        interfac.getInterface().pack();
    }

    /**
     * Erase the component in the components hashmap. Keep the arrows.
     */
    protected void erraseGrid() {
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
    public void newGrid() {
        erraseGrid();
        drawGrid();

    }

    /**
     * Set the number of line of the grid. If h <0 or >100 it is initialized to
     * 3 If the h is pair, it is incremented
     *
     * @param h the height
     */
    private void setHeight(int h) {
        if (h > 0 && h < 100) {
            height = h;
        } else {
            height = 3;
        }
    }

    /**
     * Set the number of column of the grid. If l <0 or >100 it is initialized
     * to 3 If the l is pair, it is incremented
     *
     * @param l the length
     */
    private void setLength(int l) {
        if (l > 0 && l < 100) {
            length = l;
        } else {
            length = 3;
        }
    }

    /**
     * Add the comp to the grid at a random place. If the place is not
     * accessible it redirects to the next place available.
     *
     * @param comp the component to add randomly
     */
    protected void addRandomlyComponent(Component comp) {
        Random r = new Random();
        int x = r.nextInt(length - 2);//Take x between 0 and length-2
        int y = r.nextInt(height - 2);//Take y between 0 and height-2
        x++;
        y++;
        addComponentToGrid(comp, x, y);
    }

    /**
     * Call the function setEnabled(ena) of all componenents in the map. If it
     * is true, the arrow is enabled, so it is colored and clickable If it is
     * false, the arrow is disabled, so it is greyed and not clickable
     *
     * @param ena If true enable if false disable.
     */
    public void setAllComponentEnabled(boolean ena) {
        components.entrySet().stream().forEach((e) -> {
            e.getValue().setEnabled(ena);
        });
    }

    /**
     * getter of FirstBackgroundPicture
     *
     * @return nameOfFirstBackgroundPicture is the path of the background
     * picture of the panel
     */
    public String getNameOfFirstBackgroundPicture() {
        return nameOfFirstBackgroundPicture;
    }

    /**
     * Set the nameOfFirstBackgroundPicture
     *
     * @param nameOfFirstBackgroundPicture is the path of the background picture
     * of the panel
     */
    public void setNameOfFirstBackgroundPicture(String nameOfFirstBackgroundPicture) {
        this.nameOfFirstBackgroundPicture = nameOfFirstBackgroundPicture;
    }

    /**
     * Get the picture of the background
     *
     * @return back is the picture of the background
     */
    public Image getBack() {
        return back;
    }

    /**
     * Set the background image.
     *
     * @param back The background image
     */
    public void setBack(Image back) {
        this.back = back;
    }

    /**
     * Get the components
     *
     * @return components the components
     */
    public HashMap<Integer, Component> getComponentsMap() {
        return components;
    }

    /**
     * Get the height of the window
     *
     * @return height = The height of the window
     */
    public int getHeightGrid() {
        return height;
    }

    /**
     * Get the length of the window
     *
     * @return length = The length of the window
     */
    public int getLengthGrid() {
        return length;
    }

    /**
     * get the picture path of the picture folder
     *
     * @return picturePath is the path of the picture folder
     */
    public String getPicturePath() {
        return picturePath;
    }

    /**
     * get the Interface which contain the window
     *
     * @return interfac is the Interface which contain the window
     */
    public Interface getInterfac() {
        return interfac;
    }

    /**
     * draw the background of this panel.
     */
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(back, 0, 0, this.getWidth(), this.getHeight(), this);
    }

    /**
     * Allows to get the picture of the area.
     *
     * @param newArea the new Area to display
     */
    protected void catchPicture() {
        try {
            back = ImageIO.read(new File(getPicturePath() + getNameOfFirstBackgroundPicture()));
            //draw
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Call the function setEnabled(ena) of all arrows of Window If it is true,
     * the arrow is enabled, so it is colored and clickable If it is false, the
     * arrow is disabled, so it is greyed and not clickable
     *
     * @param ena If true enable if false disable.
     */
    public abstract void setEnableArrows(boolean ena);
    
    public String getCurrentArea()
    {
        return theCurrentZone;
    }

}
