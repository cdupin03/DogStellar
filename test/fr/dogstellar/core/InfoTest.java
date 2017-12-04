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
        badInfo = new Info("Ma", "Goo");			//a bad Info object
        goodInfo = new Info("Mark", "Good Info");   //a good Info object   
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
        Info info1 = new Info(" Julien", "Test");
        assertEquals("Julien", info1.getName());
    }

    @Test
    /**
     * Test if the program remove space after name.
     */
    public void spaceAfterName() {
        Info info1 = new Info("Julien ", "Test");
        assertEquals("Julien", info1.getName());
    }

    @Test
    /**
     * Test if the program remove space before description.
     */
    public void spaceBeforeDescription() {
        Info info1 = new Info("Julien", " Test");
        assertEquals("Test", info1.getDescription());
    }

    @Test
    /**
     * Test if the program remove space after description.
     */
    public void spaceAfterDescription() {
        Info info1 = new Info("Julien", "Test ");
        assertEquals("Test", info1.getDescription());
    }

    @Test
    /**
     * Test if the Getters work with correct values.
     */
    public void okGetter() {
        assertEquals("Mark", goodInfo.getName());
        assertEquals("Good Info", goodInfo.getDescription());
    }

    @Test
    /**
     * Test if the Getters work with uncorrect values.
     */
    public void wrongGetters() {
        assertEquals("No Name", badInfo.getName());
        assertEquals("No Description", badInfo.getDescription());
    }

}
