package Model.Characters.Testing;

import Model.Posn;

/**
 * Contains tests for methods in the Posn class
 */
public class TestPosn {

    public static void testManhattanDistance() {
        assert(new Posn(0, 0).manhattanDist(0, 0) == 0);
        assert(new Posn(0, 0).manhattanDist(1, 1) == 2);
        assert(new Posn(1, 8).manhattanDist(8, 1) == 14);

        assert(new Posn(4, 4).manhattanDist(new Posn(4, 4)) == 0);

        System.out.println("Posn: TestManhattanDistance successful");
    }

    public static void testGetters() {
        Posn posn = new Posn(5, 6);

        assert(posn.getX() == 5);
        assert(posn.getY() == 6);

        System.out.println("Posn: TestGetters successful");
    }

    public static void testSetters() {
        Posn posn = new Posn(5, 6);

        posn.setX(7);
        posn.setY(8);
        assert(posn.getX() == 7);
        assert(posn.getY() == 8);

        System.out.println("Posn: TestSetters successful");
    }
}
