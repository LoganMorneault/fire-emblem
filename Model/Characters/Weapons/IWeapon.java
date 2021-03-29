package Model.Characters.Weapons;

import Model.Characters.DamageType;

/*
    An IWeapon has power and a damage type. Its damage is based on its power plus the strength stat of the user.
*/
public interface IWeapon {

    // What type of damage does this weapon deal?
    DamageType getDamageType();

    // What is the power stat of this weapon?
    int getPower();

    // What is the range of this weapon?
    int getRange();
}
