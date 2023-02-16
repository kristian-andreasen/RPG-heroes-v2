package org.example.heroes;

import org.example.enums.ArmorType;
import org.example.enums.WeaponType;
import org.example.items.Armor;
import org.example.items.Weapon;

import java.util.List;

public class Warrior extends Hero{
    private static final String heroType = "WARRIOR";
    private static final int WARRIOR_STARTING_STRENGTH = 5;
    private static final int WARRIOR_STARTING_DEXTERITY = 2;
    private static final int WARRIOR_STARTING_INTELLIGENCE = 1;
    private static final int WARRIOR_LEVELING_STRENGTH = 3;
    private static final int WARRIOR_LEVELING_DEXTERITY = 2;
    private static final int WARRIOR_LEVELING_INTELLIGENCE = 1;
    private static final List<WeaponType> warriorValidWeaponTypes = List.of(WeaponType.AXE, WeaponType.HAMMER,  WeaponType.SWORD);
    private static final List<ArmorType> warriorValidArmorTypes = List.of(ArmorType.MAIL, ArmorType.PLATE);

    public Warrior(String name) {
        super(name, heroType, new HeroAttribute(WARRIOR_STARTING_STRENGTH, WARRIOR_STARTING_DEXTERITY, WARRIOR_STARTING_INTELLIGENCE), warriorValidWeaponTypes, warriorValidArmorTypes);
    }

    @Override
    void increaseBaseAttributes() {
        int currentIntelligence = this.levelAttributes.getIntelligence();
        int currentStrength = this.levelAttributes.getStrength();
        int currentDexterity = this.levelAttributes.getDexterity();

        int updatedIntelligence = currentIntelligence + WARRIOR_LEVELING_INTELLIGENCE;
        int updatedStrength = currentStrength + WARRIOR_LEVELING_STRENGTH;
        int updatedDexterity = currentDexterity + WARRIOR_LEVELING_DEXTERITY;

        this.levelAttributes.setIntelligence(updatedIntelligence);
        this.levelAttributes.setStrength(updatedStrength);
        this.levelAttributes.setDexterity(updatedDexterity);
    }

    @Override
    boolean isValidWeapon(Weapon weapon) {
        return warriorValidWeaponTypes.contains(weapon.getWeaponType());
    }

    @Override
    boolean isValidArmor(Armor armor) {
        return warriorValidArmorTypes.contains(armor.getArmorType());
    }
}
