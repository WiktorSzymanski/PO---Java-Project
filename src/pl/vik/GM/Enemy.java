package pl.vik.GM;

import java.util.Random;

public class Enemy implements Actions{

    private Animal enemy = null;
    private FightManeger fightManeger = null;

    public Integer currentHealth;
    public Integer currentEnergy;

    Random random = new Random();

    Enemy(FightManeger fightManeger) {
        this.fightManeger = fightManeger;
        this.enemy = fightManeger.enemyAnimal;
        this.currentHealth = this.enemy.health;
        this.currentEnergy = this.enemy.energy;
    }

    @Override
    public void attack(Skill skill) {
        int efficiency = random.nextInt(skill.maxEfficiency - skill.minEfficiency) + skill.minEfficiency;

        fightManeger.dealDmg(efficiency);
    }

    @Override
    public void heal(Skill skill) {
        int efficiency = random.nextInt(skill.maxEfficiency - skill.minEfficiency) + skill.minEfficiency;

        if (currentHealth + efficiency < enemy.health) {
            currentHealth += efficiency;
        } else {
            currentHealth = enemy.health;
        }
    }

    @Override
    public void buff(Skill skill) {

    }

    @Override
    public void makeMove() {

    }
}
