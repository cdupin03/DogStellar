package fr.dogstellar.core;

/**
 * This class allows us to manage the element that interact with the player
 * (like the enigme, trap, people, chest). The king of element is determined by
 * its type : 1- enigme,2- trap,3- people,4- chest
 *
 *
 * @author Gp3
 * @version V0
 */
public class Element {

    // instance variables - replace the example below with your own
    private final Info information; //informations of the Element
    private boolean done; //Identifier for the already used object 
    private final int type; //The type of objet :1- enigme,2- trap,3- people,4- chest
    private final Stuff reward; //The reward you may win

    /**
     * This method is the constructor. It initialize the value of the Element.
     * Give a name and a description to info attribute and their type, for
     * element that give no reward
     *
     * @param name is the name to set at the element
     * @param description is the description to set at the element
     * @param newType is the Type of the element
     */
    public Element(String name, String description, int newType) {
        information = new Info(name, description);
        type = newType;
        done = false;
        reward = null;
    }

    /**
     * This method is the constructor. It initialize the value of the Element.
     * Give a name and a description to info attribute, their type and reward
     *
     * @param name is the name to set at the element
     * @param description is the description to set at the element
     * @param newType is the Type of the element
     * @param newReward is the reward of the element
     */
    public Element(String name, String description, int newType, Stuff newReward) {
        information = new Info(name, description);
        type = newType;
        done = false;
        reward = newReward;
    }

    /**
     * This method allows us to resolve an enigma (an enigma is find in the
     * chest or given by a people)
     *
     * The answer of the object is his description, and his enigma is his name.
     * You enter the answer of the player in the parameter, with the player
     * involve in the parameter and the stuff to win. If the answer match the
     * description the player win and the player earn the object. Else the
     * player win nothing.
     *
     *
     * @param reponse the reponse of the player
     * @param player is the player who answer at the question
     * @perso the perso which answer
     * @return true if the enigma is solved
     */
    public boolean resolveEnigma(String reponse, Player player) {
        if (reponse.equalsIgnoreCase(information.getDescription())) {
            player.addStuff(reward, 1);
            return true;
        } else {
            return false;
        }

    }

    public void open_chest(Player player) {
    player.addStuff(reward, 1);
    }
            
    
    
    /**
     * This method allows us to delete a lifePoint when the player meet a trap
     *
     * @param perso is the perso who lost life
     * @param lost is the life point to lost
     */
    public void lostLifePoint(Perso perso, int lost) {
        perso.decreaseLifePoint(lost);
    }

    /**
     * Method getInformation get the info of the class.
     *
     * @return the information of the class
     */
    public Info getInformation() {
        return this.information;
    }

    /**
     * To get the done information
     *
     * @return done to know if the
     */
    public boolean getDone() {
        return this.done;
    }

    /**
     * To get the type of the element
     *
     * @return type is the type of the element
     */
    public int getType() {
        return type;
    }

    /**
     * To get the reward
     *
     * @return reward is the reward to get
     */
    public Stuff getReward() {
        return reward;
    }

    /**
     * To set the done attribut
     *
     * @param Done
     */
    public void setDone(boolean Done) {
        this.done = Done;
    }

}
