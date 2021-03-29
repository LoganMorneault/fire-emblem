package Model.Characters.Weapons;

import Model.Characters.DamageType;

/**
 * Class representing a basic sword
 */
public class BasicSword extends AWeapon {
    
    /**
     * Constructor for a BasicSword.
     */
    public BasicSword(int power) {
        super(power, 1, DamageType.Physical);
    }    
}
