package pl.vik.gm.levels;

import pl.vik.gm.animals.Animal;

import java.awt.*;
import java.io.Serializable;
import java.util.HashMap;

public abstract class Level implements Serializable {
    private String name;
    private HashMap<Integer, Animal> playableAnimals;
    private HashMap<Integer,Animal> possibleEnemies;

    Level(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<Integer, Animal> getPlayableAnimals() {
        return playableAnimals;
    }

    public void setPlayableAnimals(HashMap<Integer, Animal> playableAnimals) {
        this.playableAnimals = playableAnimals;
    }

    public HashMap<Integer, Animal> getPossibleEnemies() {
        return possibleEnemies;
    }

    public void setPossibleEnemies(HashMap<Integer, Animal> possibleEnemies) {
        this.possibleEnemies = possibleEnemies;
    }

}
