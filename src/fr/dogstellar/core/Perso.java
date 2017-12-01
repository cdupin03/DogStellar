package fr.dogstellar.core;

import java.util.ArrayList;

/**
 * The class Perso. He has a name, a number of LifePoint and number of AttackPoint and an inventory.
 * 
 * When a Perso is creating, it is not possible to not have a name and to have negative lifePoint and attackPoint.
 * So at the beginning of the game :
 * the user can give a name or not, at this case the default name is Perso1
 * the default number of lifePoint and attackPoint is initiate at 10
 * 
 * The player can wins and lost lifePoint and attackPoint.
 * The player cannot have more than 10 and less than 0 lifePoint and attackPoint.
 * 
 * @author Gp3
 * @version 20/11/2017
 */
public class Perso
{
    // instance variables - replace the example below with your own
    private String namePerso;
    protected int lifePoint; //ATTTTTTTTTTTTTTTENEEEEEEEEEEEEEEEEEEEEEEEEEENNNNNNNNNNNNNNNNNNNNTIIIIIIIIIIIIONNNNNNNNNNNN
    protected int attackPoint;//ATTTTTTTTTTTTTTTENEEEEEEEEEEEEEEEEEEEEEEEEEENNNNNNNNNNNNNNNNNNNNTIIIIIIIIIIIIONNNNNNNNNNNN
    protected ArrayList<Stuff> inventory;

    /**
     * Constructor of the Perso class
     * The user can give a name to the player.
     * If the name is empty, to not have problem there is a default value (Perso1)
     * If the numbers of lifePoint or attackPoint are under 0 and superior to 10, the numbers are
     * automatically initialized to 10.
     * 
     * @param namePerso is the name(String) of the Perso
     * @param lifePoint is the number of lifePoint
     * @param attackPoint is the number of attackPoint
     * 
     */
    public Perso(String nameP, int lifeP, int attackP)
    {
        if (nameP.isEmpty())
            namePerso="Perso1";
        else
            namePerso=nameP;
        if (lifeP<=0 || lifeP>10)
            lifePoint=10;
        else
            lifePoint=lifeP;
        if (attackP<=0 || attackP>10)
            attackPoint=10;
        else
            attackPoint=attackP;
        inventory = new ArrayList();
    }
    
    /**
     * This method returns the number of lifePoint of the character.
     * @return lifePoint
     */
    public String getNamePerso()
    {
        return namePerso;
    }
    
    /**
     * This method returns the number of LifePoint of the character.
     * @return lifePoint
     */
    public int getLifePoint()
    {
        return lifePoint;
    }
    
    /**
     * This method returns the number of AttackPoint of the character.
     * @return attackPoint
     */
    public int getAttackPoint()
    {
        return attackPoint;
    }
    
    /** This method allows us to modify the number of LifePoint
     * 
     * @param lifePoint is the number of lifePoint that we want to add
     */
    public void setLifePoint(int lifePoint) {
		this.lifePoint = lifePoint;
	}
    
    /**
     * This method allows us to add lifePoint.
     * If we want to increase the number of lifePoint and the result is superior to 10, lifePoint take the value 10.
     * @param point it is the LifePoint that we add the the initial LifePoint
     */
    public void increaseLifePoint(int point)
    {
        int addition = lifePoint+point;
        if (addition<10)
            lifePoint=lifePoint+point;
        else
            lifePoint=10;
    }
    
    /**
     * This method allows us to delete a number of lifePoint.
     * If we want to decrease the number of lifePoint and the result is inferior to 0, lifePoint take the value 0.
     */
    public void decreaseLifePoint(int Point)
    {
        int soustraction = lifePoint-Point;
        if (soustraction<0)
            lifePoint=0;
        else
            lifePoint=lifePoint-Point;
    }
    
    /**
     * This method allows us to add a number of attackPoint.
     * If we want to increase the number of attackPoint and the result is superior to 10, attackPoint take the value 10.
     */
    public void increaseAttackPoint(int Point)
    {
        int addition = attackPoint+Point;
        if (addition<10)
            attackPoint=attackPoint+Point;
        else
            attackPoint=10;
    }
    
    /**
     * This method allows us to remove a number of attackPoint.
     * If we want to decrease the number of attackPoint and the result is inferior to 0, attackPoint take the value 0.
     */
    public void decreaseAttackPoint(int Point)
    {
        int soustraction = attackPoint-Point;
        if (soustraction<0)
            attackPoint=0;
        else
            attackPoint=attackPoint-Point;
    }
    
    /**
     * This method allows us to display the information of the perso (name, LifePoint and AttackPoint)
     */
    public void displayInfoPerso()
    {
    	System.out.println(namePerso);
    	System.out.println(lifePoint);
    	System.out.println(attackPoint);
    }
    
    /**
	 * The monster attack the player with a number of attackPoint
	 * @param player it is the player that the monster attack
	 * @param attackPoint it is the number of attackPoint that it decided to play
	 */
	public void monsterFight(Player player, int attackPoint)
	{
		Armor armorOfPlayer;
		int compt =0;
		if (player.hasArmor()==false) {
				player.decreaseLifePoint(attackPoint);
		} else if (player.hasArmor()==true) {
			armorOfPlayer = player.getArmorEquip();
			if (armorOfPlayer.getArmorPoint()>0) {
					compt = armorOfPlayer.getArmorPoint()-attackPoint;
					if (compt>0) {
						armorOfPlayer.decreaseArmorPoint(attackPoint);
					}else { 
						armorOfPlayer.decreaseArmorPoint(armorOfPlayer.getArmorPoint());
						player.decreaseLifePoint(attackPoint-armorOfPlayer.getArmorPoint());	
					}
			} else {
					player.decreaseLifePoint(attackPoint);
			}
		}
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
    public void displayStuff()
    {
        for (Stuff stuff : inventory) {
			System.out.println(stuff.getInformation().getName());
		}
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
