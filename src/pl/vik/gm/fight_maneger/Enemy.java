package pl.vik.gm.fight_maneger;

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
        this.setFightManager(fightManager);
        this.setEnemy(fightManager.getEnemyAnimal());
        this.setCurrentHealth(this.getEnemy().getHealth());
        this.setCurrentEnergy(this.getEnemy().getEnergy());
    }

    @Override
    public void attack(Skill skill) {
        int efficiency = random.nextInt(skill.getMaxEfficiency() - skill.getMinEfficiency() + 1) + skill.getMinEfficiency();

        getFightManager().dealDmg(efficiency);
        System.out.println("Enemy Attacked for " + efficiency);
    }

    @Override
    public void heal(Skill skill) {
        int efficiency = random.nextInt(skill.getMaxEfficiency() - skill.getMinEfficiency() + 1) + skill.getMinEfficiency();

        if (getCurrentHealth() + efficiency < getEnemy().getHealth()) {
            setCurrentHealth(getCurrentHealth() + efficiency);
        } else {
            setCurrentHealth(getEnemy().getHealth());
        }
    }

    @Override
    public void buff(Skill skill) {
        int efficiency = random.nextInt(skill.getMaxEfficiency() - skill.getMinEfficiency() + 1) + skill.getMinEfficiency();


        System.out.println("Enemy rested (restored " + regen(efficiency) + " energy)");
    }


    @Override
    public boolean makeMove(Skill skill) {
        if (haveEnergyToMakeThatMove(skill)) {
            useSkill(skill);
            setCurrentEnergy(getCurrentEnergy() - skill.getEnergyCost());

            return true;
        }

        return false;
    }

    public void enemyAI() {
        if (!makeMove(getEnemy().getSkills().get(1))) {
            useSkill(getEnemy().getSkills().get(3));
        }

    }

    @Override
    public int regen(int efficiency) {
        if(getCurrentEnergy() + efficiency > getEnemy().getEnergy()) {
            int restored = getEnemy().getEnergy() - getCurrentEnergy();
            setCurrentEnergy(getEnemy().getEnergy());
            return restored;
        } else {
            setCurrentEnergy(getCurrentEnergy() + efficiency);
            return efficiency;
        }
    }

    @Override
    public void useSkill(Skill skill) {
        switch (skill.getType()) {
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
        if (getCurrentEnergy() >= skill.getEnergyCost()) {
            return true;
        }
        return false;
    }

    public Animal getEnemy() {
        return enemy;
    }

    public void setEnemy(Animal enemy) {
        this.enemy = enemy;
    }

    public FightManager getFightManager() {
        return fightManager;
    }

    public void setFightManager(FightManager fightManager) {
        this.fightManager = fightManager;
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
