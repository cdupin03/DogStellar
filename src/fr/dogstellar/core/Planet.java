package fr.dogstellar.core;
import java.util.*;
import java.util.HashMap.*;

import com.sun.corba.se.impl.oa.poa.ActiveObjectMap.Key;

/**
 * Write a description of class Planet here.
 *
 * @author G3
 * @version V03
 */
public class Planet
{
    // instance variables - replace the example below with your own
    private AreaPlanet areas;    //all the areas are defined by the main area
    private Info information;               //the name and the description store in an object of Info type

    /**
     * Constructor for objects of class Planet
     */
    public Planet(String newName, String newDescription)
    {
        information = new Info(newName, newDescription);
    }

    /**
     * To add area to the planet
     *
     * @param  newArea is the area to add
     */
    public void addArea(AreaPlanet newArea)
    {
        this.areas = newArea;       
    }
    
    /**
     * To remove an area to the planet
     *
     * @param  newArea is the area to remove
     */
    public void removeArea()
    {
        this.areas = null;       
    }
    
     /**
     // * Search an area name in the list if
      *  the area is present in the hashmap a boolean with the true value will be returned
     // *@param name ( a string containing the name of the aera than the user is looking for)
     // */
     public boolean searchArea(String name)
     {  
    	 return (areas.getAreaPlanet().containsKey(name));
    
     }
    

}
