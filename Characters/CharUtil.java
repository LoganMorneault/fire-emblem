package Characters;

/**
 * CharUtil is a class providing many methods useful in definining Heroes.
 */
public class CharUtil {
    CharUtil(){};


    /**
     * Calculates the Manhattan Distance between two points.
     * @param x1 the x coordinate of the first point.
     * @param y1 the y coordinate of the first point.
     * @param x2 the x coordinate of the second point.
     * @param y2 the y coordinate of the second point.
     * @return the Manhattan Distance between the two points.
     */
    // Calculates the Manhattan Distance between points (x1, y1) and (x2, y2)
    public static int manhattanDist(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    /**
     * Calculates the Manhattan Distance between two heroes.
     * @param h1 the first hero.
     * @param h2 the second hero.
     * @return the Manhattan Distance between the two heroes.
     */
    public static int manhattanDist(IHero h1, IHero h2) {
        return manhattanDist(h1.getStat("X"), 
            h1.getStat("Y"), h2.getStat("X"), h2.getStat("Y"));
    }
}
