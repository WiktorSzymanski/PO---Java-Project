package pl.vik.gm;

import javax.swing.*;
import java.io.Serializable;

public class Achievement implements Serializable {
    public final String name;
    public final ImageIcon image;
    public final String defToGet;
    public boolean completed = false;

    Achievement(String name, ImageIcon image, String defToGet) {
        this.name = name;
        this.image = image;
        this.defToGet = defToGet;
    }
}
