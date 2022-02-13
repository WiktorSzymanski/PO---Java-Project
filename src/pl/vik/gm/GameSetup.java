package pl.vik.gm;

import pl.vik.gm.animals.Animal;
import pl.vik.gm.animals.Skill;
import pl.vik.gm.levels.Level;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Random;

public class GameSetup {

    public Level currentLevel;
    public int currentLevelId;
    public Animal currentAnimalPlayer;
    public Animal currentAnimalEnemy;


    private HashMap<Integer,Level> allLevels;
    private GameData gameData;

    public GameSetup() {
        gameData = GameData.getInstance();
        allLevels = gameData.getData().getLevels();

        while (true) {
            currentLevel = levelPick();

            currentAnimalPlayer = animalPick(currentLevel);
            currentAnimalEnemy = randomPick(currentLevel);
        }
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
        Random random = new Random();

        int randomNum = random.nextInt(level.getPossibleEnemies().size()) + 1;

        return level.getPossibleEnemies().get(randomNum);
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

        pickedAnimal = level.getPlayableAnimals().get(action);

        return  pickedAnimal;
    }

    private void printLevels() {

        for (Integer i : allLevels.keySet()) {
            System.out.println(i + ". " + allLevels.get(i).getName());
            if (i > gameData.getData().getHighestLevelCompleted()) {
                break;
            }
        }
    }

    private void printPlayableLevelAnimals(Level level) {
        for (Integer i : level.getPlayableAnimals().keySet()) {
            System.out.print(i + ". ");
            printAnimal(level.getPlayableAnimals().get(i));
        }
    }

    private void printAnimal(Animal animal) {
        System.out.println("Name: " + animal.getName());
//        System.out.println("Animal health: " + animal.health);
//        System.out.println("Animal energy: " + animal.energy);
//        System.out.println("Animal img source: " + animal.imgSource);
//
//        System.out.println("Skills: ");
//        for (Skill skill : animal.skills) { printSkill(skill); }
    }

}
