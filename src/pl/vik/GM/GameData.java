package pl.vik.GM;

import java.util.ArrayList;
import java.util.List;

public class GameData {

    private static ArrayList<Skill> skills = new ArrayList<>();
    private static ArrayList<Level> levels = new ArrayList<>();


    private static ArrayList<Animal> playableAnimalsLv1 = new ArrayList<>();
    private static ArrayList<Animal> possibleEnemiesLv1 = new ArrayList<>();

    private static ArrayList<Animal> playableAnimalsLv2 = new ArrayList<>();
    private static ArrayList<Animal> possibleEnemiesLv2 = new ArrayList<>();

    private static ArrayList<Animal> playableAnimalsLv3 = new ArrayList<>();
    private static ArrayList<Animal> possibleEnemiesLv3 = new ArrayList<>();


    public static ArrayList<Level> Levels() {
        skills.add(new Skill("SkillName1", Skill.skillType.ATTACK, 10, 5));
        skills.add(new Skill("SkillName1", Skill.skillType.HEAL,10,5));

        playableAnimalsLv1.add(new Animal("PlayAnimal1",10,10, skills, "img.png"));
        playableAnimalsLv1.add(new Animal("PlayAnimal2",15,15, skills, "img.png"));
        playableAnimalsLv1.add(new Animal("PlayAnimal3",20,20, skills, "img.png"));

        possibleEnemiesLv1.add(new Animal("EnemyAnimal1",10,10, skills, "img.png"));
        possibleEnemiesLv1.add(new Animal("EnemyAnimal2",15,15, skills, "img.png"));
        possibleEnemiesLv1.add(new Animal("EnemyAnimal3",20,20, skills, "img.png"));


        playableAnimalsLv2.add(new Animal("PlayAnimal1",10,10, skills, "img.png"));
        playableAnimalsLv2.add(new Animal("PlayAnimal2",15,15, skills, "img.png"));
        playableAnimalsLv2.add(new Animal("PlayAnimal3",20,20, skills, "img.png"));

        possibleEnemiesLv2.add(new Animal("EnemyAnimal1",10,10, skills, "img.png"));
        possibleEnemiesLv2.add(new Animal("EnemyAnimal2",15,15, skills, "img.png"));
        possibleEnemiesLv2.add(new Animal("EnemyAnimal3",20,20, skills, "img.png"));


        playableAnimalsLv3.add(new Animal("PlayAnimal1",10,10, skills, "img.png"));
        playableAnimalsLv3.add(new Animal("PlayAnimal2",15,15, skills, "img.png"));
        playableAnimalsLv3.add(new Animal("PlayAnimal3",20,20, skills, "img.png"));

        possibleEnemiesLv3.add(new Animal("EnemyAnimal1",10,10, skills, "img.png"));
        possibleEnemiesLv3.add(new Animal("EnemyAnimal2",15,15, skills, "img.png"));
        possibleEnemiesLv3.add(new Animal("EnemyAnimal3",20,20, skills, "img.png"));


        levels.add(new Level("Beside Grass", playableAnimalsLv1, possibleEnemiesLv1, "grass.png", "brownPlanes"));
        levels.add(new Level("Taiga", playableAnimalsLv2, possibleEnemiesLv2, "white_trees.png", "whitePlanes"));
        levels.add(new Level("Sawanna", playableAnimalsLv3, possibleEnemiesLv3, "desert.png", "yellowPlanes"));


        return levels;
    }
}
