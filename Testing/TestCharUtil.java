package Testing;

import Characters.CharUtil;
import Characters.AHero;
import Characters.IHero;

/**
 * Class for testing methods in the CharUtil class
 */
public class TestCharUtil {

    /**
     * Basic tests for CharUtil.ManhattanDistance(int, int, int, int) and CharUtil.ManhattanDistance(IHero, IHero)
     */
    public static void testManhattanDistance() {
        assert(CharUtil.manhattanDist(1, 1, 1, 1) == 0);

        assert(CharUtil.manhattanDist(0, 8, 0, 7) == 15);

        assert(CharUtil.manhattanDist(-1, 0, -1, 0) == 2);

        System.out.println("CharUtil.testManhattanDistance(int, int, int, int) is successful");

        IHero h1 = new AHero("Arthur", 0, 0, 0, 0, 0, 10, 1, 1);
        IHero h2 = new AHero("Benjamin", 0, 0, 0, 0, 0, 0, 1, 1);

        assert(CharUtil.manhattanDist(h1, h2) == 0);

        h1.move(0, 8);

        assert(CharUtil.manhattanDist(h1, h2) == 8);

        System.out.println("CharUtil.testManhattanDistance(Hero, Hero) is successful");
    }
}