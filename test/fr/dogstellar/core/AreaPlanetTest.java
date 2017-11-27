package fr.dogstellar.core;
 
import static org.junit.Assert.*;

import java.util.ArrayList;

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
    Perso perso1;
    Perso perso2;
    ArrayList <Element> elems;
    ArrayList<Perso> persos;
    
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
        areaPlan1 = new AreaPlanet("Zone", "Test1", System.getProperty("user.dir") + "/pictures/champ.jpg");
        areaPlan2 = new AreaPlanet("Zone1", "Test2", System.getProperty("user.dir") + "/pictures/champ.jpg");
        areaPlan3 = new AreaPlanet("Zone2", "Test3", System.getProperty("user.dir") + "/pictures/champ.jpg");
        areaPlan4 = new AreaPlanet("Zone3", "Test4", System.getProperty("user.dir") + "/pictures/champ.jpg");
        areaPlan5 = new AreaPlanet("Zone4", "Test5", System.getProperty("user.dir") + "/pictures/champ.jpg");
        elem1 = new Element("TheElement1", "MyElementOne", false);
        elem2 = new Element("TheElement2", "MyElementTwo", false);
        elems = new ArrayList<Element>();
        elems.add(elem1);
        elems.add(elem2);
        areaPlan1.addElement(elem1);
        perso1 = new Perso("Player1",10, 10);
        perso2 = new Perso("Player2",10, 10);
        persos = new ArrayList<Perso>();
        persos.add(perso1);
        persos.add(perso2);
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
        assertEquals("Zone1", areaPlan2.getNameArea());
        assertEquals("Test2", areaPlan2.getDescriptionArea());
        assertEquals(areaPlan4, areaPlan1.getArea("EAST"));
        assertEquals(areaPlan2, areaPlan1.getArea("NORTH"));
        assertEquals(areaPlan5, areaPlan1.getArea("SOUTH"));
        assertEquals(areaPlan3, areaPlan1.getArea("WEST"));
        assertEquals(System.getProperty("user.dir") + "/pictures/champ.jpg", areaPlan1.getPicture());
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
    
    @Test
    /**
     * To search a perso to the list and if the perso exists, it returns true
     */
    public void searchAPersoToTheList()
    {
        areaPlan1.addPerso(perso1);
        assertEquals(true, areaPlan1.searchPerso(perso1));
    }

    @Test
    /**
     * Add an element to the list 
     */
    public void addAPersoToTheList()
    {
        areaPlan1.addPerso(perso1);
        assertEquals(true, areaPlan1.searchPerso(perso1));
    }

    @Test
    /**
     * Remove a perso to the list
     */
    public void removeAPersoToTheList()
    {
        areaPlan1.addPerso(perso1);
        assertEquals(true, areaPlan1.searchPerso(perso1));
        areaPlan1.removePerso(perso1);
        assertEquals(false, areaPlan1.searchPerso(perso1));
    }
    
    @Test
    /**
     * Test if the list of perso is the expected one.
     */
    public void goodListPerso ()
    {
    	areaPlan1.getPerso().clear();
    	for (Perso p : persos)
    	{
    	areaPlan1.addPerso(p);
    	}
    	assertEquals(true, persos.equals(areaPlan1.getPerso()));
    }
    
    @Test
    /**
     * Test if the list of element is the expected one.
     */
    public void goodListElem ()
    {
    	areaPlan1.getElement().clear();
    	for (Element e : elems)
    	{
    		areaPlan1.addElement(e);
    	}
    	assertEquals(true, elems.equals(areaPlan1.getElement()));
    }
    
    
}
