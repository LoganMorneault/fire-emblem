package Characters.Weapons;

import java.util.Objects;

import Characters.DamageType;

public class AWeapon implements IWeapon {
    protected final int power;
    protected final int range;
    protected final DamageType damageType;

    AWeapon(int power, int range, DamageType damageType) {
        this.power = Math.max(1, power);
        this.range = Math.max(1, range);
        this.damageType = Objects.requireNonNull(damageType);
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