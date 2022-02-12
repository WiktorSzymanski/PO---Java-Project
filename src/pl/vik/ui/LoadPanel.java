package pl.vik.ui;

import pl.vik.gm.save_load.LoadGame;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class LoadPanel extends JPanel {
    private final MainFrame mainFrame;

    LoadPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        GridLayout gridLayout = new GridLayout(0,1);
        gridLayout.setVgap(10);
        gridLayout.setHgap(10);
        this.setLayout(gridLayout);

    }

    public void render() {
        printAllSavesButtons();
        add(new JLabel());
        add(createMainMenuButton());
    }

    private JButton createMainMenuButton() {
        JButton mainMenuButton = new JButton("Main Menu");
        mainMenuButton.addActionListener(e -> {
            removeAll();
            mainFrame.openPanel(View.MAIN_MENU);
        });
        return mainMenuButton;
    }

    private void printAllSavesButtons() {
        HashMap<Integer,String> filesNames = LoadGame.getFilesMap();
        for (Integer i : filesNames.keySet()) {
            add(createLoadButton(filesNames.get(i)));
        }

        if (filesNames.isEmpty()) {
            add(new Label("There are no saves to load :<"));
        }
    }

    private JButton createLoadButton(String name) {
        JButton loadButton = new JButton(name);
        loadButton.addActionListener(e -> {
            LoadGame.load(name);
            removeAll();
            mainFrame.openPanel(View.MAIN_MENU);
        });

        return loadButton;
    }
}
