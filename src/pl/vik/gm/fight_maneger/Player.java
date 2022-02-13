package pl.vik.gm.fight_maneger;


import pl.vik.gm.Exceptions.NoEnergyException;
import pl.vik.gm.Exceptions.Validators;
import pl.vik.gm.animals.Skill;
import pl.vik.gm.animals.Animal;
import pl.vik.ui.GamePanel;

import java.util.Random;

public class Player implements Actions{

    private Animal player;
    private FightManager fightManager;

    private Integer currentHealth;
    private Integer currentEnergy;

    Random random = new Random();

    Player(FightManager fightManager) {
        this.setFightManager(fightManager);
        this.setPlayer(fightManager.getPlayerAnimal());
        this.setCurrentHealth(this.getPlayer().getHealth());
        this.setCurrentEnergy(this.getPlayer().getEnergy());
    }

    @Override
    public void attack(Skill skill) {
        int efficiency = random.nextInt(skill.getMaxEfficiency() - skill.getMinEfficiency() + 1) + skill.getMinEfficiency();

        getFightManager().dealDmg(efficiency);
        System.out.println("Player Attacked for " + efficiency);
    }

    @Override
    public void heal(Skill skill) {
        int efficiency = random.nextInt(skill.getMaxEfficiency() - skill.getMinEfficiency() + 1) + skill.getMinEfficiency();

        if (getCurrentHealth() + efficiency < getPlayer().getHealth()) {
            setCurrentHealth(getCurrentHealth() + efficiency);
        } else {
            setCurrentHealth(getPlayer().getHealth());
        }
        System.out.println("Player Healed for " + efficiency);
    }

    @Override
    public void buff(Skill skill) {
        int efficiency = random.nextInt(skill.getMaxEfficiency() - skill.getMinEfficiency() + 1) + skill.getMinEfficiency();

        System.out.println("Player rested (restored " + regen(efficiency) + " energy)");
    }

    @Override
    public boolean makeMove(Skill skill) {
        try {
            if (Validators.haveEnergyToMakeThatMove(skill.getEnergyCost(), getCurrentEnergy())) {
                useSkill(skill);
                setCurrentEnergy(getCurrentEnergy() - skill.getEnergyCost());
                return true;
            }
        } catch (NoEnergyException e) {
            GamePanel.printNoEnergyAlert(e.toString());
        }

        return false;
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
    public int regen(int efficiency) {
        if(getCurrentEnergy() + efficiency > getPlayer().getEnergy()) {
            int restored = getPlayer().getEnergy() - getCurrentEnergy();
            setCurrentEnergy(getPlayer().getEnergy());
            return restored;
        } else {
            setCurrentEnergy(getCurrentEnergy() + efficiency);
            return efficiency;
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

    public Animal getPlayer() {
        return player;
    }

    public void setPlayer(Animal player) {
        this.player = player;
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
