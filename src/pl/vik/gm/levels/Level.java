package pl.vik.gm.levels;

import pl.vik.gm.animals.Animal;

import java.io.Serializable;
import java.util.HashMap;
import java.awt.*;

public abstract class Level implements Serializable {
    public String name;
    public HashMap<Integer, Animal> playableAnimals;
    public HashMap<Integer,Animal> possibleEnemies;
    public Image bg;
    public Color planes;

    Level(){}

}
