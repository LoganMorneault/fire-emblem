package Characters;

import java.lang.Math;
import java.util.Objects;

import Characters.Weapons.IWeapon;


/* 
    Represents a character in the game

    Heroes have HP, which is reduced as they take damage. If their current HP is ever reduced to 0, they are dead.
    Heroes have position, which is denoted by x and y coordinates.

    Heroes have 4 primary combat statistics: attack, defense, resistance, and speed.
    Heroes have a weapon that is used in combat. The damage dealt is determined by the weapon's damage type.
*/

/**
 * Represents a Hero in this game.
 * 
 */
public abstract class AHero implements IHero {
    final String name;

    private int currentHP;
    private int maxHP;

    private int x;
    private int y;

    private int strength;
    private int defense;
    private int resistance;
    private int speed;

    private int moveSpeed;

    private IWeapon weapon;

    public AHero(String name, int maxHP, int strength, int defense, int resistance, int speed, 
        int moveSpeed, int x, int y, 
        IWeapon weapon) {
        this.name = name;
        this.maxHP = Math.max(0, maxHP);
        this.currentHP = this.maxHP;

        this.strength = Math.max(0, strength);
        this.defense = Math.max(0, defense);
        this.resistance = Math.max(0, resistance);
        this.speed = Math.max(0, speed);
        this.moveSpeed = Math.max(0, moveSpeed);

        this.x = Math.max(0, x);
        this.y = Math.max(0, y);

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
     * @param stat the stat to be returned. Is one of: "CHP", "MHP", "STRENGTH", "DEFENSE", "RESISTANCE", "SPEED"
     * @return the requested stat.
     * @throws IllegalArgumentException if requested stat does not exist.
     */
    public int getStat(String stat) {
        switch (stat.toUpperCase()) {
            case "X": 
                return this.x;
            case "Y":
                return this.y;
            case "CHP":
                return this.currentHP;
            case "MHP":
                return this.maxHP;
            case "STRENGTH":
                return this.strength;
            case "DEFENSE":
                return this.defense;
            case "RESISTANCE":
                return this.resistance;
            case "SPEED":
                return this.speed;
            case "MOVE":
            case "MOVESPEED":
                return this.moveSpeed;
            default:
                throw new IllegalArgumentException(String.format("Stat %s does not exist", stat));
        }
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
        new CharUtil();
        // if the Manhattan distance of the given coordinates is greater than this Hero's move type, the move is invalid.
        int manhattanDist = CharUtil.manhattanDist(this.x, this.y, x, y);

        // x and y cannot be negative
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("Cannot move to a negative coordinate");
        }

        if (manhattanDist > this.moveSpeed) {
            throw new IllegalArgumentException(String.format("Invalid movement from (%d, %d) to (%d, %d)", this.x, this.y, x, y));
        }

        this.x = x;
        this.y = y;
    }


    /**
     * Deals damage to the other Hero based on this Hero's strength, speed and weapon
     * If this Hero's speed is at least 5 greater than other's, this Hero deals double damage.
     * @param other the Hero to be damaged.
     */
    public void attack(IHero other) {
        Objects.requireNonNull(other);

        // If other hero is out of range, throw exception
        if (CharUtil.manhattanDist(this, other) < this.weapon.getRange()) {
            throw new IllegalArgumentException(String.format("Hero %c cannot reach Hero %c", this.getName(), other.getName()));
        }

        // damage is the total damage. This is reduced by the opponent's defense
        int baseDMG = this.getStat("STRENGTH") + this.weapon.getPower();

        // If physical damage, subtract defense stat
        // If magical damage, subtract resistance stat
        int actualDMG = baseDMG - (
            (this.weapon.getDamageType() == DamageType.Physical) ? 
            other.getStat("DEFENSE") : 
            other.getStat("RESISTANCE"));

        if (this.speed - other.getStat("SPEED") >= 5) {
            actualDMG *= 2;
        }

        // reduces opponent's health by actualDMG
        other.takeDamage(actualDMG);
    }


    /**
     *  Reduces this Hero's current health by the given amount.
     * @param dmg the amount to reduce current health by
     */
    public void takeDamage(int dmg) {
        if (dmg < 0) {
            throw new IllegalArgumentException("Cannot take negative damage!");
        }

        this.currentHP -= dmg;
    }
}