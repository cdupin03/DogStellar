package fr.dogstellar.core;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PotionTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PotionTest
{
    Potion po;
    /**
     * Default constructor for test class PotionTest
     */
    public PotionTest()
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
        po = new Potion("Popo Robineau","Meilleure potion ever", 7);
    }

    
    /**
     * Method goodPotion
     * Potion constructor normal
     */
    @Test
    public void goodPotion ()
    {
        assertEquals(7,po.getLifePoint());
    }
    
    /**
     * Method shortPotion
     * Potion constructor with less than 1 lifePoint
     */
    @Test
    public void shortPotion ()
    {
        Potion popo = new Potion("Popo nulle","Pire potion ever", 0);
        assertEquals(1, popo.getLifePoint());
    }
    
    /**
     * Method tooBigPotion
     * Test if a too big potion is initialized to 1 lp.
     */
    @Test
    public void tooBigPotion ()
    {
        Potion popo = new Potion("Popo cheaté","Best potion ever", 10000);
        assertEquals(1, popo.getLifePoint());
    }
    
    /**
     * Method wellDrink
     * Test if a potion drinking well raise the number of perso's LifePoint
     *
     */
    @Test
    public void wellDrink ()
    {
       Player player = new Player("Jean-Louis");
       player.decreaseLifePoint(9);
       po.drinkPotion(player);
       assertEquals(8, player.getLifePoint());
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
}
