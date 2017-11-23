package fr.dogstellar.core;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * The test class PersoTest.
 *
 * @author  GP3
 * @version 20/11/2017
 */
public class PersoTest
{
    Perso perso1;
    Perso mauvais;
    
    /**
     * Default constructor for test class PersoTest
     */
    public PersoTest()
    {
    }
    
    /**
     * We test the creation of a new perso with good parameters (a name and no negative lifePoint and attackPoint)
     */
    @Test
    public void normalPerso()
    {
        perso1 = new Perso("Perso1",10,10);
        assertEquals("Perso1", perso1.getNamePerso());
        assertEquals(10, perso1.getLifePoint());
        assertEquals(10, perso1.getAttackPoint());
    }
    
    /**
     * In this test, there is no name for the Perso
     * The default name is Perso1
     */
    @Test
    public void noNamePerso()
    {
        mauvais = new Perso("", 10 , 10);
        assertEquals("Perso1", mauvais.getNamePerso());
    }
     /**
      * Test with a negative lifePoint
      * When we want to create a Perso and there is a negative number for lifePoint, the number
      * is initialized with 10 lifePoint
      */
    @Test
    public void noNegativeLifePoint()
    {
        mauvais = new Perso("Perso1", -2, 10);
        assertEquals(10, mauvais.getLifePoint());
    }
    
    /**
     * Test with a negativeAttackPoint
     * When we want to create a Perso and there is a negative number for attackPoint, the number
     * is initialized with 10 attackPoint
     */
    @Test
    public void noNegativeAttackPoint()
    {
        mauvais = new Perso("Perso1", 10, -2);
        assertEquals(10, mauvais.getAttackPoint());
    }
    
    
    /** 
     * Test if the modification of LifePoint is well working 
     * The new LifePoint is 3 so perso1 have 3 lifePoint at this end of the test
     */
    @Test
    public void setterLifePointOk() {
    	Perso perso1 = new Perso ("Perso1", 1, 10);
    	perso1.setLifePoint(3);
    	assertEquals(3, perso1.getLifePoint());
    }
    
    /**
     * If we want to decrease lifePoint and the result in under 0, the variable is automatically
     * egals to 0.
     */
    @Test
    public void decreaseInNegativeLifePoint()
    {
        Perso perso1 = new Perso("Perso1", 1, 10);
        perso1.decreaseLifePoint(2);
        assertEquals(0, perso1.getLifePoint());
    }
    
    /**
     * If we want to decrease attackPoint and the result in under 0, the variable is automatically
     * egals to 0.
     */
    @Test
    public void decreaseInNegativeAttackPoint()
    {
        Perso perso1 = new Perso("Perso1", 10, 1);
        perso1.decreaseAttackPoint(2);
        assertEquals(0, perso1.getAttackPoint());
    }
    
    /**
     * 
     */
    @Test
    public void monsterFight()
    {
        Perso perso1 = new Perso("Perso1", 10, 1);
        perso1.displayInfoPerso();
        assertEquals(0, perso1.getAttackPoint());
    }
    
}



