package org.example.items;

import org.example.enums.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeaponTest {

    // Test to verify that a Weapon is created with name, requiredLevel, Slot, weaponType, and weaponDamage.
    @Test
    public void testWeaponCreation() {
        Weapon staff = new Weapon("Atiesh", 1, Slot.WEAPON, WeaponType.STAFF, 5);
        assertEquals("Atiesh", staff.name);
        assertEquals(1, staff.requiredLevel);
        assertEquals(Slot.WEAPON, staff.slot);
        assertEquals( WeaponType.STAFF, staff.getWeaponType());
        assertEquals(5, staff.getWeaponDamage());
    }


}