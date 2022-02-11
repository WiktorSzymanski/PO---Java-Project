package pl.vik.gm.save_load;

import pl.vik.gm.Data;
import pl.vik.gm.GameData;

import java.beans.beancontext.BeanContextChild;
import java.io.*;
import java.util.Calendar;
import java.util.HashMap;

public class LoadGame {
    ObjectInputStream inputStream = null;

    GameData gameData = GameData.getInstance();

    public LoadGame() throws IOException, ClassNotFoundException {
        String fileName = selectFile(getFilesMap());

        load(fileName);
    }

    private void load(String fileName) throws IOException, ClassNotFoundException {
        String filePatch = "saves/" + fileName;

        try {
            inputStream = new ObjectInputStream(new FileInputStream(filePatch));
            gameData.setData((Data) inputStream.readObject());
        } finally {
            if(inputStream != null) {
                inputStream.close();
                System.out.println("Game Loaded");
            }
        }
    }

    private void printMap(HashMap<Integer,String> filesNames) {
        for (Integer i : filesNames.keySet()) {
            System.out.println(i + ". " + filesNames.get(i));
        }
    }

    private String selectFile(HashMap<Integer,String> filesNames) {
        printMap(filesNames);

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int action = 0;
        try {
            action = Integer.parseInt(input.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return filesNames.get(action);
    }

    private HashMap<Integer, String> getFilesMap() {
        File folder = new File("saves");
        File[] listOfFiles = folder.listFiles();

        HashMap<Integer,String> filesNames = new HashMap<>();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                filesNames.put(i+1,listOfFiles[i].getName());
            }
        }

        return filesNames;
    }
}
