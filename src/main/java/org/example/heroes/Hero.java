package org.example.heroes;

public abstract class Hero {
    protected String name;
    protected int level;
    protected HeroAttribute levelAttributes;
    protected String heroType;

    public Hero(String name, String heroType, HeroAttribute levelAttributes) {
        this.name = name;
        this.level = 1;
        this.heroType = heroType;
        this.levelAttributes = levelAttributes;
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

    public void levelUp(){
        level++;
        increaseBaseAttributes();
    }

    abstract void increaseBaseAttributes();

    public HeroAttribute getLevelAttributes(){
        return levelAttributes;
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
