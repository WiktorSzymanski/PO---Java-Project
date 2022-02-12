package pl.vik.gm.animals;


import javax.swing.*;
import java.io.Serializable;
import java.util.HashMap;

public abstract class Animal implements Serializable {
    public String name;
    public Integer health;
    public Integer energy;
    public HashMap<Integer, Skill> skills;
    public ImageIcon image;

    Animal(){}
}
