package Characters.Testing;

import Characters.Swordsman;
import Characters.IHero;
import Characters.Mage;

public class TestAHero {

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

        assert(sam.getStat("X") == 10);
        assert(sam.getStat("Y") == 9);
        assert(sam.getStat("CHP") == 4);
        assert(sam.getStat("MHP") == 4);
        assert(sam.getStat("STRENGTH") == 5);
        assert(sam.getStat("DEFENSE") == 3);
        assert(sam.getStat("RESISTANCE") == 4);
        assert(sam.getStat("SPEED") == 2);
        assert(sam.getStat("MOVESPEED") == 2);

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
            if (e.getMessage().equals("Invalid movement from (2, 5) to (5, 5)")) {
                System.out.println("AHero: Move throws exception when move is too far");
            }
        }

        IHero tom = new Swordsman("Tom", 0, 0);


        try {
            tom.move(-1, 0);
        } catch (IllegalArgumentException e) {
            if (e.getMessage().equals("Cannot move to a negative coordinate")) {
                System.out.println("AHero: Move throws exception when input is negative");
            }
        }

        System.out.println("AHero: TestMove successful");

    }
    
}
