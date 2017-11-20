package fr.dogstellar.core;
 


import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class AreaPlanetTest.
 *
 * @author  G3
 * @version V01
 */
public class AreaPlanetTest
{
    AreaPlanet areaPlan1;
    AreaPlanet areaPlan2;
    AreaPlanet areaPlan3;
    AreaPlanet areaPlan4;
    AreaPlanet areaPlan5;
    Element elem1;
    Element elem2;
    
    /**
     * Default constructor for test class AreaPlanetTest
     */
    public AreaPlanetTest()
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
        areaPlan1 = new AreaPlanet("Zone", "Test1");
        areaPlan2 = new AreaPlanet("Zone1", "Test2");
        areaPlan3 = new AreaPlanet("Zone2", "Test3");
        areaPlan4 = new AreaPlanet("Zone3", "Test4");
        areaPlan5 = new AreaPlanet("Zone4", "Test5");
        elem1 = new Element("TheElement1", "MyElementOne");
        elem2 = new Element("TheElement2", "MyElementTwo");
        areaPlan1.addElement(elem1);
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
     * Test the setter for the south area with correct value.
     */
    public void setterOk()
    {
        areaPlan1.addAreaPlanet(areaPlan2, "SOUTH");
        assertEquals(areaPlan2, areaPlan1.getArea("SOUTH"));
    }

    @Test
    /**
     * Test the values of all the getters with correct values .
     */
    public void okGetters()
    {
        areaPlan1.addAreaPlanet(areaPlan2, "NORTH");
        areaPlan1.addAreaPlanet(areaPlan3, "WEST");
        areaPlan1.addAreaPlanet(areaPlan4, "EAST");
        areaPlan1.addAreaPlanet(areaPlan5, "SOUTH");
        assertEquals(areaPlan4, areaPlan1.getArea("EAST"));
        assertEquals(areaPlan2, areaPlan1.getArea("NORTH"));
        assertEquals(areaPlan5, areaPlan1.getArea("SOUTH"));
        assertEquals(areaPlan3, areaPlan1.getArea("WEST"));
    }

    @Test
    /**
     * To search an element to the list and if the element exists, it returns true
     */
    public void searchAnElementToTheList()
    {
        assertEquals(true, areaPlan1.searchElement(elem1));
    }

    @Test
    /**
     * Add an element to the list 
     */
    public void addAnElementToTheList()
    {
        areaPlan1.addElement(elem2);
        assertEquals(true, areaPlan1.searchElement(elem2));
    }

    @Test
    /**
     * Remove an element to the list
     */
    public void removeAnElementToTheList()
    {
        areaPlan1.addElement(elem2);
        assertEquals(true, areaPlan1.searchElement(elem2));
        areaPlan1.removeElement(elem2);
        assertEquals(false, areaPlan1.searchElement(elem2));
    }
}
