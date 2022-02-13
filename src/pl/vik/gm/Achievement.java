package pl.vik.gm;

import javax.swing.*;
import java.io.Serializable;

public class Achievement implements Serializable {
    private final String name;
    private final ImageIcon image;
    private final String defToGet;
    private boolean completed = false;

    Achievement(String name, ImageIcon image, String defToGet) {
        this.name = name;
        this.image = image;
        this.defToGet = defToGet;
    }

    public String getName() {
        return name;
    }

    public ImageIcon getImage() {
        return image;
    }

    public String getDefToGet() {
        return defToGet;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
