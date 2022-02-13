package pl.vik.gm.animals;

import javax.swing.*;
import java.util.HashMap;

public class Bull extends Animal{
    public Bull() {
        super();
        this.setName("Bull");
        this.setHealth(100);
        this.setEnergy(50);
        this.setSkills(Skills());
        this.setImage(new ImageIcon("img/bull.png"));
    }

    HashMap<Integer, Skill> Skills () {
        HashMap<Integer,Skill> Skills = new HashMap<>();
        Skills.put(1,Attack());
        Skills.put(2,Heal());
        Skills.put(3,Buff());

        return Skills;
    }

    Skill Attack() {
        return new Skill("Charge", Skill.skillType.ATTACK, 10, 30, 25);
    }

    Skill Heal() {
        return new Skill("Health Regen", Skill.skillType.HEAL, 10,15, 20);
    }

    Skill Buff() {
        return new Skill("Energy Regen", Skill.skillType.BUFF, 20, 30, 0);
    }
}
