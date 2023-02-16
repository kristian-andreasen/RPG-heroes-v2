package org.example.heroes;

import org.example.enums.ArmorType;
import org.example.enums.WeaponType;
import org.example.items.Armor;
import org.example.items.Weapon;

import java.util.List;

public class Ranger extends Hero{
    private static final String heroType = "RANGER";
    private static final int RANGER_STARTING_STRENGTH = 5;
    private static final int RANGER_STARTING_DEXTERITY = 2;
    private static final int RANGER_STARTING_INTELLIGENCE = 1;
    private static final int RANGER_LEVELING_STRENGTH = 3;
    private static final int RANGER_LEVELING_DEXTERITY = 2;
    private static final int RANGER_LEVELING_INTELLIGENCE = 1;
    private static final List<WeaponType> rangerValidWeaponTypes = List.of(WeaponType.AXE, WeaponType.HAMMER,  WeaponType.SWORD);
    private static final List<ArmorType> rangerValidArmorTypes = List.of(ArmorType.MAIL, ArmorType.PLATE);


    public Ranger(String name) {
        super(name, heroType, new HeroAttribute(RANGER_STARTING_STRENGTH, RANGER_STARTING_DEXTERITY, RANGER_STARTING_INTELLIGENCE), rangerValidWeaponTypes, rangerValidArmorTypes);
    }

    @Override
    void increaseBaseAttributes() {
        int currentIntelligence = this.levelAttributes.getIntelligence();
        int currentStrength = this.levelAttributes.getStrength();
        int currentDexterity = this.levelAttributes.getDexterity();

        int updatedIntelligence = currentIntelligence + RANGER_LEVELING_INTELLIGENCE;
        int updatedStrength = currentStrength + RANGER_LEVELING_STRENGTH;
        int updatedDexterity = currentDexterity + RANGER_LEVELING_DEXTERITY;

        this.levelAttributes.setIntelligence(updatedIntelligence);
        this.levelAttributes.setStrength(updatedStrength);
        this.levelAttributes.setDexterity(updatedDexterity);
    }

    @Override
    boolean isValidWeapon(Weapon weapon) {
        return rangerValidWeaponTypes.contains(weapon.getWeaponType());
    }

    @Override
    boolean isValidArmor(Armor armor) {
        return rangerValidArmorTypes.contains(armor.getArmorType());
    }
}
