package fr.dogstellar.core;

/**
 * The planet class contain a information attribute (name+description) and the
 * main area
 *
 * @author G3
 * @version V03
 */
public class Planet {
    // instance variables - replace the example below with your own

    private AreaPlanet areas;    //all the areas are defined by the main area 
    private final Info information;    //the name and the description store in an object of Info type setted by the information class constructor
    private final int nbQuestElement;  //The number of quest element needed to visit the planet

    /**
     * Constructor for objects of class Planet the only setted attributes are
     * the informations
     *
     * @param newName is the name to set at the player
     * @param newDescription is the description to set at the player
     * @param theNbQuestElement is the number ofquest element that the player owns
     */
    public Planet(String newName, String newDescription, int theNbQuestElement) {
        information = new Info(newName, newDescription);
        nbQuestElement = (theNbQuestElement < 0 ? 0 : theNbQuestElement);
    }

    /**
     * To add area to the planet The system test if there is not always an area
     * if yes the adding is aborted.
     *
     * @param newArea is the area to add
     */
    public void addArea(AreaPlanet newArea) {
        if (this.areas == null) {
            this.areas = newArea;
        } else {
            System.out.println("There is always an areas in the planet remove it before adding");
        }
    }

    /**
     * To remove an area to the planet
     *
     * @param name is the name of the area to remove
     */
    public void removeArea(String name) {
        this.areas = null;
    }

    /**
     * Search an area name in the list the area is present in the hashmap
     *
     * @param name ( a string containing the name of the area than the user is
     * looking for)
     * @return true if there is a area of the same name than looked for in the
     * hashmap esle return false
     */
    public boolean searchArea(String name) {
        if (areas.getNameArea().equals(name)) {
            return true;
        } else if (areas.searchAreaPlanet(name)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @return the main area of the planet.
     */
    public AreaPlanet getAreas() {
        return areas;
    }

    /**
     * @return the information from the planet.
     */
    public Info getInformation() {
        return information;
    }

    /**
     * Get the number of quest element needed to visit the planet
     *
     * @return nbQuestElement
     */
    public int getNbQuestElement() {
        return nbQuestElement;
    }

}
