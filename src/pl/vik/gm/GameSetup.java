package pl.vik.gm;

import pl.vik.gm.animals.Animal;
import pl.vik.gm.animals.Skill;
import pl.vik.gm.fight_maneger.FightManeger;
import pl.vik.gm.levels.Level;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Random;

public class GameSetup {

    public Level currentLevel = null;
    public int currentLevelId = 0;
    public Animal currentAnimalPlayer = null;
    public Animal currentAnimalEnemy = null;

    // TODO: Clean this
    //       Zwracanie jednego pozoimu nie wszystkich


    private HashMap<Integer,Level> allLevels = null;
    private GameData gameData = null;

    public GameSetup() {
        gameData = GameData.getInstance();
        allLevels = gameData.data.levels;

        while (true) {
            currentLevel = levelPick();

            currentAnimalPlayer = animalPick(currentLevel);
            currentAnimalEnemy = randomPick(currentLevel);

//        printAnimal(currentAnimalPlayer);
//        printAnimal(currentAnimalEnemy);

            boolean passedLevel = FightManeger.returnFightResult(currentAnimalPlayer, currentAnimalEnemy);

            if (passedLevel) {
                gameData.highestLevelCompleted = currentLevelId;
                gameData.achievementCheck(currentAnimalEnemy.name);
            }

            if (ifBack()) {
                break;
            }
        }
    }

    private boolean ifBack() {
        System.out.println("0 - go back to menu, nothing to continue");

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int action = 0;
        try {
            action = Integer.parseInt(input.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return action == 0;
    }

    private Level levelPick() {
        Level pickedLevel = null;

        printLevels();
        System.out.println("Pick a level: ");

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int action = 0;
        try {
            action = Integer.parseInt(input.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        pickedLevel = allLevels.get(action);
        currentLevelId = action;

        return pickedLevel;
    }

    private Animal randomPick(Level level) {
        Animal randomEnemy = null;
        Random random = new Random();

        int randomNum = random.nextInt(level.possibleEnemies.size()) + 1;

        return level.possibleEnemies.get(randomNum);
    }

    private Animal animalPick(Level level) {
        Animal pickedAnimal = null;
        printPlayableLevelAnimals(level);
        System.out.println("Pick an Animal: ");

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int action = 0;
        try {
            action = Integer.parseInt(input.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        pickedAnimal = level.playableAnimals.get(action);

        return  pickedAnimal;
    }

    private void printLevels() {

        for (Integer i : allLevels.keySet()) {
            System.out.println(i + ". " + allLevels.get(i).name);
            if (i > gameData.highestLevelCompleted) {
                break;
            }
        }
    }

    private void printLevelDetails(Level level) {
        System.out.println("Level name: " + level.name);
        System.out.println("Level bg: " + level.bg);
        System.out.println("Level planes: " + level.planes);

        System.out.println("Possible Enemis: ");
        printEnemyLevelAnimals(level);

        System.out.println("Playable Animals: ");
        printPlayableLevelAnimals(level);
    }

    private void printPlayableLevelAnimals(Level level) {
        for (Integer i : level.playableAnimals.keySet()) {
            System.out.print(i + ". ");
            printAnimal(level.playableAnimals.get(i));
        }
    }

    private void printEnemyLevelAnimals(Level level) {
        for (Integer i : level.possibleEnemies.keySet()) { printAnimal(level.possibleEnemies.get(i)); }
    }

    private void printAnimal(Animal animal) {
        System.out.println("Name: " + animal.name);
//        System.out.println("Animal health: " + animal.health);
//        System.out.println("Animal energy: " + animal.energy);
//        System.out.println("Animal img source: " + animal.imgSource);
//
//        System.out.println("Skills: ");
//        for (Skill skill : animal.skills) { printSkill(skill); }
    }

    private void printSkill(Skill skill) {
        System.out.println("Skill name: " + skill.name);
        System.out.println("Skill type: " + skill.type);
        System.out.println("Skill max ef: " + skill.maxEfficiency);
        System.out.println("Skill min ef: " + skill.minEfficiency);
    }

}
