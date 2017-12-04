package fr.dogstellar.core;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PotionTest.
 *
 * @author (G3)
 * @version (01)
 */
public class PotionTest {

    Potion po; // A good potion

    /**
     * Sets up the test fixture. Initialize the po potion. Called before every
     * test case method.
     */
    @Before
    public void setUp() {
        po = new Potion("Popo Robineau", "Meilleure potion ever", 7);
    }

    /**
     * Method goodPotion Check if when a good potion is made, the right number
     * of lifePoint is set to the object. Potion constructor normal
     */
    @Test
    public void goodPotion() {
        assertEquals(7, po.getLifePoint());
    }

    /**
     * Method shortPotion Potion constructor with less than 1 lifePoint Check if
     * when a potion is created with too few healthpoint, the healthpoint is
     * analyze to 1.
     */
    @Test
    public void shortPotion() {
        Potion popo = new Potion("Popo nulle", "Pire potion ever", 0);
        assertEquals(1, popo.getLifePoint());
    }

    /**
     * Method tooBigPotion Test if a too big potion is initialized to 1 lp.
     * Check if when a potion is created with too much healthpoint, the
     * healthpoint is analyze to 1.
     */
    @Test
    public void tooBigPotion() {
        Potion popo = new Potion("Popo cheaté", "Best potion ever", 10000);
        assertEquals(1, popo.getLifePoint());
    }

    /**
     * Method wellDrink Test if a potion drinking well raise the number of
     * perso's LifePoint
     *
     */
    @Test
    public void wellDrink() {
        Player player = new Player("Jean-Louis", 10, 5);
        player.addStuff(po, 1);
        player.decreaseLifePoint(9);
        po.drinkPotion(player);
        assertEquals(8, player.getLifePoint());
    }

//    /**
//     * Check if the player added is the player contained in the potion. Test the
//     * stuff class.
//     */
//    @Test
//    public void playerWellAdded() {
//        Player player = new Player("Jean-Louis", 5, 5);
//        player.addStuff(po, 1);
//        assertEquals(player, po.getPlayer());
//    }
}
