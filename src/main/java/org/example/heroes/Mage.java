package org.example.heroes;

import org.example.enums.ArmorType;
import org.example.enums.WeaponType;
import org.example.items.Armor;
import org.example.items.Weapon;

import java.util.List;

public class Mage extends Hero{
    private static final String heroType = "Mage";
    private static final int MAGE_STARTING_STRENGTH = 1;
    private static final int MAGE_STARTING_DEXTERITY = 1;
    private static final int MAGE_STARTING_INTELLIGENCE = 8;
    private static final int MAGE_LEVELING_STRENGTH = 1;
    private static final int MAGE_LEVELING_DEXTERITY = 1;
    private static final int MAGE_LEVELING_INTELLIGENCE = 5;

    // instance field which is a constant list of valid weapon types for a mage.
    // the list is created using the List.of() method which returns a list with the elements specified.
    private static final List<WeaponType> mageValidWeaponTypes = List.of(WeaponType.STAFF, WeaponType.WAND);
    private static final List<ArmorType> mageValidArmorTypes = List.of(ArmorType.CLOTH);

    public Mage(String name) {
        //super(name, heroType, new HeroAttribute(mageStartingAttributes[0], mageLevelUpAttributes[1], mageLevelUpAttributes[2]));
        super(name, heroType, new HeroAttribute(MAGE_STARTING_STRENGTH, MAGE_STARTING_DEXTERITY, MAGE_STARTING_INTELLIGENCE), mageValidWeaponTypes, mageValidArmorTypes);
    }

    @Override
    void increaseBaseAttributes() {
        int currentIntelligence = this.levelAttributes.getIntelligence();
        int currentStrength = this.levelAttributes.getStrength();
        int currentDexterity = this.levelAttributes.getDexterity();

        int updatedIntelligence = currentIntelligence + MAGE_LEVELING_INTELLIGENCE;
        int updatedStrength = currentStrength + MAGE_LEVELING_STRENGTH;
        int updatedDexterity = currentDexterity + MAGE_LEVELING_DEXTERITY;

        this.levelAttributes.setIntelligence(updatedIntelligence);
        this.levelAttributes.setStrength(updatedStrength);
        this.levelAttributes.setDexterity(updatedDexterity);
    }

    @Override
    public boolean isValidWeapon(Weapon weapon){
        return mageValidWeaponTypes.contains(weapon.getWeaponType());
    }

    @Override
    public boolean isValidArmor(Armor armor){
        return mageValidArmorTypes.contains(armor.getArmorType());
    }
}
