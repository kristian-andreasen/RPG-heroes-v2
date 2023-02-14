package org.example.items;

import org.example.enums.*;
import org.example.heroes.HeroAttribute;

public class Armor extends Item {
    private ArmorType armorType;
    protected HeroAttribute armorAttributes;

    public Armor(String name, int requiredLevel, Slot slot, ArmorType armorType, HeroAttribute armorAttributes) {
        super(name, requiredLevel, slot);
        this.armorType = armorType;
        this.armorAttributes = armorAttributes;
    }

    public ArmorType getArmorType() {
        return armorType;
    }

    public HeroAttribute getArmorAttributes() {
        return armorAttributes;
    }
}
