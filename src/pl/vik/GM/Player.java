package pl.vik.GM;

import java.util.ArrayList;

public class Player extends Animal implements Actions{

    private Integer currentHealth;
    private Integer currentEnergy;

    Player(String name, Integer health, Integer energy, ArrayList<Skill> skills, String imgSource) {
        super(name, health, energy, skills, imgSource);
    }

    public void printActionList() {
        for ( Skill skill : skills) {
            System.out.println(skill.name + " (" + skill.minEfficiency + "-" + skill.maxEfficiency + " " + skill.type + ")");
        }
    }

    @Override
    public void attack(Skill skill) {

    }

    @Override
    public void heal(Skill skill) {

    }

    @Override
    public void buff(Skill skill) {

    }
}
