package pl.vik.gm.save_load;


import pl.vik.gm.GameData;


import java.io.*;


public class SaveGame {
    String filePatch = "saves/";
    ObjectOutputStream outputStream = null;

    GameData gameData = GameData.getInstance();

    public SaveGame() throws IOException {
        filePatch += getFileName();

        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(filePatch));
            outputStream.writeObject(gameData.data);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(outputStream != null) {
                outputStream.close();
            }
        }

        System.out.println("Game Saved");
    }

    private String getFileName(){
        String fileName;

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        try {
            fileName = Validators.getFileNameFromKeyboard(input.readLine());
        } catch (IOException | EmptyLabelException | NoSpacesInNameAllowed e) {
            System.out.println(e.toString());
            fileName = getFileName();
        }
        return fileName;
    }
}


