package pl.vik.gm.animals;

import javax.swing.*;
import java.util.HashMap;

public class Beetle extends Animal{
    public Beetle() {
        super();
        this.name = "Beetle";
        this.health = 30;
        this.energy = 15;
        this.skills = antSkills();
        this.image = new ImageIcon("img/beetle.png");
    }

    HashMap<Integer, Skill> antSkills () {
        HashMap<Integer,Skill> Skills = new HashMap<>();
        Skills.put(1,Attack());
        Skills.put(2,Heal());
        Skills.put(3,Buff());

        return Skills;
    }

    Skill Attack() {
        return new Skill("Bite", Skill.skillType.ATTACK, 1, 3, 5);
    }

    Skill Heal() {
        return new Skill("Health Regen", Skill.skillType.HEAL, 3,4, 5);
    }

    Skill Buff() {
        return new Skill("Energy Regen", Skill.skillType.BUFF, 4, 6, 0);
    }
}
