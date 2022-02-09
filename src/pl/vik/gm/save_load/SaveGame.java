package pl.vik.gm.save_load;

import pl.vik.gm.GameData;

import java.io.*;


public class SaveGame {
    String filePatch = "saves/";
    DataOutputStream outputStream = null;

    GameData gameData = GameData.getInstance();

    public SaveGame() throws IOException {
        filePatch += getFileName();

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

    private String getFileName() {
        String fileName = null;

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        try {
            fileName = input.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileName;
    }
}


