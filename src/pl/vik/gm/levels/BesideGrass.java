package pl.vik.gm.levels;

import pl.vik.gm.animals.Animal;
import pl.vik.gm.animals.Ant;
import pl.vik.gm.animals.Beetle;
import pl.vik.gm.animals.Mantis;

import java.util.HashMap;

public class BesideGrass extends Level{
    public BesideGrass() {
        super();
        this.name = "Beside Grass";
        this.bg = "Green";
        this.planes = "Brown";
        this.playableAnimals = playableAnimals();
        this.possibleEnemies = possibleEnemies();
    }

    private HashMap<Integer, Animal> playableAnimals() {
        HashMap<Integer, Animal> map = new HashMap<>();
        map.put(1, new Ant());
        map.put(2, new Mantis());
        map.put(3, new Beetle());

        return map;
    }

    private HashMap<Integer, Animal> possibleEnemies() {
        HashMap<Integer, Animal> map = new HashMap<>();
        map.put(1, new Ant());
        map.put(2, new Mantis());
        map.put(3, new Beetle());

        return map;
    }
}
