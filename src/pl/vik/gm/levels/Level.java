package pl.vik.gm.levels;

import pl.vik.gm.animals.Animal;

import java.util.HashMap;

public abstract class Level {
    public String name;
    public HashMap<Integer, Animal> playableAnimals;
    public HashMap<Integer,Animal> possibleEnemies;
    public String bg;
    public String planes;

    Level(){}

}
