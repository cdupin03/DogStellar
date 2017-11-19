package fr.dogstellar.core;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class WeaponTest.
 * Test if the Weapon class work
 * @author  (G3)
 * @version (01)
 */
public class WeaponTest
{Weapon weapon1;
    /**
     * Default constructor for test class WeaponTest
     */
    public WeaponTest()
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
        Weapon weapon1 = new Weapon("","",7); 
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
     * Create a Weapon with value and test if the values enter are right
     * The test success if the information enter match
     *
     */
    @Test
    public void test_weapon()
    {
        Weapon weapon1 = new Weapon("gun", "that a weapon for sure", 7);
        assertEquals("gun", weapon1.getInformation().getName());
        assertEquals("that a weapon for sure", weapon1.getInformation().getDescription());
        assertEquals(7, weapon1.getDamage());
    }
    
    /**
     * Create a Weapon with value and test if the values of damage can be set under 1
       * 
       * The test success if the damage value is 1
     *
     */
    @Test
    public void test_weapon_less()
    {
        Weapon weapon1 = new Weapon("gun", "that a weapon for sure", 0);
        assertEquals(1, weapon1.getDamage());
    }
    
      /**
       * Create a Weapon with value and test if the values of damage can be set above 16
       * 
       * The test success if the damage value is 1
       *
       */
      @Test
    public void test_weapon_more()
    {
        Weapon weapon1 = new Weapon("gun", "that a weapon for sure", 16);
        assertEquals(1, weapon1.getDamage());
    }
    
}




