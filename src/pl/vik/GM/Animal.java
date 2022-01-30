package pl.vik.GM;

import java.util.ArrayList;

public abstract class Animal {
    String name;
    Integer health;
    Integer energy;
    ArrayList<Skill> skills;
    String imgSource;

    Animal(String name, Integer health, Integer energy, ArrayList<Skill> skills, String imgSource) {
        this.name = name;
        this.health = health;
        this.energy = energy;
        this.skills = skills;
        this.imgSource = imgSource;
    }
}
