package fr.dogstellar.core;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ArmorTest. Test if the ArmorTest class work First it test the
 * creation of a armor piece of stuff and search if the object created have the
 * name and description entered. If the name and description work, the test
 * success. Then it try to create a armor with a armorpoint above the range. The
 * result must be 1 . If the armorPoint is 1 the test success. Then it try to
 * create a armor with a armorpoint under the range. The result must be 1 . If
 * the armorPoint is 1 the test success.
 *
 * @author (G3)
 * @version (01)
 */
public class ArmorTest {

    /**
     * This test is here see if the object creation work. Create a Armor with
     * value(name, description) and test if the values enter are right The test
     * success if the information enter match with the information in the object
     *
     */
    @Test
    public void armortest() {
        Armor armor2 = new Armor("bouclier", "A wise choice", 15);
        armor2.getInformation().getName();
        assertEquals("bouclier", armor2.getInformation().getName());
        assertEquals("A wise choice", armor2.getInformation().getDescription());
        assertEquals(15, armor2.getArmorPoint());
    }

    /**
     * This test is here to avoid armor with armorpoint above 25. Try to create
     * a armor with a armorpoint above the range. The result must be 1 If the
     * armorPoint is 1 the test success.
     */
    @Test
    public void armortest_more() {
        Armor armor2 = new Armor("bouclier", "A wise choice", 70);
        assertEquals(1, armor2.getArmorPoint());
    }

    /**
     * This test is here to avoid armor with armorpoint under 0. Try to create a
     * armor with a armorpoint above the range. The result must be 1 If the
     * armorPoint is 1 the test success.
     *
     */
    @Test
    public void armortest_less() {
        Armor armor2 = new Armor("bouclier", "A wise choice", 0);
        assertEquals(1, armor2.getArmorPoint());
    }
}
