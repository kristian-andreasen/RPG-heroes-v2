package org.example.heroes;

import org.example.enums.*;
import org.example.exceptions.InvalidItemException;
import org.example.items.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MageTest {
    Mage mage;

    @BeforeEach
    void init(){
        mage = new Mage("Jaina Proudmoore");
    }

    // Test to verify that a Hero's level increases correctly
    @Test
    public void mageLevelUp() {
        // Act
        mage.levelUp();
        mage.levelUp();
        mage.levelUp();

        // Assert
        assertEquals(4, mage.getLevel());
    }

    // Test to verify that a hero's levelAttributes are increased correctly after leveling
    @Test
    public void getLevelAttributes(){
        // Arrange
        HeroAttribute expected = new HeroAttribute(2,2,13);

        // Act
        mage.levelUp();

        // Assert
        assertEquals(expected, mage.getLevelAttributes());
    }

    @Test
    void equipWeapon_ofValidType() {
        Weapon staff = new Weapon("Atiesh", 1, Slot.WEAPON, WeaponType.STAFF, 5);

        try {
            mage.equipWeapon(staff);
        } catch (InvalidItemException e) {
            e.printStackTrace();
        }

        Weapon weapon = (Weapon) mage.getEquipment().get(Slot.WEAPON);

        assertEquals(staff, weapon, "Verify that weapon is equipped.");
    }

    @Test
    void equipWeapon_ofInvalidType(){
        Weapon sword = new Weapon("Thunderfury", 1, Slot.WEAPON, WeaponType.SWORD, 5);

        try {
            mage.equipWeapon(sword);
        } catch (InvalidItemException e) {
            e.printStackTrace();
        }
    }



    // Test to verify that a Hero's information is displayed correctly
    @Test
    void displayStats() {

        String expected = "name: Jaina Proudmoore | heroType: Mage | level: 1 | Strength: 1, Dexterity: 1, Intelligence: 8";

        assertEquals(expected, mage.displayStats());
    }

}