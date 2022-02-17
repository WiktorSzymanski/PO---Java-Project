package pl.vik.gm.fight_manager;

import pl.vik.gm.animals.Skill;
import pl.vik.gm.animals.Animal;

import java.util.Random;

public class Enemy implements Actions {

    private Animal enemy = null;
    private FightManager fightManager = null;

    private Integer currentHealth;
    private Integer currentEnergy;

    Random random = new Random();

    Enemy(FightManager fightManager) {
        this.fightManager = fightManager;
        this.enemy = fightManager.getEnemyAnimal();
        this.setCurrentHealth(this.enemy.getHealth());
        this.setCurrentEnergy(this.enemy.getEnergy());
    }

    @Override
    public void attack(Skill skill) {
        int efficiency = random.nextInt(skill.maxEfficiency - skill.minEfficiency + 1) + skill.minEfficiency;

        fightManager.dealDmg(efficiency);
        System.out.println("Enemy Attacked for " + efficiency);
    }

    @Override
    public void heal(Skill skill) {
        int efficiency = random.nextInt(skill.maxEfficiency - skill.minEfficiency + 1) + skill.minEfficiency;

        if (getCurrentHealth() + efficiency < enemy.getHealth()) {
            setCurrentHealth(getCurrentHealth() + efficiency);
        } else {
            setCurrentHealth(enemy.getHealth());
        }
    }

    @Override
    public void buff(Skill skill) {
        int efficiency = random.nextInt(skill.maxEfficiency - skill.minEfficiency + 1) + skill.minEfficiency;


        System.out.println("Enemy rested (restored " + regen(efficiency) + " energy)");
    }


    @Override
    public boolean makeMove(Skill skill) {
        if (haveEnergyToMakeThatMove(skill)) {
            useSkill(skill);
            setCurrentEnergy(getCurrentEnergy() - skill.energyCost);

            return true;
        }

        return false;
    }

    public void enemyAI() {
        if (!makeMove(enemy.getSkills().get(1))) {
            useSkill(enemy.getSkills().get(3));
        }

    }

    @Override
    public int regen(int efficiency) {
        if(getCurrentEnergy() + efficiency > enemy.getEnergy()) {
            int restored = enemy.getEnergy() - getCurrentEnergy();
            setCurrentEnergy(enemy.getEnergy());
            return restored;
        } else {
            setCurrentEnergy(getCurrentEnergy() + efficiency);
            return efficiency;
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
    public void afterRoundRegen() {
        regen(3);
    }

    @Override
    public boolean haveEnergyToMakeThatMove(Skill skill) {
        if (getCurrentEnergy() >= skill.energyCost) {
            return true;
        }
        return false;
    }

    public Integer getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(Integer currentHealth) {
        this.currentHealth = currentHealth;
    }

    public Integer getCurrentEnergy() {
        return currentEnergy;
    }

    public void setCurrentEnergy(Integer currentEnergy) {
        this.currentEnergy = currentEnergy;
    }
}
