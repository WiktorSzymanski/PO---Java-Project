package pl.vik.gm.fight_manager;


import pl.vik.gm.exceptions.NoEnergyException;
import pl.vik.gm.exceptions.Validators;
import pl.vik.gm.animals.Skill;
import pl.vik.gm.animals.Animal;
import pl.vik.ui.GamePanel;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Player implements Actions{

    private Animal player = null;
    private FightManager fightManager = null;

    private Integer currentHealth;
    private Integer currentEnergy;

    Random random = new Random();
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    Player(FightManager fightManager) {
        this.fightManager = fightManager;
        this.player = fightManager.getPlayerAnimal();
        this.setCurrentHealth(this.player.getHealth());
        this.setCurrentEnergy(this.player.getEnergy());
    }

    public void printActionList() {
        for ( Integer i : player.getSkills().keySet()) {
            System.out.println(i + ". " + player.getSkills().get(i).name + " (" + player.getSkills().get(i).minEfficiency + "-" + player.getSkills().get(i).maxEfficiency + " " + player.getSkills().get(i).type + ") energy Cost: " + player.getSkills().get(i).energyCost);
        }
    }

    @Override
    public void attack(Skill skill) {
        int efficiency = random.nextInt(skill.maxEfficiency - skill.minEfficiency + 1) + skill.minEfficiency;

        fightManager.dealDmg(efficiency);
        System.out.println("Player Attacked for " + efficiency);
    }

    @Override
    public void heal(Skill skill) {
        int efficiency = random.nextInt(skill.maxEfficiency - skill.minEfficiency + 1) + skill.minEfficiency;

        if (getCurrentHealth() + efficiency < player.getHealth()) {
            setCurrentHealth(getCurrentHealth() + efficiency);
        } else {
            setCurrentHealth(player.getHealth());
        }
        System.out.println("Player Healed for " + efficiency);
    }

    @Override
    public void buff(Skill skill) {
        int efficiency = random.nextInt(skill.maxEfficiency - skill.minEfficiency + 1) + skill.minEfficiency;

        System.out.println("Player rested (restored " + regen(efficiency) + " energy)");
    }

    // For console test
//    @Override
//    public void makeMove() {
//        int skillNumber = 0;
//        Skill skillToUse = null;
//
//        while (true) {
//            printActionList();
//            System.out.println("Pick a skill you want to use: ");
//            try {
//                skillNumber = Integer.parseInt(reader.readLine());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            skillToUse = player.skills.get(skillNumber);
//
//            if (haveEnergyToMakeThatMove(skillToUse)) {
//                break;
//            } else {
//                System.out.println("You don't have enough energy to perform this action");
//            }
//        }
//
//        useSkill(skillToUse);
//        currentEnergy -= skillToUse.energyCost;
//    }

    @Override
    public boolean makeMove(Skill skill) {
        try {
            if (Validators.haveEnergyToMakeThatMove(skill.energyCost, getCurrentEnergy())) {
                useSkill(skill);
                setCurrentEnergy(getCurrentEnergy() - skill.energyCost);
                return true;
            }
        } catch (NoEnergyException e) {
            GamePanel.printNoEnergyAlert(e.toString());
        }

        return false;
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
    public int regen(int efficiency) {
        if(getCurrentEnergy() + efficiency > player.getEnergy()) {
            int restored = player.getEnergy() - getCurrentEnergy();
            setCurrentEnergy(player.getEnergy());
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
