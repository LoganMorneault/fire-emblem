package Model.Characters.Testing;

// println added for readibility

public class TestMain {
    
    public static void main(String args[]) {
        System.out.println();

        // Tests for Posn
        TestPosn.testManhattanDistance();
        TestPosn.testGetters();
        TestPosn.testSetters();
        System.out.println();

        // Tests for UnitStats
        TestUnitStats.testGetStat();
        TestUnitStats.testSetStat();
        System.out.println();

        // Tests basic getters from AWeapon
        TestAWeapon.testGetDamageType();
        TestAWeapon.testGetPower();
        TestAWeapon.testGetRange();
        System.out.println();

        // Tests getters for AHero
        TestAHero.testGetName();
        TestAHero.testGetStat();
        TestAHero.testSetStat();
        TestAHero.testMove();
        TestAHero.TestTakeDamage();
        TestAHero.TestCanAttackTwice();
        TestAHero.TestGetOffensePower();
        TestAHero.TestGetDefensePower();
        System.out.println();
    }
    
}