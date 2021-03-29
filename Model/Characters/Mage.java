package Model.Characters;

import Model.Characters.Weapons.BasicSpell;

/**
 * Represents a magic-wielding character with fixed stats.
 */
public class Mage extends AHero {
    /**
     * Constructs a basic mage
     * @param name the name of the Rogue
     * @param x their x position
     * @param y their y position
     */
     public Mage(String name, int x, int y) {
         // name, HP, STR, MAG, DEF, RES, SPD, MOV, X, Y, Weapon
        super(name, 4, 1, 5, 3, 4, 5, 2, x, y, new BasicSpell(3));
     }

     // Mage doesn't create any new methods. This acts as a shortcut to initilaize a new character
}
