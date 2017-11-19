package fr.dogstellar.core;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PersoTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
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
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void normalPerso()
    {
        perso1 = new Perso("Perso1",0,0);
        assertEquals("Perso1", perso1.getNamePerso());
        assertEquals(10, perso1.getLifePoint());
        assertEquals(10, perso1.getAttackPoint());
    }
    
    @Test
    public void noNamePerso()
    {
        mauvais = new Perso("", 10 , 10);
        assertEquals("Perso1", mauvais.getNamePerso());
    }
    
    @Test
    public void noNegativeLifePoint()
    {
        mauvais = new Perso("Perso1", -2, 10);
        assertEquals(10, mauvais.getLifePoint());
    }
    
    @Test
    public void noNegativeAttackPoint()
    {
        mauvais = new Perso("Perso1", 10, -2);
        assertEquals(10, mauvais.getAttackPoint());
    }
    
    @Test
    public void decreaseInNegativeLifePoint()
    {
        Perso perso1 = new Perso("Perso1", 1, 10);
        perso1.decreaseLifePoint(2);
        assertEquals(0, perso1.getLifePoint());
    }
    
    @Test
    public void decreaseInNegativeAttackPoint()
    {
        Perso perso1 = new Perso("Perso1", 10, 1);
        perso1.decreaseAttackPoint(2);
        assertEquals(0, perso1.getAttackPoint());
    }
}



