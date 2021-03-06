package fr.dogstellar.core;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ElementTest.
 *
<<<<<<< HEAD
 * @author (G3)
 * @version (1)
=======
 * @author Group 3
 * @version V02
>>>>>>> ea25e0a84d28c041198cb609fe6dba0bf15dcd1d
 */
public class ElementTest {

    Element element1;
    Player player;
    Weapon weap;

    /**
     * Sets up the test fixture.
     *
     * Create good objects for future tests.
     */
    @Before
    public void setUp() {

        element1 = new Element("Papier", "C'est un papier", 1,"test.png","test.png", 3, 4);
        player = new Player("Jean-Louis", 5, 5);
        weap = new Weapon("weapon", "Sword of life", 3);
    }

    /**
     * Method NormalConstructor Test the normal behavior of the constructor
     */
    @Test
    public void NormalConstructor() {
        assertEquals("Papier", element1.getInformation().getName());
        assertEquals("C'est un papier", element1.getInformation().getDescription());
        assertEquals(1, element1.getType());
    }

    /**
     * Method LostLifePoint Test if the perso really last lifePoint. player has
     * 5 lifePoint The element make the player lost 3 lifePoints Check if the
     * player really has 2 lifePoints after.
     */
    @Test
    public void LostLifePoint() {
        element1.lostLifePoint(player, 3);
        assertEquals(2, player.getLifePoint());
    }

    /**
     * Method ResolveEnigma Test if the enigma return true when the answer is
     * good.
     */
    @Test
    public void ResolveEnigma() {
        assertEquals(true, element1.resolveEnigma("C'est un papier", player));
    }

    /**
     * Method WrongEnigma Test if the enigma detects when the response is wrong.
     */
    @Test
    public void WrongEnigma() {
        assertEquals(false, element1.resolveEnigma("C'est un", player));
    }
}
