package pl.vik.GM;

import java.util.ArrayList;

public class Level {
    String name;
    ArrayList<Animal> playableAnimals;
    ArrayList<Animal> possibleEnemies;
    String bg;
    String planes;


    Level(String name,ArrayList<Animal> playableAnimals, ArrayList<Animal> possibleEnemies, String bg, String planes) {
        this.name = name;
        this.playableAnimals = playableAnimals;
        this.possibleEnemies = possibleEnemies;
        this.bg = bg;
        this.planes = planes;
    }

}
