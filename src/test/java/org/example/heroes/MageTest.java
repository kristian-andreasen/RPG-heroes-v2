package org.example.heroes;

import org.example.enums.*;
import org.example.exceptions.InvalidItemException;
import org.example.items.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MageTest {
    private Mage mage;
    private Weapon validWeapon;
    private Weapon invalidWeapon;
    private Armor validArmor;
    private Armor invalidArmor;

    @BeforeEach
    void init(){
        mage = new Mage("Jaina Proudmoore");

        validWeapon = new Weapon("Atiesh", 1, Slot.WEAPON, WeaponType.STAFF, 5);
        invalidWeapon = new Weapon("Thunderfury", 1, Slot.WEAPON, WeaponType.SWORD, 5);

        validArmor = new Armor("Cloth Robes", 1, Slot.BODY, ArmorType.CLOTH, new HeroAttribute(1,1,1));
        invalidArmor = new Armor("Leather Armor", 1, Slot.BODY, ArmorType.LEATHER, new HeroAttribute(1,1,1));
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
    void equipValidWeaponForMage() {
        boolean isWeaponEquipped = false;
        try {
            mage.equipWeapon(validWeapon);
            isWeaponEquipped = true;
        } catch (InvalidItemException e) {
            e.printStackTrace();
            fail("Mage should be able to equip staff");
        }
        assertTrue(isWeaponEquipped);
    }

    @Test
    void equipInvalidWeaponForMage(){
        assertThrows(InvalidItemException.class, () -> {
            mage.equipWeapon(invalidWeapon);
        });
    }

    @Test
    void equipWeaponBelowRequiredLevel(){
        validWeapon.setRequiredLevel(60);
        try {
            mage.equipWeapon(validWeapon);
            fail("should have thrown an InvalidItemException");
        } catch (InvalidItemException e) {
            assertEquals("The hero's level is not high enough to equip this weapon", e.getMessage());
        }
    }

    @Test
    void equipValidArmorForMage(){
        boolean isArmorEquipped = false;
        try {
            mage.equipArmor(validArmor, Slot.BODY);
            isArmorEquipped = true;
        } catch (InvalidItemException e) {
            e.printStackTrace();
            fail("Mage should be able to equip cloth");
        }
        assertTrue(isArmorEquipped);
    }

    @Test
    void equipInvalidArmorForMage(){
        assertThrows(InvalidItemException.class, () -> {
            mage.equipArmor(invalidArmor, Slot.BODY);
        });
    }

    @Test
    void equipArmorBelowRequiredLevel(){
        validArmor.setRequiredLevel(60);
        try {
            mage.equipArmor(validArmor, Slot.BODY);
            fail("should have thrown an InvalidItemException");
        } catch (InvalidItemException e) {
            assertEquals("The hero does not meet the level requirement for this armor", e.getMessage());
        }
    }

    @Test
    void calculateTotalAttributesWithOneArmor(){
        Armor armor1 = new Armor("Test Armor", 1, Slot.HEAD, ArmorType.CLOTH, new HeroAttribute(1,1,1));

        try {
            mage.equipArmor(armor1, Slot.HEAD);
        } catch(InvalidItemException e){
            e.printStackTrace();
        }

        mage.calculateTotalAttributes();

        HeroAttribute expectedAttributes = new HeroAttribute(2,2,9);
        HeroAttribute actualAttributes = mage.getLevelAttributes();

        assertEquals(expectedAttributes, actualAttributes);
    }

    @Test
    void calculateTotalAttributesWithTwoArmor() {
        Armor armor1 = new Armor("Test Armor 1", 1, Slot.HEAD, ArmorType.CLOTH, new HeroAttribute(1,1,1));
        Armor armor2 = new Armor("Test Armor 2", 1, Slot.BODY, ArmorType.CLOTH, new HeroAttribute(1,1,1));

        try {
            mage.equipArmor(armor1, Slot.HEAD);
            mage.equipArmor(armor2, Slot.BODY);
        } catch(InvalidItemException e){
            e.printStackTrace();
        }
        mage.calculateTotalAttributes();

        HeroAttribute expectedAttributes = new HeroAttribute(3,3,10);
        HeroAttribute actualAttributes = mage.getLevelAttributes();

        assertEquals(expectedAttributes, actualAttributes);
    }

    @Test
    void calculateTotalAttributesWithThreeArmor() {
        Armor armor1 = new Armor("Test Armor 1", 1, Slot.HEAD, ArmorType.CLOTH, new HeroAttribute(1,1,1));
        Armor armor2 = new Armor("Test Armor 2", 1, Slot.BODY, ArmorType.CLOTH, new HeroAttribute(1,1,1));
        Armor armor3 = new Armor("Test Armor 3", 1, Slot.LEGS, ArmorType.CLOTH, new HeroAttribute(1,1,1));

        try {
            mage.equipArmor(armor1, Slot.HEAD);
            mage.equipArmor(armor2, Slot.BODY);
            mage.equipArmor(armor3, Slot.LEGS);
        } catch(InvalidItemException e){
            e.printStackTrace();
        }
        mage.calculateTotalAttributes();

        HeroAttribute expectedAttributes = new HeroAttribute(4,4,11);
        HeroAttribute actualAttributes = mage.getLevelAttributes();

        assertEquals(expectedAttributes, actualAttributes);
    }

    @Test
    void replacedArmor(){
        Armor armor1 = new Armor("Test Armor 1", 1, Slot.HEAD, ArmorType.CLOTH, new HeroAttribute(1,1,1));
        Armor armor2 = new Armor("Test Armor 2", 1, Slot.HEAD, ArmorType.CLOTH, new HeroAttribute(2,2,2));

        try {
            mage.equipArmor(armor1, Slot.HEAD);
        } catch(InvalidItemException e){
            e.printStackTrace();
        }

        mage.calculateTotalAttributes();


        try {
            mage.unequipArmor(Slot.HEAD);
            mage.equipArmor(armor2, Slot.HEAD);
        } catch(InvalidItemException e){
            e.printStackTrace();
        }

        mage.calculateTotalAttributes();

        HeroAttribute expectedAttributes = new HeroAttribute(3,3,10);
        HeroAttribute actualAttributes = mage.getLevelAttributes();

        assertEquals(expectedAttributes, actualAttributes);
    }

    @Test
    public void calculateDamage(){
        try {
            mage.equipWeapon(validWeapon);
        } catch (InvalidItemException e) {
            e.printStackTrace();
            fail("Mage should be able to equip staff");
        }

        double expectedDamage = validWeapon.getWeaponDamage()*(1+(double)mage.getLevelAttributes().getIntelligence()/100);
        double actualDamage = mage.calculateDamage();
        assertEquals(expectedDamage, actualDamage);
    }

    // Test to verify that a Hero's information is displayed correctly
    @Test
    void displayStats() {

        String expected = "name: Jaina Proudmoore | heroType: Mage | level: 1 | Strength: 1, Dexterity: 1, Intelligence: 8";

        assertEquals(expected, mage.displayStats());
    }

}