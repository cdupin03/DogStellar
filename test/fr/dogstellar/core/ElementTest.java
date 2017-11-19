package fr.dogstellar.core;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ElementTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ElementTest
{
    /**
     * Default constructor for test class ElementTest
     */
    Element element1;
    Player player;
    Weapon weap;
    
    public ElementTest()
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
        element1 = new Element("Papier", "C'est un papier");
        player = new Player("Jean-Louis");
        weap = new Weapon("weapon", "Sword of life", 3);
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
     * Method NormalConstructor
     * Test the normal behavior of the constructor
     */
    @Test
    public void NormalConstructor()
    {
        assertEquals("Papier", element1.getInformation().getName());
        assertEquals("C'est un papier", element1.getInformation().getDescription());
    }
    
    /**
     * Method LostLifePoint
     * Test if the perso really last lifePoint
     */
    @Test
    public void LostLifePoint ()
    {
        element1.lostLifePoint(player, 3);
        assertEquals(7, player.getLifePoint());
    }
    
    /**
     * Method ResolveEnigma
     * Test if the enigma return true when it is a good area
     */
    @Test
    public void ResolveEnigma ()
    {
        assertEquals(true, element1.resolveEnigma("C'est un papier", player, weap));
    }
    
    /**
     * Method WrongEnigma
     * Test if the enigma detects when the response is wrong.
     */
    @Test
    public void WrongEnigma ()
    {
        assertEquals(false, element1.resolveEnigma("C'est un", player, weap));
    }
}

