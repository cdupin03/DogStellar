package fr.dogstellar.core;

/**
 * This class gives the characteristics of the character (name, lifePoint and attackPoint).
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
    protected int lifePoint;
    protected int attackPoint;
    

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
    
    /**
     * This method allows us to add lifePoint.
     * If we want to increase the number of lifePoint and the result is superior to 10, lifePoint take the value 10.
     * 
     */
    public void increaseLifePoint(int Point)
    {
        int addition = lifePoint+Point;
        if (addition<10)
            lifePoint=lifePoint+Point;
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
    
    
   
}
