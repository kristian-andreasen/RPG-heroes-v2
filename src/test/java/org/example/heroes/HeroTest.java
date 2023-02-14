package org.example.heroes;

import org.example.enums.*;
import org.example.items.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {
    Mage mage;

    @BeforeEach
    void init(){
        mage = new Mage("Jaina Proudmoore");
    }

    // All these tests are for testing the initial creation of a hero

    @Test
    void getName(){
        assertEquals("Jaina Proudmoore", mage.getName());
    }

    @Test
    void getLevel(){
        assertEquals(1, mage.getLevel());
    }

    @Test
    void getLevelAttributes(){
        HeroAttribute expected = new HeroAttribute(1,1,8);
        assertEquals(expected, mage.getLevelAttributes());
    }

    @Test
    void getHeroType() {
        assertEquals("Mage", mage.getHeroType());
    }

    @Test
    void getEquipment() {
        Map<Slot, Item> equipment = mage.getEquipment();
        for (Item item : equipment.values()) {
            assertNull(item);
        }
    }

    @Test
    void getValidWeaponTypes() {
        List<ArmorType> expected = List.of(ArmorType.CLOTH);
        assertEquals(expected, mage.getValidArmorTypes());
    }

    @Test
    void getValidArmorTypes() {
        List<WeaponType> expected = List.of(WeaponType.STAFF, WeaponType.WAND);
        assertEquals(expected, mage.getValidWeaponTypes());
    }

}