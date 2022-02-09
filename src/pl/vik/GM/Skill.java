package pl.vik.GM;

public class Skill {

    enum skillType {
        ATTACK,
        HEAL,
        BUFF
    }

    String name;
    skillType type;
    Integer maxEfficiency;
    Integer minEfficiency;
    Integer energyCost;


    // Buff minEfficiency describe what kind of Buff, max ammount it buffs
    Skill(String name,skillType type, Integer minEfficiency, Integer maxEfficiency, Integer energyCost) {
        this.name = name;
        this.type = type;
        this.maxEfficiency = maxEfficiency;
        this.minEfficiency = minEfficiency;
        this.energyCost = energyCost;
    }
}
