package fr.dogstellar.core;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
        area1 = new AreaPlanet("Area1", "TheArea1");
        area2 = new AreaPlanet("Area2", "TheArea2");
        area3 = new AreaPlanet("Area2", "TheArea2");
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

    // @Test
    // /**
     // * Search an existing area
     // *
     // */
    // public void searchExistingArea()
    // {
        // Planet planet1 = new Planet("MyPlanet", "MyDescriptionofThePlanet");
        // planet1.addArea(area1);
        // planet1.addArea(area2);
        // assertEquals(true, planet1.searchArea(area2.getInformation().getName()));
    // }
    
    // @Test
    // /**
     // * Search an unexisting area
     // *
     // */
    // public void searchUnexistingArea()
    // {
        // Planet planet1 = new Planet("MyPlanet", "MyDescriptionofThePlanet");
        // planet1.addArea(area1);
        // planet1.addArea(area2);
        // assertEquals(false, planet1.searchArea("toto"));
    // }
    
    // @Test
    // /**
     // * Try to add an existing area with an already existing name to the list.
     // * When we search it, we find only the area2
     // *
     // */
    // public void addExistingArea()
    // {
        // Planet planet1 = new Planet("MyPlanet", "MyDescriptionofThePlanet");
        // planet1.addArea(area1);
        // planet1.addArea(area2);
        // planet1.addArea(area3);
        // //for(AreaPlanet i : planet1.areas)
        // //planet1.searchArea(area3.getInformation().getName();
        
        // assertEquals(true, planet1.searchArea(area3.getInformation().getName()));
        // //true test but this is not the area3, it is the area2
    // }
    
    // @Test
    // /**
     // * Add a normal area.
     // *
     // */
    // public void addUnexistingArea()
    // {
        // Planet planet1 = new Planet("MyPlanet", "MyDescriptionofThePlanet");
        // planet1.addArea(area1);
        // planet1.addArea(area2);
        // assertEquals(true, planet1.searchArea(area2.getInformation().getName()));
    // }

    @Test
    public void addExistingMethod()
    {
    }

    @Test
    public void addExistingArea()
    {
    }
}



