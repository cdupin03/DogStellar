package fr.dogstellar.core;
import java.util.*;

/**
 * This class gives the characteristics of the player.
 * This class is an inheritance of the Perso class 
 * which we added a inventory that is a list of Stuffs.
 *
 * @author Gp3
 * @version V0
 */
public class Player extends Perso
{
    private ArrayList<Stuff> inventory;
    
    /**
     * Constructor for objects of class Player
     */
    public Player(String nameP)
    {
        super(nameP,10,10);
        inventory = new ArrayList();
    }

    /**
     * this method allows us to add a stuff in the list of stuff
     * of the player when he wins a stuff
     *
     * @param  nameStuff is the name of the stuff
     * @param numberStuffAdd is a number of stuff that we add to the
     * inventary when the player win it
     */
    public void addStuff(Stuff stuff, int numberStuffAdd)
    {
        for (int n=0; n<numberStuffAdd; n++){
            inventory.add(stuff);
        }
    }
    
    /**
     * this method allows us to delete a stuff in the list of stuff
     * of the player when he lost a stuff
     *
     * @param  nameStuff is the name of the stuff
     * @param numberStuffDelete is a number of stuff that we add to the
     * inventary when the player win it
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
     * This method returns the list of equipment of the character.
     *
     */
    public ArrayList<Stuff> getStuff()
    {
        return(inventory);
    }
    
    /**
     * This method display the list of equipment of the character.
     * // Cette methode est bidon (c'est pour le moment pout les tests)
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
