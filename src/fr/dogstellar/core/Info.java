package fr.dogstellar.core;

/**
 * The basic informations name and description for some objects. It contains a
 * name which need to be superior to three characters and a description need to
 * be superior to four characters. The coordonates must be superior (strictly) to 0
 * and inferior (strictly) to 7. If the coordonate is wrong it is set to 3 by default.
 * If the object has no coordonate (planet) they are set to -1.
 * 
 *
 *
 * @author G3
 * @version V04
 */
public final class Info {

    //The name of the object, must be superior to three characters with no spaces before and after.
    private String name;
    //The overall description of the object, must be superior to 4 characters with no space before and after.
    private String description;
    //The x coordonate of the object on the grid to display. Must be superior (strictly) to 0
    // and inferior (strictly) to 7. If the object has no coordonate (planet) set to -1.
    private int x;
    //The y coordonate of the object on the grid to display.Must be superior (strictly) to 0
    // and inferior (strictly) to 7 .If the object has no coordonate (planet) set to -1.
    private int y;

    /**
     * Constructor for objects of class Info Initialize the infos of an object.
     *
     * @param name is the name of the object
     * @param description is the description of the object
     * @param newX the x coordonate to set. Must be superior (strictly) to 0
     * and inferior (strictly) to 7
     * @param newY the y coordonate to set. Must be superior (strictly) to 0
     * and inferior (strictly) to 7
     */
    public Info(String name, String description, int newX, int newY) {
        setName(name);
        setDescription(description);
        setX(newX);
        setY(newY);
    }
    
    /**
     * Constructor for objects of class Info Initialize the infos of an object.
     * 
     * @param name is the name of the object
     * @param description is the description of the object
     */
    public Info(String name, String description)
    {
        setName(name);
        setDescription(description);
        x = -1;
        y = -1;
    }

    /**
     * Method setName set the name of the object, only called by the
     * constructor, must be superior to three characters, with no spaces before
     * and after. If the name is bad, the value of "No Name" is set.
     *
     * @param name the name of the object
     */
    public void setName(String name) {
        if (name.trim().length() >= 3) {
            this.name = name.trim();
        } else {
            this.name = "No Name";
        }
    }

    /**
     * Method setDescription set the description of the object, only called by
     * the constructor, must be superior to four characters, with no spaces
     * before and after. If the description is bad, the value of "No
     * Description" is set.
     *
     * @param description the description to set.
     */
    public void setDescription(String description) {
        if (description.trim().length() >= 4) {
            this.description = description.trim();
        } else {
            this.description = "No Description";
        }
    }

    /**
     * Method getName get the name of the object
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Method getDescription get the description of the object
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * get the x coordinate
     * @return x
     */
    public int getX() {
        return x;
    }
    
    /**
     * set the x coordonate.
     * The coordonates must be superior (strictly) to 0
     * and inferior (strictly) to 7. If the coordonate is wrong it is set to 3 by default.
     * @param newX the new value of x.
     */
    private void setX(int newX) {
        if (newX >0 && newX<7)
        {
           this.x = newX; 
        }
        else
        {
            this.x = 3;
        }
    }
    
    /**
     * get the y coordinate
     * @return y
     */
    public int getY() {
        return y;
    }

    /**
     * set the y coordonate.
     * The coordonates must be superior (strictly) to 0
     * and inferior (strictly) to 7. If the coordonate is wrong it is set to 3 by default.
     * @param newY the new value of x.
     */
    private void setY(int newY) {
        if (newY >0 && newY<7)
        {
           this.y = newY; 
        }
        else
        {
            this.y = 3;
        }
    }

}
