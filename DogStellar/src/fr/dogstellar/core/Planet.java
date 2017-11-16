package fr.dogstellar.core;
import java.util.*;

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
     * @param  newArea is the area to add
     */
    public void removeArea()
    {
        this.areas = null;       
    }
    
    // /**
     // * Search an area name in the list
     // *
     // */
    // public int searchArea(String name)
    // {
        // int compteur = 0;
        // for(AreaPlanet i : areas)
        // {
            // if(i.getInformation().getName().equals(name))
                // compteur += 1;
        // }
        // return compteur;
    // }
    

}
