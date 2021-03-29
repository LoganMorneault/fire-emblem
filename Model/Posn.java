package Model;

/**
 * Represents the position of an entity.
 */
public class Posn {
    private int x;
    private int y;

    /**
     * Constructor for Posn.
     * @param x the x-coordinate.
     * @param y the y-coordinate.
     */
    public Posn(int x, int y) {
        this.x = Math.max(0, x);
        this.y = Math.max(0, y);
    }

    /**
     * Gets the x-coordinate of this position.
     * @return the x-coordinate.
     */
    public int getX() {
        return this.x;
    }
    
    /**
     * Gets the y-coordiante of this position
     * @return the y-coordinate.
     */
    public int getY() {
        return this.y;
    }

    /**
     * Finds the Manhattan Distance between this Posn and the given Posn.
     * @param other the other Posn.
     * @return the Manhattan Distance between the two Posns.
     */
    public int manhattanDist(Posn other) {
        return Math.abs(this.x - other.getX()) + Math.abs(this.y - other.getY());
    }

    /**
     * Finds the Manhattan Distance between this Posn and the given coordinates.
     * @param x the x coordinate of the other position.
     * @param y the y coordinate of the other position.
     */
    public int manhattanDist(int x, int y) {
        return Math.abs(this.x - x) + Math.abs(this.y - y);
    }

    /**
     * Sets the x-coordinate of this position
     * @param x the new x-coordinate.
     */
    public void setX(int x) {
        if (x < 0) {
            return;
        }

        this.x = x;
    }

    /**
     * Sets the y-coordinate of this position.
     * @param y the new y-coordinate.
     */
    public void setY(int y) {
        if (y < 0) {
            return;
        }

        this.y = y;
    }
}
