package pl.vik.gm;

import pl.vik.gm.levels.BesideGrass;
import pl.vik.gm.levels.FieldsAndWoods;
import pl.vik.gm.levels.Level;

import java.io.Serializable;
import java.util.HashMap;

public class GameData {

    private static GameData gameData;

    public Data data = new Data();

    public int highestLevelCompleted = 0;

    private GameData() {
        this.data.levels = levels();
        this.data.achievements = achievements();
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

    private HashMap<String,Boolean> achievements() {
        HashMap<String, Boolean> achievements = new HashMap<>();

        for(Integer i : data.levels.keySet()) {
            for(Integer j : data.levels.get(i).possibleEnemies.keySet()) {
                String achievementName = data.levels.get(i).possibleEnemies.get(j).name;
                achievements.put(achievementName, false);
            }
        }

        return achievements;
    }

    public void achievementCheck(String name) {
        this.data.achievements.replace(name,true);
    }
}

