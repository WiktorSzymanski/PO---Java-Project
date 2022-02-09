package pl.vik.gm;

public class Skill {

    public enum skillType {
        ATTACK,
        HEAL,
        BUFF
    }

    String name;
    skillType type;
    Integer maxEfficiency;
    Integer minEfficiency;
    Integer energyCost;


    public Skill(String name, skillType type, Integer minEfficiency, Integer maxEfficiency, Integer energyCost) {
        this.name = name;
        this.type = type;
        this.maxEfficiency = maxEfficiency;
        this.minEfficiency = minEfficiency;
        this.energyCost = energyCost;
    }
}
