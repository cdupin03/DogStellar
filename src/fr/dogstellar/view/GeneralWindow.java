/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.dogstellar.view;

import fr.dogstellar.core.Planet;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author alexandre
 */
public abstract class GeneralWindow extends JPanel {
    
    
    private HashMap<Integer,Component> components; //The coordinates (xxyy) linked to a component (arrow for example)
    private int height;//The number of column
    private int length;//The number of lines	private final String picturePath;
    private String nameOfFirstBackgroundPicture;
    private final String picturePath;
    private Image back;
    private final JFrame interfac;
    
    public GeneralWindow (JFrame inter)
	{
            super();
            interfac = inter;
            picturePath = System.getProperty("user.dir") + "/pictures/";
            nameOfFirstBackgroundPicture = "champ.jpg";
            catchPicture ();
            components = new HashMap<>();
            setHeight(7);
            setLength(13); 
	}
    
    /**
     * Generate a key to the hashmap with the x and y parameter
     * @param x the x coordonates
     * @param y the y coordonates
     * @return the key in the hashmap.
     */
    protected int generateKey (int x, int y)
    {
            return x*100+y;
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
    protected void addComponentToGrid(Component comp, int x, int y)
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
    protected void drawGrid ()
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
    protected void erraseGrid()
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
    * Add the comp to the grid at a random place. If the place is not
    * accessible it redirects to the next place available.
    * @param comp the component to add randomly
    */
   protected void addRandomlyComponent (Component comp)
   {
           Random r = new Random();
           int x = r.nextInt(length-2);//Take x between 0 and length-2
           int y = r.nextInt(height-2);//Take y between 0 and height-2
           x++;
           y++;
           addComponentToGrid(comp, x, y);
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
   /**
    * getter of FirstBackgroundPicture
    * @return nameOfFirstBackgroundPicture the path of the background picture of the panel
    */
    public String getNameOfFirstBackgroundPicture() {
        return nameOfFirstBackgroundPicture;
    }
    
    /**
     * Set the nameOfFirstBackgroundPicture
     * @param nameOfFirstBackgroundPicture the path of the background picture of the panel
     */
    public void setNameOfFirstBackgroundPicture(String nameOfFirstBackgroundPicture) {
        this.nameOfFirstBackgroundPicture = nameOfFirstBackgroundPicture;
    }
    
    /**
     * Get the picture of the background
     * @return the picture of the background
     */
    public Image getBack() {
        return back;
    }
    
    /**
     * Set the background image.
     * @param back The background image
     */
    public void setBack(Image back) {
        this.back = back;
    }
    
    /**
     * get the components
     * @return the components
     */
    public HashMap<Integer, Component> getComponentsMap() {
        return components;
    }
    /**
     * Get the height of the window
     * @return height
     */
    public int getHeightGrid() {
        return height;
    }
    
    /**
     * Get the length of the window
     * @return length
     */
    public int getLengthGrid() {
        return length;
    }
    
    /**
     * get the picture path of the picture folder
     * @return picturePath
     */
    public String getPicturePath() {
        return picturePath;
    }
    
    /**
     * get the Interface which contain the window
     * @return interfac
     */
    public JFrame getInterfac() {
        return interfac;
    }
   
   
    /**
     * draw the background of this panel.
     */
    @Override
    public void paintComponent(Graphics g)
    {
        g.drawImage(back,0,0,this.getWidth(),this.getHeight(),this);
    }
    
    protected void catchPicture ()
    {
            try 
            {
                back = ImageIO.read(new File(getPicturePath() + getNameOfFirstBackgroundPicture()));
                System.out.println(getPicturePath() + getNameOfFirstBackgroundPicture());
                //draw
            }
            catch (IOException e) 
            {
                e.printStackTrace();
            }

    }

    
}
