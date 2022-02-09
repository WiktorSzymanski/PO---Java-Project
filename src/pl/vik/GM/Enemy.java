package pl.vik.GM;

import java.util.Random;

public class Enemy implements Actions {

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
        int efficiency = random.nextInt(skill.maxEfficiency - skill.minEfficiency + 1) + skill.minEfficiency;

        fightManeger.dealDmg(efficiency);
        System.out.println("Enemy Attacked for " + efficiency);
    }

    @Override
    public void heal(Skill skill) {
        int efficiency = random.nextInt(skill.maxEfficiency - skill.minEfficiency + 1) + skill.minEfficiency;

        if (currentHealth + efficiency < enemy.health) {
            currentHealth += efficiency;
        } else {
            currentHealth = enemy.health;
        }
    }

    @Override
    public void buff(Skill skill) {
        System.out.println("Enemy used Buff and did nothing");
    }

    @Override
    public void makeMove() {
        Skill skillToUse = enemy.skills.get(1);
        if (haveEnergyToMakeThatMove(skillToUse)) {
            useSkill(skillToUse);
            currentEnergy -= skillToUse.energyCost;
        } else {
            useSkill(enemy.skills.get(3));
        }
    }

    @Override
    public void regen() {
        if(currentEnergy + 3 > enemy.energy) {
            currentEnergy = enemy.energy;
        } else {
            currentEnergy += 3;
        }
    }

    @Override
    public void useSkill(Skill skill) {
        switch (skill.type) {
            case ATTACK -> attack(skill);
            case HEAL -> heal(skill);
            case BUFF -> buff(skill);
        }
    }

    @Override
    public boolean haveEnergyToMakeThatMove(Skill skill) {
        if (currentEnergy >= skill.energyCost) {
            return true;
        }
        return false;
    }
}
