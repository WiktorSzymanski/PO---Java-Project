package pl.vik.gm;

import pl.vik.gm.levels.Level;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Data implements Serializable {
    private int highestLevelCompleted;
    private HashMap<Integer, Level> levels = null;
    private ArrayList<Achievement> achievements = null;

    public int getHighestLevelCompleted() {
        return highestLevelCompleted;
    }

    public void setHighestLevelCompleted(int highestLevelCompleted) {
        this.highestLevelCompleted = highestLevelCompleted;
    }

    public HashMap<Integer, Level> getLevels() {
        return levels;
    }

    public void setLevels(HashMap<Integer, Level> levels) {
        this.levels = levels;
    }

    public ArrayList<Achievement> getAchievements() {
        return achievements;
    }

    public void setAchievements(ArrayList<Achievement> achievements) {
        this.achievements = achievements;
    }
}
