package fr.dogstellar.core;

/**
 * This class represent a potion which add life point when drunk.
 * LifePoint must be between 1 and 13. If a wrong value is given,
 * the lifePoint is initialized to 1. 
 * 
 *
 * @author (G3)
 * @version (01)
 */
public class Potion extends Stuff
{
    //The number of potion carried by the player. 
    private int lifePoint;
    
    /**
     * Potion Constructor
     * Initialize a potion object
     * The name and the description is managed by the info class.
     * If the point is inferior to 0 or superior to 13, the lifePoint given is initialized to 1.
     * 
     * @param name the name of the potion
     * @param description the description of the potion
     * @param point the life point given by the potion
     */
    public Potion(String name, String description, int point)
    {
        super(name, description);
        if (point <1 || point > 13 )
        {
            lifePoint = 1;
        }
        else
        {
            lifePoint = point;
        }
    }
    
    
     /**
     * Method drinkPotion
     * Add life points to the perso’s life and remove the potion from the perso’s inventory.
     * @param perso the perso which drink potion
     */
     public void drinkPotion(Player play)
    {
         
        play.increaseLifePoint(lifePoint);
        play.deleteStuff(this);
    }

    /**
     * Method getNbPotion
     *  return the lifePoint given by the potion

     * 
     * @return the number of health point given
     */
    public int getLifePoint()
    {
        return lifePoint;
    }
    
}
