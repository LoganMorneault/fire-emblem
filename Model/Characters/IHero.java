package Model.Characters;


/**
 * An interface representing a Hero in the game.
 */
public interface IHero {
    /**
     * Returns this Hero's name
     */
    String getName();

    /**
     * Returns one of this Hero's stats.
     * @param stat the stat to be returned. Is one of: "X", "Y", "CHP", "MHP", "MAGIC", "STRENGTH", "DEFENSE", "RESISTANCE", "SPEED", "MOVESPEED"
     * @return the requested stat
     * @throws IllegalArgumentException if stat is not valid
     */
    int getStat(String stat);

    /**
     * Changes one of this Hero's stats.
     * @param stat the stat to be updated. Is one of: "X", "Y", "CHP", "MHP", "STRENGTH", "MAGIC", "DEFENSE", "RESISTANCE", "SPEED", "MOVESPEED"
     * @param val the new value of the stat.
     * @throws IllegalArgumentException if stat is not valid
     */
    void setStat(String stat, int val);

    /**
     * Moves this Hero to the requested position.
     * @param x the x coordinate of the new position.
     * @param y the y coordinate of the new position
     * @throws IllegalArgumentException if x or y is negative or if the new position is not valid.
     */
    void move(int x, int y);

    /**
     * This Hero attacks the other Hero
     * @param other the Hero being attacked
     */
    void attack(IHero other);

    /**
     * Reduces this Hero's current HP by the given amount.
     * @param damage the amount of damage this Hero is taking.
     * @throws IllegalArgumentException if damage < 0.
     */
    void takeDamage(int damage);

    /**
     * Determines if this Hero can attack the given Hero twice.
     * @param other the other Hero.
     * @returns true if this Hero's speed is at least 5 more than the other Hero's speed.
     */
    boolean canAttackTwice(IHero other);

    /**
     * Returns this Hero's offensive power.
     */
    int getOffensePower();

    /**
     * Returns this Hero's defensive power for the given DamageType.
     * @param dt either Physical or Magical.
     */
    int getDefensePower(DamageType dt);
}
