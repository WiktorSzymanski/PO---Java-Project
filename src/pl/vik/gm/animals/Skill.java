package pl.vik.gm.animals;

import java.io.Serializable;

public class Skill implements Serializable {

    public enum skillType {
        ATTACK,
        HEAL,
        BUFF
    }

    private String name;
    private skillType type;
    private Integer maxEfficiency;
    private Integer minEfficiency;
    private Integer energyCost;


    public Skill(String name, skillType type, Integer minEfficiency, Integer maxEfficiency, Integer energyCost) {
        this.setName(name);
        this.setType(type);
        this.setMaxEfficiency(maxEfficiency);
        this.setMinEfficiency(minEfficiency);
        this.setEnergyCost(energyCost);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public skillType getType() {
        return type;
    }

    public void setType(skillType type) {
        this.type = type;
    }

    public Integer getMaxEfficiency() {
        return maxEfficiency;
    }

    public void setMaxEfficiency(Integer maxEfficiency) {
        this.maxEfficiency = maxEfficiency;
    }

    public Integer getMinEfficiency() {
        return minEfficiency;
    }

    public void setMinEfficiency(Integer minEfficiency) {
        this.minEfficiency = minEfficiency;
    }

    public Integer getEnergyCost() {
        return energyCost;
    }

    public void setEnergyCost(Integer energyCost) {
        this.energyCost = energyCost;
    }
}
