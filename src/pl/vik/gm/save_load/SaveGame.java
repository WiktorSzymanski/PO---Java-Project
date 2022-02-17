package pl.vik.gm.save_load;


import pl.vik.gm.GameData;


import java.io.*;


public class SaveGame {
    static ObjectOutputStream outputStream = null;

    static GameData gameData = GameData.getInstance();

    public static void saveGame(String fileName){
        String filePatch = "saves/";
        filePatch += fileName;

        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(filePatch));
            outputStream.writeObject(gameData.getData());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("Game Saved");
    }
}


