package pl.vik.gm.save_load;

import pl.vik.gm.GameData;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class SaveGame {
    String filePatch = "saves/file.txt";
    DataOutputStream outputStream = null;

    GameData gameData = GameData.getInstance();

    public SaveGame() throws IOException {
        try {
            outputStream = new DataOutputStream(new FileOutputStream(filePatch));
            outputStream.writeInt(gameData.highestLevelComplited);
        } finally {
            if(outputStream != null) {
                outputStream.close();
            }
        }

        System.out.println("Game Saved");
    }
}
