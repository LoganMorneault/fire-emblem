package Characters.Weapons;

import Characters.DamageType;

public class BasicSpell extends AWeapon {

    /**
    * Constructor for a BasicSpell.
    */
    public BasicSpell(int power) {
        super(power, 2, DamageType.Magical);
    }    
}
