package fr.dogstellar.core;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class QuestElementTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class QuestElementTest
{
    /**
     * Default constructor for test class QuestElementTest
     */
    public QuestElementTest()
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
    public void CreateObject()
    {
        QuestElement questEle1 = new QuestElement("Name", "Description");
    }

    @Test
    public void Getinfo()
    {
        QuestElement questEle1 = new QuestElement("Name", "Description");
        assertEquals("Name", questEle1.getInformation().getName());
        assertEquals("Description", questEle1.getInformation().getDescription());
    }
}


