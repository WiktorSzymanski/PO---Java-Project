package pl.vik.GM;


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
        int idx = 1;
        for ( Skill skill : player.skills) {
            System.out.println(idx + ". " + skill.name + " (" + skill.minEfficiency + "-" + skill.maxEfficiency + " " + skill.type + ")");
            idx += 1;
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
        System.out.println("Player Healed for " + efficiency);
    }

    @Override
    public void buff(Skill skill) {
        System.out.println("Player used Buff and did nothing");
    }

    @Override
    public void makeMove() {
        printActionList();
        System.out.println("Pick a skill you want to use: ");
        int skillNumber = 0;
        try {
            skillNumber = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        useSkill(player.skills.get(skillNumber-1));
    }

    public void useSkill(Skill skill) {
        switch (skill.type) {
            case ATTACK -> attack(skill);
            case HEAL -> heal(skill);
            case BUFF -> buff(skill);
        }
    }
}
