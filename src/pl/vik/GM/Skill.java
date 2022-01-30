package pl.vik.GM;

public class Skill {
    String name;
    String type;
    Integer maxEfficiency;
    Integer minEfficiency;

    Skill(String name,String type, Integer maxEfficiency, Integer minEfficiency) {
        this.name = name;
        this.type = type;
        this.maxEfficiency = maxEfficiency;
        this.minEfficiency = minEfficiency;
    }
}
