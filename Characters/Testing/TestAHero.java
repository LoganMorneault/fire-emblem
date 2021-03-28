package Characters.Testing;

import Characters.Swordsman;
import Characters.IHero;
import Characters.Mage;
import Characters.Rogue;

public class TestAHero {

    /**
     * Tests the getName method
     */
    public static void testGetName() {
        assert(new Swordsman("John", 1, 1).getName().equals("John"));
        System.out.println("AHero: TestGetName successful");
    }

    /**
     * Tests the getStat method
     */
    public static void testGetStat() {
        IHero john = new Swordsman("John", 1, 5);
        IHero sam = new Mage("Sam", 10, 9);

        assert(john.getStat("X") == 1);
        assert(john.getStat("Y") == 5);
        assert(john.getStat("CHP") == 5);
        assert(john.getStat("MHP") == 5);
        assert(john.getStat("STRENGTH") == 4);
        assert(john.getStat("DEFENSE") == 4);
        assert(john.getStat("RESISTANCE") == 3);
        assert(john.getStat("SPEED") == 2);
        assert(john.getStat("MOVE") == 2);

        assert(sam.getStat("x") == 10);
        assert(sam.getStat("y") == 9);
        assert(sam.getStat("chp") == 4);
        assert(sam.getStat("mhp") == 4);
        assert(sam.getStat("strength") == 5);
        assert(sam.getStat("defense") == 3);
        assert(sam.getStat("resistance") == 4);
        assert(sam.getStat("speed") == 2);
        assert(sam.getStat("movespeed") == 2);

        try {
            sam.getStat("BAD STAT");
        } catch (IllegalArgumentException e) {
            assert(e.getMessage().equals("Stat BAD STAT does not exist"));
        }

        System.out.println("AHero: TestGetStat successful");
    }


    /**
     * Tests the move method
     */
    public static void testMove() {
        IHero john = new Swordsman("John", 1, 5);
        IHero sam = new Mage("Sam", 10, 9);

        john.move(2, 5);
        assert(john.getStat("X") == 2 
            && john.getStat("Y") == 5);

        sam.move(8, 9);
        assert(sam.getStat("X") == 8 
            && sam.getStat("Y") == 9);

        try {
            john.move(5, 5);
        } catch (IllegalArgumentException e) {
            assert(e.getMessage().equals("Invalid movement from (2, 5) to (5, 5)"));
        }


        IHero tom = new Swordsman("Tom", 0, 0);
        try {
            tom.move(-1, 0);
        } catch (IllegalArgumentException e) {
            assert(e.getMessage().equals("Cannot move to a negative coordinate"));
        }

        System.out.println("AHero: TestMove successful");

    }


    /**
     * Tests the takeDamage method.
     */
    public static void TestTakeDamage() {
        IHero john = new Swordsman("John", 1, 5);
        IHero tom = new Swordsman("Tom", 0, 0);

        assert(john.getStat("MHP") == john.getStat("CHP") 
            && john.getStat("CHP") == 5);

        john.takeDamage(2);

        assert(john.getStat("MHP") != john.getStat("CHP")
            && john.getStat("CHP") == 3);

        try {
            tom.takeDamage(-50);
        } catch (IllegalArgumentException e) {
            assert(tom.getStat("CHP") == 5);
            assert(e.getMessage().equals("Cannot take negative damage!"));
        }      
        
        System.out.println("AHero: TestTakeDamage successful");
    }

    /**
     * Tests canAttackTwice method.
     */
    public static void TestCanAttackTwice() {
        IHero john = new Swordsman("John", 1, 5);
        IHero reginald = new Rogue("Reginald", 0, 0);

        assert(!john.canAttackTwice(reginald));
        assert(reginald.canAttackTwice(john));

        System.out.println("AHero: TestCanAttackTwice successful");
    }
}
