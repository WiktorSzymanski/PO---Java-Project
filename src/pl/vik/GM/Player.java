package pl.vik.GM;

import java.util.ArrayList;
import java.util.Random;

public class Player implements Actions{

    private Animal player = null;
    private FightManeger fightManeger = null;

    public Integer currentHealth;
    public Integer currentEnergy;

    Random random = new Random();

    Player(FightManeger fightManeger) {
        this.fightManeger = fightManeger;
        this.player = fightManeger.playerAnimal;
        this.currentHealth = this.player.health;
        this.currentEnergy = this.player.energy;
    }

    public void printActionList() {
        for ( Skill skill : player.skills) {
            System.out.println(skill.name + " (" + skill.minEfficiency + "-" + skill.maxEfficiency + " " + skill.type + ")");
        }
    }

    @Override
    public void attack(Skill skill) {
        int efficiency = random.nextInt(skill.maxEfficiency - skill.minEfficiency + 1) + skill.minEfficiency - 1;

        fightManeger.dealDmg(efficiency);
        System.out.println("Player Attacked for " + efficiency);
    }

    @Override
    public void heal(Skill skill) {
        int efficiency = random.nextInt(skill.maxEfficiency - skill.minEfficiency + 1) + skill.minEfficiency - 1;

        if (currentHealth + efficiency < player.health) {
            currentHealth += efficiency;
        } else {
            currentHealth = player.health;
        }
    }

    @Override
    public void buff(Skill skill) {

    }

    @Override
    public void makeMove() {
        attack(new Skill("a", Skill.skillType.ATTACK,5,2));
    }
}
