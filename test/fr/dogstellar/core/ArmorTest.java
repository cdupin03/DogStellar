package fr.dogstellar.core;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ArmorTest.
 * Test if the ArmorTest class work
 * @author  (G3)
 * @version (01)
 */
public class ArmorTest
{
    
    /**
     * Default constructor for test class ArmorTest
     */
    public ArmorTest()
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

    /**
     * Create a Armor with value and test if the values enter are right
     * The test success if the information enter match
     *
     */
    @Test
    public void armortest()
    {
        Armor armor2 = new Armor("bouclier", "A wise choice", 15);
        armor2.getInformation().getName();
        assertEquals("bouclier", armor2.getInformation().getName());
        assertEquals("A wise choice", armor2.getInformation().getDescription());
        assertEquals(15, armor2.getArmorPoint ());
    }
    
     /**
      * Create a Armor with value and test if the values of armor can be set above 70
       * 
       * The test success if the armor value is 1
      */
     @Test
    public void armortest_more()
    {
        Armor armor2 = new Armor("bouclier", "A wise choice", 70);                
        assertEquals(1, armor2.getArmorPoint ());
    }
    
      /**
       * Create a Armor with value and test if the values of armor can be set under 1
       * 
       * The test success if the armor value is 1
       *
       */
      @Test
    public void armortest_less()
    {
        Armor armor2 = new Armor("bouclier", "A wise choice", 0);                
        assertEquals(1, armor2.getArmorPoint ());
    }
}

