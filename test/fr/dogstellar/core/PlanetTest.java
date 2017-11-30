package fr.dogstellar.core;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * The test class PlanetTest.
 *
 * @author  G3
 * @version V01
 */
public class PlanetTest
{
    //the construction of the areas
    AreaPlanet area1;
    AreaPlanet area2;
    AreaPlanet area3;
    Planet planet1;
    Planet planet3;
    
    
    /**
     * Default constructor for test class PlanetTest
     */
    public PlanetTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        area1 = new AreaPlanet("Area1", "TheArea1", System.getProperty("user.dir") + "/pictures/champ.jpg");
        area2 = new AreaPlanet("Area2", "TheArea2", System.getProperty("user.dir") + "/pictures/champ.jpg");
        area3 = new AreaPlanet("Area2", "TheArea2", System.getProperty("user.dir") + "/pictures/champ.jpg");
        planet1 = new Planet("MyPlanet", "MyDescriptionofThePlanet");
        planet3 = new Planet("MyPlanet3", "MyDescriptionofThePlanet");
    }
 
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

     @Test
     /**
     * Search an existing area
      *
      */
     public void searchExistingArea()
     {	
         String planetName = "Area1";
         planet1.addArea(area1);
         assertEquals(true, planet1.searchArea(planetName));
     }
    
     @Test
     /**
      * Search an unexisting area
      *
      */
     public void searchUnexistingArea()
     {
     	String planetName= "Toto";
        Planet planet1 = new Planet("MyPlanet", "MyDescriptionofThePlanet");
        planet1.addArea(area1);
        assertEquals(false,planet1.searchArea(planetName));
     }
    
     @Test
     /**
      * Try to add an existing area with an already existing name to the list.
      * When we search it, we find only the area2
      *
      */
     public void addAreaOnOccupedPlanet()
     {	
         Planet planet1 = new Planet("MyPlanet", "MyDescriptionofThePlanet");
         planet1.addArea(area1);
         planet1.addArea(area2);
      	 assertEquals(false,planet1.searchArea(area2.getInformation().getName()));
     }
     	
     @Test
     /**
     * Add a normal area.
     *
     */
     public void addUnexistingArea()
     {
        planet3.addArea(area2);
        assertEquals(true, planet3.searchArea(area2.getInformation().getName()));
     }
     
     @Test
     /**
      * Test the getAreas method
      */
     public void goodAreaGetter ()
     {
         planet3.addArea(area1);
         assertEquals(area1, planet3.getAreas());
     }
     
     @Test
     /**
      * Test the getInformation method
      */
     public void goodInfoGetter ()
     {
         assertEquals("MyPlanet", planet3.getInformation().getName());
     }

 
}