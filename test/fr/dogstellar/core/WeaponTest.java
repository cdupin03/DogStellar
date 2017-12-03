package fr.dogstellar.core;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class WeaponTest. Test if the Weapon class work
 *
 * @author (G3)
 * @version (01)
 */
public class WeaponTest {

    /**
     * Default constructor for test class WeaponTest Useless
     */
    public WeaponTest() {

    }

    /**
     * Create a Weapon with value and test if the values enter are right The
     * test success if the information enter match. It tests if when a "normal"
     * weapon is made, a normal behaviour happens.
     *
     */
    @Test
    public void test_weapon() {
        Weapon weapon1 = new Weapon("gun", "that a weapon for sure", 7);
        assertEquals("gun", weapon1.getInformation().getName());
        assertEquals("that a weapon for sure", weapon1.getInformation().getDescription());
        assertEquals(7, weapon1.getDamage());
    }

    /**
     * Create a Weapon with a too short damage point.
     *
     * The test success if the damage value is 1
     *
     */
    @Test
    public void test_weapon_less() {
        Weapon weapon1 = new Weapon("gun", "that a weapon for sure", 0);
        assertEquals(1, weapon1.getDamage());
    }

    /**
     * Create a Weapon with a too big value.
     *
     * The test success if the damage value is 1
     *
     */
    @Test
    public void test_weapon_more() {
        Weapon weapon1 = new Weapon("gun", "that a weapon for sure", 16);
        assertEquals(1, weapon1.getDamage());
    }

}
