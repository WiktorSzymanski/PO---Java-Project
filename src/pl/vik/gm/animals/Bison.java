package pl.vik.gm.animals;

import javax.swing.*;
import java.util.HashMap;

public class Bison extends Animal{
    public Bison() {
        super();
        this.name = "Bison";
        this.health = 100;
        this.energy = 100;
        this.skills = Skills();
        this.image = new ImageIcon("img/bison.png");
    }

    HashMap<Integer, Skill> Skills () {
        HashMap<Integer,Skill> Skills = new HashMap<>();
        Skills.put(1,Attack());
        Skills.put(2,Heal());
        Skills.put(3,Buff());

        return Skills;
    }

    Skill Attack() {
        return new Skill("Bite", Skill.skillType.ATTACK, 10, 15, 20);
    }

    Skill Heal() {
        return new Skill("Health Regen", Skill.skillType.HEAL, 25,30, 20);
    }

    Skill Buff() {
        return new Skill("Energy Regen", Skill.skillType.BUFF, 20, 30, 0);
    }
}
