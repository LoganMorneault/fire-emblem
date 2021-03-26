package Characters.Weapons;

import Characters.DamageType;

public class BasicSpell extends AWeapon {

    /**
    * Constructor for a BasicSpell.
    */
    BasicSpell(int power) {
        super(power, 2, DamageType.Magical);
    }

    /**
     * Gets this weapon's damage type.
     * @return the weapon's damage type.
     */
    @Override
    public DamageType getDamageType() {
        return this.damageType;
    }

    /**
     * Gets this weapon's power.
     * @return the weapon's power.
     */
    @Override
    public int getPower() {
        return this.power;
    }

    /**
     * Gets this weapon's range
     * @return the weapon's range
     */
    @Override
    public int getRange() {
        return this.range;
    }
    
    
}
