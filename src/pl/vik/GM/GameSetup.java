package pl.vik.GM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class GameSetup {

    public Level currentLevel = null;
    public Animal currentAnimalPlayer = null;
    public Animal currentAnimalEnemy = null;

    public GameSetup() {
        currentLevel = levelPick();


        currentAnimalPlayer = animalPick(currentLevel);
        currentAnimalEnemy = randomPick(currentLevel);
        printAnimal(currentAnimalPlayer);
        printAnimal(currentAnimalEnemy);
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

        pickedLevel = GameData.Levels().get(action - 1);

        return pickedLevel;
    }

    private Animal randomPick(Level level) {
        Animal randomEnemy = null;
        Random random = new Random();

        int randomNum = random.nextInt(3);

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

        pickedAnimal = level.playableAnimals.get(action - 1);

        return  pickedAnimal;
    }

    private void printLevels() {
        int index = 1;
        for (Level lv : GameData.Levels()) {
            System.out.println(index + ". " + lv.name);
            index += 1;
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
        int index = 1;
        System.out.println(level.playableAnimals);
        for (Animal animal : level.playableAnimals) {
            System.out.print(index + ". ");
            printAnimal(animal);
            index += 1;
        }
    }

    private void printEnemyLevelAnimals(Level level) {
        for (Animal animal : level.possibleEnemies) { printAnimal(animal); }
    }

    private void printAnimal(Animal animal) {
        System.out.println("Animal name: " + animal.name);
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
