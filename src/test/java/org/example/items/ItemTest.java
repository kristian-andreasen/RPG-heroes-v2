package org.example.items;

import org.example.enums.ArmorType;
import org.example.enums.Slot;
import org.example.enums.WeaponType;
import org.example.heroes.HeroAttribute;
import org.example.heroes.Mage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {
    Item weapon;
    Item armor;

    @BeforeEach
    void init(){
        weapon = new Weapon("Atiesh", 1, Slot.WEAPON, WeaponType.STAFF, 5);
        armor = new Armor("Arcanist Crown", 1, Slot.HEAD, ArmorType.CLOTH, new HeroAttribute(1,1,1));

    }
    @Test
    void getName() {
        assertEquals("Atiesh", weapon.getName());
        assertEquals("Arcanist Crown", armor.getName());
    }

    @Test
    void getRequiredLevel() {
        assertEquals(1, weapon.getRequiredLevel());
        assertEquals(1, armor.getRequiredLevel());
    }

    @Test
    void getSlot() {
        assertEquals(Slot.WEAPON, weapon.getSlot());
        assertEquals(Slot.HEAD, armor.getSlot());
    }
}