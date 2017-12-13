package fr.dogstellar.core;

import java.util.*;

/**
 * The class Player. A player have a name, a number of LifePoint and number of
 * AttackPoint and an inventory (inherit to perso) He can use the stuff in the
 * inventory to equipped him
 *
 * @author Gp3
 * @version 21/11/2017
 */
public class Player extends Perso {

    private Armor armor;                                    // The player armor
    private Weapon weapon;                                  // The player weapon
    private final ArrayList<Stuff> inventory;               // The list of player inventory

    /**
     * Constructor for objects of class Player When a player is creating, a
     * inventory (list of stuffs) is create and is empty
     *
     * @param nameP corresponds to the name of the player
     * @param lifePoint is the life of the player
     * @param attackPoint is the attack of the player
     */
    public Player(String nameP, int lifePoint, int attackPoint) {
        super(nameP, lifePoint, attackPoint);
        inventory = new ArrayList<>();
    }

    /**
     * this method allows to equip the player with a armor
     *
     * @param armorEquip is the armor to equip
     */
    public void addArmorEquip(Armor armorEquip) {
        armor = armorEquip;
    }

    /**
     * To desequip armor
     */
    public void desequipArmor() {
        addStuff((Stuff) armor, 1);
        armor = null;
    }

    /**
     * To desequip weapon
     */
    public void desequipWeapon() {
        increaseAttackPoint(-(weapon.getDamage()));
        this.addStuff((Stuff) weapon, 1);
        weapon = null;

    }

    /**
     * this method allows us to equip the player with a weapon
     *
     * @param weaponEquip is the player weapon to equip
     */
    public void addWeaponEquip(Weapon weaponEquip) {
        weapon = weaponEquip;
        increaseAttackPoint(weapon.getDamage());

    }

    /**
     * this method allows us to get the armor that the player has been equipped
     *
     * @return armor is the player equiped armor
     */
    public Armor getArmorEquip() {
        return armor;
    }

    /**
     * this method allows us to get the weapon that the player has been equipped
     *
     * @return weapon is the player equiped weapon
     */
    public Weapon getWeaponEquip() {
        return weapon;
    }

    /**
     * this method allows to know if the player has a armor or not
     *
     * @return true or false
     */
    public boolean hasArmor() {
        if (armor == null) {
            return (false);
        } else {
            return (true);
        }

    }

    /**
     * this method allows to know if the player has a armor or not
     *
     * @return true or false
     */
    public boolean hasWeapon() {
        if (weapon == null) {
            return (false);
        } else {
            return (true);
        }

    }

    /**
     * this method allows us to add a stuff in the list of stuff (the inventory)
     * of the player when he wins a stuff we can add several same stuff
     *
     * @param stuff is the name of the stuff
     * @param numberStuffAdd is a number of stuff that we add to the inventory
     * when the player win it
     */
    public void addStuff(Stuff stuff, int numberStuffAdd) {
        for (int n = 0; n < numberStuffAdd; n++) {
            inventory.add(stuff);
        }
    }

    /**
     * this method allows us to delete a stuff in the list of stuff (inventory)
     * of the player when he lost a stuff we can delete only one Stuff with this
     * method
     *
     * @param stuff is the name of the stuff
     */
    public void deleteStuff(Stuff stuff) {
        for (Stuff s : inventory) {
            if (s == stuff) {
                inventory.remove(stuff);
                break;
            }
        }
    }

    /**
     * To get the stuff of the monster
     *
     * @return inventory = the list of Stuff
     */
    public ArrayList<Stuff> getStuff() {
        return inventory;
    }

    /**
     * This method returns the list of stuff(inventory) of the user.
     *
     */
    public void displayStuff() {
        for (Stuff stuff : inventory) {
            System.out.println(stuff.getInformation().getName());
        }
    }

    /**
     * This method allows us to know if a stuff is in inventory or not.
     *
     * @param stuff = the stuff to compare at the list
     * @return true if the stuff is in the inventory
     */
    public boolean isInList(Stuff stuff) {
        for (Stuff s : inventory) {
            if (s == stuff) {
                return (true);
            }
        }
        return (false);
    }

    /**
     * The player attack a monster(Perso) with a number of attackPoint
     *
     * @param attackPoint it is the number of attackPoint that it decided to
     * play
     * @param monster it is a Perso who fighting with the player
     */
    public void playerFight(Perso monster, int attackPoint) {
        monster.decreaseLifePoint(attackPoint);
    }

    /**
     * To get the number of quest element (part of ship)
     *
     * @return compteurQuestElement = the nomber of quest element
     */
    public int getNumberQuestElement() {
        int compteurQuestElement = 0;
        for (Stuff s : this.getStuff()) {
            if (s instanceof QuestElement) {
                compteurQuestElement++;
            }
        }
        return compteurQuestElement;
    }
    
    /**
     * this method allows us to set the armor equiped by the player
     * @param armor 
     */
        public void setArmor(Armor armor) {
            this.armor = armor;
        }

}
