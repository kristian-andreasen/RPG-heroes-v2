package org.example.items;

import org.example.enums.ArmorType;
import org.example.enums.*;
import org.example.heroes.HeroAttribute;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArmorTest {

    // Test to verify that an Armor is created with name, requiredLevel, Slot, armorType, and armorAttributes.
    @Test
    public void testArmorCreation() {
        Armor head = new Armor("Arcanist Crown", 1, Slot.HEAD, ArmorType.CLOTH, new HeroAttribute(1,1,1));
        assertEquals("Arcanist Crown", head.name);
        assertEquals(1, head.requiredLevel);
        assertEquals(Slot.HEAD, head.slot);
        assertEquals(ArmorType.CLOTH, head.getArmorType());
        assertEquals(1, head.armorAttributes.getStrength());
        assertEquals(1, head.armorAttributes.getDexterity());
        assertEquals(1, head.armorAttributes.getIntelligence());
    }
}