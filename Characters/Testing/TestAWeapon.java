package Characters.Testing;

import Characters.Weapons.BasicSword;
import Characters.DamageType;
import Characters.Weapons.BasicSpell;

/**
 * Class for testing methods in the AWeapon class.
 */
public class TestAWeapon {
    /**
     * Tests the getPower method.
     * BasicSword and BasicSpell inherit this method from AWeapon.
     */
    public static void testGetPower() {
        assert(new BasicSword(1).getPower() == 1);
        assert(new BasicSpell(5).getPower() == 5);

        System.out.println("AWeapon: TestGetPower successful");
    }

    /**
     * Tests the getRange method.
     * BasicSword and BasicSpell inherit this method from AWeapon.
     */
    public static void testGetRange() {
        assert(new BasicSword(12).getRange() == 1);
        assert(new BasicSpell(9).getRange() == 2);

        System.out.println("AWeapon: TestGetRange successful");
    }

    /**
     * Tests the getDamageType method.
     * BasicSword and BasicSpell inherit this method from AWeapon.
     */
    public static void testGetDamageType() {
        assert(new BasicSword(1).getDamageType() == DamageType.Physical);
        assert(new BasicSpell(1).getDamageType() == DamageType.Magical);

        System.out.println("AWeapon: TestGetDamageType successful");

    }

}