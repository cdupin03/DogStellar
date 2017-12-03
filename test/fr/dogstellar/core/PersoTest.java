package fr.dogstellar.core;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * The test class PersoTest. He has a name, a number of LifePoint and number of
 * AttackPoint and an inventory.
 *
 * @author GP3
 * @version 20/11/2017
 */
public class PersoTest {

    Perso perso1;
    Perso mauvais;

    /**
     * Default constructor for test class PersoTest
     */
    public PersoTest() {
    }

    /**
     * We test the creation of a new perso with good parameters (a name and no
     * negative lifePoint and attackPoint)
     */
    @Test
    public void normalPerso() {
        perso1 = new Perso("Perso1", 10, 10);
        assertEquals("Perso1", perso1.getNamePerso());
        assertEquals(10, perso1.getLifePoint());
        assertEquals(10, perso1.getAttackPoint());
    }

    /**
     * In this test, there is no name for the Perso The default name is Perso1
     */
    @Test
    public void noNamePerso() {
        mauvais = new Perso("", 10, 10);
        assertEquals("Perso1", mauvais.getNamePerso());
    }

    /**
     * Test with a negative lifePoint When we want to create a Perso and there
     * is a negative number for lifePoint, the number is initialized with 10
     * lifePoint
     */
    @Test
    public void noNegativeLifePoint() {
        mauvais = new Perso("Perso1", -2, 10);
        assertEquals(10, mauvais.getLifePoint());
    }

    /**
     * Test with a negativeAttackPoint When we want to create a Perso and there
     * is a negative number for attackPoint, the number is initialized with 10
     * attackPoint
     */
    @Test
    public void noNegativeAttackPoint() {
        mauvais = new Perso("Perso1", 10, -2);
        assertEquals(10, mauvais.getAttackPoint());
    }

    /**
     * Test if the modification of LifePoint is well working The new LifePoint
     * is 3 so perso1 have 3 lifePoint at this end of the test
     */
    @Test
    public void setterLifePointOk() {
        Perso perso1 = new Perso("Perso1", 1, 10);
        perso1.setLifePoint(3);
        assertEquals(3, perso1.getLifePoint());
    }

    /**
     * If we want to decrease lifePoint and the result in under 0, the variable
     * is automatically egals to 0.
     */
    @Test
    public void decreaseInNegativeLifePoint() {
        Perso perso1 = new Perso("Perso1", 1, 10);
        perso1.decreaseLifePoint(2);
        assertEquals(0, perso1.getLifePoint());
    }

    /**
     * If we want to decrease attackPoint and the result in under 0, the
     * variable is automatically egals to 0.
     */
    @Test
    public void decreaseInNegativeAttackPoint() {
        Perso perso1 = new Perso("Perso1", 10, 1);
        perso1.decreaseAttackPoint(2);
        assertEquals(0, perso1.getAttackPoint());
    }

    /**
     *
     */
    @Test
    public void monsterFight() {
        Perso perso1 = new Perso("Perso1", 10, 1);
        perso1.displayInfoPerso();
        assertEquals(0, perso1.getAttackPoint());
    }

    /**
     * We test if the Potion1 have been correctly added to the inventory. At the
     * end of test, Potion1 is in the inventory
     */
    @Test
    public void goodAddStuff() {
        Player player1 = new Player("Player1", 5, 5);
        Potion potion1 = new Potion("Potion1", "Donne 2 points", 1);
        player1.addStuff(potion1, 2);
        assertEquals(true, player1.isInList(potion1));
    }

    /**
     * We test if the player1 have been correctly added to the player1. At the
     * end of test, Potion1 is in the inventory
     */
    @Test
    public void addPlayerStuff() {
        Player player1 = new Player("Player1", 5, 5);
        Potion potion1 = new Potion("Potion1", "Donne 2 points", 1);
        player1.addStuff(potion1, 2);
        assertEquals(player1, potion1.getPlayer());
    }

    /**
     * We test if we cannot add a bad stuff. So we expected an error if we add
     * Potion2 among Potion1. Potion2 must not be to the inventory.
     */
    @Test
    public void badAddStuff() {
        Player player1 = new Player("Player1", 5, 5);
        Potion potion1 = new Potion("Potion1", "Donne 2 points", 1);
        Potion potion2 = new Potion("Potion2", "Donne 3 points", 1);
        player1.addStuff(potion1, 1);
        assertEquals(false, player1.isInList(potion2));
    }

    /**
     * We test if when a stuff is deleted, the stuff does not contain the player
     * anymore. The potion need to contain a "null" instead of player.
     */
    @Test
    public void removePlayerFromPotion() {
        Player player1 = new Player("Player1", 5, 5);
        Potion potion1 = new Potion("Potion1", "Donne 2 points", 1);
        player1.addStuff(potion1, 1);
        player1.deleteStuff(potion1);
        assertEquals(null, potion1.getPlayer());
    }

    /**
     * We test if when two stuffs are added and just one deleted The stuff still
     * has the player as owner.
     */
    @Test
    public void twoStuffsOnePlayer() {
        Player player1 = new Player("Player1", 5, 5);
        Potion potion1 = new Potion("Potion1", "Donne 2 points", 1);
        player1.addStuff(potion1, 2);
        player1.deleteStuff(potion1);
        assertEquals(player1, potion1.getPlayer());
    }

    /**
     * We test if we delete correctly the stuff. So potion1 that was added is
     * not in the list after the delete.
     */
    @Test
    public void goodDeleteStuff() {
        Player player1 = new Player("Player1", 5, 5);
        Potion potion1 = new Potion("Potion1", "Donne 2 points", 2);
        player1.addStuff(potion1, 1);
        player1.deleteStuff(potion1);
        assertEquals(false, player1.isInList(potion1));
    }

    /**
     * We test if we delete correctly 1 stuff and not 2 stuff. So 2 potion1 are
     * added and only 1 potion1 is delete. So, at the end of test, 1 potion1 is
     * in list.
     */
    @Test
    public void deleteStuffAmong2() {
        Player player1 = new Player("Player1", 5, 5);
        Potion potion1 = new Potion("Potion1", "Donne 2 points", 0);
        player1.addStuff(potion1, 2);
        player1.deleteStuff(potion1);
        assertEquals(true, player1.isInList(potion1));
    }
}
