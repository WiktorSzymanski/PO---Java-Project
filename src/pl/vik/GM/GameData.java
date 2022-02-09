package pl.vik.GM;


import java.util.HashMap;


public class GameData {


    public static HashMap<Integer,Level> Levels() {
        HashMap<Integer,Level> levels = new HashMap<>();

        levels.put(1, new BesideGrass());

        return levels;
    }
}
