package fr.dogstellar.core;

import java.util.*;

/**
 * An area is a specific region in a planet (like a room in a home)
 *
 * @author G3
 * @version V04
 */
public class AreaPlanet
{
    private Info information;                   //the name and the description store in a Info object 
    private HashMap<String, AreaPlanet> areas;  //the hashmap allows to store the attached area to the current area
    private ArrayList<Element> elements;        //the list of elements in the current area like quest, chest, pieces...
    private ArrayList<Perso> persos;            //the list of persos in the current area (player or monsters)

    /**
     * Constructor for objects of class AreaPlanet
     *
     * @param name is the name of the area
     * @param descritption is the description of the area
     */
    public AreaPlanet(String newName, String newDescription)
    {
        information = new Info(newName, newDescription);    //call the constructor of the Info class
        areas = new HashMap<>();                            //instanciation of the hashmap
        elements = new ArrayList<Element>();                //instanciation of the list of element
        persos = new ArrayList<Perso>();                    //instanciation of the list of persos
    }

    /**
     * To get the area
     *
     * @return the area
     */
    public AreaPlanet getArea(String theOrientation)
    {
        theOrientation = theOrientation.trim().toUpperCase();
        return areas.get(theOrientation);
    }
 
    /**
     * Define every direction either leads to another area or leave it empty.
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
     * @param  newElement is the element to add to the list of element
     */
    public void addElement(Element newElement)
    {
        elements.add(newElement);
    }
    
    /**
     * To search an element into the area.
     *
     * @param  theElement is the element to search in the list of element
     * @return if the element exist in the list
     */
    public boolean searchElement(Element theElement)
    {
        for(Element i : elements)
        {
            if(i.equals(theElement))
                return true;
        }
        return false;
    }
    
    /**
     * To remove an element into the area.
     *
     * @param  theElement is the element to remove to the list of element
     */
    public void removeElement(Element theElement)
    {
        elements.remove(theElement);
    }
    
    /**
     * To show all elements in the area. A listing of all element
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
     * @return the object Info (his name and the description)
     */
    public Info getInformation()
    {
        return information;
    }
    
    /**
     * To get the name of the Area.
     *
     * @return the name of the Area
     */
    public String getNameArea()
    {
        return this.information.getName();
    }
    
    /**
     * To get the name of the Area.
     *
     * @return the name of the Area
     */
    public String getDescriptionArea()
    {
        return this.information.getDescription();
    }
    
    /**
     * Display the name and the orientation of all areas connected to the current area
     *
     */
    public void displayAreasConnected()
    {    
        for (HashMap.Entry<String, AreaPlanet> currentArea: areas.entrySet())
        {
            System.out.printf("Orientation : " + currentArea.getKey() + " / ");
            System.out.printf("Name : "+currentArea.getValue().getInformation().getName());
        }
    }
    
    /**
     * Getter of the areas of the planet
     *
     * @return areas is the hashmap of the areas around
     */
    public HashMap<String,AreaPlanet> getAreaPlanet()
    {    
        return areas;
    }
    
    /**
     * Getter of the areas of the planet
     *
     * @return areas is the hashmap of the areas around
     */
    public boolean searchAreaPlanet(String theName)
    {    
        for(Map.Entry<String, AreaPlanet> i : areas.entrySet())
        {
            AreaPlanet value = i.getValue();
            if(value.getNameArea().equals(theName))
                return true;
        }
        return false;
    }
    
    /**
     * To add a perso into the area.
     *
     * @param  newPerso is the perso to add to the list of persos
     */
    public void addPerso(Perso newPerso)
    {
        persos.add(newPerso);
    }
    
    /**
     * To search an Perso into the area.
     *
     * @param  thePerso is the perso to search in the list of persos
     * @return true if the perso exist in the list
     */
    public boolean searchPerso(Perso thePerso)
    {
        for(Perso i : persos)
        {
            if(i.equals(thePerso))
                return true;
        }
        return false;
    }
    
    /**
     * To remove an element into the area.
     *
     * @param thePerso is the perso to remove to the list of persos
     */
    public void removePerso(Perso thePerso)
    {
        persos.remove(thePerso);
    }
    
    /**
     * To search an Perso into the area.
     *
     * @param  thePerso is the perso to search in the list of persos
     * @return true if the perso exist in the list
     */
    public void displayPersos()
    {
        for(Perso i : persos)
        {
                System.out.println(i.getNamePerso());
        }
    }

}