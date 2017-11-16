package fr.dogstellar.core;

/**
 * This class gives the characteristics of the character.
 *
 * @author Gp3
 * @version V0
 */
public class Perso
{
    // instance variables - replace the example below with your own
    private String namePerso;
    protected int lifePoint;
    protected int attackPoint;

    /**
     * Constructor of the Perso class
     * 
     * @param namePerso is the name(String) of the Perso
     * @param lifePoint is the number of lifePoint
     * @param attackPoint is the number of attackPoint
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
     * This method returns the number of LifePoint of the character.
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
     * This method allows us to add a number of lifePoint.
     */
    public void increaseLifePoint(int newPoint)
    {
        int addition = lifePoint+newPoint;
        if (addition<10)
            lifePoint=lifePoint+newPoint;
        else
            lifePoint=10;
    }
    
    /**
     * This method allows us to deleate a number of lifePoint.
     */
    public void decreaseLifePoint(int newPoint)
    {
        int soustraction = lifePoint-newPoint;
        if (soustraction<0)
            lifePoint=0;
        else
            lifePoint=lifePoint-newPoint;
    }
    
    /**
     * This method allows us to add a number of attackPoint.
     */
    public void increaseAttackPoint(int newPoint)
    {
        int addition = attackPoint+newPoint;
        if (addition<10)
            attackPoint=attackPoint+newPoint;
        else
            attackPoint=10;
    }
    
    /**
     * This method allows us to remove a number of attackPoint.
     */
    public void decreaseAttackPoint(int newPoint)
    {
        int soustraction = attackPoint-newPoint;
        if (soustraction<0)
            attackPoint=0;
        else
            attackPoint=attackPoint-newPoint;
    }
    
}
