package pl.vik.gm.save_load;


import pl.vik.gm.GameData;


import java.io.*;


public class SaveGame {
    static String filePatch = "saves/";
    static ObjectOutputStream outputStream = null;

    static GameData gameData = GameData.getInstance();

    public static void saveGame(String fileName){
//        filePatch += getFileName();
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

//    private String getFileName(){
//        String fileName;
//
//        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
//
//        try {
//            fileName = Validators.getFileNameFromKeyboard(input.readLine());
//        } catch (IOException | EmptyLabelException | NoSpacesInNameAllowed e) {
//            System.out.println(e.toString());
//            fileName = getFileName();
//        }
//        return fileName;
//    }
}


