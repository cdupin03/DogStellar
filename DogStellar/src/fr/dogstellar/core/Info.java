package fr.dogstellar.core;

/**
 * The basic informations name and description for some objects.
 * It contains a name which need to be superior to three characters
 * and a description need to be superior to four characters 
 * 
 *
 * @author G3
 * @version V03
 */
public class Info
{
    //The name of the object, must be superior to three characters.
    private String name; 
    //The overall description of the object, must be superior to 4 characters.
    private String description;

    /**
     * Constructor for objects of class Info
     * Initialize the infos of an object.
     * @param new name, new descritpion
     */
    public Info (String name, String description)
    {
        // initialise instance variables
        setName(name);
        setDescription(description);
    }

    /**
     * Method setName
     * set the name of the object, only called by the constructor.
     * If the name is bad, the value of "Name" is set
     * 
     * @param name The new name to set.
     */
    public void setName (String name)
    {
        if(name.trim().length()>=3)
            this.name = name.trim();
        else
            this.name = "Name";
    }
    
    /**
     * Method setDescription
     * set the description of the object, only called by the constructor.
     * If the description is bad, the value of "Description" is set.
     * 
     * @param description the new description to set.   
     */
    public void setDescription (String description)
    {
        if(description.trim().length()>=4)
            this.description = description.trim();
        else
            this.description = "Description";
    }
    
    /**
     * Method getName
     * get the name of the object
     * @return the name.
     */
    public String getName ()
    {
        return name;
    }
    
    /**
     * Method getDescription
     * get the description of the object
     *
     * @return The description
     */
    public String getDescription ()
    {
        return description;
    }
    
    
}
