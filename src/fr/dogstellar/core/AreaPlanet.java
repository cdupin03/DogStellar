package fr.dogstellar.core;
import java.util.*;
import java.util.Map;

/**
 * An area is a specific region in a planet (like a room in a home)
 *
 * @author G3
 * @version V03
 */
public class AreaPlanet
{
    // instance variables - replace the example below with your own
    private Info information;               //the name and the description store in a Info object 
    private HashMap<String, AreaPlanet> areas;
    private ArrayList<Element> elements;    //A list of elements
    Syste

    /**
     * Constructor for objects of class AreaPlanet
     * @ param name , descritption
     */
    public AreaPlanet(String newName, String newDescription)
    {
        information = new Info(newName, newDescription);
        areas = new HashMap<>();
    }

    /**
     * To get the area
     *
     * @return    the area
     */
    public AreaPlanet getArea(String theOrientation)
    {
        theOrientation = theOrientation.trim().toUpperCase();
        return areas.get(theOrientation);
    }
 
    /**
     * Define the north area. Every direction either leads to another area or is null (no exit there).
     *
     * @param  north, west, east, south are the different area around
     */
    public void addAreaPlanet(AreaPlanet theAreaToAdd, String theOrientation)
    {
        theOrientation = theOrientation.trim().toUpperCase();
        
        if(theOrientation.equals("NORTH") || theOrientation.equals("WEST") || theOrientation.equals("EAST") || theOrientation.equals("SOUTH"))
        {
            String oppositeOrientation = "";
            this.areas.put(theOrientation, theAreaToAdd);
                
            if(theOrientation.equals("NORTH"))
                oppositeOrientation = "SOUTH";
            if(theOrientation.equals("WEST"))
                oppositeOrientation = "EAST";
            if(theOrientation.equals("EAST"))
                oppositeOrientation = "WEST";
            if(theOrientation.equals("SOUTH"))
                oppositeOrientation = "NORTH";

            theAreaToAdd.areas.put(oppositeOrientation, this);
        }
    }
    
    /**
     * To add an element into the area.
     *
     * @param  newElement is the element to add
     */
    public void addElement(Element newElement)
    {
        elements.add(newElement);
    }
    
    /**
     * To add an element into the area.
     *
     * @param  newElement is the element to add
     */
    public void removeElement(Element newElement)
    {
        elements.remove(newElement);
    }
    
    /**
     * To show all elements in the area.
     *
     */
    public void displayElement()
    {
        for(Element i : elements)
        {
            System.out.println("Name of the element : " + i.getInformation().getName());
            System.out.println("    Description : " + i.getInformation().getDescription());
        }
    }
    
    /**
     * To get all the infos.
     *
     */
    public Info getInformation()
    {
        return information;
    }
    
    /**
     * Display the name and the orientation of all areas connected to the current area
     *
     */
    public void getAreasConnected()
    {    
        for (HashMap.Entry<String, AreaPlanet> currentArea: areas.entrySet())
        {
            System.out.printf("Orientation : " + currentArea.getKey() + " / ");
            System.out.printf("Name : "+currentArea.getValue().getInformation().getName());
        }
    }
}
