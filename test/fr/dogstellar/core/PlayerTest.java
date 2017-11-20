package fr.dogstellar.core;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * The test class PlayerTest. A player have a name, a number of LifePoint and number of AttackPoint and an inventory.
 *
 * @author  GP3
 * @version 20/11/2017
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
     * We test if the Potion1 have been correctly add to the inventory.
     * At the end of test, Potion1 is in the inventory
     */
    @Test
    public void goodAddStuff()
    {
        Player player1 = new Player("Player1");
        Potion potion1 = new Potion("Potion1","Donne 2 points",1);
        player1.addStuff(potion1, 2);
        assertEquals(true, player1.isInList(potion1));
    }
    
    /**
     * We test if we cannot add a bad stuff.
     * So we expected an error if we add Potion2 among Potion1.
     * Potion2 must not be to the inventory.
     */
    @Test
    public void badAddStuff()
    {
        Player player1 = new Player("Player1");
        Potion potion1 = new Potion("Potion1","Donne 2 points",1);
        Potion potion2 = new Potion("Potion2","Donne 3 points",1);
        player1.addStuff(potion1, 1);
        assertEquals(false, player1.isInList(potion2));
    }
    
    /**
     * We test if we delete correctly the stuff.
     * So potion1 that was added is not in the list after the delete.
     */
    @Test
    public void goodDeleteStuff()
    {
        Player player1 = new Player("Player1");
        Potion potion1 = new Potion("Potion1","Donne 2 points",2);
        player1.addStuff(potion1, 1);
        player1.deleteStuff(potion1);
        assertEquals(false, player1.isInList(potion1));
    }
    
    /**
     * We test if we delete correctly 1 stuff and not 2 stuff.
     * So 2 potion1 are added and only 1 potion1 is delete.
     * So, at the end of test, 1 potion1 is in list.
     */
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


