package Characters.Testing;

import Characters.CharUtil;
import Characters.IHero;
import Characters.Swordsman;

/**
 * Class for testing methods in the CharUtil class.
 */
public class TestCharUtil {

    /**
     * Basic tests for CharUtil.ManhattanDistance(int, int, int, int) 
     * and CharUtil.ManhattanDistance(IHero, IHero).
     * 
     * These tests are called by TestMain.main
     */
    public static void testManhattanDistance() {
        assert(CharUtil.manhattanDist(1, 1, 1, 1) == 0);

        assert(CharUtil.manhattanDist(0, 8, 0, 7) == 15);

        assert(CharUtil.manhattanDist(-1, 0, -1, 0) == 2);

        System.out.println("CharUtil: testManhattanDistance(int, int, int, int) is successful");

        IHero h1 = new Swordsman("Arthur", 1, 1);
        IHero h2 = new Swordsman("Benjamin", 1, 1);

        assert(CharUtil.manhattanDist(h1, h2) == 0);

        h1.move(0, 2);

        assert(CharUtil.manhattanDist(h1, h2) == 2);

        System.out.println("CharUtil: testManhattanDistance(Hero, Hero) is successful");
    }
}