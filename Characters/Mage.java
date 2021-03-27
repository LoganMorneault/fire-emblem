package Characters;

import Characters.Weapons.BasicSpell;

/**
 * Represents a magic-wielding character with fixed stats.
 */
public class Mage extends AHero {
    /**
     * Constructs a basic mage
     */
     public Mage(String name, int x, int y) {
         // name, HP, STR, DEF, RES, SPD, MOV, X, Y, Weapon
        super(name, 4, 5, 3, 4, 5, 2, x, y, new BasicSpell(3));
     }

     // Mage doesn't create any new methods. This acts as a shortcut to initilaize a new character
}
