package fr.dogstellar.core;

/**
 *  A piece of armor for a player. 
 *  The armor point should be superior to 1 and inferior to 25.
 *  The player loose armor point before lifePoint.
 *  If the armor drop to 0, the player loose the armor.
 *
 * @author (G3)
 * @version (01)
 */
public class Armor extends Stuff
{
    // the number of armor point given to the player. 
    //It should be inferior to 1 and superior to 15.
    int armorPoint;
    /**
     * Constructor for objects of class Weapon
     * The constructor of the Weapon.  A piece of armor for a player.
     * The armor point should be superior to 1 and inferior to 25.
     * The player loose armor point before lifePoint.
     * If the armor drop to 0, the player loose the armor.
     * 
     * @param name the name of the armor
     * @param description the description of the armor
     * @param point the number armor point
     */
    public Armor (String name, String description,int point)
    {
        super(name, description);
        setArmorPoint(point);
    }

    /**
     * Method setDamage
     * set the armor point to point value. 
     * If point has not a good value set the armor of 1.
     *
     * @param dam The damage
     */
    private void setArmorPoint (int arm)
    {
        if (arm < 1 || arm >25)
        {
            armorPoint = 1;
        }
        else
        {
            armorPoint = arm;
        }
    }
    
    /**
     * Method getDamage
     * get the remaining armor  
     *
     * @return the remaining armor  
     */
    public int getArmorPoint ()
    {
        return armorPoint;
    }
}
