package pl.vik.gm.levels;


import pl.vik.gm.animals.Animal;
import pl.vik.gm.animals.Bison;
import pl.vik.gm.animals.Bull;
import pl.vik.gm.animals.Wolf;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class FieldsAndWoods extends Level{
    public FieldsAndWoods() {
        super();
        this.name = "Fields And Woods";
        this.bg = new ImageIcon("img/field.png").getImage();
        this.planes = new Color(53, 102, 49);
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

