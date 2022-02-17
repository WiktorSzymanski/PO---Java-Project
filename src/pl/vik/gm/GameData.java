package pl.vik.gm;

import pl.vik.gm.levels.BesideGrass;
import pl.vik.gm.levels.FieldsAndWoods;
import pl.vik.gm.levels.Level;

import java.util.ArrayList;
import java.util.HashMap;

public class GameData {

    private static GameData gameData;

    private Data data = new Data();



    private GameData() {
        this.getData().levels = levels();
        this.getData().achievements = achievements();
        this.getData().highestLevelCompleted = 0;
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

        for(Integer i : getData().levels.keySet()) {
            for(Integer j : getData().levels.get(i).getPossibleEnemies().keySet()) {
                String animalName = getData().levels.get(i).getPossibleEnemies().get(j).getName();
                achievements.add(new Achievement("Defeat " + animalName, getData().levels.get(i).getPossibleEnemies().get(j).getImage(), animalName));
            }
        }

        return achievements;
    }

    public void achievementCheck(String enemyName) {
        for (Achievement achievement : getData().achievements) {
            if (achievement.getDefToGet() == enemyName) {
                System.out.println(achievement.getName() + " should be completed now");
                achievement.setCompleted(true);
            }
        }
    }

    public Data getData() {
        return data;
    }
}

