package pl.vik.gm.levels;

import pl.vik.gm.animals.Animal;
import pl.vik.gm.animals.Ant;
import pl.vik.gm.animals.Beetle;
import pl.vik.gm.animals.Spider;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class BesideGrass extends Level{
    public BesideGrass() {
        super();
        this.setName("Beside Grass");
        this.setBg(new ImageIcon("img/grass.png").getImage());
        this.setPlanes(new Color(	170, 90, 29));
        this.setPlayableAnimals(playableAnimals());
        this.setPossibleEnemies(possibleEnemies());
    }

    private HashMap<Integer, Animal> playableAnimals() {
        HashMap<Integer, Animal> map = new HashMap<>();
        map.put(1, new Ant());
        map.put(2, new Spider());
        map.put(3, new Beetle());

        return map;
    }

    private HashMap<Integer, Animal> possibleEnemies() {
        HashMap<Integer, Animal> map = new HashMap<>();
        map.put(1, new Ant());
        map.put(2, new Spider());
        map.put(3, new Beetle());

        return map;
    }
}
