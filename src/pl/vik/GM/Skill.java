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


    Skill(String name,skillType type, Integer maxEfficiency, Integer minEfficiency) {
        this.name = name;
        this.type = type;
        this.maxEfficiency = maxEfficiency;
        this.minEfficiency = minEfficiency;
    }
}
