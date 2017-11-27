package fr.dogstellar.core;
/**
 * This class allows us to manage the element that interact 
 * with the player (like the enigme, trap, people, chest).
 *
 *
 * @author Gp3
 * @version V0
 */
public class Element
{
    // instance variables - replace the example below with your own
    private Info information; //informations of the Element
    private boolean Done; //Identifier for the already used object 
    private int type; //The type of objet :1- enigme,2- trap,3- people,4- chest
    /**
     * This method is the constructor. 
     * It initialize the value of the Element. 
     * Give a name and a description to info attribute
     */
    public Element(String name, String description, int newType )
    {
    information = new Info(name, description);
    type = newType;
    Done = false;
    }

    /**
     * This method allows us to resolve an enigma
     * (an enigma is find in the chest or given by a people)
     * 
     * The answer of the object is his description, and his enigma is his name.
     * You enter the answer of the player in the parameter, with the player involve in the parameter and
     * the stuff to win. If the answer match the description the player win and the player earn the object. 
     * Else the player win nothing. 
     * 
     * 
     * @param reponse the reponse of the player
     * @perso the perso which answer
     * @return true if the enigma is solved
     */
    public boolean resolveEnigma(String reponse, Player player, Stuff stuff)
    {
        if (reponse == information.getDescription()) 
        {System.out.print("Bravo! vous avez trouver la bonne solution!");    
        System.out.print("vous avez gagner :" + stuff.getInformation ().getName());
        player.addStuff(stuff,1);
        return true;
        }
        else  
        {System.out.print("Dommage !" + reponse + "N'est pas la solution a cette enigme !");
        return false;}
        
        
    }
    
    /**
     * This method allows us to delete a lifePoint
     * when the player meet a trap
     * 
     */
    public void lostLifePoint(Perso perso, int lost)
    {
    perso.decreaseLifePoint(lost);    
    }
    
    /**
     * Method getInformation
     * get the info of the class.
     *
     * @return the information of the class
     */
    public Info getInformation()
    {
        return this.information;
    }
    
    public boolean getDone()
    {
        return this.Done;
    }

    public int getType() {
        return type;
    }
    
    
    
    
    public void setDonee()
    {
        Done = true;
    }
    
}
