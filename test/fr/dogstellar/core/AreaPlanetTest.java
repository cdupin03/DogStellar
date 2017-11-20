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
     * Test the setter for the south area with uncorrect value.
     */
    public void setterWrong()
    {
        areaPlan1.addAreaPlanet(areaPlan2, "SOUTH");
        assertEquals(null, areaPlan1.getArea("SOUTH"));
    }

    @Test
    /**
     * Test the values of all the guetters with uncorect values .
     */
    public void wrongGetters()
    {
        areaPlan1.addAreaPlanet(areaPlan2, "NORTH");
        areaPlan1.addAreaPlanet(areaPlan3, "WEST");
        areaPlan1.addAreaPlanet(areaPlan4, "EAST");
        areaPlan1.addAreaPlanet(areaPlan5, "SOUTH");
        assertNotSame(areaPlan4, areaPlan1.getArea("EAST"));
        assertNotSame(areaPlan2, areaPlan1.getArea("NORTH"));
        assertNotSame(areaPlan5, areaPlan1.getArea("SOUTH"));
        assertNotSame(areaPlan3, areaPlan1.getArea("WEST"));
    }
}




