package org.example.heroes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {
    Mage mage;

    @BeforeEach
    void init(){
        mage = new Mage("Jaina Proudmoore");
    }

    @Test
    void getName(){
        String expectedName = "Jaina Proudmoore";
        String actualName = mage.getName();
        assertEquals(expectedName, actualName);
    }

    @Test
    void getLevelAttributes() {
        int actualStrength = mage.levelAttributes.getStrength();
        int actualDexterity = mage.levelAttributes.getDexterity();
        int actualIntelligence = mage.levelAttributes.getIntelligence();

        int expectedStrength = 1;
        int expectedDexterity = 1;
        int expectedIntelligence = 8;

        assertEquals(expectedStrength, actualStrength);
        assertEquals(expectedDexterity, actualDexterity);
        assertEquals(expectedIntelligence, actualIntelligence);
    }

    @Test
    void getLevel(){
        int expectedLevel = 1;
        int actualLevel = mage.getLevel();
        assertEquals(expectedLevel, actualLevel);
    }

    @Test
    void levelUp() {
        mage.levelUp();
        mage.levelUp();
        mage.levelUp();

        int expected = 4;
        int actual = mage.getLevel();

        assertEquals(expected, actual);
    }

    @Test
    void increaseAttributes() {
        mage.increaseBaseAttributes();

        int expectedStrength = 2;
        int expectedDexterity = 2;
        int expectedIntelligence = 13;

        int actualStrength = mage.levelAttributes.getStrength();
        int actualDexterity = mage.levelAttributes.getDexterity();
        int actualIntelligence = mage.levelAttributes.getIntelligence();

        assertEquals(expectedStrength, actualStrength);
        assertEquals(expectedDexterity, actualDexterity);
        assertEquals(expectedIntelligence, actualIntelligence);
    }
}