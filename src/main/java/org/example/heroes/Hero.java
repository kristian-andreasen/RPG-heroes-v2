package org.example.heroes;

import org.example.enums.*;
import org.example.items.*;
import org.example.exceptions.InvalidItemException;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public abstract class Hero {
    protected String name;
    protected int level;
    protected HeroAttribute levelAttributes;
    protected String heroType;
    // Map to store the equipment, with Slot as the key and Item as the value
    protected Map<Slot, Item> equipment = new EnumMap<>(Slot.class);

    private List<WeaponType> validWeaponTypes;
    private List<ArmorType> validArmorTypes;

    public Hero(String name, String heroType, HeroAttribute levelAttributes, List<WeaponType> validWeaponTypes, List<ArmorType> validArmorTypes) {
        this.name = name;
        this.level = 1;
        this.heroType = heroType;
        this.levelAttributes = levelAttributes;
        this.validWeaponTypes = validWeaponTypes;
        this.validArmorTypes = validArmorTypes;

        // initialize equipment to have each slot as an entry with null values
        for (Slot slot : Slot.values()) {
            this.equipment.put(slot, null);
        }
    }

    public String getName() {
        return name;
    }

    public String getHeroType() {
        return heroType;
    }

    public int getLevel() {
        return level;
    }

    public HeroAttribute getLevelAttributes(){
        return levelAttributes;
    }

    public Map<Slot, Item> getEquipment() {
        return equipment;
    }

    public List<WeaponType> getValidWeaponTypes() {
        return validWeaponTypes;
    }

    public List<ArmorType> getValidArmorTypes() {
        return validArmorTypes;
    }

    public void levelUp(){
        level++;
        increaseBaseAttributes();
    }

    abstract void increaseBaseAttributes();

    public void equipWeapon(Weapon weapon) throws InvalidItemException {
        // Check if the weapon's type is in the list of valid weapon types for the hero
        if (!validWeaponTypes.contains(weapon.getWeaponType())) {
            throw new InvalidItemException("This hero cannot equip this type of weapon");
        }

        Slot slot = weapon.getSlot();

        //put the weapon in the equipment map with the slot as the key and the weapon as the value
        equipment.put(slot, weapon);

    }

    public String displayStats() {
        StringBuilder sb = new StringBuilder();
        sb.append("name: " + name + " | ");
        sb.append("heroType: " + heroType + " | ");
        sb.append("level: " + level + " | ");
        sb.append(levelAttributes);
        return sb.toString();
    }

}
