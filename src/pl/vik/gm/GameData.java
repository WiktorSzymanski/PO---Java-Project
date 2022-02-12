package pl.vik.gm;

import pl.vik.gm.levels.BesideGrass;
import pl.vik.gm.levels.FieldsAndWoods;
import pl.vik.gm.levels.Level;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class GameData {

    private static GameData gameData;

    public Data data = new Data();



    private GameData() {
        this.data.levels = levels();
        this.data.achievements = achievements();
        this.data.highestLevelCompleted = 0;
    }

    public static GameData getInstance() {
        if (gameData == null) {
            gameData = new GameData();
        }

        return gameData;
    }

    public void setData(Data newData) {
        if (gameData == null) {
            gameData = new GameData();
        }
        data = newData;
    }

    private HashMap<Integer,Level> levels() {
        HashMap<Integer,Level> levels = new HashMap<>();

        levels.put(1, new BesideGrass());
        levels.put(2, new FieldsAndWoods());

        return levels;
    }

    private ArrayList<Achievement> achievements() {
        ArrayList<Achievement> achievements = new ArrayList<>();

        for(Integer i : data.levels.keySet()) {
            for(Integer j : data.levels.get(i).possibleEnemies.keySet()) {
                String animalName = data.levels.get(i).possibleEnemies.get(j).name;
                achievements.add(new Achievement("Defeat " + animalName, data.levels.get(i).possibleEnemies.get(j).image, animalName));
            }
        }

        return achievements;
    }

    public void achievementCheck(String enemyName) {
        for (Achievement achievement : data.achievements) {
            if (achievement.defToGet == enemyName) {
                System.out.println(achievement.name + " should be completed now");
                achievement.completed = true;
            }
        }
    }
}

