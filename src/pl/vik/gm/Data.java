package pl.vik.gm;

import pl.vik.gm.levels.Level;

import java.io.Serializable;
import java.util.HashMap;

public class Data implements Serializable {
    public HashMap<Integer, Level> levels = null;
    public HashMap<String, Boolean> achievements = null;
}
