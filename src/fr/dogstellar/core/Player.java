package fr.dogstellar.core;
import java.util.*;

import javax.sound.midi.VoiceStatus;

/**
 * The class Player. A player have a name, a number of LifePoint and number of AttackPoint and an inventory (inherit to perso)
 * He can use the stuff in the inventory to equipped him
 *
 * @author Gp3
 * @version 21/11/2017
 */
public class Player extends Perso
{
    private Armor armor;
    private Weapon weapon;
    /**
     * Constructor for objects of class Player
     * When a player is creating, a inventory (list of stuffs) is create and is empty
     * @param nameP corresponds to the name of the player
     */
    public Player(String nameP, int lifePoint, int attackPoint)
    {
        super(nameP,lifePoint, attackPoint);
        inventory = new ArrayList();
    }
    
    /**
     * this method allows to equip the player with a armor
     * @param armorEquip
     */
    public void addArmorEquip(Armor armorEquip)
    {
    	armor=armorEquip;
    }
    
    /**
     * This method returns the list of stuff(inventory) of the user.
     *
     */
    public ArrayList<Stuff> getStuff() 
    {
        return (inventory);
    }

 
    public void desequipArmor() 
    {
        addStuff((Stuff)armor,1);
    	armor=null;
    }
    public void desequipWeapon() 
    {
        this.addStuff((Stuff)weapon,1);
    	weapon=null;
    }
 
    /*
     * this method allows us to equip the player with a weapon
     * @param weaponEquip
     */
    public void addWeaponEquip(Weapon weaponEquip)
    {
    	weapon=weaponEquip;
    	increaseAttackPoint(weapon.getDamage());

    }
    
    /**
     * this method allows us to get the armor that the player has been equipped
     */
    public Armor getArmorEquip() {
    	return armor;
    }
    
    /**
     * this method allows us to get the weapon that the player has been equipped
     */
    public Weapon getWeaponEquip() {
    	return weapon;
    } 
    
    /**
     * this method allows to know if the player has a armor or not
     * @return true or false
     */
    public boolean hasArmor ()
    {
    	if (armor==null) {
    		return(false);
    	}else {
    		return(true);
		}
    		
    }
    
    /**
     * this method allows to know if the player has a armor or not
     * @return true or false
     */
    public boolean hasWeapon ()
    {
    	if (weapon==null) {
    		return(false);
    	}else {
    		return(true);
		}
    		
    }
    
    /**
	 * The player attack a monster(Perso) with a number of attackPoint
	 * @param attackPoint it is the number of attackPoint that it decided to play
	 * @param monster it is a Perso who fighting with the player
	 */
	public void playerFight(Perso monster, int attackPoint)
	{
		monster.decreaseLifePoint(attackPoint);
	}
}
