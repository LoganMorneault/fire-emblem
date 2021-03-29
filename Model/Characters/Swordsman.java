package Model.Characters;

import Model.Characters.Weapons.BasicSword;

/**
 * Represents a sword-wielding character with fixed stats.
 */
public class Swordsman extends AHero {

    /**
     * Constructs a basic swordsman
     * @param name the name of the Rogue
     * @param x their x position
     * @param y their y position
     */
    public Swordsman(String name, int x, int y) {
        // name, HP, STR, MAG, DEF, RES, SPD, MOV, X, Y, Weapon
        super(name, 5, 4, 1, 4, 3, 5, 2, x, y, new BasicSword(2));
    }

    // Swordsman doesn't create any new methods. This acts as a shortcut to initialize a new character
}
