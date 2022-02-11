package pl.vik;

import pl.vik.gm.Achievements;
import pl.vik.gm.GameSetup;
import pl.vik.gm.save_load.SaveGame;
import pl.vik.gm.save_load.LoadGame;
import pl.vik.ui.MainFrame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //new MainFrame();

        while (true) {


            switch (action()) {
                case 1:
                    new GameSetup();
                    break;
                case 2:
                    new SaveGame();
                    break;
                case 3:
                    new LoadGame();
                    break;
                case 4:
                    new Achievements();

                    break;
                case 5:
                    return;
            }
        }

    }

    public static int action() {
        System.out.println("What you want to do?\n1. Play game\n2. Save\n3. Load\n4. Achievements\n5. Exit");


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
