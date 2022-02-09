package pl.vik.gm.animals;

import pl.vik.gm.Skill;

import java.util.HashMap;

public class Ant extends Animal{
    public Ant() {
        super();
        this.name = "Ant";
        this.health = 15;
        this.energy = 15;
        this.skills = Skills();
        this.imgSource = "ant.png";
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
