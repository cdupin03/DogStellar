package fr.dogstellar.core;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class QuestElementTest.
 * This test is here see if the object creation work.
 * Create a Questelement with value(name, description) and test if the values enter are right   
 * The test success if the information enter match with the information in the object       
 * 
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class QuestElementTest
{
    @Test
    public void CreateObject()
    {
        QuestElement questEle1 = new QuestElement("Name", "Description");
    }

    
    /**
     *  This test is here see if the object creation works.
     * Create a Questelement with value(name, description) and test if the values enter are right
     * The test success if the information enter match with the information in the object    
     */
    @Test
    public void Getinfo()
    {
        QuestElement questEle1 = new QuestElement("Name", "Description");
        assertEquals("Name", questEle1.getInformation().getName());
        assertEquals("Description", questEle1.getInformation().getDescription());
    }
}


