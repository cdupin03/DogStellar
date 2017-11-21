package fr.dogstellar.core;


//import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.*;

/**
* The planet class contain a information attribute (name+description) and the main area
*
* @author G3
* @version V03
*/
public class Planet
{
  // instance variables - replace the example below with your own
  private AreaPlanet areas;    //all the areas are defined by the main area 
  private Info information;               //the name and the description store in an object of Info type setted by the information class constructor

  /**
   * Constructor for objects of class Planet the only setted attributes are the informations
   */
  public Planet(String newName, String newDescription)
  {
      information = new Info(newName, newDescription);
  }

  /**
   * To add area to the planet
   * The system test if there is not always an area if yes the adding is aborted. 
   * @param  newArea is the area to add
   */
  public void addArea(AreaPlanet newArea)
  {
          if(this.areas==null){
              this.areas = newArea;}  
          else {System.out.println("There is always an areas in the planet remove it before adding");}
  }
  
  /**
   * To remove an area to the planet
   *
   * @param  newArea is the area to remove
   */
  public void removeArea(String name)
  { 
      this.areas = null;       
  }
  
   /**
    * Search an area name in the list 
    *  the area is present in the hashmap 
    * @param name ( a string containing the name of the area than the user is looking for)
    * @return true if there is a area of the same name than looked for in the hashmap esle return false
    */
   public boolean searchArea(String name)
   {  
       if(areas.getNameArea().equals(name))
          return true;
       else if(areas.searchAreaPlanet(name)) 
          return true;
       else
          return false;
   }
  

}