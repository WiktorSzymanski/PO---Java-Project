package pl.vik.gm;

import pl.vik.gm.levels.BesideGrass;
import pl.vik.gm.levels.FieldsAndWoods;
import pl.vik.gm.levels.Level;

import java.util.HashMap;

public class GameData {

    private static GameData gameData;

    public HashMap<Integer, Level> levels = null;

    private GameData() {
        this.levels = levels();
    }

    public static GameData getInstance() {
        if (gameData == null) {
            gameData = new GameData();
        }

        return gameData;
    }

    private HashMap<Integer,Level> levels() {
        HashMap<Integer,Level> levels = new HashMap<>();

        levels.put(1, new BesideGrass());
        levels.put(2, new FieldsAndWoods());

        return levels;
    }
}
