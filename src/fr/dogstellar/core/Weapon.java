package fr.dogstellar.core;

/**
 *  A weapon is a piece of stuff. It gives attack points to the player.
 *
 * @author (G3)
 * @version (01)
 */
public class Weapon extends Stuff
{
    // the number of attack point given to the player.
    //It cannot be inferior to 1 and superior to 15.
    private int damage;

    /**
     * Constructor for objects of class Weapon
     * The constructor of the Weapon. The int damage is given as parameter.
     * It cannot be changed after.
     * 
     * @param name The name of the object
     * @param description The description of the object 
     * 
     */
    public Weapon (String name, String description,int damage)
    {
        super( name, description );
        setDamage(damage);
    }

    /**
     * Method setDamage
     * set the damage of the weapon if the dam is not good,
     * set the damage to 1.

     *
     * @param dam The damage
     */
    private void setDamage (int dam)
    {
        if (dam <= 0 || dam >= 16) 
        {
            damage = 1;}
        else 
        {    
        damage = dam;
        }
    }
    
    /**
     * Method getDamage
     * get the damage
     *
     * @return the damage value
     */
    public int getDamage ()
    {
        return damage;
    }
}
