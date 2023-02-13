package org.example.heroes;

public class Mage extends Hero{
    //private static final int[] mageStartingAttributes = {1, 1, 8};
    //private static final int[] mageLevelUpAttributes = {1, 1, 5};.
    private static final String heroType = "Mage";
    private static final int MAGE_STARTING_STRENGTH = 1;
    private static final int MAGE_STARTING_DEXTERITY = 1;
    private static final int MAGE_STARTING_INTELLIGENCE = 8;
    private static final int MAGE_LEVELING_STRENGTH = 1;
    private static final int MAGE_LEVELING_DEXTERITY = 1;
    private static final int MAGE_LEVELING_INTELLIGENCE = 5;

    public Mage(String name) {
        //super(name, heroType, new HeroAttribute(mageStartingAttributes[0], mageLevelUpAttributes[1], mageLevelUpAttributes[2]));
        super(name, heroType, new HeroAttribute(MAGE_STARTING_STRENGTH, MAGE_STARTING_DEXTERITY, MAGE_STARTING_INTELLIGENCE));
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
}
