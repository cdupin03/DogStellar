package fr.dogstellar.core;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * The test class PlayerTest. A player have a name, a number of LifePoint and number of AttackPoint and an inventory (inherit to perso)
 * He can use the stuff in the inventory to equipped him
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


