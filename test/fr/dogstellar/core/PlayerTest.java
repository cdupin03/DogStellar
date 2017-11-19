package fr.dogstellar.core;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PlayerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PlayerTest
{
    /**
     * Default constructor for test class PlayerTest
     */
    public PlayerTest()
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

    @Test
    public void goodAddStuff()
    {
        Player player1 = new Player("Player1");
        Potion potion1 = new Potion("Potion1","Donne 2 points",1);
        player1.addStuff(potion1, 2);
        assertEquals(true, player1.isInList(potion1));
    }
    
    @Test
    public void badAddStuff()
    {
        Player player1 = new Player("Player1");
        Potion potion1 = new Potion("Potion1","Donne 2 points",1);
        Potion potion2 = new Potion("Potion2","Donne 3 points",1);
        player1.addStuff(potion1, 1);
        assertEquals(false, player1.isInList(potion2));
    }
    
    @Test
    public void goodDeleteStuff()
    {
        Player player1 = new Player("Player1");
        Potion potion1 = new Potion("Potion1","Donne 2 points",2);
        player1.addStuff(potion1, 1);
        player1.deleteStuff(potion1);
        assertEquals(false, player1.isInList(potion1));
    }
    
    @Test
    public void deleteStuffAmong2()
    {
        Player player1 = new Player("Player1");
        Potion potion1 = new Potion("Potion1","Donne 2 points",0);
        player1.addStuff(potion1, 2);
        player1.deleteStuff(potion1);
        assertEquals(true, player1.isInList(potion1));
    }
}


