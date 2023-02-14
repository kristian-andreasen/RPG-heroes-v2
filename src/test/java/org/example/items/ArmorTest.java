package org.example.items;

import org.example.enums.ArmorType;
import org.example.enums.*;
import org.example.heroes.HeroAttribute;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArmorTest {
    Armor armor;

    @BeforeEach
    void init(){
        armor = new Armor("Arcanist Crown", 1, Slot.HEAD, ArmorType.CLOTH, new HeroAttribute(1,1,1));
    }

    @Test
    void getName() {
        assertEquals("Arcanist Crown", armor.getName());
    }

    @Test
    void getRequiredLevel() {
        assertEquals(1, armor.getRequiredLevel());
    }

    @Test
    void getSlot() {
        assertEquals(Slot.HEAD, armor.getSlot());
    }


    @Test
    void getArmorType() {
        assertEquals(ArmorType.CLOTH, armor.getArmorType());
    }

    @Test
    void getArmorAttributes() {
        HeroAttribute expected = new HeroAttribute(1,1,1);
        assertEquals(expected, armor.getArmorAttributes());
    }
}