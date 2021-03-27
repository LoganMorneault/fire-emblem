package Characters;
import Characters.Weapons.BasicSword;

/**
 * Represents a sword-wielding character with fixed stats.
 */
public class Swordsman extends AHero {

    /**
     * Constructs a basic swordsman
     */
    public Swordsman(String name, int x, int y) {
        // name, HP, STR, DEF, RES, SPD, MOV, X, Y, Weapon
        super(name, 5, 4, 4, 3, 5, 2, x, y, new BasicSword(2));
    }



    // Swordsman doesn't create any new methods. This acts as a shortcut to initialize a new character
}
