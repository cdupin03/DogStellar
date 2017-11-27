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
     * We test if the Potion1 have been correctly added to the inventory.
     * At the end of test, Potion1 is in the inventory
     */
    @Test
    public void goodAddStuff()
    {
        Player player1 = new Player("Player1",5,5);
        Potion potion1 = new Potion("Potion1","Donne 2 points",1);
        player1.addStuff(potion1, 2);
        assertEquals(true, player1.isInList(potion1));
    }
    
    /**
     * We test if the player1 have been correctly added to the player1.
     * At the end of test, Potion1 is in the inventory
     */
    @Test
    public void addPlayerStuff()
    {
    	Player player1 = new Player("Player1",5,5);
        Potion potion1 = new Potion("Potion1","Donne 2 points",1);
        player1.addStuff(potion1, 2);
        assertEquals(player1, potion1.getPlayer());
    }
    
    
    /**
     * We test if we cannot add a bad stuff.
     * So we expected an error if we add Potion2 among Potion1.
     * Potion2 must not be to the inventory.
     */
    @Test
    public void badAddStuff()
    {
        Player player1 = new Player("Player1",5,5);
        Potion potion1 = new Potion("Potion1","Donne 2 points",1);
        Potion potion2 = new Potion("Potion2","Donne 3 points",1);
        player1.addStuff(potion1, 1);
        assertEquals(false, player1.isInList(potion2));
    }
    
    /**
     * We test if when a stuff is deleted, the stuff does not contain the player anymore.
     * The potion need to contain a "null" instead of player.
     */
    @Test
    public void removePlayerFromPotion ()
    {
        Player player1 = new Player("Player1",5,5);
        Potion potion1 = new Potion("Potion1","Donne 2 points",1);
        player1.addStuff(potion1, 1);
        player1.deleteStuff(potion1);
        assertEquals(null, potion1.getPlayer());
    }
    
    
    /**
     * We test if when two stuffs are added and just one deleted
     * The stuff still has the player as owner.
     */
    @Test
    public void twoStuffsOnePlayer ()
    {
        Player player1 = new Player("Player1",5,5);
        Potion potion1 = new Potion("Potion1","Donne 2 points",1);
        player1.addStuff(potion1, 2);
        player1.deleteStuff(potion1);
        assertEquals(player1, potion1.getPlayer());
    }
    
    /**
     * We test if we delete correctly the stuff.
     * So potion1 that was added is not in the list after the delete.
     */
    @Test
    public void goodDeleteStuff()
    {
        Player player1 = new Player("Player1",5,5);
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
        Player player1 = new Player("Player1",5,5);
        Potion potion1 = new Potion("Potion1","Donne 2 points",0);
        player1.addStuff(potion1, 2);
        player1.deleteStuff(potion1);
        assertEquals(true, player1.isInList(potion1));
    }
    
    /** 
     * Test if the armor is well add to the player equipment
     */
    @Test
    public void goodAddArmorEquip()
    {
        Player player1 = new Player("Player1",5,5);
        Armor armor1 = new Armor("The armor1", "it is the armor2", 2);
        player1.addArmorEquip(armor1);
        assertEquals(true, player1.hasArmor());
    }
    
    /** 
     * Test if the weapon is well add to the player equipment
     */
    @Test
    public void goodAddWeaponEquip()
    {
        Player player1 = new Player("Player1",5,5);
        Weapon weapon1 = new Weapon("The weapon1", "it is the weapon2", 2);
        player1.addWeaponEquip(weapon1);
        assertEquals(true, player1.hasWeapon());
    }
    
    /** 
     * Test if the getter of armorEquip well return the armor of the Player equipment
     */
    @Test
    public void goodgetArmorEquip()
    {
        Player player1 = new Player("Player1",5,5);
        Armor armor1 = new Armor("The armor1", "it is the armor2", 2);
        player1.addArmorEquip(armor1);
        assertEquals(armor1, player1.getArmorEquip());
    }
    
    /** 
     * Test if the getter of weaponEquip well return the weapon of the Player equipment
     */
    @Test
    public void goodgetWeaponEquip()
    {
        Player player1 = new Player("Player1",5,5);
        Weapon weapon1 = new Weapon("The weapon1", "it is the weapon2", 2);
        player1.addWeaponEquip(weapon1);
        assertEquals(weapon1, player1.getWeaponEquip());
    }
    
    /** 
     * Test if the boolean return by the method hasArmor is the good boolean
     * true if the armor is equip
     */
    @Test
    public void goodHasArmor()
    {
        Player player1 = new Player("Player1",5,5);
        Armor armor1 = new Armor("The armor1", "it is the armor2", 2);
        player1.addArmorEquip(armor1);
        assertEquals(true, player1.hasArmor());
    }
    
    /** 
     * Test if the boolean return by the method hasWepon is the good boolean
     * true if the weapon is equip
     */
    @Test
    public void goodHasWeapon()
    {
        Player player1 = new Player("Player1",5,5);
        Weapon weapon1 = new Weapon("The weapon1", "it is the weapon2", 2);
        player1.addWeaponEquip(weapon1);
        assertEquals(true, player1.hasWeapon());
    }
    
    
}


