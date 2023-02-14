package org.example.items;

import org.example.enums.*;
import org.example.heroes.HeroAttribute;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeaponTest {
    Weapon weapon;

    @BeforeEach
    void init(){
        weapon = new Weapon("Atiesh", 1, Slot.WEAPON, WeaponType.STAFF, 5);
    }

    @Test
    void getName() {
        assertEquals("Atiesh", weapon.getName());
    }

    @Test
    void getRequiredLevel() {
        assertEquals(1, weapon.getRequiredLevel());
    }

    @Test
    void getSlot() {
        assertEquals(Slot.WEAPON, weapon.getSlot());
    }

    @Test
    void getWeaponType() {
        assertEquals(WeaponType.STAFF, weapon.getWeaponType());
    }

    @Test
    void getWeaponDamage() {
        assertEquals(5, weapon.getWeaponDamage());
    }
}