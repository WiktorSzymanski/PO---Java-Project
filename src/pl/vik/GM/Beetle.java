package pl.vik.GM;

import java.util.HashMap;

public class Beetle extends Animal{
    Beetle() {
        super();
        this.name = "Beetle";
        this.health = 30;
        this.energy = 15;
        this.skills = antSkills();
        this.imgSource = "ant.png";
    }

    HashMap<Integer,Skill> antSkills () {
        HashMap<Integer,Skill> antSkills = new HashMap<>();
        antSkills.put(1,Attack());
        antSkills.put(2,Heal());
        antSkills.put(3,Buff());

        return antSkills;
    }

    Skill Attack() {
        return new Skill("Bite", Skill.skillType.ATTACK, 1, 3, 5);
    }

    Skill Heal() {
        return new Skill("Health Regen", Skill.skillType.HEAL, 1,3, 5);
    }

    Skill Buff() {
        return new Skill("Energy Regen", Skill.skillType.BUFF, 1, 6, 0);
    }
}
