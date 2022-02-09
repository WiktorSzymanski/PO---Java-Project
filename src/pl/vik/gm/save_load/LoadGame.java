package pl.vik.gm.save_load;

import pl.vik.gm.GameData;

import java.io.*;

public class LoadGame {
    String filePatch = "saves/file.txt";
    DataInputStream inputStream = null;

    GameData gameData = GameData.getInstance();

    public LoadGame() throws IOException {
        try {
            inputStream = new DataInputStream(new FileInputStream(filePatch));
            gameData.highestLevelComplited = inputStream.readInt();
        } finally {
            if(inputStream != null) {
                inputStream.close();
            }
        }

        System.out.println("Game Loaded");
    }
}
