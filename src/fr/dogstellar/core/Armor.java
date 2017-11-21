package fr.dogstellar.core;

/**
 *  A piece of armor for a player. 
 *  The armor point should be superior to 1 and inferior to 25.
 *  If the player take damage and wear an armor, then the armor take the incoming damage 
 *  and loose armorPoint equivalent to the damage taken. 
 *  The armor behave as a upgrade of the lifepoint of the player.
 *  
 *  If the armor drop to 0, the player loose the armor.
 *  
 *
 * @author (G3)
 * @version (01)
 */
public class Armor extends Stuff
{
    // the number of armor point given to the player. 
    //It should be inferior to 25 and superior to 1.
    int armorPoint;
    /**
     * Constructor for objects of class Armor
     * The constructor of the  Armor.  A piece of armor for a player.
     * The armor point should be superior to 1 and inferior to 25.
     * If an armor is created with armorPoint outside the range (1,25) then the armor is 
     * created with 1 armorPoint
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
     * Method setArmorPoint
     * set the armorPoint value. 
     * If the armorPoint is outside the range (1,25) then the armor is 
     * then the armorPoint is set to one. 
     * 
     * @param arm The armor point
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
     * Method getArmorPoint
     * get the remaining armor  
     *
     * @return the remaining armor  
     */
    public int getArmorPoint ()
    {
        return armorPoint;
    }
}
