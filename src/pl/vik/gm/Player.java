package pl.vik.gm;


import pl.vik.gm.animals.Animal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Player implements Actions{

    private Animal player = null;
    private FightManeger fightManeger = null;

    public Integer currentHealth;
    public Integer currentEnergy;

    Random random = new Random();
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    Player(FightManeger fightManeger) {
        this.fightManeger = fightManeger;
        this.player = fightManeger.playerAnimal;
        this.currentHealth = this.player.health;
        this.currentEnergy = this.player.energy;
    }

    public void printActionList() {
        for ( Integer i : player.skills.keySet()) {
            System.out.println(i + ". " + player.skills.get(i).name + " (" + player.skills.get(i).minEfficiency + "-" + player.skills.get(i).maxEfficiency + " " + player.skills.get(i).type + ") energy Cost: " + player.skills.get(i).energyCost);
        }
    }

    @Override
    public void attack(Skill skill) {
        int efficiency = random.nextInt(skill.maxEfficiency - skill.minEfficiency + 1) + skill.minEfficiency;

        fightManeger.dealDmg(efficiency);
        System.out.println("Player Attacked for " + efficiency);
    }

    @Override
    public void heal(Skill skill) {
        int efficiency = random.nextInt(skill.maxEfficiency - skill.minEfficiency + 1) + skill.minEfficiency;

        if (currentHealth + efficiency < player.health) {
            currentHealth += efficiency;
        } else {
            currentHealth = player.health;
        }
        System.out.println("Player Healed for " + efficiency);
    }

    @Override
    public void buff(Skill skill) {
        int efficiency = random.nextInt(skill.maxEfficiency - skill.minEfficiency + 1) + skill.minEfficiency;

        System.out.println("Player rested (restored " + regen(efficiency) + " energy)");
    }

    @Override
    public void makeMove() {
        int skillNumber = 0;
        Skill skillToUse = null;

        while (true) {
            printActionList();
            System.out.println("Pick a skill you want to use: ");
            try {
                skillNumber = Integer.parseInt(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }

            skillToUse = player.skills.get(skillNumber);

            if (haveEnergyToMakeThatMove(skillToUse)) {
                break;
            } else {
                System.out.println("You don't have enough energy to perform this action");
            }
        }

        useSkill(skillToUse);
        currentEnergy -= skillToUse.energyCost;
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
        if(currentEnergy + efficiency > player.energy) {
            int restored = player.energy-currentEnergy;
            currentEnergy = player.energy;
            return restored;
        } else {
            currentEnergy += efficiency;
            return efficiency;
        }
    }

    @Override
    public void afterRoundRegen() {
        regen(3);
    }

    @Override
    public boolean haveEnergyToMakeThatMove(Skill skill) {
        if (currentEnergy >= skill.energyCost) {
            return true;
        }
        return false;
    }
}
