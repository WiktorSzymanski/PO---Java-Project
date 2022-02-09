package pl.vik.gm.animals;

import java.util.HashMap;

public class Wolf extends Animal{
    public Wolf() {
        super();
        this.name = "Wolf";
        this.health = 75;
        this.energy = 75;
        this.skills = Skills();
        this.imgSource = "wolf.png";
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
