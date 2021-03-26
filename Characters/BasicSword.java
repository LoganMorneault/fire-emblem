package Characters;

/**
 * Class representing a basic sword
 */
public class BasicSword implements IWeapon {
    private final int power;
    private final int range;
    private final DamageType damageType;

    BasicSword(int power) {
        this.power = Math.max(1, power);
        this.range = 1;
        this.damageType = DamageType.Physical;
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
