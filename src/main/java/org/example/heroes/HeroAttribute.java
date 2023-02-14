package org.example.heroes;

public class HeroAttribute {
    private int strength;
    private int dexterity;
    private int intelligence;

    public HeroAttribute(int strength, int dexterity, int intelligence) {
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void add(HeroAttribute other){
        this.strength += other.strength;
        this.dexterity += other.dexterity;
        this.intelligence += other.intelligence;
    }

    public HeroAttribute remove(HeroAttribute attr){
        this.strength -= attr.strength;
        this.dexterity -= attr.dexterity;
        this.intelligence -= attr.intelligence;
        return this;
    }

    @Override
    public String toString() {
        return String.format("Strength: %d, Dexterity: %d, Intelligence: %d", strength, dexterity, intelligence);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HeroAttribute that = (HeroAttribute) o;
        return strength == that.strength && dexterity == that.dexterity && intelligence == that.intelligence;
    }

}
