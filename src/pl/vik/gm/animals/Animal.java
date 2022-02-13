package pl.vik.gm.animals;


import javax.swing.*;
import java.io.Serializable;
import java.util.HashMap;

public abstract class Animal implements Serializable {
    private String name;
    private Integer health;
    private Integer energy;
    private HashMap<Integer, Skill> skills;
    private ImageIcon image;

    Animal(){}

    public String getName() {
        return name;
    }

    public Integer getHealth() {
        return health;
    }

    public Integer getEnergy() {
        return energy;
    }

    public void setEnergy(Integer energy) {
        this.energy = energy;
    }

    public HashMap<Integer, Skill> getSkills() {
        return skills;
    }

    public void setSkills(HashMap<Integer, Skill> skills) {
        this.skills = skills;
    }

    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }
}
