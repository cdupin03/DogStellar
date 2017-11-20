package fr.dogstellar.core;
import java.util.*;

/**
 * This class gives the characteristics of the player (name lifePoint, attackPoint and inventory).
 * This class is an inheritance of the Perso class which we added a inventory that is a list of Stuffs.
 *
 * @author Gp3
 * @version 20/11/2017
 */
public class Player extends Perso
{
    private ArrayList<Stuff> inventory;
    
    /**
     * Constructor for objects of class Player
     * When a player is creating, a inventory (list of stuffs) is create and is empty
     * @param nameP corresponds to the name of the player
     */
    public Player(String nameP)
    {
        super(nameP,10,10);
        inventory = new ArrayList();
    }

    /**
     * this method allows us to add a stuff in the list of stuff (the inventory) of the player when he wins a stuff
     * we can add several same stuff
     *
     * @param  Stuff is the name of the stuff
     * @param numberStuffAdd is a number of stuff that we add to the inventory when the player win it
     */
    public void addStuff(Stuff stuff, int numberStuffAdd)
    {
        for (int n=0; n<numberStuffAdd; n++){
            inventory.add(stuff);
        }
    }
    
    /**
     * this method allows us to delete a stuff in the list of stuff (inventory) of the player when he lost a stuff
     * we can delete only one Stuff with this method
     *
     * @param  stuff is the name of the stuff
     */
    public void deleteStuff(Stuff stuff)
    {   
        for(Stuff s : inventory){
             if(s==stuff){
                 inventory.remove(stuff);
                 break;
             }
        }
    }
    
    /**
     * This method returns the list of stuff(inventory) of the user.
     *
     */
    public ArrayList<Stuff> getStuff()
    {
        return(inventory);
    }
    
    /**
     * This method allows us to know if a stuff is in inventory or not.
     */
    public boolean isInList(Stuff stuff)
    {
        for(Stuff s : inventory){
             if(s==stuff){
                 return(true);
             }
        }
        return(false);
    }
}
