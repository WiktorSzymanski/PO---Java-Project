package pl.vik.gm.animals;

import java.io.Serializable;

public class Skill implements Serializable {

    public enum skillType {
        ATTACK,
        HEAL,
        BUFF
    }

    public String name;
    public skillType type;
    public Integer maxEfficiency;
    public Integer minEfficiency;
    public Integer energyCost;


    public Skill(String name, skillType type, Integer minEfficiency, Integer maxEfficiency, Integer energyCost) {
        this.name = name;
        this.type = type;
        this.maxEfficiency = maxEfficiency;
        this.minEfficiency = minEfficiency;
        this.energyCost = energyCost;
    }
}
