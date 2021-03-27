package Characters.Testing;

// println added for readibility

public class TestMain {
    
    public static void main(String args[]) {
        System.out.println();

        // Tests both versions of method manhattanDistance() in CharUtil.
        TestCharUtil.testManhattanDistance();
        System.out.println();

        // Tests basic getters from AWeapon
        TestAWeapon.testGetDamageType();
        TestAWeapon.testGetPower();
        TestAWeapon.testGetRange();
        System.out.println();

        // Tests getters for AHero
        TestAHero.testGetStat();
        TestAHero.testMove();
        System.out.println();
    }
    
}