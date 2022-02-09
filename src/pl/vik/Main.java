package pl.vik;

import pl.vik.gm.GameSetup;
import pl.vik.gm.save_load.SaveGame;
import pl.vik.gm.save_load.LoadGame;
import pl.vik.ui.MainFrame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        while (true) {


            switch (action()) {
                case 1:
                    new GameSetup();
                    break;
                case 2:
                    new MainFrame();
                    break;
                case 3:
                    new SaveGame();
                    break;
                case 4:
                    new LoadGame();
                    break;
                case 5:
                    return;
            }
        }

    }

    public static int action() {
        System.out.println("What you want to do?\n1. Play game\n2. Open Mainframe\n3. Save\n4. Load\n5. Exit");


        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int action = 0;
        try {
            action = Integer.parseInt(input.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return action;
    }
}
