package pl.vik.gm.animals;

import pl.vik.gm.Skill;

import java.util.HashMap;

public class Mantis extends Animal{
    public Mantis() {
        super();
        this.name = "Mantis";
        this.health = 20;
        this.energy = 15;
        this.skills = Skills();
        this.imgSource = "ant.png";
    }

    HashMap<Integer, Skill> Skills () {
        HashMap<Integer,Skill> Skills = new HashMap<>();
        Skills.put(1,Attack());
        Skills.put(2,Heal());
        Skills.put(3,Buff());

        return Skills;
    }

    Skill Attack() {
        return new Skill("Bite", Skill.skillType.ATTACK, 5, 6,5);
    }

    Skill Heal() {
        return new Skill("Health Regen", Skill.skillType.HEAL, 1,3,5);
    }

    Skill Buff() {
        return new Skill("Energy Regen", Skill.skillType.BUFF, 1, 4, 0);
    }
}
