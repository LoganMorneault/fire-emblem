package Characters;

import Characters.Weapons.BasicSword;

public class Rogue extends AHero {

    /**
     * Constructs a basic Rogue
     * @param name the name of the Rogue
     * @param x their x position
     * @param y their y position
     */
    public Rogue(String name, int x, int y) {
        super(name, 4, 3, 2, 2, 80, 3, x, y, new BasicSword(1));
    }

    // Rogue doesn't create any new methods. This acts as a shortcut to initialize a new character
}
