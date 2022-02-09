package pl.vik.GM;


import java.util.HashMap;

public class FieldsAndWoods extends Level{
    FieldsAndWoods() {
        super();
        this.name = "Fields And Woods";
        this.bg = "light blue";
        this.planes = "light green";
        this.playableAnimals = playableAnimals();
        this.possibleEnemies = possibleEnemies();
    }

    private HashMap<Integer, Animal> playableAnimals() {
        HashMap<Integer, Animal> map = new HashMap<>();
        map.put(1, new Bull());
        map.put(2, new Wolf());
        map.put(3, new Bison());

        return map;
    }

    private HashMap<Integer, Animal> possibleEnemies() {
        HashMap<Integer, Animal> map = new HashMap<>();
        map.put(1, new Bull());
        map.put(2, new Wolf());
        map.put(3, new Bison());

        return map;
    }
}

