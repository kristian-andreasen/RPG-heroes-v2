package org.example.heroes;

import org.example.enums.*;
import org.example.items.*;
import org.example.exceptions.InvalidItemException;

import java.text.DecimalFormat;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public abstract class Hero {
    protected String name;
    protected int level;
    protected HeroAttribute levelAttributes;
    protected HeroAttribute totalAttributes;
    protected String heroType;
    // Map to store the equipment, with Slot as the key and Item as the value
    protected Map<Slot, Item> equipment = new EnumMap<>(Slot.class);

    private List<WeaponType> validWeaponTypes;
    private List<ArmorType> validArmorTypes;

    public Hero(String name, String heroType, HeroAttribute levelAttributes, List<WeaponType> validWeaponTypes, List<ArmorType> validArmorTypes) {
        this.name = name;
        this.level = 1;
        this.heroType = heroType;
        this.levelAttributes = levelAttributes;
        //this.totalAttributes = new HeroAttribute(0,0,0);
        this.validWeaponTypes = validWeaponTypes;
        this.validArmorTypes = validArmorTypes;

        // initialize equipment to have each slot as an entry with null values
        for (Slot slot : Slot.values()) {
            this.equipment.put(slot, null);
        }
    }

    public String getName() {
        return name;
    }

    public String getHeroType() {
        return heroType;
    }

    public int getLevel() {
        return level;
    }

    public HeroAttribute getLevelAttributes(){
        return levelAttributes;
    }

    public Map<Slot, Item> getEquipment() {
        return equipment;
    }

    public List<WeaponType> getValidWeaponTypes() {
        return validWeaponTypes;
    }

    public List<ArmorType> getValidArmorTypes() {
        return validArmorTypes;
    }

    public void levelUp(){
        level++;
        increaseBaseAttributes();
    }

    abstract void increaseBaseAttributes();

    public void equipWeapon(Weapon weapon) throws InvalidItemException{
        if(!isValidWeapon(weapon)) {
            throw new InvalidItemException("This hero cannot equip this weapon");
        }
        if(level < weapon.getRequiredLevel()){
            throw new InvalidItemException("The hero's level is not high enough to equip this weapon");
        }
        equipment.put(Slot.WEAPON, weapon);
    }

    public void equipArmor(Armor armor, Slot slot) throws InvalidItemException{
        if (!isValidArmor(armor)) {
            throw new InvalidItemException("This hero cannot equip this type of armor");
        }
        if (level < armor.getRequiredLevel()){
            throw new InvalidItemException("The hero does not meet the level requirement for this armor");
        }
        equipment.put(slot, armor);
    }

    public void unequipArmor(Slot slot) {
        Armor armor = (Armor) equipment.get(slot);
        if(armor == null){
            return;
        }
        levelAttributes.remove(armor.getArmorAttributes());
        equipment.put(slot, null);
    }

    protected boolean isValidWeapon(Weapon weapon){
        return true;
    }

    protected boolean isValidArmor(Armor armor){
        return true;
    }

    public void calculateTotalAttributes(){
        for(Slot slot : Slot.values()){
            Item item = equipment.get(slot);

            if(item != null && item instanceof Armor){
                Armor armor = (Armor) item;
                levelAttributes.add(armor.getArmorAttributes());
            }
        }
    }

    public double calculateDamage() {
        double damagingAttribute = 0;
        Weapon equippedWeapon = (Weapon) equipment.get(Slot.WEAPON);

        if(this instanceof Mage){
            damagingAttribute = levelAttributes.getIntelligence();
        }

        if(equippedWeapon == null){
            return 1;
        }

        double damage = equippedWeapon.getWeaponDamage()*(1+damagingAttribute/100);
        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        //return Double.parseDouble(decimalFormat.format(damage));
        return damage;
    }

    public String displayStats() {
        StringBuilder sb = new StringBuilder();
        sb.append("name: " + name + " | ");
        sb.append("heroType: " + heroType + " | ");
        sb.append("level: " + level + " | ");
        sb.append(levelAttributes);
        return sb.toString();
    }

}
