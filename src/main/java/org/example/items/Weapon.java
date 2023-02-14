package org.example.items;

import org.example.enums.*;

public class Weapon extends Item{
    private WeaponType weaponType;
    private int weaponDamage;

    /**
     * Constructor for the Weapon class
     * @param name the name of the weapon
     * @param requiredLevel the required level to equip the weapon
     * @param weaponType the type of the weapon
     * @param weaponDamage the damage dealt by the weapon
     */
    public Weapon(String name, int requiredLevel, Slot slot, WeaponType weaponType, int weaponDamage) {
        super(name, requiredLevel, Slot.WEAPON);
        this.weaponType = weaponType;
        this.weaponDamage = weaponDamage;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }


}
