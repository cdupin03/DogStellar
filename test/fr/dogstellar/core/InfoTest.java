package fr.dogstellar.core;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class InfoTest.
 *
 * @author G3
 * @version V02
 */
public class InfoTest {

    private Info badInfo;
    private Info goodInfo;
    private Info planetInfo;

    /**
     * Default constructor for test class InfoTest
     */
    public InfoTest() {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() {
        badInfo = new Info("Ma", "Goo", -8, 9);			//a bad Info object
        goodInfo = new Info("Mark", "Good Info", 3, 3);   //a good Info object   
        planetInfo = new Info ("Planet", "planetType");
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown() {
    }

    @Test
    /**
     * Test if the program remove space before name.
     */
    public void spaceBeforeName() {
        Info info1 = new Info(" Julien", "Test", 5, 5);
        assertEquals("Julien", info1.getName());
    }

    @Test
    /**
     * Test if the program remove space after name.
     */
    public void spaceAfterName() {
        Info info1 = new Info("Julien ", "Test", 5, 5);
        assertEquals("Julien", info1.getName());
    }

    @Test
    /**
     * Test if the program remove space before description.
     */
    public void spaceBeforeDescription() {
        Info info1 = new Info("Julien", " Test", 5, 5);
        assertEquals("Test", info1.getDescription());
    }

    @Test
    /**
     * Test if the program remove space after description.
     */
    public void spaceAfterDescription() {
        Info info1 = new Info("Julien", "Test ", 5, 5);
        assertEquals("Test", info1.getDescription());
    }

    @Test
    /**
     * Test if the Getters work with correct values.
     */
    public void okGetter() {
        assertEquals("Mark", goodInfo.getName());
        assertEquals("Good Info", goodInfo.getDescription());
        assertEquals(3, goodInfo.getX());
        assertEquals(3, goodInfo.getY());
    }

    @Test
    /**
     * Test if the Getters work with uncorrect values.
     */
    public void wrongGetters() {
        assertEquals("No Name", badInfo.getName());
        assertEquals("No Description", badInfo.getDescription());
        assertEquals(3, badInfo.getX());
        assertEquals(3, badInfo.getY());
    }
    
    @Test
    /**
     * Chech the second constructor without x or y. The value of x and y attended
     * are -1.
     */
    public void coordonatePlanet ()
    {
        assertEquals(-1, planetInfo.getX());
        assertEquals(-1, planetInfo.getX());
    }

}
