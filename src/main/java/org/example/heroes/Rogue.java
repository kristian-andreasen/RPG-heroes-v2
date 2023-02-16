package org.example.heroes;

import org.example.enums.ArmorType;
import org.example.enums.WeaponType;
import org.example.items.Armor;
import org.example.items.Weapon;

import java.util.List;

public class Rogue extends Hero{
    private static final String heroType = "ROGUE";
    private static final int ROGUE_STARTING_STRENGTH = 5;
    private static final int ROGUE_STARTING_DEXTERITY = 2;
    private static final int ROGUE_STARTING_INTELLIGENCE = 1;
    private static final int ROGUE_LEVELING_STRENGTH = 3;
    private static final int ROGUE_LEVELING_DEXTERITY = 2;
    private static final int ROGUE_LEVELING_INTELLIGENCE = 1;
    private static final List<WeaponType> rogueValidWeaponTypes = List.of(WeaponType.AXE, WeaponType.HAMMER,  WeaponType.SWORD);
    private static final List<ArmorType> rogueValidArmorTypes = List.of(ArmorType.MAIL, ArmorType.PLATE);

    public Rogue(String name) {
        super(name, heroType, new HeroAttribute(ROGUE_STARTING_STRENGTH, ROGUE_STARTING_DEXTERITY, ROGUE_STARTING_INTELLIGENCE), rogueValidWeaponTypes, rogueValidArmorTypes);
    }

    @Override
    void increaseBaseAttributes() {
        int currentIntelligence = this.levelAttributes.getIntelligence();
        int currentStrength = this.levelAttributes.getStrength();
        int currentDexterity = this.levelAttributes.getDexterity();

        int updatedIntelligence = currentIntelligence + ROGUE_LEVELING_INTELLIGENCE;
        int updatedStrength = currentStrength + ROGUE_LEVELING_STRENGTH;
        int updatedDexterity = currentDexterity + ROGUE_LEVELING_DEXTERITY;

        this.levelAttributes.setIntelligence(updatedIntelligence);
        this.levelAttributes.setStrength(updatedStrength);
        this.levelAttributes.setDexterity(updatedDexterity);
    }

    @Override
    boolean isValidWeapon(Weapon weapon) {
        return rogueValidWeaponTypes.contains(weapon.getWeaponType());
    }

    @Override
    boolean isValidArmor(Armor armor) {
        return rogueValidArmorTypes.contains(armor.getArmorType());
    }
}
