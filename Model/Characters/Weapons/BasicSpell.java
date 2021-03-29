package Model.Characters.Weapons;

import Model.Characters.DamageType;

public class BasicSpell extends AWeapon {

    /**
    * Constructor for a BasicSpell.
    */
    public BasicSpell(int power) {
        super(power, 2, DamageType.Magical);
    }    
}
