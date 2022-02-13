package pl.vik.gm.animals;

import javax.swing.*;
import java.util.HashMap;

public class Wolf extends Animal{
    public Wolf() {
        super();
        this.setName("Wolf");
        this.setHealth(75);
        this.setEnergy(75);
        this.setSkills(Skills());
        this.setImage(new ImageIcon("img/wolf.png"));
    }

    HashMap<Integer, Skill> Skills () {
        HashMap<Integer,Skill> Skills = new HashMap<>();
        Skills.put(1,Attack());
        Skills.put(2,Heal());
        Skills.put(3,Buff());

        return Skills;
    }

    Skill Attack() {
        return new Skill("Bite", Skill.skillType.ATTACK, 15, 20, 20);
    }

    Skill Heal() {
        return new Skill("Health Regen", Skill.skillType.HEAL, 15,20, 20);
    }

    Skill Buff() {
        return new Skill("Energy Regen", Skill.skillType.BUFF, 15, 20, 0);
    }
}
