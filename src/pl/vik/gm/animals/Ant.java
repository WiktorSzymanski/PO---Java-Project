package pl.vik.gm.animals;

import javax.swing.*;
import java.util.HashMap;

public class Ant extends Animal{
    public Ant() {
        super();
        this.setName("Ant");
        this.setHealth(15);
        this.setEnergy(15);
        this.setSkills(Skills());
        this.setImage(new ImageIcon("img/ant.png"));
    }

    HashMap<Integer, Skill> Skills () {
        HashMap<Integer,Skill> antSkills = new HashMap<>();
        antSkills.put(1,Attack());
        antSkills.put(2,Heal());
        antSkills.put(3,Buff());

        return antSkills;
    }

    Skill Attack() {
        return new Skill("Bite", Skill.skillType.ATTACK, 3, 5, 5);
    }

    Skill Heal() {
        return new Skill("Health Regen", Skill.skillType.HEAL, 5,6, 5);
    }

    Skill Buff() {
        return new Skill("Energy Regen", Skill.skillType.BUFF, 3, 4, 0);
    }
}
