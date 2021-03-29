package Model.Characters;

import java.util.Objects;

import Model.Posn;
import Model.Characters.Weapons.IWeapon;

/**
 * Represents a Hero in this game.
 * 
 */
public abstract class AHero implements IHero {
    private final String name;

    private final Posn pos;
    private final UnitStats stats;

    // Weapons can be changed
    private IWeapon weapon;

    // Package protected --> Cannot create an instance of AHero.
    AHero(String name, int maxHP, int strength, int magic, int defense, int resistance, int speed, 
        int moveSpeed, int x, int y, 
        IWeapon weapon) {
        this.name = name;

        this.stats = new UnitStats(maxHP, strength, magic, defense, resistance, speed, moveSpeed);
        this.pos = new Posn(x, y);

        this.weapon = Objects.requireNonNull(weapon);
    }

    /**
     * Gets this Hero's name
     * @return this Hero's name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets one of this Hero's stats based on the input
     * @param stat the stat to be returned. Is one of: "X", "Y", "CHP", "MHP", "STRENGTH", "MAGIC", "DEFENSE", "RESISTANCE", "SPEED", "MOVESPEED"
     * @return the requested stat.
     * @throws IllegalArgumentException if requested stat does not exist.
     */
    public int getStat(String stat) {

        stat = stat.toUpperCase();

        // If stat is X or Y

        if (stat.equals("X")) {
            return this.pos.getX();
        }

        if (stat.equals("Y")) {
            return this.pos.getY();
        }

        // all other stats are in this.stats
        return this.stats.getStat(stat);
    }


    /**
     * Sets one of this Hero's stats based on the input
     * @param stat the stat to be updated. Is one of "X", "Y", "CHP", "MHP", "STRENGTH", "MAGIC", "DEFENSE", "RESISTANCE", "SPEED", "MOVESPEED"
     * @param val the new value of the stat.
     * @throws IllegalArgumentException if requested stat does not exist.
     */
    public void setStat(String stat, int val) {
        stat = Objects.requireNonNull(stat).toUpperCase();

        // error handling done in setters
        if (stat.equals("X")) {
            this.pos.setX(val);
            return;
        }
        if (stat.equals("Y")) {
            this.pos.setY(val);
            return;
        }

        // Error handling done here.
        this.stats.setStat(stat, val);
    }

    /**
     * Updates this Hero's position if the given coordinates are valid.
     * Assumes the given coordinates are in-bounds.
     * @param x the new x coordinate
     * @param y the new y coordinate
     * @throws IllegalArgumentException if x or y is negative.
     * @throws IllegalArgumentException if new coordinates are further than this unit can move
     */
    public void move(int x, int y) {
        // if the Manhattan distance of the given coordinates is greater than this Hero's move type, the move is invalid.
        int manhattanDist = this.pos.manhattanDist(x, y);

        // x and y cannot be negative
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("Cannot move to a negative coordinate");
        }

        if (manhattanDist > this.stats.getStat("MOVE")) {
            throw new IllegalArgumentException(
                String.format("Invalid movement from (%d, %d) to (%d, %d)", 
                this.pos.getX(), this.pos.getY(), x, y));
        }

        this.pos.setX(x);
        this.pos.setY(y);
    }

    /**
     * Determines if this Hero can attack the other Hero twice
     * @param other the Hero being attacked
     * @return true if this Hero's - the other Hero's speed >= 5
     * */
    public boolean canAttackTwice(IHero other) {
        Objects.requireNonNull(other);

        return this.getStat("SPEED") - other.getStat("SPEED") >= 5;
    }

    /**
     * Returns the offensive power of this unit.
     */
    public int getOffensePower() {
        if (this.weapon.getDamageType() == DamageType.Physical) {
            return this.getStat("STRENGTH") + this.weapon.getPower();
        }
        
        return this.getStat("MAGIC") + this.weapon.getPower();
    }

    /**
     * Returns the defensive power of this unit.
     */
    public int getDefensePower(DamageType dt) {
        // returns DEF if physical, MDEF if magical
        return (dt == DamageType.Physical) ? this.getStat("DEFENSE") : this.getStat("RESISTANCE");
    }

    /**
     * Deals damage to the other Hero based on this Hero's strength, speed and weapon
     * @param other the Hero to be damaged.
     */
    public void attack(IHero other) {
        Objects.requireNonNull(other);

        // If other hero is out of range, throw exception
        if (this.pos.manhattanDist(other.getStat("X"), other.getStat("Y")) < this.weapon.getRange()) {
            throw new IllegalArgumentException(String.format("Hero %c cannot reach Hero %c", this.getName(), other.getName()));
        }

        // damage is the total damage. This is reduced by the opponent's defense
        int dmg = this.getOffensePower() - other.getDefensePower(this.weapon.getDamageType());

        // reduces opponent's health by actualDMG
        other.takeDamage(dmg);
    }


    /**
     *  Reduces this Hero's current health by the given amount.
     * @param dmg the amount to reduce current health by
     */
    public void takeDamage(int dmg) {
        if (dmg < 0) {
            throw new IllegalArgumentException("Cannot take negative damage!");
        }

        // sets CHP to (CHP - dmg)
        this.stats.setStat("CHP", this.getStat("CHP") - dmg);
    }
}