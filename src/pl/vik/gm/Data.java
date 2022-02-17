package pl.vik.gm;

import pl.vik.gm.levels.Level;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Data implements Serializable {
    public int highestLevelCompleted;
    public HashMap<Integer, Level> levels = null;
    public ArrayList<Achievement> achievements = null;
}
